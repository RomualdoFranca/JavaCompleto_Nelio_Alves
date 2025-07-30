package br.com.rolf.ia.exercicios.composicao.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
	
	private String name;
	private String email;
	private LocalDate birthDate;
	

	//construtor padrão
	public Client() {
	}


	//construtor com parametros
	public Client(String nome, String email, LocalDate birthDate) {
		this.name = nome;
		this.email = email;
		this.birthDate = birthDate;
	}


	//getters and setters
	public String getNome() {
		return name;
	}


	public void setNome(String nome) {
		this.name = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	// Método de depuração: Exibe os valores dos atributos para verificação.
    // Pode ser removido ou comentado
	
	public String printDebuggin() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		StringBuilder sb = new StringBuilder();  
		sb.append("Client name: " + name );
		sb.append(", Email: " + email);
		sb.append(", Birth date: (" + dtf.format(birthDate)  + ")" );
		return sb.toString();
	}
	
	
	

}





















