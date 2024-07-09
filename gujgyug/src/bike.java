
public class bike {
	
	private int number;
	private String name;
	public static int count = 0;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	
	
	
	public bike(int number, String name){
		
		this.number = number;
		this.name = name;
		
		count++;
		
	}
	
	
	
	public void show() {
		System.out.println("now`s bike amount" + count);
	}
	
	public static void staticShow() {
		System.out.println("now`s bike amount" + count);
	}
	
}
