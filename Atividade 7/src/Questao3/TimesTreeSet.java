package Questao3;
import java.util.TreeSet;

public class TimesTreeSet 
{
	public static final int TAMANHO_SET = 30;

	TreeSet<Integer> inc = new TreeSet<Integer>();
	
	public long tempoDeInsercao()
	{
		long nanoTreeMapI = System.nanoTime();	
		
		for (int i = 0; i < TAMANHO_SET; i++) {
			inc.add(i);
		}
		long nanoTreeMapF = System.nanoTime();
		return nanoTreeMapF-nanoTreeMapI;
	}
	
	public long tempoDeRemocao()
	{
		long nanoTreeMapI = System.nanoTime();
		
		for (int i = 0; i < TAMANHO_SET; i++) {
			inc.remove(i);
		}
		
		long nanoTreeMapF = System.nanoTime();
		return nanoTreeMapF-nanoTreeMapI;
	}
	
	public long tempoDeObtencao()
	{
		long nanoTreeMapI = System.nanoTime();
		
		for (Integer i : inc) {
			System.out.println(i);
		}
		
		long nanoTreeMapF = System.nanoTime();
		return nanoTreeMapF-nanoTreeMapI;
	}
	
	public long tempoDeNavegacao()
	{
		long nanoTreeMapI = System.nanoTime();
		
		for (Integer i : inc) {
		}
		
		long nanoTreeMapF = System.nanoTime();
		return nanoTreeMapF-nanoTreeMapI;
	}
	
}
