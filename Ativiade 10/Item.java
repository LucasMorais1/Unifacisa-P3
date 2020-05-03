package br.com.unifacisa.p3.atividade10;

class Item<E> {
	E value;
	Item<E> next;
	Item<E> previous;

	Item(E value, Item<E> proximo, Item<E> anterior) {
		this.value = value;
		this.next = proximo;
		this.previous = anterior;
	
	}

	@Override
	public String toString() {
		String next1;
		String previous1;
		next1 = next == null? "null":""+next.value;
		previous1 = previous == null? "null":""+previous.value;

		String saida = "[value=" + value + ", next=" + next1 + ", previous=" + previous1 + "]\n";
		return saida;
	}
}
