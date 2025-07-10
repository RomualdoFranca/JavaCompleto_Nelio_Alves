package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Scanner;

public class Matriz01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//cria uma matriz e define o tamanho
		int[][] matriz01 = new int[2][2];
		
		//laco para inserir os valores na matriz manualmente
		for (int i = 0; i < matriz01.length; i++) {
			for (int j = 0; j < matriz01[i].length; j++) {
				System.out.println("Digite os numeros da matriz");
				int num = sc.nextInt();
				sc.nextLine();
				matriz01[i][j] = num;
			}
		}
		
		//imprime os valores
		for (int i = 0; i < matriz01.length; i++) {
			for (int j = 0; j < matriz01[i].length; j++) {
				System.out.print(matriz01[i][j] + " ");
			}
			System.out.println();
		}
		
		int[][] matriz02 = new int[4][4];
		MatrizUtils.insereNumerosSequenciais(matriz02, sc);
		MatrizUtils.imprimeSaida(matriz02);
		
		sc.close();
	}

}
