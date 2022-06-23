package fr.fbo.kata.service;

import fr.fbo.kata.model.Account;
import fr.fbo.kata.model.Transaction;

import java.util.List;

/**
 * @author Fayçal BOUACIDA
 */
public interface TransactionService {
    List<Transaction> getHistory(Account account);
}
