package p1024;

public class J1024_01 {
	public static void main(String[]args) {
		//최댓값을 구하시오
		int max=0;
		int []arr= {1,5,3,8,2};
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				max=arr[i];
			}
			
		}
		System.out.println("최댓값: "+max);
		
		
//		for(int i=0;i<arr.length;i++) {
//			max=Math.max(max, arr[i]);
//		}
//		System.out.println(max);
		
		
		
		
	}//method
}//class
