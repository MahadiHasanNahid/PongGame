import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	public InputHandler(Game game) {
		game.addKeyListener(this);
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();
		// ---Player1 Controls
		if (keyCode == KeyEvent.VK_W) {
			Game.player.goingUp = true;
		}
		if (keyCode == KeyEvent.VK_S) {
			Game.player.goingDown = true;
		}

		// --------Player 2 Controls
		if (keyCode == KeyEvent.VK_UP) {
			Game.player.goingUp = true;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			Game.ai.goingDown = true;
		}

		if(keyCode == KeyEvent.VK_ESCAPE) {
			System.exit(0);
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();

		// ---------Player 1 Controls
		if (keyCode == KeyEvent.VK_W) {
			Game.player.goingUp = false;
		}
		if (keyCode == KeyEvent.VK_S) {
			Game.ai.goingDown = false;
		}

		// --------Player 2 Controls
		if (keyCode == KeyEvent.VK_UP) {
			Game.player.goingUp = false;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			Game.ai.goingDown = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

}
