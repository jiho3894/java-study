package testJava04;

import java.util.Scanner;

public class ArrayCreateEx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] scores;
		// new 연산자를 이용한 새로운 int형 배열 저장 공간 확보
		scores = new int[3];
		Scanner scanner = new Scanner(System.in);
		int num;
		double avg;
		
		System.out.println("숫자 3개를 입력하세요");
		int sum1 = 0;
		for(int i=0; i<scores.length; i++) {
			// int형으로 scanner 한것은 num으로 저장
			num = scanner.nextInt();
			// for문으로 scores 배열 length까지 입력된 배열을 정렬
			scores[i] = num;
			// 정렬한 숫자들을 더하여 sum1에 저장
			sum1 += scores[i];
		}
		// scores length를 나눈값을 avg 평균값으로 저장
		avg = sum1 / scores.length;
		System.out.println("종합:" + sum1);
		System.out.println("평균:" + avg );
		
		
		
		int sum2 = add(new int[] {83,90,87});
		System.out.println("종합:" + sum2);
		System.out.println();
	}

		public static int add(int[] scores) {
			int sum = 0;
			for(int i=0; i<3; i++) {
				sum += scores[i];
			}
			return sum;
		}
}
