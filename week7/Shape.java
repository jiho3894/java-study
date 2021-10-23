package week7;

abstract class Shape {
	public abstract void draw();
	public abstract void delete();
}

class Circle extends Shape {
	public void draw() {
		System.out.println("원을 그립니다.");
	}
	public void delete() {
		System.out.println("원을 삭제합니다.");
	}
}

class Triangle extends Shape {
	public void draw() {
		System.out.println("삼각형을 하나,둘,셋 그립니다.");
	}
	public void delete() {
		System.out.println("삼각형을 삭제합니다.");
	}
}

class Rectangle extends Shape {
	public void draw() {
		System.out.println("사각형을 하나,둘,셋,넷 그립니다.");
	}
	public void delete() {
		System.out.println("사각형을 삭제합니다.");
	}
}