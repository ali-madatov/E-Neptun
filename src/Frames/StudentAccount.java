package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneLayout;
import javax.swing.SwingConstants;

import main.Controller;
import main.Program;
import main.Schedule;
import main.ClassRoom;
import main.Staff;
import main.Student;
import main.Subject;
import values.Colors;
import values.Dimensions;
public class StudentAccount implements ActionListener{
	
	Student accountOwner;
	boolean clicked = false;
	JFrame frame;
	JTabbedPane tabbedPane;
	
	JPanel myDataPanel;
	JTextField name;
	JTextField motherName;
	JTextField birthDate;
	JTextField country;
	JTextField birthPlace;
	JTextField nationality;
	JTextField sex;
	JTextField phoneNum;
	JTextField email;
	JTextField studentID;
	JTextField program;
	JTextField degree;
	JTextField studyMode;
	JTextField startDate;
	JTextField language;
	JTextField preIns;
	JButton editButton;
	boolean editing=false;
	
	JPanel studiesPanel;
	JTabbedPane studiesPane;
	JPanel schedulePanel;
	JPanel gradebookPanel;
	JScrollPane scrollPane;
	
	JPanel subjectsPanel;
	JTabbedPane subjectsPane;
	JPanel registerPanel;
	JPanel regSubjectsPanel;
	JScrollPane scrollPaneSub;
	JFrame moreFrame;
	
	JPanel examsPanel;
	
