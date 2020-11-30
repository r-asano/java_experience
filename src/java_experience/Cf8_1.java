package java_experience;

// HTTPを取得するプログラム

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;

public class Cf8_1 {
	public static void main(String[] args) {
		try {
			// なぜかプロキシの名前解決ができないのでIPで指定している
			SocketAddress addr = new
				InetSocketAddress("172.18.6.18", 8080);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, addr);

			URL url = new URL("http://yahoo.co.jp");
			URLConnection conn = url.openConnection(proxy);
			BufferedReader bReader = new BufferedReader(
					new InputStreamReader(
							conn.getInputStream()));

			String s;
			while ((s = bReader.readLine()) != null) {
				System.out.println(s);
			}
			bReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
