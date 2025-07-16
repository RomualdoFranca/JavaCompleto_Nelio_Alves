package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Scanner;

import br.com.rolf.utilidades.EntradaUtils;

public class Matriz01 {

	public static void main(String[] args) {

		
//		int linha = EntradaUtils.lerInteiro("Digite o números de linha");
//		int coluna= EntradaUtils.lerInteiro("Digite o números de coluna");
//		int[] vectLinhaColuna = new int[] {linha, coluna};
//		MatrizUtilsRefactory.imprimeVetor(vectLinhaColuna);
		
		int[] numeroLinhaColuna = MatrizUtilsRefactory.retornaNumeroLinhaColuna();
		MatrizUtilsRefactory.imprimeVetor(numeroLinhaColuna);
//		
//		
//		int[][] matriz01 = new int[numeroLinhaColuna[0]][numeroLinhaColuna[1]];
//		MatrizUtilsRefactory.preencheMatrizNumerosSequenciais(matriz01);
//		
//		MatrizUtilsRefactory.imprimeMatriz(matriz01);
//
//		System.out.println("_________________________");
//		
//		MatrizUtilsRefactory.preencheMatrizNumerosAleatorios(matriz01, 0, 9);
//		MatrizUtilsRefactory.imprimeMatriz(matriz01);
		System.out.println("_________________________");
		
		
		int[][] matrizDenteada = MatrizUtilsRefactory.criaMatrizDenteada();
		MatrizUtilsRefactory.imprimeMatriz(matrizDenteada);
		
		//fim da aplicação
		EntradaUtils.fecharScanner();
		
	}

}
