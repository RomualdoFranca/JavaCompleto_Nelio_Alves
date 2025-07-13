package br.com.rolf.experimentos.temporarios;

import java.util.Iterator;
import java.util.Scanner;

import br.com.rolf.exercicios.arrays_matrizes.MatrizUtils;

public class PesquisasMatriz {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[][] m = MatrizUtils.criaMatrizRetangular(sc);
		MatrizUtils.insereNumerosSequenciais(m, sc);
//		MatrizUtils.imprimeSaida(m);
		
//		MatrizUtils.insereNumerosAleatorios(m);
		MatrizUtils.imprimeSaida(m);
//		int frequencia = MatrizUtils.contaFrequenciaNumero(m, sc);
//		System.out.println(frequencia);
//		int[] vectIndices = MatrizUtils.retornaIndices(m, sc);
////		System.out.println(vectIndices[0] + "\n" + vectIndices[1]);
//		System.out.println("Numero retornado pelos indices");
//		System.out.println(m[vectIndices[0]][vectIndices[1]]);
		
		System.out.println(contaFrequencia(m, sc));
		
		sc.close();
		
		
		
		
		
		
		
		
	}
	
	//indice
	//
	
	public static int contaFrequencia(int[][] matriz,Scanner sc) {
		
		int count = 0;
		int[] v = MatrizUtils.retornaIndices(matriz, sc);
		
		int numeroPesquisado = matriz[v[0]][v[1]];
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == numeroPesquisado) {
//					System.out.println("Numero encontrado");
//					System.out.println("Numero de vezes: " + count);
					count++;
				}
			}
		}
		return count;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
