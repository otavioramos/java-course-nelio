package model.exceptions;

public class WithdrawLimitException extends RuntimeException{

    public WithdrawLimitException(String message) {
        super(message);
    }

    public WithdrawLimitException() {
        super();
    }
}
