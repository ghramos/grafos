package br.furb.trabalho01;

/*Equipe:
 * Guilherme H R
 *  Francisca E X
 */

import java.io.IOException;
import br.furb.Utils.Color;
import br.furb.Utils.MatrizAdjacencia;
public class Questao01 {
	public static void main(String[] args) throws IOException {

		// Não dirigido/Simples/regular completo
		int matriz0[][] = { {0,1,1,1},
							{1,0,1,1},
							{1,1,0,1},
							{1,1,1,0}};
		MatrizAdjacencia m0 = new MatrizAdjacencia(matriz0);
		System.out.println("\nM0");
		System.out.println(tipoDoGrafo(m0));
		System.out.println(arestasDoGrafo(m0));
		System.out.println(grausDoVertice(m0));

		// Dirigido\multigrafo\regular
		int matriz1[][] = { { 0, 1, 0, 0, 2 },
							{ 1, 1, 1, 0, 0 },
							{ 1, 0, 1, 1, 0 },
							{ 0, 0, 1, 1, 1 },
							{ 1, 1, 0, 1, 0 } };
		
		MatrizAdjacencia m1 = new MatrizAdjacencia(matriz1);
		System.out.println("\nM1");
		System.out.println(tipoDoGrafo(m1));
		System.out.println(arestasDoGrafo(m1));
		System.out.println(grausDoVertice(m1));
		
		// Não dirigido- Simples\Não Regular
		int matriz2[][] = { { 0, 1, 0, 1, 1 }, 
							{ 1, 0, 1, 0, 1 },
							{ 0, 1, 0, 1, 1 }, 
							{ 1, 0, 1, 0, 0 }, 
							{ 1, 1, 1, 0, 0 } };
		MatrizAdjacencia m2 = new MatrizAdjacencia(matriz2);
		System.out.println("\nM2");
		System.out.println(tipoDoGrafo(m2));
		System.out.println(arestasDoGrafo(m2));
		System.out.println(grausDoVertice(m2));
		
		// Dirigido\Multigrafo\não regular
		int matriz3[][] = { { 0, 1, 0, 1, 1 },
							{ 1, 0, 1, 0, 1 },
							{ 0, 2, 0, 1, 1 }, 
							{ 1, 1, 1, 0, 0 },
							{ 1, 1, 1, 0, 0 } };
		MatrizAdjacencia m3 = new MatrizAdjacencia(matriz3);
		System.out.println("\nM3");
		System.out.println(tipoDoGrafo(m3));
		System.out.println(arestasDoGrafo(m3));
		System.out.println(grausDoVertice(m3));
		
	
	 	//nul0
		int matriz4[][] = { { 0, 0, 0, 0,},
							{ 0, 0, 0, 0,},
							{ 0, 0, 0, 0,},
							{ 0, 0, 0, 0,}};
		MatrizAdjacencia m4 = new MatrizAdjacencia(matriz4);
		System.out.println("\nM4");
		System.out.println(tipoDoGrafo(m4));
		System.out.println(arestasDoGrafo(m4));
		System.out.println(grausDoVertice(m4));
		
		int matriz5[][] = { { 0, 1, 1},
							{ 1, 0, 1},
							{ 1, 1, 0}};
		
		MatrizAdjacencia m5 = new MatrizAdjacencia(matriz5);
		System.out.println("\nM5");
		System.out.println(tipoDoGrafo(m5));
		System.out.println(arestasDoGrafo(m5));
		System.out.println(grausDoVertice(m5));
							
							
		// Não dirigido- Simples\Não Regular\bipartido
		int matriz6[][] = { { 0, 0, 1, 1}, 
							{ 0, 0, 1, 1},
							{ 1, 1, 0, 0}, 
							{ 1, 1, 0, 0} };
		
		MatrizAdjacencia m6 = new MatrizAdjacencia(matriz6);
		System.out.println("\nM6");
		System.out.println(tipoDoGrafo(m6));
		System.out.println(arestasDoGrafo(m6));
		System.out.println(grausDoVertice(m6));
		
		//Dirigido- Multigrado\Não Regular\bipartido
		int matriz7[][] = { { 0, 3, 1, 1}, 
							{ 0, 0, 0, 0},
							{ 0, 0, 0, 0}, 
							{ 0, 0, 0, 0}};
		MatrizAdjacencia m7 = new MatrizAdjacencia(matriz7);
		System.out.println("\nM7");
		System.out.println(tipoDoGrafo(m7));
		System.out.println(arestasDoGrafo(m7));
		System.out.println(grausDoVertice(m7));
						
		
		// Não dirigido- Simples\Não Regular\completo\bipartido
		int matriz8[][] = { { 0, 1}, 
							{ 1, 0},
							};
		
		MatrizAdjacencia m8 = new MatrizAdjacencia(matriz8);
		System.out.println("\nM8");
		System.out.println(tipoDoGrafo(m8));
		System.out.println(arestasDoGrafo(m8));
		System.out.println(grausDoVertice(m8));

		//try {
		/*
		MatrizAdjacencia m0 = new MatrizAdjacencia(matriz0);
		System.out.println(tipoDoGrafo(m0));
		MatrizAdjacencia m1 = new MatrizAdjacencia(matriz1);
		System.out.println(tipoDoGrafo(m1));
		MatrizAdjacencia m2 = new MatrizAdjacencia(matriz2);
		System.out.println(tipoDoGrafo(m2));
		MatrizAdjacencia m3 = new MatrizAdjacencia(matriz3);
		System.out.println(tipoDoGrafo(m3));
		MatrizAdjacencia m4 = new MatrizAdjacencia(matriz4);
		System.out.println(tipoDoGrafo(m4));
		MatrizAdjacencia m5 = new MatrizAdjacencia(matriz5);
		System.out.println(tipoDoGrafo(m5));
		MatrizAdjacencia m6 = new MatrizAdjacencia(matriz6);
		System.out.println(tipoDoGrafo(m6));
		MatrizAdjacencia m7 = new MatrizAdjacencia(matriz7);
		System.out.println(tipoDoGrafo(m7));
		
		*/	
	
		
		;	
	

	}

