package com.taufik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.taufik.other.Constant;
import com.taufik.other.FailureLoginHandler;
import com.taufik.other.SuccessLoginHandler;

public class SecurityConfig {
	
	public static class UserSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{

		@Autowired
		MemberDetailService userDetailService;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http
			.antMatcher("/user/**")
			.httpBasic()
			.and()
			.authorizeRequests()			
			.antMatchers("/user/**","/api/user/**").authenticated()
			.anyRequest().authenticated()
			.antMatchers("/api/user/**").hasAnyAuthority( String.valueOf(Constant.USER_STATUS) )								
//			.antMatchers("/**").permitAll()
			.and()
			.formLogin()
			.usernameParameter("username")
			.passwordParameter("password")
			.loginPage("/user/login")
			.successHandler( new SuccessLoginHandler() )
			.failureHandler(new FailureLoginHandler()).and()
			.logout()
				.logoutUrl("/user/logout")
				.logoutSuccessUrl("/")
				.clearAuthentication(true);
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailService);
		}	

	}
	

	
	public static class AdminSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{
		
		@Autowired
		AdminDetailService userDetailService;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			http
				.httpBasic()
				.and()
				.authorizeRequests()			
				.antMatchers("/admin/login", "/assets/**").permitAll()
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
					.clearAuthentication(true);		
				
		}
		
		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailService);
			// TODO Auto-generated method stub
		}
		
	}
}
