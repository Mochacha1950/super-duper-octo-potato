package javaPackage01;

import java.util.Scanner;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException{
		
        Scanner scanner = new Scanner(System.in);
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String inputNumber;
        int inputNumber2 = 0;
        String diplayInput;
        String firstOrNot = null;
        String userId;
        String userPassword;
        String userInformation = "";
                
        do {
        	// take USERID and PASSWORD
        	bw.write("is this your first time using our ATM? Yes/No \n");
            bw.flush();
            firstOrNot = br.readLine();
            
            if(firstOrNot.toLowerCase().equals("yes")) {
            	
            	bw.write("Let`s register");
            	bw.write("\nfill the beneath forms");
            	bw.write("\nuserid:");
            	bw.flush();
            	
            	userId = "userId: "+ br.readLine();
            	
            	bw.write("\npassword:");
            	bw.flush();
            	
            	userPassword = "userPassword: "+ br.readLine();
            	
            	userInformation = userId + "\n"+ userPassword;
            	
            	// create UserInfoFile
            	FileProcessing.fileCreate(userInformation);
            	bw.write("you just registered completely");
            	bw.flush();
            	
            }else if(firstOrNot.toLowerCase().equals("no")) {
            	// take USERID and PASSWORD
                bw.write("input user ID and password\n");
                bw.flush();
                
                // input userID segment
                diplayInput = br.readLine();
                bw.write("userID:" + diplayInput + "\n");
                bw.flush();
                
                // input password segment
                diplayInput = br.readLine();
                bw.write("password:" + diplayInput + "\n");
                bw.flush();
                do {
                	
                // show menu
                bw.write("\n  **input any number to choose action to have");
                bw.write("\n1) see your user information");
                bw.write("\n2) do something bad");
                bw.write("\n3) do something good");
                bw.write("\n4) EXIT \n");
                bw.flush();
                
                //input number
                inputNumber = br.readLine();
                
        	    	switch(inputNumber){
        	    	case "1":
        	    		FileProcessing.seeUserInformation();
        	    		break;
        	    	case "2":
        	    		System.out.print("do something bad");
        	    		break;
        	    	case "3":
        	    		System.out.print("do something good");
        	    		break;
        	    	case "4":
        	    		// create a file that save userInfo *this function to be conpleted in the future
        	            //FileProcessing.fileCreate(userInformation);
        	    		return;
        	    	}
        	    	
        	    	try {
            	    	inputNumber2 = Integer.valueOf(inputNumber);
        	    	}catch(Exception e) {
        	    		bw.write("what you typed is not a number\n");
        	    		bw.flush();
        	    		inputNumber2 = 0;
        	    	}
        	    	
        	    	
                }while(inputNumber2 < 4);    
            }else {
            	bw.write("pardon?\n");
            	bw.flush();
            	firstOrNot = "";
            }
        }while(firstOrNot.isEmpty());
        
        bw.close();
        scanner.close();
		
	}
}