	public static String tipoDoGrafo(MatrizAdjacencia m) {
		int[][] matriz = m.getMatriz();
		String Saida = "";
		boolean multigrafo = false;
		boolean simetria = true;// Simetricas ainda podem digrafos;
		boolean regular = true;
		boolean completo =false;
		boolean nulo = false;
		boolean bipartido = true;
		int totalLinhaAnterior = 0;
		int totalColunaAnterior = 0;
		int[] somaColuna = new int[matriz.length];

		for (int i = 0; i < matriz.length; i++) {
			int somaLinha = 0;

			for (int j = 0; j < matriz.length; j++) {
				// System.out.println(i+":"+j);
				// Verifica Multigrafo
				if (!multigrafo) {
					if (i == j) {
						// Verifica primeiro se está na diagonal
						if (matriz[i][j] != 0) {
							multigrafo = true;
							//completo = false;
						}

					} else if (matriz[i][j] > 1) {
						// Verifica se contem arestas paralelas
						multigrafo = true;
						//completo = false;
					}
				}
				// Verifica //dirigido Simetria
				if (simetria) {
					if (matriz[i][j] != matriz[j][i]) {
						simetria = false;
						//completo = false;
					}
				}
				
				//Verifica Bipartido
				if(bipartido){
					if(matriz[i][j] !=0){						
						 
						if(m.getVertices()[j].getCor()== Color.BRANCO){	
							if(m.getVertices()[i].getCor() == Color.BRANCO || m.getVertices()[i].getCor() == Color.PRETO){
								m.getVertices()[i].setCor(Color.PRETO);
								m.getVertices()[j].setCor(Color.CINZA);
							}else if(m.getVertices()[i].getCor() == Color.CINZA){
								m.getVertices()[j].setCor(Color.PRETO);
								
							}
						}else if(m.getVertices()[j].getCor()== Color.CINZA){
							if(m.getVertices()[i].getCor() == Color.BRANCO || m.getVertices()[i].getCor() == Color.PRETO){
								m.getVertices()[i].setCor(Color.PRETO);					
							}else{
								bipartido = false;
							}
							
						}else if(m.getVertices()[j].getCor()== Color.PRETO){
							if(m.getVertices()[i].getCor() == Color.BRANCO || m.getVertices()[i].getCor() == Color.CINZA){
								m.getVertices()[i].setCor(Color.CINZA);					
							}else{
								bipartido = false;
							}
						}						
					
						
					}				
					
				}				

				somaLinha += matriz[i][j];
				somaColuna[j] += matriz[i][j];

				//Verifica Regularidade das colunas 
				if (i == matriz.length - 1 && regular) {
					// System.out.println("coluna:"+somaColuna[j]+":"+
					
					if (somaColuna[j] != totalColunaAnterior && j > 0) {
						regular = false;
					}
					
					totalColunaAnterior = somaColuna[j];

				}
							
				

			}		
			
			//Verifica regularidade das linhas
			if (regular) {
				// System.out.println("linha:"+somaLinha+":"+ totalLinhaAnterior
				// );
				if (somaLinha != totalLinhaAnterior && i > 0) {
					// verifica primeiro se coluna é regular
					regular = false;
					//completo = false;
				}
				totalLinhaAnterior = somaLinha;
				//System.out.println(i +":"+m.getVertices()[i].getCor());
			}			
		}
		
		if(regular){		
			if (totalLinhaAnterior == matriz.length - 1) {
				completo = true;
				
			}else if(totalLinhaAnterior == 0){
				nulo = true;
				
			}

		}

		if (simetria) {
			Saida = "Não dirigido";
		} else {
			Saida = "Dirigido";
		}
		if (multigrafo) {
			Saida += " - Multigrafo";
		} else {
			Saida += " - Simples";
		}
		if (regular) {
			Saida += " - Regular";
			if (completo) {
				Saida += " - Completo";
			}else if(nulo){
				Saida += " - Nulo";
			}
		} else {
			Saida += " - NãoRegular";// para teste
		}
		
		if (bipartido) {
			Saida += " - Bipartido";
		}

		return Saida;
	}

