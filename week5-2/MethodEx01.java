
public class MethodEx01 {

	public static void main(String[] args) {
		System.out.println("계좌번호, 예금주 이름, 잔액 입력");
		Account obj;
		obj = new Account();
		System.out.println("계좌번호" + obj.accountNo);
		System.out.println("예금주 이름" + obj.ownerName);
		System.out.println("잔액" + obj.balance);
		System.out.println();
	}
}
