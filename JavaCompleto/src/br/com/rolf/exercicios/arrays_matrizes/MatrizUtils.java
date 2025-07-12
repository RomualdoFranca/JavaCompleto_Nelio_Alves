package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Iterator;
import java.util.Scanner;

// classe declarada como final para impedir que seja extendida
public final class MatrizUtils {

	//declarando um contrutor privado  impede que qualquer código externo
	//(ou mesmo a própria classe) crie novas instâncias dela.
	private MatrizUtils() {
		
	}
	
	//**************MÉTODOS ESTÁTICOS*****************//
	
	
	//MÉTODOS PARA CRIAÇÃO DE MATRIZES//
	
	public static int defineQuantidadeLinhas(Scanner sc) {
		System.out.println("Digite a quantidade de linha da matriz");
		int linha = sc.nextInt();
		sc.nextLine();
		return linha;
	}
	
	public static int defineQuantidadeColunas(Scanner sc) {
		System.out.println("Digite a quantidade de coluna da matriz");
		int coluna = sc.nextInt();
		sc.nextLine();
		
		return coluna;
	}
	
	public static int[][] criaMatrizRetangular(Scanner sc) {
		int linha = defineQuantidadeLinhas(sc);
		int coluna = defineQuantidadeColunas(sc);
		
		return new int [linha][coluna];
	}

	
	public static int[][] criaMatrizDenteada(Scanner sc) {

		int[][] m = new int [defineQuantidadeLinhas(sc)][];
		
		for (int i = 0; i < m.length; i++) {
			//inicializa as linhas de 'm'
			m[i] = new int[defineQuantidadeColunas(sc)];
		}
		
		return m;
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
	
	//MÁTODOS PARA BUSCAR ELEMENTOS ESPECÍFICOS DAS MATRIZES
	
	public static boolean temNumeroPar(int[][] matriz, Scanner sc) {
		
//		int[] numeroPar = new int[matriz.length];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				if (matriz[i][j] % 2 == 0) {
						return true;
					
//					for (int j2 = 0; j2 < numeroPar.length; j2++) {
//						numeroPar[j2] = matriz[i][j];
//						
//					}
				}
			}
		}
		return false;
	}
	
	public static void iteraSobreVetor(int[] vect) {
		for (int i : vect) {
			System.out.print(i + " ");
		}
	}
	
	public static void buscaNumeroImpar(int[][] matriz, Scanner sc) {
		
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
	
	public static boolean pesquisaExistenciaNumero(int num, boolean hasNumero, int[][] matriz, Scanner sc) {
		
//		System.out.println("Digite o número para ser pesquisado:");
//		num = sc.nextInt();
//		sc.nextLine();

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				
				if (matriz[i][j] == num) {
					return hasNumero = true;
				}

			}
		}
		return hasNumero = false;
		
		
		
	}
	
	public static int contaFrequenciaNumero(int[][] matriz, Scanner sc) {

		System.out.println("Digite o número para ser pesquisado:");
		int num = sc.nextInt();
		sc.nextLine();
		
		int count = 0;
		
		if (pesquisaExistenciaNumero(num, false, matriz, sc) == true) {
			
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					
					if (matriz[i][j] == num) {
						return count;
					}
					count++;
				}
			}
		}
		
		return count;
	}
}
