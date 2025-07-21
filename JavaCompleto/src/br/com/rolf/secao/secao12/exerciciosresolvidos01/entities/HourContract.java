package br.com.rolf.secao.secao12.exerciciosresolvidos01.entities;

import java.util.Date;

public class HourContract {
	
	private Date date;
	private Double valuePerHour;
	private Integer hours;
	
	public double totalvalue() {
		
		return valuePerHour * hours;
	}

}
