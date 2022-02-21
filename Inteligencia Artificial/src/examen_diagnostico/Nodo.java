package examen_diagnostico;

public class Nodo
{
	int index;
	Nodo left;
	Nodo right;
	
	public Nodo(){}
	public Nodo(int index)
	{
		this.index = index;
	}
	
	public Nodo(int index, Nodo left, Nodo right)
	{
		this.index = index;
		this.left = left;
		this.right = right;
	}
	
	public void mostrar()
	{
		System.out.println("n° " + index);
	}
	
}