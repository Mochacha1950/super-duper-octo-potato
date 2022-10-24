package p1024;

import java.util.Scanner;

public class J1024_03 {
	public static void main(String[]args) {
		Scanner sc = new Scanner(System.in);
		//while(true)
		//학생수 입력받음
		//입력받은 학생수만큼 국어점수 입력받음
		//최고 점수랑 평균을 구하는 프로그램 ㄱㄱ
		int num=0,choice=0;
		int total=0,max=0;
		double avg=0;
		int []a=null;
		
		loop:while(true) {
			System.out.println("1. 학생 수 입력");
			System.out.println("2. 국어 점수 입력");
			System.out.println("3. 입력된 점수 출력");
			System.out.println("4. 평균과 최고값 출력");
			System.out.println("5. 프로그램 종료");
			choice=sc.nextInt();
			switch(choice) {
			
			case 1:
				num=sc.nextInt();
				a=new int[num];
				break;
			case 2:
				for(int i=0;i<a.length;i++) {
					a[i]=sc.nextInt();
					if(a[i]>max) {
						max=a[i];
					}
					total+=a[i];
				}
				avg=(double)total/a.length;
				break;
			case 3:
				System.out.println("입력된 점수 출력");
				for(int i=0;i<a.length;i++) {
					System.out.println(i+1+"번째 학생의 국어 점수: "+a[i]);
				}
				break;
			case 4:
				System.out.printf("평균: %.2f  최고: %d ", avg, max);
				break;
			case 5:
				System.out.println("프로그램 종료");
				break loop;
			}
		}
		
	}//m
}//c
