package br.furb.Utils;

import java.util.ArrayList;

public class Vertice {

	private int nome;
	private Color cor;
	private int distancia;
	private int fRetorno;
	private Vertice pai;
	private ArrayList<Vertice> verticesAdjacentes;

	public Vertice(int nome, Color cor, int distancia, int fRetorno, Vertice pai,
			ArrayList<Vertice> verticesAdjacentes) {
		setNome(nome);
		setCor(Color.BRANCO);
		setDistancia(0);
		setfRetorno(0);
		setPai(null);
		this.verticesAdjacentes = new ArrayList<Vertice>();
	}

	public int getNome() {
		return nome;
	}

	public Color getCor() {
		return cor;
	}

	public int getDistancia() {
		return distancia;
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

	public void setNome(int nome) {
		this.nome = nome;
	}

	public void setCor(Color cor) {
		this.cor = cor;
	}

	public void setDistancia(int distancia) {
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

	public void AddVerticeAdjacente(Vertice v) {
		verticesAdjacentes.add(v);
	}

	@Override
	public String toString() {
		String str = "";
		for (Vertice v : verticesAdjacentes) {
			str += v.getNome() + " ";
		}
		return str;
	}

}
