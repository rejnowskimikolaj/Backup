package Movables;

public class MovablePoint implements Movable {

	int x;
	int y;
	int xSpeed;
	int ySpeed;
	
	public MovablePoint(int x, int y, int xSpeed, int ySpeed){
		this.x=x;
		this.y=y;
		this.xSpeed=xSpeed;
		this.ySpeed=ySpeed;
	}
	
	public String toString(){
		return "(x,y):"+"("+x+","+y+")"+ "(xSpeed,ySpeed):"+"("+xSpeed+","+ySpeed+")";
	}

	@Override
	public void moveUp() {
		y++;
		
	}

	@Override
	public void moveDown() {
		y--;
	}

	@Override
	public void moveLeft() {
		
		x--;
	}

	@Override
	public void moveRight() {
		x++;
	}
	
}
