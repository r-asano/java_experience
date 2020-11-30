package java_experience;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

// 第8章練習問題


public class Cf8_4 {
	public static void main(String[] args) {
		try {
			// プロキシの指定
			InetSocketAddress serverSocket = new InetSocketAddress("172.18.6.18", 8080);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, serverSocket);

			// 対象URLにプロキシを適用
			URL url = new URL("https://jprs.co.jp/img2/main_txt.png");
			URLConnection connection = url.openConnection(proxy);

			// 入出力インスタンス
			InputStream iStream = connection.getInputStream();
			OutputStream oStream = new FileOutputStream("C:\\Eclips4.6/pleiades/workspace/java_experience/jprs.png");

			// 1バイトずつ読み込んでoStreamに出力
			int i;
			while ((i = iStream.read()) != -1) {
				oStream.write((byte) i);
			}

			iStream.close();
			oStream.flush();
			oStream.close();


			// 別解：whileループを回さずに一度に保存処理を行う
//			// 対象URLのファイルInputStreamを復号化した結果として、BufferedImageを返す
//			BufferedImage bi =ImageIO.read(connection.getInputStream());
//
//			// 保存先フォルダの指定と保存
//			File file =
//					new File("C:\\Eclips4.6/pleiades/workspace/java_experience/jprs.png");
//			FileOutputStream fStream 	= new FileOutputStream(file);
//			String format = "png";
//			ImageIO.write(bi, format, file);
//
//			fStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
