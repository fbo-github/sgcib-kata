package fr.fbo.kata.util;

import fr.fbo.kata.model.Transaction;
import fr.fbo.kata.model.TransactionType;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author Fayçal BOUACIDA
 */
public class TransactionBuilder {

    private final TransactionType transactionType;
    private final ZonedDateTime date;
    private final BigDecimal amount;
    private final BigDecimal balance;

    public  TransactionBuilder(TransactionType transactionType, ZonedDateTime date, BigDecimal amount, BigDecimal balance) {
        this.transactionType = transactionType;
        this.date = date;
        this.amount = amount;
        this.balance = balance;
    }

    /**
     * build transaction
     * @return
     */
    public Transaction build() {
        Transaction transaction =  new Transaction(this);
        return transaction;
    }

    public TransactionType getTransactionType() {
        return transactionType;
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
}
