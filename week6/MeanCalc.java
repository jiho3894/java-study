package week6;

import java.util.Scanner;

public class MeanCalc {
	private int sum;
	private int num;
	
	Scanner sc = new Scanner(System.in);
	
	public void setValue(int w, int x, int y , int z, int n) {
		w = sc.nextInt();
		x = sc.nextInt();
		y = sc.nextInt();
		z = sc.nextInt();
		n = sc.nextInt();
		sum = w + x + y + z + n;
		num = n;
	}
	
	public int getMean() {
		return sum/num;
	}
}
