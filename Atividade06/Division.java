package br.cesed.si.p3.atividade6;
public class Division {
	private char id;
	private char name;

	public String displaySubjects() {
		Admin adm = new Admin();
		return (adm.getDivisoes().toString());
	}

	public char getId() {
		return id;
	}

	public char getName() {
		return name;
	}

}
