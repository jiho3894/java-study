package thread01;
/* 하나의 프로세스 안에서 한 개 이상의 스레드가 
 * 구현되면 데이터를 공유 할 수 있다.   */ 
class SharedData{
	/*  필드 선언  */ 
	private int data; 
	/*  메서드 선언  */ 
	public void put(int data) {
		this.data = data; 
	}
	
	public int get() {
		return data; 
	}
}

/*  Thread 1구현 --> 생산  */
class Producer implements Runnable{
	/* 필드 선언 */ 
	private SharedData shared;
	/* 생성자 선언 */ 
	public Producer(SharedData sd) {
		shared = sd; 
		}
		/* 메서드 */ 
		public void run() {
			for(int i=1; i<=5; i++) {
				try {
					Thread.sleep((int) (Math.random() * 1000));
				} catch(InterruptedException e) {
					e.printStackTrace();
				} 
				shared.put(i);
				System.out.println("항목:" + i +": 생산 완료입니다.");
			}
		}
}

/* Thread 2 --> 소비   */ 
class Consumer implements Runnable {
	/* 필드 선언 */ 
	private SharedData shared;
	/* 생성자 선언 */ 
	public Consumer(SharedData sd) {
		shared = sd; 
	}

	/*  메서드  */
	public void run() {
		int data; 
		do {
			try {
				Thread.sleep((int) (Math.random() * 1000));
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			data = shared.get(); 
			System.out.println("항목" + data + ": 소비 완료되었습니다.");
		}while(data<5); 
	}
}

public class ProductionRun {
	/*  필드 선언  */ 
	/* 생성자 선언 */ 
	/* 메서드 --> Thread    */ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedData sd = new SharedData(); /*  공유 데이터 */ 
		Thread t1 = new Thread(new Producer(sd)); /*  스레드 1: 생산   */ 
		Thread t2 = new Thread(new Consumer(sd)); /*  스레드 2: 소비  */ 
		t1.start(); 
		t2.start(); 
	}
}