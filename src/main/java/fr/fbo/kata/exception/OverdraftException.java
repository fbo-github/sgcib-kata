package fr.fbo.kata.exception;

import fr.fbo.kata.exception.common.CommonException;

/**
 * @author Fayçal BOUACIDA
 */
public class OverdraftException extends CommonException {
    public OverdraftException(){super("Overdraft case");}
}
