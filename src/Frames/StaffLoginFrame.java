package Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;
import java.util.Optional;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import main.Controller;
import main.Staff;
import main.Student;
import values.Colors;

public class StaffLoginFrame implements ActionListener{
	JFrame frame;
	JButton backButton;
	JPanel topPanel;
	JPanel bottomPanel;
	JPanel innerPanel;
	JLabel loginLabel;
	JPanel emailPanel;
	JTextField emailText;
	JPanel passwordPanel;
	JPasswordField passwordText;
	JPanel registerPanel;
	JLabel registerLabel;
	JButton registerButton;
	JPanel loginPanel;
	JButton loginButton;
	JPanel extraPanel;
	
	public StaffLoginFrame(){
		frame = new JFrame();
		frame.setTitle("Staff Login");
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(50,50));
		ImageIcon logo = new ImageIcon("icons/logo.png");
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setBackground(new Color(0x123456));
		
		topPanel = new JPanel();
		topPanel.setPreferredSize(new Dimension(1000,70));
		topPanel.setBackground(new Color(0x123456));
		topPanel.setLayout(null);
		
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(1000,550));
		bottomPanel.setBackground(new Color(0x123456));
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER,50,50));
		
		innerPanel = new JPanel();
		innerPanel.setPreferredSize(new Dimension(350,400));
		innerPanel.setBackground(Colors.loginFormColor);
		innerPanel.setLayout(new GridLayout(6,1,40,0));
		innerPanel.setBorder(BorderFactory.createDashedBorder(null));
		
		
		backButton = new JButton();
		backButton.setPreferredSize(new Dimension(80,40));
		backButton.setText("Back");
		backButton.setForeground(Color.YELLOW);
		backButton.setBackground(new Color(0x123456));
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
		
		loginLabel = new JLabel("LOGIN FORM");
		loginLabel.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,22));
		loginLabel.setForeground(Color.white);
		loginLabel.setPreferredSize(new Dimension(350,80));
		loginLabel.setHorizontalAlignment(JLabel.CENTER);
		
		
		extraPanel = new JPanel();
		extraPanel.setPreferredSize(new Dimension(350,50));
		extraPanel.setBackground(Colors.loginFormColor);
		
		innerPanel.add(loginLabel);
		createEmailPanel();
		createPasswordPanel();
		createRegisterPanel();
		createLoginPanel();
		innerPanel.add(extraPanel);
		
		topPanel.add(backButton);
		bottomPanel.add(innerPanel);
		
		frame.add(topPanel,BorderLayout.NORTH);
		frame.add(bottomPanel,BorderLayout.SOUTH);
		frame.setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			new MainFrame();
			frame.dispose();
		}
		else if(e.getSource()==registerButton) {
			new StaffApplicationFrame();
			frame.dispose();
		}
		else if(e.getSource()==loginButton) {
			
			if(emailText.getText()==null || passwordText.getText()==null || 
					loginAccount(emailText.getText(),passwordText.getText())==false) {
				JOptionPane.showMessageDialog(frame, (Object) "Invalid neptun code or password", "LOGIN FAILED!",
						JOptionPane.PLAIN_MESSAGE);
				
			}
		}
		
	}
	
	private void createEmailPanel() {
		emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,25));
		emailPanel.setPreferredSize(new Dimension(350,50));
		emailPanel.setBackground(Colors.loginFormColor);
		
		ImageIcon emailIcon = new ImageIcon("icons/usernameIcon.png");
		JLabel iconLabel = new JLabel(emailIcon);
		iconLabel.setSize(60, 50);
		iconLabel.setBackground(Colors.loginFormColor);
		iconLabel.setOpaque(true);
		
		emailText = new JTextField();
		emailText.setPreferredSize(new Dimension(250,40));
		emailText.setEditable(true);
		emailText.setText("Neptun Code");
		emailText.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		emailText.setForeground(Color.LIGHT_GRAY);
		emailText.setBackground(Colors.loginFormColor);
		emailText.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				emailText.setText("");
				
			}

			
		});
		emailText.setBorder(BorderFactory.createMatteBorder(0, 0, 1 , 0, Color.LIGHT_GRAY));
		emailText.setLayout(new BorderLayout());
		emailText.add(iconLabel,BorderLayout.EAST);
		emailText.setCaretColor(Colors.loginFormColor);
		
		emailPanel.add(emailText);
		innerPanel.add(emailPanel);
	}
	
	private void createPasswordPanel() {
		passwordPanel = new JPanel();
		passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		passwordPanel.setPreferredSize(new Dimension(350,50));
		passwordPanel.setBackground(Colors.loginFormColor);
		
		ImageIcon emailIcon = new ImageIcon("icons/password.png");
		JLabel iconLabel = new JLabel(emailIcon);
		iconLabel.setSize(60, 50);
		iconLabel.setIcon(emailIcon);
		iconLabel.setBackground(Colors.loginFormColor);
		iconLabel.setOpaque(true);
		
		passwordText = new JPasswordField();
		passwordText.setPreferredSize(new Dimension(250,40));
		passwordText.setEditable(true);
		passwordText.setText("Password");
		passwordText.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,16));
		passwordText.setForeground(Color.LIGHT_GRAY);
		passwordText.setBackground(Colors.loginFormColor);
		passwordText.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				passwordText.setText("");
				passwordText.setEchoChar('*');
				
			}

			
		});
		passwordText.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));
		passwordText.setLayout(new BorderLayout());
		passwordText.add(iconLabel,BorderLayout.EAST);
		passwordText.setCaretColor(Colors.loginFormColor);
		passwordText.setEchoChar((char) 0);
		
		passwordPanel.add(passwordText);
		innerPanel.add(passwordPanel);
	}
	
	private void createRegisterPanel() {
		registerPanel = new JPanel();
		registerPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,20));
		registerPanel.setPreferredSize(new Dimension(350,50));
		registerPanel.setBackground(Colors.loginFormColor);
		
		registerLabel = new JLabel("   ");
		registerLabel.setFont(new Font(Font.SERIF,Font.ITALIC,13));
		registerLabel.setPreferredSize(new Dimension(135,30));
		registerLabel.setForeground(Color.white);
		
		registerButton = new JButton();
		registerButton.setPreferredSize(new Dimension(180,30));
		registerButton.setFocusable(false);
		registerButton.setText("Apply for a Position");
		registerButton.setFont(new Font(Font.SERIF,Font.ITALIC,16));
		registerButton.setForeground(Color.yellow);
		registerButton.setBorder(null);
		registerButton.setBackground(Colors.loginFormColor);
		registerButton.addActionListener(this);
		
		//registerPanel.add(registerLabel);
		registerPanel.add(registerButton);
		innerPanel.add(registerPanel);
	}
	
	private void createLoginPanel() {
		
		loginPanel = new JPanel();
		loginPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		loginPanel.setPreferredSize(new Dimension(350,50));
		loginPanel.setBackground(Colors.loginFormColor);
		
		loginButton = new JButton();
		loginButton.setPreferredSize(new Dimension(100,30));
		loginButton.setFocusable(false);
		loginButton.setText("LOGIN");
		loginButton.setBorder(null);
		loginButton.addActionListener(this);
		
		loginPanel.add(loginButton);
		innerPanel.add(loginPanel);
	}
	
	private boolean loginAccount(String username,String password) {
		
		Optional<Map.Entry<Integer, Staff>> matchingObject = Controller.staffs.entrySet().stream().
			    filter(p -> p.getValue().getLoginName().equals(username) && p.getValue().getPassword().equals(password)).
			    findAny();
		if(matchingObject.isPresent()) {
			new StaffAccount(matchingObject.get().getValue());
			frame.dispose();
		}
		
		return matchingObject.isPresent() ? true: false;
		
	}

}
