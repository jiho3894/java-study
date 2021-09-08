package testhava02;

import java.util.Scanner;

public class ConditionOperationEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int score = scanner.nextInt();
		if(score > 90) {
			System.out.println(score + "점은" + "A등급입니다.");
		} else if(score > 80) {
			System.out.println(score + "점은" + "B등급입니다.");
		} else {
			System.out.println(score + "점은" + "C등급입니다.");
		}
	}
}