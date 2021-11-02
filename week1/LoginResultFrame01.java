import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginResultFrame01 extends JFrame{

	/* 필드 선언   */
	/*  생성자 선언  */ 
	public LoginResultFrame01(String msg) {
		setSize(400, 300); 
		setTitle("Login Result");  /*  윈도우 창에 제목 */ 
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		JLabel label = new JLabel("Welcome to Login", SwingConstants.CENTER); 
		label.setFont(new Font("SansSerif", Font.BOLD, 26));
		
		label.setForeground(Color.blue);
		
		JLabel msgLabel = new JLabel(msg);
		
		Container container = getContentPane(); 
		
		container.setLayout(new FlowLayout()); 
		
		container.add(label);
		
		container.add(msgLabel); 
	}
	/* 메서드 선언 */ 
}

