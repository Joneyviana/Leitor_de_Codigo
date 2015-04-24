package Vertices;

public class Vertice {
    public int x;
    public int y;
	private int[] ponto;
	public Vertice(int[] ponto) {
		this.ponto = ponto ;
		x =  ponto[0];
		y = ponto[1];
	}
	public boolean equals(Object o)
	{
		
		if ((((Vertice)o).x== this.x)&&(((Vertice)o).y == this.y)){
			return true;
		}
	return false ;
	}








}
