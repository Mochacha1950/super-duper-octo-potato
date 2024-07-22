package lesson26;
import java.util. HashMap;
import java.util.Map;
public class Practice2602 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 人名とその人が生まれた年の元号を格納するマップを生成する
		Map<String, String> a = new HashMap<>();
		
		
		String N_tanaka = "田中太郎";
		String N_suzuki = "鈴木二郎";
		String N_watabe = "渡辺花子";
		
		String showa = "昭和";
		String heisei = "平成";
		
		// mapにキー 「田中太郎」、 値 「昭和」 を追加する 
		a.put("田中太郎", "昭和");
		
		// mapにキー 「鈴木二郎」、 値 「平成」 を追加する 
		a.put("鈴木二郎", "平成");
		
		// mapにキー「渡辺花子」、値 「平成」 を追加する 
		a.put("渡辺花子", "平成");
		
		
		// 田中太郎さんが生まれた年の元号を標準出力する 

		System.out.print("田中太郎さんは"+a.get(N_tanaka)+"生まれです。\n"); 
		
		// 鈴木二郎さんが生まれた年の元号を標準出力する 

		System.out.print("鈴木二郎さんは"+a.get(N_suzuki)+"生まれです。\n"); 
		
		// 渡辺花子さんが生まれた年の元号を標準出力する

		System.out.print("渡辺花子さんは"+a.get(N_watabe)+"生まれです。\n"); 
		
		
//		System.out.println(田中太郎さんは昭和生まれです。 
//				鈴木二郎さんは平成生まれです。 
//				渡辺花子さんは平成生まれです。
//				);
		
		
	}

}
