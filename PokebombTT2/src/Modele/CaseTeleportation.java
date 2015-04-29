package Modele;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controller.GameController;

public class CaseTeleportation extends Entity {
	boolean teleportationIn = true;
	
	public CaseTeleportation (int x, int y) {
		super(x, y);
	}
	public void update(){
		useCaseTeleportation();
	}
	
	public boolean getTeleportationIn(){
		return this.teleportationIn ;
	}
	public void setTeleportationIn(boolean bool){
		this.teleportationIn = bool;
	}
	
	public Image getCaseTeleportationImg(boolean teleportationIn){
	ImageIcon ic = new ImageIcon();
	if(teleportationIn) ic = new ImageIcon("porteIn.png");
	else ic = new ImageIcon("porteOut.png");
	return ic.getImage();
 }
	
	public Rectangle getBounds(){
		int intX = (int) Math.ceil(600/15);
		int intY = (int) Math .ceil(600/15);
		return new Rectangle(x,y,intX,intY);
	}
	
	
	
	public void useCaseTeleportation(){
		ArrayList<Player> players = GameController.getPlayerList() ;
		ArrayList<Bomb> bombs = GameController.getBombList() ;
		for (int i=0; i< players.size();i++){
			Player tempPlayer = players.get(i);
			if( this.getBounds().intersects(tempPlayer.getBounds() ) ){
				tempPlayer.interact(this);
			}
		}
		for (int i=0; i< bombs.size();i++){
			Bomb tempBomb = bombs.get(i);
			if( this.getBounds().intersects(tempBomb.getBounds() ) ){
				tempBomb.interact(this);
			}
		}
	}
}
