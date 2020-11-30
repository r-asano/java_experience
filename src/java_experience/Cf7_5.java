package java_experience;

//直列化（シリアライズ）したインスタンスを保存・復元する

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cf7_5 implements Serializable{
	public static void main(String[] args) throws Exception {
		// この書き方でないとエラー
		// Heroクラスをstaticにすると、エラーはでなくなるがシリアライズの対象外となってしまう
		Hero hero1 = new Cf7_5().new Hero("Shino", 100, 50);
		// ①インスタンスの直列化と保存
		FileOutputStream fStream = new FileOutputStream("C:\\rpgsave.dat");
		ObjectOutputStream oStream = new ObjectOutputStream(fStream);
		// インスタンス→バイト列
		// Mappingなどせずに丸ごとバイト列に変換することができる
		oStream.writeObject(hero1);
		oStream.flush();
		oStream.close();

		// ②ファイルからインスタンスを復元
		FileInputStream iStream = new FileInputStream("C:\\rpgsave.dat");
		ObjectInputStream oStream2 = new ObjectInputStream(iStream);
		// バイト列→インスタンス
		Hero hero2 = (Hero) oStream2.readObject();
		oStream2.close();
	}

	class Hero implements Serializable{
		// 別のPG改良時に、直列化したインスタンスにも変更が加わる場合に
		// 矛盾した状態で復元されるのを防ぐためにserialVersionUIDを設定する
		// 更新後、serialVersionUIDを変更する
		private static final long serialVersionUID = 1L;

		String name;
		int hp;
		int mp;

		Hero(String name,int hp,int mp) {
			this.name = name;
			this.hp = hp;
			this.mp = mp;
		}
	}
}
