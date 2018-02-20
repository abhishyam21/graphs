package com.abhishyam.exceptions;

/**
 * Created by Abhishyam on 20-Feb,2018
 */
public class BadInputException extends Exception{
    public BadInputException() {
        super();
    }

    public BadInputException(String message) {
        super(message);
    }
}
