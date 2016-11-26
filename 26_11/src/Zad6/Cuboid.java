package Zad6;

public class Cuboid implements Figure3D {
	
	private double height;
	private Rectangle rectangle;
	
	public Cuboid(double a, double b, double height){
		this.height=height;
		this.rectangle=new Rectangle(a,b);
		
	}

	@Override
	public double getArea() {
		return rectangle.getArea()*2+(2*rectangle.getA()*height)+2*(2*rectangle.getB()*height);
	}

	@Override
	public double getVolume() {
		return rectangle.getArea()*height;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}

	
}
