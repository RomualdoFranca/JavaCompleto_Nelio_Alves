package br.com.rolf.experimentos.temporarios;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManipulandoListas {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		
		List<Integer> numeros = new ArrayList<>();
		adicionaInteiros(numeros);
		imprimeListaInteiros(numeros);
		
		List<String> nomes = new ArrayList<String>();
		adicionaNomes(nomes, 2, sc);
		imprimeListaString(nomes);
		
		System.out.println("Adicionando mais elementos");
		adicionaNomes(nomes, 2, sc);
		imprimeListaString(nomes);
		
		
		
		
		
		
		
		
		
		
		
		
		sc.close();

	}// fim do main

	//metodo utilzando Generics
	public static <T> void adicionaElementoGenerico(List<T> lista, T elemento) {
		lista.add(elemento);
	}
	
	// adicionando elementos na lista
	public static List<Integer> adicionaInteiros(List<Integer> lista) {

		for (int i = 0; i < 10; i++) {
//			lista.add(i);
			adicionaElementoGenerico(lista, i);
		}
		return lista;
	}

	public static List<String> adicionaNomes(List<String> listaNomes, int numeroElementos, Scanner sc) {
		
		String nomes = null;
		for(int i = 0; i < numeroElementos; i++) {
			System.out.println("Digite um nome:");
			nomes = sc.next();
//			listaNomes.add(nomes);
			adicionaElementoGenerico(listaNomes, nomes);
		}
		
		return listaNomes;
	}


	// *******************************************\\
	// imprime listas
	public static void imprimeListaInteiros(List<Integer> lista) {
		for (Integer integer : lista) {
			System.out.print(integer + " ");
		}
		System.out.println();
	}

	public static void imprimeListaString(List<String> lista) {

		for (String string : lista) {
			System.out.println(string);
		}
	}

}
