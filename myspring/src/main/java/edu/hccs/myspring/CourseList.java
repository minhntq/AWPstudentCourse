package edu.hccs.myspring;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class CourseList {
	private ArrayList<Course> courseList = null;

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public ArrayList<Course> addCourse(Course course){
        getCourseList().add(course);
        return courseList;
    }
    public CourseList() {
        courseList = new ArrayList<>();
    }

	@Override
	public String toString() {
		return "CourseList [courseList=" + courseList + "]";
	}
    
}
