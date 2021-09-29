/*  배열에 데이터를 추가 삽입하는 프로그램 완성 -- 배열에 요소 삽입   */ 

import java.util.Scanner;

/*  데이터 저장 프로그램 
 * 1. 배열을 이용 --> 1차원 배열 
 * 2. 저장 데이터 입력 --> 키보드 입력 
 * 3. 입력 받아서 저장된 결과값을 출력 
 * 4. 새로운 값을 추가 저장 (데이터 삽입) */ 

public class OOP {    /*  추가 데이터를 삽입하는 메서드 구현  */ 
	static void aryIns(int[] a, int idx, int x) {

	}
	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner stdIn = new Scanner(System.in);
		System.out.print("배열의 요소 수를 입력하세요:");
		int num = stdIn.nextInt(); 
		int[] a = new int[num]; /* 정수형 자료형을 가지는 배열을 하나 
		 만들어서 그 배열을 a 배열에 대입  */

		for(int i=0; i<num; i++) {
			System.out.print("a[" + i + "]: ");
			a[i] = stdIn.nextInt(); 
		}
		System.out.print("삽입할 배열 요소의 인덱스를 입력하세요");
		int idx = stdIn.nextInt(); 
		System.out.print("삽입할 데이터를 입력하세요");
		int n = stdIn.nextInt(); 

		aryIns(a, idx, n);  /* 배열 a에서 a[idx]에 n를 삽입  */ 
              /*  추가로 삽입 된 데이터 출력 구문 완성  */
		System.out.println("a["+idx+"] : " + n );
	}
}

