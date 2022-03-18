package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.ClassRoom;
import main.Controller;
import main.GradeBook;
import main.Schedule;
import main.Staff;
import main.Student;
import main.Subject;

public class ChooseClassroomsFrame {
	JFrame frame;
	JScrollPane scrollPane;
	Set<ClassRoom.SubjectType> subjectTypes;
	
	public ChooseClassroomsFrame(Subject subject,Student student) {
		subjectTypes = new HashSet<ClassRoom.SubjectType>();
		frame = new JFrame();
		frame.setLayout(new BorderLayout());
		frame.setTitle("Register for Classrooms");
		ImageIcon logo = new ImageIcon("icons/logo.png");
		frame.setIconImage(logo.getImage());
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(1000,40));
		topPanel.setBackground(Color.cyan);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.yellow);
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setPreferredSize(new Dimension(980,400));
		
		JLabel label1 = new JLabel("   Instructor");
		label1.setPreferredSize(new Dimension(170,40));
		label1.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label2 = new JLabel("Subject Type");
		label2.setPreferredSize(new Dimension(170,40));
		label2.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label3 = new JLabel("Reg/Max Students");
		label3.setPreferredSize(new Dimension(170,40));
		label3.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label4 = new JLabel("Room");
		label4.setPreferredSize(new Dimension(170,40));
		label4.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		JLabel label5 = new JLabel("Schedule");
		label5.setPreferredSize(new Dimension(170,40));
		label5.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
		
		topPanel.add(label1);
		topPanel.add(label2);
		topPanel.add(label3);
		topPanel.add(label4);
		topPanel.add(label5);
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(Color.green);
		scrollPane.setOpaque(true);
		scrollPane.setPreferredSize(new Dimension(1000,350));
		
		if(subject.getClassIDs()!=null && subject.getClassIDs().size()>0) {
			mainPanel.setPreferredSize(new Dimension(1000,Math.max(subject.getClassIDs().size()*50,400)));
		}
		if(subject.getClassIDs()!=null)
		for(int i: subject.getClassIDs()) {
			JPanel dataPanel = new JPanel();
			dataPanel.setPreferredSize(new Dimension(970,40));
			dataPanel.setBackground(Color.white);
			dataPanel.setLayout(new FlowLayout());
			
			
			ClassRoom classroom =Controller.classrooms.get(i);
//					new ClassRoom("Calculus",123456,ClassRoom.SubjectType.LECTURE,new Staff("Rita","Gabor","abca",
//					LocalDate.now(),"IIT",1234),30,"IE_320",new HashSet<Schedule>());
//			classroom.setSchedule(new Schedule(Schedule.WeekDay.MONDAY,LocalTime.now(),LocalTime.NOON));
			
			String input = classroom.getTeacherName()+" "+classroom.getTeacherSurname();
			JLabel Label1 = new JLabel(input);
			Label1.setPreferredSize(new Dimension(170,40));
			Label1.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label1.setForeground(Color.blue);
			input = String.valueOf(classroom.getSubjectType());
			JLabel Label2 = new JLabel(input);
			Label2.setPreferredSize(new Dimension(170,40));
			Label2.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label2.setForeground(Color.red);
			String noStudents = classroom.getStudentIDs()!=null? String.valueOf(classroom.getStudentIDs().size()) : new String("0");
			input = String.valueOf(classroom.getMaxStudentNum())+"/"+ noStudents;
			JLabel Label3 = new JLabel(input);
			Label3.setPreferredSize(new Dimension(170,40));
			Label3.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label3.setForeground(Color.magenta);
			Label3.setHorizontalAlignment(JLabel.CENTER);
			
			input = "      "+classroom.getRoomNumber();
			JLabel Label4 = new JLabel(input);
			Label4.setPreferredSize(new Dimension(170,40));
			Label4.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label4.setForeground(Color.green);
			
			Schedule schedule = classroom.getSchedule().iterator().next();
			String timing = String.valueOf(schedule.getStartTime().getHour())+":"+
					String.valueOf(schedule.getStartTime().getMinute())+" - "+
					String.valueOf(schedule.getFinishTime().getHour())+":"+
					String.valueOf(schedule.getFinishTime().getMinute())+"  "+schedule.getWeekDay().toString().substring(0, 3);
			input = timing;
			JLabel Label5 = new JLabel(input);
			Label5.setPreferredSize(new Dimension(170,40));
			Label5.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,14));
			Label5.setForeground(Color.green);
			
			JCheckBox addBox = new JCheckBox();
			addBox.setPreferredSize(new Dimension(30,30));
			addBox.setBorder(null);
			addBox.setBackground(Color.black);
			addBox.setOpaque(false);
			addBox.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(addBox.isSelected()) {
						if(!subjectTypes.contains(classroom.getSubjectType())) {
							Controller.students.get(student.getStudentID()).setClassID(classroom.getClassRoomID());
							Controller.students.get(student.getStudentID()).setSubjectID(subject.getSubjectID());
							Controller.students.get(student.getStudentID()).setGradebookID(new GradeBook(classroom.getClassRoomID(),0));
							subjectTypes.add(classroom.getSubjectType());
						}
						else {
							JOptionPane.showMessageDialog(frame, "Please, unselect the classroom of the same subject type in order to register!",
									"Several occurances of the same subject type", JOptionPane.ERROR_MESSAGE);
						}
							
					}
					else {
						Controller.students.get(student.getStudentID()).getClassIDs().remove(classroom.getClassRoomID());
						Controller.students.get(student.getStudentID()).getGradebooks().remove(new GradeBook(classroom.getClassRoomID(),0));
						subjectTypes.remove(classroom.getSubjectType());
						if(subjectTypes.isEmpty())
							Controller.students.get(student.getStudentID()).getSubjectIDs().remove(subject.getSubjectID());
					}
				}
				
			});
			
			dataPanel.add(Label1);
			dataPanel.add(Label2);
			dataPanel.add(Label3);
			dataPanel.add(Label4);
			dataPanel.add(Label5);
			dataPanel.setBackground(Color.white);
			dataPanel.add(addBox);
		    
		    mainPanel.add(dataPanel);
		}
		scrollPane.setViewportView(mainPanel);
		
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(scrollPane,BorderLayout.CENTER);
		JPanel bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(1000,50));
		bottomPanel.setBackground(Color.cyan);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
		JButton saveButton = new JButton("SAVE");
		saveButton.setPreferredSize(new Dimension(120,40));
		saveButton.setBackground(Color.green);
		saveButton.setBorder(null);
		saveButton.setFocusable(false);
		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(subjectTypes.size());
				if(subjectTypes.size()>0 && subjectTypes.size()<=3) {
					frame.dispose();
					Student.SaveAllData();
				}
				else{
					JOptionPane.showMessageDialog(frame, "Please, select one classroom from each subject type in order to register!",
							"INCOMPLETE REGISTRATION", JOptionPane.ERROR_MESSAGE);
				}
					
			}
			
		});
		bottomPanel.add(saveButton);
		frame.add(bottomPanel,BorderLayout.SOUTH);
		
		frame.pack();
		frame.setVisible(true);
	}
}
