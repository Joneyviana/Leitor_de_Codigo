package Main;
import java.util.ArrayList;

import arestas.Aresta;
import Vertices.Vertice;
public class Grafo {

public ArrayList<Vertice> vertices = new  ArrayList<>();
public ArrayList<Aresta> arestas = new  ArrayList<>();


public void addAresta(int[] origem , int[] destino){
	Aresta aresta = new Aresta(origem, destino);
	if (arestas.contains(aresta)==false)
	arestas.add(aresta);
    if (vertices.contains(aresta.origem)==false){
	vertices.add(aresta.origem);
    }
    if (vertices.contains(aresta.destino)==false){
    vertices.add(aresta.destino);
      
    }
    }
public void addvertice(String Name){
	
}
}
