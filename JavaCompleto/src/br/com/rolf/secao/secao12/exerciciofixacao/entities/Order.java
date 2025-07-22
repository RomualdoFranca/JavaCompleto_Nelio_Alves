package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.rolf.secao.secao12.entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> item = new ArrayList<>();

	public Order() {

	}

	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
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
	
	

}
