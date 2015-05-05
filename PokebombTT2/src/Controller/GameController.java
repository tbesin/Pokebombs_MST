package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;
//import javax.swing.Timer;











import Modele.*;


public class GameController {	//implements KeyListener {
	
	//Timer mainTimer ;
	
	static int breakableCount = 5;		//utilité ?
	static int enemyCount = 5;			//utilité ?
	public static int  level = 1 ;		//utilité ?
	public static boolean bombPose = false;	//Ca doit se trouver ici ?
	static Random rand = new Random();
	
	static String mode ; //new !
	
	
	
	public static ArrayList<Entity> entities = new ArrayList<Entity>() ;
	public static ArrayList<Player> players = new ArrayList<Player>();
	
	
	public static ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	public static ArrayList<Bomb> bombs = new ArrayList<Bomb>();
	public static ArrayList<Explosion> explosions = new ArrayList<Explosion>();
	static ArrayList<BriqueIncassable> briqueIncassables = new ArrayList<BriqueIncassable>();
	public static ArrayList<CaseUpSpeed> speedCases = new ArrayList<CaseUpSpeed>() ;
	public static ArrayList<CaseUpBomb> bombCases = new ArrayList<CaseUpBomb>() ;
	public static ArrayList<CaseUpLife> lifeCases = new ArrayList<CaseUpLife>() ;
	public static ArrayList<Missile> missiles = new ArrayList<Missile>();	
	public static ArrayList<BriqueCassable> breakables = new ArrayList<BriqueCassable>(); //new !
	public static ArrayList<Trap> traps = new ArrayList<Trap>(); //new !
	public static ArrayList<TrapInterruptor> trapInterruptors = new ArrayList<TrapInterruptor>(); //new !
	public static ArrayList<Goal> goals = new ArrayList<Goal>();	//new!
	public static ArrayList<CaseTeleportation> caseTeleportation = new ArrayList<CaseTeleportation>() ;
	public static ArrayList<Interrupteur> interrupteur = new ArrayList<Interrupteur>() ;
	public static ArrayList<Monster> monsters = new ArrayList<Monster>() ;
	public static ArrayList<PassBomb> passBomb = new ArrayList<PassBomb>();
	public static ArrayList<CasePousseBomb> casePousseBomb= new ArrayList<CasePousseBomb>();
	
	
	
	public static ArrayList tableauEnemies = new ArrayList();		//what ?
	public static ArrayList tableauBriqueIncassable = new ArrayList();
	
	
	
	
	//constructeur va changer par la suite
	public GameController(){						
		this.clearAllLists();
	}
		

	/*
	//ELEMENTS A RESTRUCTURER ?
	public static ArrayList listeCoord(int nb){
		ArrayList a = new ArrayList();
		for (int i =0; i<nb;i++){
			for (int j =0; j<nb;j++){
				ArrayList p = new ArrayList();p.add(i);p.add(j);a.add(p);
			}
		}
		return a;
	}
	
	
	// bonus
	public static int choix() {
		int n = rand.nextInt(100);
		return n;
	}
	
	// Case teleportation a gŽrŽ
	public static void Bonus(int b, int X, int Y){
		if (b>=0 && b<4) GameController.addCaseUpSpeed(new CaseUpSpeed (X,Y));
		if (b>4 && b<20) GameController.addCaseUpBomb(new CaseUpBomb(X,Y));
		if (b>20 && b<29) GameController.addCaseUpLife(new CaseUpLife(X,Y));
		if (b>29 && b<35) GameController.addCasePousseBomb(new CasePousseBomb(X,Y));
		if  (b>35 && b<40) GameController.addInterrupteur(new Interrupteur(X,Y));
		if (b>40 && b<60)  GameController.addTrap(new Trap(X,Y));
		if (b>60 && b<70) GameController.addTrapInterruptor(new TrapInterruptor(X,Y));
		if (b>70 && b<90) GameController.addCaseTeleportation(new CaseTeleportation(X,Y));
	}*/
	
	
/*	public void checkEnd(){  //à modifier
		if(enemies.size() == 0){
			level++ ;
			enemies.clear();
			bombs.clear();
			JOptionPane.showMessageDialog(null, "Good work, you've completed level" + (level-1) + ". Let's move on the next one !");
			startGame(1);	
		}
	}*/
	
	
	
	
	
	
	
