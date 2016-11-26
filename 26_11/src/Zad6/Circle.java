package Zad6;

public class Circle implements Figure{

	private int radius = 1;
	private Point center;
	
	public Circle(int radius){
		this.radius=radius;
		setPoints();
	}
	
	public Circle(){
		setPoints();
	}
	
	@Override
	public double getArea() {
		return radius*radius*Math.PI;		
	}

	@Override
	public double getPerimeter() {
		return radius*2*Math.PI;
	}

	@Override
	public void setPoints() {
		center=new Point(0,0);
		
	}

	@Override
	public int getNodes() {
		return 0;
	}

	@Override
	public int getSides() {
		return 0;
	}
	
	

}
