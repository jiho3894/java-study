package threadEx01;

public class TaskEx implements Runnable {

   @Override
   public void run() {
      // TODO Auto-generated method stub
      int sum = 0;
      for(int index = 0; index<10; index++) {
         sum+= index;
         System.out.println(sum);
      }
      System.out.println(Thread.currentThread()+"ÃÖÁ¾ ÇÕ: " + sum);
   }
   
}