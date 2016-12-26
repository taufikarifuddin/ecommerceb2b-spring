package com.taufik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.taufik.other.Constant;
import com.taufik.other.FailureLoginHandler;
import com.taufik.other.SuccessLoginHandler;
/*
@Order(1)
@EnableWebSecurity
@Configuration*/
public class UserSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{

	@Autowired
	MemberDetailService userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()			
		.antMatchers("/api/user/**").authenticated()		
		.antMatchers("/user/**").authenticated()
		.antMatchers("/api/user/**").hasAnyAuthority( String.valueOf(Constant.USER_STATUS) )
		.antMatchers("/**").permitAll()
		.and()
		.formLogin()
		.usernameParameter("username")
		.passwordParameter("password")
		.loginPage("/login")
		.successHandler( new SuccessLoginHandler() )
		.failureHandler(new FailureLoginHandler()).and()
		.logout()
			.logoutUrl("/admin/logout")
			.logoutSuccessUrl("/admin/login")
			.clearAuthentication(true);
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}	

}
