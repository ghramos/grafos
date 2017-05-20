package br.furb.trabalho02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

import br.furb.Utils.Grafo;
import br.furb.Utils.Vertice;

/*Equipe:
 * Guilherme H R
 * Francisca E X
 */

public class Principal {
	private static BufferedReader b;
	private static File f;

	public static void main(String[] args) throws IOException {
		f = new File("XXXXXXXXXXX");
		b = new BufferedReader(new FileReader(f));
		String output[];
		Grafo g = new Grafo();

		String readLine = "";
		int i = 1;

		// Identifica origem e destino
		readLine = b.readLine();
		output = readLine.split(" ");
		String origem = output[0].replaceAll("\\s+", "").replaceAll("V", "");
		String destino = output[1].replaceAll("\\s+", "").replaceAll("V", "");

		// Constroi o grafo com os dados do arquivo
		while ((readLine = b.readLine()) != null) {

			// remove todos espaços ou \n ou \t (42,3)(41,1)
			readLine = readLine.replaceAll("\\s+", "");

			/**
			 * divide a String (42,3 # 41,1)
			 */
			output = readLine.split(Pattern.quote(")("));

			// remove ( - 42,3
			String strA = output[0].replaceAll("\\(", "");
			String verticeA[] = strA.split(",");
			int x1 = Integer.valueOf(verticeA[0]);
			int y1 = Integer.valueOf(verticeA[1]);

			// remove ) - 41,1
			String strB = output[1].replaceAll("\\)", "");
			String verticeB[] = strB.split(",");
			int x2 = Integer.valueOf(verticeB[0]);
			int y2 = Integer.valueOf(verticeB[1]);

			// Instancia os vertices caso nao existam
			if (g.getVertice(x1, y1) == null) {
				g.addVertice(i, new Vertice(String.valueOf(i), x1, y1));
				i++;
			}
			if (g.getVertice(x2, y2) == null) {
				g.addVertice(i, new Vertice(String.valueOf(i), x2, y2));
				i++;
			}

			Vertice A = g.getVertice(x1, y1);
			Vertice B = g.getVertice(x2, y2);

			// Adiciona o relacionamento bilateral
			A.AddVerticeAdjacente(B);
			B.AddVerticeAdjacente(A);
		}

		g.setDebug(false);

		g.normalizarGrafo();

		System.out.println("Vértice " + origem + " corresponde ao vértice X: " + g.getVertice(origem).getX() + " Y: "
				+ g.getVertice(origem).getY());
		System.out.println("Vértice " + destino + " corresponde ao vértice X: " + g.getVertice(destino).getX() + " Y: "
				+ g.getVertice(destino).getY());

		/*
		 * A correlação entre nome e posição dos vértices não correspondem ao do
		 * trabalho Sugiro que utilize as coordenadas X e Y
		 */

		// g.dijkstra(g.getVertice(42, 3), g.getVertice(28, 8));

		g.dijkstra(g.getVertice(origem), g.getVertice(destino));

	}

}
