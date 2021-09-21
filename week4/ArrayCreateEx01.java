package testJava04;

public class ArrayCreateEx01 {

	public static void main(String[] args) {
		// int[]  score는 score안에 int형 배열을 담기 위한 변수 선언
		// int score[5]는 int형으로 만들어진 score 배열에서
		// index가 5인 위치를 찾아주는 역할
		int[] score = {1,2,3,4,5,6};
		int sum = 0;
		for(int i=0; i<5; i++) {
			sum += score[i];
		}
		System.out.println(sum);
		System.out.println(score[5]);
	}
		
}
