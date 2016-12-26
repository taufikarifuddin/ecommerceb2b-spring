package com.taufik.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.taufik.model.Member;
import com.taufik.repository.MemberRepository;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	MemberRepository memberRepository;
	int role_id;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(username);
		if( member == null ){
			throw new UsernameNotFoundException("No user present with username: "+username);			
		}else{
			ArrayList<String> roles = new ArrayList<>();
			roles.add(String.valueOf( member.getRoleId() ));
			return new CustomUserDetails(member,roles);
		}
	}
	
	
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
}
