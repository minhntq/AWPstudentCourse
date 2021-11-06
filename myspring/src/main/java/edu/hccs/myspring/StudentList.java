package edu.hccs.myspring;

import java.util.ArrayList;

public class StudentList {
	private static ArrayList<Student> student = null;

	public static ArrayList<Student> getStudentList() {
		if ((student == null) || (student.size() == 0)) {

			student = new ArrayList<Student>();
		}
//		System.out.println("Form List ---->" + student);
//		for (Student st : student) {
//			System.out.println(st.getName() + st.getEmail() + st.getSubject() + st.getMessage());
//		}
		return student;
	}
	
	public void search(String search) {
        int check = 0;
        System.out.println("\n" + "Search by name or by course no: " + search);
        for (Student e : student) {
            if (e.getFirstName().trim().equalsIgnoreCase(search.trim())) {
                System.out.println(e);
                check++;
            }
            for (int i = 0; i < e.getCourse().getCourseList().size(); i++) {
                if (e.getCourse().getCourseList().get(i).getCourseNo().trim().equalsIgnoreCase(search.trim())) {
                    System.out.println(e);
                    check++;
                }
            }
        }
        if (check == 0) {
            System.out.println("Not found!!");
        }
    }

	public static void setStudentList(ArrayList<Student> form) {
		student = form;
	}
}
