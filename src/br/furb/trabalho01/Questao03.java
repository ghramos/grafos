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
		int T = Integer.parseInt(input.readLine()); // número de testes

		for (int j = 0; j < T; j++) { // repete ate qtdade de teste

			input = new BufferedReader(new InputStreamReader(System.in));
			String[] str = input.readLine().split(" ");

			int N = Integer.parseInt(str[0]);// número de documentos
			int M = Integer.parseInt(str[1]);// número de dependências

			for (int i = 1; i <= N; i++) {// Instancia os vertices
				g.addVertice(i, new Vertice(String.valueOf(i)));
			}

			for (int i = 0; i < M; i++) {// Faz a ligacao dos vertices
				str = input.readLine().split(" ");
				
				Vertice A = g.getVertice(Integer.parseInt(str[0]));
				Vertice B = g.getVertice(Integer.parseInt(str[1]));

				A.AddVerticeAdjacente(B);
			}
			g.DFS(g.getVertice());
			if (g.isPossuiCiclo())
				System.out.println("SIM");
			else
				System.out.println("NAO");
			g = new Grafo();
		}
		return;
	}

}
