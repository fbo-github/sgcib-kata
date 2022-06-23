package services;

import fr.fbo.kata.model.Account;
import fr.fbo.kata.model.Transaction;
import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.service.AccountService;
import fr.fbo.kata.util.AccountBuilder;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Fayçal BOUACIDA
 */
public class AccountServiceTest {
    private Account account;

    private AccountService accountService;

    @Before
    public void init() {
        account = new AccountBuilder(1L, BigDecimal.valueOf(0),new ArrayList<>()).build();
    }

    @Before
    public void setup(){
        accountService = mock(AccountService.class);
    }

    @Test
    public void testDeposit() throws OverdraftException {
        Account accountBeforeDeposit = new AccountBuilder(1L, BigDecimal.valueOf(5000),new ArrayList<>()).build();
        when(accountService.deposit(any(), any())).thenReturn(account.deposit(BigDecimal.valueOf(5000)));
        Account accountAfterDeposit = accountService.deposit(account,BigDecimal.valueOf(5000));
        assertThat(accountAfterDeposit.getBalance()).isEqualTo(accountBeforeDeposit.getBalance());
    }

    @Test
    public void testPull() throws OverdraftException {
        Account before = new AccountBuilder(1L, BigDecimal.valueOf(1000),new ArrayList<Transaction>()).build();
        account.deposit(BigDecimal.valueOf(2000));
        when(accountService.pull(any(), any())).thenReturn(account.pull(BigDecimal.valueOf(1000)));
        Account after = accountService.pull(account,BigDecimal.valueOf(1000));
        assertThat(after.getBalance()).isEqualTo(before.getBalance());
    }
}

