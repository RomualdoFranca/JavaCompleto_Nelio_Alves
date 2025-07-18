package br.com.rolf.secao.secao11.recursos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TeoriaDataHora01 {

	public static void main(String[] args) {
		
		//especifando formato customizado
		//formantando a partir de um padrão
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate date01 = LocalDate.now();
		LocalDateTime date02 = LocalDateTime.now();
		Instant date03 = Instant.now();//horario GMT,Z,
		
		//Texto ISO8601
		LocalDate date04 = LocalDate.parse("2025-07-18");
		LocalDateTime date05 = LocalDateTime.parse("2025-07-18T00:10:30");
		Instant date06 = Instant.parse("2025-07-18T00:10:30Z");
		// instancia o horario equivalente ao horario de Londres
		//aqui o horario é 00:10:30
		//acrescentando -03:00, indica que o horario local, no caso 00:10:30 está 3 horas a menos que o horario Zulu
		Instant date07 = Instant.parse("2025-07-18T00:10:30-03:00");
		
		//aqui não significa o o formato de saída será igual ao inserido aqui. A saida será no formato ISO
		//aqui temos apenas a possibilidade de inserirmos de maneira customizada a data e hora
		LocalDate date08 = LocalDate.parse("18/07/2025", fmt1);
		//passando o ofPattern dentro do .parse
		LocalDate date09 = LocalDate.parse("18/07/2025 12:00", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		//passando dia, mes e ano isoladamente
		LocalDate date10 = LocalDate.of(2025, 7, 18);
		LocalDateTime date11 = LocalDateTime.of(2025, 7, 18, 12, 30);
		
		//saída no formato ISO8601
		System.out.println("Data LocalDate: " + date01);
		System.out.println("Data LocalDateTime: " + date02);
		System.out.println("Data Instant: " + date03);
		System.out.println("date04: " + date04.toString());
		System.out.println("date05: " + date05.toString());
		System.out.println("date06: " + date06.toString());
		System.out.println("date07: " + date07.toString());
		System.out.println("date08: " + date08.toString());
		System.out.println("date09: " + date09.toString());
		System.out.println("date10: " + date10.toString());
		System.out.println("date11: " + date11.toString());
		
		
	
	
	
	}
	

}
