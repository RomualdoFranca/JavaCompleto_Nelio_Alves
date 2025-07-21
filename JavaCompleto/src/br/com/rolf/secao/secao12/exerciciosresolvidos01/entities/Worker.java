package br.com.rolf.secao.secao12.exerciciosresolvidos01.entities;

import java.util.ArrayList;
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
	//quando a composicao for do tipo 'tem-muitos' não iniciar no construtor
	//iniciar a lista vazia
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

	public double income(Integer year, Integer month) {

		return 0;
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
