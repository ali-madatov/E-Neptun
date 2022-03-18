package main;

import java.io.Serializable;

public class GradeBook implements Serializable{
	public int classID;
	public int mark;
	public GradeBook() {}
	public GradeBook(int classID,int mark) {
		this.classID = classID;
		this.mark = mark;
	}
}
