package lesson29;

public class SmartPhone2903 extends Phone2903{
	/** Eメールアドレス*/
	private String email;
	
	/**
	 * コンストラクタ
	 * 
	 * @param email Eメールアドレス
	 */
	public SmartPhone2903(String email) {
		super("09012345678");
		this.email = email;
	}
	
	/**
	 * 携帯電話の情報を表示
	 */
	public void showInformation() {
		System.out.println(this.number);
		System.out.println(this.email);
	}
	
}
