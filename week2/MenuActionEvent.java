package combo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/* 메뉴에 4개의 메뉴 아이템을 만들고 
 *  Load 메뉴 아이템을 선택하면 
 *  이미지 하나를 로딩하여 출력  */ 
public class MenuActionEvent extends JFrame {
	/* 필드 선언  */ 
	JLabel imgLabel = new JLabel();  /* 빈 이미지를 가지는 레이블   */
	/* 생성자  */ 
	MenuActionEvent(){
		setTitle("Menu 활용"); 
		createMenu(); 
		getContentPane().add(imgLabel, BorderLayout.CENTER); 
		setSize(400, 350); 
		setVisible(true); 
	}
	/* 메뉴바와 메뉴 생성   */ 
	void createMenu(){
	JMenuBar mb = new JMenuBar();
	/* 메뉴에 4개의 메뉴항목  */ 
	JMenuItem[] menuItem = new JMenuItem[4]; 
	String[] itemTitle = {"Load", "Hide", "Reshow", "Exit"   };
	JMenu screenMenu = new JMenu("Screen"); 
	 /* 이벤트 처리  */
	 MenuActionListener listener = new MenuActionListener(); 
	 
	 for(int i=0; i<menuItem.length; i++) {
		 menuItem[i] = new JMenuItem(itemTitle[i]); 
		 menuItem[i].addActionListener(listener);
		 screenMenu.add(menuItem[i]); 
	 }
	 mb.add(screenMenu); 
	 setJMenuBar(mb); 
	}
	/* 메뉴 아이템처리를 위한 이벤트(actionListener)  */ 
	class MenuActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd = e.getActionCommand(); 
			/* 선택한 메뉴항목의 문자열 리턴   */
			switch(cmd) {
			case "Load":
				if(imgLabel.getIcon() !=null ) return; 
				imgLabel.setIcon(new ImageIcon("image/ap01.JPG")); break;
			case "Hide":
				imgLabel.setVisible(false); break; 
			case "Reshow":
				imgLabel.setVisible(true); break; 
			case "Exit": 
				System.exit(0); break; 
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuActionEvent(); 
	}
}