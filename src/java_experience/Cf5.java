package java_experience;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Cf5 {
	public static void main(String[] args) {
		Log logger = LogFactory.getLog(Cf5.class);
		if (args.length != 2) {
			logger.error("起動引数の数が異常：" + args.length);
		}
	}
}
