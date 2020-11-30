package java_experience;
// ServerSocketを使用したサーバ作成

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Cf8_3 {
	public static void main(String[] args) throws IOException {
		System.out.println("起動完了");
		// ポート39648で待ち受ける
		ServerSocket serverSocket = new ServerSocket(39648);

		// 呼び出すと誰かから接続されるまで待ち続ける
		Socket socket = serverSocket.accept();

		System.out.println(socket.getInetAddress() + "から接続");
		socket.getOutputStream().write("WELCOME".getBytes());
		socket.getOutputStream().flush();

		// データ送信してすぐ切断
		socket.close();
	}
}
