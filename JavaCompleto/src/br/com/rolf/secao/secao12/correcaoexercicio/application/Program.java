package br.com.rolf.secao.secao12.correcaoexercicio.application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import br.com.rolf.secao.secao12.correcaoexercicio.entities.Client;
import br.com.rolf.secao.secao12.correcaoexercicio.entities.Order;
import br.com.rolf.secao.secao12.correcaoexercicio.entities.OrderItem;
import br.com.rolf.secao.secao12.correcaoexercicio.entities.Product;
import br.com.rolf.secao.secao12.correcaoexercicio.entities.enums.OrderStatus;



public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
//	
//		Product p = new Product("TV", 1000);
//		
//		OrderItem oi1 = new OrderItem(2, p);
//		
//		System.out.println(oi1);
//		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String birthDate = "15/03/1985";
		LocalDate localDate = LocalDate.parse(birthDate, dtf);
//		
		Client c1 = new Client("Alex Green", "alex@gmail.com", localDate);
		System.out.println(c1);
		
		String status = "processing";
		OrderStatus st = OrderStatus.valueOf(String.format(status).toUpperCase());
		
		Order o1 = new Order(st, c1);
		
		System.out.println("how many items to this order?");
		int n = sc.nextInt();
		sc.nextLine();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Enter °" + i + " item date:");
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.println("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.println("Quantity: "); 
			int quantity = sc.nextInt();
			sc.nextLine();
			//instanciando o produto
			Product product = new Product(productName, productPrice);
			//instanciando o item de pedido associado ao produto
			OrderItem orIt = new OrderItem(quantity, product);
			//adicionando o ordemItem ao lista do pedido
			o1.addItem(orIt);			
		}
		
		System.out.println(o1);
		
		
		sc.close();
	}

}
