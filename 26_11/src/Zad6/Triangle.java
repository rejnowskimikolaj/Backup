package Zad6;

public class Triangle implements Figure{
	
	private double height;
	private double a;
	private double b;
	private double c;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private TriangleType triangleType;
	
	public void setPoints(){
		pointA=new Point(0,0);
		pointB=new Point(a,0);
		pointC=new Point(1,1);  //tutaj wykorzystac jakis wzor na wierzcholek trojkota??
	}
	
	//rownoboczny
	public Triangle(double base){
		this.height=(Math.sqrt(3)/2)*base;
		this.a=base;
		this.b=base;
		this.c=base;
		this.triangleType=TriangleType.EQUILATERAL;
		setPoints();
	}

	//rownoramienny
	public Triangle(double base, double height){
		this.height=height;
		this.a=base;
		this.b = Math.sqrt((0.5*a)+(height*height));
		this.c=b;
		this.triangleType=TriangleType.ISOSCELES;
		setPoints();

	}
	
	//zwykly
	
	public Triangle(double a, double b, double c){
		this.a=a;
		this.b=b;
		this.c=c;
		this.triangleType=TriangleType.REGULAR;
		setPoints();

	}
	@Override
	public double getArea() {
		if(this.triangleType.equals(TriangleType.REGULAR)) return Math.sqrt((a+b+c)*(a+b-c)*(a-b+c));
		return (height*a)/2;
	}

	@Override
	public double getPerimeter() {
		return a+b+c;
	}

	@Override
	public int getNodes() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public int getSides() {
		// TODO Auto-generated method stub
		return 3;
	}
	
	

	
}
