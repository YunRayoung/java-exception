package sample01;


public class ExceptionApp4 {

//	public static void test1() throws IOException, ClassNotFoundException {
//		System.out.println("예외처리 위임하기 연습");
//		test2();
//	}
//	
//	public static void test2() throws IOException, ClassNotFoundException {
//		System.out.println("예외처리 위임하기 연습");
//		test3();
//	}
//	
//	public static void test3() throws IOException, ClassNotFoundException {
//		System.out.println("예외처리 위임하기 연습");
//		test4();
//		
//		Class.forName("java.io.String");
//	}
//	
//	public static void test4() throws IOException {
//		FileWriter writer = new FileWriter("src/sample01/sample04.txt");
//		writer.write("파일쓰기 연습");
//		writer.close();
//	}
	public static void test2(String str) {						// 예외처리 위임
		test1(str);												// 여기로 전달
	}
	
	public static void test1(String str) {
		int number = Integer.parseInt(str);						// 예외발생
		System.out.println("number -> " + number);
		
	}

	public static void main(String[] args) {
		try {
			test2("1234");
			test2("1234오");
		} catch (NumberFormatException ex) {
			System.out.println("유효한 숫자형식의 문자열의 아닙니다.");	// Unchecked Exception 장점 // 어디서 어떻게 예외처리 // 일괄처리
		}
		
	}
}
