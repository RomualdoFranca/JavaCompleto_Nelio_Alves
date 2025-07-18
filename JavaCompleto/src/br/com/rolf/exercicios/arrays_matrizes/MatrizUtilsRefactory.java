package br.com.rolf.exercicios.arrays_matrizes;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.rolf.utilidades.EntradaUtils;

public final class MatrizUtilsRefactory {

	private MatrizUtilsRefactory() {
	}

	// _____________________________________________________________________//
	// _____________________________________________________________________//

	// MÉTODOS DE CRIAÇÃO DE MATRIZES

	public static int[] retornaNumeroLinhaColuna() {

		int linha = EntradaUtils.lerInteiro("Digite o número de linha da matriz");
		int coluna = EntradaUtils.lerInteiro("Digite o número de coluna da matriz");

		return new int[] { linha, coluna };
	}
	// _____________________________________________________________________//

	public static int[][] criaMatriz() {

		int[][] matriz = null;
		int[] numeroLinhaColuna = retornaNumeroLinhaColuna();
		matriz = new int[numeroLinhaColuna[0]][numeroLinhaColuna[1]];

		return matriz;
	}

	// _____________________________________________________________________//

	public static int[][] criaMatrizDenteada() {

		int[][] matrizDenteada = null;

		int linha = EntradaUtils.lerInteiro("Digite o número de linha");
		matrizDenteada = new int[linha][];

		int coluna = 0;

		for (int i = 0; i < matrizDenteada.length; i++) {
			coluna = EntradaUtils.lerInteiro("Digite o número de coluna da " + (i + 1) + "° linha");

			matrizDenteada[i] = new int[coluna];
		}

		return matrizDenteada;
	}

	// _____________________________________________________________________//
	// _____________________________________________________________________//

	// MÉTODOS DE PESQUISA

