package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Controller.GameController;

public class Goal extends Entity{
	
	public Goal(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	public Image getGoalImg(){
	ImageIcon ic = new ImageIcon("ProfChen.png");
	return ic.getImage();
 }
	public Rectangle getBounds(){
		int intX = (int) Math.ceil(600/15) ;
		int intY = (int) Math .ceil(600/15);
		return new Rectangle(x,y,intX,intY);
	}
	
	public void interact(Player p){	
		p.setCanGo(1);
		if (p.getLife()>=2 && p.getBomb()>=1) {JOptionPane.showMessageDialog(null, "Good work, you've completed the level" );}
		else {JOptionPane.showMessageDialog(null, "Malheureusement, tu n'as pas assez de vies et bombs pour le prochain niveau, reviens me voir plus tard" );}
		GameController.removeGoal(this);

	
	}
}

