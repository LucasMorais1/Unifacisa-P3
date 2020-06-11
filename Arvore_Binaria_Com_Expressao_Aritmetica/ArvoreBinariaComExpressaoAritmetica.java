package br.edu.unifacisa.p3.ArvoreBinariaComExpressaoAritmetica;

import br.edu.unifacisa.p3.Item;
import br.edu.unifacisa.p3.atividade10.ListaEncadeada;

public class ArvoreBinariaComExpressaoAritmetica{
	/**
	 * Método que organiza uma equação aritmética em uma Arvore Binária .
	 * @author Lucas Morais
	 * 
	 * github.com/LucasMorais1
	 */
	private static class No {
		char value;
		No left;
		No right;
		No pai;

		No(char value) {
			this.value = value;
			this.left = null;
			this.right = null;
			this.pai = null;
		}

		@Override
		public String toString() {
			String left1;
			String right1;
			String pai1;
			left1 = left == null ? "null" : "" + left.value;
			right1 = right == null ? "null" : "" + right.value;
			pai1 = pai == null ? "null" : "" + pai.value;

			String saida = "[value=" + value + ", left=" + left1 + ", right=" + right1 + ", pai=" + pai1 + "]";
			return saida;
		}
	}
	
	private No raiz;
	
	/**
	 * Criando árvore binária, a partir de uma equação.
	 * @param eq, equação que deseja transformar em uma árvore;
	 */
	public void add(String eq) {
		ListaEncadeada<Character> l = new ListaEncadeada<Character>();
		char[] equacao = eq.toCharArray();
		for (char c : equacao) {
			if (c!=' ')
				l.add(c);
		}
		Item<Character> atual = l.getHead();
		
		while (atual != null) {
			if (isOperacao(atual.value)) {
				No no = new No(atual.value);
				if (atual.previous.value != ')') {
					No esq = new No(atual.previous.value);
					no.left = esq;
				}
				if (atual.next.value != '(') {
					No dir = new No(atual.next.value);
					no.right = dir;
				}
				if (atual.previous.value == ')' && atual.next.value == '(') {
					while(raiz.pai != null) {
						raiz = raiz.pai;
					}
					no.left = raiz;
					raiz.pai = no;
					raiz = no;
				}
				
				
				if (raiz == null) {
					raiz = no;
				}
				else if(no.left != null && no.right != null) {
					no.pai = raiz;
					raiz.right = no;
				}
			}
			atual = atual.next;
		}
	}
	
	private boolean isOperacao(Character v) {
		if (v == '+' || v == '-' || v == '*' || v == '/') {
			return true;
		}
		return false;
	}
	
	public void emOrdem() {
		emOrdem(raiz);
		System.out.println();
	}

	private void emOrdem(No no) {
		if (no != null) {
			emOrdem(no.left);
			System.out.print(no.value + " ");
			emOrdem(no.right);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public No criar(No no, String str) {
//		char equaçao = str.charAt(0);
// 		if (no == null) { // Arvore vazia
//			no = new No(str);
//			add = true; // condição para nao entrar no ultimo if
//		} else if (naoNumero(no.right)) {
//			no.right = criar(no.right, str);
//		}
//		/*
//		 * Caso nao encontrou nenhum lugar do lado direito, insere no lado
//		 * esquerdo
//		 */
//		if ((!add) & naoNumero(no.left)) {
//			no.left = criar(no.left, str);
//		}
//
//		return no;
//	}
//	
//	boolean naoNumero(No no) {
//		try {
//			Integer.parseInt(no.value);
//			return false;
//		} catch (Exception e) {
//			return true;
//		}
//	}
}
