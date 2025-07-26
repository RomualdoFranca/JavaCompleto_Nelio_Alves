package br.com.rolf.ia.exercicios.composicao.entities;

public class OrderItem {
	private int quantity;
	private double price;
	
	private Product product;

	public OrderItem() {
	}

	public OrderItem(int quantity, double price) {
		this.quantity = quantity;
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return product.getPrice();
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String printDebugging() {
		StringBuilder sb = new StringBuilder();
		sb.append("Nome do produto: " + product.getName() + "\n");
		sb.append("Preço do produto: " + String.format("%.2f", price) + "\n");
		sb.append("Quantidade: " + quantity);
		return sb.toString();
		
	}
	

}
