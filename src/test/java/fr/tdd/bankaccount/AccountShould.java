package fr.tdd.bankaccount;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

	@Mock private TransactionStore transactionStore;
	@Mock private StatementPrinter statementPrinter;
	private Account account;

	@Before
	public void initialise() {
		account = new Account(transactionStore);
	}
	
	@Test
	public void store_a_deposit_transaction() {
		account.deposit(100);
		verify(transactionStore).addDepositTransaction(100);
	}

	@Test
	public void store_a_withdrawal_transaction() {
		account.withdraw(100);
		verify(transactionStore).addWithdrawTransaction(100);
	}
	
	@Test
	public void print_a_statement_containing_all_transactions() {
		List<Transaction> transactions = Arrays.asList(new Transaction());
		given(transactionStore.getTransactions()).willReturn(transactions);
		account.printStatement();
		verify(statementPrinter).print(transactions);
	}

}
