package org.zerock.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.zerock.domain.AuthVO;
import org.zerock.domain.MemberVO;

import lombok.Data;

@Data
public class CustomUser extends User {
	
	private MemberVO member;
	
	private static List<SimpleGrantedAuthority> getAuth(List<AuthVO> list) {//생성자에 호출제한이 많으므로 static을 쓴다.
		
		if(list == null || list.size() == 0) {
			return null;
		}
		
		return list.stream().map(vo -> new SimpleGrantedAuthority(vo.getAuth()))
				.collect(Collectors.toList());
	}
	
	public CustomUser(MemberVO member) {
		
		this(member.getUserid(), member.getUserpw(), getAuth(member.getAuthList())); //getAuth메서드로 생성자 생성
		this.member = member;
	}
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);

	
	}

}
