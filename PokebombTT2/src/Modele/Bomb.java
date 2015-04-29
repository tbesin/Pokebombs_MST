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
	int n=0;
	int canGoBomb;// le bomb peut se dŽplacer
	int velX=0; int velY=0;
	
	//constructeur
	public Bomb(int x, int y, Player player) {
		super(x, y);
		this.player = player ;
		this.playerNumber = this.player.getPlayerNumber() ;
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
		checkGoBomb(player);
		checkPousseBomb(player);
		if (this.canGoBomb == 0) moveBomb();
		if (GameController.bombPose=true && n==0){missiletimer = new Timer(3000,this);missiletimer.start();}
		n++;
		}
	
	public static Image getBombImg(){
		ImageIcon ic = new ImageIcon("pokeball.png");
		return ic.getImage();
	}
	
	public Rectangle getBounds(){
		return new Rectangle(x+velX, y+velY, getBombImg().getWidth(null), getBombImg().getHeight(null));
	}
	
	public void checkGoBomb(Player p){
		if (p.getPlayerPoseBomb() && p.getX() > x-25 && p.getX()< x+30 && p.getY()>y-32 && p.getY()<y+32) p.setPlayerGoBomb(true);
		else p.setPlayerGoBomb(false);
	}
	
	public void checkPousseBomb(Player p){
		//System.out.println(this.directionBomb);
		if(p.getPousseBomb()&& this.directionBomb != null && this.canGoBomb==0){
			if(this.directionBomb=="Ouest") this.velX= -4;
			if(this.directionBomb=="Est") this.velX= 4;
			if(this.directionBomb=="Sud") this.velY= 4;
			if(this.directionBomb=="Nord") this.velX= -4;
		}
		nearBomb();
		//checkLimite();
	}

	public void moveBomb(){
		if( velX != 0) {this.velY=0;}
		if (velY !=0) {this.velX=0;}
		this.setX(getX()+velX);
		this.setY(getY()+velY);
	}
	
	public void explode(){
		x=  x -5;
		y = y -5;
		//this.getPlayer().setBomb(this.getPlayer().getBomb() + 1);
		GameController.removeBomb(this);
		GameController.addExplosion(new Explosion(x,y,2,this));
		GameController.addExplosion(new Explosion(x-40,y,3,this));
		GameController.addExplosion(new Explosion(x+40,y,3,this));
		//if (this.getDirectionBomb() == null) 
		GameController.addExplosion(new Explosion(x,y-40,4,this));
		GameController.addExplosion(new Explosion(x,y+40,4,this));
		//GameController.addExplosion(new Explosion(x-40,y));
		//GameController.addExplosion(new Explosion(x+40,y));
		//GameController.addExplosion(new Explosion(x,y-40));
		//GameController.addExplosion(new Explosion(x,y+40));
		n=0;
		missiletimer.stop();
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		explode();
		missiletimer.stop();
	}

public void checkLimite(){
	//if (x>=560) x=560;
	if (x>=160) x=160;
	if (x<=0) x =0;
	//if (y>=560) y=560;
	if (y>=160) y=160;
	if (y<= 13) y= 13;
}


public void nearBomb(){
	canGoBomb = 0 ;
	ArrayList<Entity> entities = GameController.getEntityList() ;
	ArrayList<Player> players = GameController.getPlayerList() ;
	for(int j = 0 ; j < entities.size(); j++){
		Entity ent = entities.get(j) ;
		if( this.getBounds().intersects(ent.getBounds() )&& this.directionBomb == null) {
			ent.interact(this);
		}
		if( this.getBounds().intersects(ent.getBounds() )&& this.directionBomb != null ) {
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
	//System.out.println(p.getPousseBomb());
	//if (p.getPlayerGo()){p.setCanGo(1);p.setPlayerGo(false);n=0;}
	if (p.getPlayerGoBomb()==false) p.setCanGo(1);
	if (p.getPousseBomb()&& p.getCanGo()==1){
		this.directionBomb = p.getDirection();
	}
}


public int goodPosition(int pos,int nb){
	int tempPos = (int) Math.ceil(pos*nb/200);
	int goodPos = tempPos*(600/15)+5;
	return goodPos;
}

public void interact(CaseTeleportation ct){	
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
