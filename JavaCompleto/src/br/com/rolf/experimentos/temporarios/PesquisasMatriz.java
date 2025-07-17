package br.com.rolf.experimentos.temporarios;

import java.util.Iterator;
import java.util.Scanner;

import br.com.rolf.exercicios.arrays_matrizes.MatrizUtils;
import br.com.rolf.exercicios.arrays_matrizes.MatrizUtilsRefactory;
import br.com.rolf.utilidades.EntradaUtils;

public class PesquisasMatriz {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] m = MatrizUtilsRefactory.criaMatriz();
		MatrizUtilsRefactory.preencheMatrizNumerosSequenciais(m);
		MatrizUtils.imprimeSaida(m);
		int[] indices = MatrizUtilsRefactory.retornaIndices(m);
		
		System.out.println("O número pesquisado se encontra na\nlinha: " +
				(indices[0]) + "\ncoluna:  " + (indices[1]));
		
		int[] numerosVizinhos = retornaNumerosVizinhos(m, indices[0], indices[1]);
		
//		EntradaUtils.lerVizinhos("""
//				
//				""".formatted(args));
		
//		MatrizUtils.insereNumerosAleatorios(m);



		sc.close();

	}//fim do metodo main
	
	public static int[] retornaNumerosVizinhos(int[][] matriz, int linha, int coluna) {
		int[] numVizinhos = new int[4];
		int ultimaLinhaColuna = matriz.length - 1;
		
		int numMaxCol = 0;
		//loops para retornar o número máximo de colunas
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				numMaxCol++;
			}
			break; // interrompe o loop interno depois do primeiro ciclo
		}
		
		//numero pesquisado esta no vertice superior esquerdo
		if (linha + coluna == 0) {
			numVizinhos[0] = matriz[linha + 1][coluna];//vizinho abaixo
			numVizinhos[1] = matriz[linha][coluna + 1];//vizinho a direita
//			EntradaUtils.lerVizinhos(" Número Abaixo: %d\nNúmero à Direita: %d", numVizinhos[0], numVizinhos[1]);
			
			EntradaUtils.lerVizinhos("""
					Vizinho Abaixo: %d
					Vizinho à Direita: %d
					""".formatted(numVizinhos[0], numVizinhos[1]));
			
		//o numero pesquisado esta no vertice superior direito
		}else if (linha + coluna == coluna) {
			numVizinhos[0] = matriz[linha][coluna - 1];//vizinho esquerda
			numVizinhos[1] = matriz[linha + 1][coluna];//vizinho abaixo
			
			EntradaUtils.lerVizinhos("""
					Vizinho à Esquerda: %d
					Vizinho Abaixo: %d
					""".formatted(numVizinhos[0], numVizinhos[1]));
			
		// o numero pesquisado esta no vertice inferior esquerdo
		}else if (linha + coluna == linha) {
			numVizinhos[0] = matriz[linha -1 ][coluna];//vizinho acima
			numVizinhos[1] = matriz[linha][coluna + 1];//vizinho a direita
			
			EntradaUtils.lerVizinhos("""
					Vizinho Acima: %d
					Vizinho à Direita: %d
					""".formatted(numVizinhos[0], numVizinhos[1]));
			
		// o numero pesquisado esta no vertice inferior direito
		}else if (linha == ultimaLinhaColuna && coluna == numMaxCol - 1 ) {
			numVizinhos[0] = matriz[linha - 1][coluna];//vizinho acima
			numVizinhos[1] = matriz[linha][coluna - 1];//vizinho a esquerda
			
			EntradaUtils.lerVizinhos("""
					Vizinho Acima: %d
					Vizinho à Esquerda: %d
					""".formatted(numVizinhos[0], numVizinhos[1]));
			
		}

		return numVizinhos;
	}
	
	
	
	//retorna vizinhos numero do vertice esquerdo no topo da matriz
	
	public static int[] retornaNumerosVizinhosVerticeEsquerdoTopo(int[][] matriz, int linha, int coluna) {
		int[] numVizinhos = null;
		
		if (linha + coluna == 0) {
			numVizinhos = new int[matriz[linha + 1][coluna]];
			numVizinhos = new int[matriz[linha][coluna + 1]];
		}
		
		return numVizinhos;
	}
	
	public static void escolheMetodo(int[][] matriz, int numeroPesquisado) {
		
		int[] indices = retornaIndices(matriz, numeroPesquisado);
		//indices[0] correponde ao indice da linha da matriz
		if (indices[0] == 0) {//o numero está na 1° linha
			System.out.println("Metodo do topo");
			int[] numerosVizinhos = retornaNumerosVizinhosTopo(matriz, indices[0], indices[1]);
			System.out.println("Numero  vizinho: " + numerosVizinhos[0] +
					"\nNúmero vizinho: " + numerosVizinhos[1]);
			
		}else if (indices[0] == matriz.length - 1){//o numero está na última linha
			System.out.println("Metodo da base");
			int[] numerosVizinhos = retornaNumerosVizinhosBase(matriz, indices[0], indices[1]);
			System.out.println("Numero  vizinho: " + numerosVizinhos[0] +
					"\nNúmero vizinho: " + numerosVizinhos[1]);
			
		}else {//o numero está entre o topo e a base
			System.out.println("Numero está entre o topo e a base da matriz");
			int[] numerosVizinhos = retornaNumerosVizinhosPrimeiraColunaEntreTopoBase(matriz, indices[0], indices[1]);
			System.out.printf("Numero vizinho: %d\nNumero vizinho: %d\nNumero vizinho: %d\n",
					numerosVizinhos[0], numerosVizinhos[1], numerosVizinhos[2]);
			System.out.println();
			
		}
		
		
		
	}
	
	public static int[] retornaNumerosVizinhosPrimeiraColunaEntreTopoBase(int[][] matriz, int linha, int coluna) {
		
		int ultimaLinhaColuna = matriz.length - 1;
		//variaveis com as posições dos numeros vizinhos
		int numeroAcima = linha - 1;
		int numeroAbaixo = linha + 1;
		int numeroEsquerda = coluna -1;
		int numeroDireita = coluna + 1;
		
		if (coluna == 0) {
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoAcima = matriz[numeroAcima][0];
					int vizinhoAbaixo = matriz[numeroAbaixo][0];
					int vizinhoDireita = matriz[linha][numeroDireita];
					return new int[] { vizinhoAcima, vizinhoAbaixo, vizinhoDireita,  };
				}
			}
		}
		
		
		return null;
	}
	

	public static int[] retornaNumerosVizinhosTopo(int[][] matriz,int linha, int coluna) {

		int ultimaLinhaColuna = matriz.length - 1;
		//valor booleano indicando que o numero esta entre os vertices
//		boolean entreVertices = coluna > 0 && coluna < ultimaLinhaColuna;
		
		if (coluna == 0) {
			//o numero não tem numeros acima e a esquerda
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoDireita = matriz[0][1];
					int vizinhoAbaixo = matriz[1][0];
					return new int[] { vizinhoDireita, vizinhoAbaixo };
				}
			}
		}else if (coluna == ultimaLinhaColuna) {
			//o numero não tem numeros acima e a direita
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[0][1];
					int vizinhoAbaixo = matriz[1][ultimaLinhaColuna];
					return new int[] { vizinhoEsquerda, vizinhoAbaixo };
				}
			}
			
		}else {
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[0][coluna - 1];
					int vizinhoDireita = matriz[0][coluna + 1];
					return new int[] { vizinhoEsquerda, vizinhoDireita };
				}
			}
		}
		return null;
	}
		
	public static int[] retornaNumerosVizinhosBase(int[][] matriz,int linha, int coluna) {
		
		int ultimaLinhaColuna = matriz.length - 1;
		//valor booleano indicando que o numero esta entre os vertices
//		boolean entreVertices = coluna > 0 && coluna < ultimaLinhaColuna;
		
		if (coluna == 0) {
			//o numero não tem numeros abaixo e a esquerda
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoDireita = matriz[ultimaLinhaColuna][1];
					int vizinhoAcima = matriz[ultimaLinhaColuna - 1][0];
					return new int[] { vizinhoDireita, vizinhoAcima };
				}
			}
		}else if (coluna == ultimaLinhaColuna) {
			//o numero não tem numeros acima e a direita
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[ultimaLinhaColuna][ultimaLinhaColuna - 1];
					int vizinhoAcima = matriz[ultimaLinhaColuna - 1][ultimaLinhaColuna];
					return new int[] { vizinhoEsquerda, vizinhoAcima };
				}
			}
			
		}else {
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[ultimaLinhaColuna][coluna - 1];
					int vizinhoDireita = matriz[ultimaLinhaColuna][coluna + 1];
					return new int[] { vizinhoEsquerda, vizinhoDireita };
				}
			}
		}
		return null;
	}
	


	public static int selecionaNumero(Scanner sc) {
		System.out.println("Digite um número");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	// retorna os indices dos numeros vizinhos do vertice correspondente

	public static int[] retornaNumerosVizinhosVerticeEsquerdoTopo(int[][] matriz) {

		int[] numerosContiguos = new int[2];
		// numerosContiguos[0] = numero da direita
		// numerosContiguos[1] = numero abaixo

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				if (i == 0 && j == 1) {// numero da direita
					numerosContiguos[0] = matriz[i][j];

				} else if (i == 1 && j == 0) {// numero abaixo
					numerosContiguos[1] = matriz[i][j];
				}
			}
		}

		return numerosContiguos;

	}

	public static void estaNoVertice(int[][] matriz, int linha, int coluna) {

		int ultimaColunaLinha = matriz.length - 1;

		int[] vectIndice = new int[] { linha, coluna };

		// se a condicao for true, o numero ta no topo da matriz
		if (vectIndice[0] == 0) {
			// verifica se esta nos vértices da esquerda ou direita
			if (vectIndice[1] == 0) {
				System.out.println("O número está no vértice esquerdo no topo da matriz");

			} else if (vectIndice[1] == ultimaColunaLinha) {
				System.out.println("O número está no vértice direito no topo da matriz");

			} else {
				// para uma futura implementação: retornar a coluna em que o numero se encontra
				System.out.println("O número está no topo, entre os vértices");
			}

			// indica que o numero esta na base da martiz
		} else if (vectIndice[0] == ultimaColunaLinha) {
			// verifica se esta nos vértices da esquerda ou direita
			if (vectIndice[1] == 0) {
				System.out.println("O número está no vértice esquerdo na base da matriz");

			} else if (vectIndice[1] == ultimaColunaLinha) {
				System.out.println("O número está no vértice direito na base da matriz");

			} else {
				System.out.println("O número está na base, entre os vértices");
			}

		} else {
			System.out.println("O número não está nos extremos da matriz");
		}
	}

	public static int[] retornaIndices(int[][] matriz, int numeroPesquisado) {

//		int[] vect = new int[2];

		boolean temNumero = MatrizUtils.verificaExistenciaNumero(numeroPesquisado, false, matriz);
		if (temNumero == true) {

			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if (matriz[i][j] == numeroPesquisado) {
//						vect[0] = i;
//						vect[1] = j;
						return new int[] { i, j };
					}
				}
			}
		} else {
			System.out.println("Número inexistente");
		}
		return null;
	}

}
