package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Scanner;

// classe declarada como final para impedir que seja extendida
public final class MatrizUtils {

	//declarando um contrutor privado  impede que qualquer código externo
	//(ou mesmo a própria classe) crie novas instâncias dela.
	private MatrizUtils() {
		
	}
	
	//métodos estáticos
	
	
	public static int[] defineTamanhoMatriz(int linha, int coluna, Scanner sc) {
		System.out.println("Digite a quantidade de linha da matriz");
		linha = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digite a quantidade de coluna da matriz");
		coluna = sc.nextInt();
		sc.nextLine();
		
		return new int[] {linha, coluna};
	}
	
	//MÉTODOS PARA INSERIR ELEMENTOS
	public static void insereNumerosSequenciais(int [][] matriz, Scanner sc)  {
		int count = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = count;
				count++;
			}
		}
		
	}
	
	public static void insereNumerosAleatorios(int[][] matriz) {
		//define o intervalo. Os numeros inseridos será de 0 a 9
		int min = 0;
		int max = 9;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) (Math.random() * (max - min + 1) + min);
			}
		}
		
		
	}
	
	//METODOS PARA FORMATAÇÃO DE SAÍDA
	public static void imprimeSaida(int[][] matriz) {
		System.out.println("-------------");
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();//necessário para separar as arrays posicionando uma abaixo da outra
		}
		System.out.println("-------------");
	}
	
	
	
	
}
