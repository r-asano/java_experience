package java_experience;
// DBアクセスの超基本形

import java.sql.Connection;
import java.sql.DriverManager;

public class Cf9_1 {
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

				){
			/*
			 * STEP2 : SQL送信処理
			 */

			/* **********************************
			 *
			 * メインのDB操作処理
			 *
			************************************* */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
