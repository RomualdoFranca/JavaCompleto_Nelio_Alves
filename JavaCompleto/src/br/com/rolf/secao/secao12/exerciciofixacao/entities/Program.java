package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		Product p2 = new Product();
//		createProduct(sc, p2);
		
		OrderItem orderItem1 = new OrderItem();
		createOrderItems(sc, orderItem1, p2);
		
//		System.out.println(p2.getName());
		
		System.out.println(orderItem1);

		System.out.println("\nInstanciando um objeto cliente\n");
		Client client01 = new Client();
		createDataClient(sc, client01);
		System.out.println(client01);

		sc.close();

	}
	
	public static void createProduct(Scanner sc, Product product) {
		System.out.println("Product name: ");
		product.setName(sc.nextLine());
		System.out.println("Product price: ");
		product.setPrice(sc.nextDouble());
		
	}

	public static void createOrderItems(Scanner sc, OrderItem item, Product product) {
		System.out.println("Enter order data:");
		System.out.println("How many items to this order?");
		int numberItems = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= numberItems; i++) {
			System.out.println("Enter #" + i + " item data");

			item.setProduct(product);
			System.out.println("Product name: ");
			product.setName(sc.nextLine());
			
			System.out.println("Product price: ");
			product.setPrice(sc.nextDouble());
			
			item.setPrice(product.getPrice());
			System.out.println("Quantity: ");
			item.setQuantity(sc.nextInt());
			sc.nextLine();
			item.subTotal();

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
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");// define o padrao de formatacao
		LocalDate localDate = LocalDate.parse(date, dtf);// converte string para LocalDate
		return localDate;

	}

}
