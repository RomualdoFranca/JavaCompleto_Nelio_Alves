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

	// MÉTODOS QUE RETORNAM OS NÚMEROS CONTÍGUOS A UM NÚMERO ESCOLHIDO
	// OBS: O número escolhido deve ocorrer apenas 1 VEZ

	public static int[] retornaNumerosVizinhosTopo(int[][] matriz, int linha, int coluna) {

		int ultimaLinhaColuna = matriz.length - 1;

		if (coluna == 0) {
			// o numero não tem numeros acima e a esquerda
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoDireita = matriz[0][1];
					int vizinhoAbaixo = matriz[1][0];
					return new int[] { vizinhoDireita, vizinhoAbaixo };
				}
			}
		} else if (coluna == ultimaLinhaColuna) {
			// o numero não tem numeros acima e a direita
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[0][1];
					int vizinhoAbaixo = matriz[1][ultimaLinhaColuna];
					return new int[] { vizinhoEsquerda, vizinhoAbaixo };
				}
			}

		} else {
			// o numero não tem numero acima
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[0][coluna - 1];
					int vizinhoDireita = matriz[0][coluna + 1];
					int vizinhoAbaixo = matriz[1][coluna + 1];
					return new int[] { vizinhoEsquerda, vizinhoDireita, vizinhoAbaixo };
				}
			}
		}
		return null;
	}

	public static int[] retornaNumerosVizinhosBase(int[][] matriz, int linha, int coluna) {

		int ultimaLinhaColuna = matriz.length - 1;
		// valor booleano indicando que o numero esta entre os vertices
//		boolean entreVertices = coluna > 0 && coluna < ultimaLinhaColuna;

		if (coluna == 0) {
			// o numero não tem numeros abaixo e a esquerda
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoDireita = matriz[ultimaLinhaColuna][1];
					int vizinhoAcima = matriz[ultimaLinhaColuna - 1][0];
					return new int[] { vizinhoDireita, vizinhoAcima };
				}
			}
		} else if (coluna == ultimaLinhaColuna) {
			// o numero não tem numeros acima e a direita
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[ultimaLinhaColuna][ultimaLinhaColuna - 1];
					int vizinhoAcima = matriz[ultimaLinhaColuna - 1][ultimaLinhaColuna];
					return new int[] { vizinhoEsquerda, vizinhoAcima };
				}
			}

		} else {

			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoEsquerda = matriz[ultimaLinhaColuna][coluna - 1];
					int vizinhoDireita = matriz[ultimaLinhaColuna][coluna + 1];
					return new int[] { vizinhoEsquerda, vizinhoDireita };
				}
			}
		}
		return null;
	}

	public static int[] retornaNumerosVizinhosPrimeiraColunaEntreTopoBase(int[][] matriz, int linha, int coluna) {

		int ultimaLinhaColuna = matriz.length - 1;
		// variaveis com as posições dos numeros vizinhos
		int numeroAcima = linha - 1;
		int numeroAbaixo = linha + 1;
		int numeroEsquerda = coluna - 1;
		int numeroDireita = coluna + 1;

		if (coluna == 0) {
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					int vizinhoAcima = matriz[numeroAcima][0];
					int vizinhoAbaixo = matriz[numeroAbaixo][0];
					int vizinhoDireita = matriz[linha][numeroDireita];
					return new int[] { vizinhoAcima, vizinhoAbaixo, vizinhoDireita, };
				}
			}
		}

		return null;
	}

	// MÉTODOS PARA LOCALIZAR ELEMENTOS

	// verificar se o numero pesquisado esta nos vertices da martriz
//	public static void estaNoVertice(int[][] matriz, Scanner sc) {
//
//		int ultimaColunaLinha = matriz.length - 1;
//		int[] vectIndice = MatrizUtils.retornaIndices(matriz, );
//
//		// se a condicao for true, o numero ta no topo da matriz
//		if (vectIndice[0] == 0) {
//			// verifica se esta nos vértices da esquerda ou direita
//			if (vectIndice[1] == 0) {
//				System.out.println("O número está no vértice esquerdo no topo da matriz");
//			} else if (vectIndice[1] == ultimaColunaLinha) {
//				System.out.println("O número está no vértice direito no topo da matriz");
//
//			} else {
//				// para uma futura implementação: retornar a coluna em que o numero se encontra
//				System.out.println("O número está no topo, entre os vértices");
//			}
//
//			// indica que o numero esta na base da martiz
//		} else if (vectIndice[0] == ultimaColunaLinha) {
//			// verifica se esta nos vértices da esquerda ou direita
//			if (vectIndice[1] == 0) {
//				System.out.println("O número está no vértice esquerdo na base da matriz");
//			} else if (vectIndice[1] == ultimaColunaLinha) {
//				System.out.println("O número está no vértice direito na base da matriz");
//
//			} else {
//				System.out.println("O número está na base, entre os vértices");
//			}
//
//		} else {
//			System.out.println("O número não está nos extremos da matriz");
//		}
//	}

	// o retorno dos indices serve para localizar o numero na matriz
	// poderia renomear o nome do metodo para: retornaPosicaoNumero()
	public static int[] procuraNumero(int[][] matriz, int numeroPesquisado) {

		int[] vect = new int[2];// o valor dos indices sao armazenados nesse vetor

		// para retorna a posicao é necessario verificar a existencia do numero
		boolean temNumero = MatrizUtils.verificaExistenciaNumero(numeroPesquisado, false, matriz);

		if (temNumero == true) {

			// os loops percorrem a matriz em busca do numero pesquisado
			// quando o numero é encontrado, os indices da linha e colunas sao adicionados
			// no vetor
			for (int i = 0; i < matriz.length; i++) {
				for (int j = 0; j < matriz[i].length; j++) {
					if (matriz[i][j] == numeroPesquisado) {
						vect[0] = i;
						vect[1] = j;
						return vect;
					}
				}
			}

		} else {
			System.out.println("Número inexistente");
		}
		// implementacao futura: descobrir o que retornar quando o vetor estiver vazio
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

	public static int contaFrequencia(int[][] matriz, Scanner sc) {

		int count = 0;
//		int[] v = MatrizUtils.retornaIndices(matriz, sc);
//
//		int numeroPesquisado = matriz[v[0]][v[1]];

//		for (int i = 0; i < matriz.length; i++) {
//			for (int j = 0; j < matriz[i].length; j++) {
//				if (matriz[i][j] == numeroPesquisado) {
//					count++;
//				}
//			}
//		}
		return count;
	}

}
