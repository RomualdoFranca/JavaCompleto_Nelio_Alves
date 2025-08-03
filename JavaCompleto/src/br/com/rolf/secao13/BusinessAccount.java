package br.com.rolf.secao13;

public class BusinessAccount extends Account {
	private Double loanLimit;

	public BusinessAccount() {
		//pode se chamar o super() sem argumentos da super classe caso haja alguma lógica implementada
		//na super classe que seja necessário utilizar aqui
		super();
	}

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);//construtor da super classe
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}


	public void loan(double amount) {
		
	}
	
}
