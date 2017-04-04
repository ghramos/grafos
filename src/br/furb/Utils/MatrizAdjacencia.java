package br.furb.Utils;

public class MatrizAdjacencia {
	private int [][] matriz;
	private Vertice[] vertices;
	

	public MatrizAdjacencia(int [][] matriz , Vertice[] listaVertices ) throws Exception{				
		setMatriz(matriz);
		setVertices(listaVertices);
	}
	public MatrizAdjacencia(int[][] matriz) /*throws Exception*/{		
		setMatriz(matriz);
		vertices =  new Vertice[matriz.length];
		for(int i= 0; i< matriz.length;i++){
			vertices[i] = new Vertice("V"+ i);
			
		}
	}
	
	public int[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(int[][] matriz) /*throws Exception*/ {
		//if(matriz.length != matriz[0].length){
		//	throw new Exception("Matriz de Adjacência deve ser NxN");
		//}else{
		this.matriz = matriz;
		
	}
	public Vertice[] getVertices() {
		return vertices;
	}
	public void setVertices(Vertice[] listaVertices) {
		this.vertices = listaVertices;
	}
	
}
