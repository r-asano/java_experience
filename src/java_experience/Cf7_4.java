package java_experience;

// XML形式のデータを読み込む

import java.io.FileInputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class Cf7_4 {
	public static void main(String[] args) throws Exception {
		InputStream iStream = new FileInputStream("C:\\rpgsave.xml");
		Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse(iStream);
		Element hero = document.getDocumentElement();
		Element weapon = findChildByTag(hero, "weapon");
		Element power = findChildByTag(weapon, "power");
		String value = power.getTextContent();
	}
	// 指定された名前を持つタグの最初の子タグを返す
	private static Element findChildByTag(Element self, String name) {
		// すべての子を取得
		NodeList children = self.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			if(children.item(i) instanceof Element) {
				Element element = (Element) children.item(i);
				// タグ名を照会
				if(element.getTagName().equals(name)) {
					// selfが持つ要素の中で、タグ名がnameである要素をシーケンシャルに探す
					return element;
				}
			}
		}
		return null;
	}
}
