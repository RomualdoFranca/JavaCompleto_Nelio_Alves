package br.com.rolf.exercicios.arrays_matrizes;

import java.util.Iterator;
import java.util.Scanner;

// classe declarada como final para impedir que seja extendida
public final class MatrizUtils {

	// declarando um contrutor privado impede que qualquer código externo
	// (ou mesmo a própria classe) crie novas instâncias dela.
	private MatrizUtils() {

	}

	// **************MÉTODOS ESTÁTICOS*****************//

	// MÉTODOS PARA CRIAÇÃO DE MATRIZES//

	public static int[] criaVetor(int tamanhoVetor) {
		int[] vect = new int[tamanhoVetor];
		return vect;
	}

	public static int defineQuantidadeLinhas(Scanner sc) {
		System.out.println("Digite a quantidade de linha da matriz");
		int linha = sc.nextInt();
		sc.nextLine();
		return linha;
	}

	public static int defineQuantidadeColunas(Scanner sc) {
		System.out.println("Digite a quantidade de coluna da matriz");
		int coluna = sc.nextInt();
		sc.nextLine();

		return coluna;
	}

	public static int[][] criaMatrizRetangular(Scanner sc) {
		int linha = defineQuantidadeLinhas(sc);
		int coluna = defineQuantidadeColunas(sc);

		return new int[linha][coluna];
	}

	public static int[][] criaMatrizDenteada(Scanner sc) {

		int[][] m = new int[defineQuantidadeLinhas(sc)][];

		for (int i = 0; i < m.length; i++) {
			// inicializa as linhas de 'm'
			m[i] = new int[defineQuantidadeColunas(sc)];
		}

		return m;
	}

	// MÉTODOS PARA INSERIR ELEMENTOS
	public static void insereNumerosSequenciais(int[][] matriz, Scanner sc) {
		int count = 0;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = count;
				count++;
			}
		}

	}

	public static void insereNumerosAleatorios(int[][] matriz) {
		// define o intervalo. Os numeros inseridos será de 0 a 9
		int min = 0;
		int max = 9;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = (int) (Math.random() * (max - min + 1) + min);
			}
		}

	}

	// MÁTODOS PARA PESQUISAS
	
	public static int selecionaNumero(Scanner sc) {
		System.out.println("Digite um número");
		int num = sc.nextInt();
		sc.nextLine();
		return num;
	}

	// MÉTODOS PARA LOCALIZAR ELEMENTOS

	// verificar se o numero pesquisado esta nos vertices da martriz
	public static void estaNoVertice(int[][] matriz, Scanner sc) {

		int ultimaColunaLinha = matriz.length - 1;
		int[] vectIndice = MatrizUtils.retornaIndices(matriz, sc);

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

	
	
	public static int[] retornaIndices(int[][] matriz, Scanner sc) {
		System.out.println("Digite numero");
		int num = sc.nextInt();
		sc.nextLine();
		int[] vect = new int[2];

		boolean temNumero = verificaExistenciaNumero(num, false, matriz);
		if (temNumero == true) {

			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if (matriz[i][j] == num) {
						vect[0] = i;
						vect[1] = j;
						return vect;
					}
				}
			}
		} else {
			System.out.println("Número inexistente");
		}
		return vect;
	}

	public static boolean temNumeroPar(int[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				if (matriz[i][j] % 2 == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public static int[] adicionaNumerosParesVetor(int[][] matriz) {
		boolean temPar = temNumeroPar(matriz);
		int[] vect = criaVetor(matriz.length);

		if (temPar == true) {
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if (matriz[i][j] % 2 == 0) {
						vect[i] = matriz[i][j];

					}
				}
			}
		}

		return vect;

	}

	public static void buscaNumeroImpar(int[][] matriz, Scanner sc) {

	}

	// METODOS PARA FORMATAÇÃO DE SAÍDA
	public static void imprimeSaida(int[][] matriz) {
		System.out.println("-------------");

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();// necessário para separar as arrays posicionando uma abaixo da outra
		}
		System.out.println("-------------");
	}

	// METODOS PARA IMPRIMIR TRECHOS ESPECIFICOS DA MATRIZ

	public static void imprimeDiagonais(int[][] matriz, Scanner sc) {

		System.out.println("Escolha a diagonal para ser impressa:");
		System.out.println("Diagonal principal: 1");
		System.out.println("Diagonal secundária: 2");
		int opcao = sc.nextInt();
		sc.nextLine();

		if (opcao == 1) {

			System.out.println("Diagonal Principal");

			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {

					if (i == j) {
						System.out.print(matriz[i][j] + " ");
					}
				}
				System.out.println();
			}
		} else {
			System.out.println("Diagonal Secundária");
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {

					if (i + j == matriz.length - 1) {
						System.out.print(matriz[i][j] + " ");
					}
				}

				System.out.println();
			}
		}
	}

	public static void imprimeColunas(int[][] matriz, Scanner sc) {

		System.out.println("Digite a coluna que deseja imprimir");
		int numeroColuna = sc.nextInt();
		sc.nextLine();
		// converte o numero da coluna em índice
		// Exemplo: se for digitado coluna 1, o indice da coluna é o 0
		numeroColuna -= 1;

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (j == numeroColuna) {
					System.out.print(matriz[i][numeroColuna] + " ");

				}
			}
			System.out.println();
		}

	}

	public static void imprimeLinhas(int[][] matriz, Scanner sc) {
		System.out.println("Digite a linha que deseja imprimir");
		int numeroLinha = sc.nextInt();
		sc.nextLine();
		numeroLinha -= 1;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				if (i == numeroLinha) {
					System.out.print(matriz[numeroLinha][j] + " ");

				}

				// essa condicional converte os valores das outras linhas em zero,
				// matendo apenas os numeros da linha escolhida
//				if (i != numeroLinha) {
//					matriz[i][j] = 0;
//					
//				}
//				System.out.print(matriz[i][j] + " ");
			}
			System.out.println();
		}

	}

	// MÉTODOS PARA PESQUISA DE VALORES

	public static boolean verificaExistenciaNumero(int num, boolean hasNumero, int[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {

				if (matriz[i][j] == num) {
					return hasNumero = true;
				}
			}
		}
		return hasNumero = false;
	}

	public static int contaFrequencia(int[][] matriz, Scanner sc) {

		int count = 0;
		int[] v = MatrizUtils.retornaIndices(matriz, sc);

		int numeroPesquisado = matriz[v[0]][v[1]];

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (matriz[i][j] == numeroPesquisado) {
					count++;
				}
			}
		}
		return count;
	}

}
