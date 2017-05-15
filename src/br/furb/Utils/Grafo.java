package br.furb.Utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	private boolean debug;

	public Grafo() {
		possuiCiclo = false;
		setDebug(false);
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

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
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

	public Vertice getVertice(int x, int y) {
		for (Map.Entry<Integer, Vertice> entry : grafo.entrySet()) {

			if (entry.getValue().getX() == x && entry.getValue().getY() == y) {
				return entry.getValue();
			}

		}
		return null;

	}

	public Vertice getVertice(String nome) {
		for (Map.Entry<Integer, Vertice> entry : grafo.entrySet()) {
			if (entry.getValue().getNome().equals(nome))
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
			if (v.getCor() == Color.BRANCO) {
				DFSVISIT(v);
			} else if (v.getCor() == Color.CINZA) {
				possuiCiclo = true;
			}
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

	public double calculaDistancia(Vertice A, Vertice B) {

		int x1 = A.getX();
		int y1 = A.getY();

		int x2 = B.getX();
		int y2 = B.getY();

		// raiz quadrada de (x2-x1)^2+(y2-y1)^2
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}

	/**
	 * Correlaciona os vertices com grau um
	 */
	public void normalizarGrafo() {
		logging("normalizarGrafo", "Inicio normalizador...");
		double distancia = 0;
		double menorDistancia = Double.MAX_VALUE;
		Vertice verticeDeMenorDistancia = null;
		ArrayList<Vertice> verticesParaRemover = new ArrayList<>();

		// percorre todos os vertices e identifica os de grau 1
		for (Map.Entry<Integer, Vertice> entry : grafo.entrySet()) {

			if (entry.getValue().getGrau() == 1) {
				logging("normalizarGrafo", "Vertice [" + entry.getValue().getNome() + "] x=" + entry.getValue().getX()
						+ " y=" + entry.getValue().getY());

				// calcula a distancia em ralação aos outros
				for (Map.Entry<Integer, Vertice> entry2 : grafo.entrySet()) {

					if (entry2.getValue() != entry.getValue()) {

						distancia = calculaDistancia(entry.getValue(), entry2.getValue());

						logging("normalizarGrafo",
								"     Vertice [" + entry2.getValue().getNome() + "] x=" + entry2.getValue().getX()
										+ " y=" + entry2.getValue().getY() + " Distancia: " + distancia);

						if (distancia < menorDistancia) {
							menorDistancia = distancia;
							verticeDeMenorDistancia = entry2.getValue();
						}
					}
				}

				logging("normalizarGrafo", "MenorDistancia " + entry.getValue().getNome() + "-->"
						+ verticeDeMenorDistancia.getNome() + " " + menorDistancia);

				/*
				 * Agora que identificamos o vertice de menor distancia e
				 * necessario remanejar as ligacoes
				 */
				for (Vertice v : verticeDeMenorDistancia.getVerticesAdjacentes()) {

					if (!entry.getValue().getVerticesAdjacentes().contains(v)) {

						// Faz a ligação do vertice de grau um com o de menor
						// distancia
						entry.getValue().AddVerticeAdjacente(v);
						v.AddVerticeAdjacente(entry.getValue());

						verticesParaRemover.add(v);

					}
				}
				// isola o vertice removido
				for (Vertice arrV : verticesParaRemover) {
					verticeDeMenorDistancia.removeVerticeAdjacente(arrV);
					arrV.removeVerticeAdjacente(verticeDeMenorDistancia);
				}

			}
			menorDistancia = Double.MAX_VALUE;
		}

		logging("normalizarGrafo", "Fim normalizador...");
	}

	public void logging(String metodo, String log) {
		if (isDebug()) {
			DateFormat dateFormat = new SimpleDateFormat("MMMM dd HH:mm:ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date) + " " + metodo + ": " + log);
		}
	}

	@Override
	public String toString() {
		String str = "";
		for (Map.Entry<Integer, Vertice> entry : grafo.entrySet()) {
			str += "\n[" + entry.getValue().getNome() + " x=" + entry.getValue().getX() + " y="
					+ entry.getValue().getY() + "]\n  " + entry.getValue().getVerticesAdjacentes();
		}
		return str;
	}

}
