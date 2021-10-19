package classTest06;

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
		setSize(200, 200); 
		setVisible(true); 
	}

	class MyMouseListener implements MouseListener {
		public void mousePressed(MouseEvent e){
			int x = e.getX(); 
			int y = e.getY();
			la.setLocation(x, y);
		}

		public void mousereleased(MouseEvent e) {   }
		public void mouseClicked(MouseEvent e) {  }
		public void mouseEntered(MouseEvent e) {  }
		public void mouseExited(MouseEvent e) {   }

		@Override
		public void mouseReleased(MouseEvent e) {
			
		}
	}

	public static void main(String[] args) {
		new MethodListnerRun(); 
	}
}

