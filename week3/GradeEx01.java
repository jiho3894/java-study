package testjava03;

import java.util.Scanner;

public class GradeEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("학점을 문자로 입력하시오: ");
			
			char grade = input.next().charAt(0);
			double gPoints = 0;
			
			switch(grade) {
					case 'A': case 'a':
						gPoints = 4.0;
						break;
					case 'B': case 'b':
						gPoints = 3.0;
						break;
					case 'C': case 'c':
						gPoints = 2.0;
						break;
					case 'D': case 'd':
						gPoints = 1.0;
						break;
					case 'F': case 'f':
						gPoints = 0.0;
						break;
					default:
						System.out.println("잘못된 학점입니다.");
			}
			System.out.println("평점 = " + gPoints);
			System.out.println("프로그램 계속(y) 종료(q)");
			Scanner inputStop = new Scanner(System.in);
			char stop = inputStop.next().charAt(0);
			if(stop == 'q') {
				System.out.println("종료");
				break;
			}
		}
	}

}
