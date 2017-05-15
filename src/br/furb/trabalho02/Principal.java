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
		f = new File("XXXXXXXXXXXXXXX/src/br/furb/trabalho02/teste.txt");
		b = new BufferedReader(new FileReader(f));
		Grafo g = new Grafo();

		String readLine = "";
		int i = 1;

		// Constroi o grafo com os dados do arquivo
		while ((readLine = b.readLine()) != null) {

			// remove todos espaços ou \n ou \t (42,3)(41,1)
			readLine = readLine.replaceAll("\\s+", "");

			/**
			 * divide a String (42,3 # 41,1)
			 */
			String output[] = readLine.split(Pattern.quote(")("));

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
		g.setDebug(true);

		g.normalizarGrafo();

		g.dijkstra(g.getVertice(1), g.getVertice(16));

		System.out.println(g.matrizDijkstra());
	}

}
