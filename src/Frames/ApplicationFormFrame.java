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
import java.util.Map;
import java.util.Optional;
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
import main.Student;
import values.Colors;



public class ApplicationFormFrame implements ActionListener {
	
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
	
	
	JPanel programInfoPanel;
	JComboBox startDate;
	String[] startDates;
	JComboBox program;
	String[] programsToShow; 
	ButtonGroup studyMode;
	JRadioButton partTimeButton;
	JRadioButton fullTimeButton;
	JRadioButton exchangeButton;
	ButtonGroup degree;
	JRadioButton bachelorButton;
	JRadioButton masterButton;
	JRadioButton phdButton;
	JTextField preinstutition;
	JTextField passwordText;
	JButton saveButton;
	JButton applyButton;
	
	public ApplicationFormFrame(){
		frame = new JFrame();
		frame.setTitle("Application Form");
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
		tabbedPane.addTab("  Program Info ", programInfoPanel);
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
		tabbedPane.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 24));
		tabbedPane.setForeground(Color.blue);
		tabbedPane.setBackground(Color.white);
		
		setLabels();
		frame.add(tabbedPane,BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	private void setLabels() {
		
		topPanel = new JPanel(new BorderLayout(80,0));
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
		
		label1 = new JLabel("Application for University");
		label1.setPreferredSize(new Dimension(800,60));
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
		sexLabel.setBounds(540, 90, 80, 50);
		male = new JCheckBox(" Male");
		male.setBounds(695,90, 100, 45);
		male.setFont(new Font(Font.SANS_SERIF,Font.BOLD | Font.ITALIC, 18));
		male.setBackground(Color.white);
		male.addActionListener(this);
		female = new JCheckBox(" Female");
		female.setBounds(805,90, 100, 45);
		female.setFont(new Font(Font.SANS_SERIF,Font.BOLD | Font.ITALIC, 18));
		female.setBackground(Color.white);
		female.addActionListener(this);
		personalInfoPanel.add(sexLabel);
		personalInfoPanel.add(male);
		personalInfoPanel.add(female);
		
		JLabel phoneLabel = new JLabel("Phone number*");
		phoneLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		phoneLabel.setBounds(540, 160, 150, 50);
		 phoneNumber = new JTextField();
		phoneNumber.setBounds(695,160, 200, 45);
		phoneNumber.setBorder(BorderFactory.createEtchedBorder());
		phoneNumber.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		phoneNumber.setHorizontalAlignment(JTextField.CENTER);
		personalInfoPanel.add(phoneLabel);
		personalInfoPanel.add(phoneNumber);
		
		JLabel emailLabel = new JLabel("Email*");
		emailLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		emailLabel.setBounds(540, 230, 135, 50);
		emailAddress = new JTextField("jsmith@example.com");
		emailAddress.setBounds(695,230, 200, 45);
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
		
		JLabel preinsLabel = new JLabel("Preinstitution*");
		preinsLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		preinsLabel.setBounds(250, 25, 150, 50);
		preinstutition = new JTextField();
		preinstutition.setBounds(410, 25, 250, 45);
		preinstutition.setBorder(BorderFactory.createEtchedBorder());
		preinstutition.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		preinstutition.setHorizontalAlignment(JTextField.CENTER);
		programInfoPanel.add(preinsLabel);
		programInfoPanel.add(preinstutition);
		
		JLabel degreeLabel = new JLabel("Degree*");
		degreeLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		degreeLabel.setBounds(250, 85, 80, 50);
		bachelorButton = new JRadioButton("Bachelor");
		bachelorButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 18));
		bachelorButton.setBounds(400,85,100,45);
		bachelorButton.setBackground(Color.white);
		bachelorButton.addActionListener(this);
		masterButton = new JRadioButton("Master");
		masterButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 18));
		masterButton.setBounds(510,85,100,45);
		masterButton.setBackground(Color.white);
		masterButton.addActionListener(this);
		phdButton = new JRadioButton("Phd");
		phdButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 18));
		phdButton.setBounds(620,85,100,45);
		phdButton.setBackground(Color.white);
		phdButton.addActionListener(this);
		
		degree = new ButtonGroup();
		degree.add(bachelorButton);
		degree.add(masterButton);
		degree.add(phdButton);
		
		programInfoPanel.add(degreeLabel);
		programInfoPanel.add(bachelorButton);
		programInfoPanel.add(masterButton);
		programInfoPanel.add(phdButton);
		
		programsToShow = new String[1];
		programsToShow[0] = "Please Select";
		JLabel programLabel = new JLabel("Program*");
		programLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		programLabel.setBounds(250, 145, 150, 50);
		program = new JComboBox(programsToShow);
		program.setBounds(410, 145, 250, 45);
		program.setBorder(BorderFactory.createEtchedBorder());
		program.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 20));
		program.setForeground(Color.DARK_GRAY);
		program.setBackground(Color.white);
		program.addActionListener(this);
		programInfoPanel.add(programLabel);
		programInfoPanel.add(program);
		
		JLabel modeLabel = new JLabel("Study Mode*");
		modeLabel.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 20));
		modeLabel.setBounds(250, 205, 120, 50);
		partTimeButton = new JRadioButton("Part-time");
		partTimeButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 18));
		partTimeButton.setBounds(400,205,100,45);
		partTimeButton.setBackground(Color.white);
		partTimeButton.addActionListener(this);
		fullTimeButton = new JRadioButton("Full-time");
		fullTimeButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 18));
		fullTimeButton.setBounds(510,205,100,45);
		fullTimeButton.setBackground(Color.white);
		fullTimeButton.addActionListener(this);
		exchangeButton = new JRadioButton("Exchange");
		exchangeButton.setFont(new Font(Font.SANS_SERIF,Font.ITALIC, 18));
		exchangeButton.setBounds(620,205,120,45);
		exchangeButton.setBackground(Color.white);
		exchangeButton.addActionListener(this);
		
		studyMode = new ButtonGroup();
		studyMode.add(fullTimeButton);
		studyMode.add(partTimeButton);
		studyMode.add(exchangeButton);
		
		programInfoPanel.add(modeLabel);
		programInfoPanel.add(fullTimeButton);
		programInfoPanel.add(partTimeButton);
		programInfoPanel.add(exchangeButton);
		
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
			new StudentLoginFrame();
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
		else if(e.getSource()==bachelorButton) {
			List<Map.Entry<Integer, Program>> selectedPrograms = Controller.programs.entrySet().stream().
	                filter(c -> c.getValue().GetDegree()==Program.Degree.BACHELOR).
	                collect(Collectors.toList());
			program.removeAllItems();
			program.insertItemAt("Please Select", 0);
			program.setSelectedIndex(0);
			
			for(int i=0; i<selectedPrograms.size();i++) {
				String strName = selectedPrograms.get(i).getValue().GetProgramName();
				if(selectedPrograms.get(i).getValue().GetLanguage()==Program.Language.ENGLISH) {
					strName = strName + " (English)";
				}
				else if(selectedPrograms.get(i).getValue().GetLanguage()==Program.Language.HUNGARIAN) {
					strName = strName + " (Hungarian)";
				}
				else if(selectedPrograms.get(i).getValue().GetLanguage()==Program.Language.GERMAN) {
					strName = strName + " (German)";
				}
				
				program.insertItemAt(strName,i+1);
				
			}
		}
		else if(e.getSource()==masterButton) {
			List<Map.Entry<Integer, Program>> selectedPrograms = Controller.programs.entrySet().stream().
	                filter(c -> c.getValue().GetDegree()==Program.Degree.MASTER).
	                collect(Collectors.toList());
			program.removeAllItems();
			program.insertItemAt("Please Select", 0);
			program.setSelectedIndex(0);
			
			for(int i=0; i<selectedPrograms.size();i++) {
				String strName = selectedPrograms.get(i).getValue().GetProgramName();
				if(selectedPrograms.get(i).getValue().GetLanguage()==Program.Language.ENGLISH) {
					strName = strName + " (English)";
				}
				else if(selectedPrograms.get(i).getValue().GetLanguage()==Program.Language.HUNGARIAN) {
					strName = strName + " (Hungarian)";
				}
				else if(selectedPrograms.get(i).getValue().GetLanguage()==Program.Language.GERMAN) {
					strName = strName + " (German)";
				}
				
				program.insertItemAt(strName,i+1);
				
			}
		}
		else if(e.getSource()==phdButton) {
			List<Map.Entry<Integer, Program>> selectedPrograms = Controller.programs.entrySet().stream().
	                filter(c -> c.getValue().GetDegree()==Program.Degree.PHD).
	                collect(Collectors.toList());
			program.removeAllItems();
			program.insertItemAt("Please Select", 0);
			program.setSelectedIndex(0);
			
			for(int i=0; i<selectedPrograms.size();i++) {
				String strName = selectedPrograms.get(i).getValue().GetProgramName();
				if(selectedPrograms.get(i).getValue().GetLanguage()==Program.Language.ENGLISH) {
					strName = strName + " (English)";
				}
				else if(selectedPrograms.get(i).getValue().GetLanguage()==Program.Language.HUNGARIAN) {
					strName = strName + " (Hungarian)";
				}
				else if(selectedPrograms.get(i).getValue().GetLanguage()==Program.Language.GERMAN) {
					strName = strName + " (German)";
				}
				
				program.insertItemAt(strName,i+1);
				
			}
		}
		else if(e.getSource()==applyButton) {
			Student student = new Student();
			if(firstName.getText()!=null && lastName.getText()!=null && motherName.getText()!=null && day.getText()!=null 
					&& month.getText()!=null && year.getText()!=null && countryName.getText()!=null 
					&& cityName.getText()!=null && nationalityName.getText()!=null && phoneNumber.getText()!=null
					&& emailAddress.getText()!=null && (male.isSelected() || female.isSelected()) && program.getSelectedIndex()>0
					&& studyMode.getSelection()!=null && degree.getSelection()!=null && preinstutition.getText()!=null
					&& passwordText.getText()!=null) {
				student.setName(firstName.getText());
				student.setSurname(lastName.getText());
				student.setMother_name(motherName.getText());
				LocalDate birthDate = LocalDate.of(Integer.valueOf(year.getText()), Integer.valueOf(month.getText()),
						Integer.valueOf(day.getText()));
				student.setBirth_date(birthDate);
				student.setBirth_country(countryName.getText());
				student.setBirth_place(cityName.getText());
				student.setNationality(nationalityName.getText());
				student.setParentNum(phoneNumber.getText());
				student.setEmail(emailAddress.getText());
				student.setSex(male.isSelected()? Student.Sex.MALE : Student.Sex.FEMALE);
				student.setProgramName(program.getSelectedItem().toString());
				Student.StudyMode mode;
				if(partTimeButton.isSelected())
					mode = Student.StudyMode.PART_TIME;
				else if(exchangeButton.isSelected())
					mode = Student.StudyMode.EXCHANGE;
				else 
					mode = Student.StudyMode.FULL_TIME;
				student.setStudyMode(mode);
				Program.Degree degreeSel;
				if(phdButton.isSelected())
					degreeSel = Program.Degree.PHD;
				else if(masterButton.isSelected())
					degreeSel = Program.Degree.MASTER;
				else 
					degreeSel = Program.Degree.BACHELOR;
				student.setDegree(degreeSel);
				student.setPreInstutition(preinstutition.getText());
				if(startDate.getSelectedIndex()==0)
					student.setStartDate(LocalDate.of(2021,2,1));
				else
					student.setStartDate(LocalDate.of(2021,9,1));
				student.setPassword(passwordText.getText());
				JOptionPane.showConfirmDialog(frame, (Object) "Your Neptun Code: "+student.getLoginName(), "HERE IS NEPTUN CODE!",
						JOptionPane.PLAIN_MESSAGE);
				Controller.students.put(student.getStudentID(),student);
				Student.SaveAllData();
				frame.dispose();
				new StudentLoginFrame();
			}
			else
				JOptionPane.showMessageDialog(frame, (Object) "Please fill out all necessary fields with *", "INCOMPLETE FORM",
						JOptionPane.PLAIN_MESSAGE);
				
		}
		
	}

}
