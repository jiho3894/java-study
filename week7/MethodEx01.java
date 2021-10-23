package week7;

public class MethodEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Physical obj;
		obj = new Physical("방탄", 25, 177.2f, 70.5f);
		printPhysical(obj);
	}
	
	static void printPhysical(Physical obj) {
		System.out.println("이름:" + obj.name);
		System.out.println("나이:" + obj.age);
		System.out.println("키:" + obj.height);
		System.out.println("체중:" + obj.weight);
	}
	
}
