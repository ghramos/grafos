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
		boolean entradaValida = false;
		String[] str; 
		int a, v = 0;
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		//verifica entrada
		while(!entradaValida){
			
			str = input.readLine().split(" ");	
			if(str.length >1){
				 a = Integer.parseInt(str[0]); // Pontos-Vertices
				 v = Integer.parseInt(str[1]); // Ligacoes-Arestas
				 
				 if(4 <= a && a <= 4000 && 4<=v && a<= 5000){
					 entradaValida = true;
				 }else{
					 System.out.println("Informe: pontos (4<= PONTOS <= 4000) e ligacoes (4<= ligacoes <=5000)");
				 }
			}else{
				System.out.println("Informe dois valores inteiros!");
			
				}
			}
		int key = 0;
		int distanciaUm = 0; // Entrada -> Queijo
		int distanciaDois = 0; // Saida -> Queijo

		//int a = Integer.parseInt(str[0]); // Pontos-Vertices
		//int v = Integer.parseInt(str[1]); // Ligacoes-Arestas

		for (int i = 0; i < v; i++) {// Faz a ligacao dos vertices
			str = input.readLine().split(" ");

			if (g.getVertice(str[0]) == null)
				g.addVertice(++key, new Vertice(str[0]));
			if (g.getVertice(str[1]) == null)
				g.addVertice(++key, new Vertice(str[1]));

			Vertice A = g.getVertice(str[0]);
			Vertice B = g.getVertice(str[1]);

			A.AddVerticeAdjacente(B);
			B.AddVerticeAdjacente(A);
		}

		g.BFS(g.getVertice("Entrada"));
		distanciaUm = g.getVertice("*").getDistancia();

		g.BFS(g.getVertice("Saida"));
		distanciaDois = g.getVertice("*").getDistancia();

		System.out.println(distanciaDois + distanciaDois);
	}
}
