package main;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Person implements Serializable{
	
	public enum Sex {
		MALE, FEMALE
	}
	
		protected String LoginName;
		protected String password;
		protected String name;
		protected String surname;
		protected String mother_name;
		protected String phone_num;
		protected String email;
		protected LocalDate birth_date;
		protected String birth_country;
		protected String birth_place;
		protected String nationality;
		protected Person.Sex sex;
		protected LocalDate startDate;
		static protected String UniversityName;
		    
		public Person() {
			createLoginName();
		}
		public Person(String Name,String Surname,String Password,
		            Date startdate,String Mother_name,String Email,String Phone_num,
		            Date Birth_date,String Birth_country,String Birth_place,
		            String Nationality,Sex csex) {
			createLoginName();
			
		}
		public Person(String Name,String Surname,String Password, Date startdate) {
			createLoginName();
		}
		   
		    
		public Person createLoginName() {
			for( ; ; ) {
				String temparr = "Mustaf";
				int curDigit;
				Random rand = new Random();
				/*generating random numbers between 65-90 then assigning
		                            them to the string get 6-letter LoginName */
				for (int digitIndex=0; digitIndex<6; digitIndex++){  //LoginName is 6-letter length
					curDigit = rand.nextInt(25) + 65;     
					temparr  = temparr.substring(0,digitIndex)+ (char) curDigit +temparr.substring(digitIndex+1);
				}
				final String result = temparr;
				//Searching whether the LoginName exists in Student and Staff objects
	            
	            if(!Controller.staffs.containsKey(result) && !Controller.students.containsKey(result)) {
	            	this.LoginName = result;
	            	break;
	            }
			}
		    return this;
		}
		
		public String getLoginName() {
			return LoginName;
		}
		public void setLoginName(String loginName) {
			LoginName = loginName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getMother_name() {
			return mother_name;
		}
		public void setMother_name(String mother_name) {
			this.mother_name = mother_name;
		}
		public String getPhone_num() {
			return phone_num;
		}
		public void setPhone_num(String phone_num) {
			this.phone_num = phone_num;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public LocalDate getBirth_date() {
			return birth_date;
		}
		public void setBirth_date(LocalDate birth_date) {
			this.birth_date = birth_date;
		}
		public String getBirth_country() {
			return birth_country;
		}
		public void setBirth_country(String birth_country) {
			this.birth_country = birth_country;
		}
		public String getBirth_place() {
			return birth_place;
		}
		public void setBirth_place(String birth_place) {
			this.birth_place = birth_place;
		}
		public String getNationality() {
			return nationality;
		}
		public void setNationality(String nationality) {
			this.nationality = nationality;
		}
		public Sex getSex() {
			return sex;
		}
		public void setSex(Sex sex) {
			this.sex = sex;
		}
		public LocalDate getStartDate() {
			return startDate;
		}
		public void setStartDate(LocalDate startDate) {
			this.startDate = startDate;
		}
		public static String getUniversityName() {
			return UniversityName;
		}
		public static void setUniversityName(String universityName) {
			UniversityName = universityName;
		}
		    
}
