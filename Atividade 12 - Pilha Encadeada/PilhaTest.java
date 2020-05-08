import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PilhaTest {

	private Pilha pilha;
	private Pilha pilha2;
	private Conta conta1;
	private Conta conta2;

	@BeforeEach
	void setUp() throws Exception {
		pilha = new Pilha();
		pilha2 = new Pilha();
		conta1 = new Conta(1, 1, "a");
		conta2 = new Conta(1, 2, "c");
	}

	@Test
	void testPush1() {
		pilha.push(conta1);
		pilha.push(conta2);
		Assert.assertEquals(2, pilha.getSize());
	}

	@Test
	void testPop1() throws PilhaVaziaException {
		pilha.push(conta1);
		pilha.push(conta2);
		pilha.pop();
		Assertions.assertEquals(1, pilha.getSize());

	}

	@Test
	void testPop2() throws PilhaVaziaException {
		Assertions.assertThrows(PilhaVaziaException.class, () -> {
			pilha.pop();
		});
	}

	@Test
	void testPeek1() throws PilhaVaziaException {
		pilha.push(conta1);
		pilha.push(conta2);
		Assert.assertEquals(conta2, pilha.peek());

	}

	@Test
	void testPeek2() throws PilhaVaziaException {
		Assertions.assertThrows(PilhaVaziaException.class, () -> {
			pilha.peek();
		});
	}

	@Test
	void testIsEqualTo1() {
		pilha2.push(conta1);
		pilha.push(conta1);
		Assert.assertEquals(true, pilha.isEqualTo(pilha2));
	}

	@Test
	void testIsEqualTo2() {
		pilha2.push(conta1);
		pilha.push(conta2);
		Assert.assertEquals(false, pilha.isEqualTo(pilha2));
	}

}
