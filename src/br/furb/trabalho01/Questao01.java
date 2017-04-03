package br.furb.trabalho01;

/*Equipe:
 * Guilherme H R
 *  Francisca E X
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import br.furb.Utils.Grafo;

public class Questao01 {
	public static void main(String[] args) throws IOException {
		
		//Dirigido\multigrafo
		int matriz[][] = { {0,1,0,0,2}, 
						   {1,0,1,0,1},
						   {0,1,0,1,1},
						   {1,0,1,1,0},
						   {1,0,1,1,0}
						   };
		//Não dirigido- Simples
		int matriz2[][] = {{0,1,0,1,1}, 
						   {1,0,1,0,1},
						   {0,1,0,1,1},
						   {1,0,1,0,0},
						   {1,1,1,0,0}
						   };
		//Dirigido\Simples
				int matriz3[][] = {{0,1,0,1,1}, 
								   {1,0,1,0,1},
								   {0,2,0,1,1},
								   {1,1,1,0,0},
								   {1,1,1,0,0}
								   };
		
		
		System.out.println(tipoDoGrafo(matriz));
		System.out.println(tipoDoGrafo(matriz2));	
		System.out.println(tipoDoGrafo(matriz3));
	;	

	}

	public static String tipoDoGrafo(int[][] matriz) {
		String Saida = "";
		boolean multigrafo = false;
		boolean simetria = true;//Simetricas ainda podem digrafos;
		boolean regular = true;
		boolean completo = true;
		boolean nulo = true;
		boolean bipartido = true;
		int totalColunaAnterior = 0;
				
		for (int i = 0; i < matriz.length; i++) {
			//int somaLinha = 0;
			int somaColuna = 0;	
		
			for (int j = 0; j < matriz.length; j++) {
				//System.out.println(i+":"+j);
				// Verifica Multigrafo
				if (!multigrafo) {
					if (i == j) {
						// Verifica primeiro se está na diagonal
						if (matriz[i][j] != 0) {
							multigrafo = true;
						}

					} else if (matriz[i][j] > 1) {
						// Verifica se contem arestas paralelas
						multigrafo = true;
					}
				}
				// Verifica Simetria
				if (simetria) {
					if (matriz[i][j] != matriz[j][i]) {
						simetria = false;
					}
				}
				//verifica Rregular
				somaColuna += matriz[i][j] ;

			}
			totalColunaAnterior = somaColuna;
			if(regular){
				System.out.println(somaColuna+":"+ totalColunaAnterior);	
				if(somaColuna != totalColunaAnterior ){
					
					regular = false;
				}				
			}
			
			System.out.println(somaColuna);			
		
		}
		
		if(simetria){
			Saida = "Não dirigido";
		}else{
			Saida = "Dirigido";
		}
		if(multigrafo){
			Saida += "- Multigrafo";
		}else{
			Saida += "- Simples";
		}
		if(regular){
			Saida += "-Regular";
		}else{
			Saida += "-NãoRegular";//para teste
			
		}
			
		
		return Saida;
	}

	public void arestasDoGrafo() {

	}

	public void grausDoVertice() {

	}

}
