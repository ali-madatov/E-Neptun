package Frames;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import main.Controller;
import main.Faculty;
import main.Staff;
import main.Student;

public class StaffAccount {
JFrame frame;
	
	public StaffAccount(Staff staff) {
		if(staff.getPosition()==Staff.Position.HEAD) {
			boolean flag = false;
			for(int i: Controller.faculties.keySet()) {
				if(Controller.faculties.get(i).getDeanID()==staff.getStaffID()) {
					new DeanAccount(staff);
					flag = true;
				}
			}
			if(flag==false)
				new HeadAccount(staff);
		}
		else if (staff.getPosition()==Staff.Position.TEACHER)
			new TeacherAccount(staff);
		else 
			new TechnicalStaffAccount(staff);

	}
}
