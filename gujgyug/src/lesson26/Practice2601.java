package lesson26;

import java.util.ArrayList;
import java.util.List;

public class Practice2601 {

	public static void aaa(String[] args) {
		// TODO Auto-generated method stub
		
		// DVDのタイトルを格納するリストを作成
		List<String> DVDTitle = new ArrayList<>();
		
		
		// リストにDVDタイトル「JAVA基礎」を追加
		DVDTitle.add("JAVA基礎");
		DVDTitle.add("JAVA基礎");
		
		// リストにDVDのタイトル「JAVA応用」追加
		DVDTitle.add("JAVA応用");
		
		
		// リストから「JAVA応用」を削除する
		for(int i = 0; i<DVDTitle.size();i++) {
			if(DVDTitle.get(i).equals("JAVA応用")) {
				DVDTitle.remove(i);
			}
		}
		
		// リスト内の要素数を取得して標準出力する
		
		
		System.out.println(DVDTitle.size());
	}

}
