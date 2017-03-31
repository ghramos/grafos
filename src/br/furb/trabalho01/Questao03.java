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

public class Questao03 {
	public static void main(String[] args) throws IOException {
		Grafo g = new Grafo();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] str = input.readLine().split(" ");
		String print = "";

		int n = Integer.parseInt(str[0]);// número de documentos
		int m = Integer.parseInt(str[1]);// número de dependências existentes

		while (n != 0 & m != 0) {

			for (int i = 1; i <= n; i++) {// Instancia os vertices
				g.addVertice(i, new Vertice(String.valueOf(i)));
			}

			for (int i = 0; i < m; i++) {// Faz a ligacao dos vertices
				str = input.readLine().split(" ");

				Vertice a = g.getVertice(Integer.parseInt(str[0]));
				Vertice b = g.getVertice(Integer.parseInt(str[1]));

				a.AddVerticeAdjacente(b);
				// b.AddVerticeAdjacente(a);
			}
		}
		if (g.isPossuiCiclo())
			System.out.println("Sim");
		else
			System.out.println("Não");

	}

}
