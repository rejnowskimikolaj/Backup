package Movables;

public class MovableCircle implements Movable {
	
	private int radius;
	private MovablePoint center;
	
	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius ){
		center=new MovablePoint(x,y,ySpeed, ySpeed);
		this.radius=radius;
		
	}

	@Override
	public void moveUp() {
		this.center.moveUp();
	}

	@Override
	public void moveDown() {
		this.center.moveDown();
	}

	@Override
	public void moveLeft() {
		this.center.moveLeft();
	}

	@Override
	public void moveRight() {
		this.center.moveRight();
	}
	
	public String toString(){
		return center.toString()+" radius: "+ radius;
	}

}
