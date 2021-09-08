package testjava01;

import java.util.Scanner;

public class Submit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x, y ,sum;
		Scanner scanner = new Scanner(System.in);
		x = scanner.nextInt();
		y = scanner.nextInt();
		
		sum = x + y;
		System.out.println("첫번째 값: " + x);
		System.out.println("두번째 값: " + y);
		System.out.println("합계:" + sum);
		scanner.close();
	}

}