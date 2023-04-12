package sample03;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils2 {

	private static final SimpleDateFormat YYYYMMDD = new SimpleDateFormat("yyyyy-MM-dd");
	
	/**
	 * 날짜를 'yyyy-MM-dd'형식의 텍스트로 변환해서 반환한다.
	 * @param date 날짜
	 * @return 지정된 포맷의 문자열
	 */
	
	public static String toText(Date date) {
		if (date == null) {
			return "";
		}
		String formattedText = YYYYMMDD.format(date);
		return formattedText;
	}
}
