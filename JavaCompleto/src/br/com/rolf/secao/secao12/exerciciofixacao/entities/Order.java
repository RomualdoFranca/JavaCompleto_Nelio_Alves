package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import br.com.rolf.secao.secao12.entities.enums.OrderStatus;

public class Order {

	private LocalDateTime moment;
	private OrderStatus status;

	private Client client;
	private List<OrderItem> items = new ArrayList<>();

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

	public List<OrderItem> getItem() {
		return items;
	}

	public Client getClient() {
		return client;
	}

	// atentar para o nome no parametro não ser igual ao nome da lista
	public void addItem(OrderItem itens) {
		items.add(itens);

	}

	public void removeItem(OrderItem itens) {
		items.remove(itens);
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
		
		sb.append("Order items:\n");
        for (OrderItem item : items) {
            sb.append(item.getProducts().getName()) // Acessa o nome do produto via OrderItem
              .append(", $").append(String.format(Locale.US, "%.2f", item.getPrice())) // Preço do OrderItem
              .append(", Quantity: ").append(item.getQuantity())
              .append(", Subtotal: $").append(String.format(Locale.US, "%.2f", item.subTotal()))
              .append("\n");
        }
		
//		sb.append("Order items: \n");
//		sb.append(product.getName() + ", " + product.getPrice() + "Quantity: " + orderItem.getQuantity() + ", "
//				+ "Subtotal: " + String.format("$%.2f", orderItem.subTotal()));
		return sb.toString();
		
	}

}
