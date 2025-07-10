package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Iterator;
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
	
	//METODOS PARA IMPRIMIR TRECHOS ESPECIFICOS DA MATRIZ
	
	
	public static void imprimeDiagonais(int[][] matriz, Scanner sc ) {
		
		System.out.println("Escolha a diagonal para ser impressa:");
		System.out.println("Diagonal principal: 1");
		System.out.println("Diagonal secundária: 2");
		int opcao = sc.nextInt();
		sc.nextLine();
		
		
		if (opcao == 1) {
			
			System.out.println("Diagonal Principal");
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					
					if (i == j) {
						System.out.print(matriz[i][j] + " ");
					}
				}
				System.out.println();
			}
		}else {
			System.out.println("Diagonal Secundária");
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					
					if (i + j == matriz.length - 1 ) {
						System.out.print(matriz[i][j] + " ");
					}
				}
				
				System.out.println();
			}
		}
	}
	
	public static void imprimeColunas(int[][] matriz, Scanner sc) {
		
		System.out.println("Digite a coluna que deseja imprimir");
		int numeroColuna = sc.nextInt();
		sc.nextLine();
		//converte o numero da coluna em índice
		//Exemplo: se for digitado coluna 1, o indice da coluna é o 0
		numeroColuna -= 1;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (j == numeroColuna) {
					System.out.print(matriz[i][numeroColuna] + " ");
					
				}
			}
			System.out.println();
		}
		
	}
	
	public static void iteraElementos(int[][] matriz) {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
//				matriz[i][j];
			}
		}
	}
	
	
}
