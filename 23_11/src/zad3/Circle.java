package zad3;

public class Circle {

	private double radius=1;
	private String color ="red";
	
	public Circle(){
		
	}
	
	public Circle(double radius){
		this.radius=radius;
	}
	
	public Circle(double radius,String color){
		this.radius=radius;
		this.color=color;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getRadius() {
		return radius;
	}

	public String getColor() {
		return color;
	}
	
	public double getArea(){
		return radius*radius*Math.PI;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString(){
		return "Circle[radius="+radius+",color="+color+"]";
	}
}
