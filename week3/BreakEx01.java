package testjava03;

public class BreakEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		while(true) {
			int num = (int)(Math.random() * 6) + 1;
			System.out.println(num);
			/* break 문을 선언하지 않으면 Math함수가
			 * 종료문을 찾을때까지 계속 random int를 보여주기 때문에
			 * 끝나지 않음*/
		}
		
	}

}
