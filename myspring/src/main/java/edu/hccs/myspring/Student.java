package edu.hccs.myspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "prototype")
public class Student {
	private int id;
	private String firstName;
	private String email;
	private String gender;
	@Autowired
	private CourseList course = new CourseList();


	public Student(int id, String firstName, String email, String gender, CourseList course) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.email = email;
		this.gender = gender;
		this.course = course;
	}

	public int getPoint(String grade) {
		int point = 0;
		for (Course course : course.getCourseList()) {
			if (grade.trim().compareTo("A") == 0) {
				point = 4;
			} else if (grade.trim().compareTo("B") == 0) {
				point = 3;
			} else if (grade.trim().compareTo("C") == 0) {
				point = 2;
			} else if (grade.trim().compareTo("D") == 0) {
				point = 1;
			} else {
				point = 0;
			}
		}
		return point;
	}

	public double calculateGPA() {
		int totalCreditHours = 0;
		int totalPoint = 0;
		double gpa = 0;
		if (course.getCourseList().isEmpty())
			return gpa = 0;
		for (Course course : course.getCourseList()) {
			totalCreditHours += course.getCredithours();
			int point = getPoint(course.getGrade()) * course.getCredithours();
			totalPoint += point;
		}
		gpa = (double) totalPoint / totalCreditHours;
		return gpa;

	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public CourseList  getCourse() {
		return course;
	}

	public void setCourse(CourseList course) {
		this.course = course;
	}

	public CourseList getCourseList() {
		return course;
	}

	public void setCourseList(CourseList courseList) {
		this.course = courseList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", email=" + email + ", gender=" + gender
				+ ", courseNo=" + course.getCourseList() 
//				+ ", courseGrade=" + course.getGrade() + ", courseHours="
//				+ course.getCredithours() + "]"
				;
	}

}
