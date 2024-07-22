package lesson25;

import java.io.IOException;

public class Practice2502 {
	public static void main(String[] args) throws IOException{
		Input2502 a = new Input2502();
		
		try {
			a.inputPassword();
		}catch(InputPasswordException2502 e) {
			e.printStackTrace();
		}
		
		
	}
}
