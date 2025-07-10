package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Scanner;

public class Matriz01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//cria uma matriz e define o tamanho
//		int[][] matriz01 = new int[2][2];
		
		//laco para inserir os valores na matriz manualmente
//		for (int i = 0; i < matriz01.length; i++) {
//			for (int j = 0; j < matriz01[i].length; j++) {
//				System.out.println("Digite os numeros da matriz");
//				int num = sc.nextInt();
//				sc.nextLine();
//				matriz01[i][j] = num;
//			}
//		}
		
		//imprime os valores
//		for (int i = 0; i < matriz01.length; i++) {
//			for (int j = 0; j < matriz01[i].length; j++) {
//				System.out.print(matriz01[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		//UTILIZANDO OS MÉTODOS DA CLASSE UTILITÁRIA
		
		//variaveis para armazenar os valores inserido no metodo que define o tamanho da matriz
		int linha = 0;
		int coluna = 0;
		
		//chamando o metodo que define o tamanho da matriz e atribuindo a uma array local
		int[] vectLinhaColuna = MatrizUtils.defineTamanhoMatriz(linha, coluna, sc);

		//inserindo os valores do método, que foram atribuidos as posicoes do vetor, na matriz para definir seu tamanho
		int[][] matriz02 = new int[vectLinhaColuna[0]][vectLinhaColuna[1]];
		MatrizUtils.insereNumerosSequenciais(matriz02, sc);
		MatrizUtils.imprimeSaida(matriz02);
		
		MatrizUtils.insereNumerosAleatorios(matriz02);
		MatrizUtils.imprimeSaida(matriz02);
		
//		MatrizUtils.imprimeDiagonais(matriz02, sc);
		
		MatrizUtils.imprimeColunas(matriz02, sc);
		
		sc.close();
	}

}
