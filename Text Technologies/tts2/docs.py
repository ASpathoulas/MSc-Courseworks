import re
from heapq import *
import time
started = time.time()

def tokenize_string(document):
	token=re.sub("[\_|\~|\=|\%|\`|\&|\"|\?|\!|\>|\<|\}|\{|\]|\[|\)|\;|\-|\,|]"," ",re.sub("[\@|\#|\||\$|\'|\:|\(|\.|\^|\+|\*|\/|]"," ",document))                 
	token = token.split()
	return token
	
def tokenize_list(lista):
	newlista=[]
	for z in lista:
		s=tokenize_string(z)
		something=" ".join(s)
		newlista.append(something)
	return newlista
	
def makelist(document):
	lista=[]
	lista=document.split()
	return lista 

def ifequal(lista):
    return all(x[0] == lista[0][0] for x in lista)	
	
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
	# docs.reverse()
	L=[]
	dict={}
	
	for d in docs:
		newdoc=makelist(d)
		for word in set(newdoc[1:]):
			if word not in dict: 
				dict[word]=[newdoc[0]]
			else:
				dict[word].append(newdoc[0])
	# print("dict found..")
	# print(dict)
	numbers={}
	out=[]
	# for x in dict:
		# numbers[x]=0
	for q in qrys:
		newq=makelist(q)
		newq[1:]=set(newq[1:])
		h=[]
		out1=[]
		out.append(newq[0]+"  ")
		

		for word in newq[1:]:
			numbers[word]=0
			try:
				heappush(h, (int(dict[word][0]),word))
			except KeyError:break

		h=sorted(h)
		num=0
		
		while len(h)==len(newq[1:]):
			if ifequal(h)==True:
				out1.append(h[0][0])
			
			temp=h[0][1]
			heappop(h)[0]
			numbers[temp]+=1
			if numbers[temp]<len(dict[temp]):
				heappush(h, (int(dict[temp][numbers[temp]]),temp))
		out1.reverse()
		
		k=0
		for m in out1:
			if k<5:
				out.append(str(m)+" ")
				k+=1
		out.append("\n")
		
	# print(out)
		
		
	p=open("docs.top","w")
	for n in out:
		p.write(n)
	p.close()
		
main()
runtime=time.time() - started
print(runtime)
