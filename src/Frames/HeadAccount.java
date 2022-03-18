package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.ClassRoom;
import main.Controller;
import main.Department;
import main.Program;
import main.Schedule;
import main.Staff;
import main.Subject;
import values.Colors;
import values.Dimensions;

public class HeadAccount implements ActionListener{
	Staff accountOwner;
	boolean clicked = false;
	ImageIcon logo;
	JFrame frame;
	JTabbedPane tabbedPane;
	
	JPanel myDataPanel;
	JTextField name;
	JTextField motherName;
	JTextField birthDate;
	JTextField country;
	JTextField birthPlace;
	JTextField nationality;
	JTextField phoneNum;
	JTextField email;
	JTextField sex;
	JTextField taxID;
	JTextField staffID;
	
	JTextField startDate;
	String[] startDates;
	JTextField department;
	String[] departmentsToShow; 
	JTextField position;
	JTextField bankAccount;
	JTextField salary;
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
	
	int height=80;
	List<ClassRoom> addedClasses;
	List<Map.Entry<Integer, Staff>> filteredStaffs;
	JPanel regSubjectsPanel;
	JScrollPane scrollPaneSub;
	JFrame moreFrame;
	
	JPanel examsPanel;
	
	public HeadAccount(Staff staff) {
		accountOwner = staff;
		frame = new JFrame();
		frame.setTitle("Staff Account");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(50,50));
		logo = new ImageIcon("icons/logo.png");
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setBackground(Colors.staffAccountColor);
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
		label1.setForeground(Colors.staffAccountColor);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label2 = new JLabel("SUBJECTS");
		label2.setPreferredSize(new Dimension(250,120));
		label2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 30));
		label2.setForeground(Colors.staffAccountColor);
		label2.setHorizontalAlignment(JLabel.CENTER);
	
	
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(Dimensions.screenSize.width,500));

		myDataPanel = new JPanel();
		myDataPanel.setPreferredSize(new Dimension(1000,400));
		myDataPanel.setBackground(Colors.staffAccountColor);
		myDataPanel.setLayout(null);
		setMyData(staff);
		tabbedPane.addTab("  My Data  ", myDataPanel);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		
		subjectsPanel = new JPanel();
		subjectsPanel.setPreferredSize(new Dimension(1000,400));
		subjectsPanel.setBackground(Colors.staffAccountColor);
		subjectsPanel.setLayout(new BorderLayout());
		setSubjects(staff);
		tabbedPane.addTab("  Subjects ", subjectsPanel);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		
		tabbedPane.setTabComponentAt(0, label1);
		tabbedPane.setTabComponentAt(1, label2);
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
		moreButton.setBackground(Colors.staffAccountColor);
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
				//changeButton.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Colors.staffAccountColor));
				changeButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						moreFrame.dispose();
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
									Controller.staffs.get(accountOwner.getStaffID()).setPassword(newOne.getText());
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
						moreFrame.dispose();
						new StaffLoginFrame();
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
				  moreButton.setBackground(Colors.staffAccountColor);
			  }
		   }	  
			
		});
		panel.add(moreButton);
		
		
	}
	
	private void setMyData(Staff staff) {
		JLabel label1 = new JLabel("Full Name: ");
		label1.setBounds(40, 20, 120, 40);
		label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label1.setForeground(Color.YELLOW);
		name = new JTextField();
		name.setBounds(170,20,150,40);
		name.setText(staff.getName()+" "+staff.getSurname());
		name.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		name.setForeground(Color.YELLOW);
		
		JLabel label2 = new JLabel("Mother Name: ");
		label2.setBounds(40, 70, 140, 40);
		label2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label2.setForeground(Color.YELLOW);
		motherName = new JTextField();
		motherName.setBounds(195,70,130,40);
		motherName.setText(staff.getMother_name());
		motherName.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		motherName.setForeground(Color.YELLOW);
		
		JLabel label3 = new JLabel("Birth Date: ");
		label3.setBounds(40, 120, 120, 40);
		label3.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label3.setForeground(Color.YELLOW);
		birthDate = new JTextField();
		birthDate.setBounds(170,120,200,40);
		birthDate.setText(staff.getBirth_date().toString());
		birthDate.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		birthDate.setForeground(Color.YELLOW);
		
		JLabel label4 = new JLabel("Birth Country: ");
		label4.setBounds(40, 170, 150, 40);
		label4.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label4.setForeground(Color.YELLOW);
		country = new JTextField();
		country.setBounds(200,170,150,40);
		country.setText(staff.getBirth_country());
		country.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		country.setForeground(Color.YELLOW);
		
		JLabel label5 = new JLabel("Birth Place: ");
		label5.setBounds(40, 220, 140, 40);
		label5.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label5.setForeground(Color.YELLOW);
		birthPlace = new JTextField();
		birthPlace.setBounds(185,220,150,40);
		birthPlace.setText(staff.getBirth_place());
		birthPlace.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		birthPlace.setForeground(Color.YELLOW);
		
		JLabel label6 = new JLabel("Nationality: ");
		label6.setBounds(40, 270, 135, 40);
		label6.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label6.setForeground(Color.YELLOW);
		nationality = new JTextField();
		nationality.setBounds(180,270,150,40);
		nationality.setText(staff.getNationality());
		nationality.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		nationality.setForeground(Color.YELLOW);
		
		JLabel label7 = new JLabel("Sex: ");
		label7.setBounds(40, 320, 60, 40);
		label7.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label7.setForeground(Color.YELLOW);
		sex = new JTextField();
		sex.setBounds(106,320,150,40);
		sex.setText(staff.getSex().toString().toLowerCase());
		sex.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		sex.setForeground(Color.YELLOW);
		
		JLabel label8 = new JLabel("Phone Number: ");
		label8.setBounds(40, 370, 160, 40);
		label8.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label8.setForeground(Color.YELLOW);
		phoneNum = new JTextField();
		phoneNum.setBounds(210,370,160,40);
		phoneNum.setText(staff.getPhoneNum());
		phoneNum.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		phoneNum.setForeground(Color.YELLOW);
		
		JLabel label9 = new JLabel("Email: ");
		label9.setBounds(40, 420, 80, 40);
		label9.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label9.setForeground(Color.YELLOW);
		email = new JTextField();
		email.setBounds(125,420,250,40);
		email.setText(staff.getEmail());
		email.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		email.setForeground(Color.YELLOW);
		
		JLabel label10 = new JLabel("Staff ID: ");
		label10.setBounds(500, 20, 110, 40);
		label10.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label10.setForeground(Color.YELLOW);
		staffID = new JTextField();
		staffID.setBounds(605,20,150,40);
		staffID.setText(String.valueOf(staff.getStaffID()));
		staffID.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		staffID.setForeground(Color.YELLOW);
		
		JLabel label11 = new JLabel("Department: ");
		label11.setBounds(500, 70, 130, 40);
		label11.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label11.setForeground(Color.YELLOW);
		department = new JTextField();
		department.setBounds(635,70,300,40);
		department.setHorizontalAlignment(JTextField.LEFT);
		department.setText(staff.getDepartment());
		department.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		department.setForeground(Color.YELLOW);
		
		JLabel label12 = new JLabel("Position: ");
		label12.setBounds(500, 120, 110, 40);
		label12.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label12.setForeground(Color.YELLOW);
		position = new JTextField();
		position.setBounds(615,120,150,40);
		position.setText(staff.getPosition().toString().toLowerCase());
		position.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		position.setForeground(Color.YELLOW);
		
		JLabel label13 = new JLabel("Bank Account: ");
		label13.setBounds(500, 170, 150, 40);
		label13.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label13.setForeground(Color.YELLOW);
		bankAccount = new JTextField();
		bankAccount.setBounds(665,170,150,40);
		bankAccount.setText(staff.getBankAccount());
		bankAccount.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		bankAccount.setForeground(Color.YELLOW);
		
		JLabel label14 = new JLabel("Start Date: ");
		label14.setBounds(500, 220, 140, 40);
		label14.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label14.setForeground(Color.YELLOW);
		startDate = new JTextField();
		startDate.setBounds(640,220,150,40);
		if(staff.getStartDate()!=null)
		startDate.setText(staff.getStartDate().toString());
		startDate.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		startDate.setForeground(Color.YELLOW);
		
		JLabel label15 = new JLabel("Salary: ");
		label15.setBounds(500, 270, 100, 40);
		label15.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label15.setForeground(Color.YELLOW);
		salary = new JTextField();
		salary.setBounds(605,270,150,40);
		salary.setText(String.valueOf(staff.getSalary()));
		salary.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		salary.setForeground(Color.YELLOW);
		
		JLabel label16 = new JLabel("Tax ID: ");
		label16.setBounds(500, 320, 80, 40);
		label16.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label16.setForeground(Color.YELLOW);
		taxID = new JTextField();
		taxID.setBounds(590,320,180,40);
		taxID.setText(String.valueOf(staff.getTaxID()));
		taxID.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		taxID.setForeground(Color.YELLOW);
		
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
		myDataPanel.add(staffID);
		myDataPanel.add(department);
		myDataPanel.add(position);
		myDataPanel.add(bankAccount);
		myDataPanel.add(startDate);
		myDataPanel.add(salary);
		myDataPanel.add(taxID);
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
		taxID.setEditable(flag);
		
		name.setBorder(null);
		motherName.setBorder(null);
		birthDate.setBorder(null);
		country.setBorder(null);
		birthPlace.setBorder(null);
		nationality.setBorder(null);
		sex.setBorder(null);
		phoneNum.setBorder(null);
		email.setBorder(null);
		staffID.setBorder(null);
		department.setBorder(null);
		position.setBorder(null);
		bankAccount.setBorder(null);
		startDate.setBorder(null);
		salary.setBorder(null);
		taxID.setBorder(null);
		
		if(flag) {
			name.setBackground(Color.LIGHT_GRAY);
			motherName.setBackground(Color.LIGHT_GRAY);
			country.setBackground(Color.LIGHT_GRAY);
			birthPlace.setBackground(Color.LIGHT_GRAY);
			nationality.setBackground(Color.LIGHT_GRAY);
			phoneNum.setBackground(Color.LIGHT_GRAY);
			email.setBackground(Color.LIGHT_GRAY);
			taxID.setBackground(Color.LIGHT_GRAY);
			name.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			motherName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			country.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			birthPlace.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			nationality.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			phoneNum.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			email.setBorder(BorderFactory.createLineBorder(Color.WHITE));
			taxID.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		}
		
		else {
			name.setBackground(Colors.staffAccountColor);
			motherName.setBackground(Colors.staffAccountColor);
			country.setBackground(Colors.staffAccountColor);
			birthPlace.setBackground(Colors.staffAccountColor);
			nationality.setBackground(Colors.staffAccountColor);
			phoneNum.setBackground(Colors.staffAccountColor);
			email.setBackground(Colors.staffAccountColor);
			taxID.setBackground(Colors.staffAccountColor);
		}
		birthDate.setBackground(Colors.staffAccountColor);
		sex.setBackground(Colors.staffAccountColor);
		staffID.setBackground(Colors.staffAccountColor);
		department.setBackground(Colors.staffAccountColor);
		position.setBackground(Colors.staffAccountColor);
		bankAccount.setBackground(Colors.staffAccountColor);
		startDate.setBackground(Colors.staffAccountColor);
		salary.setBackground(Colors.staffAccountColor);
	}

	private void setSubjects(Staff staff) {
		subjectsPane = new JTabbedPane();
		subjectsPane.setPreferredSize(new Dimension(1000,400));
		
		JLabel label1 = new JLabel("Register New Subjects");
		label1.setPreferredSize(new Dimension(300,40));
		label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		label1.setForeground(Colors.staffAccountColor);
		label1.setHorizontalAlignment(JLabel.CENTER);
		
		JLabel label2 = new JLabel("Department Subjects");
		label2.setPreferredSize(new Dimension(300,40));
		label2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		label2.setForeground(Colors.staffAccountColor);
		label2.setHorizontalAlignment(JLabel.CENTER);
		
		regSubjectsPanel = new JPanel();
		regSubjectsPanel.setPreferredSize(new Dimension(1000,370));
		regSubjectsPanel.setLayout(new BorderLayout());
		setRegSubjects(staff,regSubjectsPanel);
		subjectsPane.add(regSubjectsPanel);
		subjectsPane.setMnemonicAt(0, KeyEvent.VK_1);
		subjectsPane.setTabComponentAt(0, label2);
		
		registerPanel = new JPanel();
		registerPanel.setPreferredSize(new Dimension(1000,370));
		registerPanel.setLayout(new BorderLayout());
		setRegistration(staff,registerPanel);
		subjectsPane.add(registerPanel);
		subjectsPane.setMnemonicAt(1, KeyEvent.VK_2);
		subjectsPane.setTabComponentAt(1, label1);
		
		subjectsPane.setVisible(true);
		
		subjectsPanel.add(subjectsPane);
	}
	
	private void setRegistration(Staff staff,JPanel panel) {
		JPanel topPanel = new JPanel();
		topPanel.setBounds(10, 20, 1100, 60);
		topPanel.setPreferredSize(new Dimension(1100,60));
		topPanel.setBackground(Color.white);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,10));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.cyan);
		mainPanel.setLayout(null);
		mainPanel.setPreferredSize(new Dimension(1200,1400));
		
		JTextField subject = new JTextField("Subject Name");
		subject.setPreferredSize(new Dimension(200,40));
		subject.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		subject.setForeground(Color.LIGHT_GRAY);
		subject.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				subject.setText("");
				subject.setForeground(Color.blue);
			}
			
		});
		
		String[] languages = {"Language","Enslish","Hungarian","German"};
		JComboBox language = new JComboBox(languages);
		language.setPreferredSize(new Dimension(200,40));
		language.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		language.setForeground(Color.blue);
		
		JTextField credit = new JTextField("Credit");
		credit.setPreferredSize(new Dimension(200,40));
		credit.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		credit.setForeground(Color.LIGHT_GRAY);
		credit.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				credit.setText("");
				credit.setForeground(Color.blue);
			}
			
		});
		
		JTextField term = new JTextField("Number of Term");
		term.setPreferredSize(new Dimension(200,40));
		term.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		term.setForeground(Color.LIGHT_GRAY);
		term.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				term.setText("");
				term.setForeground(Color.blue);
			}
			
		});
		
		
		topPanel.add(subject);
		topPanel.add(language);
		topPanel.add(credit);
		topPanel.add(term);
		mainPanel.add(topPanel);
		
		scrollPaneSub = new JScrollPane();
		scrollPaneSub.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPaneSub.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneSub.setBackground(Color.green);
		scrollPaneSub.setOpaque(true);
		scrollPaneSub.setPreferredSize(new Dimension(1000,380));
		
		addedClasses = new ArrayList<ClassRoom>();
		
		height=80;
		JButton addClassButton = new JButton("Add Classroom");
		addClassButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		addClassButton.setBounds(40, 90, 180, 40);
		addClassButton.setIcon(new ImageIcon("icons/plusIcon.png"));
		addClassButton.setHorizontalTextPosition(SwingConstants.RIGHT);
		addClassButton.setBackground(Color.green);
		addClassButton.setFocusable(false);
		
		//Classrooms to add 
		List<ClassRoom> classrooms = new ArrayList<ClassRoom>();
		addClassButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				JLabel label = new JLabel("New Classroom");
				label.setBounds(10, height+10, 200, 40);
				label.setForeground(Color.blue);
				label.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,18));
				
				JPanel dataPanel = new JPanel();
				dataPanel.setBounds(10, height+55, 1100, 60);
				dataPanel.setBackground(Color.white);
				dataPanel.setLayout(new FlowLayout(FlowLayout.LEADING,11,10));
				
				String[] subjTypes = {"Subject Type","Lecture","Practice","Lab"};
				JComboBox subjType = new JComboBox(subjTypes);
				subjType.setPreferredSize(new Dimension(170,40));
				subjType.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
				subjType.setForeground(Color.blue);
				
				filteredStaffs = Controller.staffs.entrySet().stream().
									filter(s -> s.getValue().getDepartmentID()==accountOwner.
									getDepartmentID() && s.getValue().getPosition().equals(Staff.Position.TEACHER)).
									collect(Collectors.toList());
				String[] teachers = new String[filteredStaffs.size()+1];
				teachers[0]="Teacher";
				int index=1;
				for(Map.Entry<Integer, Staff> value : filteredStaffs) {
					teachers[index] = value.getValue().getName()+" "+value.getValue().getSurname();
					index++;
				}
				JComboBox teacher = new JComboBox(teachers);
				teacher.setPreferredSize(new Dimension(170,40));
				teacher.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
				teacher.setForeground(Color.blue);
				
				JTextField max = new JTextField("Max No.Students");
				max.setPreferredSize(new Dimension(170,40));
				max.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
				max.setForeground(Color.LIGHT_GRAY);
				max.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						max.setText("");
						max.setForeground(Color.blue);
					}
					
				});
				
				JTextField room = new JTextField("Room Number");
				room.setPreferredSize(new Dimension(170,40));
				room.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
				room.setForeground(Color.LIGHT_GRAY);
				room.addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						room.setText("");
						room.setForeground(Color.blue);
					}
					
				});
				
				String[] intervals = {"Time","8:15-10:00","10:15-12:00","12:15-14:00","14:15-16:00","16:15-18:00"};
				JComboBox interval = new JComboBox(intervals);
				interval.setPreferredSize(new Dimension(170,40));
				interval.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
				interval.setForeground(Color.blue);
				
				String[] weekDays = {"Weekday","Monday","Tuesday","Wednesday","Thursday","Friday"};
				JComboBox weekDay = new JComboBox(weekDays);
				weekDay.setPreferredSize(new Dimension(170,40));
				weekDay.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
				weekDay.setForeground(Color.blue);
				
				dataPanel.add(subjType);
				dataPanel.add(teacher);
				dataPanel.add(max);
				dataPanel.add(room);
				dataPanel.add(interval);
				dataPanel.add(weekDay);

				height+=115;
				
				addClassButton.setBounds(20,height+10 , 180, 40);
			
				mainPanel.add(label);
				mainPanel.add(dataPanel);
			}
			
		});
		
		mainPanel.add(addClassButton);
		scrollPaneSub.setViewportView(mainPanel);
		panel.add(scrollPaneSub,BorderLayout.NORTH);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(1000,60));
		bottomPanel.setBackground(Color.cyan);
		bottomPanel.setLayout(null);
		
		JButton delete = new JButton("CANCEL");
		delete.setBounds(550, 5, 150, 50);
		delete.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,18));
		delete.setBackground(Color.green);
		delete.setFocusable(false);
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setRegistration(staff,panel);
				
			}
			
		});
		
		JButton save = new JButton("SAVE");
		save.setBounds(720, 5, 150, 50);
		save.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,18));
		save.setBackground(Color.green);
		save.setFocusable(false);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(subject.getText()!=null && language.getSelectedIndex()>0 && credit.getText()!=null && term.getText()!=null) {
					Subject subjvalue = new Subject();
					subjvalue.setSubjectName(subject.getText());
					subjvalue.setCredit(Integer.valueOf(credit.getText()));
					subjvalue.setNoTerm(Integer.valueOf(term.getText()));
					if(language.getSelectedIndex()==1)
						subjvalue.setSubjectLanguage(Program.Language.ENGLISH);
					else if(language.getSelectedIndex()==3)
						subjvalue.setSubjectLanguage(Program.Language.GERMAN);
					else
						subjvalue.setSubjectLanguage(Program.Language.HUNGARIAN);
					
					int yPosition = 145;
					for(int i=2;i<mainPanel.getComponentCount();i+=2) {
						ClassRoom classroom = new ClassRoom();
						if(mainPanel.getComponentAt(10, yPosition)!=null) {
							JPanel component = (JPanel) mainPanel.getComponentAt(10, yPosition);
							JComboBox subje = (JComboBox) component.getComponent(0);
							JComboBox teacherData = (JComboBox) component.getComponent(1);
							JTextField maxNo = (JTextField) component.getComponent(2);
							JTextField room = (JTextField) component.getComponent(3);
							JComboBox timeint = (JComboBox) component.getComponent(4);
							JComboBox days = (JComboBox) component.getComponent(5);
							if(subje.getSelectedIndex()>0 && teacherData.getSelectedIndex()>0 && maxNo.getText()!=null
									&& room.getText()!=null && timeint.getSelectedIndex()>0 && days.getSelectedIndex()>0) {
								if(subje.getSelectedIndex()==2)
									classroom.setSubjectType(ClassRoom.SubjectType.PRACTICE);
								else if(subje.getSelectedIndex()==3)
									classroom.setSubjectType(ClassRoom.SubjectType.LAB);
								else
									classroom.setSubjectType(ClassRoom.SubjectType.LECTURE);
								
								classroom.setTeacherID(filteredStaffs.get(teacherData.getSelectedIndex()-1).getKey());
								classroom.setMaxStudentNum(Integer.valueOf(maxNo.getText()));
								classroom.setRoomNumber(room.getText());
								Schedule schedul = new Schedule();
								if(timeint.getSelectedIndex()==1) {
									schedul.setStartTime(LocalTime.of(8, 15));
									schedul.setFinishTime(LocalTime.of(10, 0));
								}
								else if(timeint.getSelectedIndex()==2) {
									schedul.setStartTime(LocalTime.of(10, 15));
									schedul.setFinishTime(LocalTime.of(12, 0));
								}
								else if(timeint.getSelectedIndex()==3) {
									schedul.setStartTime(LocalTime.of(12, 15));
									schedul.setFinishTime(LocalTime.of(14, 0));
								}
								else if(timeint.getSelectedIndex()==4) {
									schedul.setStartTime(LocalTime.of(14, 15));
									schedul.setFinishTime(LocalTime.of(16, 0));
								}
								else {
									schedul.setStartTime(LocalTime.of(16, 15));
									schedul.setFinishTime(LocalTime.of(18, 0));
								}
								
								if(days.getSelectedIndex()==1)
									schedul.setWeekDay(Schedule.WeekDay.MONDAY);
								else if(days.getSelectedIndex()==2)
									schedul.setWeekDay(Schedule.WeekDay.TUESDAY);
								else if(days.getSelectedIndex()==3)
									schedul.setWeekDay(Schedule.WeekDay.WEDNESDAY);
								else if(days.getSelectedIndex()==4)
									schedul.setWeekDay(Schedule.WeekDay.THURSDAY);
								else
									schedul.setWeekDay(Schedule.WeekDay.FRIDAY);
								
								classroom.setSchedule(schedul);
								classroom.setSubjectID(subjvalue.getSubjectID());
								classroom.setSubjectName(subjvalue.getSubjectName());
								Controller.staffs.get(classroom.getTeacherID()).setClassID(classroom.getClassRoomID());
								subjvalue.setClassID(classroom.getClassRoomID());
								Controller.classrooms.put(classroom.getClassRoomID(), classroom);
								ClassRoom.SaveAllData();
							}
						}
						yPosition+=115;
					}
					Controller.subjects.put(subjvalue.getSubjectID(), subjvalue);
					Subject.SaveAllData();
					Department temp =Controller.departments.get(accountOwner.getDepartmentID());
					temp.setSubjectID(subjvalue.getSubjectID());
					Controller.departments.replace(temp.getDepartmentID(), temp);
					Department.SaveAllData();
					setRegSubjects(staff,regSubjectsPanel);
					subjectsPane.setSelectedIndex(0);
				}
				else
					JOptionPane.showMessageDialog(frame, "Invalid input!");
				
			}
			
		});
		
		bottomPanel.add(delete);
		bottomPanel.add(save);
		panel.add(bottomPanel,BorderLayout.SOUTH);
	}
	
	private void setRegSubjects(Staff staff, JPanel panel) {
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
		
		if(Controller.departments.get(staff.getDepartmentID()).getSubjectIDs()!=null) {
			mainPanel.setPreferredSize(new Dimension(1000,Math.max(Controller.departments.get(staff.getDepartmentID()).getSubjectIDs().size()*50,400)));
		}
	if(Controller.departments.get(staff.getDepartmentID()).getSubjectIDs()!=null 
			&& Controller.departments.get(staff.getDepartmentID()).getSubjectIDs().size()>0) {
		for(int i: Controller.departments.get(staff.getDepartmentID()).getSubjectIDs()) {
			JPanel dataPanel = new JPanel();
			dataPanel.setPreferredSize(new Dimension(1000,40));
			dataPanel.setBackground(Color.white);
			dataPanel.setLayout(new FlowLayout());
			Subject subj = Controller.subjects.get(i);
			Subject subjToShowData = subj;
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
					moreFrame.setLocation(new Point(point.x-100,point.y-60));
					JButton addButton = new JButton("Add Classroom");
					addButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,12));
					addButton.setHorizontalTextPosition(SwingConstants.CENTER);
					addButton.setBounds(0,0,140,30);
					addButton.setBorder(null);
					addButton.setFocusable(false);
					addButton.setBackground(Color.green);
					addButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							moreFrame.dispose();
							JFrame addFrame = new JFrame();
							addFrame.setSize(new Dimension(1200,160));
							addFrame.setTitle("New Classroom");
							addFrame.setIconImage(logo.getImage());
							addFrame.setLayout(new BorderLayout());
							
							JPanel dataPanel = new JPanel();
							dataPanel.setPreferredSize(new Dimension(1100,60));
							dataPanel.setBackground(Color.white);
							dataPanel.setLayout(new FlowLayout(FlowLayout.LEADING,11,10));
							
							String[] subjTypes = {"Subject Type","Lecture","Practice","Lab"};
							JComboBox subjType = new JComboBox(subjTypes);
							subjType.setPreferredSize(new Dimension(170,40));
							subjType.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
							subjType.setForeground(Color.blue);
							
							filteredStaffs = Controller.staffs.entrySet().stream().
												filter(s -> s.getValue().getDepartmentID()==accountOwner.
												getDepartmentID() && s.getValue().getPosition().equals(Staff.Position.TEACHER)).
												collect(Collectors.toList());
							String[] teachers = new String[filteredStaffs.size()+1];
							teachers[0]="Teacher";
							int index=1;
							for(Map.Entry<Integer, Staff> value : filteredStaffs) {
								teachers[index] = value.getValue().getName()+" "+value.getValue().getSurname();
								index++;
							}
							JComboBox teacher = new JComboBox(teachers);
							teacher.setPreferredSize(new Dimension(170,40));
							teacher.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
							teacher.setForeground(Color.blue);
							
							JTextField max = new JTextField("Max No.Students");
							max.setPreferredSize(new Dimension(170,40));
							max.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
							max.setForeground(Color.LIGHT_GRAY);
							max.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent e) {
									max.setText("");
									max.setForeground(Color.blue);
								}
								
							});
							
							JTextField room = new JTextField("Room Number");
							room.setPreferredSize(new Dimension(170,40));
							room.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
							room.setForeground(Color.LIGHT_GRAY);
							room.addMouseListener(new MouseAdapter() {

								@Override
								public void mouseClicked(MouseEvent e) {
									room.setText("");
									room.setForeground(Color.blue);
								}
								
							});
							
							String[] intervals = {"Time","8:15-10:00","10:15-12:00","12:15-14:00","14:15-16:00","16:15-18:00"};
							JComboBox interval = new JComboBox(intervals);
							interval.setPreferredSize(new Dimension(170,40));
							interval.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
							interval.setForeground(Color.blue);
							
							String[] weekDays = {"Weekday","Monday","Tuesday","Wednesday","Thursday","Friday"};
							JComboBox weekDay = new JComboBox(weekDays);
							weekDay.setPreferredSize(new Dimension(170,40));
							weekDay.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
							weekDay.setForeground(Color.blue);
							
							dataPanel.add(subjType);
							dataPanel.add(teacher);
							dataPanel.add(max);
							dataPanel.add(room);
							dataPanel.add(interval);
							dataPanel.add(weekDay);
							
							JPanel bottomPanel = new JPanel();
							bottomPanel.setPreferredSize(new Dimension(1100,60));
							bottomPanel.setBackground(Color.cyan);
							bottomPanel.setLayout(null);
							
							JButton delete = new JButton("CANCEL");
							delete.setBounds(550, 5, 150, 50);
							delete.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,18));
							delete.setBackground(Color.green);
							delete.setFocusable(false);
							delete.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									addFrame.dispose();
									setRegSubjects(staff,panel);
									
								}
								
							});
							
							JButton save = new JButton("SAVE");
							save.setBounds(720, 5, 150, 50);
							save.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,18));
							save.setBackground(Color.green);
							save.setFocusable(false);
							save.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
										
											if(subjType.getSelectedIndex()>0 && teacher.getSelectedIndex()>0 && max.getText()!=null
														&& room.getText()!=null && interval.getSelectedIndex()>0 && weekDay.getSelectedIndex()>0) {
													ClassRoom classroom = new ClassRoom();
													if(subjType.getSelectedIndex()==2)
														classroom.setSubjectType(ClassRoom.SubjectType.PRACTICE);
													else if(subjType.getSelectedIndex()==3)
														classroom.setSubjectType(ClassRoom.SubjectType.LAB);
													else
														classroom.setSubjectType(ClassRoom.SubjectType.LECTURE);
													
													classroom.setTeacherID(filteredStaffs.get(teacher.getSelectedIndex()-1).getKey());
													classroom.setMaxStudentNum(Integer.valueOf(max.getText()));
													classroom.setRoomNumber(room.getText());
													Schedule schedul = new Schedule();
													if(interval.getSelectedIndex()==1) {
														schedul.setStartTime(LocalTime.of(8, 15));
														schedul.setFinishTime(LocalTime.of(10, 0));
													}
													else if(interval.getSelectedIndex()==2) {
														schedul.setStartTime(LocalTime.of(10, 15));
														schedul.setFinishTime(LocalTime.of(12, 0));
													}
													else if(interval.getSelectedIndex()==3) {
														schedul.setStartTime(LocalTime.of(12, 15));
														schedul.setFinishTime(LocalTime.of(14, 0));
													}
													else if(interval.getSelectedIndex()==4) {
														schedul.setStartTime(LocalTime.of(14, 15));
														schedul.setFinishTime(LocalTime.of(16, 0));
													}
													else {
														schedul.setStartTime(LocalTime.of(16, 15));
														schedul.setFinishTime(LocalTime.of(18, 0));
													}
													
													if(weekDay.getSelectedIndex()==1)
														schedul.setWeekDay(Schedule.WeekDay.MONDAY);
													else if(weekDay.getSelectedIndex()==2)
														schedul.setWeekDay(Schedule.WeekDay.TUESDAY);
													else if(weekDay.getSelectedIndex()==3)
														schedul.setWeekDay(Schedule.WeekDay.WEDNESDAY);
													else if(weekDay.getSelectedIndex()==4)
														schedul.setWeekDay(Schedule.WeekDay.THURSDAY);
													else
														schedul.setWeekDay(Schedule.WeekDay.FRIDAY);
													
													classroom.setSchedule(schedul);
													classroom.setSubjectID(subj.getSubjectID());
													classroom.setSubjectName(subj.getSubjectName());
													subj.setClassID(classroom.getClassRoomID());
													Controller.classrooms.put(classroom.getClassRoomID(), classroom);
													ClassRoom.SaveAllData();
													Controller.subjects.replace(subj.getSubjectID(), subj);
													Subject.SaveAllData();
													setRegSubjects(staff,regSubjectsPanel);
													subjectsPane.setSelectedIndex(0);
													addFrame.dispose();
										}
											else
												JOptionPane.showMessageDialog(addFrame, "Invalid Input");
									}
								
							});
							
							bottomPanel.add(delete);
							bottomPanel.add(save);
							addFrame.add(dataPanel,BorderLayout.NORTH);
							addFrame.add(bottomPanel,BorderLayout.SOUTH);
							addFrame.setVisible(true);
						}
					
					});
					
					JButton detailsButton = new JButton("Details");
					detailsButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,12));
					detailsButton.setBounds(0,30,140,30);
					detailsButton.setHorizontalTextPosition(SwingConstants.CENTER);
					detailsButton.setBorder(null);
					detailsButton.setFocusable(false);
					detailsButton.setBackground(Color.green);
					detailsButton.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							moreFrame.dispose();
							new SubjectDataFrame(subjToShowData);
							
						}
						
					});
					
					moreFrame.setBackground(Color.white);
					moreFrame.add(addButton);
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
		}
		scrollPaneSub.setViewportView(mainPanel);
		
		panel.add(topPanel,BorderLayout.NORTH);
		panel.add(scrollPaneSub,BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==editButton) {
			if(editing) {
				Staff staff = accountOwner;
				if(name.getText()!=null  && motherName.getText()!=null  
						&& country.getText()!=null 
						&& birthPlace.getText()!=null && nationality.getText()!=null && phoneNum.getText()!=null
						&& email.getText()!=null  && taxID.getText()!=null) {
					String fullName[] = name.getText().split("\\s+");
					staff.setName(fullName[0]);
					staff.setSurname(fullName[1]);
					staff.setMother_name(motherName.getText());
					staff.setBirth_country(country.getText());
					staff.setBirth_place(birthPlace.getText());
					staff.setNationality(nationality.getText());
					staff.setPhoneNum(phoneNum.getText());
					staff.setEmail(email.getText());
					staff.setTaxID(Integer.valueOf(taxID.getText()));
					
					
					if(Controller.staffs.containsKey(staff.getStaffID())) {
						Controller.staffs.replace(staff.getStaffID(), staff);
					}
					
					Staff.SaveAllData();
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
