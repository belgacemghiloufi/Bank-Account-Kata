package fr.tdd.bankaccount;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AccountShould {

	@Mock private TransactionStore transactionStore;
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

}
