package classTest06;

public class CalculatorRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculator myCal = new Calculator();
		myCal.powerOn();
		int result1 = myCal.plus(1, 2);
		System.out.println("더하기" + result1);
		double result4 = myCal.min(6, 4);
		System.out.println("빼기" + result4);
		double result3 = myCal.mul(6, 4);
		System.out.println("곱하기" + result3);
		double result2 = myCal.div(5, 3);
		System.out.println("나누기" + result2);
		double result5 = myCal.sel(5, 3);
		System.out.println("나머지" + result5);
		myCal.powerOff();	
	}
}
