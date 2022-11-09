package kr.co.ezenweb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThrowingTwoDices {
	@RequestMapping("/rollDice")
	public void ezen(HttpServletResponse response) {
		response.setContentType("text/html"); 	
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		
		int num = (int)(Math.random()*6)+1;
		
		try {
			out= response.getWriter();
			out.println("<html>");
			out.println("<head>");
			out.println("</head>");
			out.println("<body>");
			switch (num) {
			case 1: out.println("<img src= 'resources\\img\\dice1.jpg'>");	
				break;
			case 2: out.println("<img src= 'resources\\img\\dice2.jpg'>");
				break;
			case 3: out.println("<img src= 'resources\\img\\dice3.jpg'>");
				break;
			case 4: out.println("<img src= 'resources\\img\\dice4.jpg'>");
				break;
			case 5: out.println("<img src= 'resources\\img\\dice5.jpg'>");
				break;
			case 6: out.println("<img src= 'resources\\img\\dice6.jpg'>");
				break;

			default: out.println("돌아가");
				break;
			}

			out.println("</body>");
			out.println("</html>");

		} catch (IOException e) {e.printStackTrace();}
	}
}
