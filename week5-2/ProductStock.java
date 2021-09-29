import java.util.Scanner;

public class ProductStock {

		Scanner sc = new Scanner(System.in);	
		String productCode = sc.nextLine();
		int stockNum = sc.nextInt();
		
		// 재고수량 증가 시키는 코드
		void addStock(int amount) {
			stockNum += amount;
		}
		
		// 재고수량 감소 시키는 코드
		int substractStock(int amount) {
			// 감소량이 현재 수량보다 적으면 0으로 return
			if(stockNum < amount) {
				return 0;
			}
			stockNum -= amount;
			return amount;
		}
	}

