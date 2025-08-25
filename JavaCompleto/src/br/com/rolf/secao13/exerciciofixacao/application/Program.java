package br.com.rolf.secao13.exerciciofixacao.application;

import br.com.rolf.secao13.exercicioresolvido.entities.BusinessAccount;
import br.com.rolf.secao13.exercicioresolvido.entities.SavingsAccount;
import br.com.rolf.secao13.exercicioresolvido.entities.Account;

public class Program {

	public static void main(String[] args) {

		Account acc = new Account(1001, "Alex", 0.0);
		BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.0);
		
		//UPCASTING
		//ao atribuir um objeto de uma subclasse a uma super classe, não ocorre erro
		Account acc1 = bacc;
		Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.0);
		Account acc3 = new SavingsAccount(1004, "Joao", 0.0, 0.01);
		
		//DONWCASTING
		
		//mesmo instaciando a 'acc2' como uma BusinessAccount, o tipo da variavel é Account
		//o compilador nao permite a conversao automatica como no Upcasting
		//Embora o objeto ao qual ela se refere na memória seja de fato um BusinessAccount,
		//o compilador só "enxerga" o tipo da variável de referência.
		//Para o compilador, acc2 é, e sempre será, uma Account.
		BusinessAccount bacc2 = (BusinessAccount)acc2;
		
		//no exemplo abaixo, como o compilador só enxerga o tipo da variável e nesse caso é do tipo Account
		//o erro só vai aparecer em tempo de execução, pois a variável 'acc3' não aponta para um objeto do tipo Account
		//ela aponta para um objeto do tipo SavingsAccount
		
		//BusinessAccount bacc3 = (BusinessAccount)acc3;
		
		//para evitar esse tipo de erro devemos realizar um teste usando o 'instanceof'
		if(acc3 instanceof BusinessAccount) {
			BusinessAccount bacc3 = (BusinessAccount)acc3;
			bacc3.loan(200.0);
			System.out.println("Loan!");
		}
		
		if(acc3 instanceof SavingsAccount) {
			SavingsAccount svacc = (SavingsAccount)acc3;
			svacc.updateBalance();
			System.out.println("Update");
		}
		
		
		
	}

}
