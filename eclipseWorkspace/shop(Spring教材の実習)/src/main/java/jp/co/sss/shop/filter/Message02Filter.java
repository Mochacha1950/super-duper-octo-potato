package jp.co.sss.shop.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Message02Filter extends HttpFilter{
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException{
		
		System.out.println("Done Message02Filter");
		chain.doFilter(req, res);
		
	}
	
}
