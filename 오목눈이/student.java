package week8;

import java.util.Scanner;

public class test2 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner input = new Scanner(System.in);
      while(true) {
         System.out.println("학점을 문자로 입력하시오: ");
         
         char grade = input.next().charAt(0);
         double gPoints = 0;
         
         switch(grade) {	//학점별 점수 지정
         						// 대소문자 구분하기
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
                  System.out.println("학점을 다시 입력하시오.");				
         }
         System.out.println("평점 = " + gPoints);			
         System.out.println("프로그램 계속(Y 입력), 종료(Q 입력)");					
         Scanner inputStop = new Scanner(System.in);
         char stop = inputStop.next().charAt(0);
         if(stop == 'q' || stop == 'Q') {
             System.out.println("프로그램 종료입니다.");
             break;
          }
         if(stop != 'y' && stop != 'Y') {
        	 System.out.println("문구를 잘못입력하여 강제 종료합니다.");
        	 break;
         }
      }
   }
}
