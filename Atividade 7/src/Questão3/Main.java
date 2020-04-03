package Questão3;

public class Main 
{
	public static void main(String[] args) 
	{
		TimesTreeSet ts = new TimesTreeSet();
		TimesHashSet hs = new TimesHashSet();
		
		System.out.println("Inserção");
		System.out.println("TreeSet: " + ts.tempoDeInsercao());
		System.out.println("HashSet: " + hs.tempoDeInsercao());
		
		System.out.println("\nRemoção");
		System.out.println("TreeSet: " + ts.tempoDeRemocao());
		System.out.println("HashSet: " + hs.tempoDeRemocao());
		
		System.out.println("\nObtenção");
		System.out.println("TreeSet: " + ts.tempoDeObtencao());
		System.out.println("HashSet: " + hs.tempoDeObtencao());
		
		System.out.println("\nNavegação");
		System.out.println("TreeSet: " + ts.tempoDeNavegacao());
		System.out.println("HashSet: " + hs.tempoDeNavegacao());
	}	
}
