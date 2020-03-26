package br.cesed.si.p3.atividade6;
import java.util.HashSet;
import java.util.Stack;

public class Students {
	private char id;
	private String name;
	private int phno;
	private String address;
	private int attendance;

	private HashSet<Teachers> professores = new HashSet<Teachers>();
	private HashSet<Class> turmas = new HashSet<Class>();
	private Stack<TestPaper> provas = new Stack<TestPaper>();

	public void fillAdmissionForm(int phno, String address) {
		this.phno = phno;
		this.address = address;
	}

	public String getEnrolled() {
		String matricula = "Id: " + this.id + "\nNome: " + this.name + "\nTelefone: " + this.phno + "\nEndereço: "
				+ this.address;
		return matricula;
	}

	public void writeExam() {

	}

	public char getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPhno() {
		return phno;
	}

	public String getAddress() {
		return address;
	}

	public int getAttendance() {
		return attendance;
	}

	public void setId(char id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhno(int phno) {
		this.phno = phno;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}

	public HashSet<Class> getTurmas() {
		return turmas;
	}

	public void setTurmas(HashSet<Class> turmas) {
		this.turmas = turmas;
	}

	public HashSet<Teachers> getProfessores() {
		return professores;
	}

	public Stack<TestPaper> getProvas() {
		return provas;
	}

	public void setProfessores(HashSet<Teachers> professores) {
		this.professores = professores;
	}

	public void setProvas(Stack<TestPaper> provas) {
		this.provas = provas;
	}

}