	public StudentAccount(Student student) {
		accountOwner = student;
		frame = new JFrame();
		frame.setTitle("Student Account");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(50,50));
		ImageIcon logo = new ImageIcon("icons/logo.png");
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setBackground(Colors.studentAccountColor);
		frame.setVisible(true);
		
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(1280,160));
		ImageIcon backgroundImage = new ImageIcon("icons/school.png");
		topPanel.setLayout(null);
		
		JLabel label = new JLabel();
		label.setBounds(400,0,500,160);
		label.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 34));
		label.setForeground(Color.YELLOW);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setBackground(Color.white);
		label.setIcon(backgroundImage);
		JPanel rightPanel = new JPanel();
		rightPanel.setBounds(880,0,400,160);
		rightPanel.setLayout(null);
		rightPanel.setBorder(null);
		rightPanel.setBackground(new Color(0x38A6DB));
		topPanel.add(label);
		topPanel.add(rightPanel);
		setLabels(rightPanel);
		topPanel.setBackground(new Color(0x2165A6));
		
		JLabel label1 = new JLabel("MY DATA");
		label1.setPreferredSize(new Dimension(250,120));
		label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		label1.setForeground(Colors.studentAccountColor);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label2 = new JLabel("STUDIES");
		label2.setPreferredSize(new Dimension(250,120));
		label2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		label2.setForeground(Colors.studentAccountColor);
		label2.setHorizontalAlignment(JLabel.CENTER);
	
		
		JLabel label3 = new JLabel("SUBJECTS");
		label3.setPreferredSize(new Dimension(250,120));
		label3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		label3.setForeground(Colors.studentAccountColor);
		label3.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label4 = new JLabel("EXAMS");
		label4.setPreferredSize(new Dimension(250,120));
		label4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		label4.setForeground(Colors.studentAccountColor);
		label4.setHorizontalAlignment(JLabel.CENTER);
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(Dimensions.screenSize.width,500));

		myDataPanel = new JPanel();
		myDataPanel.setPreferredSize(new Dimension(1000,400));
		myDataPanel.setBackground(Colors.studentAccountColor);
		myDataPanel.setLayout(null);
		setMyData(student);
		tabbedPane.addTab("  My Data  ", myDataPanel);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		studiesPanel = new JPanel();
		studiesPanel.setPreferredSize(new Dimension(1000,400));
		studiesPanel.setBackground(Colors.studentAccountColor);
		studiesPanel.setLayout(new BorderLayout());
		setStudies(student);
		tabbedPane.addTab("  Studies ", studiesPanel);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		subjectsPanel = new JPanel();
		subjectsPanel.setPreferredSize(new Dimension(1000,400));
		subjectsPanel.setBackground(Colors.studentAccountColor);
		subjectsPanel.setLayout(new BorderLayout());
		setSubjects(student);
		tabbedPane.addTab("  Subjects ", subjectsPanel);
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);
		
		examsPanel = new JPanel();
		examsPanel.setPreferredSize(new Dimension(1000,400));
		examsPanel.setBackground(Colors.studentAccountColor);
		tabbedPane.addTab("  Exams ", examsPanel);
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
		tabbedPane.setTabComponentAt(0, label1);
		tabbedPane.setTabComponentAt(1, label2);
		tabbedPane.setTabComponentAt(2, label3);
		tabbedPane.setTabComponentAt(3, label4);
		tabbedPane.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 40));
		tabbedPane.setForeground(Color.blue);
		tabbedPane.setBackground(Color.white);
		tabbedPane.setTabPlacement(JTabbedPane.LEFT);
		
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(tabbedPane,BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	private void setLabels(JPanel panel) {
		
		JButton moreButton = new JButton();
		moreButton.setText(accountOwner.getName()+" "+accountOwner.getSurname());
		moreButton.setFont(new Font("Berlin Sans BV",Font.BOLD,15));
		FontMetrics metrics = moreButton.getFontMetrics(moreButton.getFont()); 
	    int width = metrics.stringWidth( moreButton.getText() )+50;
	    int height = metrics.getHeight()+10;
		moreButton.setBounds(panel.getWidth()-width-15, 5, width, height);
		ImageIcon plusIcon = new ImageIcon("icons/usernameIcon.png");
		moreButton.setIcon(plusIcon);
		moreButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		moreButton.setBorder(null);
		moreButton.setBackground(Colors.studentAccountColor);
		moreButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
			  if(!clicked) {
				if(moreFrame!=null && moreFrame.isVisible())
					moreFrame.dispose();
				moreButton.setBackground(Color.white);
				moreFrame = new JFrame();
				moreFrame.setSize(new Dimension(width,height*2));
				moreFrame.setUndecorated(true);
				moreFrame.setVisible(true);
				moreFrame.setLayout(null);
				moreFrame.setBackground(Color.white);
				Point point = moreButton.getLocationOnScreen();
				moreFrame.setLocation(new Point(point.x,point.y+moreButton.getHeight()));
				JButton changeButton = new JButton("Change password");
				changeButton.setFont(new Font("Berlin Sans BV",Font.BOLD,14));
				changeButton.setBounds(0,0,width,height);
				changeButton.setBorder(null);
				changeButton.setFocusable(false);
				changeButton.setBackground(Color.white);
				//changeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.studentAccountColor));
				changeButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame changeFrame = new JFrame();
						changeFrame.setSize(new Dimension(300,250));
						changeFrame.setTitle("Change Password");
						changeFrame.setLayout(null);
						changeFrame.setLocation(400, 200);
						ImageIcon logoIcon = new ImageIcon("icons/logo.png");
						changeFrame.setIconImage(logoIcon.getImage());
						JPasswordField current = new JPasswordField();
						current.setText("Current Password");
						current.setFont(new Font("Berlin Sans BV",Font.BOLD,14));
						current.setEchoChar((char) 0); 
						current.setBounds(40, 30, 220, 30);
						current.setForeground(Color.LIGHT_GRAY);
						current.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								current.setText("");
								current.setEchoChar('*');
								
							}
						});
						
						JPasswordField newOne = new JPasswordField();
						newOne.setText("New Password");
						newOne.setEchoChar((char) 0); 
						newOne.setBounds(40, 70, 220, 30);
						newOne.setForeground(Color.LIGHT_GRAY);
						newOne.setFont(new Font("Berlin Sans BV",Font.BOLD,14));
						newOne.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								newOne.setText("");
								newOne.setEchoChar('*');
								
							}
						});
						
						JPasswordField repeat = new JPasswordField();
						repeat.setText("Current Password");
						repeat.setEchoChar((char) 0); 
						repeat.setBounds(40, 110, 220, 30);
						repeat.setForeground(Color.LIGHT_GRAY);
						repeat.setFont(new Font("Berlin Sans BV",Font.BOLD,14));
						repeat.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								repeat.setText("");
								repeat.setEchoChar('*');
								
							}
						});
						
						JButton change = new JButton("Save");
						change.setFocusable(false);
						change.setBackground(Color.green);
						change.setFont(new Font("Berlin Sans BV",Font.BOLD,15));
						change.setForeground(Color.black);
						change.setBounds(100,160,100,30);
						change.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								if(current.getText()==null || !current.getText().equals(accountOwner.getPassword())) {
									JOptionPane.showMessageDialog(changeFrame, "Please, input the current password correctly",
											"Invalid password", JOptionPane.ERROR_MESSAGE);
								}
								else if(newOne.getText()==null || repeat.getText()==null || !newOne.getText().equals(repeat.getText())) {
									JOptionPane.showMessageDialog(changeFrame, "New passwords do not match!",
											"Invalid input", JOptionPane.ERROR_MESSAGE);
								}
								else {
									Controller.students.get(accountOwner.getStudentID()).setPassword(newOne.getText());
									changeFrame.dispose();
								}
								
							}
							
						});
						
						changeFrame.add(newOne);
						changeFrame.add(current);
						changeFrame.add(repeat);
						changeFrame.add(change);
						changeFrame.setVisible(true);
						
					}
				
				});
				
				JButton logout = new JButton();
				logout.setBounds(0,height,width,height);
				logout.setText("Log out");
				logout.setFont(new Font("Berlin Sans BV",Font.BOLD,14));
				logout.setForeground(Color.black);
				logout.setBackground(Color.white);
				logout.setFocusPainted(false);
				logout.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						new StudentLoginFrame();
						frame.dispose();
					}
					
				});
				logout.setBorder(null);
				
				moreFrame.setBackground(Color.white);
				moreFrame.add(logout);
				moreFrame.add(changeButton);
				moreFrame.setVisible(true);
				clicked=true;
			}
			  else {
				  clicked=false;
				  moreFrame.dispose();
				  moreButton.setBackground(Colors.studentAccountColor);
			  }
		   }	  
			
		});
		panel.add(moreButton);
		
		
	}
	
	private void setMyData(Student student) {
		JLabel label1 = new JLabel("Full Name: ");
		label1.setBounds(40, 20, 120, 40);
		label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label1.setForeground(Color.YELLOW);
		name = new JTextField();
		name.setBounds(170,20,150,40);
		name.setText(student.getName()+" "+student.getSurname());
		name.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		name.setForeground(Color.YELLOW);
		
		JLabel label2 = new JLabel("Mother Name: ");
		label2.setBounds(40, 70, 140, 40);
		label2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label2.setForeground(Color.YELLOW);
		motherName = new JTextField();
		motherName.setBounds(195,70,130,40);
		motherName.setText(student.getMother_name());
		motherName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		motherName.setForeground(Color.YELLOW);
		
		JLabel label3 = new JLabel("Birth Date: ");
		label3.setBounds(40, 120, 120, 40);
		label3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label3.setForeground(Color.YELLOW);
		birthDate = new JTextField();
		birthDate.setBounds(170,120,200,40);
		birthDate.setText(student.getBirth_date().toString());
		birthDate.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		birthDate.setForeground(Color.YELLOW);
		
		JLabel label4 = new JLabel("Birth Country: ");
		label4.setBounds(40, 170, 150, 40);
		label4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label4.setForeground(Color.YELLOW);
		country = new JTextField();
		country.setBounds(200,170,150,40);
		country.setText(student.getBirth_country());
		country.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		country.setForeground(Color.YELLOW);
		
		JLabel label5 = new JLabel("Birth Place: ");
		label5.setBounds(40, 220, 140, 40);
		label5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label5.setForeground(Color.YELLOW);
		birthPlace = new JTextField();
		birthPlace.setBounds(185,220,150,40);
		birthPlace.setText(student.getBirth_place());
		birthPlace.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		birthPlace.setForeground(Color.YELLOW);
		
		JLabel label6 = new JLabel("Nationality: ");
		label6.setBounds(40, 270, 135, 40);
		label6.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label6.setForeground(Color.YELLOW);
		nationality = new JTextField();
		nationality.setBounds(180,270,150,40);
		nationality.setText(student.getNationality());
		nationality.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		nationality.setForeground(Color.YELLOW);
		
		JLabel label7 = new JLabel("Sex: ");
		label7.setBounds(40, 320, 60, 40);
		label7.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label7.setForeground(Color.YELLOW);
		sex = new JTextField();
		sex.setBounds(106,320,150,40);
		sex.setText(student.getSex().toString().toLowerCase());
		sex.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		sex.setForeground(Color.YELLOW);
		
		JLabel label8 = new JLabel("Phone Number: ");
		label8.setBounds(40, 370, 160, 40);
		label8.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label8.setForeground(Color.YELLOW);
		phoneNum = new JTextField();
		phoneNum.setBounds(210,370,160,40);
		phoneNum.setText(student.getParentNum());
		phoneNum.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		phoneNum.setForeground(Color.YELLOW);
		
		JLabel label9 = new JLabel("Email: ");
		label9.setBounds(40, 420, 80, 40);
		label9.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label9.setForeground(Color.YELLOW);
		email = new JTextField();
		email.setBounds(125,420,250,40);
		email.setText(student.getEmail());
		email.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		email.setForeground(Color.YELLOW);
		
		JLabel label10 = new JLabel("Student ID: ");
		label10.setBounds(500, 20, 130, 40);
		label10.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label10.setForeground(Color.YELLOW);
		studentID = new JTextField();
		studentID.setBounds(640,20,150,40);
		studentID.setText(String.valueOf(student.getStudentID()));
		studentID.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		studentID.setForeground(Color.YELLOW);
		
		JLabel label11 = new JLabel("Program: ");
		label11.setBounds(500, 70, 110, 40);
		label11.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label11.setForeground(Color.YELLOW);
		program = new JTextField();
		program.setBounds(615,70,300,40);
		program.setHorizontalAlignment(JTextField.LEFT);
		String[] str = student.getProgramName().split("\\s+");
		String progName = new String();
		for(int p=0;p<str.length-1;p++)
			progName+=" "+str[p];
		program.setText(progName);
		program.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		program.setForeground(Color.YELLOW);
		
		JLabel label12 = new JLabel("Degree: ");
		label12.setBounds(500, 120, 110, 40);
		label12.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label12.setForeground(Color.YELLOW);
		degree = new JTextField();
		degree.setBounds(615,120,150,40);
		degree.setText(student.getDegree().toString().toLowerCase());
		degree.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		degree.setForeground(Color.YELLOW);
		
		JLabel label13 = new JLabel("Study Mode: ");
		label13.setBounds(500, 170, 150, 40);
		label13.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label13.setForeground(Color.YELLOW);
		studyMode = new JTextField();
		studyMode.setBounds(655,170,150,40);
		studyMode.setText(student.getStudyMode().toString().toLowerCase());
		studyMode.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		studyMode.setForeground(Color.YELLOW);
		
		JLabel label14 = new JLabel("Start Date: ");
		label14.setBounds(500, 220, 140, 40);
		label14.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label14.setForeground(Color.YELLOW);
		startDate = new JTextField();
		startDate.setBounds(640,220,150,40);
		if(student.getStartDate()!=null)
		startDate.setText(student.getStartDate().toString());
		startDate.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		startDate.setForeground(Color.YELLOW);
		
		JLabel label15 = new JLabel("Language: ");
		label15.setBounds(500, 270, 130, 40);
		label15.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label15.setForeground(Color.YELLOW);
		language = new JTextField();
		language.setBounds(635,270,150,40);
		language.setText("English");
		language.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		language.setForeground(Color.YELLOW);
		
		JLabel label16 = new JLabel("Pre-institution: ");
		label16.setBounds(500, 320, 160, 40);
		label16.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label16.setForeground(Color.YELLOW);
		preIns = new JTextField();
		preIns.setBounds(670,320,180,40);
		preIns.setText(student.getPreInstutition());
		preIns.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		preIns.setForeground(Color.YELLOW);
		
		editButton = new JButton();
		editButton.setBounds(840, 420, 120, 50);
		editButton.setText("EDIT");
		editButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 26));
		editButton.setBackground(Color.green);
		editButton.setForeground(Color.blue);
		editButton.setFocusable(false);
		editButton.addActionListener(this);
		
		setEditibility(false);
		myDataPanel.add(label1);
		myDataPanel.add(label2);
		myDataPanel.add(label3);
		myDataPanel.add(label4);
		myDataPanel.add(label5);
		myDataPanel.add(label6);
		myDataPanel.add(label7);
		myDataPanel.add(label8);
		myDataPanel.add(label9);
		myDataPanel.add(name);
		myDataPanel.add(motherName);
		myDataPanel.add(birthDate);
		myDataPanel.add(country);
		myDataPanel.add(birthPlace);
		myDataPanel.add(nationality);
		myDataPanel.add(sex);
		myDataPanel.add(phoneNum);
		myDataPanel.add(email);
		myDataPanel.add(label10);
		myDataPanel.add(label11);
		myDataPanel.add(label12);
		myDataPanel.add(label13);
		myDataPanel.add(label14);
		myDataPanel.add(label15);
		myDataPanel.add(label16);
		myDataPanel.add(studentID);
		myDataPanel.add(program);
		myDataPanel.add(degree);
		myDataPanel.add(studyMode);
		myDataPanel.add(startDate);
		myDataPanel.add(language);
		myDataPanel.add(preIns);
		myDataPanel.add(editButton);
	}
	
	//setting editibility of textfields and their background colors
	private void setEditibility(boolean flag) {
		
		name.setEditable(flag);
		motherName.setEditable(flag);
		country.setEditable(flag);
		birthPlace.setEditable(flag);
		nationality.setEditable(flag);
		phoneNum.setEditable(flag);
		email.setEditable(flag);
		preIns.setEditable(flag);
		
		name.setBorder(null);
		motherName.setBorder(null);
		birthDate.setBorder(null);
		country.setBorder(null);
		birthPlace.setBorder(null);
		nationality.setBorder(null);
		sex.setBorder(null);
		phoneNum.setBorder(null);
		email.setBorder(null);
		studentID.setBorder(null);
		program.setBorder(null);
		degree.setBorder(null);
		studyMode.setBorder(null);
		startDate.setBorder(null);
		language.setBorder(null);
		preIns.setBorder(null);
		
		if(flag) {
			name.setBackground(Color.LIGHT_GRAY);
			motherName.setBackground(Color.LIGHT_GRAY);
			country.setBackground(Color.LIGHT_GRAY);
			birthPlace.setBackground(Color.LIGHT_GRAY);
			nationality.setBackground(Color.LIGHT_GRAY);
			phoneNum.setBackground(Color.LIGHT_GRAY);
			email.setBackground(Color.LIGHT_GRAY);
			preIns.setBackground(Color.LIGHT_GRAY);
			name.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			motherName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			country.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			birthPlace.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			nationality.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			phoneNum.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			email.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			preIns.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		}
		
		else {
			name.setBackground(Colors.studentAccountColor);
			motherName.setBackground(Colors.studentAccountColor);
			country.setBackground(Colors.studentAccountColor);
			birthPlace.setBackground(Colors.studentAccountColor);
			nationality.setBackground(Colors.studentAccountColor);
			phoneNum.setBackground(Colors.studentAccountColor);
			email.setBackground(Colors.studentAccountColor);
			preIns.setBackground(Colors.studentAccountColor);
		}
		birthDate.setBackground(Colors.studentAccountColor);
		sex.setBackground(Colors.studentAccountColor);
		studentID.setBackground(Colors.studentAccountColor);
		program.setBackground(Colors.studentAccountColor);
		degree.setBackground(Colors.studentAccountColor);
		studyMode.setBackground(Colors.studentAccountColor);
		startDate.setBackground(Colors.studentAccountColor);
		language.setBackground(Colors.studentAccountColor);
	}

	private void setStudies(Student student) {
		studiesPane = new JTabbedPane();
		studiesPane.setPreferredSize(new Dimension(1000,350));
		
		JLabel label1 = new JLabel("Class Schedule");
		label1.setPreferredSize(new Dimension(200,40));
		label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		label1.setForeground(Colors.studentAccountColor);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label2 = new JLabel("Gradebook");
		label2.setPreferredSize(new Dimension(200,40));
		label2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		label2.setForeground(Colors.studentAccountColor);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		schedulePanel = new JPanel();
		schedulePanel.setPreferredSize(new Dimension(1000,370));
		setSchedule(student);
		studiesPane.add(schedulePanel);
		studiesPane.setMnemonicAt(0, KeyEvent.VK_1);
		studiesPane.setTabComponentAt(0, label1);
		
		gradebookPanel = new JPanel();
		gradebookPanel.setPreferredSize(new Dimension(1000,370));
		gradebookPanel.setLayout(new BorderLayout());
		setGradeBook(student,gradebookPanel);
		studiesPane.add(gradebookPanel);
		studiesPane.setMnemonicAt(1, KeyEvent.VK_2);
		studiesPane.setTabComponentAt(1, label2);
		studiesPane.setVisible(true);
		
		studiesPanel.add(studiesPane);
		
		
	}
	
	private void setSchedule(Student student) {
		schedulePanel.setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(1000,44));
		topPanel.setLayout(new FlowLayout());
		topPanel.setBackground(Color.green);
		
		JLabel monday = new JLabel("Monday");
		monday.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		monday.setForeground(Color.RED);
		monday.setPreferredSize(new Dimension(192,40));
		JLabel tuesday = new JLabel("Tuesday");
		tuesday.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		tuesday.setForeground(Color.RED);
		tuesday.setPreferredSize(new Dimension(192,40));
		JLabel wednesday = new JLabel("Wednesday");
		wednesday.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		wednesday.setForeground(Color.RED);
		wednesday.setPreferredSize(new Dimension(192,40));
		JLabel thursday = new JLabel("Thursday");
		thursday.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		thursday.setForeground(Color.RED);
		thursday.setPreferredSize(new Dimension(192,40));
		JLabel friday = new JLabel(" Friday");
		friday.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		friday.setForeground(Color.RED);
		friday.setPreferredSize(new Dimension(192,40));
		topPanel.add(monday);
		topPanel.add(tuesday);
		topPanel.add(wednesday);
		topPanel.add(thursday);
		topPanel.add(friday);
		schedulePanel.add(topPanel,BorderLayout.NORTH);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(900,400));
		bottomPanel.setLayout(new GridLayout(5,5));
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(Color.YELLOW);
		panel1.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.yellow);
		panel2.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.yellow);
		panel3.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.yellow);
		panel4.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel5 = new JPanel();
		panel5.setBackground(Color.yellow);
		panel5.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		JPanel panel6 = new JPanel();
		panel6.setBackground(Color.yellow);
		panel6.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel7 = new JPanel();
		panel7.setBackground(Color.yellow);
		panel7.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel8 = new JPanel();
		panel8.setBackground(Color.yellow);
		panel8.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel9 = new JPanel();
		panel9.setBackground(Color.yellow);
		panel9.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel10 = new JPanel();
		panel10.setBackground(Color.yellow);
		panel10.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		JPanel panel11 = new JPanel();
		panel11.setBackground(Color.yellow);
		panel11.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel12 = new JPanel();
		panel12.setBackground(Color.yellow);
		panel12.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel13 = new JPanel();
		panel13.setBackground(Color.yellow);
		panel13.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel14 = new JPanel();
		panel14.setBackground(Color.yellow);
		panel14.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel15 = new JPanel();
		panel15.setBackground(Color.yellow);
		panel15.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		JPanel panel16 = new JPanel();
		panel16.setBackground(Color.yellow);
		panel16.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel17 = new JPanel();
		panel17.setBackground(Color.yellow);
		panel17.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel18 = new JPanel();
		panel18.setBackground(Color.yellow);
		panel18.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel19 = new JPanel();
		panel19.setBackground(Color.yellow);
		panel19.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel20 = new JPanel();
		panel20.setBackground(Color.yellow);
		panel20.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		JPanel panel21 = new JPanel();
		panel21.setBackground(Color.yellow);
		panel21.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel22 = new JPanel();
		panel22.setBackground(Color.yellow);
		panel22.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel23 = new JPanel();
		panel23.setBackground(Color.yellow);
		panel23.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel24 = new JPanel();
		panel24.setBackground(Color.yellow);
		panel24.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		JPanel panel25 = new JPanel();
		panel25.setBackground(Color.yellow);
		panel25.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		
		bottomPanel.add(panel1);
		bottomPanel.add(panel2);
		bottomPanel.add(panel3);
		bottomPanel.add(panel4);
		bottomPanel.add(panel5);
		bottomPanel.add(panel6);
		bottomPanel.add(panel7);
		bottomPanel.add(panel8);
		bottomPanel.add(panel9);
		bottomPanel.add(panel10);
		bottomPanel.add(panel11);
		bottomPanel.add(panel12);
		bottomPanel.add(panel13);
		bottomPanel.add(panel14);
		bottomPanel.add(panel15);
		bottomPanel.add(panel16);
		bottomPanel.add(panel17);
		bottomPanel.add(panel18);
		bottomPanel.add(panel19);
		bottomPanel.add(panel20);
		bottomPanel.add(panel21);
		bottomPanel.add(panel22);
		bottomPanel.add(panel23);
		bottomPanel.add(panel24);
		bottomPanel.add(panel25);
		
		resetSchedule(student,bottomPanel);
		
		schedulePanel.add(bottomPanel,BorderLayout.SOUTH);
		
	}
	
	private void resetSchedule(Student student, JPanel panel) {
		
		if(!Controller.classrooms.isEmpty() && student.getClassIDs()!=null && student.getClassIDs().size()>0) {
			List<ClassRoom> list = new ArrayList<ClassRoom>();
			for(int i: student.getClassIDs()) {
				list.add(Controller.classrooms.get(i));
			}
			for(int i=0;i<list.size();i++) {
				for(Schedule schedule: list.get(i).getSchedule()) {
					int dayOf;
					int timeOf;
					
					//defining day of week
					if(schedule.getWeekDay()==Schedule.WeekDay.MONDAY)
						dayOf=0;
					else if(schedule.getWeekDay()==Schedule.WeekDay.TUESDAY)
						dayOf=1;
					else if(schedule.getWeekDay()==Schedule.WeekDay.WEDNESDAY)
						dayOf=2;
					else if(schedule.getWeekDay()==Schedule.WeekDay.THURSDAY)
						dayOf=3;
					else
						dayOf=4;
					
					//defining time of day
					if(schedule.getStartTime().getHour()<10)
						timeOf=0;
					else if(schedule.getStartTime().getHour()<12)
						timeOf=1;
					else if(schedule.getStartTime().getHour()<14)
						timeOf=2;
					else if(schedule.getStartTime().getHour()<16)
						timeOf=3;
					else
						timeOf=4;
					
					String timing = String.valueOf(schedule.getStartTime().getHour())+":"+
							String.valueOf(schedule.getStartTime().getMinute())+" - "+
							String.valueOf(schedule.getFinishTime().getHour())+":"+
							String.valueOf(schedule.getFinishTime().getMinute())+"       ";
					String text = timing + list.get(i).getSubjectName()+"  -  ("+list.get(i).getTeacherName()+" "+
							list.get(i).getTeacherSurname()+")  -  Room: "+list.get(i).getRoomNumber();
					
					JTextArea textArea = new JTextArea();
					textArea.setText(text);
					textArea.setWrapStyleWord(true);
				    textArea.setLineWrap(true);
				    textArea.setFont(new Font(Font.DIALOG,Font.BOLD,14));
				    textArea.setForeground(Color.blue);
				    textArea.setOpaque(false);
				    textArea.setBounds(2, 2, 190, 75);
					((JPanel) panel.getComponent(timeOf*5+dayOf)).add(textArea);
				}
			}
		}
	}
	
	private void setGradeBook(Student student, JPanel panel) {
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(1000,40));
		topPanel.setBackground(Color.cyan);
		topPanel.setLayout(new FlowLayout());
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.cyan);
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setPreferredSize(new Dimension(1000,400));
		
		JLabel label1 = new JLabel("Subject Name");
		label1.setPreferredSize(new Dimension(240,40));
		label1.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label2 = new JLabel("Lecturer");
		label2.setPreferredSize(new Dimension(240,40));
		label2.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label3 = new JLabel("Credit");
		label3.setPreferredSize(new Dimension(240,40));
		label3.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label4 = new JLabel("Mark");
		label4.setPreferredSize(new Dimension(240,40));
		label4.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		
		topPanel.add(label1);
		topPanel.add(label2);
		topPanel.add(label3);
		topPanel.add(label4);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(Color.green);
		scrollPane.setOpaque(true);
		scrollPane.setPreferredSize(new Dimension(1000,400));
		
		if(student.getClassIDs()!=null) {
			mainPanel.setPreferredSize(new Dimension(1000,student.getClassIDs().size()*50));
		}
		for(int i=0;student.getClassIDs()!=null && i<student.getClassIDs().size();i++) {
			JPanel dataPanel = new JPanel();
			dataPanel.setPreferredSize(new Dimension(1000,40));
			dataPanel.setBackground(Color.white);
			dataPanel.setLayout(new FlowLayout());
			
			ClassRoom classr = Controller.classrooms.get(student.getClassIDs().iterator().next());
			String input = classr.getSubjectName();
			JLabel Label1 = new JLabel(input);
			Label1.setPreferredSize(new Dimension(240,40));
			Label1.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label1.setForeground(Color.white);
			input = classr.getTeacherName()+" "+classr.getTeacherSurname();
			JLabel Label2 = new JLabel(input);
			Label2.setPreferredSize(new Dimension(240,40));
			Label2.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label2.setForeground(Color.white);
			input = String.valueOf(Controller.subjects.get(classr.getSubjectID()).getCredit());
			JLabel Label3 = new JLabel(input);
			Label3.setPreferredSize(new Dimension(240,40));
			Label3.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label3.setForeground(Color.white);
			
			input = " ";
			for(int j=0;j<student.getGradebooks().size();j++) {
				if(student.getGradebooks().get(j).classID==classr.getClassRoomID())
					input = String.valueOf(student.getGradebooks().get(j).mark);
			}
			JLabel Label4 = new JLabel(input);
			Label4.setPreferredSize(new Dimension(240,40));
			Label4.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label4.setForeground(Color.white);
			
			dataPanel.add(Label1);
			dataPanel.add(Label2);
			dataPanel.add(Label3);
			dataPanel.add(Label4);
		    
		    mainPanel.add(dataPanel);
		}
		scrollPane.setViewportView(mainPanel);
		
		panel.add(topPanel,BorderLayout.NORTH);
		panel.add(scrollPane,BorderLayout.SOUTH);
	}

	private void setSubjects(Student student) {
		subjectsPane = new JTabbedPane();
		subjectsPane.setPreferredSize(new Dimension(1000,400));
		
		JLabel label1 = new JLabel("Register for Subjects");
		label1.setPreferredSize(new Dimension(250,40));
		label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		label1.setForeground(Colors.studentAccountColor);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label2 = new JLabel("Registered Subjects");
		label2.setPreferredSize(new Dimension(250,40));
		label2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		label2.setForeground(Colors.studentAccountColor);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		registerPanel = new JPanel();
		registerPanel.setPreferredSize(new Dimension(1000,370));
		registerPanel.setLayout(new BorderLayout());
		setRegistration(student,registerPanel);
		subjectsPane.add(registerPanel);
		subjectsPane.setMnemonicAt(0, KeyEvent.VK_1);
		subjectsPane.setTabComponentAt(0, label1);
		
		regSubjectsPanel = new JPanel();
		regSubjectsPanel.setPreferredSize(new Dimension(1000,370));
		regSubjectsPanel.setLayout(new BorderLayout());
		setRegSubjects(student,regSubjectsPanel);
		subjectsPane.add(regSubjectsPanel);
		subjectsPane.setMnemonicAt(1, KeyEvent.VK_2);
		subjectsPane.setTabComponentAt(1, label2);
		subjectsPane.setVisible(true);
		
		subjectsPanel.add(subjectsPane);
	}
	
	private void setRegistration(Student student,JPanel panel) {
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(1000,40));
		topPanel.setBackground(Color.cyan);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.cyan);
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setPreferredSize(new Dimension(1000,400));
		
		JLabel label1 = new JLabel("Subject ID");
		label1.setPreferredSize(new Dimension(200,40));
		label1.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label2 = new JLabel("Subject Name");
		label2.setPreferredSize(new Dimension(200,40));
		label2.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label3 = new JLabel("Credit");
		label3.setPreferredSize(new Dimension(200,40));
		label3.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label4 = new JLabel("No. Term");
		label4.setPreferredSize(new Dimension(200,40));
		label4.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		
		topPanel.add(label1);
		topPanel.add(label2);
		topPanel.add(label3);
		topPanel.add(label4);
		
		scrollPaneSub = new JScrollPane();
		scrollPaneSub.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneSub.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneSub.setBackground(Color.green);
		scrollPaneSub.setOpaque(true);
		scrollPaneSub.setPreferredSize(new Dimension(1000,400));
		
		if(Controller.subjects.size()>0) {
			mainPanel.setPreferredSize(new Dimension(1000,Math.max(Controller.subjects.size()*50,400)));
		}
		
		for(int i: Controller.subjects.keySet()) {
			JPanel dataPanel = new JPanel();
			dataPanel.setPreferredSize(new Dimension(1000,40));
			dataPanel.setBackground(Color.white);
			dataPanel.setLayout(new FlowLayout());
			
			Subject subj = Controller.subjects.get(i);
					//new Subject("Calculus 1",Program.Language.ENGLISH,6,1);
			String input = String.valueOf(subj.getSubjectID());
			JLabel Label1 = new JLabel(input);
			Label1.setPreferredSize(new Dimension(220,40));
			Label1.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label1.setForeground(Color.blue);
			input = subj.getSubjectName();
			JLabel Label2 = new JLabel(input);
			Label2.setPreferredSize(new Dimension(220,40));
			Label2.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label2.setForeground(Color.red);
			input = String.valueOf(subj.getCredit());
			JLabel Label3 = new JLabel(input);
			Label3.setPreferredSize(new Dimension(220,40));
			Label3.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label3.setForeground(Color.magenta);
			
			input = String.valueOf(subj.getNoTerm());
			JLabel Label4 = new JLabel(input);
			Label4.setPreferredSize(new Dimension(220,40));
			Label4.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label4.setForeground(Color.green);
			
			JButton moreButton = new JButton();
			moreButton.setPreferredSize(new Dimension(30,30));
			ImageIcon plusIcon = new ImageIcon("icons/plusIcon.png");
			moreButton.setIcon(plusIcon);
			moreButton.setBorder(null);
			moreButton.setBackground(Color.black);
			moreButton.setOpaque(false);
			moreButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(moreFrame!=null && moreFrame.isVisible())
						moreFrame.dispose();
					moreFrame = new JFrame();
					moreFrame.setSize(new Dimension(120,60));
					moreFrame.setUndecorated(true);
					moreFrame.setVisible(true);
					moreFrame.setLayout(null);
					Point point = moreButton.getLocationOnScreen();
					moreFrame.setLocation(new Point(point.x-80,point.y-60));
					JButton registerButton = new JButton("Register");
					registerButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,12));
					registerButton.setBounds(0,0,120,30);
					registerButton.setBorder(null);
					registerButton.setFocusable(false);
					registerButton.setBackground(Color.green);
					registerButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							new ChooseClassroomsFrame(subj,student);
							moreFrame.dispose();
						}
					
					});
					
					JButton detailsButton = new JButton("Details");
					detailsButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,12));
					detailsButton.setBounds(0,30,120,30);
					detailsButton.setBorder(null);
					detailsButton.setFocusable(false);
					detailsButton.setBackground(Color.green);
					detailsButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							new SubjectDataFrame(subj,student);
							moreFrame.dispose();
						}
						
					});
					
					moreFrame.setBackground(Color.white);
					moreFrame.add(registerButton);
					moreFrame.add(detailsButton);
				}
				
			});
			
			dataPanel.add(Label1);
			dataPanel.add(Label2);
			dataPanel.add(Label3);
			dataPanel.add(Label4);
			dataPanel.setBackground(Color.white);
			dataPanel.add(moreButton);
		    
		    mainPanel.add(dataPanel);
		}
		scrollPaneSub.setViewportView(mainPanel);
		
		panel.add(topPanel,BorderLayout.NORTH);
		panel.add(scrollPaneSub,BorderLayout.SOUTH);
	}
	
	private void setRegSubjects(Student student, JPanel panel) {
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(1000,40));
		topPanel.setBackground(Color.cyan);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.cyan);
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setPreferredSize(new Dimension(1000,400));
		
		JLabel label1 = new JLabel("Subject ID");
		label1.setPreferredSize(new Dimension(200,40));
		label1.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label2 = new JLabel("Subject Name");
		label2.setPreferredSize(new Dimension(200,40));
		label2.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label3 = new JLabel("Credit");
		label3.setPreferredSize(new Dimension(200,40));
		label3.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label4 = new JLabel("No. Term");
		label4.setPreferredSize(new Dimension(200,40));
		label4.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		
		topPanel.add(label1);
		topPanel.add(label2);
		topPanel.add(label3);
		topPanel.add(label4);
		
		scrollPaneSub = new JScrollPane();
		scrollPaneSub.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneSub.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneSub.setBackground(Color.green);
		scrollPaneSub.setOpaque(true);
		scrollPaneSub.setPreferredSize(new Dimension(1000,400));
		
		if(student.getSubjectIDs()!=null) {
			mainPanel.setPreferredSize(new Dimension(1000,Math.max(student.getSubjectIDs().size()*50,400)));
		}
		
		for(int i=0;student.getSubjectIDs()!=null && i<student.getSubjectIDs().size();i++) {
			JPanel dataPanel = new JPanel();
			dataPanel.setPreferredSize(new Dimension(1000,40));
			dataPanel.setBackground(Color.white);
			dataPanel.setLayout(new FlowLayout());
			
			Subject subj = Controller.subjects.get(student.getSubjectIDs().iterator().next());
			String input = String.valueOf(subj.getSubjectID());
			JLabel Label1 = new JLabel(input);
			Label1.setPreferredSize(new Dimension(220,40));
			Label1.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label1.setForeground(Color.blue);
			input = subj.getSubjectName();
			JLabel Label2 = new JLabel(input);
			Label2.setPreferredSize(new Dimension(220,40));
			Label2.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label2.setForeground(Color.red);
			input = String.valueOf(subj.getCredit());
			JLabel Label3 = new JLabel(input);
			Label3.setPreferredSize(new Dimension(220,40));
			Label3.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label3.setForeground(Color.magenta);
			
			input = String.valueOf(subj.getNoTerm());
			JLabel Label4 = new JLabel(input);
			Label4.setPreferredSize(new Dimension(220,40));
			Label4.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label4.setForeground(Color.green);
			
			JButton moreButton = new JButton();
			moreButton.setPreferredSize(new Dimension(30,30));
			ImageIcon plusIcon = new ImageIcon("icons/plusIcon.png");
			moreButton.setIcon(plusIcon);
			moreButton.setBorder(null);
			moreButton.setBackground(Color.black);
			moreButton.setOpaque(false);
			moreButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(moreFrame!=null && moreFrame.isVisible())
						moreFrame.dispose();
					moreFrame = new JFrame();
					moreFrame.setSize(new Dimension(120,60));
					moreFrame.setUndecorated(true);
					moreFrame.setVisible(true);
					moreFrame.setLayout(null);
					Point point = moreButton.getLocationOnScreen();
					moreFrame.setLocation(new Point(point.x-80,point.y-60));
					JButton dropButton = new JButton("Drop Subject");
					dropButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,12));
					dropButton.setBounds(0,0,120,30);
					dropButton.setBorder(null);
					dropButton.setFocusable(false);
					dropButton.setBackground(Color.green);
					dropButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							moreFrame.dispose();
							int selection = JOptionPane.showConfirmDialog(frame, "Do you want to drop the subject?",
									"Degregistration", JOptionPane.YES_NO_OPTION);
							if(selection==JOptionPane.YES_OPTION) {
								System.out.println("yes");
								student.removeSubject(subj.getSubjectID());
							}
						}
					
					});
					
					JButton detailsButton = new JButton("Details");
					detailsButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,12));
					detailsButton.setBounds(0,30,120,30);
					detailsButton.setBorder(null);
					detailsButton.setFocusable(false);
					detailsButton.setBackground(Color.green);
					detailsButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							moreFrame.dispose();
							new SubjectDataFrame(subj,student);
							
						}
						
					});
					
					moreFrame.setBackground(Color.white);
					moreFrame.add(dropButton);
					moreFrame.add(detailsButton);
				}
				
			});
			
			dataPanel.add(Label1);
			dataPanel.add(Label2);
			dataPanel.add(Label3);
			dataPanel.add(Label4);
			dataPanel.setBackground(Color.white);
			dataPanel.add(moreButton);
		    
		    mainPanel.add(dataPanel);
		}
		scrollPaneSub.setViewportView(mainPanel);
		
		panel.add(topPanel,BorderLayout.NORTH);
		panel.add(scrollPaneSub,BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==editButton) {
			if(editing) {
				Student student = accountOwner;
				if(name.getText()!=null  && motherName.getText()!=null  
						&& country.getText()!=null 
						&& birthPlace.getText()!=null && nationality.getText()!=null && phoneNum.getText()!=null
						&& email.getText()!=null  && preIns.getText()!=null) {
					String fullName[] = name.getText().split("\\s+");
					student.setName(fullName[0]);
					student.setSurname(fullName[1]);
					student.setMother_name(motherName.getText());
					student.setBirth_country(country.getText());
					student.setBirth_place(birthPlace.getText());
					student.setNationality(nationality.getText());
					student.setParentNum(phoneNum.getText());
					student.setEmail(email.getText());
					student.setPreInstutition(preIns.getText());
					
					
					if(Controller.students.containsKey(student.getStudentID())) {
						Controller.students.replace(student.getStudentID(), student);
					}
					
					Student.SaveAllData();
					setEditibility(false);
					editButton.setText("EDIT");
					editing=false;
				}
				else
					JOptionPane.showMessageDialog(frame, (Object) "Please fill out all necessary fields with *", "INCOMPLETE FORM",
							JOptionPane.PLAIN_MESSAGE);
					
			}
			else {
				setEditibility(true);
				editButton.setText("SAVE");
				editing=true;
			}
		}
		
	}
		
}
