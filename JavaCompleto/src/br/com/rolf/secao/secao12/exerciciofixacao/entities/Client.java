package br.com.rolf.secao.secao12.exerciciofixacao.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Client {

	private String name;
	private String email;
	private LocalDate birthDate;
	
	public Client() {
		
	}

	public Client(String name, String email, LocalDate birthDate) {
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

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void clienteData(Scanner sc) throws ParseException {
		System.out.println("Enter cliente data:");
		System.out.print("Name: ");
		name = sc.nextLine();
		
		System.out.print("Email: ");
		email = sc.nextLine();
		
		System.out.print("Birth date: (DD/MM/YYYY): " );
		String dataInput = sc.nextLine();
		
		birthDate = converteData2(dataInput);
		
	}
	
	public Date converteData(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date stringParaDate = sdf.parse(date);//parseando uma string para um local date
		return stringParaDate;
	
	}
	
	public LocalDate converteData2(String date) {
		//define padrao de formatação
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//converte de string para LocalDate
		LocalDate localdate = LocalDate.parse(date, dtf);
		return localdate;
	}

	//metodo para depuração
	@Override
	public String toString() {
		//formatação antiga do Date
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//formatação da API java.time
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("Client: " + name + "(" + birthDate.format(dtf) + ") - " + email);
//		sb.append("Email: " + email + "\n");
////		sb.append("Birth date (DD/MM/YYYY): " + sdf.format(birthDate) + "\n");
//		sb.append("Birth date (DD/MM/YYYY): " + birthDate.format(dtf) + "\n");
		
		return sb.toString();
	}
















}

