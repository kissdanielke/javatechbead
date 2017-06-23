package api.model;

public class Subject {
	
	public static enum Type { REQUIRED, OPTIONAL};
	public static enum Semester { AUTUMN, SPRING, CROSS};
	private Type subjectType;
	private String code;
	private Semester semester;
	private String subjectName;
	public Type getSubjectType() {
		return subjectType;
	}
	public void setSubjectType(Type subjectType) {
		this.subjectType = subjectType;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Semester getSemester() {
		return semester;
	}
	public void setSemester(Semester semester) {
		this.semester = semester;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public Subject(Type subjectType, String code, Semester semester, String subjectName) {
		super();
		this.subjectType = subjectType;
		this.code = code;
		this.semester = semester;
		this.subjectName = subjectName;
	}
	public Subject() {
		super();
	}
	
	

}
