package br.com.rolf.ia.exercicios.composicao.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		Client client1 = createClient(sc);
//		System.out.println(client1.printDebuggin());
		
		Product p1 = createProduct(sc);
		System.out.println(p1.printDebugging());
		
		OrderItem order1 = createOrderItem(sc, p1);
		System.out.println(order1.printDebugging());
	
		
		sc.close();
	}//fim do main
	
	
	//converte a data em LocalDate
	public static LocalDate convertDate(String dateS) {
		//define a formatação
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(dateS, dtf);//converte a string da entrada em LocalDate
		return localDate;
		
	}
	
	//metodo para formatação de data. 
	public static String formatDate(LocalDate localDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dtf.format(localDate);
	}
	
	//metodos para entrada de dados e criacao de objetos
	
	public static Client createClient(Scanner sc) {
		System.out.print("Nome: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date: ");
		LocalDate date = convertDate(sc.nextLine());
		
		return new Client(name, email, date);
		
	}
	
	public static Product createProduct(Scanner sc){
		System.out.println("Product name: ");
		String nameProduct = sc.nextLine();
	
		System.out.println("Produc price: ");
		double price = sc.nextDouble();
		sc.nextLine();
		
		return new Product(nameProduct, price);
	
	}
	
	public static OrderItem createOrderItem(Scanner sc, Product product) {
		System.out.println("Quantidade: ");
		int quantidade = sc.nextInt();
		sc.nextLine();
		
		
		return new OrderItem(quantidade, product.getPrice());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

