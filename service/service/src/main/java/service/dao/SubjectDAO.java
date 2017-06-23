package service.dao;

import java.util.Collection;

import api.model.Subject;

public interface SubjectDAO {

	void createSubject(Subject subject);

	Collection<Subject> readSubjects();
	Collection<Subject> readSubjectsByType(Subject.Type type);
}