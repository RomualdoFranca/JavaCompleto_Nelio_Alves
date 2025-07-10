package br.com.rolf.experimentos.temporarios;

public class TesteManipulacaoStrings {

	public static void main(String[] args) {

		
		String nome = "" + "Rolf";
		
		for (int i = 0; i < 10; i++) {
			String comEspacos = nome.replace("", " ");
			System.out.println(comEspacos);
		}
		
		for (int i = 0; i < 10; i++) {
//			System.out.println(espaco + nome);
		}
		
	}

}
