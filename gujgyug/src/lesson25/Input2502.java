package lesson25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input2502 {

	public void inputPassword()throws IOException, InputPasswordException2502 {
		System.out.println("パスワードを入力してください (4文字以上、8文字以内)");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String password;
		do {
			
			password = reader.readLine();
			
			checkPassword(password);
			
			System.out.println("パスワードは"+password+"です。");
		}while(!password.equals("no"));
		
	}
	
	public void checkPassword(String a) throws InputPasswordException2502{
		
		
		int b = Integer.parseInt(a);
		
		if( b >= 4 && b <= 8) {
			return;
		}else {
			throw new InputPasswordException2502();
		}
		
	}

}
