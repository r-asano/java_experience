package java_experience;

// プロパティのセットメソッド

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;

public class Cf7_3 {
	public static void main(String[] args) throws IOException {
	Writer writer = new FileWriter("C:\\rpgsave.properties");
	Properties properties = new Properties();
	properties.setProperty("heroName", "Shino");
	properties.setProperty("heroHp", "100");
	properties.setProperty("heroMp", "50");
	// store()を呼び出すことで初めて保存される
	properties.store(writer, "勇者の情報"); // ファイルの先頭にコメントとして出力される
	writer.close();
	}
}
