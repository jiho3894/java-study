package ch01data;

import java.util.Scanner;

/* 성적관리 프로그램 
 *  -학급수, 각 학급의 학생 
 *  -모든 학생의 성적을 읽어서 합계와 평균 계산   */
/*  1. 학급수, 각 학급의 학생 수 (배열-> 2차원), 성적  --> 키보드 입력 
 *  2. 합계 계산 
 *  3. 평균 계산 
 *  4. 합계, 평균 출력  
 *  추가: 합계와 평균은 학급 단위와 전교생을 대상으로 각각 계산 
 *  
 *  */ 

public class ScoreEx01 {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);  /* 생성자  */

		System.out.println("학급 수를 입력하세요:");

		int classNum = stdIn.nextInt(); 
		int[][] point = new int[classNum][]; 
		int totNumber = 0;  /* 모든 학급의 총 학생 수   */  

		for(int i=0; i < classNum; i++) {
			System.out.printf("\n %d반의 학생수를 입력하세요:", i+1);
			int num = stdIn.nextInt(); /*  학생수 입력 처리  */
			point[i] = new int[num]; 
			totNumber = totNumber + num; 
			for(int j=0; j < num; j++){
				System.out.printf("%d반 %d 번의 점수: ",  i+1, j+1);
				point[i][j] = stdIn.nextInt(); 
			}
		}

		System.out.println("  반       |   합계           |   평균");
		System.out.println("------ | ---------- | --------");

		int total = 0; 
		for(int i=0; i < classNum; i++) {
			int sum=0; 
			for(int j=0; j < point.length; j++) {
				sum = sum + point[i][j];  
			}
			total = total + sum; 
			System.out.printf("%2d반|%7d    |%7.1f\n", i+1, sum, (double)sum/point[i].length);
		}

		System.out.println("------ | ---------- | --------");
		System.out.printf(" 합   | %7d|%7.1f\n", total, (double)total/totNumber);
	}
}

