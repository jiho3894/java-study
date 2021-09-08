package testhava02;

import java.util.Scanner;

public class Submit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("점수를 입력하시오:");
		Scanner input = new Scanner(System.in); // new Scanner
		// while문을 이용한 무한 점수 확인
		while(true) {
			int score = input.nextInt(); 
			// 삼한 연산자를 이용한 점수별 등급 
			char grade = (score >= 90) ? 'A' : 
				((score >= 80) ? 'B' : 
					((score >= 70) ? 'C' : 
						((score >= 60) ? 'D' : 
							'F')));
			// loop를 끊기위한 특정 int 값 입력시 break 발동
			if(score == 0) {
				System.out.println("종료");
				break;
			} 
			System.out.println(score + "점은" + grade + "등급입니다."); 
			System.out.println("점수를 입력하시오:");
		}
	} 
}
