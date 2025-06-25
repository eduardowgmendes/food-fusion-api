package br.com.edu.foodfusion.configuration.exception.handlers;

public class CustomerNotFoundException extends NotFoundException{
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
