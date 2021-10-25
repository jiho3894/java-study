package testhava02;
import java.util.Scanner;

public class Submit {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in); // new Scanner
      System.out.println("점수를 입력하세요:");
      // while문을 이용한 무한 점수 확인
      while(true) {
         String finish = input.nextLine();
         if(finish.equals("q")) {
            System.out.println("종료");
            break;
      } 
      // string to int parse
      int score = Integer.parseInt(finish);
      // 삼항연산자로 점수별 등급 표기
      char grade = (score >= 90) ? 'A' : 
         ((score >= 80) ? 'B' : 
            ((score >= 70) ? 'C' : 
               ((score >= 60) ? 'D' : 
                  'F')));
      System.out.println(score + "점은" + grade + "등급입니다."); 
      System.out.println("종료는 q를 입력해주세요");
      System.out.println("점수 입력 : "); 
      } 
   }
}