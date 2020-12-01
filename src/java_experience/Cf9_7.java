package java_experience;
// 練習問題

import java.util.ArrayList;

public class Cf9_7 {
	public static void main(String[] args) {
		System.out.println("1円以上のアイテム一覧表を表示します");
		ArrayList<Cf9_6> items = Cf9_8.findByMinimumPrice(1);
		for (Cf9_6 item : items) {
			System.out.printf("%-10s%4d%4d \r\n",
					item.getName(),
					item.getPrice(),
					item.getWeight());
		}
	}
}
