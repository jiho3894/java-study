package ch01data;



public class Button {

	/*  클래스 = 필드와 메서드  */
	/*  필드 선언 */ 
	OnClickListener listener;  /* 버튼 클래스내부에 있는 
	모든 프로그램에 사용되는 전역변수 처럼 사용   */ 

	void setOnClickListener(OnClickListener listener) {
		this.listener = listener; 
	}
		/* 메서드 선언 */ 

	void touch() {
		listener.onClick(); 
	}

	interface OnClickListener{
		void onClick(); 
	 }
}