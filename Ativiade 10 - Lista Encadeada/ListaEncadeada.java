package br.com.unifacisa.p3.atividade10;

public class ListaEncadeada<E> {

	private static final int UMA_POS = 1;
	private static final int INICIO = 1;
	private static final int PRIMEIRO = 0;
	private static final int VAZIO = 0;
	
	/**
	 * Numero de elementos na lista.
	 */
	private int size = VAZIO;
	
	/**
	 * Primeiro valor da lista.
	 */
	private Item<E> cabeca;
	
	/**
	 * Ultimo valor da lista.
	 */
	private Item<E> rabo;
	
	/**
	 * Adiciona valor no final.
	 */
	private void adicionarValor(E value) {
		Item<E> item = new Item<E>(value, null, null);
		if (cabeca == null) {
			cabeca = item;
		} else if (cabeca.next != null) {
			Item<E> proximo = cabeca.next;
			while (proximo.next != null)
				proximo = proximo.next;
			item.previous = proximo;
			proximo.next = item;
			rabo = item;
		} else {
			item.previous = cabeca;
			cabeca.next = item;
			rabo = item;
		}
		size++;
	}
	
	/**
	 * Adiciona valor no index.
	 */
	private void adicionarValor(E value, int index) {
		Item<E> item = new Item<E>(value, null, null);
		if (index == size) {
			item.previous = rabo;
			rabo.next = item;
			rabo = item;
		} else if (index == PRIMEIRO) {
			cabeca.previous = item;
			item.next = cabeca;
			cabeca = item;
		} else {
			Item<E> atual = cabeca;
			int cont = INICIO;
			while (cont != index) {
				atual = atual.next;
				cont++;
			}
			item.next = atual.next;
			item.previous = atual;
			atual.next.previous = item;
			atual.next = item;
		}
		size++;
	}

	/**
	 * Remove primeira ocorrência.
	 */
	private void removerValor(Object value) {
		if (value.equals(cabeca.value)) {
			cabeca.next.previous = null;
			cabeca = cabeca.next;
		} else if (value.equals(rabo.value)) {
			rabo.previous.next = null;
			rabo = rabo.previous;
		} else {
			Item<E> atual = cabeca;
			while (atual.value != value) {
				atual = atual.next;
			}
			atual.previous.next = atual.next;
			atual.next.previous = atual.previous;
		}
		size--;
	}

	/**
	 * Remove item da posição.
	 */
	private E removerValor(int index) {
		E saida;
		if (index == PRIMEIRO) {
			saida = cabeca.value;
			cabeca.next.previous = null;
			cabeca = cabeca.next;
		} else if (index == size - UMA_POS) {
			saida = rabo.value;
			rabo.previous.next = null;
			rabo = rabo.previous;
		} else {
			Item<E> atual = cabeca;
			int cont = PRIMEIRO;
			while (cont != index) {
				atual = atual.next;
				cont++;
			}
			saida = atual.value;
			atual.previous.next = atual.next;
			atual.next.previous = atual.previous;
		}
		size--;
		return saida;
	}

	/**
	 * Retorna valor do index.
	 */
	private E pegarValor(int index) {
		Item<E> atual = cabeca;
		int cont = VAZIO;
		while (cont != index) {
			atual = atual.next;
			cont++;
		}
		return atual.value;
	}

	/**
	 * Retorna index do valor
	 */
	private int pegarIndex(E value) {
		int cont = VAZIO;
		Item<E> atual = cabeca;
		while (atual.value != value) {
			atual = atual.next;
			cont++;
		}
		return cont;
	}
	
	/**
	 * Retorna mensagem de erro indexOutOfBound. 
	 */
	private String getMenssagemIOB(int index){
		return "Index: " + index + ", Size: " + size;
	}
	
	/**
	 * Adiciona o elemento especificado no final da lista.
	 * 
	 * @param value elemento que será adiciona na lista.
	 * @return {@code true}
	 */
	public boolean add(E value) {
		adicionarValor(value);
		return true;
	}

	/**
	 * Adiciona um elemento na posição especificada.
	 * 
	 * @param value elemento que será adicionado na lista.
	 * @param index posição que o valor será adicionado.
	 */
	public void add(int index, E value) {
		if (index < PRIMEIRO || index > size) 
			throw new IndexOutOfBoundsException(getMenssagemIOB(index));
		else
			adicionarValor(value, index);
	}

	/**
	 * Remove o primeiro elemento da lista.
	 * 
	 * @return a cabeça da lista.
	 */
	public E remove() {
		if (size == VAZIO)
			throw new IndexOutOfBoundsException("A lista está vazia!");
		removerValor(PRIMEIRO);
		return cabeca.value;
	}

	/**
	 * Remove a primeira ocorrência na lista do elemento especificado.
	 * 
	 * @param value o elemento que será retirado da lista.
	 * @return {@code true} se o elementos estiver na lista, caso contrario, {@code false}
	 */
	public boolean remove(Object value) {
		if (value == null) {
			for (Item<E> i = cabeca; i != null; i = i.next) {
				if (i.value == null) {
					removerValor(value);
					return true;
				}
			}
		}else {
			for (Item<E> i = cabeca; i != null; i = i.next) {
				if (i.value.equals(value)) {
					removerValor(value);
					return true;
				}
			}		
		}
		return false;
	}
	
	/**
	 * Remove da lista o elemento que está na posição especificada.
	 * 
	 * @param index a posição do elemento, que será retirado da lista.
	 * @return {@code true} se o index estiver compatível com o tamanho da lista, caso
	 *         contraio, {@code false}
	 */
	public E remove(int index) {
		if (index >= PRIMEIRO && index < size)
			return removerValor(index);			
		else
			throw new IndexOutOfBoundsException(getMenssagemIOB(index));
	}

	/**
	 * Retorna a posição na lista do elemento especificado.
	 * 
	 * @param value elemento, que será retornado o index.
	 * @return posição em que o value está na lista.
	 */
	public int getIndex(E value) {
		return pegarIndex(value);
	}

	/**
	 * Retorna o valor da lista na posição especificado.
	 * 
	 * @param index posição que se encontra o elemento.
	 * @return elemento na posição especificado.
	 */
	public E getValue(int index) {
		if (index>PRIMEIRO &&  index<size)
			return pegarValor(index);
		else
			throw new IndexOutOfBoundsException(getMenssagemIOB(index));
	}

	/**
	 * Retorna o número de elementos presente na lista.
	 * 
	 * @return número de elementos presente na lista.
	 */
	public int size() {
		return size;
	}

	@Override
	public String toString() {
		Item<E> z = cabeca;
		String saida = "[";
		saida += z.value + ", ";
		while (true) {
			if (z.next != null) {
				saida += z.next.value;
				if (z.next.next != null)
					saida += ", ";
				z = z.next;
			} else
				break;
		}
		saida += "]";
		return saida;
	}
}
