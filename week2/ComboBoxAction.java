package combo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

/* 콤보박스를 생성하고 이벤트 처리 하는 프로그램  */ 

public class ComboBoxAction extends JFrame {
	/* 필드 선언   */
	String[] ff = {"ap01", "ba01", "ma01"  };
	/*  콤보박스 항목  */
	ImageIcon[] images = { new ImageIcon("image/ap01.JPG"), 
			new ImageIcon("image/ba01.JPG"), 
			new ImageIcon("image/ma01.JPG")};  /* 이미지 아이콘 배열처리 */ 
	/* JLabel --> 이미지를 출력할 레이블   */
	JLabel imgLabel = new JLabel(images[0]); 

	/*  생성자 */ 
   ComboBoxAction(){
	  setTitle("콤보박스 메뉴 ");
	  Container  c = getContentPane(); 
	  c.setLayout(new FlowLayout());
	  /* 콤보 박스를 생성  */ 
	  JComboBox combo = new JComboBox(ff); 
	  c.add(combo); 
	  c.add(imgLabel); 
	  /*  콤보박스에서 ActionListener 등록 --> 선택된 이미지 출력 처리  */
	  combo.addActionListener(new ActionListener() {
		  /*  implement method --> override  */ 
		@Override

		public void actionPerformed(ActionEvent e) {
			/* 액션 이벤트가 발생  */ 
			JComboBox cb = (JComboBox) e.getSource(); 
			/* 액션 이벤트가 발생한 콤보박스를 알아내기 위하여  */
			int index = cb.getSelectedIndex(); 
			/* 인덱스에 이미지를 이미지 레이블에 출력 */
			imgLabel.setIcon(images[index]);
		}
	  });
	  setSize(300, 400); 
	  setVisible(true); 
   	}
	/* 메서드  */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ComboBoxAction(); 
	}
}