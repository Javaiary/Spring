package kr.co.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.springsecurity.member.MemberDto;
import kr.co.springsecurity.member.MemberMapperInterface;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
public class MemberInjectionTest {

	@Setter(onMethod_ = @Autowired)
	private MemberMapperInterface dao;

	@Test
	public void testRead() throws Exception {
		MemberDto memberDto = dao.read("admin");
		
		System.out.println(memberDto);
		log.info(memberDto);

		memberDto.getAuthList().forEach(authdto -> log.info(authdto));

	}
}
