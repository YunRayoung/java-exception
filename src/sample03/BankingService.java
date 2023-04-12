package sample03;

import javax.security.auth.login.AccountNotFoundException;

public class BankingService {
	
	/**
	 * 계좌정보에 대한 추가/조회/변경/삭제 기능을 제공하는 객체를 참조한다.
	 */
	private BankingRepository repo = new BankingRepository();		// new 키워드가 객체 생성 -
	
	/**
	 * 계좌번호와 비밀번호를 전달받아서 계좌정보를 반환한다.
	 * @param no	계좌번호
	 * @param password	비밀번호
	 * @return	계좌정보
	 * @throws AccountNotFoundException 
	 */
	public Account getAccountDetailAccount(int no, int password) throws AccountNotFoundException {
		Account account = repo.getAccountByNo(no);
		if (account == null) {
			throw new AccountNotFoundException(String.valueOf(no));
		}
		
		if (account.getPassword() != password) {
			throw new PasswordMismatchException();
		}					
		
		return account;
	}
	
	/**
	 * 계좌번호, 입금액을 전달받아서 계좌의 현재 잔액을 증가시킨다.
	 * @param no	계좌번호
	 * @param amount	입금액
	 * @throws AccountNotFoundException 
	 */
	public void deposit(int no, long amount) throws AccountNotFoundException {
		Account account = repo.getAccountByNo(no);
		if (account == null) {
			throw new AccountNotFoundException(String.valueOf(no));
		}
		account.setBalance(account.getBalance() + amount);
		
	}
	
	/**
	 * 계좌번호, 비밀번호, 출금액을 전달받아서 계좌의 현재 잔액을 감소시킨다.
	 * @param no 계좌번호
	 * @param password 비밀번호
	 * @param amount 출금액
	 */
	public void withdraw(int no, int password, long amount) throws AccountNotFoundException {
		Account account = repo.getAccountByNo(no);
		if (account == null) {
			throw new AccountNotFoundException(String.valueOf(no));
		}
		if (account.getPassword() != password) {
			throw new PasswordMismatchException();
		}
		if (account.getBalance() < amount) {
			String message = "현재잔액: " + account.getBalance() + ", 출금액: " + amount;
			throw new NotEnoughBalanceException(message);
		}
		account.setBalance(account.getBalance() - amount);
	}

	public Account getAccountDetail(int no, int password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
