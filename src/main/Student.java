package main;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

enum StudyMode{
	FULL_TIME, PART_TIME, EXCHANGE
}


public class Student extends Person {
	
	public enum StudyMode{
		FULL_TIME, PART_TIME, EXCHANGE
	}
	
	 /**
	 * 
	 */
	 private static final long serialVersionUID = 1L;
	 private int studentID;
	 private String parentNum;
	 private String programName;    
	 private int programID;
	 private StudyMode studyMode;
	 private Program.Degree degree;
	 private String preInstutition;
	 private Set<Integer> subjectIDs = new HashSet<Integer>();
	 private Set<Integer> classIDs = new HashSet<Integer>();
	 private List<GradeBook> gradebooks;
	 private static int numberOfStudents;

	 	//Constructors
	 public Student(){
		 createStudentID();
		 numberOfStudents++;
	 }
	 public Student(String Name,String Surname,String Password, LocalDate startdate) {
		 createStudentID();
		 this.name = Name;
		 this.surname = Surname;
		 this.password = Password;
		 this.startDate = startdate;
		 numberOfStudents++;

	 }

	 public Student SetAllVariables(String mother_name,String phone_num,String email,
	                LocalDate birth_date,String birth_country,String birth_place,
	                String nationality,Sex sex,String universityName,
	                String parentNum, String programName, int programID,
	                StudyMode studyMode, Program.Degree degree,String preInstutition) {
		 this.mother_name = mother_name;
	     this.phone_num = phone_num;
	     this.email = email;
	     this.birth_date = birth_date;
	     this.birth_country = birth_country;
	     this.birth_place = birth_place;
	     this.nationality = nationality;
	     this.sex = sex;
	     UniversityName = universityName;
	     this.parentNum = parentNum;
	     this.programName = programName;
	     this.programID = programID;
	     this.studyMode = studyMode;
	     this.degree =  degree;
	     this.preInstutition = preInstutition;
		 return this;
		 
	 }
	 public Student createStudentID() {
		 for ( ; ; ) {
			 int temp = 0;
			 int curDigit;
			 Random rand = new Random();
			 //generating random single-digits then gathering them to get 8-digit number 
			 for (int digitIndex=0; digitIndex<8; digitIndex++){ //ID is 8-digit length
				 curDigit = rand.nextInt(10);
				 curDigit *= Math.pow(10, digitIndex);
				 temp += curDigit;
			 }
			 final int result = temp;
			//Searching whether the ID exists in other objects
			 Optional<Map.Entry<Integer, Student>> searchResult = Controller.students.entrySet().stream()
	        		    .filter(a -> a.getValue().getStudentID()==result)
	        		    .findAny();
	            
	            //if not, assign the random ID
	            if(!searchResult.isPresent()) {
	            	this.studentID = result;
	            	break;
	            }
		 }
		 return this;
	 }
	 
	 public int getStudentID() {
		return studentID;
	 }
	 public void setStudentID(int studentID) {
		this.studentID = studentID;
	 }
	 public String getParentNum() {
		return parentNum;
	 }
	 public void setParentNum(String parentNum) {
		this.parentNum = parentNum;
	 }
	 public String getProgramName() {
		return programName;
	 }
	 public void setProgramName(String programName) {
		this.programName = programName;
	 }
	 public int getProgramID() {
		return programID;
	 }
	 public void setProgramID(int programID) {
		this.programID = programID;
		}
	 public StudyMode getStudyMode() {
			return studyMode;
		}
	 public void setStudyMode(StudyMode studyMode) {
			this.studyMode = studyMode;
		}
	public Program.Degree getDegree() {
		return degree;
	}
	public void setDegree(Program.Degree degree) {
		this.degree = degree;
	}
	public String getPreInstutition() {
		return preInstutition;
	}
	public void setPreInstutition(String preInstutition) {
		this.preInstutition = preInstutition;
	}
	public Set<Integer> getSubjectIDs() {
		return subjectIDs;
	}
	public void setSubjectID(int subjectID) {
		if(this.subjectIDs==null)
			this.subjectIDs = new HashSet<Integer>();
		this.subjectIDs.add(subjectID);
	}
	public Set<Integer> getClassIDs() {
		return classIDs;
	}
	public void setClassID(int classID) {
		if(classIDs==null)
			this.classIDs = new HashSet<Integer>();
		this.classIDs.add(classID);
	}
	public List<GradeBook> getGradebooks() {
		return gradebooks;
	}
	public void setGradebookID(GradeBook gradebook) {
		if(this.gradebooks==null)
			this.gradebooks = new LinkedList<GradeBook>();
		this.gradebooks.add(gradebook);
	}
	public static int getNumberOfStudents() {
		return numberOfStudents;
	}
	
	public void removeSubject(int subjectID) {
		this.subjectIDs.remove(subjectID);
		Set<Integer> temp = new HashSet<Integer>();
		for(int i: this.classIDs) {
			if(Controller.classrooms.get(i).getSubjectID()!=subjectID) {
				temp.add(i);
			}
		}
		this.classIDs = temp;
	}
	
	//Serialization of Student objects
		public static void SaveAllData() {
			try {
				FileOutputStream outputFile = new FileOutputStream(Controller.filenameOfStudent);
				ObjectOutputStream output = new ObjectOutputStream(outputFile);
				Iterator stIt = Controller.students.entrySet().iterator();
				while(stIt.hasNext()) {
					Map.Entry mapElement = (Map.Entry)stIt.next();
					output.writeObject((Student) mapElement.getValue());
				}
				
				output.close();
				outputFile.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//Deserialization of Student objects
		@SuppressWarnings("unchecked")
		public static void LoadAllData() {
			try {
				FileInputStream inputFile = new FileInputStream(Controller.filenameOfStudent);
				ObjectInputStream input = new ObjectInputStream(inputFile);
				boolean read = true;
				while(read) {
					Student student = (Student) input.readObject();
					if(student!=null) {
						Controller.students.put(student.getStudentID(),student);
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
