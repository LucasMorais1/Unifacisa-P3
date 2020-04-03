package Questão4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ordenar 
{
	List<Integer> lista = new ArrayList<Integer>();
	
	private Ordenar()
	{
		for (int i = 0; i < 20; i++) {
			lista.add(i);
		}
	}
	
	public List<Integer> ListaDecrescente()
	{
		lista.sort(Collections.reverseOrder());
		return lista;
	}
}
