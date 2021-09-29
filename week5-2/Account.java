import java.util.*;
public class Account {
		Scanner sc = new Scanner(System.in);
		String accountNo = sc.next();
		String ownerName = sc.next();
		int balance = sc.nextInt();

		// 입금
		void deposit(int amount) { /* return 값이 없음을 표시: void*/
			balance = balance + amount; /*"예금한다" 기능을 구현하는 메서드 선언*/
		}
		// 출금
		int withdraw(int amount) {
			if(balance < amount) {
				return 0;
			}
			balance = balance - amount;
			return amount;
		}
}
