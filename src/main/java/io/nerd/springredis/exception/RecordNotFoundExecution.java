package io.nerd.springredis.exception;

public class RecordNotFoundExecution extends RuntimeException{

    public RecordNotFoundExecution(String message) {
        super(message);
    }
}
