package com.taufik.other;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class SuccessLoginHandler implements AuthenticationSuccessHandler{
	
	private String url;
	
	public SuccessLoginHandler(String url) {
		this.url = url;
	}
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication arg2)
			throws IOException, ServletException {
		
		String data = "{\"error\" : \"false\",\"msg\" : \"Login Sukses, anda akan dialihkan secara otomatis\""
				+ ", \"url\" : \"/"+url+"\"  }";
		PrintWriter out = arg1.getWriter();
		out.write(data);

		
	}

}
