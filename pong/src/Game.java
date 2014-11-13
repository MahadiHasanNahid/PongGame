import java.awt.BorderLayout;
import java.awt.BufferCapabilities;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	//-----Pong Game
	public static PlayerPaddle player;
	public static AIPaddle ai;
	public static Ball ball;
	InputHandler inputHandler;

	static boolean gameRunning = false;

	JFrame frame;
	public final int WIDTH = 400;
	public final int HEIGHT = WIDTH / 16 * 9;
	public final Dimension gameSize = new Dimension(WIDTH, HEIGHT);

	public final String TITLE = "Pong Game";

	// public int screenWidth;
	// public int screenHeigh;
	BufferedImage image = new BufferedImage(WIDTH, HEIGHT,
			BufferedImage.TYPE_INT_RGB);

	// Thread thread;

	int p1Score;
	int p2Score;
	
	@Override
	public void run() {

		while (gameRunning) {

			tick();
			render();

			try {
				Thread.sleep(7);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	public synchronized void start() {
		gameRunning = true;
		new Thread(this).start();
	}

	public static synchronized void stop() {
		gameRunning = false;
		System.exit(0);
	}

	public Game() {

		frame = new JFrame();
		setMinimumSize(gameSize);
		setPreferredSize(gameSize);
		setMaximumSize(gameSize);

		frame.add(this, BorderLayout.CENTER);

		frame.pack();

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle(TITLE);
		frame.setLocationRelativeTo(null);

		// screenWidth = getWidth();
		// screenHeigh = getHeight();

		System.out.println("hh " + getHeight());
		inputHandler = new InputHandler(this);
		player = new PlayerPaddle(10, 60);
		ai = new AIPaddle(getWidth() - 25, 60);
		ball = new Ball(getWidth()/2, getHeight()/2);
	}

	public void tick() {
		player.tick(this);
		ai.tick(this);
		ball.tick(this);
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();

		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		//g.setColor(Color.WHITE);
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);

		g.setColor(Color.WHITE);
		g.drawString("Player 1: "+p1Score, 0, 10);
		g.drawString("Player 2: "+p2Score, getWidth()-60, 10);
		
		player.render(g);
		ai.render(g);
		ball.render(g);
		g.dispose();
		bs.show();

	}

}
