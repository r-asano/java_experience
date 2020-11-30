package java_experience;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

// 練習問題6-1,2

public class Cf6 {
	public static void main(String[] args) throws IOException {
		try (
				FileInputStream is = new FileInputStream("indate.dat");
				BufferedOutputStream bo = new BufferedOutputStream(new
						FileOutputStream("outdata.dat"));
				GZIPOutputStream zs = new GZIPOutputStream(bo);
		) {
			int i;
			while((i = is.read()) != -1) {
				zs.write(i);
			}
			zs.flush();

			// BufferReaderを使ってreadline()メソッドを使用する方法もある
			// 戻り値はString型、ストリームの終わりはnull
//			FileReader fr = new FileReader("");
//			BufferedReader br = new BufferedReader(fr);
//			String line = null;
//			while ((line = br.readLine()) != null) {
//				.....
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
