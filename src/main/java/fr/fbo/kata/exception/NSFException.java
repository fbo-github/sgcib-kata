package fr.fbo.kata.exception;

import fr.fbo.kata.exception.common.CommonException;

/**
 * @author Fayçal BOUACIDA
 */
public class NSFException extends CommonException {
    public NSFException(){super("Non-sufficient balance");}
}
