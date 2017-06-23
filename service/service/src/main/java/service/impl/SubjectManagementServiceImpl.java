package service.impl;

import java.util.Collection;

import api.model.Subject;
import api.service.SubjectManagementService;
import service.dao.SubjectDAO;

public class SubjectManagementServiceImpl implements SubjectManagementService {

	private SubjectDAO SubjectDAO;

	public SubjectManagementServiceImpl(SubjectDAO SubjectDAO) {
		super();
		this.SubjectDAO = SubjectDAO;
	}

	public Collection<Subject> listSubjects() {
		return SubjectDAO.readSubjects();
	}

	public Collection<Subject> listSubjectsByType(Subject.Type type) {
		return SubjectDAO.readSubjectsByType(type);
	}
	
	public void acquireSubject(Subject Subject) {
		SubjectDAO.createSubject(Subject);
	}
	
	
	
	/*public Subject getSubjectByPlateNo(String plateNo) throws UnknownSubjectException {
		try {
			Subject result = SubjectDAO.readSubjectByPlateNo(plateNo);
			return result;
		} catch (SubjectNotFoundException e) {
			throw new UnknownSubjectException(plateNo);
		}
	}*/

}