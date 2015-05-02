package Modele;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controller.GameController;

public class CasePousseBomb extends Entity {
	
	public CasePousseBomb(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	public Image getCasePousseBombImg(){
		ImageIcon ic = new ImageIcon("casePoussebomb.png");
		return ic.getImage();
	}
	
	public Image getImg(){
		ImageIcon ic = new ImageIcon("casePoussebomb.png");
		return ic.getImage();
	}
	
	public Rectangle getBounds(){
		int X = 30;
		int Y = 30;
		return new Rectangle(x , y, X, Y);
	}
	
	
	public void interact(Player p){			// dit au joueur ce qu'il doit faire en cas de collision
		p.setPousseBomb(true);
		GameController.getCasePousseBombList().remove(this);
	}

}