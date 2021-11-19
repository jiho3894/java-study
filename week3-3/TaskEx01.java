package threadEx01;

public class TaskEx01 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Runnable task = new Runnable() {
         public void run() {
            int sum = 0;
            for(int index = 0; index<10; index++) {
               sum += index;
               System.out.println(sum);
            }
            System.out.println(Thread.currentThread()+"ÃÖÁ¾ÇÕ : "+sum);
         }
      };
      Thread subTread1 = new Thread(task);
      Thread subTread2 = new Thread(task);
      subTread1.start();
      subTread2.start();
   }

}
