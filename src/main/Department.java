package main;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Department implements Serializable {
	private String departmentName;
	private int departmentID;
	private Set<Integer> subjectIDs = new HashSet<Integer>();
	private Set<Integer> staffIDs = new HashSet<Integer>();
    //in order to manage the number of departments
    private static int numberOfDepartments;
    
        //Constructors
    public Department() {
    	//to only initialize and assign ID for it
    	subjectIDs = new HashSet<Integer>();
    	createDepartmentID();
    	numberOfDepartments++;
    }
    public Department(String DepartmentName) {
    	createDepartmentID();
    	subjectIDs = new HashSet<Integer>();
    	this.departmentName = DepartmentName;
    	numberOfDepartments++;

    }
    
    //random ID generator
    public Department createDepartmentID() {
    	
    	for( ; ;) {
    		int temp = 0;
    		int curDigit;
    		Random rand = new Random();
    		for (int digitIndex=0; digitIndex<5; digitIndex++){
    			curDigit = rand.nextInt(9);
    			curDigit *= Math.pow(10, digitIndex);
    			temp += curDigit;
    		}
    		final int result = temp;
    		//Searching whether the ID exists in other objects
            List<Map.Entry<Integer,Department>> searchResult = Controller.departments.entrySet().stream()
        		    .filter(a -> a.getValue().getDepartmentID()==result)
        		    .collect(Collectors.toList());
            
            //if not, assign the random ID
            if(searchResult.size()==0) {
            	this.departmentID = result;
            	break;
            }
    	}
	        
        return this;
    }
    
    //Setters and Getters
    public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public Set<Integer> getSubjectIDs() {
		return subjectIDs;
	}
	public void setSubjectID(int subjectID) {
		if(subjectIDs==null)
			subjectIDs = new HashSet<Integer>();
		this.subjectIDs.add(subjectID);
	}
	public void deleteSubjectID( int subjectID) {
		this.subjectIDs.remove(subjectID);
	}
	public Set<Integer> getStaffIDs() {
		return staffIDs;
	}
	public void deleteStaffID(int staffID) {
		this.staffIDs.remove(staffID);
	}
	public void setStaffID(int staffID) {
		if(staffIDs==null)
			staffIDs = new HashSet<Integer>();
		this.staffIDs.add(staffID);
	}
	public static int getNumberOfDepartments() {
		return numberOfDepartments;
	}
	public static void setNumberOfDepartments(int numberOfDepartments) {
		Department.numberOfDepartments = numberOfDepartments;
	}
	
	//Serialization of Department objects
		public static void SaveAllData() {
			try {
				FileOutputStream outputFile = new FileOutputStream(Controller.filenameOfDepartment);
				ObjectOutputStream output = new ObjectOutputStream(outputFile);
				Iterator stIt = Controller.departments.entrySet().iterator();
				while(stIt.hasNext()) {
					Map.Entry mapElement = (Map.Entry)stIt.next();
					output.writeObject((Department) mapElement.getValue());
				}
				
				output.close();
				outputFile.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//Deserialization of Department objects
		@SuppressWarnings("unchecked")
		public static void LoadAllData() {
			try {
				FileInputStream inputFile = new FileInputStream(Controller.filenameOfDepartment);
				ObjectInputStream input = new ObjectInputStream(inputFile);
				boolean read = true;
				while(read) {
					Department department = (Department) input.readObject();
					if(department!=null) {
						Controller.departments.put(department.getDepartmentID(),department);
					}
					else 
						read=false;
				}
				
				input.close();
				inputFile.close();
			}
			
			catch(IOException e) {
				e.printStackTrace();
			}
			catch(ClassNotFoundException c) {
				c.printStackTrace();
			}
		}
}
