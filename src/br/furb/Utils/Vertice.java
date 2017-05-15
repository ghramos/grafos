package br.furb.Utils;

import java.util.ArrayList;

public class Vertice {

	private String nome;
	private int x;
	private int y;
	private Color cor;
	private double distancia;
	private int fRetorno;
	private Vertice pai;
	private ArrayList<Vertice> verticesAdjacentes;

	public Vertice(String nome, int x, int y) {
		setNome(nome);
		setX(x);
		setY(y);
		setCor(Color.BRANCO);
		setDistancia(0);
		setfRetorno(0);
		setPai(null);
		this.verticesAdjacentes = new ArrayList<Vertice>();
	}

	public String getNome() {
		return nome;
	}

	public Color getCor() {
		return cor;
	}

	public double getDistancia() {
		return distancia;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getfRetorno() {
		return fRetorno;
	}

	public Vertice getPai() {
		return pai;
	}

	public ArrayList<Vertice> getVerticesAdjacentes() {
		return verticesAdjacentes;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}

	public void setfRetorno(int fRetorno) {
		this.fRetorno = fRetorno;
	}

	public void setPai(Vertice pai) {
		this.pai = pai;
	}

	public void setVerticesAdjacentes(ArrayList<Vertice> verticesAdjacentes) {
		this.verticesAdjacentes = verticesAdjacentes;
	}

	// Metodos auxiliares

	public int getGrau() {
		return getVerticesAdjacentes().size();
	}

	public void removeVerticeAdjacente(Vertice v) {
		verticesAdjacentes.remove(v);
	}

	public void AddVerticeAdjacente(Vertice v) {
		verticesAdjacentes.add(v);
	}

	@Override
	public String toString() {
		// String str = "";
		// for (Vertice v : verticesAdjacentes) {
		// str += v.getNome() + " ";
		// }
		return getNome();
	}

}
