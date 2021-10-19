package classTest06;

public class MethodOverloadRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pysical obj;
		obj = new Pysical("방탄찌",29,178.2f,75.2f,"bts@nate.com");
		printPysical(obj);
	}
	
	static void printPysical(Pysical obj ){
		System.out.println("이름=" + obj.name);
		System.out.println("나이=" + obj.age);
		System.out.println("신장=" + obj.height);
		System.out.println("제충=" + obj.weight);
		System.out.println("이메일=" + obj.email);
	}

}
