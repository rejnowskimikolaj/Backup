package Zad6;

public class Trapeze implements Figure{

	private double a;
	private double b;
	private double c;
	private double d;
	
	public Trapeze(double a, double b, double c, double d){
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
	}
	
	
	
	@Override
	public double getArea() {
		return(1 / 4 * ((this.a + this.b) / (this.a - this.b)) * Math.sqrt((a - b) + c + d)
        * Math.sqrt((a - b) + c - d) * Math.sqrt((a - b) - c + d) * Math.sqrt(-(a - b) + c + d));
	}

	@Override
	public double getPerimeter() {
		return a+b+c+d;
	}

	@Override
	public void setPoints() {
		
	}



	@Override
	public int getNodes() {
		return 4;
	}



	@Override
	public int getSides() {
		return 4;
	}

}
