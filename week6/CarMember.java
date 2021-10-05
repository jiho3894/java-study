package week6;

public class CarMember {
	/* 필드 선언 */
	String model;
	int speed;
	
	/* 생성자 선언 */
	CarMember(String model){
		this.model = model;
	}
	/* 메서드 선언 */
	void setSpeed(int speed) {
		this.speed = speed;
	}
	
	void run() {
		for(int i=10; i<=50; i+=10) {
			this.setSpeed(i);
			System.out.println(this.model + "가 달립니다.(시속:" + this.speed + "km/h)");
		}
	}
}
