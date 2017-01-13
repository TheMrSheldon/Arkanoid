package Arkanoid;

import java.awt.*;

//Basically the same as a block
public class Player {
	private Arkanoid game;
	int height = 10;
	int width = 100;
	Point position = new Point(0, 0);
	
	public Player(Arkanoid game) {
		this.game = game;
		position = new Point(0, game.height/2-height-20);
	}
	
	//Calculate into which direction the ball would bounce off
	public Point bounceVector(Rectangle hitbox) {
		Point p = new Point(1, 1);
		Rectangle hb_t = new Rectangle(position.x-width/2, position.y-height/2, width, height/3);
		Rectangle hb_b = new Rectangle(position.x-width/2, position.y+height/2-height/3, width, height/3);
		Rectangle hb_l = new Rectangle(position.x-width/2, position.y-height/2, width/10, height);
		Rectangle hb_r = new Rectangle(position.x+width/2-width/10, position.y-height/2, width/10, height);
		if (hb_t.intersects(hitbox) || hb_b.intersects(hitbox)) p.y = -1;
		if (hb_r.intersects(hitbox) || hb_l.intersects(hitbox)) p.x = -1;
		return p;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.lightGray);
		g.fillRect(position.x-width/2, position.y-height/2, width, height);
		//Uncomment to debug-render hitboxes
		/*Rectangle hb_t = new Rectangle(game.player.position.x-game.player.width/2, game.player.position.y-game.player.height/2, game.player.width, height/3);
		Rectangle hb_b = new Rectangle(game.player.position.x-game.player.width/2, game.player.position.y+game.player.height/2-height/3, game.player.width, height/3);
		Rectangle hb_l = new Rectangle(game.player.position.x-game.player.width/2, game.player.position.y-game.player.height/2, width/10, game.player.height);
		Rectangle hb_r = new Rectangle(game.player.position.x+game.player.width/2-width/10, game.player.position.y-game.player.height/2, width/10, game.player.height);
		g.setColor(new Color(0 , 0, 255, 100));
		g.fillRect(hb_t.x, hb_t.y, hb_t.width, hb_t.height);
		g.setColor(new Color(0 , 255, 0, 100));
		g.fillRect(hb_b.x, hb_b.y, hb_b.width, hb_b.height);
		g.setColor(new Color(255 , 255, 255, 100));
		g.fillRect(hb_l.x, hb_l.y, hb_l.width, hb_l.height);
		g.setColor(new Color(255 , 0, 0, 100));
		g.fillRect(hb_r.x, hb_r.y, hb_r.width, hb_r.height);*/
	}
}
