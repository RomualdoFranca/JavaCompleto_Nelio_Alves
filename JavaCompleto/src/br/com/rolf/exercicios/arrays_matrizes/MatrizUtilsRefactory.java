package br.com.rolf.exercicios.arrays_matrizes;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class MatrizUtilsRefactory {
	
	private  MatrizUtilsRefactory() {
	}

	//_____________________________________________________________________//
	//_____________________________________________________________________//
	
	//MÉTODOS DE CRIAÇÃO DE MATRIZES
	
	public static int[] retornaNumeroLinhaColuna(Scanner sc) {
		int linha = 0;
		int coluna = 0;
		
		boolean entradaValida = false; // flag para controlar o loop
		
		do {
			try {
				System.out.println("Digite o número de linha da matriz");
				linha = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Digite o número de coluna da matriz");
				coluna= sc.nextInt();
				sc.nextLine();
				entradaValida = true;
				
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida");
				sc.next();// Limpa o buffer do scanner para evitar loop infinito
							//Consome a entrada inválida para que o scanner não tente lê-la novamente
			}
			
		} while (!entradaValida);
		
		
		return new int[] {linha, coluna};
	}
	
	
	//_____________________________________________________________________//
	//_____________________________________________________________________//
	
	
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
