package classTest06;

public class Calculator {
	void powerOn() {
		System.out.println("전원을 켜요");
	}
	
	//더하기
	int plus (int x, int y) {
		int result = x + y;
		return result;
	}
	
	//빼기
	int min (int x, int y) {
		int result = x - y;
		return result;
	}
	
	//곱하기
	double mul (int x, int y) {
		double result = (double)x * (double)y;
		return result;
	}
	
	//나누기
	
	//Math 함수를 이용해서 double형 100.00을 나누어 소수점 2자리까지 출력
	double div (int x, int y) {
			double result = (double)x / (double)y;
			return Math.round(result * 100) / 100.00;
		}
	
	//나머지
	double sel (int x, int y) {
		double result = (double)x % (double)y;
		return result;
	}
	
	
	void powerOff() {
		System.out.println("전원을 꺼요");
	}


}
