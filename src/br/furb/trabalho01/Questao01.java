package br.furb.trabalho01;

/*Equipe:
 * Guilherme H R
 *  Francisca E X
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import br.furb.Utils.MatrizAdjacencia;

public class Questao01 {
	public static void main(String[] args) throws IOException {

		// testePadrao();

		int opcao = 0;
		do {
			Scanner entrada = new Scanner(System.in);
			System.out.println(
					"Informe o nome de cada vertices da matriz de adjac�ncia separadas por \";\" (Vertices com nomes igauais ser�o ignorados)");
			String[] v = (entrada.nextLine() + ";").split(";");

			MatrizAdjacencia ma = null;
			try {
				ma = MatrizAdjacencia.criaMatriz(v);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

			int i = 0;
			int j = 0;

			System.out.println("Informe o valores da matriz:");
			// System.out.println(" " + ma.listaNomeVertices());

			// System.out.println("____" + new String(new
			// char[ma.listaNomeVertices().length()/2]).replace("", "_"));

			for (i = 0; i < ma.getVertices().length; i++) {
				for (j = 0; j < ma.getVertices().length; j++) {
					System.out.print("Valor de [" + ma.getVertices()[i].getNome() + "]x["
							+ ma.getVertices()[j].getNome() + "] :");

					boolean isInt = false;
					while (!isInt) {
						Scanner inteiro = new Scanner(System.in);
						try {
							int a = inteiro.nextInt();
							if (a < 0) {
								throw new IllegalArgumentException();
							}
							ma.getMatriz()[i][j] = a;
							isInt = true;
						} catch (InputMismatchException e) {
							isInt = false;
							System.out.print("Informe um inteiro positivo!");
						} catch (IllegalArgumentException e) {
							isInt = false;
							System.out.print("Informe um inteiro positivo!");
						}
						// }

					}

				}

			}
			do {
				System.out.println(
						"\nEcolha a Pr�xima a��o:\n 1- Tipo do Grafo.\n 2- Arestas do Grafo \n 3- Graus do Vertice \n 4 -Novo Grafo\n 0- Sair");

				Scanner inteiro = new Scanner(System.in);
				try {
					opcao = inteiro.nextInt();
				} catch (InputMismatchException ime) {
					opcao = -1;

				}

				switch (opcao) {
				case 1:
					System.out.println(MatrizAdjacencia.tipoDoGrafo(ma));
					break;
				case 2:
					System.out.println(MatrizAdjacencia.arestasDoGrafo(ma));
					break;
				case 3:
					System.out.println(MatrizAdjacencia.grausDoVertice(ma));
					break;
				case 4:
					System.out.println("\n");
					break;	
				case 0:

					break;

				default:
					System.out.print("Op��o inv�lida!");

					break;
				}

			} while (opcao != 0 && opcao != 4);

		} while (opcao != 0);

	}

	public static void testePadrao() throws Exception {
		// N�o dirigido/Simples/regular completo
		int matriz0[][] = { { 0, 1, 1, 1 }, { 1, 0, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 0 } };
		MatrizAdjacencia m0 = new MatrizAdjacencia(matriz0);
		System.out.println("\nM0");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m0));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m0));
		System.out.println(MatrizAdjacencia.grausDoVertice(m0));

		// Dirigido\multigrafo\regular
		int matriz1[][] = { { 0, 1, 0, 0, 2 }, { 1, 1, 1, 0, 0 }, { 1, 0, 1, 1, 0 }, { 0, 0, 1, 1, 1 },
				{ 1, 1, 0, 1, 0 } };

		MatrizAdjacencia m1 = new MatrizAdjacencia(matriz1);
		System.out.println("\nM1");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m1));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m1));
		System.out.println(MatrizAdjacencia.grausDoVertice(m1));

		// N�o dirigido- Simples\N�o Regular
		int matriz2[][] = { { 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 1 }, { 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 0 },
				{ 1, 1, 1, 0, 0 } };
		MatrizAdjacencia m2 = new MatrizAdjacencia(matriz2);
		System.out.println("\nM2");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m2));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m2));
		System.out.println(MatrizAdjacencia.grausDoVertice(m2));

		// Dirigido\Multigrafo\n�o regular
		int matriz3[][] = { { 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 1 }, { 0, 2, 0, 1, 1 }, { 1, 1, 1, 0, 0 },
				{ 1, 1, 1, 0, 0 } };
		MatrizAdjacencia m3 = new MatrizAdjacencia(matriz3);
		System.out.println("\nM3");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m3));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m3));
		System.out.println(MatrizAdjacencia.grausDoVertice(m3));

		// nul0
		int matriz4[][] = { { 0, 0, 0, 0, }, { 0, 0, 0, 0, }, { 0, 0, 0, 0, }, { 0, 0, 0, 0, } };
		MatrizAdjacencia m4 = new MatrizAdjacencia(matriz4);
		System.out.println("\nM4");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m4));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m4));
		System.out.println(MatrizAdjacencia.grausDoVertice(m4));

		int matriz5[][] = { { 0, 1, 1 }, { 1, 0, 1 }, { 1, 1, 0 } };

		MatrizAdjacencia m5 = new MatrizAdjacencia(matriz5);
		System.out.println("\nM5");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m5));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m5));
		System.out.println(MatrizAdjacencia.grausDoVertice(m5));

		// N�o dirigido- Simples\N�o Regular\bipartido
		int matriz6[][] = { { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 0, 0 }, { 1, 1, 0, 0 } };

		MatrizAdjacencia m6 = new MatrizAdjacencia(matriz6);
		System.out.println("\nM6");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m6));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m6));
		System.out.println(MatrizAdjacencia.grausDoVertice(m6));

		// Dirigido- Multigrado\N�o Regular\bipartido
		int matriz7[][] = { { 0, 3, 1, 1 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		MatrizAdjacencia m7 = new MatrizAdjacencia(matriz7);
		System.out.println("\nM7");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m7));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m7));
		System.out.println(MatrizAdjacencia.grausDoVertice(m7));

		// N�o dirigido- Simples\N�o Regular\completo\bipartido
		int matriz8[][] = { { 0, 1 }, { 1, 0 }, };

		MatrizAdjacencia m8 = new MatrizAdjacencia(matriz8);
		System.out.println("\nM8");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m8));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m8));
		System.out.println(MatrizAdjacencia.grausDoVertice(m8));

		;
	}

}
