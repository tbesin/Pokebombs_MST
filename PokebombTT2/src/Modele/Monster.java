package Modele;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import Controller.GameController;

public class Monster extends Entity {
	String directionMonster = "Sud" ;
	boolean interrupteurUse = true;
	int velX= 1 , velY = 1 ;
	public Monster(int x, int y) {
		super(x, y);
	}
	public void update(){
		
		nearMonster();
		checkLimite();
		move();
	}
	// rester sur le monstre perde full vie?
	
	public String getDirectionMonster() {
		return this.directionMonster ;
	}
	public void setDirectionMonster(String newDirection){
		this.directionMonster = newDirection ;
	}
	public boolean getInterrupteurUse(){
		return this.interrupteurUse ;
	}
	
	public void setVelX(int newVelX){
		this.velX = newVelX;
	}
	public void setInterrupteurUse(boolean bool){
		this.interrupteurUse = bool;
	}
	
	public void setVelY(int newVelY){
		this.velY = newVelY;
	}
	
	
	public Image getMonsterImg(){	
		ImageIcon ic = new ImageIcon();
		if(directionMonster == "Sud"){
			ic =new ImageIcon("MonsterDown.png");
		}
		if(directionMonster == "Nord"){
				ic = new ImageIcon("MonsterUp.png");
		}
		if(directionMonster == "Ouest"){
			ic = new ImageIcon("LinkRunLeft1.png");
		}
		if(directionMonster == "Est"){
			ic = new ImageIcon("LinkRunRight3.png");
		}
		return ic.getImage();
	}
	
	public Image getImg(){	
		ImageIcon ic = new ImageIcon();
		if(directionMonster == "Sud"){
			ic =new ImageIcon("MonsterDown.png");
		}
		if(directionMonster == "Nord"){
				ic = new ImageIcon("MonsterUp.png");
		}
		if(directionMonster == "Ouest"){
			ic = new ImageIcon("LinkRunLeft1.png");
		}
		if(directionMonster == "Est"){
			ic = new ImageIcon("LinkRunRight3.png");
		}
		return ic.getImage();
	}
	
	
	public Rectangle getBounds(){	
		return new Rectangle(x+10, y+10, (600/15)-20,(600/15)-20);
	}
	
	public void checkLimite(){
		//if (x>=560) x=560;
		if (x>160) {x=159;this.setDirectionMonster("Ouest");}
		if (x<0) {x =0;this.setDirectionMonster("Est");}
		//if (y>=560) y=560;
		if (y>160){y=159;this.setDirectionMonster("Nord");}
		if (y<0) {y =0;this.setDirectionMonster("Sud");}
	}
	
	public void move(){
		if (this.getDirectionMonster()=="Sud") this.setY(y+velY);
		if (this.getDirectionMonster()=="Nord") this.setY(y-velY);
		if (this.getDirectionMonster()=="Ouest") this.setX(x-velX);
		if (this.getDirectionMonster()=="Est") this.setX(x+velX);
	}
	
	public void nearMonster(){
		int n =0;
		ArrayList<BriqueIncassable> briqueIncassables = GameController.getBriqueIncassableList() ;
		ArrayList<Explosion> explosions = GameController.getExplosionList();
		ArrayList<BriqueCassable> enemies = GameController.getBreakableList() ;
		ArrayList<Interrupteur> interrupteur = GameController.getInterrupteurList();
		for(int j = 0 ; j < briqueIncassables.size(); j++){
			BriqueIncassable ent = briqueIncassables.get(j) ;
			if( this.getBounds().intersects(ent.getBounds() ) ){
				changeDirection();
			}
			}
		for(int j = 0 ; j < enemies.size(); j++){
			BriqueCassable en = enemies.get(j) ;
			if( this.getBounds().intersects(en.getBounds() ) ){
				changeDirection();
			}}
		for(int j = 0 ; j < interrupteur.size(); j++){
			Interrupteur inter = interrupteur.get(j) ;
			if( this.getBounds().intersects(inter.getBounds() ) == false){
				n++;
		}
			else inter.interact(this);
		}
			if (n==interrupteur.size())this.setInterrupteurUse(true);
		}
	public void changeDirection(){
		if (this.getDirectionMonster()=="Sud") this.setDirectionMonster("Nord");
		if (this.getDirectionMonster()=="Nord") this.setDirectionMonster("Sud");
		if (this.getDirectionMonster()=="Est") this.setDirectionMonster("Ouest");
		if (this.getDirectionMonster()=="Ouest") this.setDirectionMonster("Est");
		
	}
	
	public void interact(Player p){	
		p.setLife(p.getLife() - 1);
		if (p.getLife()==1)p.setBomb(p.getBomb()+1);
	}
	
}
