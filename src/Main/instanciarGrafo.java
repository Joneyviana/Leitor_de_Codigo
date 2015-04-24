package Main;

public class instanciarGrafo {

public static void main(String[] args){
	Grafo grafo = new Grafo();
	grafo.addAresta(new int[]{1,2}, new int[]{3,4});
	grafo.addAresta(new int[]{1,2}, new int[]{5,6});
	grafo.addAresta(new int[]{1,2}, new int[]{5,6});
	System.out.println("arestas:"+grafo.arestas);
    System.out.println("vertices:"+grafo.vertices);
}
}
