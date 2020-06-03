package br.edu.unifacisa.p3.atividade13;

import java.util.LinkedList;

/**
 * Projeto implementação de uma árvore binária
 * 
 * @author Lucas Morais
 * 
 * github.com/LucasMorais1
 */

public class ArvoreBinaria {
	private static class No {
		int value;
		No left;
		No right;
		No pai;

		No(int value) {
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
	 * Variável representando o valor máximo da arvore binária.
	 */
	private int valorMaximo = 0;
	
	/**
	 * Inserindo nó na arvore binária sem recursividade.
	 * 
	 * @param valor á ser adicionado na arvore.
	 */
	public void inserirV1(int value) {
		No novoNo = new No(value);
		if (raiz == null) {
			raiz = novoNo;
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
					atual.left = no;
					adicionou = true;
				}
			} else {
				if (atual.right != null)
					atual = atual.right;
				else {
					no.pai = atual;
					atual.right = no;
					adicionou = true;
				}
			}
		}
	}

	/**
	 * Inserindo nó na arvore binária com recursividade.
	 * 
	 * @param valor á ser adicionado na arvore.
	 */
	public void inserirV2(int valor) {
		raiz = AdicionarNoV2(raiz, valor);
		tamanho++;

	}

	private No AdicionarNoV2(No node, int valor) {
		if (node != null) {
			if ((valor <= node.value)) {
				if (node.left != null) {
					AdicionarNoV2(node.left, valor);
				} else {
					node.left = new No(valor);
					node.left.pai = node;
				}
			} else if (valor > node.value) {
				if (node.right != null) {
					AdicionarNoV2(node.right, valor);
				} else {
					node.right = new No(valor);
					node.right.pai = node;
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
	 * Exibe os nós da árvore organizados em pré-ordem, com recursividade.
	 */
	public void preOrdemV1() {
		preOrdemV1(raiz);
		System.out.println();
	}

	private void preOrdemV1(No no) {
		if (no != null) {
			System.out.print(no.value + " ");
			preOrdemV1(no.left);
			preOrdemV1(no.right);
		}
	}

	/**
	 * Exibe os nós da árvore organizados em pré-ordem, sem recursividade.
	 */
	public void preOrdemV2() {
		LinkedList<No> jaPassou = new LinkedList<No>();
		No atual = raiz;
		int cont = 1;
		System.out.print(atual.value + " ");
		while (cont < tamanho) {
			if (atual.left != null && !jaPassou.contains(atual.left)) {
				atual = atual.left;
				System.out.print(atual.value + " ");
				jaPassou.add(atual);
				cont++;
			} else if (atual.right != null && !jaPassou.contains(atual.right)) {
				atual = atual.right;
				System.out.print(atual.value + " ");
				jaPassou.add(atual);
				cont++;
			} else {
				atual = atual.pai;
			}
		}
		System.out.println();
	}

	/**
	 * Exibe os nós da árvore organizados em-ordem, com recursividade.
	 */
	public void emOrdemV1() {
		emOrdemV1(raiz);
		System.out.println();
	}

	private void emOrdemV1(No no) {
		if (no != null) {
			emOrdemV1(no.left);
			System.out.print(no.value + " ");
			emOrdemV1(no.right);
		}
	}

	/**
	 * Exibe os nós da árvore organizados em-ordem, sem recursividade.
	 */
	public void emOrdemV2() {
		LinkedList<No> exibidos = new LinkedList<No>();
		No atual = raiz;
		int cont = 0;
		while (cont < tamanho) {
			if (jaFoi(exibidos, atual.left) && !jaFoi(exibidos, atual)) {
				System.out.print(atual.value + " ");
				exibidos.add(atual);
				cont++;
			} if (atual.left != null && !exibidos.contains(atual.left)) {
				atual = atual.left;
			} else if (atual.right != null && !exibidos.contains(atual.right)) {
				atual = atual.right;
			} else if (exibidos.contains(atual)) {
				atual = atual.pai;
			}
		}
		System.out.println();
	}

	/**
	 * Exibe os nós da árvore organizados em pós-ordem, com recursividade.
	 */
	public void posOrdemV1() {
		posOrdemV1(raiz);
		System.out.println();
	}

	private void posOrdemV1(No no) {
		if (no != null) {
			posOrdemV1(no.left);
			posOrdemV1(no.right);
			System.out.print(no.value + " ");
		}
	}

	/**
	 * Exibe os nós da árvore organizados em pós-ordem, sem recursividade.
	 */
	public void posOrdemV2() {
		LinkedList<No> exibidos = new LinkedList<No>();
		No atual = raiz;
		int cont = 0;
		while (cont < tamanho) {
			if ((jaFoi(exibidos, atual.left) && jaFoi(exibidos, atual.right)) && !jaFoi(exibidos, atual)) {
				System.out.print(atual.value + " ");
				exibidos.add(atual);
				cont++;
			} if (atual.left != null && !exibidos.contains(atual.left)) {
				atual = atual.left;
			} else if (atual.right != null && !exibidos.contains(atual.right)) {
				atual = atual.right;
			} else if (exibidos.contains(atual)) {
				atual = atual.pai;
			}
		}
		System.out.println();
	}

	/**
	 * A partir do valor do nó, retorna o objeto Nó presente na árvore binária.
	 * @param valor do nó, que deseja encontrar na árvore binária.
	 * @return nó, de valor igual, ao passado como parâmetro.
	 */
	private No encontrarNo(int valor) {
		No atual = raiz;
		while (atual.value != valor)
        {
            if (valor <= atual.value){
            	atual = atual.left;
            } else {
            	atual = atual.right;
            }
            if(atual == null) {
            	return null;
            }
        }
		return atual;
	}
	
	/**
	 * Verifica se determinado nó está vazio ou está inserido na lista passada como parâmetro.
	 * @param historico, uma lista com os nós.
	 * @param no, nó que deseja verificar se está na lista.
	 * @return true se o nó for uma folha ou estiver na lista, caso contrario, false.
	 */
	private boolean jaFoi(LinkedList<No> historico, No no) {
		return (no == null || historico.contains(no));
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
	 * Retorna a altura da árvore binária, com recursividade.
	 * 
	 * @return um numero inteiro representando a altura da árvore binária.
	 */
	public int getAlturaV1() {
		return getAlturaV1(this.raiz);
	}
	
	private int getAlturaV1(No node) {
		if (node == null) {
			return 0;
		}
		int alturaEsquerda = getAlturaV1(node.left);
		int alturaDireita = getAlturaV1(node.right);

		if (alturaEsquerda > alturaDireita) {
			return alturaEsquerda + 1;
		} else {
			return alturaDireita + 1;
		}

	}
	
	/**
	 * Retorna a altura da árvore binária, sem recursividade.
	 * @return 
	 */
	public int getAlturaV2(){
		LinkedList<No> jaPassou = new LinkedList<No>();
		No atual = raiz;
		int alturaMax = 0;
		int cont = 0;
		while (cont < tamanho) {
			if ((jaFoi(jaPassou, atual.left) && jaFoi(jaPassou, atual.right)) && !jaFoi(jaPassou, atual)) {
				if (atual.right == null && atual.left == null) {
					int altura = getAlturaDoNo(atual);
					alturaMax = altura>alturaMax? altura:alturaMax;
				}
				jaPassou.add(atual);
				cont++;
			} else if (atual.left != null && !jaPassou.contains(atual.left)) {
				atual = atual.left;
			} else if (atual.right != null && !jaPassou.contains(atual.right)) {
				atual = atual.right;
			} else if (jaPassou.contains(atual)) {
				atual = atual.pai;
			}
		}
		return alturaMax;
	}
	
	private int getAlturaDoNo(No no) {
		 No aux = raiz;
         int nivel = 1;
         while (aux != no)
         {
             if (no.value <= aux.value){
            	 aux = aux.left;
             } else {
            	 aux = aux.right;
             }
             nivel++;
         }
         return nivel;
 }	
	
	/**
	 * Retorna a raiz da árvore binária.
	 * 
	 * @return raiz da árvore binária.
	 */
	public Integer getRaiz() {
		if (raiz == null)
			return null;
		else
			return raiz.value;
	}

	/**
	 * Retorna o valor máximo da árvore binária.
	 * 
	 * @return valor máximo da árvore binária.
	 */
	public int getValorMaximo() {
		return getValorMaximo(raiz);
	}

	private int getValorMaximo(No no) {
		if (no != null) {
			getValorMaximo(no.right);
			if (no.value > valorMaximo) {
				valorMaximo = no.value;
			}
		}
		return valorMaximo;
	}

	/**
	 * Remove o todas as aparições do valor especificado, sem recursividade.
	 * 
	 * @param valor que será inserido na árvore.
	 */
	public void remover(int valor) {
		No no = encontrarNo(valor);
		if (no != null) {
			if (isFolha(no)) {
				removeNo(no);
			} else {
				No atual = no;					
				if (no.left != null) {
					atual = atual.left;
					while (atual.right != null) {
						atual = atual.right;
					}
				} else {					
					atual = atual.right;
					while (atual.left != null) {
						atual = atual.left;
					}
				}
				removeNo(atual);
				no.value = atual.value;
			}
		}
	}
	
	/**
	 * Verifica se o nó está a esquerda ou a direita do pai, e remove.
	 * @param no que deseja remover.
	 */
	private void removeNo(No no) {
		if(no.value > no.pai.value)
			no.pai.right = null;
		else
			no.pai.left = null;

	}
		
	/**
	 * Verifica se o no é uma folha.
	 * 
	 * @param no nó que será verificado
	 * @return se o nó for uma folha, retorna true, caso contrario, false.
	 */
	private boolean isFolha(No no) {
		return no.left == null && no.right == null ? true : false;
	}

	public void getString() {
		getString(raiz);
	}

	private void getString(No no) {
		if (no != null) {
			getString(no.left);
			System.out.println(no);
			getString(no.right);
		}
	}
}
