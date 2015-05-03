package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import Controller.GameController;


public class Bomb extends Entity implements ActionListener {
	
	//attributs
	private Timer missiletimer;
	public Player player ;
	private int playerNumber ;
	private String directionBomb;
	int n=0;						//gère la différence entre les deux update
	int canGoBomb;// le bomb peut se dŽplacer
	int velX=0; int velY=0;
	
	//String mode ;		//changement cf setMode()
	
	
	
	
	//constructeur
	public Bomb(int x, int y, Player player) {
		super(x, y);
		this.player = player ;
		this.playerNumber = this.player.getPlayerNumber() ;
		this.setMode(this.player.getMode()) ;		//new
		}
	
	
	// accesseur 
	
	
	public Player getPlayer(){
		return this.player;
	}
	
	public int getn(){
		return this.n;
	}
	
	public String getDirectionBomb(){
		return this.directionBomb;
	}
	
	public void setn(int newn){
		this.n = newn;
	}
	
	public void setCanGoBomb(int y){
		this.canGoBomb= y;
	}

	public void setDirectionBomb(String direc){
		this.directionBomb = direc;
	}
	
	public void update(){
		checkLimite();
		
		checkGoBomb(this.player);//vérifie si le perso peut traverser la bombe
		checkPousseBomb(this.player);//vérifie si le perso peut pousser la bombe
		if (this.canGoBomb == 0) moveBomb();
		if (GameController.bombPose=true && n==0){
			missiletimer = new Timer(2000,this);
			missiletimer.start();
			}
		n++;
		}
	
	public Image getImg(){
		ImageIcon ic = new ImageIcon("pokeball.png");
		return ic.getImage();
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x+velX, y+velY, getImg().getWidth(null), getImg().getHeight(null));
	}
	
	public void checkGoBomb(Player p){
		if (p.getPlayerPoseBomb() && p.getX() > x-25 && p.getX()< x+30 && p.getY()>y-32 && p.getY()<y+32) p.setPlayerGoBomb(true);
		else p.setPlayerGoBomb(false);
	}
	
	public void checkPousseBomb(Player p){
		if(p.getPousseBomb()&& this.directionBomb != null && this.canGoBomb==0){
			if(this.directionBomb=="Ouest") this.velX=-8;
			if(this.directionBomb=="Est") this.velX=8;
			if(this.directionBomb=="Sud") this.velY=8;
			if(this.directionBomb=="Nord") this.velY=-8;
		}
		nearBomb();
		checkLimite();
	}

	public void moveBomb(){
		if( velX != 0) {this.velY=0;}
		if (velY !=0) {this.velX=0;}
		this.setX(getX()+velX);
		this.setY(getY()+velY);
	}
	
	public void explode(){		///ajouter les levels de la bombe
		/*x=  x -5;
		y = y -5;*/
		if(mode == "multi"){
			this.getPlayer().setBomb(this.getPlayer().getBomb() + 1);
		}
		
		GameController.removeBomb(this);
		GameController.addExplosion(new Explosion(x -5,y -5,2,this));
		GameController.addExplosion(new Explosion(x-45,y -5,3,this));
		GameController.addExplosion(new Explosion(x+35,y -5,3,this));
		GameController.addExplosion(new Explosion(x -5 ,y-45,4,this));
		GameController.addExplosion(new Explosion(x-5,y+35,4,this));
		//GameController.addExplosion(new Explosion(x-40,y));
		//GameController.addExplosion(new Explosion(x+40,y));
		//GameController.addExplosion(new Explosion(x,y-40));
		//GameController.addExplosion(new Explosion(x,y+40));
		n=0;
		//missiletimer.stop();			//on ne sait pas pk ...
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		explode();
		missiletimer.stop();
	}



	public void nearBomb(){
		canGoBomb = 0 ;
		ArrayList<Entity> entities = GameController.getEntityList() ;
		ArrayList<Player> players = GameController.getPlayerList() ;
		for(int j = 0 ; j < entities.size(); j++){
			Entity ent = entities.get(j) ;
			/*if( this.getBounds().intersects(ent.getBounds() )&& this.directionBomb == null) {
				ent.interact(this);
			}
			if( this.getBounds().intersects(ent.getBounds() )&& this.directionBomb != null ) {
				ent.interact(this);
			}*/
			
			if( this.getBounds().intersects(ent.getBounds() ) ) {			///à vérifier
				ent.interact(this);
			}
			
		}
		for (int i=0; i< players.size();i++){
			Player tempPlayer = players.get(i);
			if( this.getBounds().intersects(tempPlayer.getBounds() ) && tempPlayer.getPlayerGoBomb() ){
				//tempPlayer.interact(this);
				this.setCanGoBomb(1);
			}
		}
	}


	public void interact(Player p){	
		if (p.getPlayerGoBomb()==false) {
			p.setCanGo(1);
		}
		if (p.getPousseBomb()&& p.getCanGo()==1){
			this.directionBomb = p.getDirection();
		}
	}


	public int goodPosition(int pos,int nb){
		int tempPos = (int) Math.ceil(pos*nb/200);
		int goodPos = tempPos*(600/15)+5;
		return goodPos;
	}

	public void interact(CaseTeleportation ct){	// à bouger si changement du controleur
		Random rand = new Random();
		ArrayList<CaseTeleportation> caseTeleportation= GameController.getCaseTeleportationList() ;
		ArrayList a = new ArrayList();
		if (ct.getTeleportationIn()&& caseTeleportation.size()>1){
			int i =0;
			while (i < caseTeleportation.size()){
			if (caseTeleportation.get(i).getTeleportationIn()==false){
				a.add(i);
			}
			i++;
			}
			int j=rand.nextInt(a.size());
			this.setX(goodPosition(caseTeleportation.get((Integer) a.get(j)).getX(),5));// gŽnŽraliser
			this.setY(goodPosition(caseTeleportation.get((Integer) a.get(j)).getY(),5));
			}
		}
	}
