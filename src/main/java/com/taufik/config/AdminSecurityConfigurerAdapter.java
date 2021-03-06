package com.taufik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.taufik.other.Constant;
import com.taufik.other.FailureLoginHandler;
import com.taufik.other.SuccessLoginHandler;
/*
@Order(2)
@EnableWebSecurity
@Configuration*/
public class AdminSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
	
	@Autowired
	AdminDetailService userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()			
			.antMatchers("/admin/login").permitAll()
			.antMatchers("/assets/**").permitAll()
			.antMatchers("/admin/**").authenticated()
			.antMatchers("/admin/**").hasAuthority( String.valueOf(Constant.ADMIN_STATUS) )
			.and()
			.formLogin()
			.usernameParameter("username")
			.passwordParameter("password")
			.loginPage("/admin/login")
			.successHandler( new SuccessLoginHandler() )
			.failureHandler(new FailureLoginHandler()).and()
			.logout()
				.logoutUrl("/admin/logout")
				.logoutSuccessUrl("/admin/login")
				.clearAuthentication(true)
//			.and()
//			.formLogin()
//			.usernameParameter("username")
//			.passwordParameter("password")
//			.loginPage("/login")
//			.successHandler( new SuccessLoginHandler("/") )
//			.failureHandler(new FailureLoginHandler()).and()
//			.logout()
//				.logoutUrl("/admin/logout")
//				.logoutSuccessUrl("/admin/login")
//				.clearAuthentication(true)
;			
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
		// TODO Auto-generated method stub
	}
	
}
