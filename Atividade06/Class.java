package br.cesed.si.p3.atividade6;
public class Class {
	private char id;
	private char name;
	private char division;

	public String displaySubjects() {
		Admin adm = new Admin();
		return (adm.getTurmas().toString());
	}

	public char getId() {
		return id;
	}

	public char getName() {
		return name;
	}

	public char getDivision() {
		return division;
	}

}
