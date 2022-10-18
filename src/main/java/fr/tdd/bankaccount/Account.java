package fr.tdd.bankaccount;

public class Account {

	private TransactionStore transactionStore;

	public Account(TransactionStore transactionStore) {
		this.transactionStore = transactionStore;
	}

	public void deposit(int amount) {
		transactionStore.addDepositTransaction(amount);
	}

	public void withdraw(int amount) {
		transactionStore.addWithdrawTransaction(amount);
	}

	public void printStatement() {
		
	}

}