	/*

	//DEMARRAGE DU JEU		==> reste à gérer la fin
	
	
	
	//mode multi
	public static void startGame(int a, int player1img,int player2img,int player3img,int player4img, String choosenlevel){
		
		ModeMulti multi = new ModeMulti(a, choosenlevel, player1img, player2img, player3img, player4img);
		multi.startGame() ;
		mode = "multi";
		
		
		entities.addAll(multi.entities);
	}
		
	
	


	//mode solo

	public static void startGameSolo(String choosenlevel, int playerImg){*/
		/*ArrayList tableau = listeCoord(5);
		Player player= new Player(0,0,1);
		player.setPousseBomb(true);
		player.setLife(2);
		players.add(player);
		addBriqueIncassable(new BriqueIncassable (1*(200/5),0*(600/5)));
		addBriqueIncassable(new BriqueIncassable (3*(200/5),1*(200/5)));
		addBriqueIncassable(new BriqueIncassable (2*(200/5),2*(200/5)));
		addBriqueIncassable(new BriqueIncassable (2*(200/5),3*(200/5)));
		addBriqueIncassable(new BriqueIncassable (2*(200/5),4*(200/5)));
		addBriqueIncassable(new BriqueIncassable (4*(200/5),2*(200/5)));
		addBriqueIncassable(new BriqueIncassable (4*(200/5),3*(200/5)));
		addEnemy(new Enemy(0*(200/5),3*(200/5)));
		addEnemy(new Enemy(3*(200/5),0*(200/5)));
		addEnemy(new Enemy(4*(200/5),1*(200/5)));
		addEnemy(new Enemy(3*(200/5),3*(200/5)));
		addCaseTeleportation(new CaseTeleportation(2*(200/5),1*(200/5)));
		addCaseTeleportation(new CaseTeleportation(3*(200/5),2*(200/5)));
		for(int i = 0 ; i < caseTeleportation.size() ; i++){
			CaseTeleportation ct = caseTeleportation.get(i);
			if (i%2 != 0) ct.setTeleportationIn(false);
		}
		addInterrupteur(new Interrupteur(0*(200/5),4*(200/5)));
		addInterrupteur(new Interrupteur(4*(200/5),4*(200/5)));
		addMonster(new Monster(1*(200/5),4*(200/5)));
		addTrap(new Trap(2*(200/5),0*(200/5)));*/
		
		/*ModeSolo solo = new ModeSolo(choosenlevel, playerImg);
		solo.startGame() ;
		mode = "solo";
		
		entities.addAll(solo.entities);//new
		
		//System.out.println(entities.size());*/
		
		/*for(int i = 0 ; i < entities.size() ; i++){//new
			entities.get(i).setMode("solo");
		}*/
		
