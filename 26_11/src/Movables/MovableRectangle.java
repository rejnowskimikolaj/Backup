package Movables;

public class MovableRectangle implements Movable{
	
	private MovablePoint topLeft;
	private MovablePoint bottomRight;
	
	public MovableRectangle(int x1, int y1, int x2,int y2, int xSpeed, int ySpeed ){
		this.topLeft=new MovablePoint(x1,y1,ySpeed, ySpeed);
		this.bottomRight=new MovablePoint(x2,y2,ySpeed, ySpeed);

		
	}

	@Override
	public void moveUp() {
		this.topLeft.moveUp();
		this.bottomRight.moveUp();
	}

	@Override
	public void moveDown() {
		this.topLeft.moveDown();
		this.bottomRight.moveDown();		
	}

	@Override
	public void moveLeft() {
		this.topLeft.moveLeft();
		this.bottomRight.moveLeft();		
	}

	@Override
	public void moveRight() {
		this.topLeft.moveRight();
		this.bottomRight.moveRight();		
	}
	
	public String toString(){
		return "bottom right:"+bottomRight.toString()+"top left: "+topLeft.toString();
	}
	
	public int getWidth(){
		return Math.abs(bottomRight.x-topLeft.x);
		
	}
	
	public int getHeight(){
		return Math.abs(bottomRight.y-topLeft.y);
	}
	
	public int[] getSize(){
		int[]arr={getWidth(),getHeight()};
		return arr;
	}
	
	public int getArea(){
		return getHeight()*getWidth();
	}
	
	public int getPerimeter(){
		return 2*getHeight()+2*getWidth();
	}

}
