package Modele;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controller.GameController;

public class Interrupteur extends Entity{
	static boolean interrupteurOn = false;
	
	public Interrupteur (int x, int y) {
		super(x, y);
	}
	public void update(){
	}
	
	public boolean getInterrupteurOn(){
		return this.interrupteurOn ;
	}
	public void setInterrupteurOn(boolean bool){
		this.interrupteurOn = bool;
	}

	
	public Image getInterrupteurImg(boolean interrupteurOn){
	ImageIcon ic = new ImageIcon();
	if(interrupteurOn) ic = new ImageIcon("interrupteurOn.png");
	else ic = new ImageIcon("interrupteurOff.png");
	return ic.getImage();
 }
	
	public Rectangle getBounds(){
		int intX = 20 ;					//(int) Math.ceil(600/15) ;
		int intY = 20 ;			// (int) Math .ceil(600/15);
		return new Rectangle(x+12,y+10,intX,intY);
	}
	
	
	public void explode(){
		GameController.addExplosion(new Explosion(x,y));
		GameController.addExplosion(new Explosion(x-30,y));
		GameController.addExplosion(new Explosion(x+30,y));
		GameController.addExplosion(new Explosion(x,y-30));
		GameController.addExplosion(new Explosion(x,y+30));
	}
	
	public void interact(Player p){
		ArrayList<CaseTeleportation> teleportation = GameController.getCaseTeleportationList() ;
		if (p.getInterrupteurUse()){
		for (int i =0; i< teleportation.size();i++){
			CaseTeleportation tempTeleportation = teleportation.get(i);
			if (tempTeleportation.getTeleportationIn()) tempTeleportation.setTeleportationIn(false);
			else tempTeleportation.setTeleportationIn(true);
		}
		if (this.getInterrupteurOn()) this.setInterrupteurOn(false);
		else if (this.getInterrupteurOn()==false) this.setInterrupteurOn(true);
		}
		p.setInterrupteurUse(false);
	}
	public void interact(Monster p){
		ArrayList<CaseTeleportation> teleportation = GameController.getCaseTeleportationList() ;
		if (p.getInterrupteurUse()){
		for (int i =0; i< teleportation.size();i++){
			CaseTeleportation tempTeleportation = teleportation.get(i);
			if (tempTeleportation.getTeleportationIn()) tempTeleportation.setTeleportationIn(false);
			else tempTeleportation.setTeleportationIn(true);
		}
		if (this.getInterrupteurOn()) this.setInterrupteurOn(false);
		else if (this.getInterrupteurOn()==false) this.setInterrupteurOn(true);
		}
		p.setInterrupteurUse(false);
	}
}
