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
		
		MatrizUtils.imprimeLinhas(m, sc);
		
		sc.close();
		
	}

}
