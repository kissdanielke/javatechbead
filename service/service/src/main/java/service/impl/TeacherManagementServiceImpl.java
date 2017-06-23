package service.impl;

import java.util.Collection;

import api.model.Teacher;
import api.service.TeacherManagementService;
import service.dao.TeacherDAO;
/*import hu.uni.miskolc.iit.java.technologies.Teachershop.api.service.exceptions.UnknownTeacherException;
import hu.uni.miskolc.iit.java.technologies.Teachershop.service.dao.TeacherDAO;
import hu.uni.miskolc.iit.java.technologies.Teachershop.service.dao.exceptions.TeacherNotFoundException;*/

public class TeacherManagementServiceImpl implements TeacherManagementService {

	private TeacherDAO teacherDAO;

	public TeacherManagementServiceImpl(TeacherDAO teacherDAO) {
		super();
		this.teacherDAO = teacherDAO;
	}

	public Collection<Teacher> listTeachers() {
		return teacherDAO.readTeachers();
	}

	public Collection<Teacher> listTeachersByPosition(Teacher.Position position) {
		return teacherDAO.readTeacherByPosition(position);
	}
	
	public void acquireTeacher(Teacher teacher) {
		teacherDAO.createTeacher(teacher);
	}
	
	public void addSubjectToTeacher(String teacherName, String subjectCode) {
		teacherDAO.addSubjectToTeacher(teacherName, subjectCode);
	}
	
	
	/*public Teacher getTeacherByPlateNo(String plateNo) throws UnknownTeacherException {
		try {
			Teacher result = TeacherDAO.readTeacherByPlateNo(plateNo);
			return result;
		} catch (TeacherNotFoundException e) {
			throw new UnknownTeacherException(plateNo);
		}
	}*/

}