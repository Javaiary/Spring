package kr.co.ezensep;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 년 월 일 을 입력하면 해당 요일을 알려주는 프로그램
@Controller					// [1] 원격 호출 가능한 프로그램으로 등록
public class DayOfTheWeekMVC {
	@RequestMapping("/getDayMVC")		// [2] URL과 메서드를 연결
	public String main(int year,int month, int day, Model model) {
	
	// 1. 입력 ==> 매개변수를 받았기 때문에 필요없어짐
//		String year = request.getParameter("year");
//		String month = request.getParameter("month");
//		String day = request.getParameter("day");
		
	// 2. 문자를 숫자로 바꿈 (처리) ==> int 형식으로 받았기 때문에 필요 없음
//		int yyyy = Integer.parseInt(year);
//		int mm = Integer.parseInt(month);
//		int dd = Integer.parseInt(day);
		
		// (1) 유효성 검사
		if(!isValid(year, month, day))
			return "dayOfWeekError";			//webapp/WEB-INF/views/dayOfWeekError.jsp
		char dayOfWeek = getDayofWeek(year, month, day);
		
	// 3.출력 ==> views/dayOfWeek.jsp 로 분리
	//servlet-context.xml에 경로/파일형식 지정되어있으니 name만 입력
		
	// 3. Model에 작업 결과 저장
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("dayOfWeek", dayOfWeek);
		
		return "dayOfWeek";
	}
	
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