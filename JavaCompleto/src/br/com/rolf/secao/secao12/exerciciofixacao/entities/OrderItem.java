package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.util.Scanner;

public class OrderItem {
	private int quantity;
	private double price;

	private Product product;

	public OrderItem() {

	}

	public OrderItem(int quantity, double price, Product product) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public Product getProducts() {
		return product;
	}

	public double subTotal() {
		return quantity * price;
	}

	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Order items: \n");
		sb.append(product.getName() + ", " + "Quantity: " + quantity + ", " + "Subtotal: "
				+ String.format("$%.2f", subTotal()));

		return sb.toString();
	}

}
