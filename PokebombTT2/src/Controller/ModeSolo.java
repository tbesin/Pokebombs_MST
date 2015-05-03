package Controller;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

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

public class ModeSolo {
	
	//attributs
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
		
		
		
		FileReader fr ;
		String choosenLevel ;
		File levelFile ;
		
		public int frameDim = 600;		//dimensions de la fenêtre (carrée)
		public int nombreCases = 15 ;	//nombre de cases dans la fenêtre
		public int tailleCase = frameDim/nombreCases ;	//dimensions des cases
		
		
		//constructeur
		
		public ModeSolo( String choosenLevel){

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
		
		
		public static void BonusSolo(int lvl, int X, int Y){
			if (lvl == 1){ if (X ==0*(200/5) && Y == 3*(200/5)){GameController.addCaseUpBomb(new CaseUpBomb(X,Y));}}
			if (lvl == 1){ if (X ==3*(200/5) && Y == 3*(200/5)){GameController.addCaseUpBomb(new CaseUpBomb(X,Y));}}
			if (lvl == 1){ if (X==3*(200/5) && Y == 0*(200/5)){GameController.addTrap(new Trap(X,Y));}}
			if (lvl == 1){ if (X ==4*(200/5) && Y == 4*(200/5)){GameController.addCaseUpLife(new CaseUpLife(X,Y));}}
			//if (lvl == 0){if (X==4*(200/5) && Y == 2*(200/5)){GameController.addInterrupteur(new Interrupteur(X,Y));}}
			if (lvl == 0){ if (X ==1*(200/5) && Y == 2*(200/5)){GameController.addCaseUpBomb(new CaseUpBomb(X,Y));}}
			if (lvl == 0){ if (X ==0*(200/5) && Y == 2*(200/5)){GameController.addCaseUpBomb(new CaseUpBomb(X,Y));}}
		}
		
		
		public void startGame(){
			
			/*ArrayList tableau= listeCoord(15);		//tableau contenant les coordonnées
			
			int brique=0;*/
	
			
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
					}
					
					else if(strImg == '1'){
						breakables.add(new BriqueCassable(this.tailleCase*x, this.tailleCase*y) );
					}
					
					else if(strImg == '2'){
						players.add(new Player(x,y, 1) );
						
						if(this.choosenLevel == "levelSolo3"){
							players.get(0).setPousseBomb(true);
						}
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
			}
			
			catch(Exception ex){
				System.out.println("problème..." + ex);
				
				
				//pour test
				
				//ArrayList tableau = listeCoord(5);
				players.add(new Player(0,0,1));
				//players.add(new Player(2*(200/5),0));
				//addBriqueIncassable(new BriqueIncassable (1*(200/5),0*(600/5)));
				
				GameController.addBriqueIncassable(new BriqueIncassable (1*(200/5),0*(200/5)));
				GameController.addBriqueIncassable(new BriqueIncassable (3*(200/5),3*(200/5)));
				GameController.addBriqueIncassable(new BriqueIncassable (4*(200/5),0*(200/5)));
				GameController.addBriqueIncassable(new BriqueIncassable (2*(200/5),1*(200/5)));
				GameController.addBriqueIncassable(new BriqueIncassable (0*(200/5),3*(200/5)));
				GameController.addBriqueIncassable(new BriqueIncassable (3*(200/5),4*(200/5)));
				GameController.addBriqueIncassable(new BriqueIncassable (3*(200/5),1*(200/5)));
				GameController.addBriqueIncassable(new BriqueIncassable (2*(200/5),3*(200/5)));
				GameController.addGoal(new Goal (3*(200/5),0*(200/5)));
				GameController.addCaseUpBomb(new CaseUpBomb (1*(200/5),4*(200/5)));
				GameController.addCaseUpLife(new CaseUpLife (0*(200/5),4*(200/5)));
				//GameController.addCasePousseBomb(new CasePousseBomb ((1*200/5),3*(200/5)));
				//GameController.addMonster(new Monster(4*(200/5),4*(200/5)));
				//GameController.addPassBomb(new PassBomb(2*(200/5),2*(200/5)));
				GameController.addBreakable(new BriqueCassable(4*(200/5),2*(200/5)));
				GameController.addBreakable(new BriqueCassable(1*(200/5),2*(200/5)));
				//GameController.addInterrupteur(new Interrupteur(4*(200/5),1*(200/5)));
				GameController.addCaseTeleportation(new CaseTeleportation(2*(200/5),0*(200/5)));
				GameController.addCaseTeleportation(new CaseTeleportation(2*(200/5),4*(200/5)));
				
				
				for(int i = 0 ; i < caseTeleportation.size() ; i++){
					CaseTeleportation ct = caseTeleportation.get(i);
					if (i%2 != 0){
						ct.setTeleportationIn(false);
					}
				}
			}
			
			
			
			//new
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
				entities.get(j).setMode("solo");
			}
			
			for(int i = 0 ; i < players.size() ; i++){
				players.get(i).setMode("solo");
			}
			
		}
}


