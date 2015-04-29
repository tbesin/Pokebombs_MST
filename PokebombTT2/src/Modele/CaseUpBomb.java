package Modele;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controller.GameController;

public class CaseUpBomb extends Entity {
	
	public CaseUpBomb(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	public Image getCaseUpBombImg(){
		ImageIcon ic = new ImageIcon("BombBonus.png");
		return ic.getImage();
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x , y, getCaseUpBombImg().getWidth(null), getCaseUpBombImg().getHeight(null));
	}
	
	
	public void interact(Player p){			// dit au joueur ce qu'il doit faire en cas de collision
		p.setBomb(p.getBomb() + 1);
		GameController.getCaseUpBombList().remove(this);
	}

}