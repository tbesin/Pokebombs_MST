package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controller.GameController;
import Modele.*;

public class GamePanel extends JPanel {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Aide");
	private JMenuItem item1 = new JMenuItem("Nouvelle partie");
	private JMenuItem item2 = new JMenuItem("Aide");
	
	
	public static ArrayList<Entity> entities = GameController.getEntityList() ;////
	
	public static ArrayList<Bomb> bombs = GameController.getBombList() ;
	static ArrayList<Explosion> explosions = GameController.getExplosionList();
	static ArrayList<Enemy> enemies = GameController.getEnemyList();
	static ArrayList<BriqueIncassable> briqueIncassables =GameController.getBriqueIncassableList();
	public static ArrayList<CaseUpSpeed> speedCases = GameController.getCaseUpSpeedList() ;
	public static ArrayList<CaseUpBomb> bombCases = GameController.getCaseUpBombList() ;
	public static ArrayList<CaseUpLife> lifeCases = GameController.getCaseUpLifeList() ;
	public static ArrayList<Missile> missiles = GameController.getMissileList() ;
	public static ArrayList<Player> players = GameController.getPlayerList() ;
	
	public static ArrayList<BriqueCassable> breakables = GameController.getBreakableList() ; //new !
	public static ArrayList<Trap> traps = GameController.getTrapList() ; //new !
	public static ArrayList<TrapInterruptor> trapInterruptors = GameController.getTrapInterruptorList() ; //new !
	public static ArrayList<Goal> goals = GameController.getGoalList() ; //new !
	
	public static ArrayList<CaseTeleportation> caseTeleportation = GameController.getCaseTeleportationList() ;
	public static ArrayList<Interrupteur> interrupteur = GameController.getInterrupteurList() ;
	public static ArrayList<Monster> monsters = GameController.getMonsterList() ;
	public static ArrayList<PassBomb> passBomb = GameController.getPassBombList() ;
	public static ArrayList<CasePousseBomb> casePousseBomb = GameController.getCasePousseBombList() ;

	
	
	//Utiliser entity !!!
	
	//constructeur
	public GamePanel(){			
		
	}
	
	public void draw(Graphics2D g2d, Image image, int posX, int posY){
		g2d.drawImage(image, posX, posY, null);
	}
	
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g ;
		ImageIcon bg = new ImageIcon("map_herbe.png");		//le background
		draw(g2d , bg.getImage(), 0, 0);
		
		int intx = (int) Math.ceil(600/15);				//ne pas utiliser abusivement
		int inty = (int) Math .ceil(600/15);
		
		
		//tout
		for(int i = 0 ; i < entities.size() ; i++){
			Entity cus = entities.get(i);
			draw(g2d, cus.getImg(), cus.getX(), cus.getY() );
		}
		
