package Arkanoid;

public class GameThread extends Thread {
	private Arkanoid game;
	public GameThread(Arkanoid game) {
		this.game = game;
	}
	
	public void run() {
		//Init
		game.isRunning = true;
		game.isPaused = false;
		game.lastUpdate = System.nanoTime();
		//Gameloop
		while (game.isRunning) {
			try {
				if (game.isPaused) {
					game.lastUpdate = System.nanoTime();
					Thread.sleep(1);
				} else {
					game.tick();
					game.lastUpdate = System.nanoTime();
					Thread.sleep((long)(1000.0/game.tickrate));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		//Exit
	}
}
