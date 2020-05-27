package br.edu.unifacisa.p3.atividade13;

public class ArvoreBinaria {
	private static class No {
		/**
		 * Valor do nó.
		 */
		int value;
		int altura;
		No left;
		No right;
		No pai;

		No(int value) {
			this.value = value;
			this.left = null;
			this.right = null;
			this.pai = null;
			this.altura = 0;
		}

		@Override
		public String toString() {
			String left1;
			String right1;
			String pai1;
			left1 = left == null ? "null" : "" + left.value;
			right1 = right == null ? "null" : "" + right.value;
			pai1 = pai == null ? "null" : "" + pai.value;

			String saida = "[value=" + value + ", left=" + left1 + ", right=" + right1 + ", pai=" + pai1 + ", altura="
					+ altura + "]";
			return saida;
		}
	}

	/**
	 * Variável representando a raiz da arvore binária.
	 */
	private No raiz;
	/**
	 * Variável representando a quantidade de nós da arvore binária.
	 */
	private int tamanho = 0;
	/**
	 * Variável representando a soma total dos nós da arvore binária.
	 */
	private int somaTotal = 0;
	/**
	 * Variável representando a quantidade de nós não folhas da arvore binária.
	 */
	private int naoFolhas = 0;
	/**
	 * Variável representando a quantidade de nós folhas da arvore binária.
	 */
	private int folhas = 0;
	/**
	 * Variável representando a altura da arvore binária.
	 */
	private int altura = 0;

	/**
	 * Inserindo nó na arvore binária sem recursividade.
	 * 
	 * @param valor que será adicionado na arvore.
	 */
	public void inserirV1(int value) {
		No novoNo = new No(value);
		if (raiz == null) {
			raiz = novoNo;
			raiz.altura = 1;
		} else
			AdicionarNoV1(novoNo);
		tamanho++;
	}

	private void AdicionarNoV1(No no) {
		No atual = raiz;
		boolean adicionou = false;
		while (!adicionou) {
			if (no.value <= atual.value) {
				if (atual.left != null)
					atual = atual.left;
				else {
					no.pai = atual;
					no.altura = no.pai.altura + 1;
					atual.left = no;
					adicionou = true;
				}
			} else {
				if (atual.right != null)
					atual = atual.right;
				else {
					no.pai = atual;
					no.altura = no.pai.altura + 1;
					atual.right = no;
					adicionou = true;
				}
			}
		}
	}

	/**
	 * Inserindo nó na arvore binária com recursividade.
	 * 
	 * @param valor que será adicionado na arvore.
	 */
	public void inserirV2(int valor) {
		raiz = AdicionarNoV2(raiz, valor);
	}

	private No AdicionarNoV2(No node, int valor) {
		if (node != null) {
			if ((valor <= node.value)) {
				if (node.left != null) {
					AdicionarNoV2(node.left, valor);
				} else {
					node.left = new No(valor);
				}
			} else if (valor > node.value) {
				if (node.right != null) {
					AdicionarNoV2(node.right, valor);
				} else {
					node.right = new No(valor);
				}
			}
		} else {
			node = new No(valor);
		}
		return node;
	}

	/**
	 * Retorna o numero de nós da arvore binária.
	 * 
	 * @return um numero inteiro representando a quantidade de nós da arvore
	 *         binária.
	 */
	public int getNumeroDeNos() {
		return tamanho;
	}

	/**
	 * Retorna a soma de todos os nós da arvore binária.
	 * 
	 * @return soma de todos os nós da arvore binária.
	 * 
	 */
	public int getsomaDosNos() {
		return somaDosNos(raiz);
	}

	private int somaDosNos(No no) {
		if (no != null) {
			somaDosNos(no.left);
			somaDosNos(no.right);
			somaTotal += no.value;
		}
		return somaTotal;
	}

	/**
	 * Exibe os nós da árvore organizados em pré-ordem.
	 */
	public void preOrdem() {
		preOrdem(raiz);
	}

	private void preOrdem(No no) {
		if (no != null) {
			System.out.print(no.value + " ");
			preOrdem(no.left);
			preOrdem(no.right);
		}
	}

	/**
	 * Exibe os nós da árvore organizados em-ordem.
	 */
	public void emOrdem() {
		emOrdem(raiz);
	}

	private void emOrdem(No no) {
		if (no != null) {
			emOrdem(no.left);
			System.out.print(no);
			emOrdem(no.right);
		}
	}

	/**
	 * Exibe os nós da árvore organizados em pós-ordem.
	 */
	public void posOrdem() {
		posOrdem(raiz);
	}

	private void posOrdem(No no) {
		if (no != null) {
			posOrdem(no.left);
			posOrdem(no.right);
			System.out.print(no.value + " ");
		}
	}

	/**
	 * Retorna a quantidade de nós não folha
	 * 
	 * @return um numero inteiro representando a quantidade de nós não folha.
	 */
	public int getQuantidadeDeNaoFolhas() {
		return contadorDeNoNaoFolhas(raiz);
	}

	private int contadorDeNoNaoFolhas(No no) {
		if (no != null) {
			contadorDeNoNaoFolhas(no.left);
			contadorDeNoNaoFolhas(no.right);
			if (no.left != null || no.right != null) {
				naoFolhas++;
			}
		}
		return naoFolhas;
	}

	/**
	 * Retorna a quantidade de nós folha.
	 * 
	 * @return um numero inteiro representando a quantidade de nós folha.
	 */
	public int getQuantidadeDeFolhas() {
		return contadorDeNoFolhas(raiz);
	}

	private int contadorDeNoFolhas(No no) {
		if (no != null) {
			contadorDeNoFolhas(no.left);
			contadorDeNoFolhas(no.right);
			if (no.left == null && no.right == null) {
				folhas++;
			}
		}
		return folhas;
	}

	/**
	 * Retorna a altura da árvore binária.
	 * 
	 * @return um numero inteiro representando a altura da árvore binária.
	 */
	public int getAltura() {
		return getAltura(raiz);
	}

	private int getAltura(No no) {
		if (no != null) {
			getAltura(no.left);
			getAltura(no.right);
			if (no.altura > altura) {
				altura = no.altura;
			}
		}
		return altura;
	}

	/**
	 * Retorna a raiz da árvore binária.
	 * 
	 * @return raiz da árvore binária.
	 */
	public No getRaiz() {
		if (raiz == null)
			return null;
		else
			return raiz;
	}
}
