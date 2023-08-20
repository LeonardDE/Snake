package Snake;

import java.awt.Color;

public class Apple {
	private int positionX;
	private int positionY;
	
	private Color color;
	
	
	public Apple(int x,int y, Color color) {
		positionX = x;
		positionY = y;
		this.color = color;
	}
	
	public int getX() {
		return positionX;
	}
	public int getY() {
		return positionY;
	}
	
	public Color getColor() {
		return color;
	}

}
