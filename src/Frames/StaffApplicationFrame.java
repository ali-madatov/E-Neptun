package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
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
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import main.Controller;
import main.Program;
import main.Staff;
import main.Student;
import values.Colors;



public class StaffApplicationFrame implements ActionListener {
	
	JFrame frame;
	JPanel topPanel;
	JButton backButton;
	JLabel label1;
	JLabel label2;
	JTabbedPane tabbedPane;
	
	JPanel personalInfoPanel;
	JTextField firstName;
	JTextField lastName;
	JTextField motherName;
	JTextField day;
	JTextField month;
	JTextField year;
	JTextField countryName;
	JTextField cityName;
	JTextField nationalityName;
	JTextField phoneNumber;
	JTextField emailAddress;
	JCheckBox male;
	JCheckBox female;
	JTextField taxID;
	
	
	JPanel programInfoPanel;
	JComboBox<String> startDate;
	String[] startDates;
	JComboBox<String> department;
	String[] departmentsToShow; 
	ButtonGroup position;
	JRadioButton headButton;
	JRadioButton teacherButton;
	JRadioButton technicalButton;
	JTextField bankAccount;
	JTextField salary;
	JTextField passwordText;
	JButton saveButton;
	JButton applyButton;
	
	public StaffApplicationFrame(){
		frame = new JFrame();
		frame.setTitle("Employment Application Form");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		ImageIcon logo = new ImageIcon("icons/logo.png");
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setBackground(Colors.backgroundColor);
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setPreferredSize(new Dimension(1000,520));

		setPersonalInfoPanel();
		tabbedPane.addTab("  Personal Info  ", personalInfoPanel);
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		setProgramInfoPanel();
		tabbedPane.addTab("  Position Info ", programInfoPanel);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabbedPane.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		tabbedPane.setForeground(Color.blue);
		tabbedPane.setBackground(Color.white);
		
		setLabels();
		frame.add(tabbedPane,BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	private void setLabels() {
		
		topPanel = new JPanel(new BorderLayout(30,0));
		topPanel.setPreferredSize(new Dimension(1000,60));
		topPanel.setBackground(Colors.backgroundColor);
		
		backButton = new JButton();
		backButton.setPreferredSize(new Dimension(120,40));
		backButton.setText("Back");
		backButton.setForeground(Color.YELLOW);
		backButton.setBackground(Colors.backgroundColor);
		backButton.setFocusable(false);
		backButton.setHorizontalTextPosition(JButton.RIGHT);
		backButton.setVerticalTextPosition(JButton.CENTER);
		backButton.setFont(new Font(Font.SERIF,Font.ITALIC,30));
		ImageIcon backIcon = new ImageIcon("icons/backIcon.png");
		backButton.setIcon(backIcon);
		backButton.setIconTextGap(10);
		backButton.setBounds(10,10, 160, 40);
		backButton.setOpaque(false);
		backButton.addActionListener(this);
		backButton.setBorder(null);
		
		label1 = new JLabel("Staff Application for University");
		label1.setPreferredSize(new Dimension(850,60));
		label1.setHorizontalAlignment(JLabel.LEFT);
		label1.setVerticalAlignment(JLabel.CENTER);
		label1.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 28));
		label1.setForeground(Color.YELLOW);
		
		topPanel.add(backButton,BorderLayout.WEST);
		topPanel.add(label1,BorderLayout.EAST);
		
		label2 = new JLabel("Please fill out the application form carefully");
		label2.setPreferredSize(new Dimension(1000,60));
		label2.setHorizontalAlignment(JLabel.CENTER);
		label2.setVerticalAlignment(JLabel.TOP);
		label2.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		label2.setForeground(Color.YELLOW);
		
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(label2,BorderLayout.CENTER);
	}
	
