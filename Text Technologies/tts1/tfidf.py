from __future__ import division
import re
import math
import string


		
def tf(word,doc):
	number=0
	for n in doc:
		if n==word:
			number+=1
	return number


def tokenize(document):
	token=re.sub("[\_|\~|\=|\%|\`|\&|\"|\?|\!|\>|\<|\}|\{|\]|\[|\)|\;|\-|\,|]"," ",re.sub("[\||\$|\'|\:|\(|\.|\^|\+|\*|\/|]","",document))                 
	token = token.split()
	return token
	
def tokenize_list(lista):
	newlista=[]
	for z in lista:
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
			if g in d:
				if g not in df:			
					df[g] =1
				else:
					df[g] += 1  

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
				if w in newdoc[1:] :
					tfwd=tf(w,newdoc[1:])
					score1=tfwq
					score2=tfwd
					score3=(tfwd+(k*D/average))
					score4=math.log(C/df[w],10)
					score=score+score1*(score2/score3)*score4
			if score!=0:
				W.append(newq[0]+ ' 0 ')
				W.append(newdoc[0]+ ' 0 ')
				W.append(str(score)+ ' 0 ')
				W.append('\n')
			score=0

	p=open("tfidf.top","w")
	for n in W:
		p.write(n)
	p.close()
		
main()
