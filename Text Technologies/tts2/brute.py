import re
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
	docs.reverse()
	L=[]
	M=[]
	for q in qrys:
		newq=makelist(q)
		L.append(newq[0] + "  ")
		num=0
		for d in docs:
			newdoc=makelist(d)
			counter=0
			for word in newq[1:]:
				if word in newdoc[1:]:
					counter+=1
			
			if counter==len(newq[1:]):
				if num<5:
					L.append(newdoc[0]+ "  ")
					num+=1

		L.append("\n")
		# print(L)	
	p=open("brute.top","w")
	for n in L:
		p.write(n)
	p.close()
			
main()
runtime=time.time() - started
print(runtime)
