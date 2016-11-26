package Shapes;

public class ResizableCircle  extends Circle implements Resizable{

	@Override
	public void resize(int percent) {
		
		super.radius=super.radius*((100-percent)/100);
	}

}
