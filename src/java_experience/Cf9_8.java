package java_experience;
// 練習問題

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO(ItemDAO)
public class Cf9_8 {
	public static ArrayList<Cf9_6> findByMinimumPrice(int i) {
		String DATABASE_NAME = "java_experience";
		String PROPATIES = "?characterEncoding=UTF-8&serverTimezone=JST";
		String URL = "jdbc:mySQL://localhost/" + DATABASE_NAME+PROPATIES;

		//DB接続用・ユーザ定数
		String USER = "asano";
		String PASS = "#Infinity22";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}

		Connection connection = null;
		try {
			/*
			 * データベースの接続
			 */
			connection = DriverManager.
					getConnection(URL,USER,PASS);

			/*
			 * SQL送信処理
			 */
			// 送信すべきSQL文の雛形を準備
			PreparedStatement pStatement = connection.prepareStatement
					("SELECT * FROM items WHERE PRICE >= ?");

			// 雛形に値を流し込みSQL文を組み立て送信する
			pStatement.setInt(1, i);          // 1番目の？に引数iを流しこむ
			ResultSet resultset = pStatement.executeQuery();

			ArrayList<Cf9_6> items = new ArrayList<Cf9_6>();
			while (resultset.next()) {
				Cf9_6 item = new Cf9_6();
				item.setName(resultset.getString("NAME"));
				item.setPrice(resultset.getInt("PRICE"));
				item.setWeight(resultset.getInt("WEIGHT"));
				items.add(item);
			}

			resultset.close();
			pStatement.close();
			return items;

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		} finally {
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
