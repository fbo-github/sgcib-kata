package fr.fbo.kata.service;



import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.exception.NSFException;
import fr.fbo.kata.model.Account;

import java.math.BigDecimal;


public interface  AccountService {

    Account deposit(Account account, BigDecimal depositAmount) throws OverdraftException;
    Account pull(Account account, BigDecimal amount) throws OverdraftException, NSFException;
}
