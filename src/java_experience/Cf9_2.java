package java_experience;
// SQL送信パターン　①更新系

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Cf9_2 {
	public static void main(String[] args) {
		try {
			/*
			 * MySQLに接続(新しいバージョンではcjを入れ込む必要がある)
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception e) {
			e.printStackTrace();
		}

		try (
				/*
				 * STEP1 : データベースの接続
				 */
				Connection connection = DriverManager.
						getConnection("jdbc:mysql://localhost/java_experience?serverTimezone=JST","root","#Infinity22");
				/*
				 * STEP2 : SQL送信処理
				 */

				// ①-１　送信すべきSQL文の雛形を準備
				PreparedStatement pStatement = connection.prepareStatement
						("DELETE FROM MONSTERS WHERE HP <= ? OR NAME = ?");
				){
			// ①-２　雛形に値を流し込みSQL文を組み立て送信する
			pStatement.setInt(1, 10);          // 1番目の？に10を流しこむ
			pStatement.setString(2, "ゾンビ"); // 2番目の？にゾンビを流し込む
			int r = pStatement.executeUpdate();
			// ①-３　処理結果を判定する
			if (r != 0) {
				System.out.println(r + "件のモンスターを削除しました");
			} else {
				System.out.println("該当するモンスターはいませんでした");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
