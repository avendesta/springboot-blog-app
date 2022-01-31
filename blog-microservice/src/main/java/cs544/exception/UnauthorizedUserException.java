package cs544.exception;

public class UnauthorizedUserException extends Exception{
    public UnauthorizedUserException(String errMsg){
        super(errMsg);
    }
}
