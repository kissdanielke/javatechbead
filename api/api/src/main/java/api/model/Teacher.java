package api.model;

import java.util.Date;
import java.util.List;

public class Teacher {
	
	public static enum Position { PROFESSOR, ASSOCIATE_PROFESSOR, ASSISTANT_PROFESSOR, 
		ASSISTANT_LECTURER, HEAD_OF_DEPARTMENT, RESEARCH_FELLOW };
			
	private String name;
	private Date birthDate;
	private Date startWorkingDay;
	private Position position;
	
	private List<Subject> subjects;
	
	
	public Teacher() {
		super();
	}

	public Teacher(String name, Date birthDate, Date startWorkingDay, Position position) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.startWorkingDay = startWorkingDay;
		this.position = position;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Date getStartWorkingDay() {
		return startWorkingDay;
	}
	public void setStartWorkingDay(Date startWorkingDay) {
		this.startWorkingDay = startWorkingDay;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}
		
	
}
