from __future__ import division
import re
import math
import operator
import time
started = time.time()

def main():
	f = open("graph.txt")
	graph = f.readlines()
	
	
	outLinks={}
	inLinks={}
	nodes={}
	dictOfSets={}
	pointsAt={}
	neighbour={}
	hubs={}
	auth={}
	numberL = 0.8 
	
	for line in graph:
		links  = re.split("\s+",line)
		if links[1] != links[2]:
			if links[1] not in nodes: 
				nodes[links[1]] = 0
			if links[2] not in nodes: 
				nodes[links[2]] = 0
			
			if(links[1],links[2]) not in dictOfSets: 
				dictOfSets[(links[1],links[2])] = 1
			else: 
				dictOfSets[(links[1],links[2])] += 1
	
	for eachSet in dictOfSets:
		
		if eachSet[0] not in outLinks: 
			neighbour[eachSet[0]]=[]
			outLinks[eachSet[0]] = dictOfSets[eachSet]
			neighbour[eachSet[0]].append(eachSet[1])
		else:
			
			neighbour[eachSet[0]].append(eachSet[1])
			outLinks[eachSet[0]] += dictOfSets[eachSet]
		
		if eachSet[1] not in inLinks: 
			pointsAt[eachSet[1]]=[]	
			inLinks[eachSet[1]] = dictOfSets[eachSet]
			pointsAt[eachSet[1]].append(eachSet[0])
		else:
			inLinks[eachSet[1]] += dictOfSets[eachSet]
			pointsAt[eachSet[1]].append(eachSet[0])
	
	
	
	N=len(nodes)  
	sumOfSinks=0	
	pageRank={}
	for node in nodes:
		hubs[node]=1
		auth[node]=1
		pageRank[node]=1/N		
		if node not in outLinks:			
			sumOfSinks+=1
	
	for i in range(9):
		authSum=0
		hubsSum=0
		sumOfSinks=0
		
		PRnew=pageRank.copy()
		for node in nodes:
			if node not in outLinks:
				sumOfSinks += pageRank[node]

		
		for node in nodes:
			hubsTemp=0
			if node in neighbour:
				for neighb in neighbour[node]:
					hubsTemp+=dictOfSets[node,neighb]*auth[neighb]
				hubs[node]=hubsTemp 
			hubsSum += math.pow(hubs[node],2)		
		hubsSum=math.sqrt(hubsSum)	
		for node in hubs:
			hubs[node]=hubs[node]/hubsSum
		
		for node in nodes:
			authTemp = 0
			if node in pointsAt:
				for point in pointsAt[node]:
					authTemp += dictOfSets[(point,node)]*hubs[point]
				auth[node]=authTemp
			authSum += math.pow(auth[node],2) 
		authSum = math.sqrt(authSum)	
		for node in auth:
			auth[node] = auth[node]/authSum	
			
	for i in range(10):	
		sumOfSinks=0
		
		PRnew=pageRank.copy()
		for node in nodes:
			if node not in outLinks:
				sumOfSinks += pageRank[node]
		for node in nodes:
			if node in pointsAt:
				pointSum=0
				for point in pointsAt[node]:
					pointSum = pointSum + PRnew[point]*dictOfSets[(point,node)]/outLinks[point]
				pageRank[node]=(1-numberL + numberL*sumOfSinks)/N + numberL*pointSum
			else:
				pageRank[node]=(1-numberL + numberL*sumOfSinks)/N

			
			
	auth_sorted = sorted(auth.iteritems(), key=operator.itemgetter(1), reverse=True)
	hubs_sorted = sorted(hubs.iteritems(), key=operator.itemgetter(1), reverse=True)
	PR_sorted = sorted(pageRank.iteritems(), key=operator.itemgetter(1), reverse=True)
	print "hubs",'jeff.dasovich@enron.com: ','%.8f'%hubs['jeff.dasovich@enron.com']
	print "auth",'jeff.dasovich@enron.com: ','%.8f'%auth['jeff.dasovich@enron.com']
	print "PR",'jeff.dasovich@enron.com: ','%.8f'%pageRank['jeff.dasovich@enron.com']
	
	pageRankResults=[]
	hubsResult=[]
	authResults=[]
	resultForTask2=[]
	for i,value in PR_sorted[:10]:
		pageRankResults.append('%.8f'%pageRank[i])
		pageRankResults.append( " " +i)
		pageRankResults.append("\n")
	for i,value in PR_sorted[:15]:
		resultForTask2.append(i)
		resultForTask2.append("\n")
	for i,value in hubs_sorted[:10]:
		hubsResult.append('%.8f'%hubs[i])
		hubsResult.append(" "+ i)
		hubsResult.append("\n")
	for i,value in auth_sorted[:10]:
		authResults.append('%.8f'%auth[i])
		authResults.append(" " + i)
		authResults.append("\n")
	file=open("pr.txt","w")
	for row in pageRankResults:
		file.write(row)
	file.close()
	file=open("hubs.txt","w")
	for row in hubsResult:
		file.write(row)
	file.close()
	file=open("auth.txt","w")
	for row in authResults:
		file.write(row)
	file.close()
	file=open("15pr.txt","w")
	for row in resultForTask2:
		file.write(row)
	file.close()
	

main()
runtime=time.time() - started
print "==========================================="
print "time",runtime