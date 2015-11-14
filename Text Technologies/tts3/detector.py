#!/usr/bin/python
# -*- coding: utf-8 -*-
import re
import codecs
import zlib
import hashlib
from itertools import combinations
import os


def tokenize_string(document):
	token = re.compile(u'[⺀-⺙⺛-⻳⼀-⿕々〇〡-〩〸-〺〻㐀-䶵一-鿃豈-鶴侮-頻並-龎]', re.UNICODE)  
	# Reference : http://stackoverflow.com/questions/2718196/find-all-chinese-text-in-a-string-using-python-and-regex
	# The regular expression above used was taken from this link

	token1=token.findall(document)
	token1="".join(token1)
	return token1

def retrieve_content(document):  
	pattern = re.compile(">[^>]*<",re.UNICODE)
	# Reference : http://www.inf.ed.ac.uk/teaching/courses/tts/pdf/dup-2x2.pdf
	# The regular expression above used was taken from this link
	pattern1 = re.compile(u'[⺀-⺙⺛-⻳⼀-⿕々〇〡-〩〸-〺〻㐀-䶵一-鿃豈-鶴侮-頻並-龎]', re.UNICODE)  	
	token1=pattern.findall(document)
	maximum = max(token1, key=len) 	
	maximum = pattern1.findall(maximum)
	return maximum


###########################TYPE 1############################
#f=codecs.open("files.index","r",encoding = 'utf-8').read()
#files=[]
#files=f.split()
#adlerlist={}
#for link in files:
#	g=codecs.open(link,"r",encoding = 'utf-8')
#	file1=g.read()	
#	hash1 = int(hashlib.md5(file1.encode('utf-8')).hexdigest(),32)
#	if hash1 not in adlerlist:
#		adlerlist[hash1]=[(link)]
#	else:
#		adlerlist[hash1].append(link)
#for x in adlerlist:
#	if len(adlerlist[x])>1:
#		print(adlerlist[x])
##############################################################


f=codecs.open("files.index","r",encoding = 'utf-8').read()
files=[]
files=f.split()
characters={}
chars=[]
files11={}
htmlfiles=[]

for link in files:
	g=codecs.open(link,"r",encoding = 'utf-8')
	file1=g.read()
	files11[link]=file1
for link in files11:
	
	for char in files11[link]:
		chars.append(char)
	chars=list(set(chars))
	s="html"
	if s in file1:
		htmlfiles.append(link)	


for character in chars:
	list1=[]
	s = bin(int(hashlib.md5(character.encode('utf-8')).hexdigest(),16))[2:]
	if len(str(s)) < 128 :
		d=(128-len(str(s)))
		while d!=0:
			s = "0" + str(s)
			d-=1
	for number in s:
		list1.append(int(number))
	for number1 in list1:
		if number1==0:
			list1[list1.index(number1)]=-1
	characters[character]=list1

	
filehash={}

for link in files11:
	
	filehash[link]=[]
			
	for i in range(128):
		sum=0
		for char in files11[link]:
			
			sum +=characters[char][i]

		
		if sum>0:filehash[link].append("1")
		else:filehash[link].append("0")

last={}
final=[]
final1=[]
kati=[]
for key in filehash:
	kati="".join(filehash[key])
	if kati not in last:
		last[kati] = [os.path.basename(key)]
	else:
		last[kati].append(os.path.basename(key))	
for y in last:
	if len(last[y])>1:
		final.append([" ".join(map(str,comb)) for comb in combinations(last[y], 2)])

	


characters={}
chars=[]
L=[]
filehash={}


for file2 in htmlfiles:
	newfile1=retrieve_content(files11[file2])
	filehash[file2]=[]
	kati=[]		
	for i in range(128):
		sum=0
		for char in newfile1:#[1:-1]:
			sum +=characters[char][i]

		
		if sum>0:filehash[file2].append("1")
		else:filehash[file2].append("0")
last={}
for key in filehash:
	kati="".join(filehash[key])
	if kati not in last:
		last[kati] = [os.path.basename(key)]
	else:
		last[kati].append(os.path.basename(key))	
final1=[]
for y in last:
	if int(y)!=0:
		if len(last[y])>1:
			final1.append([" ".join(map(str,comb)) for comb in combinations(last[y], 2)])
				
output=[]
for res in final:
	for char in res:
		output.append(char)
		output.append("\n")
for res1 in final1:
	for char1 in res1:
		output.append(char1)
		output.append("\n")

p=open("result.dup","w")
for n in output:
	p.write(n)
p.close()

	
