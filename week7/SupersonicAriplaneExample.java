package week7;

public class SupersonicAriplaneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SupersonicAriplane sa = new SupersonicAriplane();
		sa.takeOff();
		sa.fly();
		sa.flyMode = SupersonicAriplane.SUPERSONIC;
		sa.fly();
		sa.flyMode = SupersonicAriplane.NORMAL;
		sa.fly();
		sa.land();
	}

}
