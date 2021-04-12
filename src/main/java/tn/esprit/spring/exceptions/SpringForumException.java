package tn.esprit.spring.exceptions;

public class SpringForumException extends RuntimeException {

    public SpringForumException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringForumException(String exMessage) {
        super(exMessage);
    }
}