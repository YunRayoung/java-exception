package sample03;

import javax.security.auth.login.AccountNotFoundException;

public class BankingApplication  {

	private KeyboardReader2 reader = new KeyboardReader2();
	private BankingService service = new BankingService();
	
	public void menu() {
		System.out.println("--------------------------------");
		System.out.println("1.조회 2.입금 3.출금 0.종료");
		System.out.println("--------------------------------");
		System.out.println();
		
		System.out.println("### 메뉴선택: ");
		int menuNo = reader.readInt();
		System.out.println();
		
		// 예외 일괄 처리
		try {
			if (menuNo == 1) {
				조회하기();
			} else if (menuNo == 2) {
			입금하기();
			} else if (menuNo == 3) {
				출금하기();
			} else if (menuNo == 0) {
				종료하기();
			}
		} catch (BankingException ex) {
			System.out.print("### 오류 발생: " + ex.toString());
			//ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("### 오류 발생: 알 수 없는 오류가 발생하였습니다.");
			//ex.printStackTrace();
			
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		menu();
	}
	
	private void 조회하기() {
		System.out.println("<< 계좌정보 조회하기 >>");
		System.out.println("### 계좌번호와 비밀번호를 입력하세요.");
		
		System.out.print("### 계좌번호 : ");
		int no = reader.readInt();
		System.out.print("### 비밀번호 : ");
		int password = reader.readInt();
		System.out.println();
		
		Account account = service.getAccountDetail(no, password);
		System.out.println("### 계좌상세 정보 출력");	
		System.out.println("----------------------------------");
		System.out.println("계좌번호 : " + account.getNo());
		System.out.println("예금주 : " + account.getOwner());
		System.out.println("현재잔액 : " + account.getBalance());
		System.out.println("----------------------------------");
	}
	
	private void 입금하기() throws AccountNotFoundException {
		System.out.println("<< 입금하기 >>");
		System.out.println("### 계좌번호와 입금액을 입력하세요.");
		
		System.out.print("### 계좌번호: ");
		int no = reader.readInt();
		System.out.print("### 입금액: ");
		long amount = reader.readLong();
		System.out.println();
		
		service.deposit(no, amount);
		System.out.println("### 입금이 완료되었습니다.");
	}
	
	private void 출금하기() throws AccountNotFoundException  {
		System.out.println("<< 출금하기 >>");
		System.out.println("### 계좌번호, 비밀번호, 출금액을 입력하세요.");
		
		System.out.print("### 계좌번호 : ");
		int no = reader.readInt();
		System.out.print("### 비밀번호 : ");
		int password = reader.readInt();
		System.out.print("### 출금액 : ");
		long amount = reader.readLong();
		System.out.println();
		
		service.withdraw(no, password, amount);
		System.out.println("### 출금이 완료되었습니다.");
	}
	
	private void 종료하기() {
		System.out.println("<< 프로그램 종료 >>");
		System.exit(0);
	}
	public static void main(String[] args) {
		BankingApplication app = new BankingApplication();
		app.menu();
	}
}
