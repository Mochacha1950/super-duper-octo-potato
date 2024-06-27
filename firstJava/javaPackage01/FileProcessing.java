package javaPackage01;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.FileWriter;
import java.io.FileReader;

public class FileProcessing {
	
	public static void fileCreate(String contents) throws IOException{
		
		BufferedWriter file = new BufferedWriter(new FileWriter("UserInformation.txt"));
		
		file.write(contents);
		file.close();
	}
	
	public static void fileUpdate() {
		
	}
	
	public static void seeUserInformation() throws IOException{
		
		BufferedReader file = new BufferedReader(new FileReader("UserInformation.txt"));
		
		System.out.println(file.readLine());
		file.close();
		
	}
	
	public static void fileDelete() {
		
	}
	
}
