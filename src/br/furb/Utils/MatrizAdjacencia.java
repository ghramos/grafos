package br.furb.Utils;

import java.util.HashSet;
import java.util.Set;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class MatrizAdjacencia {
	private int [][] matriz;
	private Vertice[] vertices;
	

	/**
	 * 
	 * @param matriz - Matriz NxN
	 * @param listaVertices - nome dos vetores da matriz
	 * @throws Exception
	 */
	public MatrizAdjacencia(int [][] matriz , Vertice[] listaVertices ) throws Exception{				
		setMatriz(matriz);
		setVertices(listaVertices);
	}
	
	/**Gera vertices com nome "v+i"
	 * 
	 * @param matriz
	 * @throws Exception 
	 */
	public MatrizAdjacencia(int[][] matriz) throws Exception /*throws Exception*/{		
		setMatriz(matriz);
		vertices =  new Vertice[matriz.length];
		for(int i= 0; i< matriz.length;i++){
			vertices[i] = new Vertice("v"+ (i+1));
			
			
			
		}
	}
	
	/**Gera vertices com nome baseado na String[] 
	 * 
	 * @param matriz
	 * @throws Exception 
	 */
	public MatrizAdjacencia(int[][] matriz, String [] nomeVertices) throws Exception {		
		setMatriz(matriz);
		
		vertices =  new Vertice[matriz.length];
		for(int i= 0; i< matriz.length;i++){
			vertices[i] = new Vertice(nomeVertices[i]);
						
		}
	}
	private static String[] validaNomeVertices (String[] v){
		Set<String> nomeVetores = new HashSet<>();
		for(int i =0 ; i < v.length;i++){
			if (!v[i].trim().equals("")){
				if(!nomeVetores.add(v[i].trim())){
				System.out.println("Nome de vertice repitido:" + v[i] + " .Nome repetido será ignorado!");
				}
					
			}			
			
		}
		String[] s_nomeVetores;
		s_nomeVetores = nomeVetores.toArray(new String [nomeVetores.size()]); 		
		
		return s_nomeVetores;
		
	}
	public static MatrizAdjacencia criaMatriz  (String[] v) throws Exception{
		String[] nomeVertices = MatrizAdjacencia.validaNomeVertices(v);
		int[][] matriz = new int[nomeVertices.length][nomeVertices.length];

		return 	new MatrizAdjacencia(matriz, nomeVertices);
		
	}
	
	
	public String listaNomeVertices() {
		String saida = "";
		for(int i = 0; i< vertices.length; i++ ){
			saida+=" | "+vertices[i].getNome();
		}
		return saida;
	}
	
	public int[][] getMatriz() {
		return matriz;
	}
	public void setMatriz(int[][] matriz) throws Exception {
		if(matriz.length != matriz[0].length){
			throw new Exception("Matriz de Adjacência deve ser NxN");
		}else{
		this.matriz = matriz;
		}
		
	}
	public Vertice[] getVertices() {
		return vertices;
	}
	
	
	public void setVertices(Vertice[] listaVertices) {
		this.vertices = listaVertices;
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
