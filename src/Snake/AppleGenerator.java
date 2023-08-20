package Snake;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class AppleGenerator {
	
	private ArrayList<Apple> apples;
	
	public AppleGenerator() {
		apples = new ArrayList<Apple>();
	}
	
	public void GenerateApples(int count) {
		for(int i = 0; i < count;i++) {
			Random r = new Random();
			Apple apple = new Apple(r.nextInt(5,55) * 10,r.nextInt(5,35) * 10,Color.GREEN);
			apples.add(apple);
			System.out.println("Apple generate whith x: " + apple.getX() + " y: " + apple.getY());
		}
	}
	
	public void removeApple(Apple apple) {
		apples.remove(apple);
		System.out.println("Apple remove");
	}
	
	public ArrayList<Apple> getApples(){
		return apples;
	}

}
