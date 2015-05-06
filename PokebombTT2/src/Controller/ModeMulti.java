package Controller;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;








import java.util.Random;

import Modele.BriqueCassable;
import Modele.BriqueIncassable;
import Modele.CasePousseBomb;
import Modele.CaseTeleportation;
import Modele.CaseUpBomb;
import Modele.CaseUpLife;
import Modele.Enemy;
import Modele.Entity;
import Modele.Goal;
import Modele.Interrupteur;
import Modele.Monster;
import Modele.PassBomb;
import Modele.Player;
import Modele.Trap;
import Modele.TrapInterruptor;

public class ModeMulti {
	
	//attributs
	
	/*static ArrayList<Enemy> enemies = GameController.getEnemyList();
	public static ArrayList<BriqueIncassable> briqueIncassables =GameController.getBriqueIncassableList();
	public static ArrayList<Player> players = GameController.getPlayerList() ;
	public static ArrayList<BriqueCassable> breakables = GameController.getBreakableList() ;
	public static ArrayList<Trap> traps = GameController.getTrapList() ;
	public static ArrayList<TrapInterruptor> trapInterruptors = GameController.getTrapInterruptorList() ;
	public static ArrayList<Goal> goals = GameController.getGoalList() ;
	
	public static ArrayList<Entity> entities = GameController.getEntityList() ;*/
	
	static ArrayList<Enemy> enemies = GameController.getEnemyList();
	public static ArrayList<BriqueIncassable> briqueIncassables =GameController.getBriqueIncassableList();
	public static ArrayList<Player> players = GameController.getPlayerList() ;
	public static ArrayList<BriqueCassable> breakables = GameController.getBreakableList() ;
	public static ArrayList<Trap> traps = GameController.getTrapList() ;
	public static ArrayList<TrapInterruptor> trapInterruptors = GameController.getTrapInterruptorList() ;
	public static ArrayList<Goal> goals = GameController.getGoalList() ;
	public static ArrayList<CaseUpBomb> bombCases = GameController.getCaseUpBombList() ;
	public static ArrayList<CaseUpLife> lifeCases = GameController.getCaseUpLifeList() ;
	public static ArrayList<CasePousseBomb> casePousseBomb = GameController.getCasePousseBombList() ;
	public static ArrayList<PassBomb> passBomb = GameController.getPassBombList() ;
	public static ArrayList<Interrupteur> interrupteur = GameController.getInterrupteurList() ;
	public static ArrayList<Monster> monsters = GameController.getMonsterList() ;
	public static ArrayList<CaseTeleportation> caseTeleportation = GameController.getCaseTeleportationList() ;
	
	public static ArrayList<Entity> entities = GameController.getEntityList() ;
	
	int nombreJoueurs ;
	
	FileReader fr ;
	String choosenLevel ;
	File levelFile ;
	
	public int frameDim = 600;		//dimensions de la fenêtre (carrée)
	public int nombreCases = 15 ;	//nombre de cases dans la fenêtre
	public int tailleCase = frameDim/nombreCases ;	//dimensions des cases
	
	
	//pour mode random
	static Random rand = new Random();
	public static ArrayList tableauEnemies = new ArrayList();		//what ?
	public static ArrayList tableauBriqueIncassable = new ArrayList();
	//static int breakableCount = 5;		//utilité ?
	
	//Choix du Sprite
	private static int player1img;
	private static int player2img;
	private static int player3img;
	private static int player4img;
	
		
	
	//constructeur
	
	public ModeMulti(int nombreJoueurs, String choosenLevel, int player1img,int player2img,int player3img,int player4img){
		this.nombreJoueurs = nombreJoueurs ;
		this.choosenLevel = choosenLevel ;
		this.player1img = player1img;
		this.player2img = player2img;
		this.player3img = player3img;
		this.player4img = player4img;
		try{
			levelFile = new File(choosenLevel + ".txt");
		}
		catch(Exception ex){
			
		}
		
	}
	
	
	//méthodes
	
