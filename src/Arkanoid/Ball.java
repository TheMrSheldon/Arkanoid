package Arkanoid;

import java.awt.*;

//The Ball class, used to calculate hits and and ball movement
public class Ball {
	private Arkanoid game;
	private int radius = 10;
	Point position = new Point(0, 0);
	Point movement = new Point(1, 1);
	float speed = 0.3f;
	
	public Ball(Arkanoid game) {
		this.game = game;
	}
	
	//On Every tick... move the ball and check for collisions
	public void tick(double deltatime) {
		position.translate((int)(movement.x*(speed*deltatime)), (int)(movement.y*(speed*deltatime)));
		if (Math.abs(position.x) >= Math.abs(game.width/2)) movement.x = -movement.x;
		if (position.y <= -game.height/2) movement.y = -movement.y;
		if (position.y >= game.height/2) game.OnBallLost();
		
		Rectangle hitbox = new Rectangle(position.x-radius, position.y-radius, radius*2, radius*2);
		Point pv = game.player.bounceVector(hitbox);
		movement.x *= pv.x;
		movement.y *= pv.y;
		
		for (int i = 0; i < game.blocks.size(); i++) {
			Block b = game.blocks.get(i);
			pv = b.bounceVector(hitbox);
			movement.x *= pv.x;
			movement.y *= pv.y;
			if (pv.x < 0 || pv.y < 0) {
				game.OnBlockBroken(b);
				game.blocks.remove(b);
			}
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(position.x-radius, position.y-radius, radius*2, radius*2);
	}
	
}
