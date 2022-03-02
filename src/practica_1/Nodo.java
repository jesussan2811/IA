package practica_1;

import java.util.ArrayList;
import java.util.List;

public class Nodo 
{
	public String dato;
	public List<Camino> caminos;
	public boolean visitado;
	
	public Nodo(String dato)
	{
		this.dato = dato;
		caminos = new ArrayList<>();
	}
	
	@Override
	public String toString()
	{
		return "Nodo{" +
				"dato='" + dato + '\'' +
				", visitado=" + visitado +
				'}';
	}
}

