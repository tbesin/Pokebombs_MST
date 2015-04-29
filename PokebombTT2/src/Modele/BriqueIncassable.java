package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class BriqueIncassable extends Entity{
	
	public BriqueIncassable(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	public Image getBriqueIncassableImg(){
	ImageIcon ic = new ImageIcon("petit_rocher.png");
	return ic.getImage();
 }
	public Rectangle getBounds(){
		int intX = (int) Math.ceil(600/15) ;
		int intY = (int) Math .ceil(600/15);
		return new Rectangle(x,y,intX,intY);
	}
	
	public void interact(Player p){	
		p.setCanGo(1);
	
	}
	public void interact(Bomb b){
		b.setCanGoBomb(1);
	}
}
