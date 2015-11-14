import re

	

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
	f=open('docs.txt')
	f1=f.readlines()
	h=open('qrys.txt')
	h1=h.readlines()
	docs=[x.lower() for x in f1]
	qrys=[y.lower() for y in h1]

	docs=tokenize_list(docs)
	qrys=tokenize_list(qrys)
	L=[]
	for q in qrys:
		counter=0
		newq=change_list(q)

		for n in docs:
			newdoc=change_list(n)
			for m in newq[1:]:
				if m in newdoc[1:]:
					counter+=1
			if counter!=0:
				L.append(newq[0]+ " 0 ")
				L.append(newdoc[0]+ " 0 ")
				L.append(str(counter)+ " 0 ")
				L.append("\n")
			counter=0
	file=open("overlap.top","w")
	for row in L:
		file.write(row)
	file.close()


main()