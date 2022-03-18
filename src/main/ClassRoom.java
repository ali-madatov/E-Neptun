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
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

enum SubjectType{
	LECTURE, PRACTICE, LAB
}

public class ClassRoom implements Serializable{
	
	public enum SubjectType{
		LECTURE, PRACTICE, LAB
	}
	
	private String subjectName;
	private int subjectID;
	private SubjectType subjectType;
	private int ClassRoomID;
	private String teacherName;
	private String teacherSurname;
	private int teacherID;
	private Set<Integer> studentIDs = new HashSet<Integer>();
	private int maxStudentNum;
	private String roomNumber;
	private Set<Schedule> schedule = new HashSet<Schedule>();
    
	public ClassRoom() {
		createClassRoomID();
	}
    public ClassRoom(String subjectName,int subjectID, SubjectType subjectType, Staff teacher, int maxStudentNum, String roomNumber,
                Set<Schedule> schedule) {
    	createClassRoomID();
    	this.subjectName =subjectName;
    	this.subjectID = subjectID;
    	this.subjectType = subjectType;
    	this.teacherName = teacher.getName();
    	this.teacherSurname = teacher.getSurname();
    	this.teacherID = teacher.getStaffID();
    	this.maxStudentNum = maxStudentNum;
    	this.roomNumber = roomNumber;
    	this.schedule = schedule;
    }
    
  //generating random 6-digit ID
    public ClassRoom createClassRoomID(){
    	
    	for( ; ; ) {
    		int temp = 0;
            int curDigit;
            Random rand = new Random();
            //generating random 6-digit ID
            for (int digitIndex=0; digitIndex<6; digitIndex++){
                curDigit = rand.nextInt(9);
                curDigit *= Math.pow(10, digitIndex);
                temp += curDigit;
            }
            final int result = temp;
            
            //Searching whether the ID exists in other objects
            Optional<Map.Entry<Integer, ClassRoom>> searchResult = Controller.classrooms.entrySet().stream()
        		    .filter(a -> a.getValue().getClassRoomID()==result)
        		    .findAny();
            
            //if not, assign the random ID
            if(!searchResult.isPresent()) {
            	this.ClassRoomID = result;
            	break;
            }
    	}
    	return this;
    }
    
    	/*Getters and Setters*/
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
	public SubjectType getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}
	public int getClassRoomID() {
		return ClassRoomID;
	}
	public void setClassRoomID(int classRoomID) {
		ClassRoomID = classRoomID;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherSurname() {
		return teacherSurname;
	}
	public void setTeacherSurname(String teacherSurname) {
		this.teacherSurname = teacherSurname;
	}
	public int getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(int teacher_ID) {
		this.teacherID = teacher_ID;
		this.teacherName = Controller.staffs.get(teacher_ID).getName();
		this.teacherSurname = Controller.staffs.get(teacher_ID).getSurname();
	}
	public Set<Integer> getStudentIDs() {
		return studentIDs;
	}
	public void setStudentID(int studentID) {
		if(studentIDs.size()<maxStudentNum) {
			this.studentIDs.add(studentID);
		}
		else {
			System.out.println("Registration Failed!");
		}
	}
	public int getMaxStudentNum() {
		return maxStudentNum;
	}
	public void setMaxStudentNum(int maxStudentNum) {
		this.maxStudentNum = maxStudentNum;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Set<Schedule> getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule.add(schedule);
	}
	
	//Serialization of ClassRoom objects
	public static void SaveAllData() {
		try {
			FileOutputStream outputFile = new FileOutputStream(Controller.filenameOfClassroom);
			ObjectOutputStream output = new ObjectOutputStream(outputFile);
			
			Iterator csIt = Controller.classrooms.entrySet().iterator();
			while(csIt.hasNext()) {
				Map.Entry mapElement = (Map.Entry)csIt.next();
				output.writeObject((ClassRoom) mapElement.getValue());
			}
			
			output.close();
			outputFile.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Deserialization of ClassRoom objects
	@SuppressWarnings("unchecked")
	public static void LoadAllData() {
		try {
			FileInputStream inputFile = new FileInputStream(Controller.filenameOfClassroom);
			ObjectInputStream input = new ObjectInputStream(inputFile);
			boolean read = true;
			while(read) {
				ClassRoom classroom = (ClassRoom) input.readObject();
				if(classroom!=null) {
					Controller.classrooms.put(classroom.getClassRoomID(),classroom);
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
