package persist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import api.model.Subject;
import service.dao.SubjectDAO;
//import service.dao.exceptions.SubjectNotFoundException;

public class SubjectDAOJSON implements SubjectDAO {

    private Logger LOGGER = LogManager.getLogger(SubjectDAOJSON.class);
	
	private File database;
	
	public SubjectDAOJSON(String databasePath) {
		this.database = new File(databasePath);
	
		
		System.out.println(String.format("Subject Databse : %s", database.getAbsolutePath()));
	}

	public void createSubject(Subject car) {
		Collection<Subject> allSubjects = readSubjects();
		allSubjects.add(car);
		Subject[] extendedDatabase = allSubjects.toArray(new Subject[allSubjects.size()]);
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
		//LOGGER.info(String.format("Subject (%s) has been added!", car.getPlateNo()));
		
		

	}

	public Collection<Subject> readSubjects() {
		ObjectMapper mapper = new ObjectMapper();
		Subject[] cars = new Subject[] {};
		try {
			cars = mapper.readValue(database, Subject[].class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			//LOGGER.fatal(String.format("IOException occured due to %s", e.getMessage()));
		}
		Collection<Subject> result = new ArrayList<Subject>(Arrays.asList(cars));
		return result;
	}

	public Collection<Subject> readSubjectsByType(Subject.Type type) {
		// TODO Auto-generated method stub
		
		ObjectMapper mapper = new ObjectMapper();
		Subject[] cars = new Subject[] {};
		try {
			cars = mapper.readValue(database, Subject[].class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			//LOGGER.fatal(String.format("IOException occured due to %s", e.getMessage()));
		}
		Collection<Subject> result = new ArrayList<Subject>();
		
		for(Subject t: cars) {
			if(t.getSubjectType()== type) {
				result.add(t);
			}
		}
		
		return result;
		
	}

	

}
