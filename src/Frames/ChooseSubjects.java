package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import main.Controller;
import main.Program;
import main.Subject;
import values.Colors;

public class ChooseSubjects {
	
	JFrame frame;
	JScrollPane scrollPaneSub;
	JFrame moreFrame;
	JPanel panel;

	public ChooseSubjects(Program program) {
		
		frame = new JFrame();
		frame.setTitle("Select Subjects");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(50,50));
		ImageIcon logo = new ImageIcon("icons/logo.png");
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setBackground(Colors.studentAccountColor);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000,500));
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.cyan);
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
							program.SetSubjects(subj);
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
							new SubjectDataFrame(subj);
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
		JButton save = new JButton("SAVE");
		save.setPreferredSize(new Dimension(150,50));
		save.setFont(new Font(Font.DIALOG,Font.BOLD | Font.ITALIC,18));
		save.setBackground(Color.green);
		save.setFocusable(false);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		
		});
		scrollPaneSub.setViewportView(mainPanel);
		
		panel.add(topPanel,BorderLayout.NORTH);
		panel.add(scrollPaneSub,BorderLayout.CENTER);
		panel.add(save,BorderLayout.SOUTH);
		
		frame.add(panel);
		frame.pack();

		frame.setVisible(true);
	}
}
