package br.com.rolf.secao.secao12.exerciciofixacao.entities;

public class Program {

	public static void main(String[] args) {

		// instanciando um obj do tipo produto
		Product p1 = new Product("TV", 1000);
		System.out.println(p1);

		double preco = p1.getPrice();
		String nomeItem = p1.getName();
		OrderItem order1 = new OrderItem(2, p1.getPrice(), p1);
		System.out.println(order1);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
