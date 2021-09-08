package testhava02;

public class IncreaseDecreaseOpEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 10;
		int z;
		
		System.out.println("----------------------");
		x++; // 1증가
		++x; // 1증가
		System.out.println("x: " + x );           // x = 12 
		
		System.out.println("----------------------");
		y--; // 1감소
		--y; // 1감소
		System.out.println("y: " + y );           // y = 8
		
		System.out.println("----------------------");
		z=x++;  // 연산 수행 전 z = 12
		System.out.println("z:" + z);      // z = 12
		System.out.println("x:" + x);      // x의 값은 증가 x = 13
		
		System.out.println("----------------------");
		z=++x; // 연산 수행 후 z = 14
		System.out.println("z:" + z);  // z = 14
		System.out.println("x:" + x);   // x의 값은 증가 x = 14
		
		System.out.println("----------------------");
		z= ++x + y++;
		// x는 수행 후 증가 x = 15 , y는 수행 전 증가 y = 8
		// z = 23
		System.out.println("z:" + z);   // z = 23
		System.out.println("x:" + x);  // 이미 증가 x =15
		System.out.println("y:" + x);  // 이제 증가 y = 9
	}

}