	public static String arestasDoGrafo(MatrizAdjacencia m) {
		int[][] matriz = m.getMatriz();
		String saidaD = "E = {";
		String saidaND ="E = {";
		int totalArestas = 0;
		boolean simetria = true;
		for (int i = 0; i < matriz.length; i++) {			
			
			for (int j = 0; j < matriz.length; j++) {				
					
				if (matriz[i][j] != 0){
					// Verifica //dirigido Simetria
					if (simetria) {
						if (matriz[i][j] != matriz[j][i]) {
							simetria = false;
							//completo = false;
						}
					}
					
					int cont = 0;
					// Trata Arestas paralelas
					//if(matriz[i][j] >1){
					while(matriz[i][j] != cont){						
						saidaND += "("+i+","+j+")";					
						saidaD += "("+i+","+j+")";
								
						saidaD += ",";
						saidaND +=",";
						totalArestas ++;
						cont++;
					}				
				
				}
			}	
		}
		String saida;
		if(simetria){			
			saida = "|E| = "+(totalArestas/2)+"\n"+ saidaND.substring(0, saidaND.length()-1)+"}";
		}else{
			saida = "|E| = "+totalArestas+"\n"+saidaD.substring(0, saidaD.length()-1)+"}";	
		}
		return saida;

	}

	public static String grausDoVertice(MatrizAdjacencia m) {
		int[][] matriz = m.getMatriz();
		boolean simetria = true;
		String saidaD = "";
		String saidaEntrada ="";
		int[] seqgrauEntrada = new int[matriz.length];
		int[] seqgrauSaida = new int[matriz.length];
		int contEntrada = 0;
		int contSaida = 0;
		
		int[] grauEntrada = new int[matriz.length];
		
		for (int i = 0; i < matriz.length; i++) {	
			int somaLinha = 0;
			
			//System.out.println(m.getVertices()[i]);
			
			for (int j = 0; j < matriz.length; j++) {	
				
				// Verifica //dirigido Simetria
				if (simetria) {
					if (matriz[i][j] != matriz[j][i]) {
						simetria = false;
						//completo = false;
					}
				}			
				
				
				somaLinha += matriz[i][j];
				grauEntrada[j] += matriz[i][j];
				if(!simetria){
					if (i == matriz.length - 1){
						saidaEntrada += "grauEntrada(" +m.getVertices()[j].getNome() +") = "+grauEntrada[j]+" ;";	
						
						//ordena sequencia de grau de entrada
						
						if (contEntrada == 0){
							seqgrauEntrada[contEntrada] = grauEntrada[j];
							contEntrada ++;
							
						}else if(grauEntrada[j] >= seqgrauEntrada[contEntrada-1]){							
							seqgrauEntrada[contEntrada] = grauEntrada[j];//
							contEntrada ++;
							
						}else{
							int posicao = contEntrada;
							while(posicao!=0  && grauEntrada[j] < seqgrauEntrada[posicao-1]){
								int aux = seqgrauEntrada[posicao -1];
								seqgrauEntrada[posicao -1] = grauEntrada[j];						
								seqgrauEntrada[posicao] = aux;
								posicao --;
								
							}
							contEntrada ++;
							
						}
							
						
					  
					}
				}
												
			}
			saidaD += "grau(" + m.getVertices()[i].getNome() +") = "+somaLinha+"; ";
			
			if (contSaida == 0){
				seqgrauSaida[contSaida] = somaLinha;
				contSaida ++;
				
			}else if(somaLinha >= seqgrauSaida[contSaida-1]){	
				seqgrauSaida[contSaida] = somaLinha;//
				contSaida ++;
				
			}else{
				
				int posicao = contSaida;
				while(posicao !=0 && somaLinha < seqgrauSaida[posicao-1]){					
					int aux =seqgrauSaida[posicao-1];
					seqgrauSaida[posicao-1] = somaLinha;				
					seqgrauSaida[posicao] = aux;
					posicao --;
				}
				contSaida ++;
				
			}
			
		}		
		String saida = null;
			if(!simetria){
			saida = saidaEntrada;
			saida += "\n" +saidaD.replaceAll("grau", "grauSaida")+"\nSequencia de Grau de Entrada = ";
			String grauSaida= "";
			for(int i =0; i< matriz.length; i++){
				saida += seqgrauEntrada[i]+"; ";
				grauSaida += seqgrauSaida[i]+"; ";
			}
			saida += "\nSequencia de Grau de Saida = " +grauSaida;
		}else{
			saida = saidaD + "\nSequencia de Grau = " ;
			for(int i =0; i< matriz.length; i++){
				saida += seqgrauSaida[i]+"; ";
				
			}
		}
		
		
		return saida;

	}

}