		/*for(int i = 0 ; i < caseTeleportation.size() ; i++){		//à déplacer
			CaseTeleportation ct = caseTeleportation.get(i);
			if (i%2 != 0) ct.setTeleportationIn(false);
		}
		
	}
	
	
	
	public static void startGameSoloTuto(){		//voir avec les fichiers
		ArrayList tableau = listeCoord(5);
		players.add(new Player(0,0,1));
		//players.add(new Player(2*(200/5),0));
		//addBriqueIncassable(new BriqueIncassable (1*(200/5),0*(600/5)));
		
		addBriqueIncassable(new BriqueIncassable (1*(200/5),0*(200/5)));
		addBriqueIncassable(new BriqueIncassable (3*(200/5),3*(200/5)));
		addBriqueIncassable(new BriqueIncassable (4*(200/5),0*(200/5)));
		addBriqueIncassable(new BriqueIncassable (2*(200/5),1*(200/5)));
		addBriqueIncassable(new BriqueIncassable (0*(200/5),3*(200/5)));
		addBriqueIncassable(new BriqueIncassable (3*(200/5),4*(200/5)));
		addBriqueIncassable(new BriqueIncassable (3*(200/5),1*(200/5)));
		addBriqueIncassable(new BriqueIncassable (2*(200/5),3*(200/5)));
		addGoal(new Goal (3*(200/5),0*(200/5)));
		addCaseUpBomb(new CaseUpBomb (1*(200/5),4*(200/5)));
		addCaseUpLife(new CaseUpLife (0*(200/5),4*(200/5)));
		addCasePousseBomb(new CasePousseBomb ((1*200/5),3*(200/5)));
		addMonster(new Monster(4*(200/5),4*(200/5)));
		addPassBomb(new PassBomb(2*(200/5),2*(200/5)));
		addBreakable(new BriqueCassable(4*(200/5),2*(200/5)));
		addBreakable(new BriqueCassable(1*(200/5),2*(200/5)));
		addInterrupteur(new Interrupteur(4*(200/5),1*(200/5)));
		addCaseTeleportation(new CaseTeleportation(2*(200/5),0*(200/5)));
		addCaseTeleportation(new CaseTeleportation(2*(200/5),4*(200/5)));
		for(int i = 0 ; i < caseTeleportation.size() ; i++){
			CaseTeleportation ct = caseTeleportation.get(i);
			if (i%2 != 0){
				ct.setTeleportationIn(false);
			}
		}
	}

	
	
	//pour les bonus des niveaux de Minh Huy
	public static void BonusSolo(int lvl, int X, int Y){
		if (lvl == 1){ if (X ==0*(200/5) && Y == 3*(200/5)){GameController.addCaseUpBomb(new CaseUpBomb(X,Y));}}
		if (lvl == 1){ if (X ==3*(200/5) && Y == 3*(200/5)){GameController.addCaseUpBomb(new CaseUpBomb(X,Y));}}
		if (lvl == 1){ if (X==3*(200/5) && Y == 0*(200/5)){GameController.addTrap(new Trap(X,Y));}}
		if (lvl == 1){ if (X ==4*(200/5) && Y == 4*(200/5)){GameController.addCaseUpLife(new CaseUpLife(X,Y));}}
		//if (lvl == 0){if (X==4*(200/5) && Y == 2*(200/5)){GameController.addInterrupteur(new Interrupteur(X,Y));}}
		if (lvl == 0){ if (X ==1*(200/5) && Y == 2*(200/5)){GameController.addCaseUpBomb(new CaseUpBomb(X,Y));}}
		if (lvl == 0){ if (X ==0*(200/5) && Y == 2*(200/5)){GameController.addCaseUpBomb(new CaseUpBomb(X,Y));}}
	}
	
	
	
	
	
	
//fin mode solo		
	
	
	
	
	
	//MISE A JOUR DU PROGRAMME
	public void update(){	
		entities.clear();	
	
		entities.addAll(goals);	
		entities.addAll(breakables);	
		entities.addAll(trapInterruptors);
		entities.addAll(enemies);
		entities.addAll(bombs);
		entities.addAll(explosions);
		entities.addAll(briqueIncassables);
		entities.addAll(speedCases);
		entities.addAll(bombCases);
		entities.addAll(missiles);
		entities.addAll(lifeCases);
		entities.addAll(caseTeleportation);
		entities.addAll(interrupteur);
		entities.addAll(monsters);
		entities.addAll(traps);
		entities.addAll(passBomb);
		entities.addAll(casePousseBomb);
		
		entities.addAll(players);//essai
		
		for(int i = 0 ; i < caseTeleportation.size() ; i++){//vérifie que les téléporteurs fonctionnent par paires
			CaseTeleportation ct = caseTeleportation.get(i);
			if (i%2 != 0){
				ct.setTeleportationIn(false);
			}
		}
		
		for(int i = 0 ; i < entities.size() ; i++){
			Entity ent = entities.get(i);
			ent.update();
		}
		
		checkEnd();
		
		}
	
	
		
	public void checkEnd(){		//à terminer
		if(mode == "multi"){
			if(players.size() == 1){
				JOptionPane.showMessageDialog(null, "Il ne reste plus qu'un seul joueur, le jeu est terminé !" );
				//il faut encore fermer la fenêtre	
			}
		}
		
		if (mode == "solo"){	//à compléter
		}
	}
	
	
	
	
	//INTERACTIONS PAR CLAVIER
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		ArrayList<Player> players = GameController.players ;
		
		// player 1
		if(key == KeyEvent.VK_Z) players.get(0).moveUp();
		else if(key == KeyEvent.VK_S) players.get(0).moveDown() ;
		else if(key == KeyEvent.VK_Q) players.get(0).moveLeft() ;
		else if(key == KeyEvent.VK_D) players.get(0).moveRight();
		
		else if(key == KeyEvent.VK_SPACE){players.get(0).dropBomb(players.get(0).getX(), players.get(0).getY());}
		
		//player 2
		else if(key == KeyEvent.VK_O) players.get(1).moveUp();
		else if(key == KeyEvent.VK_L) players.get(1).moveDown() ;
		else if(key == KeyEvent.VK_K) players.get(1).moveLeft() ;
		else if(key == KeyEvent.VK_M) players.get(1).moveRight();
		
		else if(key == KeyEvent.VK_B){players.get(1).dropBomb(players.get(1).getX(), players.get(1).getY());}
		
		// player 3
		else if(key == KeyEvent.VK_UP) players.get(2).moveUp();
		else if(key == KeyEvent.VK_DOWN) players.get(2).moveDown() ;
		else if(key == KeyEvent.VK_LEFT) players.get(2).moveLeft() ;
		else if(key == KeyEvent.VK_RIGHT) players.get(2).moveRight();
		
		else if(key == KeyEvent.VK_ALT){players.get(2).dropBomb(players.get(2).getX(), players.get(2).getY());}
			
	}


	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		//player 1
		if(key == KeyEvent.VK_Z) players.get(0).setVelY(0);			
		else if(key == KeyEvent.VK_S) players.get(0).setVelY(0);			
		else if(key == KeyEvent.VK_Q) players.get(0).setVelX(0);
		else if(key == KeyEvent.VK_D) players.get(0).setVelX(0);
		
		// player 2
		else if(key == KeyEvent.VK_O) players.get(1).setVelY(0);
		else if(key == KeyEvent.VK_L) players.get(1).setVelY(0);
		else if(key == KeyEvent.VK_K) players.get(1).setVelX(0);	
		else if(key == KeyEvent.VK_M) players.get(1).setVelX(0);
		
		// player 3
		else if(key == KeyEvent.VK_UP) players.get(2).setVelY(0);
		else if(key == KeyEvent.VK_DOWN) players.get(2).setVelY(0);
		else if(key == KeyEvent.VK_LEFT) players.get(2).setVelX(0);	
		else if(key == KeyEvent.VK_RIGHT) players.get(2).setVelX(0);	
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	*/
	
	
	
	
	//ACCESSEURS POUR TOUTES LES LISTES
	
	
	//POUR LE JOUEUR
		public static void addPlayer(Player player){
			players.add(player);
			}
		public static void removePlayer(Player player){
			players.remove(player);
			}
		public static ArrayList<Player> getPlayerList(){
			return players;
			}
		
		
		//ENNEMIS
		public static void addEnemy(Enemy e){
			enemies.add(e);
			}
		public static void removeEnemy(Enemy e){
			enemies.remove(e);
			}
			
