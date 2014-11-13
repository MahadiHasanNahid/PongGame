import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

public class MainMenu extends JFrame {

	private static final long serialVersionUID = 1L;

	int screenWidth = 250;
	int screenHeight = 200;

	int buttonWidth = 100;
	int buttonHeight = 40;

	JButton play;
	JButton quit;

	JCheckBox twoPlayers;
	JCheckBox limitFrameRate;

	public MainMenu() {
		addButtons();
		addActions();

		getContentPane().setLayout(null);

		play.setBounds((screenWidth - buttonWidth) / 2, 5, buttonWidth,
				buttonHeight);
		quit.setBounds((screenWidth - buttonWidth) / 2, 50, buttonWidth,
				buttonHeight);

		twoPlayers.setBounds((screenWidth - buttonWidth) / 2, 95,
				buttonWidth * 2, buttonHeight);
		limitFrameRate.setBounds(0, 140, buttonWidth * 3, buttonHeight);

		getContentPane().add(play);
		getContentPane().add(quit);
		getContentPane().add(twoPlayers);
		getContentPane().add(limitFrameRate);

		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setSize(screenWidth, screenHeight);
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);

	}

	private void addButtons() {

		play = new JButton("Play");
		quit = new JButton("Quit");
		twoPlayers = new JCheckBox("2 Players");
		limitFrameRate = new JCheckBox("Limit Frames/Second to Updates/Seconds");
	}

	private void addActions() {

		play.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				Game game = new Game();
				if (twoPlayers.isSelected()) {
					game.ai.isTwoPlayer = true;
				} else {
					game.ai.isTwoPlayer = false;
				}

				game.start();
			}
		});
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
