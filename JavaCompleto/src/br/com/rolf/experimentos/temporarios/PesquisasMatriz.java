package br.com.rolf.experimentos.temporarios;

import java.util.Iterator;
import java.util.Scanner;

import br.com.rolf.exercicios.arrays_matrizes.MatrizUtils;
import br.com.rolf.exercicios.arrays_matrizes.MatrizUtilsRefactory;
import br.com.rolf.utilidades.EntradaUtils;

public class PesquisasMatriz {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[][] m = MatrizUtilsRefactory.criaMatriz();
		MatrizUtilsRefactory.preencheMatrizNumerosAleatorios(m, 1, 9);
		
		MatrizUtils.imprimeSaida(m);
		int[] indices = retornaIndices(m);

		System.out.println("O número pesquisado se encontra na\nlinha: " + (indices[0]) + "\ncoluna:  " + (indices[1]));
		System.out.println("matriz.lenght: " + m.length);
		System.out.println("Numero pesquisado: " + indices[2]);
		
		int quantidadeRepeticao = retornaQuantidadeRepeticaoNumeroPesquisado(m, indices[2]);

		System.out.println("Números de repetições: " + quantidadeRepeticao);
//		MatrizUtilsRefactory.retornaVizinhos(m, indices[0], indices[1]);


		sc.close();

	}// fim do metodo main
	
	
	public static int retornaQuantidadeRepeticaoNumeroPesquisado(int[][] matriz, int numPesquisado) {

		int count = 0;
		
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz.length; j++) {
				if (matriz[i][j] == numPesquisado) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public static int[] retornaIndices(int[][] matriz) {

		int numeroPesquisado = EntradaUtils.lerInteiro("Digite o número para pesquisa");
		int[] indices = new int[3];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == numeroPesquisado) {
					indices[0] = i;
					indices[1] = j;
					indices[2] = numeroPesquisado;
					break;
				}
			}
		}

		return indices;
	}
	


	

	
}
