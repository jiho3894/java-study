package threadEx01;

import java.awt.Toolkit;

public class BeepPrintEx01 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Toolkit toolkit = Toolkit.getDefaultToolkit(); //Toolkit 객체받기
      for(int i=0; i<5; i++) {
         toolkit.beep();
         try {
            Thread.sleep(500); //0.5초 일시 정지
         }catch(Exception e) {
         }
      }
      for(int i=0; i<5; i++) {
         System.out.println("띵");
         try {
            Thread.sleep(500); //0.5초 일시 정지
         }catch(Exception e) {
         }
      }
   }

}