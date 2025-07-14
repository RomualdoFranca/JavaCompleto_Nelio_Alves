package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Scanner;

public class Matriz01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] numeroLinhaColuna = MatrizUtilsRefactory.retornaNumeroLinhaColuna(sc);
		MatrizUtilsRefactory.imprimeVetor(numeroLinhaColuna);
		
		
		int[][] matriz01 = new int[numeroLinhaColuna[0]][numeroLinhaColuna[1]];
		MatrizUtilsRefactory.preencheMatrizNumerosSequenciais(matriz01);
		
		MatrizUtilsRefactory.imprimeMatriz(matriz01);

		System.out.println("_________________________");
		
		MatrizUtilsRefactory.preencheMatrizNumerosAleatorios(matriz01, 0, 9);
		MatrizUtilsRefactory.imprimeMatriz(matriz01);
		
		
		sc.close();
	}

}
