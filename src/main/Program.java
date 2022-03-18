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

enum Language {
	ENGLISH, HUNGARIAN, GERMAN
}

 

public class Program implements Serializable{
	
	public enum Degree {
		BACHELOR, MASTER, PHD
	}
	public enum Language {
		ENGLISH, HUNGARIAN, GERMAN
	}
	
	  private String programName;
	  private int programID; 
	  private Language language;
	  private Degree degree;
	  private int duration;
	  private int tutionFee;
	  private Set<Integer> studentIDs = new HashSet<Integer>();
	  private Set<Integer> subjectIDs = new HashSet<Integer>();
	    
	  private static int numberOfPrograms;
	    
	  public Program(){
		  createProgramID();
		  numberOfPrograms++;
	  }
	  //the constructor needs to be called only explicitly 
	  public Program(String programName) {
		  this.programName = programName;
		  createProgramID();
		  numberOfPrograms++;
	  }
	  public Program(String programName,Language language,Degree degree,
	            int duration,int tutionFee){
		  this.programName = programName;
		  this.language = language;
		  this.degree = degree;
		  this.duration =duration;
		  this.tutionFee = tutionFee;
		  createProgramID();
		  numberOfPrograms++;
	  }
	  
	  public Program(Program theOther) {
		  //need to be filled
	  }
	    
	  public Program SetDegree(Degree degree) {
		  this.degree = degree; 
		  return this;
	  }
	  public Program SetDuration(int duration) {
		  this.duration = duration;
		  return this;
	  }
	  public Program SetLanguage(Language language) {
		  this.language = language;
		  return this;
	  }
	  public Program SetProgramName(String programName) {
		  this.programName = programName;
		  return this;
	  }
	  public Program SetStudents (Student student) {
		  this.studentIDs.add(student.getStudentID());
		  return this;
	  }
	  public Program SetSubjects (Subject subject) {
		  this.subjectIDs.add(subject.getSubjectID());
		  return this;
	  }
	  public Program SetTutionFee(int tutionFee) {
		  this.tutionFee =tutionFee;
		  return this;
	  }
	  public Program createProgramID() {
		  for( ; ; ) {
			  int temp = 0;
			  int curDigit;
			  //generating random single-digits then gathering them to get 7-digit number 
			  Random rand = new Random();
			  for (int digitIndex=0; digitIndex<7; digitIndex++){  //ID is 7-digit length
				  curDigit = rand.nextInt(9) + 1;     
				  curDigit *= Math.pow(10, digitIndex);
				  temp += curDigit;
			  }
			  final int result = temp;
			  //Searching whether the ID exists in other objects
	            if(!Controller.programs.containsKey(result)) {
	            	this.programID = result;
	            	break;
	            }
		  }
	      return this;
	  }
	    
	  public Degree GetDegree() {
		  	return this.degree;
	    }
	  public int GetDuration() {
	    	return this.duration;
	    }
	  public Language GetLanguage(){
	    	return this.language;
	    }
	  public int GetNumberOfStudents() {
	    	return this.studentIDs.size();
	    }
	  public int GetNumberOfSubjects() {
	    	return this.subjectIDs.size();
	    }
	  //for getting the value of programID
	  public int GetProgramID() {
	    	return this.programID;
	    }
	  public String GetProgramName() {
	    	return this.programName;
	    }
	  public Set<Integer> GetStudentIDs() {
	    	return this.studentIDs;
	    }
	  public Set<Integer> GetSubjectIDs(){
	    	return this.subjectIDs;
	    }
	  public int GetTutionFee() {
	    	return this.tutionFee;
	    }
	    
	  public static int GetNumberOfPrograms() {
		return numberOfPrograms;
		}
	  public void showInfo() {
		//maybe needed
		}
	  public void showSubjects() {
	    	//maybe needed
	    }
	  
	//Serialization of Program objects
		public static void SaveAllData() {
			try {
				FileOutputStream outputFile = new FileOutputStream(Controller.filenameOfProgram);
				ObjectOutputStream output = new ObjectOutputStream(outputFile);
				Iterator stIt = Controller.programs.entrySet().iterator();
				while(stIt.hasNext()) {
					Map.Entry mapElement = (Map.Entry)stIt.next();
					output.writeObject((Program) mapElement.getValue());
				}
				
				output.close();
				outputFile.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//Deserialization of Program objects
		@SuppressWarnings("unchecked")
		public static void LoadAllData() {
			try {
				FileInputStream inputFile = new FileInputStream(Controller.filenameOfProgram);
				ObjectInputStream input = new ObjectInputStream(inputFile);
				boolean read = true;
				while(read) {
					Program program = (Program) input.readObject();
					if(program!=null) {
						Controller.programs.put(program.GetProgramID(),program);
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
