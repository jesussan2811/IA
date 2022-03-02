package practica_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Coleccion de nodos?
// Coleccion de <String, List<String>

public class Principal 
{
	HashMap<String, Nodo> hashMap = new HashMap<String, Nodo>();
    String objetivo = "Los Mochis";
    List<Nodo> obtenerSucesores(Nodo x){
        List<Nodo> nodos = new ArrayList<>();
        for (Camino c: x.caminos) {
            nodos.add(c.destino);
        }
        return nodos;
    }
    boolean encontroObjetivo(Nodo n){
        if(objetivo.equals(n.dato))
            return true;
        return false;
    }
    public static void main(String[] args) {
        Nodo n1 = new Nodo("Mazatlan");
        Nodo n2 = new Nodo("Los Mochis");
        Nodo n3 = new Nodo("Guasave");
        Nodo n4 = new Nodo("Culiacan");
        Nodo n5 = new Nodo("Navolato");
        Nodo n6 = new Nodo("Elota");
        List<Camino> c1 = new ArrayList<Camino>();
        c1.add(new Camino(n4, 200));
        c1.add(new Camino(n6, 100));    // Maza - Elota
        List<Camino> c2 = new ArrayList<Camino>();
        c2.add(new Camino(n5, 35));     // CLN - Navolato
        c2.add(new Camino(n3, 150));    // CLN - Guasave
        List<Camino> c3 = new ArrayList<Camino>();
        c3.add(new Camino(n2, 80));     // Guasave - Mochis
        n1.caminos = c1;
        n4.caminos = c2;
        n3.caminos = c3;
        Principal m = new Principal();
        Nodo nodo = m.BFS(n1);
        System.out.println("Nodo encontrado: " + nodo.toString());
    }
    private Nodo BFS(Nodo inicio){
    	Queue<Nodo> Q = new LinkedList<>();
        inicio.visitado = true;
        Q.add(inicio);
        while (Q.size() > 0){
            Nodo v = Q.remove();
            if( encontroObjetivo(v) ){
                return v;
            }
            for (Nodo w: obtenerSucesores(v)) {
                if(!w.visitado){
                    w.visitado = true;
                    Q.add(w);
                }
            }
        }
        return null;
    }
    
}

/*


1  procedure BFS(G, root) is
2      let Q be a queue
3      label root as explored
4      Q.enqueue(root)
5      while Q is not empty do
6          v := Q.dequeue()
7          if v is the goal then
8              return v
9          for all edges from v to w in G.adjacentEdges(v) do
10              if w is not labeled as explored then
11                  label w as explored
12                  Q.enqueue(w)


*/