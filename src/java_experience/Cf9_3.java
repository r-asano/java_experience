package java_experience;
// SQL送信パターン　①検索系


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cf9_3 {
	public static void main(String[] args) {
		try {
			/*
			 * MySQLに接続(新しいバージョンではcjを入れ込む必要がある)
			 */
			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * このようにtry文の外で宣言しないとtry文内で宣言した変数はcatch文で使うことが出来ない
		 * 同様にtry()も使えないので、finallyでクローズの宣言を行う
		 */
		Connection connection = null;
		try {
			/*
			 * STEP1 : データベースの接続
			 */
			connection = DriverManager.
					getConnection("jdbc:mysql://localhost/java_experience?serverTimezone=JST","root","#Infinity22");
			/*
			 * STEP2 : SQL送信処理
			 */

			// ②-１　送信すべきSQL文の雛形を準備
			PreparedStatement pStatement = connection.prepareStatement
					("SELECT FROM MONSTERS WHERE HP >= ?");

			// ②-２　雛形に値を流し込みSQL文を組み立て送信する
			pStatement.setInt(1, 10);          // 1番目の？に10を流しこむ
			ResultSet resultset = pStatement.executeQuery();

			// ②-３　結果表を処理する
			/* *************************************
			 *
			 * 結果表の処理（後述）
			 *
			**************************************** */
		} catch (Exception e) {
			e.printStackTrace();
		}  finally {
			/*
			 * STEP3 : DB接続の切断
			 */
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			}
		}
	}
}
