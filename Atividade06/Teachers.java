package br.cesed.si.p3.atividade6;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class Teachers {
	private char id;
	private String name;
	private int phno;
	private String Address;
	private Stack<TestPaper> provas = new Stack<TestPaper>();
	private HashSet<Students> estudantes = new HashSet<Students>();
	private HashSet<Division> divisoes = new HashSet<Division>();

	public void prepareTestPaper(TestPaper newProva) {
		provas.add(newProva);
	}

	public void parkAttendance(Students aluno) {
		Admin adm = new Admin();
		for (Students alunos : adm.getEstudantes()) {
			if (alunos.getId() == aluno.getId()) {
				aluno.setAttendance(aluno.getAttendance() + 1);
			}
		}
	}

	public String checkPaper(Students aluno) {
		String provas = "Aluno: " + aluno + "\n";
		for (Students alunos : estudantes) {
			if (alunos.getId() == aluno.getId()) {
				for (TestPaper prova : aluno.getProvas()) {
					provas += prova.toString() + "\n";
				}
			}
		}
		return provas;
	}

	public void prepareReportCard(ArrayList<Float> notas) {
		String boletim = "Notas: " + notas.toString();
	}

	public String declareResult(float notaTotal) {
		if (notaTotal > 7) {
			return "Aprovado";
		} else {
			return "Substitutiva";
		}
	}

	public char getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public long getPhno() {
		return phno;
	}

	public String getAddress() {
		return Address;
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
		Address = address;
	}
}
