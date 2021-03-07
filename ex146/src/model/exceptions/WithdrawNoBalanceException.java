package model.exceptions;

public class WithdrawNoBalanceException extends RuntimeException{

    public WithdrawNoBalanceException() {
        super();
    }

    public WithdrawNoBalanceException(String message) {
        super(message);
    }
}
