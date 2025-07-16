package br.com.rolf.exercicios.arrays_matrizes;

import java.util.InputMismatchException;
import java.util.Scanner;

import br.com.rolf.utilidades.EntradaUtils;

public final class MatrizUtilsRefactory {
	
	private  MatrizUtilsRefactory() {
	}

	//_____________________________________________________________________//
	//_____________________________________________________________________//
	
	

	
	//MÉTODOS DE CRIAÇÃO DE MATRIZES
	
	public static int[] retornaNumeroLinhaColuna() {
		
		int linha = EntradaUtils.lerInteiro("Digite o número de linha da matriz");
		int coluna = EntradaUtils.lerInteiro("Digite o número de coluna da matriz");
		
		return new int[] {linha, coluna};
	}
	//_____________________________________________________________________//
	
	public static int[][] criaMatriz() {
		
		int[][] matriz = null;
		int[] numeroLinhaColuna = retornaNumeroLinhaColuna();
		matriz = new int[numeroLinhaColuna[0]][numeroLinhaColuna[1]];

		return matriz;
	}

	//_____________________________________________________________________//
	
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
	
	//_____________________________________________________________________//
	//_____________________________________________________________________//
	
	//MÉTODOS DE PESQUISA
	
	
	
	public static int[] retornaIndices(int[][] matriz) {
		
		int numeroPesquisado = EntradaUtils.lerInteiro("Digite o número para pesquisa");
		int[] indices = new int [2];
		
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
	
	
	
	
	
	// MÉTODOS PARA IMPRESSAO DE VETORES E MATRIZES
	
	
	public static void imprimeVetor(int[] vect) {
		for (int i = 0; i < vect.length; i++) {
			System.out.print(vect[i] + " ");
		}
		System.out.println();
	}
	
	//_____________________________________________________________________//
	
	public static void imprimeMatriz(int[][] matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//_____________________________________________________________________//
	
//	MÉTODOS PARA PREENCHER MATRIZES E VETORES
	
	public static void preencheMatrizNumerosSequenciais(int[][] matriz) {
		
		int count = 1;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = count++;
			}
		}
	}
	
	//_____________________________________________________________________//
	
	public static void preencheMatrizNumerosAleatorios(int[][] matriz, int min, int max) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) (Math.random() * (max - min + 1) + min);
			}
		}
	}
	
	//_____________________________________________________________________//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