		/*
		//les cases + vitesse
		for(int i = 0 ; i < speedCases.size() ; i++){
			CaseUpSpeed cus = speedCases.get(i);
			draw(g2d, cus.getCaseUpSpeedImg(), cus.getX(), cus.getY() );
		}
		
		//les cases + vie
		for(int i = 0 ; i < lifeCases.size() ; i++){
			CaseUpLife cul = lifeCases.get(i);
			draw(g2d, cul.getCaseUpLifeImg(), cul.getX(), cul.getY() );
		}
		
		//les cases + bombes
		for(int i = 0 ; i < bombCases.size() ; i++){
			CaseUpBomb cub = bombCases.get(i);
			draw(g2d, cub.getCaseUpBombImg(), cub.getX(), cub.getY() );
		}
		
		//les pièges
		for(int i = 0 ; i < traps.size() ; i++ ){
			Trap t= traps.get(i);
			//int intX = (int) Math.ceil(600/15);
			//int intY = (int) Math .ceil(600/15);
			g2d.drawImage(t.getTrapImg(), t.getX(), t.getY(),null);
			//g2d.draw(t.getBounds()); //
		}
		
		//les interrupters qui détruisent les pièges
		for(int i = 0 ; i < trapInterruptors.size() ; i++ ){
			TrapInterruptor ti= trapInterruptors.get(i);
			//int intX = (int) Math.ceil(600/15);
			//int intY = (int) Math .ceil(600/15);
			g2d.drawImage(ti.getTrapInterruptorImg(), ti.getX(), ti.getY(),null);
			//g2d.draw(t.getBounds()); //
		}
		
		//les buts
		for(int i = 0 ; i < goals.size() ; i++ ){
			Goal gl = goals.get(i);
			//int intX = (int) Math.ceil(600/15);
			//int intY = (int) Math .ceil(600/15);
			g2d.drawImage(gl.getGoalImg(), gl.getX(), gl.getY(),null);
			//g2d.draw(t.getBounds()); //
		}
		
		
		
		//les ennemis
		for(int i = 0 ; i < enemies.size() ; i++ ){
			Enemy tempEnemy = enemies.get(i);
			int intX = (int) Math.ceil(600/15);
			int intY = (int) Math .ceil(600/15);
			g2d.drawImage(tempEnemy.getEnemyImg(), tempEnemy.getX(), tempEnemy.getY(),intX,intY,null);
		}
		
		//les briques cassables
		for(int i = 0 ; i < breakables.size() ; i++ ){
			BriqueCassable bc= breakables.get(i);
			int intX = (int) Math.ceil(600/15);
			int intY = (int) Math .ceil(600/15);
			g2d.drawImage(bc.getBriqueCassableImg(), bc.getX(), bc.getY(),intX,intY,null);
		}
		
		
		
		//les briques incassables
		for(int i = 0 ; i < briqueIncassables.size() ; i++){
			BriqueIncassable b = briqueIncassables.get(i);
			g2d.drawImage( b.getBriqueIncassableImg(),b.getX(),b.getY(),null );
			//g2d.draw(b.getBounds()); 
		}
		
		//les missiles
		for(int i = 0 ; i < missiles.size() ; i++){
			Missile m = missiles.get(i);
			draw(g2d, m.getMissileImg(), m.getX(), m.getY() );
		}
		
		for(int i = 0 ; i < caseTeleportation.size() ; i++){
			CaseTeleportation ct = caseTeleportation.get(i);
			g2d.drawImage( ct.getCaseTeleportationImg(ct.getTeleportationIn()),ct.getX(),ct.getY(), intx, inty,null );
			//g2d.draw(ct.getBounds());
		}
		for(int i = 0 ; i < interrupteur.size() ; i++){
			Interrupteur inter = interrupteur.get(i);
			g2d.drawImage( inter.getInterrupteurImg(inter.getInterrupteurOn()),inter.getX(),inter.getY(), intx, inty,null );	
			//g2d.draw(inter.getBounds());
		}
		for(int i = 0 ; i < monsters.size() ; i++){
			Monster monster= monsters.get(i);
			g2d.drawImage( monster.getMonsterImg(),monster.getX(),monster.getY(), intx, inty,null );	
			//g2d.draw(monster.getBounds());
	}
		for(int i = 0 ; i < explosions.size() ; i++){
			Explosion ex = explosions.get(i);
			g2d.drawImage( ex.getExplosionImg(),ex.getX(),ex.getY(), intx-20, inty-20,null );
			//g2d.draw(ex.getBounds());
		}
		
		for(int i = 0 ; i < bombs.size() ; i++){
			Bomb b = bombs.get(i);
			g2d.drawImage(b.getBombImg(), b.getX(), b.getY(),intx-10,inty-10,null);
			//g2d.draw(b.getBounds());
		}
		for(int i = 0 ; i < passBomb.size() ; i++ ){
			PassBomb pb = passBomb.get(i);
			g2d.drawImage(pb.getPassBombImg(), pb.getX()+5, pb.getY()+5,null);
			//g2d.draw(pb.getBounds());
		}
		for(int i = 0 ; i < casePousseBomb.size() ; i++ ){
			CasePousseBomb cpb = casePousseBomb.get(i);
			g2d.drawImage(cpb.getCasePousseBombImg(), cpb.getX()+5, cpb.getY()+5,null);
			//g2d.draw(cpb.getBounds());
		}*/
		//les joueurs
				for(int i = 0 ; i < players.size() ; i++ ){
					Player tempPlayer = players.get(i);
					//g2d.draw(tempPlayer.getBounds()); //
					g2d.drawImage(tempPlayer.getPlayerImg(), tempPlayer.getX(), tempPlayer.getY(), null) ;					//intX-10,intY-10,null);
				}
	}
	

		
		
	}


