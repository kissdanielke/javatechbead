package console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import api.model.Subject;
import api.model.Teacher;
import api.service.SubjectManagementService;
import api.service.TeacherManagementService;
import persist.SubjectDAOJSON;
import persist.TeacherDAOJSON;
import service.dao.SubjectDAO;
import service.dao.TeacherDAO;
import service.impl.SubjectManagementServiceImpl;
import service.impl.TeacherManagementServiceImpl;


public class App {
	private static TeacherManagementService teacherManager;
	private static SubjectManagementService subjectManager;
	
	static {
		TeacherDAO teacherDAO = new TeacherDAOJSON("resources/teachers.json");
		
		teacherManager = new TeacherManagementServiceImpl(teacherDAO);
		
		SubjectDAO subjectDAO = new SubjectDAOJSON("resources/subjects.json");
		
		subjectManager = new SubjectManagementServiceImpl(subjectDAO);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean run = true;
		while (run) {
			String line = br.readLine();
			
			if ("exit".equals(line)) {
				break;
			}
			if ("list teachers".equals(line)) {
				listTeachers();
			}
			if ("add teacher".equals(line)) {
				addTeacher();
			}
			if ("add subject".equals(line)) {
				addSubject();
			}
			
			if ("add subject to teacher".equals(line)) {
				addSubjectToTeacher();
			}
			
			
		}
		
	}
	
	private static void printHorisontalLine(int length) {
		for (int i = 0; i < length; i++) {
			System.out.print("-");
		}
		System.out.println();
	}
	
	private static void listTeachers() {
		final int tableWidth = 30;
		printHorisontalLine(tableWidth);
		System.out.println("| Name | Birth date | Started working day| Position");
		printHorisontalLine(tableWidth);
		for (Teacher car : teacherManager.listTeachers()) {
			System.out.println(String.format("| %1$7s | %2$8s | %3$5s | %4$7s |",
					car.getName(), car.getBirthDate(), car.getStartWorkingDay(), car.getPosition()));
			printHorisontalLine(tableWidth);
		}
	}
	
	private static void addTeacher() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Name ");
		String name = br.readLine();
		System.out.println("Birth Date (YYYY-MM-dd): ");
		String birthDateStr = br.readLine();
		
		System.out.println("Started Work Date (YYYY-MM-dd): ");
		String startedWorkDateStr = br.readLine();
		
		System.out.println("Positon");
		String posChar = br.readLine();
		
		Teacher.Position position = null;
		
		switch(posChar) {
		case "a": position = Teacher.Position.ASSISTANT_LECTURER; break;
		case "b": position = Teacher.Position.ASSISTANT_PROFESSOR; break;
		case "c": position = Teacher.Position.ASSOCIATE_PROFESSOR; break;
		case "d": position = Teacher.Position.HEAD_OF_DEPARTMENT; break;
		case "e": position = Teacher.Position.PROFESSOR; break;
		case "f": position = Teacher.Position.RESEARCH_FELLOW; break;
		
		}

		try {
			
			DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
			Date birthDate = df.parse(birthDateStr);
			Date startedWorkDate = df.parse(startedWorkDateStr);
			
			Teacher t = new Teacher(name, birthDate, startedWorkDate, position);

			teacherManager.acquireTeacher(t);
		} /*catch (UnknownCarException e) {
			// TODO
		}*/ catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	private static void addSubject() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Subject name ");
		String name = br.readLine();
		System.out.println("Subject code");
		String code = br.readLine();
		
		
		System.out.println("Type");
		String typeChar = br.readLine();
		
		Subject.Type type = null;
		
		switch(typeChar) {
			case "a": type = Subject.Type.REQUIRED; break;
			case "b": type = Subject.Type.OPTIONAL; break;
		
		}
		
		System.out.println("Semester");
		String semesterChar = br.readLine();
		
		Subject.Semester semester = null;
		
		switch(semesterChar) {
			case "a": semester = Subject.Semester.AUTUMN; break;
			case "b": semester = Subject.Semester.SPRING; break;
			case "c": semester=  Subject.Semester.CROSS; break;
		
		}

			
		
			Subject t = new Subject(type, code, semester, name);

			subjectManager.acquireSubject(t);
	
			

	}
	
	private static void addSubjectToTeacher() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Teacher name ");
		String name = br.readLine();
		System.out.println("Subject code");
		String code = br.readLine();
		
	    
		teacherManager.addSubjectToTeacher(name, code);
	
			

	}

		
	
}
