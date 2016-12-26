package com.taufik.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.taufik.other.Constant;
import com.taufik.other.FailureLoginHandler;
import com.taufik.other.SuccessLoginHandler;

@EnableWebSecurity
@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests()			
			.antMatchers("/user/login").permitAll()
			.antMatchers("/assets/**").permitAll()
			.antMatchers("/admin/**","/user/**").authenticated()
			.antMatchers("/admin/**").hasAuthority( String.valueOf(Constant.ADMIN_STATUS) )
			.antMatchers("/api/user/**").hasAuthority( String.valueOf(Constant.USER_STATUS) )			
			.anyRequest().permitAll()
			.and()
			.exceptionHandling()
			.accessDeniedPage("/error/notfound")
			.and()
			.formLogin()
			.usernameParameter("username")
			.passwordParameter("password")
			.loginPage("/user/login")
			.successHandler( new SuccessLoginHandler() )
			.failureHandler(new FailureLoginHandler()).and()
			.logout()
				.logoutUrl("/user/logout")
				.logoutSuccessUrl("/user/login")
				.clearAuthentication(true);			
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

}
