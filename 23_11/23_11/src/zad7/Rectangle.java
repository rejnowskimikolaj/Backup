package zad7;

public class Rectangle extends Shape {
	
	private double width = 1;
	private double length = 1;
	
	public Rectangle(){
		super();
	}

	public Rectangle(double width,double length){
		super();
		this.width=width;
		this.length=length;
	}
	
	public Rectangle(double width,double length,String color, boolean filled){
		super(color, filled);
		this.width=width;
		this.length=length;
	}
	@Override
	public double getArea() {
		
		return width*length;
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return 2*length+2*width;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public String toString(){
		return "Circle[width="+width+",length="+length+",color"+getColor()+"]";
	}

}