		public static ArrayList<Enemy> getEnemyList(){
			return enemies;
		}
		
		//BRIQUES CASSABLES
		public static void addBreakable(BriqueCassable bc){
			breakables.add(bc);
			}
		public static void removeBreakable(BriqueCassable bc){
			breakables.remove(bc);
			}
		public static ArrayList<BriqueCassable> getBreakableList(){
			return breakables;
			}
		
		//PIEGES
		public static void addTrap(Trap t){
			traps.add(t);
		}
		public static void removeTrap(Trap t){
			traps.remove(t);
		}
		public static ArrayList<Trap> getTrapList(){
			return traps;
		}
		
		//INTERRUPTEURS QUI DETRUISENT LES PIEGES
		public static void addTrapInterruptor(TrapInterruptor ti){
			trapInterruptors.add(ti);
		}
		public static void removeTrapInterruptor(TrapInterruptor ti){
			trapInterruptors.remove(ti);
		}
		public static ArrayList<TrapInterruptor> getTrapInterruptorList(){
			return trapInterruptors;
		}
			
		
		// POUR LES BOMBES
		public static void addBomb(Bomb b){
			bombs.add(b);
		}
		public static void removeBomb(Bomb b){
			bombs.remove(b);
		}
		public static ArrayList<Bomb> getBombList(){
			return bombs;
		}
		
		
		//POUR LES EXPLOSIONS
		public static void addExplosion(Explosion ex){
			explosions.add(ex);
		}
		public static void removeExplosion(Explosion ex){
			explosions.remove(ex);
		}	
		public static ArrayList<Explosion> getExplosionList(){
			return explosions;
		}
		
