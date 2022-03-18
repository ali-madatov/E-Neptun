package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.SwingConstants;

import main.ClassRoom;
import main.Controller;
import main.GradeBook;
import main.Schedule;
import main.Student;
import main.Staff;

public class TeacherClassesFrame {
	JFrame frame;
	JScrollPane scrollPane;
	JFrame moreFrame;
	
	public TeacherClassesFrame(Staff staff, JPanel panel) {
		panel.setLayout(new BorderLayout());
		JPanel topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(1000,40));
		topPanel.setBackground(Color.cyan);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,0));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.yellow);
		mainPanel.setLayout(new FlowLayout());
		mainPanel.setPreferredSize(new Dimension(980,400));
		
		JLabel label1 = new JLabel("   Subject Name");
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
		scrollPane.setPreferredSize(new Dimension(1000,400));
		
		if(staff.getClassIDs()!=null && staff.getClassIDs().size()>0) {
			mainPanel.setPreferredSize(new Dimension(1000,Math.max(staff.getClassIDs().size()*60,400)));
		}
		if(staff.getClassIDs()!=null)
		for(int i: staff.getClassIDs()) {
			JPanel dataPanel = new JPanel();
			dataPanel.setPreferredSize(new Dimension(1000,40));
			dataPanel.setBackground(Color.white);
			dataPanel.setLayout(new FlowLayout());
			
			
			ClassRoom classroom =Controller.classrooms.get(i);
//					new ClassRoom("Calculus",123456,ClassRoom.StaffType.LECTURE,new Staff("Rita","Gabor","abca",
//					LocalDate.now(),"IIT",1234),30,"IE_320",new HashSet<Schedule>());
//			classroom.setSchedule(new Schedule(Schedule.WeekDay.MONDAY,LocalTime.now(),LocalTime.NOON));
			
			String input = classroom.getSubjectName();
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
					// TODO Auto-generated method stub
					if(moreFrame!=null && moreFrame.isVisible())
						moreFrame.dispose();
					moreFrame = new JFrame();
					moreFrame.setSize(new Dimension(120,30));
					moreFrame.setUndecorated(true);
					moreFrame.setLayout(null);
					Point point = moreButton.getLocationOnScreen();
					moreFrame.setLocation(new Point(point.x-80,point.y-30));
					JButton addButton = new JButton("Set GradeBooks");
					addButton.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,12));
					addButton.setHorizontalTextPosition(SwingConstants.CENTER);
					addButton.setBounds(0,0,140,30);
					addButton.setBorder(null);
					addButton.setFocusable(false);
					addButton.setBackground(Color.green);
					moreFrame.add(addButton);
					moreFrame.setVisible(true);
				}
			
			});
			
			dataPanel.add(Label1);
			dataPanel.add(Label2);
			dataPanel.add(Label3);
			dataPanel.add(Label4);
			dataPanel.add(Label5);
			dataPanel.add(moreButton);
			dataPanel.setBackground(Color.white);
		    
		    mainPanel.add(dataPanel);
		}
		scrollPane.setViewportView(mainPanel);
		
		panel.add(topPanel,BorderLayout.NORTH);
		panel.add(scrollPane,BorderLayout.SOUTH);
		
		
	}
}
