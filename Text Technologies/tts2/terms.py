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
	
	M=[]
	for q in qrys:
		newq=makelist(q)
		kati=set()
		try:
			kati=kati.union(dict[newq[1]])
		except KeyError:break
		for i in range(1,len(newq[1:])):
			try:
				kati=kati.intersection(dict[newq[i+1]])
			except KeyError:break
		something=sorted(list(kati))
		something.reverse()
		M.append(newq[0]+"  ")
		# print(newq[0])
		for n in something[:5]:
			M.append(n+" ")
		M.append("\n")

		
			
			
	p=open("terms.top","w")
	for n in M:
		p.write(n)
	p.close()
			
main()
runtime=time.time() - started
print(runtime)
