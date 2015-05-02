package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controller.GameController;

public class TrapInterruptor extends Entity{
	
	public TrapInterruptor(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	public Image getTrapInterruptorImg(){
	ImageIcon ic = new ImageIcon("pokedex.png");
	return ic.getImage();
 }
	
	public Image getImg(){
		ImageIcon ic = new ImageIcon("pokedex.png");
		return ic.getImage();
	 }
	
	public Rectangle getBounds(){
		int intX = 10;					//(int) Math.ceil(600/15) ;
		int intY = 10 ;			// (int) Math .ceil(600/15);
		return new Rectangle(x+8 , y+8 ,intX,intY);
	}
	
	
	public void interact(Player p){	
		ArrayList<Trap> traps = GameController.getTrapList() ;
		traps.clear();
		ArrayList<TrapInterruptor> trapInterruptors = GameController.getTrapInterruptorList() ;
		trapInterruptors.remove(this);
	}
}
