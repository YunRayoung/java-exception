package sample02;

public class ExceptionApp1 {

	/**
	 * 문자열을 전달받아서 정수로 변환해서 반환한다.
	 * @param text 숫자로 구성된 문자열
	 * @return 정수값
	 */
	public static int toInt(String text) {						// 메소드 // 문자열을 정수로 바꾸는 
		int number = Integer.parseInt(text);
		return number;
	}
	
	public static void main(String[] args) {
	
		try {
			int value = toInt("1234가");								//"1234가" 예외처리 안한경우 - 최종적으로 JVM 전달 -> Object toString 재정의 호출
			System.out.println(value);
		} catch (NumberFormatException ex) {						// JVM 전달 x / try ~ catch 가로채다 / 예외 발생 x
			String errorMessage = ex.getMessage();
			System.out.println("오류 메세지: " + errorMessage);
			
			String text = ex.toString();
			System.out.println("toString() -> " + text);
			
			ex.printStackTrace();									// 메소드를 실행하면 예외된(오류) 메세지 출력 오류가 발생한 행번호 입력 // 어디서 오류 발생한지 파악.
		}															// throwable 에 정의된 내용 // 예외발생여부 확인
	}
}
