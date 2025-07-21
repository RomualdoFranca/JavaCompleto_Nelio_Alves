package br.com.rolf.secao.secao12.application;

import java.util.Date;

import br.com.rolf.secao.secao12.entities.Order;
import br.com.rolf.secao.secao12.entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {

		Order order = new Order(1080, new Date(), OrderStatus.PENDING_PAYMENT);
		
		System.out.println(order);
		
		//convertendo uma string para uma instacia do tipo enumerado
		OrderStatus os1 = OrderStatus.DELIVERED;
		OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
		
		
		System.out.println(os1);
		System.out.println(os2);
		
		
		
	}

}
