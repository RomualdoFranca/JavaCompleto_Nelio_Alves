package br.com.rolf.ia.exercicios.composicao.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PrograminComposition {

	public static void main(String[] args) {
		
		Client client1 = new Client("Rolf", "rolf@gmail.com", convertDate("12/11/1981"));
		System.out.println(client1.printDebuggin());;
	
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

}

