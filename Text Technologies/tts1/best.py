from __future__ import division
import re
import math
from numpy import *
from nltk.stem import PorterStemmer
from nltk.corpus import stopwords
import operator

def calculateSynonyms(nab,na,nb, n):
	result = nab * math.log(n * nab/(na*nb),10)
	return result


def tf(word,doc):
	number=0
	for w in doc:
		if word==w:
			number+=1
	return number
		
def tokenize(document):
	token=re.sub("[\_|\~|\=|\%|\`|\&|\"|\?|\!|\>|\<|\}|\{|\]|\[|\)|\;|\-|\,|]"," ",re.sub("[\||\$|\'|\:|\(|\.|\^|\+|\*|\/|]","",document))                  
	token = token.split()
	return token


def porter(lista):
	newlista=[]
	for z in lista:
		z=tokenize(z)
		z=porter_list1(z)
		something=" ".join(z)
		newlista.append(something)
	return newlista
			
	
def remove_stop(lista):
	newlista=[]
	for z in lista:	
		z=tokenize(z)
		filtered_words = [w for w in z if not w in stopwords.words('english')]
		something=" ".join(filtered_words)
		newlista.append(something)
	return newlista


def porter_list1(lista):   
	stemmer = PorterStemmer()
	newlist=[]
	for b in lista:
		b=stemmer.stem(b)
		newlist.append(b)
	return newlist
	
def tokenize_list(lista):
	newlista=[]
	position=0
	for z in lista:
		match = re.search(r"[^a-zA-Z](references:)[^a-zA-Z]", z)
		if(match!=None):
			position=match.start(1)
			z=z[:position]


		s=tokenize(z)
		
		something=" ".join(s)
		newlista.append(something)
	return newlista

def change_list(document):
	lista=[]
	lista=document.split()
	return lista 
		
def main():
	f1=open("docs.txt","r")
	docs=f1.read()
	docs=re.split("\n",docs)
	f2=open("qrys.txt","r")
	qrys=f2.read()
	qrys=re.split("\n",qrys)

	docs=[x.lower() for x in docs]
	qrys=[y.lower() for y in qrys]
	
	docs=remove_stop(docs)
	qrys=remove_stop(qrys)	
	docs=porter(docs)
	qrys=porter(qrys)

	docs=tokenize_list(docs)
	qrys=tokenize_list(qrys)


	C=len(docs)

	k=2	
	num=0
	average=0
	for z in docs:

		s=change_list(z)
		num =num +len(s[1:])
	average=num/C


	R=[]
	df={}
	for q in qrys:
		newq=change_list(q)
		for r in newq[1:]:
			R.append(r)
	R=list(set(R))


	for g in R:
		for d in docs:
			newdoc=change_list(d)
			if (g in newdoc[1:]) and len(g)>2:

				if g not in df:			
					df[g] =1
				else:
					df[g] += 1   


	newqueries=[]
	pseudo=[]				
	sumscore=0
	W=[]
	
	df2={}
	df1={}
	for q in qrys:
		score=0
		newq=change_list(q)
		for d in docs:
			newdoc=change_list(d)
			D=len(newdoc[1:])
			for w in newq[1:]:
				tfwq=tf(w,newq[1:])
				if (w in newdoc[1:] and len(w)>2 ):
					tfwd=tf(w,newdoc[1:])
					score=score+tfwq *(tfwd/(tfwd+(k*D)/average))*(math.log(C/(df[w]),10))

			if score!=0:
				
				data = [int(newq[0]),  int(newdoc[0]),score]
			

				pseudo.append(data)
				
			
			score=0



		pseudo.sort(key=lambda tup: tup[2],  reverse=True)	
		tempQ=' '
		
		metrites={}
		limit=0.0
		c=0
		for docum in pseudo[:4]:


			pos=docum[1]
			######print pos
			oroi= docs[pos-1][1:]

			oroi=change_list(oroi)
			limit=limit+ len(oroi)
			c+=1
			for x in oroi:
				if x not in metrites:			
						metrites[x] = 1
						
				else:
						metrites[x] += 1

			limit= limit/c 
			sorted_metrites = sorted(metrites.iteritems(), key=operator.itemgetter(1) , reverse=True)

			counteraki=0
			mpike={}

			for kati in sorted_metrites:
				if kati[0] not in mpike and len(kati[0])>2 and counteraki<limit/3 :
					
					mpike[kati[0]]=0
					if (kati[0] not in newq):
						tempQ= tempQ+' '+ kati[0]
						counteraki+=1

			metrites={}		

		pseudo=[]

	
		tempQ= change_list(tempQ)

		R1=list(set(tempQ))

		for g in R1:
			for d in docs:
				newdoc=change_list(d)
				if (g in newdoc[1:]) and len(g)>2 :
					
					if g not in df1:			
						df1[g] =1
						
					else:
						df1[g] += 1  
							
		tempLeksi=' '
		for leksi in tempQ:
			tempLeksi= tempLeksi+ ' '+leksi


		tempQ= q + ' ' + tempLeksi

		

		newqueries.append(tempQ)
	
		

	df.update(df1)

	qrys= newqueries

	#print qrys



	sumscore=0
	W=[]

	for q in qrys:
		score=0
		newq=change_list(q)
		for d in docs:
			newdoc=change_list(d)
			D=len(newdoc[1:])
			for w in newq[1:]:
				tfwq=tf(w,newq[1:])
				if (w in newdoc[1:] and len(w)>2 ):
					tfwd=tf(w,newdoc[1:])
					score=score+tfwq *(tfwd/(tfwd+(k*D)/average))*(math.log(C/(df[w]),10))

			if score!=0:
				W.append(newq[0]+ ' 0 ')
				W.append(newdoc[0]+ ' 0 ')
				W.append(str(score)+ ' 0 ')
				W.append('\n')
				
			
			score=0


	p=open("best.top","w")
	for n in W:
		p.write(n)
	p.close()
		
main()
