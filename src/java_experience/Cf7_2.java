package java_experience;

// プロパティのリードメソッド

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

public class Cf7_2 {
	public static void main(String[] args) throws IOException {
		Reader fr = new FileReader("C:\\rpgdata.properties");
		Properties p = new Properties();
		p.load(fr);
		String name = p.getProperty("heroName");
		String strHp = p.getProperty("hero.hp");
		int hp = Integer.parseInt(strHp); // すべて文字列データとして格納されている
		System.out.println("勇者の名前：" + name);
		System.out.println("勇者のHP：" + hp);
		fr.close();
	}
}
