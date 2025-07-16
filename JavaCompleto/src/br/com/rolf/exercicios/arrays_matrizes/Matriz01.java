package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Scanner;

import br.com.rolf.utilidades.EntradaUtils;
//
public class Matriz01 {

	public static void main(String[] args) {

		int[][] matriz01 = MatrizUtilsRefactory.criaMatriz();
		MatrizUtilsRefactory.preencheMatrizNumerosSequenciais(matriz01);
		System.out.println("Martriz com números sequenciais");
		MatrizUtilsRefactory.imprimeMatriz(matriz01);
		
		int[] indices = MatrizUtilsRefactory.retornaIndices(matriz01);
		System.out.println("O número pesquisado se encontra na\nlinha: " +
				(indices[0] + 1) + "\ncoluna:  " + (indices[1] + 1));
//		
//		MatrizUtilsRefactory.imprimeMatriz(matriz01);
//
//		System.out.println("_________________________");
//		
//		MatrizUtilsRefactory.preencheMatrizNumerosAleatorios(matriz01, 0, 9);
//		MatrizUtilsRefactory.imprimeMatriz(matriz01);
		System.out.println("_________________________");
		
		
//		int[][] matrizDenteada = MatrizUtilsRefactory.criaMatrizDenteada();
//		MatrizUtilsRefactory.imprimeMatriz(matrizDenteada);
		
		//fim da aplicação
		EntradaUtils.fecharScanner();
		
	}

}
