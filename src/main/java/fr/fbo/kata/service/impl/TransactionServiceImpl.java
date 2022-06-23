package fr.fbo.kata.service.impl;

import fr.fbo.kata.model.Account;
import fr.fbo.kata.model.Transaction;
import fr.fbo.kata.service.TransactionService;

import java.util.List;


public class TransactionServiceImpl implements TransactionService {

    @Override
    public List<Transaction> getHistory(Account account) {
        return account.getTransactions();
    }
}
