package com.taufik.other;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SuccessLoginHandler implements AuthenticationSuccessHandler{
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
			throws IOException, ServletException {
		
		String url = "";
		for( GrantedAuthority data : arg2.getAuthorities() ){
			url = data.getAuthority().equals( String.valueOf( Constant.ADMIN_STATUS ) ) ?
					"admin/dashboard" : "";
		}
		
		String data = "{\"error\" : \"false\",\"msg\" : \"Login Sukses, anda akan dialihkan secara otomatis\""
				+ ", \"url\" : \"/"+url+"\"  }";
		PrintWriter out = arg1.getWriter();
		out.write(data);		
	}

}
