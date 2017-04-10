package br.furb.trabalho01;

/*Equipe:
 * Guilherme H R
 *  Francisca E X
 */

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.sun.media.sound.InvalidFormatException;

import br.furb.Utils.MatrizAdjacencia;

public class Questao01 {
	public static void main(String[] args) throws IOException {

	/*	try {
			testePadrao();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
*/
		
		int opcao = 0;
		do {
			Scanner entrada = new Scanner(System.in);
			System.out.println(
					"Informe o nome de cada vertices da matriz de adjacência separadas por \";\"\nEx: v1;..;vn (Vertices com nomes iguais serão ignoradas)" );
			String[] v = (entrada.nextLine() + ";").split(";");
			//System.out.println(v.length);
			MatrizAdjacencia ma = null;
			try {
				ma = MatrizAdjacencia.criaMatriz(v);
				
			} catch (InvalidFormatException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

			int i = 0;
			int j = 0;

			int leitura = 0;
			do {
				System.out.println(
						"\nEscolha a forma de Entrada: \n1- Informar a string de uma matriz EX:({{N11,...,N1n},{Nnn,...,Nnn}{N,n1,...,Nnn}})  \n2- Informar os elementos da matriz separadamente.");
				Scanner inteiro = new Scanner(System.in);
				try {
					leitura = inteiro.nextInt();
				} catch (InputMismatchException ime) {
					leitura = -1;
					System.out.println(ime.getMessage());

				}

				// System.out.println(" " + ma.listaNomeVertices());

				// System.out.println("____" + new String(new
				// char[ma.listaNomeVertices().length()/2]).replace("", "_"));
				switch (leitura) {
				case 1:
					System.out.println("Apóz informar a Matriz perte duas vezes o \"Enter\" para confirmar.");
					System.out.println("Matriz:");
					Scanner s = new Scanner(System.in);
					String matrizString = "";
							
					
					String e = "";
					do {					
					e = s.nextLine();
					 matrizString += e;	
					
					// System.out.println("Scan"+matrizString);
					}while(!e.trim().equals(""));
					//s.close();
					
					//System.out.println("\nScan"+matrizString);
					//boolean matrizValida = false;
					
						try{
						ma.leMatrizString(matrizString);						
						}catch (InvalidFormatException ife) {
							System.err.print(ife.getMessage());
							leitura = -1;
							
						}catch (NumberFormatException nfe) {
							System.err.print(nfe.getMessage());
							leitura = -1;
						}
					
					break;

				case 2:

					for (i = 0; i < ma.getVertices().length; i++) {
						for (j = 0; j < ma.getVertices().length; j++) {
							System.out.print("Valor de [" + ma.getVertices()[i].getNome() + "]x["
									+ ma.getVertices()[j].getNome() + "] :");

							boolean isInt = false;
							while (!isInt) {
								Scanner inteiro1 = new Scanner(System.in);
								try {
									int a = inteiro1.nextInt();
									if (a < 0) {
										throw new IllegalArgumentException();
									}
									ma.getMatriz()[i][j] = a;
									isInt = true;
								} catch (InputMismatchException e1) {
									isInt = false;
									System.out.print("Informe um inteiro positivo!");
								} catch (IllegalArgumentException e1) {
									isInt = false;
									System.out.print("Informe um inteiro positivo!");
								}
								// }

							}

						}

					}

				default:
					leitura = -1;
					break;
				}
			} while (leitura != 1 && leitura != 2);
			
			do {
				System.out.println(
						"\nEcolha a Próxima ação:\n 1- Tipo do Grafo.\n 2- Arestas do Grafo \n 3- Graus do Vertice \n 4 -Novo Grafo\n 0- Sair");

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
					System.out.print("Opção inválida!");

					break;
				}

			} while (opcao != 0 && opcao != 4);

		} while (opcao != 0);

	}

	public static void testePadrao() throws Exception {
		// Não dirigido/Simples/regular completo
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

		// Não dirigido- Simples\Não Regular
		int matriz2[][] = { { 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 1 }, { 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 0 },
				{ 1, 1, 1, 0, 0 } };
		MatrizAdjacencia m2 = new MatrizAdjacencia(matriz2);
		System.out.println("\nM2");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m2));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m2));
		System.out.println(MatrizAdjacencia.grausDoVertice(m2));

		// Dirigido\Multigrafo\não regular
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

		// Não dirigido- Simples\Não Regular\bipartido
		int matriz6[][] = { { 0, 0, 1, 1 }, { 0, 0, 1, 1 }, { 1, 1, 0, 0 }, { 1, 1, 0, 0 } };

		MatrizAdjacencia m6 = new MatrizAdjacencia(matriz6);
		System.out.println("\nM6");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m6));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m6));
		System.out.println(MatrizAdjacencia.grausDoVertice(m6));

		// Dirigido- Multigrado\Não Regular\bipartido
		int matriz7[][] = { { 0, 3, 1, 1 }, 
							{ 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0 }, 
							{ 0, 0, 0, 0 } };
		MatrizAdjacencia m7 = new MatrizAdjacencia(matriz7);
		System.out.println("\nM7");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m7));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m7));
		System.out.println(MatrizAdjacencia.grausDoVertice(m7));

		// Não dirigido- Simples\Não Regular\completo\bipartido
		int matriz8[][] = { { 0, 1 },
							{ 1, 0 } };

		MatrizAdjacencia m8 = new MatrizAdjacencia(matriz8);
		System.out.println("\nM8");
		System.out.println(MatrizAdjacencia.tipoDoGrafo(m8));
		System.out.println(MatrizAdjacencia.arestasDoGrafo(m8));
		System.out.println(MatrizAdjacencia.grausDoVertice(m8));

		;
	}

}
