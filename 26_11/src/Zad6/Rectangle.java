package Zad6;

public class Rectangle implements Figure{

	private double a=2;
	private double b=2;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Point pointD;
	
	public Rectangle(double a, double b){
		this.a=a;
		this.b=b;
		setPoints();
	}
	
	public Rectangle(){
		setPoints();
	}
	
	
	@Override
	public double getArea() {
		return a*b;
	}
	@Override
	public double getPerimeter() {
		return 2*a+2*b;
	}

	@Override
	public void setPoints() {
		pointA = new Point(0,0);
		pointB=new Point (a,0);
		pointC=new Point(a,b);
		pointC=new Point (0,b);
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Point getPointD() {
		return pointD;
	}

	public void setPointD(Point pointD) {
		this.pointD = pointD;
	}

	@Override
	public int getNodes() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getSides() {
		// TODO Auto-generated method stub
		return 4;
	}
	
	
	
	
}
