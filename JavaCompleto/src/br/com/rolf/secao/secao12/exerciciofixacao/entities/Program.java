package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);

		System.out.println("Instanciando um objeto Product");
//		Product p1 = createProduct(sc);
//		System.out.println(p1);

		System.out.println("\nInstanciando um objeto Client");
		Client c1 = createClient(sc);
		System.out.println(c1);
		sc.close();

	}
	//metodo para instanciar um objeto do tipo product
	public static Product createProduct(Scanner sc) {
		System.out.print("Product name: ");
		String name = sc.nextLine();
		System.out.print("Product price: ");
		double price = sc.nextDouble();
		
		return new Product(name, price);
	}

	//metodo para instanciar um objeto do tipo client
	public static Client createClient(Scanner sc) {
		System.out.println("Enter data client");
		System.out.println("Name: ");
		String name = sc.nextLine();

		System.out.println("Email: ");
		String email = sc.nextLine();

		System.out.println("Birth date (DD/MM/YYYY): ");
		String date = sc.nextLine();
		LocalDate localDate = convertDate(date);
		
		return new Client(name, email, localDate);
	}
	//metodo para instanciar um objeto do tipo orderItems
	public static OrderItem createOrderItems(Scanner sc) {
		System.out.println("Enter order data:");
		System.out.println("How many items to this order?");
		int numberItems = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= numberItems; i++) {
			System.out.println("Enter #" + i + " item data");
			
		}
		
	}
	
	
	public static void readOrderItems(Scanner sc, OrderItem item, Product product) {
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
