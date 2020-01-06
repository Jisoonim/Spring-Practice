package org.zerock.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zerock.domain.MemberVO;
import org.zerock.mapper.MemberMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;


@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Setter(onMethod_ = @Autowired )
	private MemberMapper MemberMapper;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		log.info("++++++++++++++++++++++++custom user service++++++++++++++++++++++++" + MemberMapper);
		log.info("++++++++++++++++++++++++custom user service++++++++++++++++++++++++" + MemberMapper);
		log.info("++++++++++++++++++++++++custom user service++++++++++++++++++++++++" + MemberMapper);
		log.info("++++++++++++++++++++++++custom user service++++++++++++++++++++++++" + MemberMapper);
		
		
		MemberVO member = MemberMapper.getMember(username);
		
		if(member == null) {
			throw new UsernameNotFoundException("그런 사용자는 없습니다.............");
		}
		
		return new CustomUser(member);
		
		
		
//		String[] arr = {"ROLE_MEMBER", "ROLE_ADMIN"};
//		List<SimpleGrantedAuthority> authList = null;
//		
//		authList = Arrays.stream(arr)
//		.map(str -> new SimpleGrantedAuthority(str))
//		.collect(Collectors.toList());
//		
//		CustomUser user = new CustomUser("aaa", "$2a$10$3DuR0Uj6.G9ld6Fn5x65Q.ExwAXxMnjC7jbNuvMCQLdYWmM2YZQbK",
//				authList); //유저이름,유저패스워드,권한
		
		
//		return user;
	}

}
