package java_experience;

// ソケット（低水準アクセス）を利用したHTTPアクセス
// やっていることはCf8_1と同じ

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class Cf8_2 {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("dokojava.jp", 80);
		InputStream iStream = socket.getInputStream();
		OutputStream oStream = socket.getOutputStream();
		oStream.write("GET /index.html HTTP/1.0\r\n".getBytes());
		oStream.write("\r\n".getBytes());
		oStream.flush();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));

		String string;
		while ((string = bReader.readLine()) != null) {
			System.out.println(string);
		}
		socket.close();
	}
}
