package Zad6;

public class Pyramid implements Figure3D{
	
	private double height;
	Figure figure;
	
	public Pyramid(Figure figure,double height){
		this.figure=figure;
		this.height=height;
	}

	@Override
	public double getArea() {
		return 0;
	}

	@Override
	public double getVolume() {
		return 0;
	}

}
