package threadEx01;

public class StopFlagExample {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      PrintThread printThread = new PrintThread();
      printThread.start();
      
      try {
         Thread.sleep(1000);
      }catch(InterruptedException e) {
         
      }
      printThread.setStop(true);
   }

}
