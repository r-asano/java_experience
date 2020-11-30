package java_experience;

// 第7章練習課題

import java.io.FileReader;
import java.io.Reader;
import java.util.Properties;

public class Cf7_6 {
	public static void main(String[] args) throws Exception {

		// ファイル名をフルパスで書かないとなぜかエラーに
		// Cの後の"://"と\を区別して使用すること
		try (Reader fReader = new FileReader("C:\\Eclips4.6/pleiades/workspace/java_experience/pref.properties")) {
			Properties p = new Properties();
			p.load(fReader);
			String capital = p.getProperty("aichi.capital");
			String food = p.getProperty("aichi.food");
			System.out.println(capital + ":" + food);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}