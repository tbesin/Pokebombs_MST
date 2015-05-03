package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;


public abstract class Entity {
	int x, y ;
	String mode ; //
	
	public Entity( int x , int y){
		this.x = x;
		this.y = y;
	}
	
	public Entity getEntity(){
		return this ;
	}
	
	public void update(){
		
	}
	
	public Image getImg(){
		return null;
		
	}
	
	public void checkCollision(){
		
	}
	
	public Rectangle getBounds(){
		int intX = (int) Math.ceil(600/15);
		int intY = (int) Math .ceil(600/15);
		return new Rectangle(x,y,intX,intY);
	}
	
	
	public void checkLimite(){
		if(mode == "solo"){
			if (x>=160) x=160;
			if (y>=160) y=160;
		}
		
		if(mode == "multi"){
			if (x>=560){ x=560;
			if (y>=560) y=560;
			}
		}
		
		if (x<=0) {x =0;}
		if (y<=13) y=13;
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
		
		
		//interfaces ???
		public void interact(Player p){
		}
		public void interact (Missile m){
			
		}
		public void interact(Bomb b){
			
		}
		public void interact(CaseTeleportation ct){
			
		}
		
		
		
		
		public String getMode(){
			return mode ;
		}
		
		public void setMode(String mode){
			this.mode = mode ;
		}
}