package fr.fbo.kata.test.model.operation;


import fr.fbo.kata.model.Account;
import fr.fbo.kata.model.Transaction;
import fr.fbo.kata.util.AccountBuilder;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;

/**
 * @author Fayçal BOUACIDA
 */
public class TransactionTest {
    private Account account;

    @Before
    public void init() {
        account = new AccountBuilder(1L, BigDecimal.valueOf(0),new ArrayList<>()).build();
    }

    @Test
    public void testTransactionsHistory() {
        Transaction transaction = account.deposit(BigDecimal.valueOf(100)).getTransactions().get(0);

        List<Transaction> accountTransactions = account.getTransactions();
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);

        assertThat(transactionList).isEqualTo(accountTransactions);
        assertThat(transaction).isEqualTo(accountTransactions.get(0));
    }
}
