package fr.fbo.kata.test.model.account;

import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.exception.NSFException;
import fr.fbo.kata.model.Account;
import fr.fbo.kata.util.AccountBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Fayçal BOUACIDA
 */
public class AccountTest {
    private Account account;

    @Before
    public void init() {
        account = new AccountBuilder(1L, BigDecimal.valueOf(0),new ArrayList<>()).build();
    }

    @Test(expected = OverdraftException.class)
    public void testBalanceException() throws OverdraftException {
        account.deposit(BigDecimal.valueOf(-100));
    }

    @Test(expected = NSFException.class)
    public void testNSFException() throws NSFException, OverdraftException {
        account.pull(BigDecimal.valueOf(100000000));
    }




}
