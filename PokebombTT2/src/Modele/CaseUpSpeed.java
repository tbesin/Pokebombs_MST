package Modele;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Controller.GameController;

public class CaseUpSpeed extends Entity {
	public CaseUpSpeed(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	public Image getImg(){
		ImageIcon ic = new ImageIcon("bonusVelo.png");
		return ic.getImage();
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x , y, getImg().getWidth(null), getImg().getHeight(null));
	}
	
	
	public void interact(Player p){			// dit au joueur ce qu'il doit faire en cas de collision
		if (p.getSpeed()<4){
			p.setSpeed(p.getSpeed() + 1);
		}
		GameController.getCaseUpSpeedList().remove(this);
	}

}