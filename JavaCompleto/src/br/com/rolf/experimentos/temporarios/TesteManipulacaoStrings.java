package br.com.rolf.experimentos.temporarios;

import java.util.Scanner;

import br.com.rolf.exercicios.arrays_matrizes.MatrizUtils;

public class TesteManipulacaoStrings {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int linha = 0;
		int coluna = 0;
//		int[] linhaColuna = MatrizUtils.defineTamanhoMatriz(linha, coluna, sc);
//		
//		int[][] m = new int[linhaColuna[0]][linhaColuna[1]];
//		MatrizUtils.insereNumerosAleatorios(m);
//		MatrizUtils.imprimeSaida(m);
		
//		MatrizUtils.imprimeLinhas(m, sc);
		
//		int[][] m2 = new int[linhaColuna[0]][linhaColuna[1]];
//		MatrizUtils.converteMatrizString(m2);
		
//		MatrizUtils.imprimeSaida(m);
		
//		int[][] matrizTeste = criaMatrizRetangular(linha, coluna, sc);
//		System.out.println(matrizTeste.length);
//		MatrizUtils.imprimeSaida(matrizTeste);
		
		//implementa uma matriz denteada
//		int[][] matrizDenteada = new int[defineQuantidadeLinha(linha, sc)][];
//		for (int i = 0; i < matrizDenteada.length; i++) {
//			matrizDenteada[i] = new int[defineQuantidadeColunas(coluna, sc)];
//		}
		
		System.out.println("implementa uma matriz denteada com método");
		int[][] denteada = criaMatrizDeMatriz(linha, sc);
		
		
//		for (int i = 0; i < matrizDenteada.length; i++) {
//			coluna = defineQuantidadeColunas(coluna, sc);
//			for (coluna = 0; coluna < matrizDenteada[i].length; coluna++) {
//				System.out.println(matrizDenteada[i][coluna] + " "); 
//			}
//			System.out.println();
//		}
		MatrizUtils.imprimeSaida(denteada);
		
		sc.close();
		
	}
	
	
	public static void imprimeLinhas(int[][] matriz, Scanner sc) {
		System.out.println("Digite a linha que deseja imprimir");
		int numeroLinha = sc.nextInt();
		sc.nextLine();
		numeroLinha -= 1;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
//				essa condicional converte os valores das outras linhas em zero,
//				matendo apenas os numeros da linha escolhida
				if (i != numeroLinha) {
					matriz[i][j] = 0;
					
				}
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	//MÉTODOS PARA CRIAÇÃO DE MATRIZES
	
	public static int defineQuantidadeLinha(int linha, Scanner sc) {
		System.out.println("Digite a quantidade de linha da matriz");
		linha = sc.nextInt();
		sc.nextLine();
		
		
		return linha;
	}
	public static int defineQuantidadeColunas(int coluna, Scanner sc) {
		System.out.println("Digite a quantidade de coluna da matriz");
		coluna = sc.nextInt();
		sc.nextLine();
		
		
		return coluna;
	}
	
	public static int[][] criaMatrizRetangular(int linha,int coluna, Scanner sc) {
		linha = defineQuantidadeLinha(linha, sc);
		coluna = defineQuantidadeColunas(coluna, sc);
		
		return new int[linha][coluna];
	}
	
	
//	int[][] matrizDenteada = new int[defineQuantidadeLinha(linha, sc)][];
//	for (int i = 0; i < matrizDenteada.length; i++) {
//		matrizDenteada[i] = new int[defineQuantidadeColunas(coluna, sc)];
//	}
	
	public static int[][] criaMatrizDeMatriz(int linha , Scanner sc) {
		linha = defineQuantidadeLinha(linha, sc);
		int[][] m = new int[linha][];
		
		for (int i = 0; i < m.length; i++) {
			//inicializa linha
			m[i] = new int[defineQuantidadeColunas(i, sc)];
		}
		
		return m;
	}
	
	
	
//	public static void preencheMatriz(int[][]matriz, int coluna, Scanner sc) {
//		int linha = defineTamanhoMatriz(linha, sc);
//		
//		int count = 1;
//		for (int i = 0; i < matriz.length; i++) {
//			
//			System.out.println("Digite a quantidade de coluna da matriz");
//			coluna = sc.nextInt();
//			sc.nextLine();
//			for (int j = 0; j < matriz.length; j++) {
//				
//			}
//			
//			
//		}
//	}
	
	private static int defineTamanhoMatriz(int linha, Scanner sc) {
		// TODO Auto-generated method stub
		return 0;
	}


	//a quantidade de colunas deve ser definidos nos métodos para inserir valores 
	public static void insereNumerosSequenciais(int [][] matriz, Scanner sc)  {
		int count = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = count;
				count++;
			}
		}
		
	}

}
