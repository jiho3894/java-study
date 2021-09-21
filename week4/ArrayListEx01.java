package testJava04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 배열과 ArrayList의 차이점
		// 배열은 크기가 고정되어 있지만 ArrayList는 크기가
		// 동적으로 할 수 있다 단 ArrayList는 type object의 관계없는 배열과 다르게
		// 오로지 object element만 담을 수 있음
		List<String> lst = new ArrayList<String>();  //String 형 ArrayList 생성
		lst.add("alpha"); //추가하기
		lst.add("beta");
		lst.add("smartIT");
		System.out.println(lst);
	
		Iterator<String> iter = lst.iterator();  //String 형 Iterator 생성
		while(iter.hasNext()) {
			String str = iter.next();  // next로 다음 element로 포인터를 이동하여 조회
			System.out.println(str);
		}
		
		for(String str : lst) {  // 향샹된 for문
			System.out.println(str);
		}
	}
}
