package br.com.rolf.secao13;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Account acount1 = new Account(1, "Lua", 1000.0);
		
		System.out.println("Withdraw: ");
		double withdraw = sc.nextDouble();
		sc.nextLine();
		acount1.withDraw(withdraw);
		System.out.println(acount1);
		
		sc.close();
	}

}
