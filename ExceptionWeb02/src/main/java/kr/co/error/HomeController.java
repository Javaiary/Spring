package kr.co.error;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST )
class myException extends RuntimeException {
	public myException(String msg) {
		super(msg);
	}
}

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR )
class myException2 extends RuntimeException {
	public myException2(String msg) {
		super(msg);
	}
}

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
@RequestMapping("/test")
	public String ezen (Model m) {
		throw new myException("사용자 정의 예외가 발생했습니다.");
	}


@RequestMapping("/test2")
public String ezen2 (Model m) {
	throw new myException("사용자 정의 예외가 발생했습니다2.");
}
}
