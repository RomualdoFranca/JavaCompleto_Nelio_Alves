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

		int num = selecionaNumero(sc);
		int[] indices = retornaIndices(m, num);
		System.out.print(indices[0] + ", " + indices[1] + "\n");

		escolheMetodo(m, num);
		
//		int[] numerosContiguos = retornaNumerosVizinhosVerticeEsquerdoTopo(m);
//		System.out.println("Numero à direita: " + numerosContiguos[0] + "\nNúmero abaixo: " + numerosContiguos[1]);

//		estaNoVertice(m, indices[0], indices[1]);

//		MatrizUtils.estaNoVertice(m, sc);

		sc.close();

	}
	
	public static void escolheMetodo(int[][] matriz, int numeroPesquisado) {
		
		int[] indices = retornaIndices(matriz, numeroPesquisado);
		
		if (indices[0] == 0) {
			System.out.println("Metodo do topo");
			
			
			
		}else if (indices[0] == matriz.length - 1){
			System.out.println("Metodo da base");
			
		}else {
			System.out.println("Numero fora das extremidades");
		}
		
		
		
	}
	

	public static int[] retornaNumerosVizinhosTopo(int[][] matriz, int numeroPesquisado, int linha, int coluna) {

		if (coluna == 0) {
			//o numero não tem numeros acima e a esquerda
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoDireita = matriz[0][1];
					int vizinhoAbaixo = matriz[1][0];
					return new int[] { vizinhoDireita, vizinhoAbaixo };
				}
			}
		}
		
		
		

//		if (indices[0] == 0) {
//
//			int ultimaLinhaColuna = matriz.length - 1;
//
//			//se o indice da coluna for igual a zero, o numero esta no vertice esquerdo
//			if (indices[1] == 0) {
//				//o numero não tem numeros acima e a esquerda
//				for (int i = 0; i < matriz.length; i++) {
//					for (int j = 0; j < matriz[i].length; j++) {
//						int vizinhoDireita = matriz[0][1];
//						int vizinhoAbaixo = matriz[1][0];
//						return new int[] { vizinhoDireita, vizinhoAbaixo };
//					}
//				}
//
//			//se o indice da coluna for igual a ultima coluna, o numero esta no vertice direito
//			} else if (indices[1] == ultimaLinhaColuna) {
//				//o numero não tem numeros acima e a direita
//				for (int i = 0; i < matriz.length; i++) {
//					for (int j = 0; j < matriz[i].length; j++) {
//						int vizinhoEsquerda = matriz[0][1];
//						int vizinhoAbaixo = matriz[1][ultimaLinhaColuna];
//						return new int[] { vizinhoEsquerda, vizinhoAbaixo };
//					}
//
//				}
//
//			}
//		//fim do if externo
//		//inicio do else externo
//		}
		return new int[] {1};

	}

	public static int selecionaNumero(Scanner sc) {
		System.out.println("Digite um número");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	// retorna os indices dos numeros vizinhos do vertice correspondente

	public static int[] retornaNumerosVizinhosVerticeEsquerdoTopo(int[][] matriz) {

		int[] numerosContiguos = new int[2];
		// numerosContiguos[0] = numero da direita
		// numerosContiguos[1] = numero abaixo

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				if (i == 0 && j == 1) {// numero da direita
					numerosContiguos[0] = matriz[i][j];

				} else if (i == 1 && j == 0) {// numero abaixo
					numerosContiguos[1] = matriz[i][j];
				}
			}
		}

		return numerosContiguos;

	}

	public static void estaNoVertice(int[][] matriz, int linha, int coluna) {

		int ultimaColunaLinha = matriz.length - 1;

		int[] vectIndice = new int[] { linha, coluna };

		// se a condicao for true, o numero ta no topo da matriz
		if (vectIndice[0] == 0) {
			// verifica se esta nos vértices da esquerda ou direita
			if (vectIndice[1] == 0) {
				System.out.println("O número está no vértice esquerdo no topo da matriz");

			} else if (vectIndice[1] == ultimaColunaLinha) {
				System.out.println("O número está no vértice direito no topo da matriz");

			} else {
				// para uma futura implementação: retornar a coluna em que o numero se encontra
				System.out.println("O número está no topo, entre os vértices");
			}

			// indica que o numero esta na base da martiz
		} else if (vectIndice[0] == ultimaColunaLinha) {
			// verifica se esta nos vértices da esquerda ou direita
			if (vectIndice[1] == 0) {
				System.out.println("O número está no vértice esquerdo na base da matriz");

			} else if (vectIndice[1] == ultimaColunaLinha) {
				System.out.println("O número está no vértice direito na base da matriz");

			} else {
				System.out.println("O número está na base, entre os vértices");
			}

		} else {
			System.out.println("O número não está nos extremos da matriz");
		}
	}

	public static int[] retornaIndices(int[][] matriz, int numeroPesquisado) {

//		int[] vect = new int[2];

		boolean temNumero = MatrizUtils.verificaExistenciaNumero(numeroPesquisado, false, matriz);
		if (temNumero == true) {

			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if (matriz[i][j] == numeroPesquisado) {
//						vect[0] = i;
//						vect[1] = j;
						return new int[] { i, j };
					}
				}
			}
		} else {
			System.out.println("Número inexistente");
		}
		return null;
	}

}
