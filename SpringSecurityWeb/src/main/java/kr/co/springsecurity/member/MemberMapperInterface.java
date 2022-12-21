package kr.co.springsecurity.member;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapperInterface {

	public MemberDto read(String user_id) throws Exception;
	
}
