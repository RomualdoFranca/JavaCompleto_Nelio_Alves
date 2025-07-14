package br.com.rolf.exercicios.arrays_matrizes;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class MatrizUtilsRefactory {
	
	private  MatrizUtilsRefactory() {
	}

	
	//MÉTODOS DE CRIAÇÃO DE MATRIZES
	
	public static int[] retornaNumeroLinhaColuna(Scanner sc) {
		int linha = 0;
		int coluna = 0;
		
		try {
			System.out.println("Digite o número de linha da matriz");
			linha = sc.nextInt();
			sc.nextLine();
			
			System.out.println("Digite o número de coluna da matriz");
			coluna= sc.nextInt();
			sc.nextLine();
			
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida");
		}
		
		return new int[] {linha, coluna};
	}
}
