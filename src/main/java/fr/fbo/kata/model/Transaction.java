package fr.fbo.kata.model;


import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author Fayçal BOUACIDA
 */

public class Transaction {
    // combination of date, time and zone
    private final ZonedDateTime date;
    private final BigDecimal amount;
    private final TransactionType transactionType;

    public Transaction() {
        // TODO: must be init via object builder
        this.date = null;
        this.amount = null;
        this.transactionType = null;
    }

    public ZonedDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
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
