package service.dao;

import java.util.Collection;

import api.model.Teacher;

public interface TeacherDAO {

	void createTeacher(Teacher teacher);

	Collection<Teacher> readTeachers();
	
	Collection<Teacher> readTeacherByPosition(Teacher.Position position);
	
	void addSubjectToTeacher(String teacherName, String subjectCode);

}