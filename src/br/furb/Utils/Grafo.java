package br.furb.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Grafo {

	private HashMap<Integer, Vertice> grafo = new HashMap<>();// nome,vertice
	private int ordem;// quantidade de vertices
	private int tamanho;// quantidade de arestas
	private int tempo;
	private boolean possuiCiclo;
	private boolean digrafo;

	public Grafo() {
		possuiCiclo = false;
	}

	public HashMap<Integer, Vertice> getGrafo() {
		return grafo;
	}

	public int getOrdem() {
		return grafo.size();
	}

	public int getTamanho() {
		int total = 0;
		for (Map.Entry<Integer, Vertice> entry : grafo.entrySet()) {
			total += entry.getValue().getGrau();
		}

		if (isDigrafo())
			return total;

		return total / 2;
	}

	public int getTempo() {
		return tempo;
	}

	public boolean isDigrafo() {
		return digrafo;
	}

	public void setGrafo(HashMap<Integer, Vertice> grafo) {
		this.grafo = grafo;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public void setDigrafo(boolean digrafo) {
		this.digrafo = digrafo;
	}

	public boolean isPossuiCiclo() {
		return possuiCiclo;
	}
	// Metodos auxiliares

	public void addVertice(int key, Vertice v) {
		grafo.put(key, v);
	}

	public Vertice getVertice(int i) {
		return grafo.get(i);
	}

	public Vertice getVertice() {
		for (Map.Entry<Integer, Vertice> entry : grafo.entrySet()) {
			return entry.getValue();
		}
		return null;

	}

	public String getSequenciaDeGraus() {
		ArrayList<Integer> a = new ArrayList<>();
		for (Map.Entry<Integer, Vertice> entry : grafo.entrySet()) {
			a.add(entry.getValue().getGrau());
		}
		return a.toString();
	}

	public void DFS(Vertice G) { // Busca em profundidade
		tempo = 0;
		for (Vertice u : G.getVerticesAdjacentes()) {
			if (u.getCor() == Color.BRANCO) {
				DFSVISIT(u);
			}
		}
	}

	private void DFSVISIT(Vertice U) {// Busca em profundidade
		U.setCor(Color.CINZA);
		tempo += 1;
		U.setDistancia(tempo);
		for (Vertice v : U.getVerticesAdjacentes()) {
			if (v.getCor() == Color.BRANCO)
				DFSVISIT(v);
			else if (v.getCor() == Color.CINZA)
				possuiCiclo = true;
		}
		U.setCor(Color.PRETO);
		tempo += 1;
		U.setfRetorno(tempo);
	}

	public void BFS(Vertice s) {// Busca em largura
		LinkedList<Vertice> Q = new LinkedList<>();
		Vertice u = null;

		s.setDistancia(0);
		s.setCor(Color.CINZA);
		Q.add(s);
		while (!Q.isEmpty()) {
			u = Q.removeFirst();
			for (Vertice v : u.getVerticesAdjacentes()) {
				if (v.getCor() == Color.BRANCO) {
					Q.add(v);
					v.setCor(Color.CINZA);
					v.setPai(u);
					v.setDistancia(u.getDistancia() + 1);
				}
			}
			u.setCor(Color.PRETO);
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (Map.Entry<Integer, Vertice> entry : grafo.entrySet()) {
			// str += entry.getValue().getNome() + " (" +
			// entry.getValue().getDistancia() + "/"
			// + entry.getValue().getfRetorno() + ") Cor:" +
			// entry.getValue().getCor() + "\n";
			str += "\n[" + entry.getValue().getNome() + "]\n" + entry.getValue().toString();
		}
		return str;
	}

}
