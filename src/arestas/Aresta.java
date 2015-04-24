package arestas;

import Vertices.Vertice;

public class Aresta {
    public Vertice origem;
    public Vertice destino ;
	public Aresta(int[] origem, int[] destino) {
		this.origem = new Vertice(origem);
		this.destino = new Vertice(destino) ;
	}

	public boolean equals(Object o)
	{
		
		if ((((Aresta)o).origem.equals(this.origem))&&(((Aresta)o).destino.equals(this.destino))){
			return true ;
		}
		
     return false ;
}
}