	private void setPersonalInfoPanel() {
		personalInfoPanel = new JPanel();
		personalInfoPanel.setPreferredSize(new Dimension(200,80));
		personalInfoPanel.setBackground(Color.white);
		personalInfoPanel.setBorder(null);
		personalInfoPanel.setLayout(null);
		
		JLabel nameLabel = new JLabel("First Name*");
		nameLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		nameLabel.setBounds(25, 20, 150, 50);
		 firstName = new JTextField();
		firstName.setBounds(185, 20, 200, 45);
		firstName.setBorder(BorderFactory.createEtchedBorder());
		firstName.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		firstName.setHorizontalAlignment(JTextField.CENTER);
		personalInfoPanel.add(nameLabel);
		personalInfoPanel.add(firstName);
		
		JLabel surnameLabel = new JLabel("Last Name*");
		surnameLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		surnameLabel.setBounds(25, 90, 150, 50);
		 lastName = new JTextField();
		lastName.setBounds(185, 90, 200, 45);
		lastName.setBorder(BorderFactory.createEtchedBorder());
		lastName.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		lastName.setHorizontalAlignment(JTextField.CENTER);
		personalInfoPanel.add(surnameLabel);
		personalInfoPanel.add(lastName);
		
		JLabel motherNameLabel = new JLabel("Mother Name*");
		motherNameLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		motherNameLabel.setBounds(25, 150, 160, 50);
		 motherName = new JTextField();
		motherName.setBounds(185, 150, 200, 45);
		motherName.setBorder(BorderFactory.createEtchedBorder());
		motherName.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		motherName.setHorizontalAlignment(JTextField.CENTER);
		personalInfoPanel.add(motherNameLabel);
		personalInfoPanel.add(motherName);
		
		JLabel birthDateLabel = new JLabel("Birth Date*");
		birthDateLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		birthDateLabel.setBounds(25, 210, 160, 50);
		 day = new JTextField("DD");
		day.setBounds(185, 210, 53, 45);
		day.setBorder(BorderFactory.createEtchedBorder());
		day.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		day.setHorizontalAlignment(JTextField.CENTER);
		day.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				day.setText("");
				
			}

			
		});
		
		 month = new JTextField("MM");
		month.setBounds(243, 210, 53, 45);
		month.setBorder(BorderFactory.createEtchedBorder());
		month.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		month.setHorizontalAlignment(JTextField.CENTER);
		month.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				month.setText("");
				
			}

			
		});
		
		 year = new JTextField("YYYY");
		year.setBounds(301, 210, 84, 45);
		year.setBorder(BorderFactory.createEtchedBorder());
		year.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		year.setHorizontalAlignment(JTextField.CENTER);
		year.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				year.setText("");
				
			}

			
		});
		personalInfoPanel.add(birthDateLabel);
		personalInfoPanel.add(day);
		personalInfoPanel.add(month);
		personalInfoPanel.add(year);
		
		JLabel countryLabel = new JLabel("Birth Country*");
		countryLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		countryLabel.setBounds(25, 270, 160, 50);
		 countryName = new JTextField();
		countryName.setBounds(185,270, 200, 45);
		countryName.setBorder(BorderFactory.createEtchedBorder());
		countryName.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		countryName.setHorizontalAlignment(JTextField.CENTER);
		personalInfoPanel.add(countryLabel);
		personalInfoPanel.add(countryName);
		
		JLabel cityLabel = new JLabel("Birth Place*");
		cityLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		cityLabel.setBounds(25, 330, 135, 50);
		 cityName = new JTextField();
		cityName.setBounds(185,330, 200, 45);
		cityName.setBorder(BorderFactory.createEtchedBorder());
		cityName.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		cityName.setHorizontalAlignment(JTextField.CENTER);
		personalInfoPanel.add(cityLabel);
		personalInfoPanel.add(cityName);
		
		JLabel nationalityLabel = new JLabel("Nationality*");
		nationalityLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		nationalityLabel.setBounds(540, 20, 135, 50);
		 nationalityName = new JTextField();
		nationalityName.setBounds(695,20, 200, 45);
		nationalityName.setBorder(BorderFactory.createEtchedBorder());
		nationalityName.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		nationalityName.setHorizontalAlignment(JTextField.CENTER);
		personalInfoPanel.add(nationalityLabel);
		personalInfoPanel.add(nationalityName);
		
		JLabel sexLabel = new JLabel("Sex*");
		sexLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		sexLabel.setBounds(540, 80, 80, 50);
		male = new JCheckBox(" Male");
		male.setBounds(695,80, 100, 45);
		male.setFont(new Font(Font.SANS_SERIF,Font.BOLD | Font.ITALIC, 18));
		male.setBackground(Color.white);
		male.addActionListener(this);
		female = new JCheckBox(" Female");
		female.setBounds(805,80, 100, 45);
		female.setFont(new Font(Font.SANS_SERIF,Font.BOLD | Font.ITALIC, 18));
		female.setBackground(Color.white);
		female.addActionListener(this);
		personalInfoPanel.add(sexLabel);
		personalInfoPanel.add(male);
		personalInfoPanel.add(female);
		
		JLabel phoneLabel = new JLabel("Phone number*");
		phoneLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		phoneLabel.setBounds(540, 140, 150, 50);
		 phoneNumber = new JTextField();
		phoneNumber.setBounds(695,140, 200, 45);
		phoneNumber.setBorder(BorderFactory.createEtchedBorder());
		phoneNumber.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		phoneNumber.setHorizontalAlignment(JTextField.CENTER);
		personalInfoPanel.add(phoneLabel);
		personalInfoPanel.add(phoneNumber);
		
		JLabel taxIDLabel = new JLabel("Tax ID*");
		taxIDLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		taxIDLabel.setBounds(540, 200, 150, 50);
		taxID = new JTextField();
		taxID.setBounds(695,200, 200, 45);
		taxID.setBorder(BorderFactory.createEtchedBorder());
		taxID.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		taxID.setHorizontalAlignment(JTextField.CENTER);
		personalInfoPanel.add(taxIDLabel);
		personalInfoPanel.add(taxID);
		
		JLabel emailLabel = new JLabel("Email*");
		emailLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		emailLabel.setBounds(540, 260, 135, 50);
		emailAddress = new JTextField("jsmith@example.com");
		emailAddress.setBounds(695,260, 200, 45);
		emailAddress.setBorder(BorderFactory.createEtchedBorder());
		emailAddress.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 16));
		emailAddress.setForeground(Color.gray);
		emailAddress.setHorizontalAlignment(JTextField.CENTER);
		emailAddress.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				emailAddress.setText("");
				emailAddress.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
				emailAddress.setForeground(Color.black);
				
			}

			
		});
		personalInfoPanel.add(emailLabel);
		personalInfoPanel.add(emailAddress);
		
		saveButton = new JButton("SAVE & NEXT");
		saveButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC, 22));
		saveButton.setBounds(950,380,180,40);
		saveButton.addActionListener(this);
		saveButton.setOpaque(true);
		saveButton.setBackground(Color.GREEN);
		personalInfoPanel.add(saveButton);
		
	}
	
	private void setProgramInfoPanel() {
		programInfoPanel = new JPanel();
		programInfoPanel.setPreferredSize(new Dimension(200,80));
		programInfoPanel.setBackground(Color.white);
		programInfoPanel.setBorder(null);
		programInfoPanel.setLayout(null);
		
		departmentsToShow = new String[Controller.departments.size()+1];
		departmentsToShow[0] = "Please Select";
		for(int i=0; i<Controller.departments.size();i++) {
			departmentsToShow[i+1]=Controller.departments.entrySet().iterator().next().getValue().getDepartmentName();
		}
		JLabel departmentLabel = new JLabel("Department*");
		departmentLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		departmentLabel.setBounds(250, 25, 150, 50);
		department = new JComboBox(departmentsToShow);
		department.setBounds(410, 25, 250, 45);
		department.setBorder(BorderFactory.createEtchedBorder());
		department.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		department.setForeground(Color.DARK_GRAY);
		department.setBackground(Color.white);
		department.addActionListener(this);
		programInfoPanel.add(departmentLabel);
		programInfoPanel.add(department);
		
		
		JLabel positionLabel = new JLabel("Position*");
		positionLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		positionLabel.setBounds(250, 85, 100, 50);
		headButton = new JRadioButton("Head");
		headButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 18));
		headButton.setBounds(400,85,70,45);
		headButton.setBackground(Color.white);
		headButton.addActionListener(this);
		teacherButton = new JRadioButton("Teacher");
		teacherButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 18));
		teacherButton.setBounds(480,85,100,45);
		teacherButton.setBackground(Color.white);
		teacherButton.addActionListener(this);
		technicalButton = new JRadioButton("Technical");
		technicalButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 18));
		technicalButton.setBounds(590,85,120,45);
		technicalButton.setBackground(Color.white);
		technicalButton.addActionListener(this);
		
		position = new ButtonGroup();
		position.add(headButton);
		position.add(teacherButton);
		position.add(technicalButton);
		
		programInfoPanel.add(positionLabel);
		programInfoPanel.add(headButton);
		programInfoPanel.add(teacherButton);
		programInfoPanel.add(technicalButton);
		
		JLabel salaryLabel = new JLabel("Exp. Salary*");
		salaryLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		salaryLabel.setBounds(250, 145, 150, 50);
		salary = new JTextField();
		salary.setBounds(410, 145, 250, 45);
		salary.setBorder(BorderFactory.createEtchedBorder());
		salary.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		salary.setHorizontalAlignment(JTextField.CENTER);
		programInfoPanel.add(salaryLabel);
		programInfoPanel.add(salary);
		
		JLabel bankAccountLabel = new JLabel("Bank Account*");
		bankAccountLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		bankAccountLabel.setBounds(250, 205, 150, 50);
		bankAccount = new JTextField();
		bankAccount.setBounds(410, 205, 250, 45);
		bankAccount.setBorder(BorderFactory.createEtchedBorder());
		bankAccount.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		bankAccount.setHorizontalAlignment(JTextField.CENTER);
		programInfoPanel.add(bankAccountLabel);
		programInfoPanel.add(bankAccount);
		
		startDates = new String[2];
		startDates[0] = "2020/2021-Spring";
		startDates[1] = "2021/2022-Autumn";
		JLabel periodLabel = new JLabel("Start Period*");
		periodLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		periodLabel.setBounds(250, 265, 150, 50);
		startDate = new JComboBox(startDates);
		startDate.setBounds(410, 265, 250, 45);
		startDate.setBorder(BorderFactory.createEtchedBorder());
		startDate.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		startDate.setForeground(Color.DARK_GRAY);
		startDate.setBackground(Color.white);
		startDate.addActionListener(this);
		programInfoPanel.add(periodLabel);
		programInfoPanel.add(startDate);
		
		JLabel passwordLabel = new JLabel("Password*");
		passwordLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		passwordLabel.setBounds(250, 325, 150, 50);
		passwordText = new JTextField();
		passwordText.setBounds(410, 330, 250, 40);
		passwordText.setBorder(BorderFactory.createEtchedBorder());
		passwordText.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		passwordText.setHorizontalAlignment(JTextField.CENTER);
		programInfoPanel.add(passwordLabel);
		programInfoPanel.add(passwordText);
		
		applyButton = new JButton("APPLY");
		applyButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC, 22));
		applyButton.setBounds(800,360,130,40);
		applyButton.addActionListener(this);
		applyButton.setOpaque(true);
		applyButton.setBackground(Color.GREEN);
		applyButton.setFocusable(false);
		programInfoPanel.add(applyButton);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			new StaffLoginFrame();
			frame.dispose();
		}
		else if(e.getSource()==saveButton) {
			tabbedPane.setSelectedIndex(1);
		}
		else if(e.getSource()==male) {
			female.setSelected(false);
		}
		else if(e.getSource()==female) {
			male.setSelected(false);
		}
		
		
		
		else if(e.getSource()==applyButton) {
			Staff staff = new Staff();
			if(firstName.getText()!=null && lastName.getText()!=null && motherName.getText()!=null && day.getText()!=null 
					&& month.getText()!=null && year.getText()!=null && countryName.getText()!=null 
					&& cityName.getText()!=null && nationalityName.getText()!=null && phoneNumber.getText()!=null
					&& emailAddress.getText()!=null && (male.isSelected() || female.isSelected()) && taxID.getText()!=null
					&& department.getSelectedIndex()>0
					&& position.getSelection()!=null && salary.getText()!=null && bankAccount.getText()!=null
					&& passwordText.getText()!=null) {
				staff.setName(firstName.getText());
				staff.setSurname(lastName.getText());
				staff.setMother_name(motherName.getText());
				LocalDate birthDate = LocalDate.of(Integer.valueOf(year.getText()), Integer.valueOf(month.getText()),
						Integer.valueOf(day.getText()));
				staff.setBirth_date(birthDate);
				staff.setBirth_country(countryName.getText());
				staff.setBirth_place(cityName.getText());
				staff.setNationality(nationalityName.getText());
				staff.setPhoneNum(phoneNumber.getText());
				staff.setEmail(emailAddress.getText());
				staff.setSex(male.isSelected()? Student.Sex.MALE : Student.Sex.FEMALE);
				staff.setTaxID(Integer.valueOf(taxID.getText()));
				String departmentNameValue = department.getItemAt(department.getSelectedIndex());
				staff.setDepartment(departmentNameValue);
				Staff.Position position;
				if(headButton.isSelected())
					position = Staff.Position.HEAD;
				else if(teacherButton.isSelected())
					position = Staff.Position.TEACHER;
				else 
					position = Staff.Position.TECHNICAL;
				staff.setPosition(position);
				staff.setSalary(Integer.valueOf(salary.getText()));
				staff.setBankAccount(bankAccount.getText());
				staff.setPassword(passwordText.getText());
				if(startDate.getSelectedIndex()==0)
					staff.setStartDate(LocalDate.of(2021,2,1));
				else
					staff.setStartDate(LocalDate.of(2021,9,1));
				JOptionPane.showConfirmDialog(frame, (Object) "Your Neptun Code: "+staff.getLoginName(), "HERE IS NEPTUN CODE!",
						JOptionPane.PLAIN_MESSAGE);
				Controller.staffs.put(staff.getStaffID(),staff);
				Staff.SaveAllData();
				frame.dispose();
				new StaffLoginFrame();
			}
			else
				JOptionPane.showMessageDialog(frame, (Object) "Please fill out all necessary fields with *", "INCOMPLETE FORM",
						JOptionPane.PLAIN_MESSAGE);
				
		}
		
	}

}
