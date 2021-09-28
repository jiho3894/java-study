package ch01data;
/*  앞에서 버튼 클래스(class Button) 만들고  */ 
public class Window {
	/*  필드 선언  */
	Button button1 = new Button();
	Button button2 = new Button();
	Button button3 = new Button();
	 
	/* 메서드 선언   */
	Button.OnClickListener listener = new Button.OnClickListener() {
		@Override public void onClick() {
			// TODO Auto-generated method stub
			System.out.println("전화를 콜합니다.");
		}
	};
	
	Button.OnClickListener finish = new Button.OnClickListener() {
		@Override public void onClick() {
			// TODO Auto-generated method stub
			System.out.println("전화를 끊습니다.");
		}
	};
	
	Window(){
		button1.setOnClickListener(listener);
		button2.setOnClickListener(new Button.OnClickListener() {
		@Override public void onClick() {
				// TODO Auto-generated method stub
				System.out.println("message를 보냅니다.");
			}
		});
		button3.setOnClickListener(finish);
	}
}