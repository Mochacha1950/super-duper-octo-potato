package jp.co.sss.shop.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

//Componentを外して非活性
//@Component
public class LoginCheckFilter extends HttpFilter{
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException{
		//リクエストURLを取得
		String requestURL = req.getRequestURI();
		if(requestURL.endsWith("/loginWithValidation")) {
			//リクエストURLが「ログイン画面への遷移処理」、
			//「ログイン処理」宛ての場合、ログインチェックを実施せず、
			//リクエスト対象のコントローラの処理に移る
			
			chain.doFilter(req, res);
			
		} else {
			//セッション情報を取得
			HttpSession session = req.getSession();
			//セッション情報からユーザのログイン情報（セッション属性 userId）を取得
			Integer userId = (Integer) session.getAttribute("userId");
			
			if(userId == null) {
				//ログイン情報が存在しない場合 (ログイン情報(userId)がnullの場合)、
				//ログイン画面にリダイレクトする
				res.sendRedirect("/shop/loginWithValidation");
				return;
			} else {
				chain.doFilter(req, res);
			}
			
		}
		
	}
}
