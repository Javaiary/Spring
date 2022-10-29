package kr.co.ezensep;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 년 월 일 을 입력하면 해당 요일을 알려주는 프로그램
@Controller					// [1] 원격 호출 가능한 프로그램으로 등록
public class DayOfTheWeekMVC2 {
	@RequestMapping("/getDayMVC2")		// [2] URL과 메서드를 연결
	public void main(int year,int month, int day, Model model) {

		// (1) 유효성 검사
//		if(!isValid(year, month, day))
//			return "dayOfWeekError";			//webapp/WEB-INF/views/dayOfWeekError.jsp
		char dayOfWeek = getDayofWeek(year, month, day);

		
	// Model에 작업 결과 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("dayOfWeek", dayOfWeek);
	}		
//		return "dayOfWeek";   -- 요청을 처리해주는 view단이 없음
	
	private boolean isValid(int year, int month, int day) {
		if(year ==-1 || month ==-1 || day==-1)
			return false;
		return(1<=month && month <= 12) && (1<=day && day<=31);		//간단한 체크
	}
	private static char getDayofWeek(int year, int month, int day) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day); 							// 날짜 setting
		
		int dayofweek = cal.get(Calendar.DAY_OF_WEEK);		// 요일 리턴(sunday = 1, ....)
		
		/*
		 *  " 일월화수목금토".charAt(2); => 월
		 */
		char dayoftheweek =" 일월화수목금토".charAt(dayofweek);
		return dayoftheweek;
	}
}