package fr.fbo.kata.model;

import fr.fbo.kata.util.TransactionBuilder;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static java.util.Objects.requireNonNull;

/**
 * @author Fayçal BOUACIDA
 */

public class Transaction {
    // combination of date and time
    private final ZonedDateTime date;
    private final BigDecimal balance;
    private final BigDecimal amount;
    private final TransactionType transactionType;

    /**
     *
     * @param transaction
     */
    public Transaction(TransactionBuilder transaction) {
        this.date = requireNonNull(transaction.getDate(), "Account date must not be null");
        this.balance = requireNonNull(transaction.getBalance(), "Balance must not be null");
        this.transactionType = requireNonNull(transaction.getTransactionType(), "transactionType must not be null");
        this.amount = requireNonNull(transaction.getAmount(), "Amount must not be null");
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public String toString() {
        return "Transaction : " + this.transactionType +
                ", Date : " + this.date +
                ", Amount : " + this.amount;
    }
}
