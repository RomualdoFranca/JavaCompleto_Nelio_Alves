package br.com.rolf.experimentos.temporarios;

import java.util.Scanner;

import br.com.rolf.exercicios.arrays_matrizes.MatrizUtils;

public class TesteManipulacaoStrings {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int linha = 0;
		int coluna = 0;
		int[] linhaColuna = MatrizUtils.defineTamanhoMatriz(linha, coluna, sc);
		
		int[][] m = new int[linhaColuna[0]][linhaColuna[1]];
		MatrizUtils.insereNumerosAleatorios(m);
		MatrizUtils.imprimeSaida(m);
		
//		MatrizUtils.imprimeLinhas(m, sc);
		
		int[][] m2 = new int[linhaColuna[0]][linhaColuna[1]];
		MatrizUtils.converteMatrizString(m2);
		
//		MatrizUtils.imprimeSaida(m);
		
		
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

}
