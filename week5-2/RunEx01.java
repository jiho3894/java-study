

public class RunEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("상품코드와 재고수량을 입력해주세요");
		ProductStock obj;
		obj = new ProductStock();
		
		System.out.println("상품코드:" + obj.productCode);
		System.out.println("재고수량:" + obj.stockNum); 
		
	}

}