	public static int[] retornaIndices(int[][] matriz) {

		int numeroPesquisado = EntradaUtils.lerInteiro("Digite o número para pesquisa");
		int[] indices = new int[2];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == numeroPesquisado) {
					indices[0] = i;
					indices[1] = j;
				}
			}
		}

		return indices;
	}
	// _____________________________________________________________________//

	public static int[] retornaNumerosVizinhosVertices(int[][] matriz, int linha, int coluna) {
		int[] numVizinhos = new int[4];
		int ultimaLinhaColuna = matriz.length - 1;

		int numMaxCol = matriz[0].length;
//		//loops para retornar o número máximo de colunas
//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz[i].length; j++) {
//				numMaxCol++;
//			}
//			break; // interrompe o loop interno depois do primeiro ciclo
//		}

		// numero pesquisado esta no vertice superior esquerdo
		if (linha + coluna == 0) {
			numVizinhos[0] = matriz[linha + 1][coluna];// vizinho abaixo
			numVizinhos[1] = matriz[linha][coluna + 1];// vizinho a direita
//			EntradaUtils.lerVizinhos(" Número Abaixo: %d\nNúmero à Direita: %d", numVizinhos[0], numVizinhos[1]);

			EntradaUtils.lerVizinhos("""
					Número pesquisado está no vértice superior esquerdo
					Vizinho Abaixo: %d
					Vizinho à Direita: %d
					""".formatted(numVizinhos[0], numVizinhos[1]));

			// o numero pesquisado esta no vertice superior direito
		} else if (linha + coluna == coluna) {
			numVizinhos[0] = matriz[linha][coluna - 1];// vizinho esquerda
			numVizinhos[1] = matriz[linha + 1][coluna];// vizinho abaixo

			EntradaUtils.lerVizinhos("""
					Número pesquisado está no vértice superior direito
					Vizinho à Esquerda: %d
					Vizinho Abaixo: %d
					""".formatted(numVizinhos[0], numVizinhos[1]));

			// o numero pesquisado esta no vertice inferior esquerdo
		} else if (linha + coluna == linha) {
			numVizinhos[0] = matriz[linha - 1][coluna];// vizinho acima
			numVizinhos[1] = matriz[linha][coluna + 1];// vizinho a direita

			EntradaUtils.lerVizinhos("""
					Número pesquisado está no vértice inferior esquerdo
					Vizinho Acima: %d
					Vizinho à Direita: %d
					""".formatted(numVizinhos[0], numVizinhos[1]));

			// o numero pesquisado esta no vertice inferior direito
		} else if (linha == ultimaLinhaColuna && coluna == numMaxCol - 1) {
			numVizinhos[0] = matriz[linha - 1][coluna];// vizinho acima
			numVizinhos[1] = matriz[linha][coluna - 1];// vizinho a esquerda

			EntradaUtils.lerVizinhos("""
					Número pesquisado está no vértice inferior direito
					Vizinho Acima: %d
					Vizinho à Esquerda: %d
					""".formatted(numVizinhos[0], numVizinhos[1]));

		}

		return numVizinhos;
	}
	// _____________________________________________________________________//

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
					Número pesquisado está na borda superior
					Vizinho Esquerda: %d
					Vizinho à Direita: %d
					Vizinho Abaixo: %d
					""".formatted(numVizinho[0], numVizinho[1], numVizinho[2]));
		} else if (bordaInferior) {
			numVizinho[0] = matriz[linha][coluna - 1];// esquerda
			numVizinho[1] = matriz[linha][coluna + 1];// direita
			numVizinho[2] = matriz[linha - 1][coluna];// acima

			EntradaUtils.lerVizinhos("""
					Número pesquisado está na borda inferior
					Vizinho Esquerda: %d
					Vizinho à Direita: %d
					Vizinho Acima: %d
					""".formatted(numVizinho[0], numVizinho[1], numVizinho[2]));
		} else if (bordaEsquerda) {
			numVizinho[0] = matriz[linha - 1][coluna];// acima
			numVizinho[1] = matriz[linha + 1][coluna];// abaixo
			numVizinho[2] = matriz[linha][coluna + 1];// direita

			EntradaUtils.lerVizinhos("""
					Número pesquisado está na borda à esquerda
					Vizinho Acima: %d
					Vizinho Abaixo: %d
					Vizinho à Direita: %d
					""".formatted(numVizinho[0], numVizinho[1], numVizinho[2]));
		} else if (bordaDireita) {
			numVizinho[0] = matriz[linha - 1][coluna];// acima
			numVizinho[1] = matriz[linha + 1][coluna];// abaixo
			numVizinho[2] = matriz[linha][coluna - 1];// esquerda

			EntradaUtils.lerVizinhos("""
					Número pesquisado está na borda à direita
					Vizinho Acima: %d
					Vizinho Abaixo: %d
					Vizinho à Esquerda: %d
					""".formatted(numVizinho[0], numVizinho[1], numVizinho[2]));
		}

		return numVizinho;
	}
	// _____________________________________________________________________//

	public static void retornaVizinhos(int[][] matriz, int linha, int coluna) {

		int numMaxCol = matriz[0].length;

		boolean numeroVertices = (linha == 0 || linha == matriz.length - 1) && (coluna == 0 || coluna == numMaxCol - 1);
//		boolean numeroBordas = (linha >= matriz.length - 1 || linha >= 0) && (coluna < numMaxCol && coluna > 0);

		boolean numeroBordas = (linha == 0 && (coluna < numMaxCol && coluna > 0) // borda superior
				|| linha == matriz.length - 1 && (coluna < numMaxCol && coluna > 0)// borda inferior
				|| (linha < matriz.length - 1 && linha > 0) && coluna == 0 // borda esquerda
				|| (linha < matriz.length - 1 && linha > 0) && coluna < numMaxCol); // borda direita

		if (numeroVertices) {
			MatrizUtilsRefactory.retornaNumerosVizinhosVertices(matriz, linha, coluna);
		} else if (numeroBordas) {
			MatrizUtilsRefactory.retornaVizinhosBordas(matriz, linha, coluna);
		}

	}

	// _____________________________________________________________________//

	// MÉTODOS PARA IMPRESSAO DE VETORES E MATRIZES

	public static void imprimeVetor(int[] vect) {
		for (int i = 0; i < vect.length; i++) {
			System.out.print(vect[i] + " ");
		}
		System.out.println();
	}

	// _____________________________________________________________________//

	public static void imprimeMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}

	// _____________________________________________________________________//

//	MÉTODOS PARA PREENCHER MATRIZES E VETORES

	public static void preencheMatrizNumerosSequenciais(int[][] matriz) {

		int count = 1;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = count++;
			}
		}
	}

	// _____________________________________________________________________//

	public static void preencheMatrizNumerosAleatorios(int[][] matriz, int min, int max) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) (Math.random() * (max - min + 1) + min);
			}
		}
	}

	// _____________________________________________________________________//

}
