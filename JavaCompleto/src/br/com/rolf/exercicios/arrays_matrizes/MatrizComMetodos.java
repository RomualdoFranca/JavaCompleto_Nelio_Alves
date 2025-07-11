package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Scanner;

public class MatrizComMetodos {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		int[][] matriz01 = MatrizUtils.criaMatrizRetangular(sc);
//		
//		System.out.println("Matriz sem os valores");
//		MatrizUtils.imprimeSaida(matriz01);
		
		int[][] matriz02 = MatrizUtils.criaMatrizDenteada(sc);
		System.out.println("Matriz sem os valores");
		MatrizUtils.imprimeSaida(matriz02);
		
		
		
		
		
		
		sc.close();

	}

}
