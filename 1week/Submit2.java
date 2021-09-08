package testjava01;

import java.util.Scanner;

public class Submit2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name, num, tel;
		Scanner scanner = new Scanner(System.in);
		name = scanner.next();
		num = scanner.next();
		tel = scanner.next();
		
		System.out.println("[필수 정보 입력]");
		System.out.println("이름: " + name);
		System.out.println("주민번호 6자리 :" + num);
		System.out.println("전화번호 :" + tel);
		
		scanner.close();
		
	}

}