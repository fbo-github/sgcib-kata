package fr.fbo.kata.service.impl;

import fr.fbo.kata.model.Account;
import fr.fbo.kata.model.Transaction;
import fr.fbo.kata.service.TransactionService;

import java.util.List;

/**
 * @author Fayçal BOUACIDA
 */
public class TransactionServiceImpl implements TransactionService {
    /**
     * get the transaction's history of the account
     * @param account
     * @return
     */
    @Override
    public List<Transaction> getHistory(Account account) {
        return account.getTransactions();
    }
}
