package kr.co.springsecurity.member;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User{
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> auth) {
		super(username, password, auth);
	}

	private static final long serialVersionUID =1L;
	
	private MemberDto member;
	
	public CustomUser(MemberDto dto) {
		
		    super(dto.getUser_id(), dto.getUser_pw(), 
		    	dto.getAuthList().stream().map(auth 
		    			-> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		
		    this.member = dto;
		  }

	
	
	
}
