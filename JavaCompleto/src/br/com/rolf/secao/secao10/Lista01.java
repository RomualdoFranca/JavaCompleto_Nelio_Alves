package br.com.rolf.secao.secao10;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Lista01 {

	public static void main(String[] args) {

		//declarando uma lista
		List <Integer> listInt;
 		
		//instanciando uma lista
		listInt = new ArrayList<>();
		
		//adicionando elementos. A cada novo elemento que é adicionado vai para a posicao final da lista
		listInt.add(1);
		listInt.add(2);
		listInt.add(5);
		
		//inserindo elemento em uma posicao especifica
		//dentro do parenteses; (indice, elemento que sera adicionado)
		listInt.add(1, 100);
		
		//imprimindo os elementos da lista
		for (Integer integer : listInt) {
			System.out.print(integer + " ");
		}
		System.out.println();
		
		//removendo elemento por comparacao
		//em listas de elementos numericos, não se pode usar diretamente um tipo primitivo no metodo .remove()
		//é necessário fazer o auto-boxing
		listInt.remove(Integer.valueOf(100));
		
		//imprimindo os elementos da lista
		for (Integer integer : listInt) {
			System.out.print(integer + " ");
		}
		System.out.println();

		listInt.add(9);
		listInt.add(8);
		listInt.add(7);
		
		List<String> stg = new ArrayList<String>();
		stg.add("amora");
		stg.add("banana");
		stg.add("cacau");
		stg.add("damasco");
		stg.add("figo");
		stg.add("abacate");
		stg.add("cajú");
		stg.add("biribiri");
		
		//posicao de um elemento
		System.out.println("Posicao de um elemento: " + stg.indexOf("damasco"));
		
		//removendo da lista elemento que atenda a um predicado
		stg.removeIf(nome -> nome.charAt(0) == 'a');
		
		//quando o elemento nao é encontrado, o retorno é igual a -1
		System.out.println("Buscando um elemento que não está na lista: " + stg.indexOf("amora"));

		//filtrando elementos usando predicado
		List<String> result = stg.stream().filter(nome -> nome.charAt(0) == 'c').collect(Collectors.toList());
		
		//encontrando elemento da lista que atenda a um certo predicado
		String name = stg.stream().filter(nome -> nome.charAt(0) == 'd').findFirst().orElse(null);
		System.out.println(name);
		
		
		//imprimindo os elementos da lista
		for (String s : result) {
			System.out.print(s + " ");
		}
		System.out.println();
		
		//tamanho da lista
		System.out.println("Tamanho da lista: " + listInt.size());
		
	}

}
