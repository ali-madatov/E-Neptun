package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Frames.DeanAccount;
import Frames.HeadAccount;
import Frames.MainFrame;
import Frames.StudentAccount;
import Frames.TeacherAccount;
import main.Program.Degree;
import values.Colors;

public class Controller {
	
	 /*File names for storing each class*/
	
	public static String filenameOfClassroom = "Classroom.txt";
	public static String filenameOfDepartment = "Department.txt";
	public static String filenameOfFaculty = "Faculty.txt";
	public static String filenameOfProgram = "Program.txt";
	public static String filenameOfStaff = "Staff.txt";
	public static String filenameOfStudent = "Student.txt";
	public static String filenameOfSubject = "Subject.txt";
	
	 /*Array lists for objects of each class*/
	
	public static HashMap<Integer,ClassRoom> classrooms = new HashMap<Integer,ClassRoom>();
	public static HashMap<Integer,Department> departments = new HashMap<Integer,Department>();
	public static HashMap<Integer,Faculty> faculties = new HashMap<Integer,Faculty>();
	public static HashMap<Integer,Program> programs = new HashMap<Integer,Program>();
	public static HashMap<Integer,Staff> staffs = new HashMap<Integer,Staff>();
	public static HashMap<Integer,Student> students = new HashMap<Integer,Student>();
	public static HashMap<Integer,Subject> subjects = new HashMap<Integer,Subject>();
	
	public static void main(String[] args) {
		LoadData();

		Program program = new Program("Finance");
		program.SetDuration(7);
		program.SetDegree(Degree.BACHELOR);
		program.SetLanguage(Program.Language.GERMAN);
		program.SetTutionFee(7200);
		programs.put(program.GetProgramID(),program);
		new MainFrame();
		
		SaveData();
		
	}
	
	private static void LoadData() {
		ClassRoom.LoadAllData();
		Department.LoadAllData();
		Faculty.LoadAllData();
		Program.LoadAllData();
		Staff.LoadAllData();
		Subject.LoadAllData();
		Student.LoadAllData();
	}
	
	private static void SaveData() {
		ClassRoom.SaveAllData();
		Department.SaveAllData();
		Faculty.SaveAllData();
		Staff.SaveAllData();
		Subject.SaveAllData();
		Student.SaveAllData();
		Program.SaveAllData();
	}

}
