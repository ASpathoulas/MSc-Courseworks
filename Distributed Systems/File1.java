import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class File1{
	private static HashMap<ArrayList<String>, Integer> mapWithEverythingSent;
	private static ArrayList<Process> listWithProcesses;
	
	private static boolean inMutex = false;
	private static ArrayList<Process> priorityList;
	private static int counterForPriorityList;
	

	
	private static ArrayList<Process> buildOfPriorityList(){
		int numberOfProcesses = listWithProcesses.size();
		ArrayList<Process> theList = new ArrayList<Process>();
		for(int i=0;i<listWithProcesses.size();i++){
		for (Process process1 : listWithProcesses) {
			int counterPerm = 0;
			for (Process process2 : listWithProcesses) {
				boolean permission = false;
				permission = process1.askForPermission(process1, process2);
				if(permission){
					counterPerm++;
				}
			}
			if (counterPerm == numberOfProcesses){
				theList.add(process1);
			}
		}
		numberOfProcesses--;
		}
		return theList;
	}
	
	

	public static void main(String [] args){
		mapWithEverythingSent = new HashMap<>();
		priorityList = new ArrayList<Process>();
		
		int numberOfPrints=0;
		try{
		BufferedReader in = new BufferedReader(new FileReader(args[0]));
		String line = null;
		Process p = null;
		listWithProcesses = new ArrayList<Process>();

		while ((line = in.readLine()) != null) {
			String[] arr = line.trim().split("[ ]+");
			if (arr[0].equals("begin")) { 
				if (arr[1].equals("process")) {
					p = new Process(arr[2]);
					listWithProcesses.add(p);
					
					
				} else
				if (arr[1].equals("mutex")) {
					inMutex = true;
				}
			}
			if (arr[0].equals("end")) {
				if (arr[1].equals("mutex")) {
					inMutex = false;
				} 
				else if (arr[1].equals("process")) {
					
				}
			} 
			if (arr[0].equals("send")) {
				if(inMutex==false){
					p.insertOperation(arr);
					
				}
				else{
					String[] tmpArray = new String[4];
					tmpArray[0] = "mutex"; 
					tmpArray[1] = arr[0];
					tmpArray[2] = arr[1];
					tmpArray[3] = arr[2];
					p.insertOperation(tmpArray);
				}
				numberOfPrints++;
				
			}

			if (arr[0].equals("recv")) {

				if(inMutex==false){
					p.insertOperation(arr);
					
				}
				else{
					String[] tmpArray = new String[4];
					tmpArray[0] = "mutex"; 
					tmpArray[1] = arr[0];
					tmpArray[2] = arr[1];
					tmpArray[3] = arr[2];
					p.insertOperation(tmpArray);
				}
				numberOfPrints++;
				
			}

			if (arr[0].equals("print")) {
				if(inMutex==false){
					p.insertOperation(arr);


				}
				else{
					String[] tmpArray = new String[3];
					tmpArray[0] = "mutex"; 
					tmpArray[1] = arr[0];
					tmpArray[2] = arr[1];
					p.insertOperation(tmpArray);
					
				}
				numberOfPrints++;
			}
		}
		counterForPriorityList = 0;
		for (int i = 0; i < numberOfPrints; i++) {
			priorityList = buildOfPriorityList();
			
			for (Process myProcess: listWithProcesses) {
				if(myProcess.getSizeOfArrayList()==0 ){
					priorityList.remove(myProcess);
				}
			}
			if(priorityList.size()==0){break;}
			
			if(priorityList.get(counterForPriorityList).getSizeOfArrayList()!=0){
				if(priorityList.get(counterForPriorityList).returnOperation(0)[0].equals("print")){
					priorityList.get(counterForPriorityList).increment();
					System.out.println("printed " 
							+ priorityList.get(counterForPriorityList).getProcessID() + " " 
							+ priorityList.get(counterForPriorityList).returnOperation(0)[1] + " " 
							+ priorityList.get(counterForPriorityList).getTimestamp());
					priorityList.get(counterForPriorityList).removeOperation(0);
					counterForPriorityList = 0;
				}
				
				
				else if(priorityList.get(counterForPriorityList).returnOperation(0)[0].equals("send")){
					priorityList.get(counterForPriorityList).increment();
	
					System.out.println("sent " 
								+ priorityList.get(counterForPriorityList).getProcessID() + " " 
								+ priorityList.get(counterForPriorityList).returnOperation(0)[2] +" "
								+ priorityList.get(counterForPriorityList).returnOperation(0)[1] +" " 
								+ priorityList.get(counterForPriorityList).getTimestamp());
						ArrayList<String> tempor = new ArrayList<>();
						tempor.add(priorityList.get(counterForPriorityList).getProcessID());
						tempor.add(priorityList.get(counterForPriorityList).returnOperation(0)[1]);
						tempor.add(priorityList.get(counterForPriorityList).returnOperation(0)[2]);
						
						mapWithEverythingSent.put(tempor, priorityList.get(counterForPriorityList).getTimestamp());
						priorityList.get(counterForPriorityList).removeOperation(0);
						counterForPriorityList = 0;
				}
			
				else if(priorityList.get(counterForPriorityList).returnOperation(0)[0].equals("recv")){

					ArrayList<String> tempor1 = new ArrayList<>();
					tempor1.add(priorityList.get(counterForPriorityList).returnOperation(0)[1]);
					tempor1.add(priorityList.get(counterForPriorityList).getProcessID());
					tempor1.add(priorityList.get(counterForPriorityList).returnOperation(0)[2]);
					
					if(mapWithEverythingSent.containsKey(tempor1)){
						if(priorityList.get(counterForPriorityList).getTimestamp() < mapWithEverythingSent.get(tempor1)){
							
							priorityList.get(counterForPriorityList).setTimestamp(mapWithEverythingSent.get(tempor1) +1);
						}
						else{
							priorityList.get(counterForPriorityList).setTimestamp(priorityList.get(counterForPriorityList).getTimestamp() +1);
						}

						System.out.println("received "
								+ priorityList.get(counterForPriorityList).getProcessID() + " " 
								+ priorityList.get(counterForPriorityList).returnOperation(0)[2]+ " " 
								+ priorityList.get(counterForPriorityList).returnOperation(0)[1] + " " 
								+ priorityList.get(counterForPriorityList).getTimestamp());
						priorityList.get(counterForPriorityList).removeOperation(0);
						counterForPriorityList = 0;
					}
						
					else{
						counterForPriorityList++;
						i--;
					}
				}
				
				
				
				else if(priorityList.get(counterForPriorityList).returnOperation(0)[0].equals("mutex")){
					if(priorityList.get(counterForPriorityList).getSizeOfArrayList()!=0){
						int numberOfReceives = 0;
						int numberOfPermissions = 0;
						String proce = priorityList.get(counterForPriorityList).getProcessID();
						for (String[] mutexArray : priorityList.get(counterForPriorityList).getMapWithOperations()) {
							if(mutexArray[0].equals("mutex") && mutexArray[1].equals("recv") ){
								numberOfReceives++;
								ArrayList<String> temporary1 = new ArrayList<>();
								temporary1.add(mutexArray[2]);
								temporary1.add(proce);
								temporary1.add(mutexArray[3]);
								if(mapWithEverythingSent.containsKey(temporary1)){
									numberOfPermissions++;
								}
								else{
									i--;
									break;
								}
							}
						}
						
			
						if(numberOfPermissions==numberOfReceives || numberOfReceives==0){
						try {
							while(priorityList.get(counterForPriorityList).returnOperation(0)[0] == "mutex"){

									if(priorityList.get(counterForPriorityList).returnOperation(0)[1].equals("print")){
										priorityList.get(counterForPriorityList).setTimestamp(priorityList.get(counterForPriorityList).getTimestamp() +1);
										System.out.println("printed " 
												+ priorityList.get(counterForPriorityList).getProcessID() + " " 
												+ priorityList.get(counterForPriorityList).returnOperation(0)[2] +" " 
												+ priorityList.get(counterForPriorityList).getTimestamp());
										i++;

										priorityList.get(counterForPriorityList).removeOperation(0);
								}
								else if(priorityList.get(counterForPriorityList).returnOperation(0)[1].equals("send")){
									priorityList.get(counterForPriorityList).setTimestamp(priorityList.get(counterForPriorityList).getTimestamp() +1);
									
									System.out.println("sent " 
											+ priorityList.get(counterForPriorityList).getProcessID() + " " 
											+ priorityList.get(counterForPriorityList).returnOperation(0)[3] +" "
											+ priorityList.get(counterForPriorityList).returnOperation(0)[2] +" " 
											+ priorityList.get(counterForPriorityList).getTimestamp());
									
									ArrayList<String> tempor = new ArrayList<>();
									tempor.add(priorityList.get(counterForPriorityList).getProcessID());
									tempor.add(priorityList.get(counterForPriorityList).returnOperation(0)[2]);
									tempor.add(priorityList.get(counterForPriorityList).returnOperation(0)[3]);
									
									mapWithEverythingSent.put(tempor, priorityList.get(counterForPriorityList).getTimestamp());
									i++;
									priorityList.get(counterForPriorityList).removeOperation(0);;
								}
								else if(priorityList.get(counterForPriorityList).returnOperation(0)[1].equals("recv"))
								{
									ArrayList<String> tempor1 = new ArrayList<>();
									tempor1.add(priorityList.get(counterForPriorityList).returnOperation(0)[2]);
									tempor1.add(priorityList.get(counterForPriorityList).getProcessID());
									tempor1.add(priorityList.get(counterForPriorityList).returnOperation(0)[3]);
									
									if(mapWithEverythingSent.containsKey(tempor1)){
										
										if(priorityList.get(counterForPriorityList).getTimestamp() < mapWithEverythingSent.get(tempor1)){
											priorityList.get(counterForPriorityList).setTimestamp(mapWithEverythingSent.get(tempor1) + 1);

										}
										else{
											priorityList.get(counterForPriorityList).setTimestamp(priorityList.get(counterForPriorityList).getTimestamp() + 1);
										}

										System.out.println("received "
												+ priorityList.get(counterForPriorityList).getProcessID()+" "
												+ priorityList.get(counterForPriorityList).returnOperation(0)[3]+ " " 
												+ priorityList.get(counterForPriorityList).returnOperation(0)[2] + " " 
												+ priorityList.get(counterForPriorityList).getTimestamp());
										i++;
										priorityList.get(counterForPriorityList).removeOperation(0);
									}
										
									else{i--;}
								
								}
								
							}

						} catch (IndexOutOfBoundsException e) {}
						i--;
						}else{
							counterForPriorityList++;
							i--;
						}
					}
				}	
			
			}
				else{i--;
				}
			}

			in.close();
		}
		catch(IOException e){e.printStackTrace();}
	}
}



class Process {

	private ArrayList<String[]> mapWithOperations;
	private int timestamp;
	private String processID;
	
	public Process(String processID) {
		mapWithOperations = new ArrayList<String[]>();
		timestamp = 0;
		this.processID = processID;
		
	}
	public String getProcessID() {
		return processID;
	}
	
	public void setProcessID(String processID) {
		this.processID = processID;
	}

	public int getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(int timestamp) {
		this.timestamp = timestamp;
	}

	
	public void insertOperation(String[] operation){
		mapWithOperations.add(operation);
	}
	
	public String[] returnOperation (int locationInArrayList){
		return mapWithOperations.get(locationInArrayList);
	}
	
	public int getSizeOfArrayList(){
		return mapWithOperations.size();
	}
	
	public void increment(){
		timestamp++;
	}
	
	public void removeOperation(int number){
		mapWithOperations.remove(number);
	}
	
	public ArrayList<String[]> getMapWithOperations(){
		return mapWithOperations;
	}
	
	public boolean askForPermission(Process base,Process target){
		if(base.getTimestamp()<=target.getTimestamp()){
			return true;
		}
		else{
			return false;
		}
	}
}
