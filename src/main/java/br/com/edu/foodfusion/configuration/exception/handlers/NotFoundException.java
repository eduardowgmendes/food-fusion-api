package br.com.edu.foodfusion.configuration.exception.handlers;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

}
