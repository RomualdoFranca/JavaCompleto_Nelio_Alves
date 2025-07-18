package br.com.rolf.secao.secao11.recursos;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DataHoraConverteTexto {

	public static void main(String[] args) {

		LocalDate date01 = LocalDate.parse("2025-07-18");
		LocalDateTime date02 = LocalDateTime.parse("2025-07-18T00:10:30");
		Instant date03 = Instant.parse("2025-07-18T00:10:30Z");
		
		//transformando os textos de formas alternativas
		
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		//para imprimir de forma customizada um horario global, temos que informar qual o fuso horario que vamos considerar
		// esse trecho do codigo realiza essa tarefa pegando o fuso horario do computador do usuario
		//metodo estatico: .withZone(ZoneId.systemDefault());
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());
		
		//utilizando padroes prontos da documentacao
		DateTimeFormatter fmt4 = DateTimeFormatter.ISO_DATE_TIME;
		DateTimeFormatter fmt5 = DateTimeFormatter.ISO_INSTANT;
		
		
		//a saida não vai ser mais no padrao ISO, e sim na forma especificada no ofPattern()
		System.out.println("date01 = " + date01.format(fmt1));
		System.out.println("date01 = " + fmt1.format(date01));//faz o mesmo que o codigo acima
		System.out.println("date02 = " + date02.format(fmt2));
		//o Instant não tem o metodo .format(), a unica forma de chamar esse metodo é atravez do DateTimeFormatter
		System.out.println("date03 = " + fmt3.format(date03));//imprime o horario equivalente ao horario local
		
		System.out.println("Imprime usando padrões prontos");
		System.out.println("date02 = " + date02.format(fmt4));
		System.out.println("date03 = " + fmt5.format(date03));
		
		
		
		
		
		
	}

}
