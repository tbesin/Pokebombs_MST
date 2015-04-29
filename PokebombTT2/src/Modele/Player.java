package Modele;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Controller.GameController;


public class Player extends Entity {
	
	// ATTRIBUTS
	int velX= 0 , velY = 0 ;
	int speed = 2 ;
	int bomb =10;
	int life = 1;
	int canGo ;// se dŽplacer
	boolean playerGoBomb = false; //passer a travers les bombes
	boolean actif = true;
	boolean playerPoseBomb = false;// pouvoir traverser la bombe
	int playerNumber = 1 ;		//permet de déterminer l'image du joueur
	int n=0;// ˆ rŽflechir mode solo
	boolean pousseBomb=false;
	boolean interrupteurUse = true;
	boolean playerGoTrap = false;
	String direction = "Sud" ;
	
	//CONSTRUCTEUR
	public Player(int x, int y, int playerNumber) {
		super(x, y);
		this.playerNumber = playerNumber ;
	}
	
	
	
	//ACCESSEURS
	
		public int getSpeed(){
			return this.speed ;
		}
		public int getBomb(){
			return this.bomb;
		}
		public int getLife(){
			return this.life;
		}
		public int getVelX(){
			return this.velX ;
		}
		
		public int getVelY() {
			return this.velY ;
		}
		public int getCanGo(){
			return this.canGo ;
		}
		public boolean getPlayerGoBomb(){
			return this.playerGoBomb;
		}
		
		public boolean getPlayerPoseBomb(){
			return this.playerPoseBomb;
		}
		public boolean getActif(){
			return this.actif;
		}
		public String getDirection() {
			return this.direction ;
		}
		public boolean getPousseBomb(){
			return this.pousseBomb;
		}
		public boolean getInterrupteurUse(){
			return this.interrupteurUse ;
		}
		public boolean getPlayerGoTrap(){
			return this.playerGoTrap;
		}
		
		
		
		public void setSpeed(int newSpeed){
			this.speed = newSpeed;
		}
		public void setBomb(int newBomb){
			this.bomb= newBomb;
		}
		public void setVelX(int newVelX){
			this.velX = newVelX;
		}
		
		public void setVelY(int newVelY){
			this.velY = newVelY;
		}
		
		public void setCanGo(int bool){
			this.canGo = bool ;
		}
		public void setPlayerGoBomb(boolean bool){
			this.playerGoBomb = bool;
		}
		public void setPlayerPoseBomb(boolean bool){
			this.playerPoseBomb =bool;
		}
		public void setActif(boolean bool){
			this.actif = bool;
		}
		public void setLife(int newlife){
			this.life= newlife;
		}
		public void setDirection(String newDirection){
			this.direction = newDirection ;
		}
		public void setPousseBomb(boolean bool){
			this.pousseBomb = bool;
		}
		public void setInterrupteurUse(boolean bool){
			this.interrupteurUse = bool;
		}
		public void setPlayerGoTrap(boolean bool){
			this.playerGoTrap = bool;
		}

	
	
	
	
	public void setPlayerNumber(int playerNumber){
		this.playerNumber = playerNumber;
	}
	
	public int getPlayerNumber(){		//new !
		return this.playerNumber ;
	}
	
	//MISE A JOUR DU PERSO							///
	public void update(){		
		
		nearPlayer();
		checkLimite();
		checkLife();
		if(canGo == 0){
			this.setX(x + velX);			//x += velX;
			this.setY(y + velY);			//y += velY;
		}
	}
	
	
	//pour les images du perso
	public Image getPlayerImg(){
		ImageIcon ic = new ImageIcon("Player1down1.png");
		if(this.playerNumber == 1){							//joueur 1
			if(direction == "Nord"){
				ic = new ImageIcon("Player1up1.png");
			}
			else if(direction == "Ouest"){
				ic = new ImageIcon("Player1left1.png");
			}
			else if(direction == "Est"){
				ic = new ImageIcon("Player1right1.png");
			}
			
			if(this.speed > 2){					//pour le vélo (perte de précision avec la taille du getBounds()
				if(direction == "Sud"){
					ic = new ImageIcon("Player1velo_down1.png");
				}
				else if(direction == "Nord"){
					ic = new ImageIcon("Player1velo_up1.png");
				}
				else if(direction == "Ouest"){
					ic = new ImageIcon("Player1velo_left1.png");
				}
				else if(direction == "Est"){
					ic = new ImageIcon("Player1velo_right1.png");
				}
			}
		}
		
		
		if(this.playerNumber == 2){							//joueur 2
			if(direction == "Sud"){
				ic = new ImageIcon("Player2down1.png");
			}
			else if(direction == "Nord"){
				ic = new ImageIcon("Player2up1.png");
			}
			else if(direction == "Ouest"){
				ic = new ImageIcon("Player2left1.png");
			}
			else if(direction == "Est"){
				ic = new ImageIcon("Player2right1.png");
			}
		}
		
		if(this.playerNumber == 3){							//joueur 3
			if(direction == "Sud"){
				ic = new ImageIcon("Player2down1.png");
			}
			else if(direction == "Nord"){
				ic = new ImageIcon("Player2up1.png");
			}
			else if(direction == "Ouest"){
				ic = new ImageIcon("Player2left1.png");
			}
			else if(direction == "Est"){
				ic = new ImageIcon("Player2right1.png");
			}
		}
		
		return ic.getImage();
	}
	
	
	
	

