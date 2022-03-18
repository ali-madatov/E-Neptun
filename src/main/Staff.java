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
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

enum Position{
    HEAD, TEACHER, TECHNICAL
}

public class Staff extends Person implements Serializable{
	
	public enum Position{
	    HEAD, TEACHER, TECHNICAL
	}
	private static final long serialVersionUID = 1L;
	private String department;
	private int departmentID;
	private Position position;
	private int staffID;
	private int salary;
	private String phoneNum;
	private String bankAccount;
	private int taxID;
	private Set<Integer> classIDs = new HashSet<Integer>();
	private static int numberOfStaffs;
	
		//Constructors
	public Staff() {
		createStaffID();
		 numberOfStaffs++;

	}
	public Staff(String Name,String Surname,String Password,
	             LocalDate startdate, String department, int departmentID){
		createStaffID();
		this.name = Name;
		this.surname = Surname;
		this.password = Password;
		this.startDate = startdate;
		this.department = department;
		this.departmentID = departmentID;
		numberOfStaffs++;

	}
	
	//generating random 6-digit ID
	public Staff createStaffID(){
		for( ; ; ) {
			int temp = 0;
			int curDigit;
			Random rand = new Random();
			//generating random single-digits then gathering them to get 8-digit number 
			for (int digitIndex=0; digitIndex<8; digitIndex++){
				curDigit = rand.nextInt(9);             //ID is 8-digit length
				curDigit *= Math.pow(10, digitIndex);
				temp += curDigit;
			}
			final int result = temp;
			//Searching whether the ID exists in other objects
            if(!Controller.staffs.containsKey(result)) {
            	this.staffID = result;
            	break;
            }
		}
	    return this;
	}
		/*Getters and Setters*/
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		for(int i=0; i< Controller.departments.size(); i++) {
			Department dep = Controller.departments.entrySet().iterator().next().getValue();
			if(dep.getDepartmentName().equals(department))
				this.departmentID=dep.getDepartmentID();
		}
		this.department = department;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getDepartmentID() {
		return departmentID;
	}
	public void setDepartmentID(int departmentID) {
		this.departmentID = departmentID;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getStaffID() {
		return staffID;
	}
	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getBankAccount() {
		return bankAccount;
	}
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public int getTaxID() {
		return taxID;
	}
	public void setTaxID(int taxID) {
		this.taxID = taxID;
	}
	public Set<Integer> getClassIDs() {
		return classIDs;
	}
	public void setClassID(int classID) {
		this.classIDs.add(classID);
	}
	public static int getNumberOfStaffs() {
		return numberOfStaffs;
	}
	public static void setNumberOfStaffs(int numberOfStaffs) {
		Staff.numberOfStaffs = numberOfStaffs;
	}
	
	//Serialization of Staff objects
		public static void SaveAllData() {
			try {
				FileOutputStream outputFile = new FileOutputStream(Controller.filenameOfStaff);
				ObjectOutputStream output = new ObjectOutputStream(outputFile);
				Iterator stIt = Controller.staffs.entrySet().iterator();
				while(stIt.hasNext()) {
					Map.Entry mapElement = (Map.Entry)stIt.next();
					output.writeObject((Staff) mapElement.getValue());
				}
				
				output.close();
				outputFile.close();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		//Deserialization of Staff objects
		@SuppressWarnings("unchecked")
		public static void LoadAllData() {
			try {
				FileInputStream inputFile = new FileInputStream(Controller.filenameOfStaff);
				ObjectInputStream input = new ObjectInputStream(inputFile);
				boolean read = true;
				while(read) {
					Staff staff = (Staff) input.readObject();
					if(staff!=null) {
						Controller.staffs.put(staff.getStaffID(),staff);
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
