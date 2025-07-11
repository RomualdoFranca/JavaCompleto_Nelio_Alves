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
	//(int[][] matriz,int linha, int coluna ,Scanner sc)
	public static void converteMatrizString(int[][] matriz) {
//		linha = 0;
//		coluna = 0;
		String[][] numerosEmString = new String[matriz.length][];
		
		for (int i = 0; i < numerosEmString.length; i++) {
			numerosEmString[i] = new String[matriz.length];
			for (int j = 0; j < matriz[i].length; j++) {
				numerosEmString[i][j] = String.valueOf(matriz[i][j]);
//				System.out.print(numerosEmString[i][j] + " ");
			}
//			System.out.println();
		}
		
		if(numerosEmString instanceof String[][]) {
			System.out.println("Matriz foi convertida");
		}
		
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
	
	public static void imprimeLinhas(int[][] matriz, Scanner sc) {
		System.out.println("Digite a linha que deseja imprimir");
		int numeroLinha = sc.nextInt();
		sc.nextLine();
		numeroLinha -= 1;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				
				if (i == numeroLinha) {
					System.out.print(matriz[numeroLinha][j] + " ");
					
				}
				
				//essa condicional converte os valores das outras linhas em zero,
				//matendo apenas os numeros da linha escolhida
//				if (i != numeroLinha) {
//					matriz[i][j] = 0;
//					
//				}
//				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
	// MÉTODOS PARA PESQUISA DE VALORES
	
	public static boolean pesquisaExistenciaNumero(boolean hasNumero, int[][] matriz, Scanner sc) {
		
		System.out.println("Digite o número para ser pesquisado:");
		int num = sc.nextInt();
		sc.nextLine();
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				if (matriz[i][j] == num) {
					return hasNumero = true;
				}
				break;
			}
		}
		return hasNumero = false;
		
		
		
		
	}
	
	public static void iteraElementos(int[][] matriz, Scanner sc) {
		
		if (pesquisaExistenciaNumero(false, matriz, sc) == true) {
			
			System.out.println("Número encontrado");
			
		}else {
			System.out.printf("Número não foi encontrado");
			
		}
		
//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz[i].length; j++) {
//
//			
//			}
//		}
	}
	
	
}
