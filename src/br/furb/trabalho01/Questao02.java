package br.furb.trabalho01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.furb.Utils.Grafo;
import br.furb.Utils.Vertice;

/*Equipe:
 * Guilherme H R
 *  Francisca E X
 */

public class Questao02 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Grafo g = new Grafo();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] str = input.readLine().split(" ");

		int a = Integer.parseInt(str[0]); // Pontos-Vertices
		int v = Integer.parseInt(str[1]); // Ligacoes-Arestas

		for (int j = 0; j < v; j++) {

			input = new BufferedReader(new InputStreamReader(System.in));
			str = input.readLine().split(" ");

			for (int i = 1; i <= a; i++) {// Instancia os vertices
				g.addVertice(i, new Vertice(String.valueOf(i)));
			}

			for (int i = 0; i < v; i++) {// Faz a ligacao dos vertices
				str = input.readLine().split(" ");

				Vertice A = g.getVertice(Integer.parseInt(str[0]));
				Vertice B = g.getVertice(Integer.parseInt(str[1]));

				A.AddVerticeAdjacente(B);
				B.AddVerticeAdjacente(A);
			}
		}
	}
}
