package br.com.rolf.secao13;

import java.util.Scanner;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	
	public Account() {
		super();
	}
	
	public Account(Integer number, String holder, Double balance) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}

	public void withDraw(double amount) {
		if(amount <= balance && amount > 0) {
			balance -= amount;
			
		}else {
			System.out.println("Insufficient balance");
		}
	}
	public void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			
		}else {
			System.out.println("Invalid value");
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Account number: " + number + "\n");
		sb.append("Holder name: " + holder + "\n");
		sb.append("Initial Balance: $" + String.format("%.2f\n", balance));
//		sb.append("Withdraw: $" + String.format("%.2f\n", balance));
//		sb.append("Deposit: $" + String.format("%.2f\n", balance));
//		sb.append("Final Balance: $" + String.format("%.2f\n", balance));
		return sb.toString();
	}
	
//	public static double amountWithdraw(Scanner sc) {
//		System.out.println("Withdraw: ");
//		double withdraw = sc.nextDouble();
//		sc.nextLine();
//		withdraw
//		
//	}
	
}
