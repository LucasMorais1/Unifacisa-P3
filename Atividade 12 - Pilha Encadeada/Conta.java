public class Conta {

	private int agencia;
	private int numeroConta;
	private float saldo;
	private String nome;

	public Conta(int agencia, int numeroConta, String nome) {
		super();
		this.agencia = agencia;
		this.numeroConta = numeroConta;
		this.nome = nome;
	}

	public Conta proximo;

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Conta getProximo() {
		return proximo;
	}

	public void setProximo(Conta proximo) {
		this.proximo = proximo;
	}
	
	@Override
	public String toString() {
		return "Conta [numeroConta=" + numeroConta + ", nome=" + nome + "]";
	}	
	
}
