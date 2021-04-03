package tn.esprit.spring.exceptions;

public class SubforumNotFoundException extends RuntimeException {

    public SubforumNotFoundException(String message) {
        super(message);
    }
}
