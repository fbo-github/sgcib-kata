package fr.fbo.kata.model;

import java.math.BigDecimal;


/**
 * @author Fayçal BOUACIDA
 */

public class Account {
    
    private final Long id = 1L;
    private BigDecimal balance;
    
    //TODO:
    // add transactions list

  

    public Long getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    
}


