package java_experience;

public class Cf1_2 {

		// 末尾が\かどうかをmachesメソッドで判断
		// ifで場合分けし、末尾が\でなければつけて、returnでfolder+fileを返すメソッドを作成

		String concatPath(String folder, String file) {
			if(!(folder.matches("\\$"))) folder += "\\";
			return folder + file;
		}

}
