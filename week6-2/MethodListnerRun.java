package week8;

import java.awt.Container;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MethodListnerRun extends JFrame {

	JLabel la = new JLabel("SmartIT"); 

	MethodListnerRun(){
		setTitle("Mouse Event"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		Container c = getContentPane();
		c.addMouseListener(new MyMouseListener());
		c.setLayout(null);
		la.setSize(50, 20);
		la.locate(30, 30); 
		c.add(la); 
		setSize(400, 400); 
		setVisible(true); 
	}

	class MyMouseListener implements MouseListener {
		public void mousePressed(MouseEvent e){
			int x = e.getX(); 
			int y = e.getY();
			la.setLocation(x, y);
		}

		public void mouseClicked(MouseEvent e) { 
				if(e.getClickCount() == 2) {
				System.out.println("더블클릭했음");
			}
		}
		public void mouseEntered(MouseEvent e) {
			System.out.println("위에 있어요");
		}
		public void mouseExited(MouseEvent e) {
			System.out.println("마우스 나갔어요");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("?");
		}
	}

	public static void main(String[] args) {
		new MethodListnerRun(); 
	}
}
