package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Scanner;

public class Matriz01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[] numeroLinhaColuna = MatrizUtilsRefactory.retornaNumeroLinhaColuna(sc);
		
		sc.close();
	}

}
