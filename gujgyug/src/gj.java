import java.math.BigDecimal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

public class gj {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
		
		
		
		String inputDataString;
		do {
			
			inputDataString = reader.readLine();
			
		}while(isIllegalData(inputDataString));
		
		System.out.println(inputDataString);
		
	}
	
	public static boolean isIllegalData(String inputData) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		try {
			
			sdf.parse(inputData);
			
			return false;
			
		}catch(ParseException e){
			System.out.println(e);
			Pattern a= Pattern.compile("[/w]");
			a.matcher(inputData);  
			return true;
		}
		
	}

}
