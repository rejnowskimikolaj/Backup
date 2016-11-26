package Shapes;

public class Circle implements GeometricObject{
	
	protected double radius = 1;

	@Override
	public double getPerimeter() {
		return radius*2*Math.PI;
	}

	@Override
	public double getArea() {
		return radius*radius*Math.PI;
	}
	
	

}
