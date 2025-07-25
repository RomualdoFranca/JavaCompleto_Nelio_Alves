package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

import br.com.rolf.secao.secao12.entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.println("\nInstanciando um objeto Client");
		Client c1 = createClient(sc);
//		System.out.println(c1);
//
//		System.out.println("Instanciando objetos Product");
//		Product p1 = createProduct(sc);
////		System.out.println(p1);

//		System.out.println("\nInstanciando um objeto OrderItem");

//		OrderItem od1 = createOrderItem(sc, p1);
//		System.out.println(od1);

		System.out.println("Enter order data:");
		Order order01 = createOrderData(sc, c1);
//		order01.addItem(od1);
//		System.out.println(order01.getItem());
		
		System.out.println("How many items to this order?");
		int itemQuantity = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= itemQuantity; i++) {
			Product product = createProduct(sc);
			OrderItem orderItem =createOrderItem(sc, product);
			order01.addItem(orderItem);
		
		}
		System.out.println("toString da classe Order");
		System.out.println(order01.toString());;
		
		
		
		
		

		sc.close();

	}// fim do main

	// metodo para interagir com o usuario e obter dados para a criacao de objetos

	// Métodos para a classe Client

	public static Client createClient(Scanner sc) {
		System.out.print("Name: ");
		String name = sc.nextLine();

		System.out.print("Email: ");
		String email = sc.nextLine();

		System.out.print("Birth date (DD/MM/YYYY): ");
		String date = sc.nextLine();
		LocalDate birthDate = converteData2(date);

		return new Client(name, email, birthDate);
	}

	public static Date converteData(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date stringParaDate = sdf.parse(date);// parseando uma string para um local date
		return stringParaDate;

	}

	public static LocalDate converteData2(String date) {
		// define padrao de formatação
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// converte de string para LocalDate
		LocalDate localdate = LocalDate.parse(date, dtf);
		return localdate;
	}

	// MÉTODOS DA CLASSE PRODUCT

	public static Product createProduct(Scanner sc) {
		System.out.print("Product name: ");
		String name = sc.nextLine();
		System.out.print("Product price: ");
		double price = sc.nextDouble();
		sc.nextLine();
		return new Product(name, price);
	}
	
	//MÉTODOS PARA A CLASSE orderItem
	
	public static OrderItem createOrderItem(Scanner sc, Product product) {
		double price = product.getPrice();
		System.out.print("Quantity: ");
		int quantity = sc.nextInt();
		sc.nextLine();
		
		return new OrderItem(quantity, price, product);
	}
	
	//Formata DateTime
	
	public static String coverteDateTime(LocalDateTime moment) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		
		return moment.format(dtf);
	}
	
	//MÉTODO DA CLASSE Order
	
	public static Order createOrderData(Scanner sc, Client client) {

		System.out.println("Status Options: PENDING_PAYMENT, " + "PROCESSING, " + "SHIPPED, " + "DELIVERED");
		System.out.print("Enter Status: "); 
		String statusInput = sc.nextLine();
		OrderStatus orderStatus = OrderStatus.valueOf(statusInput.toUpperCase());
		LocalDateTime dateTimeOrder = LocalDateTime.now();
		
		
		return new Order(dateTimeOrder, orderStatus, client);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
