package fr.tdd.bankaccount.application;

import fr.tdd.bankaccount.Account;
import fr.tdd.bankaccount.Clock;
import fr.tdd.bankaccount.Console;
import fr.tdd.bankaccount.StatementPrinter;
import fr.tdd.bankaccount.TransactionStore;

public class Application {

	public static void main(String[] args) {
		Clock clock = new Clock();
		TransactionStore transactionStore = new TransactionStore(clock);
		Console console = new Console();
		StatementPrinter statementPrinter = new StatementPrinter(console);
		Account account = new Account(transactionStore, statementPrinter);
		
		account.deposit(1000);
		account.withdraw(500);
		account.deposit(100);
		
		account.printStatement();
	}
}
