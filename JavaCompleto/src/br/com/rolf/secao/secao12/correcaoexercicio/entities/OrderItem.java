package br.com.rolf.secao.secao12.correcaoexercicio.entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	// composição com o Product
	private Product product;// o nome 'product' foi definido pelo diagrama UML

	public OrderItem() {
	}

	public OrderItem(Integer quantity, Product product) {
		this.quantity = quantity;
		price = product.getPrice();
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double subTotal() {
		return price * quantity;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
//		sb.append("Order items:\n");
		sb.append(product.getName() + ", ");
		sb.append("$" + String.format("%.2f", price) + ", ");
		sb.append("Quantity: " + quantity + ", ");
		sb.append("Subtotal: $" + String.format("%.2f", subTotal()));
		return sb.toString();

	}

}
