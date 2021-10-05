package week6;

public class SingletonExRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Singleton obj1 = new Singleton();
		Singleton obj2 = new Singleton();*/
		/* 싱글톤이라는 하나의 객체를 return 하기 때문에
		 * 변수 obj1, obj2은 동일한 객체를 참조합니다.*/
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		
		if(obj1==obj2) {
			System.out.println("같은 Singleton 객체 입니다.");
		} else {
			System.out.println("다른 Singleton 객체 입니다.");
		}
	}

}
