package gujgyug;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class practice1901 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		String HW = "hello world";
//		System.out.println(HW);
//		
//		System.out.println(HW.toUpperCase());
//		
//		Date dd = new Date();
//		String dd2 = dd.toString();
//		
//		System.out.println(dd);
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
//		
//		System.out.println(sdf.format(dd));
		
		List<String> a = new ArrayList<>();
		
		a.add("a");
		a.add("b");
		a.add("c");
		
		a.add(1,"d");
		
		
		for (String bb : a) {
			System.out.println(bb);
		}
		
		
	}

}
