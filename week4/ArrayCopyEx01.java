package testJava04;

public class ArrayCopyEx01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] oldIntArray = {1,2,3};
		int[] newIntArray = new int[5];
		
//		for(int i=0; i<oldIntArray.length; i++) {
//			newIntArray[i] = oldIntArray[i];
//		}
		
		//arraycopy 함수 oldIntArray 0 번째부터 length까지 복사하여
		// newIntArray 0번째를 시작으로 복사해 붙여넣기
		System.arraycopy(oldIntArray, 0, newIntArray, 0, oldIntArray.length);
		
		for(int i=0; i<newIntArray.length; i++) {
			System.out.print(newIntArray[i] + ".");
		}
	}

}
