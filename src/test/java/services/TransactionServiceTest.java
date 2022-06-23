package services;

import fr.fbo.kata.model.Account;
import fr.fbo.kata.model.Transaction;
import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.service.TransactionService;
import fr.fbo.kata.util.AccountBuilder;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Fayçal BOUACIDA
 */
public class TransactionServiceTest {
    private Account account;

    private TransactionService operationService;

    @Before
    public void init() {
        account = new AccountBuilder(1L, BigDecimal.valueOf(0),new ArrayList<>()).build();
    }

    @Before
    public void setup() {
        operationService = mock(TransactionService.class);
    }

    @Test
    public void testHistory() throws OverdraftException {
        Transaction tr = account.deposit(BigDecimal.valueOf(100)).getTransactions().get(0);
        List<Transaction> accountTransactions = account.getTransactions();

        when(operationService.getHistory(any())).thenReturn(
                account.getTransactions());
        List<Transaction> afterList = operationService.getHistory(account);

        assertThat(afterList).isEqualTo(accountTransactions);
        assertThat(tr).isEqualTo(accountTransactions.get(0));

    }
}
