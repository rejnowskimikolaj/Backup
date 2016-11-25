package zad7;

public abstract class Shape {

	private String color = "red";
	private boolean filled = true;
	
	public Shape(){
		
	}
	
	public abstract double getArea();
	public abstract double getPerimeter();

	
	public Shape(String color, boolean filled){
		this.color=color;
		this.filled=filled;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public String toString(){
		return filled+" "+color;
	}
	
	
}
