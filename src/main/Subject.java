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

public class Subject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String subjectName;
	private int subjectID;
	private Program.Language subjectLanguage;
	private int credit;
	private int noTerm;
	private Set<Integer> classIDs = new HashSet<Integer>();
	private static int numberOfAllSubjects;
    
	public Subject() {
		createSubjectID();
		numberOfAllSubjects++;
	}
    public Subject(String subjectName,Program.Language language,int credit,int noTerm){
    	createSubjectID();
    	this.subjectName = subjectName;
    	this.subjectLanguage = language;
    	this.credit = credit;
    	this.noTerm = noTerm;
    	numberOfAllSubjects++;
    }
    
    public Subject createSubjectID() {
    	for( ; ; ) {
    		int temp = 0;
    		int curDigit;
    		Random rand = new Random();
    		for (int digitIndex=0; digitIndex<6; digitIndex++){
    			curDigit = rand.nextInt(9);
    			curDigit *= Math.pow(10, digitIndex);
    			temp += curDigit;
    		}
    		final int result = temp;
    		//Searching whether the ID exists in other objects
            if(!Controller.subjects.containsKey(result)) {
            	this.subjectID = result;
            	break;
            }
    	}
        return this;
    }
    

	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getSubjectID() {
		return subjectID;
	}
	public void setSubjectID(int subjectID) {
		this.subjectID = subjectID;
	}
	public Program.Language getSubjectLanguage() {
		return subjectLanguage;
	}
	public void setSubjectLanguage(Program.Language subjectLanguage) {
		this.subjectLanguage = subjectLanguage;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int getNoTerm() {
		return noTerm;
	}
	public void setNoTerm(int noTerm) {
		this.noTerm = noTerm;
	}
	public Set<Integer> getClassIDs() {
		return classIDs;
	}
	public void setClassID(int classID) {
		this.classIDs.add(classID);
	}
	public static int getNumberOfAllSubjects() {
		return numberOfAllSubjects;
	}
	public static void setNumberOfAllSubjects(int numberOfAllSubjects) {
		Subject.numberOfAllSubjects = numberOfAllSubjects;
	}
	
	//Serialization of Subject objects
		public static void SaveAllData() {
			try {
				FileOutputStream outputFile = new FileOutputStream(Controller.filenameOfSubject);
				ObjectOutputStream output = new ObjectOutputStream(outputFile);
				Iterator stIt = Controller.subjects.entrySet().iterator();
				while(stIt.hasNext()) {
					Map.Entry mapElement = (Map.Entry)stIt.next();
					output.writeObject((Subject) mapElement.getValue());
				}
				
				output.close();
				outputFile.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//Deserialization of Subject objects
		@SuppressWarnings("unchecked")
		public static void LoadAllData() {
			try {
				FileInputStream inputFile = new FileInputStream(Controller.filenameOfSubject);
				ObjectInputStream input = new ObjectInputStream(inputFile);
				boolean read = true;
				while(read) {
					Subject subject = (Subject) input.readObject();
					if(subject!=null) {
						Controller.subjects.put(subject.getSubjectID(),subject);
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