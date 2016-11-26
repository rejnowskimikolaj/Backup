package Zad6;

public class Cylinder implements Figure3D{
	
	private Circle circle;
	private double height;
	
	public Cylinder(int radius, double height){
		this.circle=new Circle(radius);
		this.height=height;
	}

	@Override
	public double getArea() {
		return 2*circle.getArea()+circle.getPerimeter()*height;
	}

	@Override
	public double getVolume() {
		return circle.getArea()*height;
	}
	
	
	
	

}
