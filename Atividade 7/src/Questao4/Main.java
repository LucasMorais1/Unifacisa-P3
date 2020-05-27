package Questao4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static final int TAMANHO_SET = 20;
	
	public static void main(String[] args) 
	{
		List<Integer> lista = new ArrayList<Integer>();
		
		for (int i = 0; i < TAMANHO_SET; i++) {
			lista.add(i);
		}
		
		lista.sort(Collections.reverseOrder());
		
		System.out.println(lista.toString());
	}	
}
