package br.cesed.si.p3.atividade6;
public class Subject {
	private char id;
	private char name;
	private char classId;

	public String displaySubjects() {
		Admin adm = new Admin();
		return (adm.getDisciplinas().toString());
	}

	public char getId() {
		return id;
	}

	public char getName() {
		return name;
	}

	public char getClassId() {
		return classId;
	}

}
