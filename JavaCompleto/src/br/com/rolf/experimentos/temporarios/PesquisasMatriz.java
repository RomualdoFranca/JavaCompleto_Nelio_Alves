package br.com.rolf.experimentos.temporarios;

import java.util.Iterator;
import java.util.Scanner;

import br.com.rolf.exercicios.arrays_matrizes.MatrizUtils;

public class PesquisasMatriz {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[][] m = MatrizUtils.criaMatrizRetangular(sc);
		MatrizUtils.insereNumerosSequenciais(m, sc);
		
		MatrizUtils.imprimeSaida(m);
		int[] vectIndices = retornaIndices(m, sc);
		System.out.println(vectIndices[0] + "\n" + vectIndices[1]);
		
		sc.close();
	}
	
	public static int[] retornaIndices(int[][] matriz, Scanner sc) {
		System.out.println("Digite numero");
		int num = sc.nextInt();
		sc.nextLine();
		int[] vect = new int[2];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == num) {
					vect[0] = i;
					vect[1] = j;
				}
			}
		}
		
		return vect;
	}

}
