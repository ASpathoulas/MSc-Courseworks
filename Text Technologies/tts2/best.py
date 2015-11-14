import re
from heapq import *
import time
import bisect
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
				dict[word]=[int(newdoc[0])]
			else:
				dict[word].append(int(newdoc[0]))
	# print("dict found..")
	# print(dict)

	out=[]
	for q in qrys:
		newq=makelist(q)
		newq[1:]=list(set(newq[1:]))
		h=[]
		out1=[]
		if len(newq[1:])!=0:
			out.append(newq[0]+"  ")
			for word in newq[1:]:
				try:
					heappush(h, dict[word])
				except KeyError:break
			h=sorted(h)
			num=0
			while len(h)==len(newq[1:]):
				max=0
				for i in range(0,len(h)):
					if int(h[i][0])>max:
						max=int(h[i][0])
				if ifequal(h)==True:
					out1.append(h[0][0])
					del h[0][0]
				for i in range(0,len(h)):
					h[i]=h[i][bisect.bisect_left(h[i],max):]
				for i in range(0,len(h)):
					if len(h[i])==0:
						del h[i]	
						break
			out1.reverse()
		k=0
		for m in out1:
			if k<5:
				out.append(str(m)+" ")
				k+=1
		out.append("\n")
		
		# print(out)
		
	p=open("best.top","w")
	for n in out:
		p.write(n)
	p.close()
		
main()
runtime=time.time() - started
print(runtime)
