

import java.util.Scanner;

public class score {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      int member = 0;
      int[] scores = null;
      
      Scanner scanner = new Scanner(System.in);
      
      while(true) {
         System.out.println("--------------------------------------------------------");
         System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
         System.out.println("--------------------------------------------------------");
         System.out.print("선택>");
         int selectNum = Integer.parseInt(scanner.nextLine());
         
         if(selectNum == 1) {
            System.out.print("학생수>");
            member = Integer.parseInt(scanner.nextLine());
            scores = new int[member];
         }
         
         if(selectNum == 2) {
            for(int i=0; i<scores.length; i++) {
               System.out.println("scores[" + i + "] >" );
               scores[i] = Integer.parseInt(scanner.nextLine());
            }
         }
         
         if(selectNum == 3) {
            for(int i=0; i<scores.length; i++) {
               System.out.println("scores[" + i + "] >" + scores[i]);
            }
         }

         if(selectNum == 4) {
            int max = 0; 
            int sum = 0;
            double avg = 0;
            for(int i=0; i<scores.length; i++) {
               max = (max > scores[i]) ? max : scores[i];
               sum += scores[i];
               avg = (double) sum / member;
            }
            System.out.println("최고점수: " + max);
            System.out.println("평균점수:"+ avg);
         }
         
         if(selectNum == 5) {
            System.out.println("프로그램을 종료합니다");
            break;
         }
      }
   }

}