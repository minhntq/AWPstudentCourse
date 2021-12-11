package edu.hccs.myspring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;


@SpringBootApplication
public class MyspringApplication {
	static ArrayList<Student> students = new ArrayList<Student>();
	// static ArrayList<Course> coursesList = new ArrayList<Course>();

	public static ArrayList<Student> parseJSOn(String url) throws ParseException {
		Client client = Client.create();
		WebResource webResource = client.resource(url);

		ClientResponse clientResponse = webResource.accept("application/json").get(ClientResponse.class);
		if (clientResponse.getStatus() != 200) {
			throw new RuntimeException("Failed" + clientResponse);
		}

		JSONArray jsonArray = (JSONArray) new JSONParser().parse(clientResponse.getEntity(String.class));

		Iterator<Object> it = jsonArray.iterator();

		while (it.hasNext()) {
			JSONObject jsonObject = (JSONObject) it.next();

			int id = Integer.parseInt(String.valueOf(jsonObject.get("id")));
			String name = String.valueOf(jsonObject.get("first_name"));
			System.out.println("name " + name);
			String email = String.valueOf(jsonObject.get("email"));
			System.out.println("name " + email);
			String gender = String.valueOf(jsonObject.get("gender"));
			System.out.println("name " + gender);

			JSONArray list = (JSONArray) jsonObject.get("course");
			CourseList coursesList = new CourseList();
			if (list != null) {
				Iterator<Object> c = list.iterator();
				while (c.hasNext()) {
					JSONObject courseObject = (JSONObject) c.next();
					String courseNo = String.valueOf(courseObject.get("courseNo"));
					System.out.println("" + courseNo);
					String grade = String.valueOf(courseObject.get("grade"));
					System.out.println("" + courseNo + " " + grade);
					String credithours = String.valueOf(courseObject.get("creditHours"));
					System.out.println("" + credithours);
					Course course = new Course(courseNo, grade, Integer.parseInt(credithours));
					coursesList.addCourse(course);
				}
			}
			Student student = new Student(id, name, email, gender, coursesList);
			// list.addStudent(student);
			students.add(student);
		}
		System.out.println("" + students);
		return students;
	}
	
	private static void extracted(ConfigurableApplicationContext context) {
		Book book = context.getBean(Book.class);
		book.setTitle("Managing Yourself");
		book.setNoOfPages(23);

		Author author = context.getBean(Author.class);
		author.setName("David");
		author.setEmail("davaid@gmail.com");
		author.setGender("Male");

		Author author2 = context.getBean(Author.class);
		author2.setName("Sam");
		author2.setEmail("sam@gmail.com");
		author2.setGender("Male");
		Author author3 = context.getBean(Author.class);
		List<Author> authors = new ArrayList(0);
		authors.add(author);
		authors.add(author2);
		authors.add(author3);
		
		Publisher pub1 = context.getBean(Publisher.class);
		pub1.setName("New");
		pub1.setAddress("unkonwn");
		List<Publisher> pubs = new ArrayList(0);
		pubs.add(pub1);
		book.setAuthors(authors);
		book.setPublisher(pubs);

		System.out.printf(book.toString());
	}

	public static void main(String[] args) throws ParseException {
		ConfigurableApplicationContext context = SpringApplication.run(MyspringApplication.class, args);
		StudentList studentList = new StudentList();
		StudentList.setStudentList(parseJSOn("https://hccs-advancejava.s3.amazonaws.com/student_course.json"));

		studentList.search("Aida  ");
		studentList.search("CS12 ");

		for (Student e : StudentList.getStudentList()) {
			if (!e.getCourse().getCourseList().isEmpty()) {
				System.out.println("GPA of " + e.getFirstName() + " : " + e.calculateGPA());
			} else
				System.out.println("Can not calculate GPA of " + e.getFirstName());
		}
		
		//extracted(context);
	}

}
