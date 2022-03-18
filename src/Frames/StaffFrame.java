package Frames;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class StaffFrame {
	JFrame frame;
	StaffFrame(){
		frame = new JFrame();
		frame.setTitle("Staff Account");
		frame.setSize(1000, 630);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout(50,50));
		ImageIcon logo = new ImageIcon("icons/logo.png");
		frame.setIconImage(logo.getImage());
		frame.getContentPane().setBackground(new Color(0x123456));
		frame.setVisible(true);
	}
}
