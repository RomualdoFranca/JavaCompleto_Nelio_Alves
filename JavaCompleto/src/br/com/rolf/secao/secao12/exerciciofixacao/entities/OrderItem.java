package br.com.rolf.secao.secao12.exerciciofixacao.entities;

public class OrderItem {
	private int quantity;
	private double price;

	private Product products;

	public OrderItem() {

	}

	
	public OrderItem(int quantity, double price, Product products) {
		this.quantity = quantity;
		this.price = price;
		this.products = products;
	}


	public int getQuantity() {
		return quantity;
	}

	public double getPrice() {
		return price;
	}

	public Product getProducts() {
		return products;
	}

	public double subTotal() {
		return quantity * price;
	}
	
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append("Order items: \n");
		sb.append(products.getName() + ", " +
		"Quantity: " + quantity +
		", " + "Subtotal: " + String.format("$%.2f",products.getPrice()));
		
		return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	

}
