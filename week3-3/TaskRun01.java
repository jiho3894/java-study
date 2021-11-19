package threadEx01;

public class TaskRun01 {

   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Runnable task = new TaskEx();
      Thread subTread1 = new Thread(task);
      Thread subTread2 = new Thread(task);
      subTread1.start();
      subTread2.start();
   }

}