		// POUR BRIQUES INCASSABLES
		public static void addBriqueIncassable(BriqueIncassable b){
			briqueIncassables.add(b);
		}
		public static ArrayList<BriqueIncassable> getBriqueIncassableList(){
			return briqueIncassables;
		}
		
		//POUR LES ENTITES												///
		public static ArrayList<Entity> getEntityList(){
			return entities;
		}
		
		//POUR LES CASES +SPEED
		public static void addCaseUpSpeed(CaseUpSpeed cus){
			speedCases.add(cus);
		}
				
		public static void removeCaseUpSpeed(CaseUpSpeed cus){
			speedCases.remove(cus);
		}
				
		public static ArrayList<CaseUpSpeed> getCaseUpSpeedList(){
			return speedCases;
		}
			
			
		//POUR LES CASES +BOMB
		public static void addCaseUpBomb(CaseUpBomb cub){
			bombCases.add(cub);
		}
						
		public static void removeCaseUpBomb(CaseUpBomb cub){
			bombCases.remove(cub);
		}
						
		public static ArrayList<CaseUpBomb> getCaseUpBombList(){
			return bombCases;
		}
					
		// POUR LES CASES + LIFE
		public static void addCaseUpLife(CaseUpLife cul){
			lifeCases.add(cul);
		}
						
		public static void removeCaseUpBomb(CaseUpLife cul){
			lifeCases.remove(cul);
		}
						
		public static ArrayList<CaseUpLife> getCaseUpLifeList(){
			return lifeCases;
		}
					
		// POUR LES MISSILES
		public static void addMissile(Missile m){
			missiles.add(m);
		}
						
		public static void removeMissile(Missile m){
			missiles.remove(m);
		}
						
		public static ArrayList<Missile> getMissileList(){
			return missiles;
		}
		
		// POUR LES BUTS
		public static void addGoal(Goal g){
			goals.add(g);
		}
							
		public static void removeGoal(Goal g){
			goals.remove(g);
		}
							
		public static ArrayList<Goal> getGoalList(){
			return goals;
		}
					
					
		
		// POUR CASE TELEPORTATION
		public static void addCaseTeleportation(CaseTeleportation ct){
			caseTeleportation.add(ct);
		}
		
		public static void removeGoal(CaseTeleportation ct){
			caseTeleportation.remove(ct);
		}
		
		public static ArrayList<CaseTeleportation> getCaseTeleportationList(){
			return caseTeleportation;
		}		
				

		// POUR CASE INTERRUPTEUR
		public static void addInterrupteur(Interrupteur inter){
			interrupteur.add(inter);
		}
		public static void removeInterrupteur(Interrupteur inter){
			interrupteur.remove(inter);
		}
			
		public static ArrayList<Interrupteur> getInterrupteurList(){
			return interrupteur;
		}		
		
		// POUR MONSTER
		public static void addMonster(Monster monster){
			monsters.add(monster);
		}
		
		public static void removeMonster(Monster monster){
			monsters.remove(monster);
		}
		public static ArrayList<Monster> getMonsterList(){
			return monsters;
		}		
						

		//Passe Bombes
		public static void addPassBomb(PassBomb pb){
			passBomb.add(pb);
		}
		public static void removePassBomb(PassBomb pb){
			passBomb.remove(pb);
		}
		public static ArrayList<PassBomb> getPassBombList(){
			return passBomb;
		}
		
		//Pousse Bombes
		public static void addCasePousseBomb(CasePousseBomb pb){
			casePousseBomb.add(pb);
		}
		public static void removeCasePousseBomb(CasePousseBomb pb){
			casePousseBomb.remove(pb);
		}
		public static ArrayList<CasePousseBomb> getCasePousseBombList(){
			return casePousseBomb;
		}
		
		
		
		
		//fonction pour vider toutes les listes
		public void clearAllLists(){
			entities.clear();	
			
			goals.clear();	
			breakables.clear();	
			trapInterruptors.clear();
			enemies.clear();
			bombs.clear();
			explosions.clear();
			briqueIncassables.clear();
			speedCases.clear();
			bombCases.clear();
			missiles.clear();
			lifeCases.clear();
			caseTeleportation.clear();
			interrupteur.clear();
			monsters.clear();
			traps.clear();
			passBomb.clear();
			casePousseBomb.clear();
			players.clear();
		}

}
