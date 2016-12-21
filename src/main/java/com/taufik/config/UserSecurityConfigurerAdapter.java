package com.taufik.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Order(2)
@EnableWebSecurity
@Configuration
public class UserSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{

	@Autowired
	MemberDetailService userDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
		authorizeRequests()			
		.antMatchers("/**").permitAll()
		.and()
		.formLogin()
		.usernameParameter("username")
		.passwordParameter("password")
		.loginPage("/login")
		.successHandler(new AuthenticationSuccessHandler() {
			
			@Override
			public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
					throws IOException, ServletException {
				
				String data = "{\"error\" : \"false\",\"msg\" : \"Login Sukses, anda akan dialihkan secara otomatis ke home\""
						+ ", \"url\" : \"/admin/dashboard\"  }";
				PrintWriter out = arg1.getWriter();
				out.write(data);
			}
		}).failureHandler(new AuthenticationFailureHandler() {
			
			@Override
			public void onAuthenticationFailure(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
					throws IOException, ServletException {
				// TODO Auto-generated method stub
				String data = "{\"error\" : \"true\",\"msg\" : \"Login Gagal, Username / password salah\" }";
				PrintWriter out = arg1.getWriter();
				out.write(data);					
			}
		}).and()
		.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/home")
			.clearAuthentication(true);			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}	

}
