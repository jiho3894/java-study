import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class point {

   public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         HashMap<String, Integer> manage = new HashMap<String, Integer>();
         System.out.println("** 포인트 관리 프로그램입니다 **");
         while(true) {
            System.out.print("이름과 포인트 입력 >> ");
            String name = sc.next();
            if(name.equals("스톱"))
               break;

            try {
               int point = sc.nextInt();
            
            
            
            if(manage.get(name) == null) {
               manage.put(name, point);
            }
            
            else {
               manage.put(name,  manage.get(name)+point);
            }
            } catch(InputMismatchException e) {
               System.out.println("이름을 먼저 입력해주세요.");
            }
            Set<String> key = manage.keySet();
            Iterator<String> it = key.iterator();
            while(it.hasNext()) {
               String people = it.next();
               Integer sum = manage.get(people);
               System.out.print("("+people+","+sum+")");
            }
            System.out.println();
         }
        
         sc.close();
        
      }
   }