package Snake;
import java.awt.Point;
import java.util.ArrayList;


public class Snake {
	private int length;
	private int headPositionX;
	private int headPositionY;
	private Direction direction;
	private int borderPosX;
	private int borderPosY;
	
	private ArrayList<Point> body;

	
	public Snake(int x,int y,int borderPosX, int borderPosY) {
		length = 0;
		setPosition(x,y);
		direction = Direction.LEFT;
		
		this.borderPosX = Game.dim.width;
		this.borderPosY = Game.dim.height;
		
		body = new ArrayList<Point>();
		
	}
	
	public ArrayList<Point> getBody(){
		return body;
	}
	
	public int getLength() {
		return length;
	}
	
	public void addBodyBlock() {
		if(body.isEmpty()) {
			Point point = new Point(this.getHeadPositionX(),this.getHeadPositionY());
			body.add(point);
			length++;
		}
		else {
			Point point = new Point(this.getBody().get(length-1).x,
									this.getBody().get(length-1).y);
			body.add(point);
			length++;
		}
		
	}
	
	public void setPosition(int x, int y) {
		headPositionX = x;
		headPositionY = y;
	}
	
	public int getHeadPositionX() {
		return headPositionX;
	}
	
	public int getHeadPositionY() {
		return headPositionY;
	}
	
	
	public void Move() {
		MoveBody();
		switch (direction) {
		case UP:
			if(headPositionY > 0)
				headPositionY -=10;
			else
				headPositionY = borderPosY;
			break;
		case DOWN:
			if (headPositionY <= borderPosY)
				headPositionY +=10;
			else
				headPositionY = 0;
			break;
		case LEFT:
			if (headPositionX > 0)
				headPositionX -=10;
			else 
				headPositionX = borderPosX;
			break;
		case RIGHT:
			if (headPositionX <= borderPosX) 
				headPositionX +=10;
			else
				headPositionX = 0;
			
			break;
		
		}

		
	}
	
	private void MoveBody() {
		for(int i = length-1; i >= 0;i--) {
			Point block = body.get(i);
			if(i == 0) {
				block.x = this.headPositionX;
				block.y = this.headPositionY;
			} 
			else {
				block.x = body.get(i-1).x;
				block.y = body.get(i-1).y;
			}
		}
	}
	
	

	
	public void setDirection(Direction dir) {
		direction = dir;
	}
	public Direction getDirection() {
		return direction;
	}
}
