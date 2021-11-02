import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MenuItemActionListener extends JFrame{

	/*  필드 선언 --> 전역변수 (!!!) */
	private   JTextArea ta = new JTextArea();  
	/*  생성자 선언 */
	public MenuItemActionListener() {
		super("파일저장"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		createMenu(); 
		Container c = getContentPane(); 
		c.add(new JScrollPane(ta)); 
		setSize(300, 300); 
		setVisible(true); 
	}

	/* 메서드  */ 
private void createMenu(){
	 JMenu fileMenu = new JMenu("파일"); 
	 JMenuItem save = new JMenuItem("저장"); 
	 fileMenu.add(save); 
	 save.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(ta.getText().length() == 0) {
				JOptionPane.showMessageDialog(MenuItemActionListener.this, "입력된 내용이 없습니다.", 
						"Warning", JOptionPane.WARNING_MESSAGE);
				return; 
			}
			String fileName = JOptionPane.showInputDialog(MenuItemActionListener.this, "저장할 파일 이름을 입력하세요."); 
			if(fileName == null) {
				JOptionPane.showMessageDialog(MenuItemActionListener.this, "파일을 저장하지 않습니다.", 
						"warning", JOptionPane.WARNING_MESSAGE);
			}
			try {
				FileWriter fout = new FileWriter(fileName); /* 파일 스트림 열기 */
				String t = ta.getText(); /* 입력된 텍스트를 문자열로 얻어내기 위해 */
				StringTokenizer st = new StringTokenizer(ta.getText(), "\n"); 
				/*  라인 분리 시 처리 */ 
				while(st.hasMoreTokens()) {
					fout.write(st.nextToken()); /* 한 라인 씩 쓰기  */
					fout.write("\r\n"); /* 라인 끝에서 다음 줄(라인)로 넘어가는 문자 삽입  */ 
				} fout.close();  /* 파일 스트림 닫기 */ 
			} catch(IOException e1) {
				
			}
		}
	 });

	   JMenuBar mb = new JMenuBar(); 
	   mb.add(fileMenu); 
	   setJMenuBar(mb); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuItemActionListener(); 
	}
}

