package kr.co.springsecurity.member;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.userdetails.User.UserBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberDto {
	/**
	 * 
	 * user_id character(16) NOT NULL, user_name character(25) NOT NULL, user_pw
	 * character(16) NOT NULL, user_gender character(1) NOT NULL, user_birth_date
	 * date NOT NULL, user_email character(50) NOT NULL, user_phone_number
	 * character(11) NOT NULL, user_addr character varying(100), user_regdate date
	 * NOT NULL, user_grade character(10) DEFAULT '일반회원' NOT NULL, user_social_type
	 * character(1) NOT NULL
	 */

	private String user_id;
	private String user_name;
	private String user_pw;
	private String user_gender;
	private String birthYear;
	private String birthMonth;
	private String birthDay;
	private Date user_birth_date;
	private String user_email;
	private String user_phone_number;
	private String user_postcode;
	private String user_rNameAddr;
	private String user_detailAddr;
	private Date user_regdate;
	private String user_grade;
	private String user_social_type;

	private List<AuthDto> authList;

}
