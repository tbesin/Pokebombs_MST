package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class PassBomb extends Entity{
	
	public PassBomb(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	
	public Image getImg(){
		ImageIcon ic = new ImageIcon("passBomb.png");
		return ic.getImage();
	 }
	
	public void interact(Player p){	//interface ???
		p.setCanGo(1);
	}
	
}
