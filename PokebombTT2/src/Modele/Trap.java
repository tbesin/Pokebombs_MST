package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

import Controller.GameController;

public class Trap extends Entity{
	
	public Trap(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	public Image getTrapImg(){
	ImageIcon ic = new ImageIcon("kabuto.png");
	return ic.getImage();
 }
	public Rectangle getBounds(){
		int intX = 10;					//(int) Math.ceil(600/15) ;
		int intY = 10 ;			// (int) Math .ceil(600/15);
		return new Rectangle(x+8 , y+8 ,intX,intY);
	}
	
	public void checkGoTrap(Player p){
		if (p.getBounds().intersects(this.getBounds())){p.setPlayerGoTrap(true);}
		else {p.setPlayerGoTrap(false);}
	}
	
	public void interact(Player p){	
		if (p.getPlayerGoTrap()==false) {p.setLife(p.getLife() - 1);if (p.getLife()==1)p.setBomb(p.getBomb()+1);}
		checkGoTrap(p);
	}
}

