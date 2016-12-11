package com.taufik.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taufik.model.Member;
import com.taufik.other.Constant;
import com.taufik.repository.MemberRepository;

@Service
public class AdminDetailService implements UserDetailsService{

	@Autowired
	MemberRepository memberRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmailAndRoleId(username, Constant.ADMIN_STATUS);
		
		if( member == null ){
			System.out.println("null gan"+username);
			throw new UsernameNotFoundException("No user present with username: "+username);			
		}else{
			System.out.println("member"+member.getPassword());
			ArrayList<String> roles = new ArrayList<>();
			roles.add(String.valueOf( member.getRoleId() ));
			return new CustomUserDetails(member,roles);
		}
	}

}
