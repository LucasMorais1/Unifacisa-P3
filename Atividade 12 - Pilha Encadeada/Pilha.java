public class Pilha {

	private Conta cabeca = null;
	private Conta rabo = null;
	private int size = 0;

	/**
	 * Adiciona uma nova conta no topo da pilha
	 * 
	 * @param novaConta Conta que deseja adicionar
	 */
	public void push(Conta novaConta) {
		if (cabeca == null) {
			cabeca = novaConta;
		} else if (rabo != null) {
			Conta seguinte = cabeca;
			while (!seguinte.proximo.equals(rabo)) {
				seguinte = seguinte.proximo;
			}
			seguinte.proximo = rabo;
			rabo.proximo = novaConta;
			rabo = novaConta;
		} else {
			cabeca.proximo = novaConta;
			rabo = novaConta;
		}
		size++;
	}

	/**
	 * Remove a conta do topo da pilha e retorna seus valores.
	 * 
	 * @return informações da conta removida.
	 * @throws PilhaVaziaException Caso o método seja chamado antes de adicionar
	 *                             algo na pilha.
	 */
	public Conta pop() throws PilhaVaziaException {
		if (cabeca == null)
			throw new PilhaVaziaException();
		Conta conta = cabeca;
		Conta retirada;
		while (!conta.proximo.equals(rabo)) {
			conta = conta.proximo;
		}
		retirada = conta.proximo;
		conta.proximo = null;
		size--;
		return retirada;
	}

	/**
	 * Retorna a conta que está no topo da pilha.
	 * 
	 * @return Conta que está no topo da pilha.
	 * @throws PilhaVaziaException Caso o método seja chamado antes de adicionar
	 *                             algo na pilha.
	 */
	public Conta peek() throws PilhaVaziaException {
		if (cabeca == null)
			throw new PilhaVaziaException();
		return rabo;
	}

	/**
	 * Compara os números de todas as contas de duas pilhas. e retorna um boolean
	 * relacionado a igualdade das pilhas.
	 * 
	 * @param outraPilha Pilha com qual deseja comparar a atual.
	 * @return true, se as pilha forem iguais, caso contrario, false.
	 */
	public boolean isEqualTo(Pilha outraPilha) {
		if (outraPilha.size != size)
			return false;
		else {
			Conta primeiroP = cabeca;
			Conta primeiroOP = outraPilha.cabeca;
			while (primeiroP != null) {
				if (primeiroP.getNumeroConta() != primeiroOP.getNumeroConta()) {
					return false;
				} else {
					primeiroP = primeiroP.proximo;
					primeiroOP = primeiroOP.proximo;
				}
			}
			
			return true;
		}
	}

	public int getSize() {
		return size;
	}

	@Override
	public String toString() {
		if (size > 0) {
			String saida = "" + cabeca.toString();
			if (cabeca.proximo != null) {
				for (Conta v = cabeca.proximo; v != null; v = v.proximo) {
					saida += ", " + v.toString();
				}
			}
			return saida;
		} else {
			return "[]";
		}
	}

}
