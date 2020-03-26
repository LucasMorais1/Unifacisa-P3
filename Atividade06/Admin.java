package br.cesed.si.p3.atividade6;
import java.util.HashSet;
import java.util.LinkedList;

public class Admin {
	private char id;
	private String name;
	private String password;
	private HashSet<Teachers> professoresContratados = new HashSet<Teachers>();
	private HashSet<Students> estudantes = new HashSet<Students>();
	private LinkedList<Subject> disciplinas = new LinkedList<Subject>();
	private HashSet<Division> divisoes = new HashSet<Division>();
	private HashSet<Class> turmas = new HashSet<Class>();

	public void login(char id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public void logout() {
		this.id = (Character) null;
		this.name = null;
		this.password = null;
	}

	public void AddNewTeachers(Teachers newTeacher) {
		professoresContratados.add(newTeacher);
	}

	public void modifyTeacher(Teachers newTeacher) {
		for (Teachers teachers : professoresContratados) {
			if (teachers.getId() == newTeacher.getId()) {
				professoresContratados.remove(teachers);
				professoresContratados.add(newTeacher);
			}
		}
	}

	public void addNewStudent(Students newStudent) {
		estudantes.add(newStudent);

	}

	public void modifyStudent(Students newStudent) {
		for (Students students : estudantes) {
			if (students.getId() == newStudent.getId()) {
				estudantes.remove(students);
				estudantes.add(newStudent);
			}
		}
	}

	public void addNewSubject(Subject newSubject) {
		disciplinas.add(newSubject);
	}

	public void modifySubject(Subject newSubject) {
		for (Subject subjects : disciplinas) {
			if (subjects.getId() == newSubject.getId()) {
				disciplinas.remove(subjects);
				disciplinas.add(newSubject);
			}
		}
	}

	public void addNewDivision(Division newDivision) {
		divisoes.add(newDivision);
	}

	public void modifyDivision(Division newDivision) {
		for (Division divisions : divisoes) {
			if (divisions.getId() == newDivision.getId()) {
				divisoes.remove(divisions);
				divisoes.add(newDivision);
			}
		}
	}

	public void addNewClass(Class newClass) {
		turmas.add(newClass);
	}

	public void modifyClass(Class newClass) {
		for (Class classes : turmas) {
			if (classes.getId() == newClass.getId()) {
				turmas.remove(classes);
				turmas.add(newClass);
			}
		}
	}

	public HashSet<Teachers> getProfessoresContratados() {
		return professoresContratados;
	}

	public HashSet<Students> getEstudantes() {
		return estudantes;
	}

	public LinkedList<Subject> getDisciplinas() {
		return disciplinas;
	}

	public HashSet<Division> getDivisoes() {
		return divisoes;
	}

	public HashSet<Class> getTurmas() {
		return turmas;
	}

	public void setProfessoresContratados(HashSet<Teachers> professoresContratos) {
		this.professoresContratados = professoresContratos;
	}

	public void setEstudantes(HashSet<Students> estudantes) {
		this.estudantes = estudantes;
	}

	public void setDivisoes(HashSet<Division> divisoes) {
		this.divisoes = divisoes;
	}

	public void setTurmas(HashSet<Class> turmas) {
		this.turmas = turmas;
	}

}
