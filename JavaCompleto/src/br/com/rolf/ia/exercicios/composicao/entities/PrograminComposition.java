package br.com.rolf.ia.exercicios.composicao.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PrograminComposition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Client client1 = createClient(sc);
		System.out.println(client1.printDebuggin());;
	
		
		sc.close();
	}//fim do main
	
	
	//converte a data em LocalDate
	public static LocalDate convertDate(String dateS) {
		//define a formatação
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate localDate = LocalDate.parse(dateS, dtf);//converte a string da entrada em LocalDate
		return localDate;
		
	}
	
	//metodo para formatação de data. 
	public static String formatDate(LocalDate localDate) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return dtf.format(localDate);
	}
	
	//metodos para entrada de dados e criacao de objetos
	
	public static Client createClient(Scanner sc) {
		System.out.print("Nome: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date: ");
		LocalDate date = convertDate(sc.nextLine());
		
		
		return new Client(name, email, date);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

