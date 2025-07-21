package br.com.rolf.secao.secao12.exerciciosresolvidos01.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.rolf.secao.secao12.exerciciosresolvidos01.entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	// acrescentando as associacoes
	private Departament departament;
	// no diagrama UML, mostra que essa classe tem varios contratos
	// como são varios, eles ficarão numa lista
	// quando a composicao for do tipo 'tem-muitos' não iniciar no construtor
	// iniciar a lista vazia
	private List<HourContract> contracts = new ArrayList<HourContract>();

	public Worker() {

	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);

	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);

	}

	public double income(int year, int month) {

		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();// instanciando um calendario

		// o laco percorre todos os contratos adicionados na lista
		for (HourContract c : contracts) {

			cal.setTime(c.getDate());// atribuindo a data do contrato ao calendario
			int c_year = cal.get(Calendar.YEAR);// atribuindo o ano do contrato a variavel
			// necessario acrescentar '+1' porque o mes no Calender começa com 0
			int c_month = 1 + cal.get(Calendar.MONTH);// atribuindo o mes do contrato a variavel

			if (c_year == year && c_month == month) {
				sum += c.totalvalue();
			}
		}
		return sum;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

}
