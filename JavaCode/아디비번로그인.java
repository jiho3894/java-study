package testjava03;

import java.util.Scanner;

public class LoginEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("아이디: ");
		String name = scanner.nextLine();
		
		System.out.println("비밀번호: ");
		String strPassword = scanner.nextLine();
		
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("kimjiho")) {
			if(password == 41730015) {
				System.out.println("로그인 성공");
			} else {
				System.out.println("로그인 실패: 패스워드가 틀림");
			}
		} else {
			System.out.println("로그인 실패: 아이디가 존재하지 않음");
		}
		
	}

}
