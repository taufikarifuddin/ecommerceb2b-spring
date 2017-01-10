package com.taufik.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

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
/*			.authenticationEntryPoint(new AuthenticationEntryPoint() {
				
				@Override
				public void commence(HttpServletRequest arg0, HttpServletResponse arg1, AuthenticationException arg2)
						throws IOException, ServletException {
					
					String requestedWith = arg0.getHeader("X-Requested-With");
			        Boolean isAjax = requestedWith != null ? "XMLHttpRequest".equals(requestedWith) : false;			        
			        if( isAjax ){				        
						arg1.sendError(HttpServletResponse.SC_UNAUTHORIZED,arg2.getMessage());								        	
			        }
				}
			})*/
			.and()
			.formLogin()
			.usernameParameter("username")
			.passwordParameter("password")
			.loginPage("/user/login")
			.successHandler( new SuccessLoginHandler() )
			.failureHandler(new FailureLoginHandler()).and()
			.logout()
				.logoutRequestMatcher( new AntPathRequestMatcher("/user/logout") )
//				.logoutUrl("/user/logout")
				.logoutSuccessUrl("/user/login")
				.clearAuthentication(true);			
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

}
