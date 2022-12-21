package kr.co.springsecurity.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberMapperImpl implements MemberMapperInterface {

	@Autowired
	private SqlSession session;
	private static String namespace = "kr.co.springsecurity.member.memberMapper.";

	@Override
	public MemberDto read(String user_id) throws Exception {
		MemberDto dto = null;
		try {
			System.out.println("read");
			dto = session.selectOne(namespace + "read", user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("dto at impl : " + dto);

		return session.selectOne(namespace + "read", user_id);
	}

}
