package Frames;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainFrame implements ActionListener{
	
	JFrame frame;
	JPanel topPanel;
	JPanel bottomPanel;
	JButton buttonStudent;
	JButton buttonStaff;
	JLabel label;
	public MainFrame(){
		//creating frame
		frame = new JFrame();
		frame.setTitle("University Management System");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(50,50));
		
		//creating a top panel for the label
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(1000,150));
		topPanel.setBackground(new Color(0x123456));
		topPanel.setLayout(new BorderLayout());
		
		//creating a bottom panel for account buttons
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(1000,450));
		bottomPanel.setBackground(new Color(0x123456));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,120,10));
		
		//creating a student account button
		buttonStudent = new JButton();
		buttonStudent.setText("Student Account");
		buttonStudent.setHorizontalTextPosition(JButton.CENTER);
		buttonStudent.setVerticalTextPosition(JButton.BOTTOM);
		buttonStudent.setIconTextGap(20);
		buttonStudent.setFont(new Font(Font.SERIF,Font.BOLD,20));
		buttonStudent.setFocusable(false);
		buttonStudent.setOpaque(true);
		buttonStudent.setSize(250, 300);
		buttonStudent.setBorder(BorderFactory.createEtchedBorder(Color.cyan, Color.gray));
		ImageIcon studentIcon = new ImageIcon("icons/student.png");
		buttonStudent.setIcon(studentIcon);
		buttonStudent.addActionListener(this);
		
		//creating a staff account button
		buttonStaff = new JButton();
		buttonStaff.setText("Staff Account");
		buttonStaff.setHorizontalTextPosition(JButton.CENTER);
		buttonStaff.setVerticalTextPosition(JButton.BOTTOM);
		buttonStaff.setIconTextGap(20);
		buttonStaff.setFont(new Font(Font.SERIF,Font.BOLD,20));
		buttonStaff.setFocusable(false);
		buttonStaff.setOpaque(true);
		buttonStaff.setSize(250,300);
		buttonStaff.setBorder(BorderFactory.createEtchedBorder(Color.cyan, Color.gray));
		ImageIcon staffIcon = new ImageIcon("icons/staff.png");
		buttonStaff.setIcon(staffIcon);
		buttonStaff.addActionListener(this);
		
		//creating label for salutaion
		label = new JLabel();
		label.setText("Welcome to University Management System!");
		label.setForeground(Color.YELLOW);
		label.setFont(new Font(Font.SERIF,Font.HANGING_BASELINE,28));
		label.setOpaque(false);
		label.setSize(600,100);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		
		topPanel.add(label);
		bottomPanel.add(buttonStudent);
		bottomPanel.add(buttonStaff);
		
		ImageIcon logo = new ImageIcon("icons/logo.png");
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setBackground(new Color(0x123456));
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(bottomPanel,BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==buttonStudent) {
			new StudentLoginFrame();
			frame.dispose();
		}
		else if(e.getSource()==buttonStaff) {
			new StaffLoginFrame();
			frame.dispose();
		}
	}

}
