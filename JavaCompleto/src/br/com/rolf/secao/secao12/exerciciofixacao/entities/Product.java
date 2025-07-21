package br.com.rolf.secao.secao12.exerciciofixacao.entities;

public class Product {
	private String name;
	private double price;
	
	public Product() {
		
	}

	public Product(String name, double price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Product name: " + name + "\n");
		sb.append("Product price: " + String.format("%.2f",price));
		return sb.toString();
	
	}
	
	

}
