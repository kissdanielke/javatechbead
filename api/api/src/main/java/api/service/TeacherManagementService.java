package api.service;


import java.util.Collection;

import api.model.Teacher;
//import hu.uni.miskolc.iit.java.technologies.carshop.api.service.exceptions.UnknownCarException;

public interface TeacherManagementService {

	Collection<Teacher> listTeachers();
	//Teacher getCarByPlateNo(String plateNo) throws UnknownCarException;
	void acquireTeacher(Teacher teacher);
	
	void addSubjectToTeacher(String teacherName, String subjectCode);
	
}