package alex.andrew.monoplyproject;

import java.io.IOException;

public class Monopoly {

	public static void main(String[] args) throws IOException {
		Game game = new Game();
		game.init();
		game.run();
	}

}
