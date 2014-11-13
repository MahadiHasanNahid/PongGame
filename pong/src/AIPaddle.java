import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.sun.javafx.scene.control.behavior.TwoLevelFocusBehavior;

public class AIPaddle {

	int x;
	int y;

	int width = 15;
	int height = 40;
	int speed = 1;

	boolean isTwoPlayer = false;
	Rectangle boundingBox;

	boolean goingUp = false;
	boolean goingDown = false;

	public AIPaddle(int x, int y) {
		this.x = x;
		this.y = y;

		boundingBox = new Rectangle(x, y, width, height);
		boundingBox.setBounds(x, y, width, height);
	}

	public void tick(Game game) {

		boundingBox.setBounds(x, y, width, height);
		
		if(!isTwoPlayer) {
			if (game.ball.y < y + height && y >= 0) {
				y -= speed;
			}
			if (game.ball.y > y && y + height <= game.getHeight()) {
				y += speed;
			}
		} else {
			if(goingUp) {
				y -= speed;
			}
			else if(goingDown) {
				y += speed;
			}
		}
		

		// int check = game.screenHeigh - height;
		// System.out.println("y: "+y+" screenHeight: "+check);
	}

	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
	}
}
