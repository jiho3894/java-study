package ch01data;

import java.util.Scanner;

public class DepositEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("---------------------------------------");
			System.out.println("1.예금  |   2.출금  |  3.잔고  |  4.종료");
			System.out.println("---------------------------------------");
			/*nextLine()은 마지막 enter를 제거하지 않아 그 이후
			 * 입력처리가 문제가 발생할 수 있어 int 값 형태로 변환해주는것이
			 * 안전한 방법*/
			System.out.print("번호를 입력해주세요 >>> ");
			int inputData = Integer.parseInt(scanner.nextLine());
			
			if(inputData == 1) {
				System.out.println("선택 > " + inputData + "번");
				System.out.print("예금액을 입력해주세요 : ");
				balance += Integer.parseInt(scanner.nextLine());
				System.out.println("예금액: " + balance);
			}
			
			if(inputData == 2) {
				System.out.println("선택 > " + inputData + "번");
				System.out.print("출금액을 입력해주세요: ");
				balance -= Integer.parseInt(scanner.nextLine());
				System.out.println("출금 후  금액 : " + balance);
			}
			
			if(inputData == 3) {
				System.out.println("선택 > " + inputData + "번");
				System.out.println("잔고:" + balance);
			}
			
			if(inputData == 4) {
				break;
			}
		}
		System.out.println("프로그램 종료");
	}

}