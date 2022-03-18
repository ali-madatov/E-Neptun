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

public class Faculty implements Serializable{
	
	private int facultyID;
	private String name;
	private int deanID;
	private Set<Integer> programIDs = new HashSet<Integer>();
	private Set<Integer> staffIDs = new HashSet<Integer>();
	private static int numberOfFaculties;
    
	public Faculty() {
		createFacultyID();
		numberOfFaculties++;
	}
    public Faculty(String Name) {
    	createFacultyID();
    	this.name = Name;
		numberOfFaculties++;

    }
    
    public Faculty createFacultyID(){
    	for ( ; ;) {
    		int temp = 0;
    		int curDigit;
    		Random rand = new Random();
    		//creating single random digit and gathering them to get 4-digit ID
    		for (int digitIndex=0; digitIndex<4; digitIndex++){
    			curDigit = rand.nextInt(9);
    			curDigit *= Math.pow(10, digitIndex);
    			temp += curDigit;
    		}
    		final int result = temp;
    		//Searching whether the ID exists in other objects
            
            //if not, assign the random ID
            if(!Controller.faculties.containsKey(result)) {
            	this.facultyID = result;
            	break;
            }
    	}
        return this;
    }
    public int getFacultyID() {
		return facultyID;
	}
	public void setFacultyID(int facultyID) {
		this.facultyID = facultyID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDeanID() {
		return deanID;
	}
	public void setDeanID(int deanID) {
		this.deanID = deanID;
	}
	public Set<Integer> getProgramIDs() {
		return programIDs;
	}
	public void setProgramID(int programID) {
		this.programIDs.add(programID);
	}
	public Set<Integer> getStaffIDs() {
		return staffIDs;
	}
	public void setStaffID(int staffID) {
		this.staffIDs.add(staffID);
	}
	public static int getNumberOfFaculties() {
		return numberOfFaculties;
	}
	public static void setNumberOfFaculties(int numberOfFaculties) {
		Faculty.numberOfFaculties = numberOfFaculties;
	}
	
	//Serialization of Faculty objects
		public static void SaveAllData() {
			try {
				FileOutputStream outputFile = new FileOutputStream(Controller.filenameOfFaculty);
				ObjectOutputStream output = new ObjectOutputStream(outputFile);
				Iterator stIt = Controller.faculties.entrySet().iterator();
				while(stIt.hasNext()) {
					Map.Entry mapElement = (Map.Entry)stIt.next();
					output.writeObject((Faculty) mapElement.getValue());
				}
				
				output.close();
				outputFile.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//Deserialization of Faculty objects
		@SuppressWarnings("unchecked")
		public static void LoadAllData() {
			try {
				FileInputStream inputFile = new FileInputStream(Controller.filenameOfFaculty);
				ObjectInputStream input = new ObjectInputStream(inputFile);
				boolean read = true;
				while(read) {
					Faculty faculty = (Faculty) input.readObject();
					if(faculty!=null) {
						Controller.faculties.put(faculty.getFacultyID(),faculty);
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
