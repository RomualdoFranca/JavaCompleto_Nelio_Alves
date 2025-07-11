package br.com.rolf.experimentos.temporarios;

public class MatrizDeMatrizes {

    public static void main(String[] args) {

        // --- Etapa 1: Criar uma matriz 3x3 de inteiros ---
        System.out.println("--- Etapa 1: Criando a matriz 3x3 de inteiros ---");
        int[][] matrizInteiros = new int[3][3]; // Declara e inicializa uma matriz 3x3

        // Preenchendo a matriz de inteiros
        int contador = 1;
        for (int i = 0; i < matrizInteiros.length; i++) {
            for (int j = 0; j < matrizInteiros[i].length; j++) {
                matrizInteiros[i][j] = contador++;
            }
        }

        // Imprimindo a matriz de inteiros para visualização
        System.out.println("Matriz de inteiros original:");
        for (int i = 0; i < matrizInteiros.length; i++) {
            for (int j = 0; j < matrizInteiros[i].length; j++) {
                System.out.print(matrizInteiros[i][j] + "\t");
            }
            System.out.println(); // Pula para a próxima linha
        }
        System.out.println();

        // --- Etapa 2: Criar outra matriz para converter os inteiros em strings ---
        System.out.println("--- Etapa 2: Criando a matriz para strings (Matriz de Matrizes) ---");

        // Declaração e inicialização da matriz de strings (apenas a primeira dimensão)
        String[][] matrizStrings = new String[matrizInteiros.length][];

        System.out.println("1. Matriz de Strings declarada como `new String[matrizInteiros.length][]`");
        System.out.println("   - Nesse ponto, 'matrizStrings' tem " + matrizStrings.length + " linhas.");
        System.out.println("   - Cada 'linha' (matriz interna) ainda é null. Ex: matrizStrings[0] é " + matrizStrings[0]);
        System.out.println();

        // Loop para inicializar cada linha da matriz de strings e converter os elementos
        for (int i = 0; i < matrizInteiros.length; i++) {
            // Inicializa cada sub-matriz (linha) com o tamanho correto de colunas
            matrizStrings[i] = new String[matrizInteiros[i].length];
            System.out.println("2. Inicializando a linha " + i + ": `matrizStrings[" + i + "] = new String[" + matrizInteiros[i].length + "]`");
            System.out.println("   - Agora, matrizStrings[" + i + "] não é mais null, mas seus elementos são (ex: matrizStrings[" + i + "][0] é " + matrizStrings[i][0] + ")");

            for (int j = 0; j < matrizInteiros[i].length; j++) {
                // Converte o inteiro para string e atribui
                matrizStrings[i][j] = String.valueOf(matrizInteiros[i][j]);
                System.out.println("3. Convertendo e atribuindo elemento [" + i + "][" + j + "]: " + matrizInteiros[i][j] + " -> \"" + matrizStrings[i][j] + "\"");
            }
            System.out.println(); // Linha em branco para melhor legibilidade
        }

        // Imprimindo a matriz de strings convertida
        System.out.println("Matriz de Strings convertida:");
        for (int i = 0; i < matrizStrings.length; i++) {
            for (int j = 0; j < matrizStrings[i].length; j++) {
                System.out.print("\"" + matrizStrings[i][j] + "\"\t"); // Coloca aspas para mostrar que são strings
            }
            System.out.println();
        }
    }
}
