package api.service;

import java.util.Collection;

import api.model.Subject;

public interface SubjectManagementService {

	Collection<Subject> listSubjects();
	void acquireSubject(Subject subject);
	Collection<Subject> listSubjectsByType(Subject.Type type);
	
}