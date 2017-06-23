package persist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.model.Subject;
import api.model.Teacher;
import api.model.Teacher.Position;
import service.dao.TeacherDAO;

//import service.dao.exceptions.TeacherNotFoundException;

public class TeacherDAOJSON implements TeacherDAO {

    private Logger LOGGER = LogManager.getLogger(TeacherDAOJSON.class);
	
	private File database;
	
	public TeacherDAOJSON(String databasePath) {
		this.database = new File(databasePath);
	
		
		System.out.println(String.format("Teacher Databse : %s", database.getAbsolutePath()));
	}

	
	public void addSubjectToTeacher(String teacherName, String subjectCode) {
		
		Collection<Teacher> allTeachers = readTeachers();
		
		Teacher teacher = null;
		int i;
		for(Teacher t: allTeachers) {
			
		
		 if(t.getName().equals(teacherName)) {
			System.out.println("itt");
		    teacher = t;
		    break;
		 }
		}
		
		if(teacher.getSubjects()==null || teacher.getSubjects().size()==0) {
			teacher.setSubjects(new ArrayList<Subject>());
		}
		
		List<Subject> list = teacher.getSubjects();
		
		Subject s = new Subject();
		s.setCode(subjectCode);
		
		list.add(s);
		
		teacher.setSubjects(list);
		
		for(Teacher t: allTeachers) {
			
			
			 if(t.getName().equals(teacherName)) {
				t.setSubjects(list);
			    break;
			 }
			}
		
		 
		Teacher[] extendedDatabase = allTeachers.toArray(new Teacher[allTeachers.size()]);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(database, extendedDatabase);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			//LOGGER.fatal(String.format("IOException occured due to %s", e.getMessage()));
			
		}
		//LOGGER.info(String.format("Teacher (%s) has been added!", car.getPlateNo()));
		
		

	}
		
	
	
	public void createTeacher(Teacher car) {
		Collection<Teacher> allTeachers = readTeachers();
		allTeachers.add(car);
		Teacher[] extendedDatabase = allTeachers.toArray(new Teacher[allTeachers.size()]);
		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(database, extendedDatabase);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			//LOGGER.fatal(String.format("IOException occured due to %s", e.getMessage()));
			
		}
		//LOGGER.info(String.format("Teacher (%s) has been added!", car.getPlateNo()));
		
		

	}

	public Collection<Teacher> readTeachers() {
		ObjectMapper mapper = new ObjectMapper();
		Teacher[] cars = new Teacher[] {};
		try {
			cars = mapper.readValue(database, Teacher[].class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			//LOGGER.fatal(String.format("IOException occured due to %s", e.getMessage()));
		}
		Collection<Teacher> result = new ArrayList<Teacher>(Arrays.asList(cars));
		return result;
	}

	public Collection<Teacher> readTeacherByPosition(Position position) {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		Teacher[] cars = new Teacher[] {};
		try {
			cars = mapper.readValue(database, Teacher[].class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			//LOGGER.fatal(String.format("IOException occured due to %s", e.getMessage()));
		}
		Collection<Teacher> result = new ArrayList<Teacher>();
		
		for(Teacher t: cars) {
			if(t.getPosition() == position) {
				result.add(t);
			}
		}
		
		return result;
		
	}

	

}
