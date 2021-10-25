package week8;

import java.util.Scanner;

public class test3{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int member = 0; // 인원수 저장
		int[] scores = null; // 점수 저장
		
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("--------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("--------------------------------------------------------");
			System.out.print("선택>");
			// 오류 방지 개행문자(enter)를 제거 안해 nextLine을 parseInt 시켜줌
			int selectNum = Integer.parseInt(scanner.nextLine());
			
			// 학생수를 정하는 selectNum 1번
			if(selectNum == 1) {
				System.out.print("학생수>");
				member = Integer.parseInt(scanner.nextLine());
				// member int값을 배열에 담아 점수 입력 형태로 만듦
				scores = new int[member];
				System.out.println("현재 학생수는 " + member + "입니다");
			}
			
			// 학생별 점수를 입력하는 selectNum 2번
			if(selectNum == 2) {
				for(int i=0; i<scores.length; i++) {
					// 0부터 시작하여 i+1로 하여 1번째 학생으로 뜨게 만듦
					System.out.println( i+1 +"번째학생 점수");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			}
			
			// 학생별 점수를 확인하는 selectNum 3번
			if(selectNum == 3) {
				for(int i=0; i<scores.length; i++) {
					// 0부터 시작하여 i+1로 하여 1번째 학생으로 뜨게 만듦
					System.out.println(i+1 + "번 학생 점수:" + scores[i]);
				}
			}
			
			// 점수의 제일 높은값과 평균값을 알려주는 selectNum 4번
			if(selectNum == 4) {
				int max = 0; // 최대값 변수
				int sum = 0; // 총합 변수
				double avg = 0; // 평균 변수
				for(int i=0; i<scores.length; i++) {
					// 삼항연산자로 점수별로 최대값보다 작은 scores는 걸러내는 작업
					max = (max > scores[i]) ? max : scores[i];
					// 점수를합산 sum에 담기
					sum += scores[i];
					// sum에서 멤버를 나눠 평균값 정하기
					avg = (double) sum / member;
				}
				System.out.println("최고점수: " + max);
				System.out.println("평균점수:"+ avg);
			}
			// 프로그램을 종료시키는 selectNum 5번
			if(selectNum == 5) {
				// break문으로 종료시키기
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
	}

}
