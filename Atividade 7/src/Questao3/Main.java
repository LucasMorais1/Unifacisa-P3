package Questao3;

public class Main 
{
	public static void main(String[] args) 
	{
		TimesTreeSet ts = new TimesTreeSet();
		TimesHashSet hs = new TimesHashSet();
		
		System.out.println("Inser��o");
		System.out.println("TreeSet: " + ts.tempoDeInsercao());
		System.out.println("HashSet: " + hs.tempoDeInsercao());
		
		System.out.println("\nRemo��o");
		System.out.println("TreeSet: " + ts.tempoDeRemocao());
		System.out.println("HashSet: " + hs.tempoDeRemocao());
		
		System.out.println("\nObten��o");
		System.out.println("TreeSet: " + ts.tempoDeObtencao());
		System.out.println("HashSet: " + hs.tempoDeObtencao());
		
		System.out.println("\nNavega��o");
		System.out.println("TreeSet: " + ts.tempoDeNavegacao());
		System.out.println("HashSet: " + hs.tempoDeNavegacao());
	}	
}
