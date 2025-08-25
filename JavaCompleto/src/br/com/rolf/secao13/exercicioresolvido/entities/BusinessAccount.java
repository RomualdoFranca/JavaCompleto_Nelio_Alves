package br.com.rolf.secao13.exercicioresolvido.entities;

public class BusinessAccount extends Account{
	private Double loanLimit;
	
	public BusinessAccount() {
		//esse super() é para garantir que caso haja no futuro alguma implementacao no construtor padrao da super classe
		//essa logica tambem vai ser executada aqui
		super();
	}

	//essa classe tem dos os dados da classe mãe mais os dados da propria classe
	//na hora de gerar o construtor, escolher qual construtor da superclasse vai derivar

	public BusinessAccount(Integer number, String holder, Double balance, Double loanLimit) {
		super(number, holder, balance);
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}
	
	private void loan(double amount) {
		if(amount <= loanLimit) {
			balance += amount - 10.0;
		}else {
			System.out.println("Limite indisponível");
		}
	}
	
	
	

}
