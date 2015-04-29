package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;


public abstract class Entity {
	int x, y ;
	
	public Entity( int x , int y){
		this.x = x;
		this.y = y;
	}
	
	public Entity getEntity(){
		return this ;
	}
	
	public void update(){
		
	}
	
	public Image getEntityImg(){
		return null;
		
	}
	
	public void checkCollision(){
		
	}
	
	public Rectangle getBounds(){
		return null;
	}
	
	//ACCESSEURS
		public int getX(){
			return this.x ;
		}
		
		public int getY() {
			return this.y ;
		}
		
		
		public void setX(int newX){
			this.x = newX;
		}
		
		public void setY(int newY){
			this.y = newY;
		}
		public void interact(Player p){
		}
		public void interact (Missile m){
			
		}
		public void interact(Bomb b){
			
		}
		public void interact(CaseTeleportation ct){
			
		}
}