package week7;

public class ShapeRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle c = new Circle();
		Triangle t = new Triangle();
		Rectangle r = new Rectangle();
		
		c.draw();
		t.draw();
		r.draw();
		
		c.delete();
		t.delete();
		r.delete();
	}

}
