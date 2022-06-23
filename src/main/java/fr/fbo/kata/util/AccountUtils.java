package fr.fbo.kata.util;

import fr.fbo.kata.exception.OverdraftException;
import fr.fbo.kata.exception.NSFException;
import fr.fbo.kata.model.Transaction;
import fr.fbo.kata.model.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

public final class AccountUtils {

    public static void verifyBalance(BigDecimal transactionAmount, BigDecimal balance) {
        if (transactionAmount.compareTo(balance) == 1) throw new NSFException();
    }

    public static void verifyTransaction(BigDecimal transactionAmount) {
        if (transactionAmount.compareTo(BigDecimal.valueOf(0)) <= 0) throw new OverdraftException();
    }

    public static void saveTransaction(TransactionType transactionType, BigDecimal transactionAmount, BigDecimal balance, List<Transaction> transactions) {
        Transaction transaction = new TransactionBuilder(transactionType, ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Europe/Paris")), transactionAmount, balance).build();
        transactions.add(transaction);
    }
}
