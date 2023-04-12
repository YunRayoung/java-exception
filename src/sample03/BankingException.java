package sample03;

public class BankingException extends RuntimeException {
	
	public BankingException() {}
	
	public BankingException(String message) {
		super(message);
	}

}
