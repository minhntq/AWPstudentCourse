package edu.hccs.myspring;

import org.springframework.stereotype.Component;

@Component
public class Course {
	@Override
	public String toString() {
		return "Course [courseNo=" + courseNo + ", grade=" + grade + ", credithours=" + credithours + "]";
	}
	private String courseNo;
	private String grade;
	private int credithours;
	
	
	public Course() {
		super();
	}
	public Course(String courseNo, String grade, int credithours) {
		super();
		this.courseNo = courseNo;
		this.grade = grade;
		this.credithours = credithours;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getCredithours() {
		return credithours;
	}
	public void setCredithours(int credithours) {
		this.credithours = credithours;
	}
	
	
}
