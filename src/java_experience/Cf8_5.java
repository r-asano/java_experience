package java_experience;

import java.io.OutputStream;
import java.net.Socket;

public class Cf8_5 {
	public static void main(String[] args) {
		try (
				// ポート番号60025を指定したソケット
				Socket socket = new Socket("smtp.example.com", 60025);
		) {
			// 出力ストリームを取得
			OutputStream oStream = socket.getOutputStream();

			// メールデータの出力
			oStream.write("HELO example.com\r\n".getBytes());
			oStream.write("MAIL FROM: asaka@example.com\r\n".getBytes());
			oStream.write("RECT FROM: minato@example.com\r\n".getBytes());
			oStream.write("DATA\r\n".getBytes());

			// 保存
			oStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
