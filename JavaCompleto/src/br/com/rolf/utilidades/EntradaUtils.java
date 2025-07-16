package br.com.rolf.utilidades;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EntradaUtils {
	
	private static Scanner sc = new Scanner(System.in);
	
	public static int lerInteiro(String mensagem) {
		
		int numero = 0;
		boolean entradavalida = false;
		
		do {
			System.out.println(mensagem);
			try {
				
				numero = sc.nextInt();
				sc.nextLine();
				entradavalida = true;
				
			} catch (InputMismatchException e) {
				System.out.println("Entrada ínvalida.\nDigite um valor válido:");
				sc.next();
			}
			
		} while (!entradavalida);
		
		return numero;
	}
	
	// Valida entrada linha e coluna
	public static void validaEntradaLinhaColuna(int linha, int coluna) {
		boolean validaEntrada = false;
		
		do {
			
			if (linha < 0 || coluna < 0) {
				System.out.println("Os números não podem ser negativos");
				System.out.println("Digite um valor positivo.");
			}
			
		} while (validaEntrada);
		
	}
	
	public static void fecharScanner() {
		if (sc != null) {
			sc.close();
		}
	}

}