	public void nearPlayer(){
		canGo = 0 ;
		int n = 0;
		ArrayList<Trap> traps = GameController.getTrapList();
		ArrayList<Entity> entities = GameController.getEntityList() ;
		ArrayList<Interrupteur> interrupteur = GameController.getInterrupteurList();
		for(int j = 0 ; j < entities.size(); j++){
			Entity ent = entities.get(j) ;
			if( this.getBounds().intersects(ent.getBounds() ) ){
				ent.interact(this);
			}
		}
		for(int j = 0 ; j < interrupteur.size(); j++){
			Interrupteur inter = interrupteur.get(j) ;
			if( this.getBounds().intersects(inter.getBounds() ) == false){
				n++;
		}
		}
			if (n==interrupteur.size())this.setInterrupteurUse(true);
			for (int i = 0; i< traps.size();i++){
				Trap tr = traps.get(i);
				if (this.getBounds().intersects(tr.getBounds())==false){
					this.setPlayerGoTrap(false);
				}
		}
	}

			
	
	
	public Rectangle getBounds(){	
	//	return new Rectangle(x+velX , y+velY, this.getPlayerImg().getWidth(null), this.getPlayerImg().getHeight(null) ) ;				//30, 30);
		return new Rectangle(x+velX , y+velY,25, 33) ;	
	}
	
	
	public void checkLimite(){
		String mode = "multi";
		if(mode =="multi"){
		if (life>0){
		if (x>=560) x=560;
		if (y>=560) y=560;
		}
		}
		if (mode == "solo"){
		if (x>=160) x=160;
		if (y>=160) y=160;
		}
		if (x<=0) x =0;
		if (y<=0) y=0;
	}
	

	public void checkLife(){
		//if(life==1 && n==0 ){x=0;y=0;n=1;}// mode solo
		if (life<1){setActif(false); x=1000; y =10000;}
	}
	
	
	public void dropBomb(int posX, int posY){//dépose une bombe
		int goodX = goodPosition(posX+12,5);
		int goodY = goodPosition(posY+17,5);
		if (this.getBomb()>0){
			GameController.bombs.add(new Bomb(goodX,goodY, this));
			this.setBomb(this.getBomb() - 1);
			this.setPlayerPoseBomb(true);
			}
		//else this.setPlayerPoseBomb(false);
	}
	
	
	public int goodPosition(int pos,int nb){
		int tempPos = (int) Math.ceil(pos*nb/200);
		int goodPos = tempPos*(600/15)+5;
		return goodPos;
	}
	
	public void launchMissile(int posX, int posY, String direction){			//lance un missile
		GameController.missiles.add(new Missile(posX,posY,direction));
	}
	
	
	//MOUVEMENT du perso			-----> ajouter les sprites
	public void moveUp(){
		velY = -speed ;
		this.setDirection("Nord");
	}
	
	public void moveDown(){
		this.velY = speed ;
		this.setDirection("Sud");
	}
	
	public void moveLeft(){
		velX = -speed ;
		this.setDirection("Ouest");
	}
	
	public void moveRight(){
		velX = speed ;
		this.setDirection("Est");
	}

	public void interact(CaseTeleportation ct){	
		Random rand = new Random();
		ArrayList<CaseTeleportation> caseTeleportation= GameController.getCaseTeleportationList() ;
		ArrayList a = new ArrayList();
		if (ct.getTeleportationIn()){
			int i =0;
			while (i < caseTeleportation.size()){
			if (caseTeleportation.get(i).getTeleportationIn()==false){
				a.add(i);
			}
			i++;
			}
			int j=rand.nextInt(a.size());
			this.setX(caseTeleportation.get((Integer) a.get(j)).getX());
			this.setY(caseTeleportation.get((Integer) a.get(j)).getY());
			}
		}
	/*
	public void interact(Bomb b){	
		b.setCanGoBomb(1);
		//if (p.getPlayerGo()){p.setCanGo(1);p.setPlayerGo(false);n=0;}
		//if (this.getPlayerGoBomb()==false) this.setCanGo(1);
		//else if (this.getPousseBomb()&& this.getCanGo()==1){
			b.setDirectionBomb(this.getDirection());
		}
	}
	*/

}
	

