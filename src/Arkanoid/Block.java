package Arkanoid;

import java.awt.*;

public class Block {
	public Point position = new Point(0, 0);
	public int width = 70;
	public int height = 30;
	public Color mainColor = Color.red.darker();
	
	//Calculate in which direction the ball should bounce off
	public Point bounceVector(Rectangle hitbox) {
		Point p = new Point(1, 1);
		Rectangle hb_t = new Rectangle(position.x, position.y, width, height/3);
		Rectangle hb_b = new Rectangle(position.x, position.y+height-height/3, width, height/3);
		Rectangle hb_l = new Rectangle(position.x, position.y, width/10, height);
		Rectangle hb_r = new Rectangle(position.x+width-width/10, position.y, width/10, height);
		if (hb_t.intersects(hitbox) || hb_b.intersects(hitbox)) p.y = -1;
		if (hb_r.intersects(hitbox) || hb_l.intersects(hitbox)) p.x = -1;
		return p;
	}
	
	public void render(Graphics g) {
		g.setColor(mainColor);
		g.fillRect(position.x, position.y, width, height);
		
		for (int i = 0; i < height/4; i++) {
			g.setColor(mainColor.darker());
			g.drawLine(position.x+i, position.y+height-i, position.x+width-1, position.y+height-i);
			g.drawLine(position.x+width-1-i, position.y+i, position.x+width-1-i, position.y+height);
			g.setColor(mainColor.brighter());
			g.drawLine(position.x, position.y+i, position.x+width-1-i, position.y+i);
			g.drawLine(position.x+i, position.y+height-i, position.x+i, position.y);
		}
		
		//Uncomment to debug render hitboxes
		/*Rectangle hb_t = new Rectangle(position.x, position.y, width, height/3);
		Rectangle hb_b = new Rectangle(position.x, position.y+height-height/3, width, height/3);
		Rectangle hb_l = new Rectangle(position.x, position.y, width/10, height);
		Rectangle hb_r = new Rectangle(position.x+width-width/10, position.y, width/10, height);
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
