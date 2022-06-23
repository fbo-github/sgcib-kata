package fr.fbo.kata.service.impl;

import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.exception.NSFException;
import fr.fbo.kata.model.Account;
import fr.fbo.kata.service.AccountService;

import java.math.BigDecimal;

/**
 * @author Fayçal BOUACIDA
 */
public class AccountServiceImpl implements AccountService {
    /**
     * deposit a amount into the account
     * @param account the client account
     * @param amount an amount of money to deposit
     * @return
     * @throws OverdraftException
     */
    @Override
    public Account deposit(Account account, BigDecimal amount) throws OverdraftException {
        return account.deposit(amount);
    }

    /**
     * pull a amount from a account
     * @param account
     * @param amount the amount to get
     * @return
     * @throws OverdraftException
     * @throws NSFException
     */
    @Override
    public Account pull(Account account, BigDecimal amount) throws OverdraftException, NSFException {
        return account.pull(amount);
    }
}
