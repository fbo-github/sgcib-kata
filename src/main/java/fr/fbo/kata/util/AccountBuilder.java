package fr.fbo.kata.util;

import fr.fbo.kata.model.Account;
import fr.fbo.kata.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Fayçal BOUACIDA
 */
public class AccountBuilder {
    private Long id;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public AccountBuilder(Long id, BigDecimal balance, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
    }

    /**
     * build the account
     * @return
     */
    public Account build() {
        Account account =  new Account(this);
        return account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
