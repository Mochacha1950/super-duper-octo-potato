package lesson29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmployeeManagementSystem2904 implements ManagementSystem2904{

	List<String> employeeNames = new ArrayList<>();
	
	@Override
	public void registName() {
		// TODO Auto-generated method stub
		String[] groupOfNames = new String[] {"tanaka","suzuki","sato","murata","watabe"};		
		employeeNames = Arrays.asList(groupOfNames);
	}
	
	/**
	 * ユーザーId入力メソッド
	 * 
	 */
	@Override
	public int inputId() {
		// TODO Auto-generated method stub
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputEmployeeId = null;
		
		try {
			inputEmployeeId = reader.readLine();
			inputEmployeeId.trim();
		}catch(IOException e) {
			System.out.println("入力処理に失敗した。");
		}
		
		Pattern p = Pattern.compile("^[0-4]$");
		Matcher m = p.matcher(inputEmployeeId);
		
		int intToReturn = -1;
		
		if (m.find()) {
			intToReturn = Integer.parseInt(inputEmployeeId);
		}else {
			System.out.println("0~4の番号以外の値が入力されました。");
		}
		
		return intToReturn;
		
	}
	

	@Override
	public void showName(int id) {
		// TODO Auto-generated method stub
		//引数で受け取ったIDを元にemployeeNamesから該当する社員を検索し出力
		
		try {
			System.out.println(employeeNames.get(id));
		}catch(Exception e) {
			System.out.println();
			System.out.println(e.getMessage());
		}
		
		
	}

}
