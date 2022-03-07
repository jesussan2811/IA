package ocho_puzzle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import practica_1.Camino;
import practica_1.Nodo;

public class Principal 
{
	//EL PROGRAMA AUN TIENE PROBLEMAS Y SIGO TRATANDO DE HACER QUE FUNCIONE
	static ArrayList<String> puzzle;
	static ArrayList<String> memoria;
	String objetivo = "012345678";
	public static void main(String[] args) 
	{
		puzzle = new ArrayList<String>();
		puzzle.add("1");
		puzzle.add("0");
		puzzle.add("2");
		puzzle.add("3");
		puzzle.add("4");
		puzzle.add("6");
		puzzle.add("5");
		puzzle.add("7");
		puzzle.add("8");
		
		Principal m = new Principal();
        ArrayList<String> respuesta = m.BFS(puzzle);
        System.out.println("Respuesta: " + imprimirPuzzle(respuesta));
		//System.out.println(imprimirPuzzle(puzzle));
		//System.out.println(puzzle.toString());
		//System.out.println(puzzle.get(5));
	}
	
	static String imprimirPuzzle(ArrayList<String> e)
	{
		String res="";
		for(int a = 0; a<e.size(); a++)
		{
			
			res = res + e.get(a);
		}
		
		return res;
	}
	
	int buscarVacio(ArrayList<String> x)
	{
		int b=0;
		do
		{
			if(x.get(b) != "0")
			{
				b++;
			}
			
		}while(x.get(b) != "0");
		return b;
	}
	//funcion sucesores
	
