package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.rolf.secao.secao12.entities.enums.OrderStatus;

public class Order {

	private LocalDateTime moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> item = new ArrayList<>();

	public Order() {

	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getOrderStatus() {
		return item;
	}

	public Client getClient() {
		return client;
	}

	// atentar para o nome no parametro não ser igual ao nome da lista
	public void addItem(OrderItem itens) {
		item.add(itens);

	}

	public void removeItem(OrderItem itens) {
		item.remove(itens);
	}

	@Override
	public String toString() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + dtf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + " (" + client.getBirthDate().format(dtf2) + ") - " + client.getEmail()
				+ "\n");
		return sb.toString();

	}

}
