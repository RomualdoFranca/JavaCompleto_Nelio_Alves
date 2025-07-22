package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		// instanciando um obj do tipo produto
		Product p1 = new Product("TV", 1000);
		System.out.println(p1);

		double preco = p1.getPrice();
		String nomeItem = p1.getName();
		OrderItem order1 = new OrderItem(2, p1.getPrice(), p1);
		System.out.println(order1);
		
		System.out.println("\nInstanciando um objeto cliente\n");
		Client client01 = new Client();
		createDataClient(sc, client01);
		System.out.println(client01);
		
		sc.close();
		

		
	}
	
	public static void createOrderItems(Scanner sc, Product product) {
		System.out.println("Enter order data:");
		System.out.println("How many items to this order?");
		int numberItems = sc.nextInt();
		sc.nextLine();
		
		
		for (int i = 1; i <= numberItems; i++) {
			System.out.println("Enter #" + i + " item data") ;
			System.out.println("Product name: ");
			  
			System.out.println("Product price: ");
			System.out.println("Quantity: ");
			
		}
	}
	
	public static void createDataClient(Scanner sc, Client client) {
		System.out.println("Enter data client");
		System.out.println("Name: ");
		client.setName(sc.nextLine());
		
		System.out.println("Email: ");
		client.setEmail(sc.nextLine());
		
		System.out.println("Birth date (DD/MM/YYYY): ");
		String date = sc.nextLine();
		client.setBirthDate(convertDate(date));
		
		
	}
	
	public static LocalDate convertDate(String date) {
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yyyy");//define o padrao de formatacao
		LocalDate localDate = LocalDate.parse(date, dtf);//converte string para LocalDate
		return localDate;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
