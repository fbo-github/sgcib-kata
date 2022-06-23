package fr.fbo.kata.exception;

import fr.fbo.kata.exception.common.CommonException;

/**
 * occurs when there isn't enough money in an account to cover the transaction.
 * @author Fayçal BOUACIDA
 */
public class NSFException extends CommonException {
    public NSFException(){super("Non-sufficient balance");}
}
