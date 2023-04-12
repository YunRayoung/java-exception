package sample02;

/**  
 * 사용자 정의 예외 unchecked 클래스다.
 * @param message
 * @param cause
 */
public class CustomException extends RuntimeException {

	public CustomException (String message) {
		super(message);
	}

	public CustomException (String message, Throwable cause) {
		super(message, cause);
	}

}
