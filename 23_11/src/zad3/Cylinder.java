package zad3;

public class Cylinder extends Circle {
	
	private double height=1;
	
	public Cylinder(){
		super();
	}
	
	public Cylinder(double radius){

		super(radius);
	}
	
	public Cylinder(double radius,double height){
		super(radius);
		this.height=height;
	}
	
	public Cylinder(double radius, double height,String color){
		super(radius,color);
		this.height=height;
	}
	
	public double getHeight(){
		return height;
	}
	
	public void setHeight(){
		this.height= height;
	}
	
	public double getVolume(){
		return super.getArea()*height;
	}
	
	public double getArea(){
		return (super.getArea())*2+2*Math.PI*getRadius();
	}
	
	public String toString(){
		return "Cylinder[radius="+getRadius()+",color="+getColor()+",height="+height+"]";
	}
	

}
