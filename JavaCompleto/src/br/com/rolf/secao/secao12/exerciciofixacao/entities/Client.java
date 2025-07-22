package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Scanner;

public class Client {

	private String name;
	private String email;
	private Date birthDate;
	
	public Client() {
		
	}

	public Client(String name, String email, Date birthDate) {
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void clienteData(Scanner sc) throws ParseException {
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		name = sc.nextLine();
		
		System.out.print("Email: ");
		email = sc.nextLine();
		
		System.out.print("Birth date: (DD/MM/YYYY): " );
		String dataInput = sc.nextLine();
		
		birthDate = converteData(dataInput);
		
	}
	
	public Date converteData(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date stringParaDate = sdf.parse(date);
		return stringParaDate;
	
	}

	@Override
	public String toString() {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + name + "\n");
		sb.append("Email: " + email + "\n");
		sb.append("Birth date (DD/MM/YYYY): " + sdf.format(birthDate) + "\n");
		
		return sb.toString();
	}
















}

