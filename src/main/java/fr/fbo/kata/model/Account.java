package fr.fbo.kata.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Fayçal BOUACIDA
 */

public class Account {
    private final Long id = 1L;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Account() {
        // TODO:
    }


    public Account deposit(BigDecimal amount)  {
       // TODO:
        return this;
    }


    public Account withdraw(BigDecimal amount)  {
        // TODO:

        return this;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}


