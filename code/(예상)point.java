package week8;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		ArrayList<Member> list = new ArrayList<Member>();
		Scanner sc = new Scanner(System.in);
		System.out.println("** 포인트 관리 프로그램입니다 **");
		while(true) {
			try {
				System.out.print("이름과 포인트 입력 >> ");
		        String name = sc.next();
		        if(name.equals("그만하기")) {
		        	System.out.println("프로그램 종료");
		       	 	break;
		        }
		        int point = sc.nextInt();
		        list.add(new Member(name,point));
		        for(int i = 0; i < list.size(); i++) {
		        	if(name.equals(list.get(i).getName())) {
		        		point =+ list.get(i).getPoint();
		        		System.out.println("(" + list.get(i).getName() + "," + point + ")");
		        	} else {
		        	System.out.println("(" + list.get(i).getName() + "," + list.get(i).getPoint() + ")");
		        	}
		        }
			} catch	(InputMismatchException e) {
	               System.out.println("이름을 먼저 입력해주세요.");
			}
		}	
	}
}

class Member {
	private String name;
	private int point;
	
	public Member() {}
	
	public Member(String name, int point) {
		this.name = name;
		this.point = point;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPoint() {
		return point;
	}
}