	public void startGame(){
		
		//ArrayList tableau= listeCoord(15);		//tableau contenant les coordonnées
		
		//int brique=0;
		
		for (int i=0; i< this.nombreJoueurs; i++){		//crée les joueurs
			if (i==0) players.add(new Player(0,0, this.player1img));
			else if (i==1) players.add(new Player(570,570, this.player2img));
			else if (i==2) players.add(new Player(660,0, this.player3img));
			else if (i==3) players.add(new Player(0,630, this.player4img));
		}
		
		for(int i = 0 ; i < players.size() ; i++){
			players.get(i).setMode("multi");
		}
		
		
		//lecture du fichier contenant les informations sur le niveau
		
		try{
			fr = new FileReader(this.levelFile);
			
			int i = 0 ;
			int x = 0 , y = 0 ;
			
			while((i = fr.read()) != -1){
				char strImg = (char) i ;
				
				if(strImg == '0'){
					briqueIncassables.add(new BriqueIncassable(this.tailleCase*x, this.tailleCase*y));
				}
				
				else if(strImg == '1'){
					breakables.add(new BriqueCassable(this.tailleCase*x, this.tailleCase*y) );
				}
				
				
				else if(strImg == '3'){
					goals.add(new Goal(this.tailleCase*x, this.tailleCase*y));
				}
				
				else if(strImg == '4'){
					bombCases.add(new CaseUpBomb(this.tailleCase*x, this.tailleCase*y));
				}
				
				else if(strImg == '5'){
					lifeCases.add(new CaseUpLife(this.tailleCase*x, this.tailleCase*y));
				}
				
				
				else if(strImg == '6'){
					caseTeleportation.add(new CaseTeleportation(this.tailleCase*x, this.tailleCase*y));
				}
				
				else if(strImg == '7'){
					traps.add(new Trap(this.tailleCase*x, this.tailleCase*y));
				}
				
				else if(strImg == '8'){
					monsters.add(new Monster(this.tailleCase*x, this.tailleCase*y));
				}
				
				else if(strImg == '9'){
					monsters.add(new Monster(this.tailleCase*x, this.tailleCase*y));
				}
				
				else if(strImg == 'A'){
					interrupteur.add(new Interrupteur(this.tailleCase*x, this.tailleCase*y));
				}
				
				else if(strImg == 'B'){
					passBomb.add(new PassBomb(this.tailleCase*x, this.tailleCase*y));
				}
				
				else if(strImg == 'C'){
					this.casePousseBomb.add(new CasePousseBomb(this.tailleCase*x, this.tailleCase*y));
				}
				
				
				else if(strImg == '\r' || strImg == '\n'){
					x-- ;
				}
				
				if(x == 14){
					y++ ;
					x = 0 ;
				}
				else {
					x++ ;
				}
			}
			fr.close();
			
			
			//new
			/*entities.addAll(goals);	
			entities.addAll(breakables);	
			entities.addAll(trapInterruptors);
			entities.addAll(enemies);
			entities.addAll(briqueIncassables);
			entities.addAll(traps);*/
			
			entities.addAll(goals);	
			entities.addAll(breakables);	
			entities.addAll(trapInterruptors);
			entities.addAll(enemies);
			entities.addAll(briqueIncassables);
			entities.addAll(traps);
			
			entities.addAll(bombCases);	
			entities.addAll(lifeCases);	
			entities.addAll(caseTeleportation);
			entities.addAll(monsters);
			entities.addAll(interrupteur);
			entities.addAll(passBomb);
			entities.addAll(casePousseBomb);

			
			
			
			for(int j = 0 ; j < entities.size() ; j++){
				entities.get(j).setMode("multi");
			}
			
			for(int k = 0 ; k < caseTeleportation.size() ; k++){//vérifie que les téléporteurs fonctionnent par paires
				CaseTeleportation ct = caseTeleportation.get(k);
				if (k%2 != 0){
					ct.setTeleportationIn(false);
				}
			}
		}
		
		catch(Exception ex){
			
			
			ArrayList tableau= listeCoord(15);
			int brique=0;
			int breakableCount = 5 ; //Pourquoi 5 ?
			
			while (brique<49){
				int n = rand.nextInt(tableau.size());
				ArrayList coord = (ArrayList) tableau.get(n);
				int X= (Integer) coord.get(0);
				int Y= (Integer) coord.get(1);
				if (X%2 != 0 && Y%2 !=0){
				int intx = (int) Math.ceil(X*(600/15));
				int inty = (int) Math.ceil(Y*(600/15));
				tableauBriqueIncassable.add(coord);
				tableau.remove(coord);
				this.briqueIncassables.add(new BriqueIncassable(intx, inty));
				brique++;
				}
			}
				
				while(breakableCount<100){		//new !
					int n = rand.nextInt(tableau.size());
					ArrayList coord = (ArrayList) tableau.get(n);
					int X= (Integer) coord.get(0);
					int Y= (Integer) coord.get(1);
					int intx = (int) Math.ceil(X*(600/15));
					int inty = (int) Math.ceil(Y*(600/15));
					if( !((X== 0 && Y==0)||(X==0 && Y==1)||(Y==1 && X==0)||(X== 1 && Y==0)||(X== 14 && Y==0)||(X==14 && Y==1)||(Y==0 && X==13)||(X==0 && Y==14)||(X==1 && Y==14)||(X==0 && Y==13)||(X==14 && Y==14)||(X==14 && Y==13)||(X==13 && Y==14))){
						tableauEnemies.add(coord);tableau.remove(coord);
						breakables.add(new BriqueCassable(intx, inty));
						breakableCount++;
						}	
				}
			
		}
	}
	
	
	public static ArrayList listeCoord(int nb){
		ArrayList a = new ArrayList();
		for (int i =0; i<nb;i++){
			for (int j =0; j<nb;j++){
				ArrayList p = new ArrayList();p.add(i);p.add(j);a.add(p);
			}
		}
		return a;
	}
	
	
	public static int choix() {
		int n = rand.nextInt(5);
		return n;
	}
	
}


