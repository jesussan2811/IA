package examen_diagnostico;

import java.util.ArrayList;

public class Arbol
{
	Nodo raiz;
	Nodo Aux = raiz;
	
	public boolean vacio()
	{
		/*if(raiz == null)
		{
			System.out.println("El arbol esta vacio");
			return true;
		}
		else
		{
			System.out.println("arbol existe");
			return false;
		}*/
		
		return raiz == null;
	}
	
	public Nodo buscarNodo(int index)
	{
		if(vacio())
		{
			System.out.println("no se puede buscar");
			return null;
		}
		else
		{
			if(Aux.index == index)
			{
				Nodo Ans = Aux;
				Aux = raiz;
				return Ans;
			}
			else
			{
				if(Aux.index > index)
				{
					if (Aux.right == null)
					{
						System.out.println("Nodo no existente");
						return null;
					}
					else
					{
						Aux = Aux.right;
						return buscarNodo(index);
					}
				}
				else
				{
					if (Aux.left == null)
					{
						System.out.println("Nodo no existente");
						return null;
					}
					else
					{
						Aux = Aux.left;
						return buscarNodo(index);
					}
				}
			}
		}
	}
	
	
	public void insertar(int indice)
	{
		if(vacio())
		{
			raiz = new Nodo(indice);
			System.out.println("Raiz creada satisfactoriamente");
		}
		else
		{
			if(Aux.index == indice)
			{
				System.out.println("Error este nodo ya existe");
			}
			else
			{
				if(Aux.index > indice)
				{
					if (Aux.right == null)
					{
						Aux.right = new Nodo(indice);
						Aux = raiz;
					}
					else
					{
						Aux = Aux.right;
						buscarNodo(indice);
					}
				}
				else
				{
					if (Aux.left == null)
					{
						Aux.left = new Nodo(indice);
						Aux = raiz;
					}
					else
					{
						Aux = Aux.left;
						buscarNodo(indice);
					}
				}
			}
		}
	}
	
	public void imprimir()
	{
		imprimir(raiz);
	}
	
	public void imprimir(Nodo n)
	{
		n.mostrar();
		if(n.right != null)
			imprimir(n.right);
		if(n.left != null)
			imprimir(n.left);
	}
	
	
}
