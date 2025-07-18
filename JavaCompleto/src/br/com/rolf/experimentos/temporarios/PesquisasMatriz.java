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

		System.out.println("O número pesquisado se encontra na\nlinha: " + (indices[0]) + "\ncoluna:  " + (indices[1]));
		System.out.println("matriz.lenght: " + m.length);

//		int[] numerosVizinhos = MatrizUtilsRefactory.retornaNumerosVizinhosVertices(m,indices[0], indices[1]);
//		int[] vizinhosBordaSuperior = retornaVizinhosBordas(m, indices[0], indices[1]);

		System.out.println("Metodo retorna vizinhos geral");
		retornaVizinhos(m, indices[0], indices[1]);

//		EntradaUtils.lerVizinhos("""
//				
//				""".formatted(args));

//		MatrizUtils.insereNumerosAleatorios(m);

		sc.close();

	}// fim do metodo main

	public static void retornaVizinhos(int[][] matriz, int linha, int coluna) {

		int numMaxCol = matriz[0].length;

		boolean numeroVertices = (linha == 0 || linha == matriz.length - 1) && (coluna == 0 || coluna == numMaxCol - 1);
//		boolean numeroBordas = (linha >= matriz.length - 1 || linha >= 0) && (coluna < numMaxCol && coluna > 0);
		
		boolean numeroBordas = (linha == 0 && (coluna < numMaxCol && coluna > 0) //borda superior
				|| linha == matriz.length - 1 && (coluna < numMaxCol && coluna > 0)//borda inferior
				|| (linha < matriz.length - 1 && linha > 0) && coluna == 0 // borda esquerda
				|| (linha < matriz.length - 1 && linha > 0) && coluna < numMaxCol); // borda direita

		if (numeroVertices) {
			MatrizUtilsRefactory.retornaNumerosVizinhosVertices(matriz, linha, coluna);
		} else if (numeroBordas) {
			MatrizUtilsRefactory.retornaVizinhosBordas(matriz, linha, coluna);
		}

	}

	public static int[] retornaVizinhosBordas(int[][] matriz, int linha, int coluna) {

		int[] numVizinho = new int[4];
		int numMaxCol = matriz[0].length;

		boolean bordaSuperior = linha == 0 && (coluna < numMaxCol && coluna > 0);
		boolean bordaInferior = linha == matriz.length - 1 && (coluna < numMaxCol && coluna > 0);
		boolean bordaEsquerda = (linha < matriz.length - 1 && linha > 0) && coluna == 0;
		boolean bordaDireita = (linha < matriz.length - 1 && linha > 0) && coluna < numMaxCol;

		if (bordaSuperior) {
			numVizinho[0] = matriz[linha][coluna - 1];// esquerda
			numVizinho[1] = matriz[linha][coluna + 1];// direita
			numVizinho[2] = matriz[linha + 1][coluna];// abaixo

			EntradaUtils.lerVizinhos("""
					Vizinho Esquerda: %d
					Vizinho à Direita: %d
					Vizinho Abaixo: %d
					""".formatted(numVizinho[0], numVizinho[1], numVizinho[2]));
		} else if (bordaInferior) {
			numVizinho[0] = matriz[linha][coluna - 1];// esquerda
			numVizinho[1] = matriz[linha][coluna + 1];// direita
			numVizinho[2] = matriz[linha - 1][coluna];// acima

			EntradaUtils.lerVizinhos("""
					Vizinho Esquerda: %d
					Vizinho à Direita: %d
					Vizinho Acima: %d
					""".formatted(numVizinho[0], numVizinho[1], numVizinho[2]));
		} else if (bordaEsquerda) {
			numVizinho[0] = matriz[linha - 1][coluna];// acima
			numVizinho[1] = matriz[linha + 1][coluna];// abaixo
			numVizinho[2] = matriz[linha][coluna + 1];// direita

			EntradaUtils.lerVizinhos("""
					Vizinho Acima: %d
					Vizinho Abaixo: %d
					Vizinho à Direita: %d
					""".formatted(numVizinho[0], numVizinho[1], numVizinho[2]));
		} else if (bordaDireita) {
			numVizinho[0] = matriz[linha - 1][coluna];// acima
			numVizinho[1] = matriz[linha + 1][coluna];// abaixo
			numVizinho[2] = matriz[linha][coluna - 1];// esquerda

			EntradaUtils.lerVizinhos("""
					Vizinho Acima: %d
					Vizinho Abaixo: %d
					Vizinho à Esquerda: %d
					""".formatted(numVizinho[0], numVizinho[1], numVizinho[2]));
		}

		return numVizinho;
	}

	// retorna vizinhos numero do vertice esquerdo no topo da matriz

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
		// indices[0] correponde ao indice da linha da matriz
		if (indices[0] == 0) {// o numero está na 1° linha
			System.out.println("Metodo do topo");
			int[] numerosVizinhos = retornaNumerosVizinhosTopo(matriz, indices[0], indices[1]);
			System.out.println("Numero  vizinho: " + numerosVizinhos[0] + "\nNúmero vizinho: " + numerosVizinhos[1]);

		} else if (indices[0] == matriz.length - 1) {// o numero está na última linha
			System.out.println("Metodo da base");
			int[] numerosVizinhos = retornaNumerosVizinhosBase(matriz, indices[0], indices[1]);
			System.out.println("Numero  vizinho: " + numerosVizinhos[0] + "\nNúmero vizinho: " + numerosVizinhos[1]);

		} else {// o numero está entre o topo e a base
			System.out.println("Numero está entre o topo e a base da matriz");
			int[] numerosVizinhos = retornaNumerosVizinhosPrimeiraColunaEntreTopoBase(matriz, indices[0], indices[1]);
			System.out.printf("Numero vizinho: %d\nNumero vizinho: %d\nNumero vizinho: %d\n", numerosVizinhos[0],
					numerosVizinhos[1], numerosVizinhos[2]);
			System.out.println();

		}

	}

	public static int[] retornaNumerosVizinhosPrimeiraColunaEntreTopoBase(int[][] matriz, int linha, int coluna) {

		int ultimaLinhaColuna = matriz.length - 1;
		// variaveis com as posições dos numeros vizinhos
		int numeroAcima = linha - 1;
		int numeroAbaixo = linha + 1;
		int numeroEsquerda = coluna - 1;
		int numeroDireita = coluna + 1;

		if (coluna == 0) {
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoAcima = matriz[numeroAcima][0];
					int vizinhoAbaixo = matriz[numeroAbaixo][0];
					int vizinhoDireita = matriz[linha][numeroDireita];
					return new int[] { vizinhoAcima, vizinhoAbaixo, vizinhoDireita, };
				}
			}
		}

		return null;
	}

	public static int[] retornaNumerosVizinhosTopo(int[][] matriz, int linha, int coluna) {

		int ultimaLinhaColuna = matriz.length - 1;
		// valor booleano indicando que o numero esta entre os vertices
//		boolean entreVertices = coluna > 0 && coluna < ultimaLinhaColuna;

		if (coluna == 0) {
			// o numero não tem numeros acima e a esquerda
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoDireita = matriz[0][1];
					int vizinhoAbaixo = matriz[1][0];
					return new int[] { vizinhoDireita, vizinhoAbaixo };
				}
			}
		} else if (coluna == ultimaLinhaColuna) {
			// o numero não tem numeros acima e a direita
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[0][1];
					int vizinhoAbaixo = matriz[1][ultimaLinhaColuna];
					return new int[] { vizinhoEsquerda, vizinhoAbaixo };
				}
			}

		} else {

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

	public static int[] retornaNumerosVizinhosBase(int[][] matriz, int linha, int coluna) {

		int ultimaLinhaColuna = matriz.length - 1;
		// valor booleano indicando que o numero esta entre os vertices
//		boolean entreVertices = coluna > 0 && coluna < ultimaLinhaColuna;

		if (coluna == 0) {
			// o numero não tem numeros abaixo e a esquerda
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoDireita = matriz[ultimaLinhaColuna][1];
					int vizinhoAcima = matriz[ultimaLinhaColuna - 1][0];
					return new int[] { vizinhoDireita, vizinhoAcima };
				}
			}
		} else if (coluna == ultimaLinhaColuna) {
			// o numero não tem numeros acima e a direita
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[ultimaLinhaColuna][ultimaLinhaColuna - 1];
					int vizinhoAcima = matriz[ultimaLinhaColuna - 1][ultimaLinhaColuna];
					return new int[] { vizinhoEsquerda, vizinhoAcima };
				}
			}

		} else {

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
