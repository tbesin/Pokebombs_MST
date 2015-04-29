package Controller;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;





import Modele.BriqueCassable;
import Modele.BriqueIncassable;
import Modele.Enemy;
import Modele.Goal;
import Modele.Player;
import Modele.Trap;
import Modele.TrapInterruptor;

public class ModeMulti {
	
	//attributs
	static ArrayList<Enemy> enemies = GameController.getEnemyList();
	public static ArrayList<BriqueIncassable> briqueIncassables =GameController.getBriqueIncassableList();
	public static ArrayList<Player> players = GameController.getPlayerList() ;
	public static ArrayList<BriqueCassable> breakables = GameController.getBreakableList() ;
	public static ArrayList<Trap> traps = GameController.getTrapList() ;
	public static ArrayList<TrapInterruptor> trapInterruptors = GameController.getTrapInterruptorList() ;
	public static ArrayList<Goal> goals = GameController.getGoalList() ;
	
	int nombreJoueurs ;
	
	FileReader fr ;
	String choosenLevel ;
	File levelFile ;
	
	public int frameDim = 600;		//dimensions de la fenêtre (carrée)
	public int nombreCases = 15 ;	//nombre de cases dans la fenêtre
	public int tailleCase = frameDim/nombreCases ;	//dimensions des cases
	
	
	
	//constructeur
	
	public ModeMulti(int nombreJoueurs, String choosenLevel){
		this.nombreJoueurs = nombreJoueurs ;
		this.choosenLevel = choosenLevel ;
		
		try{
			levelFile = new File(choosenLevel + ".txt");
		}
		catch(Exception ex){
			
		}
	}
	
	
	
	//méthodes
	
	/*public static ArrayList listeCoord(int nb){		//renvoit une liste de listes avec les coordonnées
		ArrayList a = new ArrayList();
		
		for (int i =0; i<nb;i++){
			for (int j =0; j<nb;j++){
				ArrayList p = new ArrayList();
				p.add(i);
				p.add(j);
				a.add(p);
			}
		}
		return a;
	}*/
	
	
	public void startGame(){
		
		//ArrayList tableau= listeCoord(15);		//tableau contenant les coordonnées
		
		//int brique=0;
		
		for (int i=0; i< this.nombreJoueurs; i++){		//crée les joueurs
			if (i==0) players.add(new Player(0,0, 1));
			else if (i==1) players.add(new Player(570,570, 2));
			else if (i==2) players.add(new Player(660,0, 3));
			else if (i==3) players.add(new Player(0,630, 4));
		}
		
		/*trapInterruptors.add(new TrapInterruptor(5, 525));
		traps.add(new Trap(560, 05));
		goals.add(new Goal(5, 550)) ; */
		
		
		//lecture du fichier contenant les informations sur le niveau
		
		try{
			fr = new FileReader(this.levelFile);
			
			int i = 0 ;
			int x = 0 , y = 0 ;
			
			while((i = fr.read()) != -1){
				char strImg = (char) i ;
				
				if(strImg == '0'){
					briqueIncassables.add(new BriqueIncassable(this.tailleCase*x, this.tailleCase*y));
					//System.out.println(x + "    " + y);
				}
				
				else if(strImg == '1'){
					breakables.add(new BriqueCassable(this.tailleCase*x, this.tailleCase*y) );
				}
				
				/*else if(strImg == '2'){
					players.add(new Player(x,y) );
				}*/
				
				else if(strImg == '3'){
					goals.add(new Goal(this.tailleCase*x, this.tailleCase*y));
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
		}
		
		catch(Exception ex){
			System.out.println("problème..." + ex);
		}
	}
}


