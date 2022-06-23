package fr.fbo.kata.service;



import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.exception.NSFException;
import fr.fbo.kata.model.Account;

import java.math.BigDecimal;

/**
 * @author Fayçal BOUACIDA
 */
public interface  AccountService {
    /**
     * deposit a amount into the account
     * @param account the client account
     * @param amount an amount of money to deposit
     * @return
     * @throws OverdraftException
     */
    Account deposit(Account account, BigDecimal amount) throws OverdraftException;

    /**
     * pull a amount from a account
     * @param account
     * @param amount the amount to get
     * @return
     * @throws OverdraftException
     * @throws NSFException
     */
    Account pull(Account account, BigDecimal amount) throws OverdraftException, NSFException;
}
