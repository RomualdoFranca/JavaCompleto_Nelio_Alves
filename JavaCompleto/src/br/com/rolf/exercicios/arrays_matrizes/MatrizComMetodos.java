package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Scanner;

public class MatrizComMetodos {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int[][] matriz01 = MatrizUtils.criaMatrizRetangular(sc);
		MatrizUtils.insereNumerosAleatorios(matriz01);
		MatrizUtils.imprimeSaida(matriz01);
		
		System.out.println(MatrizUtils.temNumeroPar(matriz01, sc));

//		int[] vect = MatrizUtils.temNumeroPar(matriz01, sc);
//		MatrizUtils.iteraSobreVetor(vect);
		
		
//		int[][] matriz02 = MatrizUtils.criaMatrizDenteada(sc);
//		System.out.println("Matriz sem os valores");
		
//		MatrizUtils.insereNumerosSequenciais(matriz02, sc);
//		MatrizUtils.imprimeSaida(matriz02);
//		
//		MatrizUtils.insereNumerosAleatorios(matriz02);
//		MatrizUtils.imprimeSaida(matriz02);
		
		
		
		
		sc.close();

	}

}
