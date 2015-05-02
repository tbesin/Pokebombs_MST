package Modele;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controller.GameController;

public class Missile extends Entity {
	String direction ;
	
	public Missile(int x, int y, String direction) {
		super(x, y);
		this.direction = direction;
	}
	
	public void update(){
		if(direction == "Nord"){
			this.y -= 1 ;
		}
		else if(direction == "Sud"){
			this.y += 1 ;
		}
		else if(direction == "Ouest"){
			this.x -= 1 ;
		}
		else if(direction == "Est"){
			this.x += 1 ;
		}
		
		checkLimite();
		nearMissile();
	}
	
	public Image getMissileImg(){
		ImageIcon ic = new ImageIcon("ArrowUp1.png");
		if(direction == "Sud"){
			ic = new ImageIcon("ArrowDown1.png");
		}
		else if(direction == "Ouest"){
			ic = new ImageIcon("ArrowLeft1.png");
		}
		else if(direction == "Est"){
			ic = new ImageIcon("ArrowRight1.png");
		}
		return ic.getImage();
	}
	
	
	public Image getImg(){
		ImageIcon ic = new ImageIcon("ArrowUp1.png");
		if(direction == "Sud"){
			ic = new ImageIcon("ArrowDown1.png");
		}
		else if(direction == "Ouest"){
			ic = new ImageIcon("ArrowLeft1.png");
		}
		else if(direction == "Est"){
			ic = new ImageIcon("ArrowRight1.png");
		}
		return ic.getImage();
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x , y, getMissileImg().getWidth(null), getMissileImg().getHeight(null));
	}
	
	/*public void explode(){
		GameController.removeBomb(this);
		GameController.addExplosion(new Explosion(x,y));
		GameController.addExplosion(new Explosion(x-20,y));
		GameController.addExplosion(new Explosion(x+20,y));
		GameController.addExplosion(new Explosion(x,y-20));
		GameController.addExplosion(new Explosion(x,y+20));
		GameController.addExplosion(new Explosion(x-40,y));
		GameController.addExplosion(new Explosion(x+40,y));
		GameController.addExplosion(new Explosion(x,y-40));
		GameController.addExplosion(new Explosion(x,y+40));
	}*/
	
	public void checkLimite(){			//fait disparaitre le missile s'il sort du terrain
		if (x>450 || x<0 || y>=530 || y<0 ){
			GameController.getMissileList().remove(this);
		}
		
	}
	
	public void nearMissile(){				//pour les collisions
		ArrayList<Enemy> enemies = GameController.getEnemyList() ;
		for(int i = 0 ; i < enemies.size(); i++){
			Enemy e = enemies.get(i) ;
			if( this.getBounds().intersects(e.getBounds() ) ){
				e.interact(this);
			}
		}
		ArrayList<BriqueCassable> breakables= GameController.getBreakableList() ;
		for(int i = 0 ; i < breakables.size(); i++){
			BriqueCassable e = breakables.get(i) ;
			if( this.getBounds().intersects(e.getBounds() ) ){
				e.interact(this);
			}
		}
	}
	
	public void interact(Enemy e){			// dit au joueur ce qu'il doit faire en cas de collision
		GameController.getEnemyList().remove(e);
		GameController.getMissileList().remove(this);
	}
	
	public void interact(BriqueCassable bc){			// dit au joueur ce qu'il doit faire en cas de collision
		GameController.getBreakableList().remove(bc);
		GameController.getMissileList().remove(this);
	}
}

