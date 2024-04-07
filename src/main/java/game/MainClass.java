package game;

public class MainClass {

	public static void main(String[] args) {
		Configuration config = new Configuration();
        GameLogic game = new GameLogic(config);
        game.play(100); // Pass the betting amount

	}

}
