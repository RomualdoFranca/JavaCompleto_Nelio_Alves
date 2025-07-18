package br.com.rolf.secao.secao11.recursos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class ConverteHoraGlobalLocal {

	public static void main(String[] args) {
//		// ZoneId disponíveis
//		for (String string : ZoneId.getAvailableZoneIds()) {
//			System.out.println(string);
//		}

		LocalDate date01 = LocalDate.parse("2025-07-18");
		LocalDateTime date02 = LocalDateTime.parse("2025-07-18T00:10:30");
		Instant date03 = Instant.parse("2025-07-18T01:00:00Z");//horario zulu, horario de Londres
		
		//convertendo variavel global em local
		
		//pegando apenas dia, mes e ano com base me TimeZone da propria maquina
		//estamos convertendo um Instant (date03), para uma data local, considerando o fuso horario do meu computador
		LocalDate r1 = LocalDate.ofInstant(date03, ZoneId.systemDefault());
		LocalDate r2 = LocalDate.ofInstant(date03, ZoneId.of("Portugal"));
		
		//a saida vai ser no horario local, no caso,  do meu computador
		//será com 3 horas a menos que o horario especificado no Instant
		System.out.println("r1 = " + r1);
		System.out.println("r2 = " + r2);
		
		//pegando partes especificas de uma data, como mes, ano e dia
		System.out.println("date01 ano: " + date01.getYear());
		System.out.println("date01 mês: " + date01.getMonth());
		System.out.println("date01 dia: " + date01.getDayOfMonth());
		
		
	}

}
