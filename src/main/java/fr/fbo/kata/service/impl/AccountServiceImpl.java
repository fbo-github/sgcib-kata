package fr.fbo.kata.service.impl;

import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.exception.NSFException;
import fr.fbo.kata.model.Account;
import fr.fbo.kata.service.AccountService;

import java.math.BigDecimal;


public class AccountServiceImpl implements AccountService {

    @Override
    public Account deposit(Account account, BigDecimal depositAmount) throws OverdraftException {
        return account.deposit(depositAmount);
    }

    @Override
    public Account pull(Account account, BigDecimal withdrawAmount) throws OverdraftException, NSFException {
        return account.pull(withdrawAmount);
    }
}
