package fr.tdd.bankaccount.features;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import fr.tdd.bankaccount.Account;
import fr.tdd.bankaccount.Console;
import fr.tdd.bankaccount.TransactionStore;

@RunWith(MockitoJUnitRunner.class)
public class PrintStatementFeature {

	@Mock
	private Console console;
	private Account account;

	@Before
	public void initialise() {
		TransactionStore transactionStore = new TransactionStore();
		account = new Account(transactionStore);
	}

	@Test
	public void should_print_statement_containing_all_transactions() {

		account.deposit(1000);
		account.withdraw(100);
		account.deposit(500);

		account.printStatement();

		InOrder inOrder = Mockito.inOrder(console);
		inOrder.verify(console).printLine("DATE | AMOUNT | BALANCE");
		inOrder.verify(console).printLine("10/04/2014 | 500.00 | 1400.00");
		inOrder.verify(console).printLine("02/04/2014 | -100.00 | 900.00");
		inOrder.verify(console).printLine("01/04/2014 | 1000.00 | 1000.00");
	}

}
