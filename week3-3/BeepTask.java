package threadEx01;

import java.awt.Toolkit;

public class BeepTask implements Runnable {
   
   public void run() {
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      for(int i =0; i<5; i++) {
         toolkit.beep();
         try {
            Thread.sleep(500); //0.5초 일시 정지
         }catch(Exception e) {
            
         }
      }
   }
}
