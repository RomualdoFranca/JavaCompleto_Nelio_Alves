package br.com.rolf.secao.secao12.exerciciosresolvidos02.entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Comment comment1 = new Comment("Have a nice trip");
		Comment comment2 = new Comment("Wow that's awesome!");
		Comment comment3 = new Comment("Good night");
		Comment comment4 = new Comment("May the Force be whith you");
		
		
//		LocalDateTime moment = LocalDateTime.parse("2018-06-21T13:05:44");
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:MM");
		String title = "Traveling to New Zealeand";
		String content = "I'm going to visit this wondeful country";
		int likes = 12;
		
//		System.out.println("moment: " + date1.format(dtf));
		Post post1 = new Post(sdf.parse("21/06/2018 13:05:44"), title, content, likes);
		post1.addComment(comment1);
		post1.addComment(comment2);
		System.out.println(post1);
		
	}

}
