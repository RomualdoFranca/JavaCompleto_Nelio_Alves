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

		estaNoVertice(m, sc);
//		System.out.println(MatrizUtils.contaFrequencia(m, sc));
		
		sc.close();
		
		
		
		
		
		
		
		
	}
	
// identificar qual linha ou coluna o numero pesquisado se encontra
	
	
	//verificar se o numero pesquisado esta nos vertices da martriz
	
	public static void estaNoVertice(int[][] matriz, Scanner sc) {
		
		int ultimaColunaLinha = matriz.length - 1;
		int[] vectIndice = MatrizUtils.retornaIndices(matriz, sc);
		
		//se a condicao for true, o numero ta no topo da matriz
		if (vectIndice[0] == 0) {
		//verifica se esta na esquerda ou direita
			if (vectIndice[1] == 0) {
				System.out.println("O número está no vértice esquerdo no topo da matriz");
			}else if (vectIndice[1] == ultimaColunaLinha) {
				System.out.println("O número está no vértice direito no topo da matriz");
				
			}else {
				//para uma futura implementação: retornar a coluna em que o numero se encontra
				System.out.println("O número está no topo, entre os vértices");
			}
			
			// indica que o numero esta na base da martiz
		}else if (vectIndice[0] == ultimaColunaLinha) {
			//verifica se esta na esquerda ou direita
			if (vectIndice[1] == 0) {
				System.out.println("O número está no vértice esquerdo na base da matriz");
			}else if (vectIndice[1] == ultimaColunaLinha) {
				System.out.println("O número está no vértice direito na base da matriz");
				
			}else {
				System.out.println("O número está na base, entre os vértices");
			}
			
		}else {
			System.out.println("O número não está nos extremos da matriz");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
