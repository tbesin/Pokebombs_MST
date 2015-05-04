package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import Controller.GameController;
import Controller.GameManager;


public class Explosion extends Entity implements ActionListener {
	
	Timer explosiontimer;
	private int n=0;
	static Random rand = new Random();
	boolean bombExplose = false;	
	private int imgNumber;		//permet de déterminer quelle image mettre
	boolean ExplosionActif = true;
	int playerNumber ;
	String choosenLevel ;
	
	
	//constructeur
	public Explosion(int x, int y, int imgNumber, Bomb bomb) {
		super(x, y);
		this.imgNumber = imgNumber ;
		this.playerNumber = bomb.getPlayer().getPlayerNumber() ;
		this.mode = bomb.getMode();
	}
	
	public Explosion(int x, int y) {
		super(x, y);
		this.playerNumber = 0 ;
	}
	
	public void update(){
		if (n==0){explosiontimer = new Timer(500,this);
		explosiontimer.start();
		checkCollisions();}
		n++;
		
	}

	
	public boolean getExplosionActif(){
		return this.ExplosionActif;
	}
	public void setExplosionActif(boolean bool){
		this.ExplosionActif = bool;
	}
	
	
	
	
	
	
	
	public Image getImg(){
			
			ImageIcon ic = new ImageIcon("DeflagrationDown2.png");
			
			if(this.playerNumber == 1){
				if(this.imgNumber == 2){
					ic = new ImageIcon("pikachu_bombe.png");
				}
				
				else if(this.imgNumber == 3){
					ic = new ImageIcon("Electric_attack_left1.png");
				}
				
				else if(this.imgNumber == 4){
					ic = new ImageIcon("Electric_attack_up1.png");
				}
			}
			
			if(this.playerNumber == 2){
				if(this.imgNumber == 2){
					ic = new ImageIcon("salameche_bombe1.png");
				}
				
				else {
					ic = new ImageIcon("petite_flamme.png");
				}
			}
			
			if(this.playerNumber == 3){
				if(this.imgNumber == 2){
					ic = new ImageIcon("carapuce_bombe1.png");
				}
				
				else {
					ic = new ImageIcon("bubble_attack1.png");
				}
			}
			
			if(this.playerNumber == 4){
				if(this.imgNumber == 2){
					ic = new ImageIcon("bulbizarre_bombe1.png");
				}
				
				else {
					ic = new ImageIcon("leaf_attack1.png");
				}
			}
			
			return ic.getImage();
		}
	
	public Rectangle getBounds(){
		return new Rectangle(x,y,40,40);
	}
	
	public void checkCollisions(){
		int lvl = 1;			//à changer après avec choosenlevl
		ArrayList<BriqueCassable> breakables = GameController.getBreakableList();
		for(int i = 0 ; i < breakables.size(); i++){
			BriqueCassable tempEnemy = breakables.get(i);
			if( getBounds().intersects(tempEnemy.getBounds() )&& this.getExplosionActif() ) {
				this.setExplosionActif(false);
				GameController.removeBreakable(tempEnemy);
				if(mode == "solo"){
					GameManager.BonusSolo(lvl, tempEnemy.getX(), tempEnemy.getY());
				}
				if(mode == "multi"){
					GameManager.Bonus(GameManager.choix(),tempEnemy.getX(),tempEnemy.getY());
				}
			}
			
		}
		
		ArrayList<Trap> traps = GameController.getTrapList();//faire une interface pour détruire les trucs avec les explposions
		for(int i = 0 ; i <traps.size(); i++){
			Trap t = traps.get(i);
			if( getBounds().intersects(t.getBounds() ) && this.getExplosionActif()) {
				this.setExplosionActif(false);
				GameController.removeTrap(t);
			}
		}
		
		ArrayList<Player> players= GameController.getPlayerList();
		for(int i = 0 ; i < players.size(); i++){
			Player tempPlayer = players.get(i);
			if( getBounds().intersects(tempPlayer.getBounds() ) && this.getExplosionActif()) {
				this.setExplosionActif(false);
				tempPlayer.setLife(tempPlayer.getLife()-1);
				if (tempPlayer.getLife()==1)tempPlayer.setBomb(tempPlayer.getBomb()+1);
			}
		}
		ArrayList<Bomb> bombs= GameController.getBombList();
		for(int i = 0 ; i < bombs.size(); i++){
			Bomb tempBomb = bombs.get(i);
			if( getBounds().intersects(tempBomb.getBounds() )&& this.getExplosionActif() ) {
				this.setExplosionActif(false);
				tempBomb.explode();
			}
			
		}
		ArrayList<Monster> monsters= GameController.getMonsterList();
		for(int i = 0 ; i < monsters.size(); i++){
			Monster monster = monsters.get(i);
			if( getBounds().intersects(monster.getBounds() ) && this.getExplosionActif()) {
				this.setExplosionActif(false);
				GameController.removeMonster(monster);
				if (lvl==1){GameController.addCaseUpBomb(new CaseUpBomb (monster.getX(),monster.getY()));
			}
			
		}}
		ArrayList<Interrupteur> interrupteurs = GameController.getInterrupteurList();
		for(int i = 0 ; i <interrupteurs.size(); i++){
			Interrupteur t = interrupteurs.get(i);
			if( getBounds().intersects(t.getBounds() )&& this.getExplosionActif() ) {
				this.setExplosionActif(false);
				GameController.removeInterrupteur(t);
				GameManager.BonusSolo(lvl, t.getX(), t.getY());
				if(lvl != 0){t.explode();}
			}
	}
	}
	
	public void actionPerformed(ActionEvent e) {
		GameController.removeExplosion(this);
		explosiontimer.stop();
		this.setExplosionActif(true);
		n=0;
	}

}