	ArrayList<ArrayList<String>> sucesores(ArrayList<String> x)
	{
		ArrayList<ArrayList<String>> nodos = new ArrayList<ArrayList<String>>();
		ArrayList<String> aux1 = new ArrayList<String>();
		ArrayList<String> aux2 = new ArrayList<String>();
		ArrayList<String> aux3 = new ArrayList<String>();
		ArrayList<String> aux4 = new ArrayList<String>();
	    switch (buscarVacio(x)) {
		case 0: {
			aux1.add(x.get(1));aux1.add(x.get(0));aux1.add(x.get(2));aux1.add(x.get(3));aux1.add(x.get(4));aux1.add(x.get(5));aux1.add(x.get(6));aux1.add(x.get(7));aux1.add(x.get(8));
			aux2.add(x.get(3));aux2.add(x.get(1));aux2.add(x.get(2));aux2.add(x.get(0));aux2.add(x.get(4));aux2.add(x.get(5));aux2.add(x.get(6));aux2.add(x.get(7));aux2.add(x.get(8));
			
			nodos.add(aux1);
			nodos.add(aux2);
			return nodos;
		}
		case 1: {
			aux1.add(x.get(1));aux1.add(x.get(0));aux1.add(x.get(2));aux1.add(x.get(3));aux1.add(x.get(4));aux1.add(x.get(5));aux1.add(x.get(6));aux1.add(x.get(7));aux1.add(x.get(8));
			aux2.add(x.get(0));aux2.add(x.get(2));aux2.add(x.get(1));aux2.add(x.get(3));aux2.add(x.get(4));aux2.add(x.get(5));aux2.add(x.get(6));aux2.add(x.get(7));aux2.add(x.get(8));
			aux3.add(x.get(0));aux3.add(x.get(4));aux3.add(x.get(2));aux3.add(x.get(3));aux3.add(x.get(1));aux3.add(x.get(5));aux3.add(x.get(6));aux3.add(x.get(7));aux3.add(x.get(8));
			
			nodos.add(aux1);
			nodos.add(aux2);
			nodos.add(aux3);
			return nodos;
		}
		case 2: {
			aux1.add(x.get(0));aux1.add(x.get(2));aux1.add(x.get(1));aux1.add(x.get(3));aux1.add(x.get(4));aux1.add(x.get(5));aux1.add(x.get(6));aux1.add(x.get(7));aux1.add(x.get(8));
			aux2.add(x.get(0));aux2.add(x.get(1));aux2.add(x.get(5));aux2.add(x.get(3));aux2.add(x.get(4));aux2.add(x.get(2));aux2.add(x.get(6));aux2.add(x.get(7));aux2.add(x.get(8));

			nodos.add(aux1);
			nodos.add(aux2);
			return nodos;
		}
		case 3: {
			aux1.add(x.get(3));aux1.add(x.get(1));aux1.add(x.get(2));aux1.add(x.get(0));aux1.add(x.get(4));aux1.add(x.get(5));aux1.add(x.get(6));aux1.add(x.get(7));aux1.add(x.get(8));
			aux2.add(x.get(0));aux2.add(x.get(1));aux2.add(x.get(2));aux2.add(x.get(4));aux2.add(x.get(3));aux2.add(x.get(5));aux2.add(x.get(6));aux2.add(x.get(7));aux2.add(x.get(8));
			aux3.add(x.get(0));aux3.add(x.get(1));aux3.add(x.get(2));aux3.add(x.get(6));aux3.add(x.get(4));aux3.add(x.get(5));aux3.add(x.get(3));aux3.add(x.get(7));aux3.add(x.get(8));

			nodos.add(aux1);
			nodos.add(aux2);
			nodos.add(aux3);
			return nodos;
		}
		case 4: {
			aux1.add(x.get(0));aux1.add(x.get(4));aux1.add(x.get(2));aux1.add(x.get(3));aux1.add(x.get(1));aux1.add(x.get(5));aux1.add(x.get(6));aux1.add(x.get(7));aux1.add(x.get(8));
			aux2.add(x.get(0));aux2.add(x.get(1));aux2.add(x.get(2));aux2.add(x.get(4));aux2.add(x.get(3));aux2.add(x.get(5));aux2.add(x.get(6));aux2.add(x.get(7));aux2.add(x.get(8));
			aux3.add(x.get(0));aux3.add(x.get(1));aux3.add(x.get(2));aux3.add(x.get(3));aux3.add(x.get(5));aux3.add(x.get(4));aux3.add(x.get(6));aux3.add(x.get(7));aux3.add(x.get(8));
			aux4.add(x.get(0));aux4.add(x.get(1));aux4.add(x.get(2));aux4.add(x.get(3));aux4.add(x.get(7));aux4.add(x.get(5));aux4.add(x.get(6));aux4.add(x.get(4));aux4.add(x.get(8));

			nodos.add(aux1);
			nodos.add(aux2);
			nodos.add(aux3);
			nodos.add(aux4);
			return nodos;
		}
		case 5: {
			aux1.add(x.get(0));aux1.add(x.get(1));aux1.add(x.get(5));aux1.add(x.get(3));aux1.add(x.get(4));aux1.add(x.get(2));aux1.add(x.get(6));aux1.add(x.get(7));aux1.add(x.get(8));
			aux2.add(x.get(0));aux2.add(x.get(1));aux2.add(x.get(2));aux2.add(x.get(3));aux2.add(x.get(5));aux2.add(x.get(4));aux2.add(x.get(6));aux2.add(x.get(7));aux2.add(x.get(8));
			aux3.add(x.get(0));aux3.add(x.get(1));aux3.add(x.get(2));aux3.add(x.get(3));aux3.add(x.get(4));aux3.add(x.get(8));aux3.add(x.get(6));aux3.add(x.get(7));aux3.add(x.get(5));

			nodos.add(aux1);
			nodos.add(aux2);
			nodos.add(aux3);
			return nodos;
		}
		case 6: {
			aux1.add(x.get(0));aux1.add(x.get(1));aux1.add(x.get(2));aux1.add(x.get(6));aux1.add(x.get(4));aux1.add(x.get(5));aux1.add(x.get(3));aux1.add(x.get(7));aux1.add(x.get(8));
			aux2.add(x.get(0));aux2.add(x.get(1));aux2.add(x.get(2));aux2.add(x.get(3));aux2.add(x.get(4));aux2.add(x.get(5));aux2.add(x.get(7));aux2.add(x.get(6));aux2.add(x.get(8));

			nodos.add(aux1);
			nodos.add(aux2);
			return nodos;
		}
		case 7: {
			aux1.add(x.get(0));aux1.add(x.get(1));aux1.add(x.get(2));aux1.add(x.get(3));aux1.add(x.get(7));aux1.add(x.get(5));aux1.add(x.get(6));aux1.add(x.get(4));aux1.add(x.get(8));
			aux2.add(x.get(0));aux2.add(x.get(1));aux2.add(x.get(2));aux2.add(x.get(3));aux2.add(x.get(4));aux2.add(x.get(5));aux2.add(x.get(7));aux2.add(x.get(6));aux2.add(x.get(8));
			aux3.add(x.get(0));aux3.add(x.get(1));aux3.add(x.get(2));aux3.add(x.get(3));aux3.add(x.get(4));aux3.add(x.get(5));aux3.add(x.get(6));aux3.add(x.get(8));aux3.add(x.get(7));

			nodos.add(aux1);
			nodos.add(aux2);
			nodos.add(aux3);
			return nodos;
		}
		case 8: {
			aux1.add(x.get(0));aux1.add(x.get(1));aux1.add(x.get(2));aux1.add(x.get(3));aux1.add(x.get(4));aux1.add(x.get(5));aux1.add(x.get(6));aux1.add(x.get(8));aux1.add(x.get(7));
			aux2.add(x.get(0));aux2.add(x.get(1));aux2.add(x.get(2));aux2.add(x.get(3));aux2.add(x.get(4));aux2.add(x.get(8));aux2.add(x.get(6));aux2.add(x.get(7));aux2.add(x.get(5));

			nodos.add(aux1);
			nodos.add(aux2);
			return nodos;
		}
		}
	    return nodos;
	}
	
	boolean visitado(ArrayList<String> a)
	{
		for (int i = 0; i < memoria.size(); i++){
			if(imprimirPuzzle(a).equals(memoria.get(i))) {
				return true;
			}
		}
		return false;
	}

	private ArrayList<String> BFS(ArrayList<String> inicio){
    	Queue<ArrayList<String>> Q = new LinkedList<>();
    	memoria = new ArrayList<String>();
    	int profundidad=0;
    	int Qant=Q.size();
        System.out.println("origen: [" + imprimirPuzzle(inicio) + "]");
        memoria.add(imprimirPuzzle(inicio));
        Q.add(inicio);
        while (Q.size() > 0){
            ArrayList<String> v = Q.remove();
            if(imprimirPuzzle(v).equals(objetivo)){
                return v;
            }
            for (ArrayList<String> w: sucesores(v)) {
            	if(!visitado(w)){
                    memoria.add(imprimirPuzzle(w));
                    System.out.print(imprimirPuzzle(w) + "Objetivo" + objetivo + "/");
                    Q.add(w);
                }
            }System.out.println("");
        }
        return null;
    }

}
