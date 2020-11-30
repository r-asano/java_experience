package java_experience;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// mainクラスのSerializableをしていなくてエラー
// new Cf7=7()をしているため必要になっている
public class Cf7_7 implements Serializable{
	public static void main(String[] args) throws Exception {
		// インスタンスの直列化と保存
		Employee employee = new Cf7_7().new Employee();
		employee.setName("淺野紫乃");
		employee.setAge(1);
		Department department = new Cf7_7().new Department();
		department.setName("総務部");
		department.setLeader(employee);

		FileOutputStream fStream
			= new FileOutputStream("C:\\Eclips4.6/pleiades/workspace/java_experience/company.dat");
		ObjectOutputStream oStream = new ObjectOutputStream(fStream);
		oStream.writeObject(department);
		oStream.flush();
		oStream.close();

		// ファイルからインスタンスを復元
		FileInputStream iStream = new FileInputStream("C:\\Eclips4.6/pleiades/workspace/java_experience/company.dat");
		ObjectInputStream oStream2 = new ObjectInputStream(iStream);
		// バイト列→インスタンス
		Department department2 = (Department) oStream2.readObject();
		System.out.println("部署名：" + department2.getName());
		System.out.println(("リーダー：" + department2.getLeader().getName()));
		System.out.println("年齢：" + department2.getLeader().getAge() + "才");
		oStream2.close();
	}

	class Employee implements Serializable {
		String name;
		int age;

		public void setName(String name) {
			this.name = name;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
	}

	class Department implements Serializable {
		String name;
		Employee leader;

		public void setName(String name) {
			this.name = name;
		}
		public void setLeader(Employee leader) {
			this.leader = leader;
		}
		public String getName() {
			return name;
		}
		public Employee getLeader() {
			return leader;
		}
	}
}
