package fr.fbo.kata.exception;

import fr.fbo.kata.exception.common.CommonException;

/**
 * occurs when there isn't enough money in an account to cover a transaction or withdrawal
 * @author Fayçal BOUACIDA
 */
public class OverdraftException extends CommonException {
    public OverdraftException(){super("Overdraft case");}
}
