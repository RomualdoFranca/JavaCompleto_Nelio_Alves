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


	// metodo para depuração
	@Override
	public String toString() {
		// formatação antiga do Date
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		// formatação da API java.time
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();
		sb.append("Client: " + name + " (" + birthDate.format(dtf) + ") - " + email);
//		sb.append("Email: " + email + "\n");
////		sb.append("Birth date (DD/MM/YYYY): " + sdf.format(birthDate) + "\n");
//		sb.append("Birth date (DD/MM/YYYY): " + birthDate.format(dtf) + "\n");

		return sb.toString();
	}

}
