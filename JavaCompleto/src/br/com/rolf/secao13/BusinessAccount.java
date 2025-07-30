package br.com.rolf.secao13;

public class BusinessAccount extends Account {
	private Double loanLimit;

	public BusinessAccount() {
	}

	public BusinessAccount(Double loanLimit) {
		this.loanLimit = loanLimit;
	}

	public Double getLoanLimit() {
		return loanLimit;
	}

	public void setLoanLimit(Double loanLimit) {
		this.loanLimit = loanLimit;
	}
	
	
	
	
}
