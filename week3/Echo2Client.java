package networking;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

/* client - side  프로그램 작성 */ 
public class Echo2Client {
	public static void main(String[] args)  throws IOException  {
		// TODO Auto-generated method stub
		Socket client = null;  
		/*  서버가 소켓을 발생하면 클라이언트도 같이 소켓이 발생 */
		PrintWriter out = null; 
		try {
			client = new Socket(); 
			System.out.println("Echo Server와 연결 시도-----");
			client.connect(new InetSocketAddress("localhost", 5000),  3000);
			System.out.println("Echo Server 연결 성공-----");
		} catch(Exception e) {

		}
		out = new PrintWriter(client.getOutputStream(), true); 
		Scanner in = new Scanner(System.in); 
		String msg; 
		System.out.println("보낼 메시지가 있나요?");
		while((msg = in.nextLine()) !=null) {
			if(msg.equals("잘있어요."))	break;
			out.println(msg);
			System.out.println("보낼 메시지가 더 있나요?");
		}
		System.out.println("클라이언트 종료");
		out.close();
		in.close();
		client.close();
	}
}