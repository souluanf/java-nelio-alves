package model.exceptions;

public class WithdrawException extends RuntimeException {
    private static final long serialVersionUID = 3303870181677866627L;

    public WithdrawException(String msg) {
        super(msg);
    }
}
