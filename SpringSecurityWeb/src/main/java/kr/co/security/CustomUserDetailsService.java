package kr.co.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import kr.co.springsecurity.member.CustomUser;
import kr.co.springsecurity.member.MemberDto;
import kr.co.springsecurity.member.MemberMapperInterface;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
public class CustomUserDetailsService implements UserDetailsService {

	@Setter(onMethod_ = { @Autowired })
	private MemberMapperInterface memberMapper;

	@Override
	public UserDetails loadUserByUsername(String user_id) throws UsernameNotFoundException {
		MemberDto dto=null;
		
		log.warn("Load User By UserName : " + user_id);
		try {
			dto = memberMapper.read(user_id);
			log.warn("queried by member mapper: " + dto);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto == null ? null : new CustomUser(dto);
	}
}
