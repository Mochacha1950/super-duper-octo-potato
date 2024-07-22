package lesson29;

public interface ManagementSystem2904 {
	/**
	 * 社員名をリストに登録（登録する名前は固定）
	 */
	
	void registName();
	
	/**
	 * 入力されたIDを取得
	 * 
	 * @return 検索対象のID
	 */
	public int inputId();
	
	/**
	 * メンバーの名前を出力
	 * 
	 * @param id 検索用ID
	 */
	void showName(int id);
	
}
