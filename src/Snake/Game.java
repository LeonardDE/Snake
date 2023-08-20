package Snake;

import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Game extends Frame implements ActionListener {
	
	private Snake snake;
	private AppleGenerator appleGenerator;
	private Timer timer = new Timer(100,this);
	
	public static final Dimension dim = new Dimension(600, 400);
	
	
	public Game(){
		super("Snake-Game");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension mySize = dim;
		setLocation((d.width - mySize.width) / 2, (d.height - mySize.height) / 2);
		setSize(mySize);

				
		addWindowListener(new WindowAdapter()
		{
		public void windowClosing(WindowEvent e)
		{
		Game.this.setVisible(false);
		Game.this.dispose();
		timer.stop();
		}
		});
		
		addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				
				switch (keyCode) {
				case KeyEvent.VK_UP:
					if(snake.getDirection() != Direction.DOWN) snake.setDirection(Direction.UP);
					break;
				case KeyEvent.VK_DOWN:
					if(snake.getDirection() != Direction.UP) snake.setDirection(Direction.DOWN);
					break;
				case KeyEvent.VK_LEFT:
					if(snake.getDirection() != Direction.RIGHT) snake.setDirection(Direction.LEFT);
					break;
				case KeyEvent.VK_RIGHT:
					if(snake.getDirection() != Direction.LEFT) snake.setDirection(Direction.RIGHT);
					break;
				}
			}
			
		});
		
		
		snake = new Snake(mySize.width/2,mySize.height/2,mySize.width,mySize.height);
		appleGenerator = new AppleGenerator();
		
		timer.start();
	}
	
	
	public void snakeUpdate(Graphics g) {
		g.setColor(Color.RED);	
		g.fillRect(snake.getHeadPositionX(), snake.getHeadPositionY(), 10,10);
		
		for(Point point: snake.getBody())
		{
			g.fillRect(point.x, point.y, 10,10);
		}
	}
	
	private void applesUpdate(Graphics g) {
		if(appleGenerator.getApples().isEmpty()) {
			appleGenerator.GenerateApples(1);
		}
		
		for (int i = 0; i < appleGenerator.getApples().size();i++) {
			Apple apple =  appleGenerator.getApples().get(i);
			if (apple.getX() == snake.getHeadPositionX() && apple.getY() == snake.getHeadPositionY())
			{
				appleGenerator.removeApple(apple);
				snake.addBodyBlock();
				continue;
			}else {
				g.setColor(apple.getColor());
				g.fillRect(apple.getX(), apple.getY(), 10,10);
			}
		}

	}
	
	private void GameOver() {
		timer.stop();
		this.add((new Label("GAME OVER")));
		setTitle("GAME OVER");
		Dimension my_Size = dim;
		my_Size.width = 200;
		my_Size.height = 100;
		setSize(my_Size);
		}
	private void checkSnakeHeadPosition() {
		for (Point point: snake.getBody()) {
			if(point.x == snake.getHeadPositionX() && point.y == snake.getHeadPositionY()) {
				GameOver();
			}
		}
	}
	
	
	public void paint(Graphics g)
	{
		//System.out.println("paint");
		
		snakeUpdate(g);
		applesUpdate(g);
		
	}
	public static void main(String[] args)
	{
		Frame game = new Game();
		game.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//System.out.println("Action");
		snake.Move();
		checkSnakeHeadPosition();
		repaint();
	}

	
	
}
