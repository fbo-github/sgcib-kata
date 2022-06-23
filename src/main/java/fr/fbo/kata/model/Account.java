package fr.fbo.kata.model;



import fr.fbo.kata.util.AccountBuilder;
import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.exception.NSFException;
import fr.fbo.kata.util.AccountUtils;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * @author Fayçal BOUACIDA
 */

public class Account {
    private final Long id;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Account(AccountBuilder accountBuilder) {
        this.id = requireNonNull(accountBuilder.getId(), "accountId must not be null");
        this.balance = requireNonNull(accountBuilder.getBalance(), "balance must not be null");
        this.transactions = accountBuilder.getTransactions();
    }

    /**
     *
     * @param amount
     * @return
     * @throws OverdraftException
     */
    public Account deposit(BigDecimal amount) throws OverdraftException {
        AccountUtils.verifyTransaction(amount);
        balance = balance.add(amount);
        AccountUtils.saveTransaction(TransactionType.DEPOSIT, amount, balance, this.transactions);
        return this;
    }

    /**
     *
     * @param amount
     * @return
     * @throws OverdraftException
     * @throws NSFException
     */
    public Account pull(BigDecimal amount) throws OverdraftException, NSFException {
        AccountUtils.verifyTransaction(amount);
        AccountUtils.verifyBalance(amount, balance);
        balance = balance.subtract(amount);
        AccountUtils.saveTransaction(TransactionType.PULL, amount, balance, this.transactions);

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


