package View;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.GameController;
import Controller.GameManager;
import Controller.ModeMulti;
import Controller.ModeSolo;


public class GameView extends JFrame implements ActionListener{
	
	Timer mainTimer = new Timer(10,this);						
	
	GamePanel pan  = new GamePanel() ;
	BarreInfo barreinfo;
	BarreInfoSolo barreinfosolo;
	String mode;		
	
	
	
	private static Boolean premierTour1 = true ;	//cheat pour les nouvelles parties !!!
	private static Boolean premierTour2 = true ;
	
	
	
	
	static GameManager manager ; //new !
	
	//barre d'outils
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Aide");
	private JMenuItem item1 = new JMenuItem("Retour au menu");
	private JMenuItem item2 = new JMenuItem("Aide");
	private JMenuItem item3 = new JMenuItem("Nouvelle partie");
	
	//menu principal 
	Menu menupage1;   
	public static Bouton bsolo = new Bouton("","Solo.png",350,150,150,40);
	public static Bouton bmulti = new Bouton("","menu.png",50,150,150,40);
	
	//menu multi page 1
	Menu menupage2;
	private JButton ok = new JButton("ok");
	public static Bouton p2 = new Bouton("","2Joueurs.png",140,120,70,70);
	public static Bouton p3 = new Bouton("","3Joueurs.png",240,120,70,70);
	public static Bouton p4 = new Bouton("","4Joueurs.png",340,120,70,70);
	public static Bouton lvl1multi = new Bouton("","lvl1solo.jpg",140,260,50,50);
	public static Bouton lvl2multi = new Bouton("","lvl2solo.jpg",200,260,50,50);
	public static Bouton lvl3multi = new Bouton("","lvl3solo.png",260,260,50,50);
	public static Bouton lvl4multi = new Bouton("","lvl4solo.jpg",320,260,50,50);
	public static Bouton lvl5multi = new Bouton("","lvl5solo.jpg",380,260,50,50);
	
	
	final JLabel levelmulti = new JLabel("Niveau choisi : ");		
	final JLabel nbreplayer= new JLabel("Nombre choisi : ");
	
	//pour choisir le nbre de joueurs et le niveau
	static int nbplayer;
	static String chosenlevelmulti;
	
	//menu multi page 2
	private JButton ok2 = new JButton("ok");
	private Bouton player1_1 = new Bouton("","Player1down1.png",140,100,50,50);
	private Bouton player2_1 = new Bouton("","Player2down1.png",200,100,50,50);
	private Bouton player3_1 = new Bouton("","player3down1.png",260,100,50,50);
	private Bouton player4_1 = new Bouton("","player4down1.png",320,100,50,50);
	private Bouton player1_2 = new Bouton("","Player1down1.png",140,200,50,50);
	private Bouton player2_2 = new Bouton("","Player2down1.png","SoloMenuB.jpg",200,200,50,50);
	private Bouton player3_2 = new Bouton("","player3down1.png",260,200,50,50);
	private Bouton player4_2 = new Bouton("","player4down1.png",320,200,50,50);
	private Bouton player1_3 = new Bouton("","Player1down1.png","SoloMenuB.jpg",140,300,50,50);
	private Bouton player2_3 = new Bouton("","Player2down1.png","SoloMenuB.jpg",200,300,50,50);
	private Bouton player3_3 = new Bouton("","player3down1.png",260,300,50,50);
	private Bouton player4_3 = new Bouton("","player4down1.png",320,300,50,50);
	private Bouton player1_4 = new Bouton("","Player1down1.png","SoloMenuB.jpg",140,400,50,50);
	private Bouton player2_4 = new Bouton("","Player2down1.png","SoloMenuB.jpg",200,400,50,50);
	private Bouton player3_4 = new Bouton("","player3down1.png",260,400,50,50);
	private Bouton player4_4 = new Bouton("","player4down1.png",320,400,50,50);
	
	final JLabel player1multi = new JLabel("Joueur choisi : ");
	final JLabel player2multi = new JLabel("Joueur choisi : ");
	final JLabel player3multi = new JLabel("Joueur choisi : ");
	final JLabel player4multi = new JLabel("Joueur choisi : ");
	
	//Pour Choisir son Sprite
	static int player1img;
	static int player2img;
	static int player3img;
	static int player4img;
	
	//menu solo 
	private JLabel label = new JLabel("Nom");	
	private JButton ok3 = new JButton("ok");
	private Bouton lvl1solo = new Bouton("","bouton1SoloLevel1.png",20,60,100,100);
	private Bouton lvl2solo = new Bouton("","bouton2SoloLevel1.png",130,60,100,100);
	private Bouton lvl3solo = new Bouton("","bouton3SoloLevel1.png",240,60,100,100);
	private Bouton lvl4solo = new Bouton("","lvl4solo.jpg",350,60,100,100);
	private Bouton lvl5solo = new Bouton("","lvl5solo.jpg",460,60,100,100);
	private Bouton player1 = new Bouton("","Player1down1.png",170,400,50,50);
	private Bouton player2 = new Bouton("","Player2down1.png",230,400,50,50);
	private Bouton player3 = new Bouton("","player3down1.png",290,400,50,50);
	private Bouton player4 = new Bouton("","player4down1.png",350,400,50,50);
	
	final JLabel levelsolo = new JLabel("Niveau choisi : ");
	final JLabel playersolo = new JLabel("Joueur choisi : ");
	
	
	
	//pour choisir son niveau et son sprite
	static String chosenlevelsolo; 
	private static int playerimg;
	
	//contructeur
	public GameView() {
		InitMenu();
		InitToolbar();	
	}
	
	//Setter, permettent de choisir le niveau, le sprite et le nbre de joueurs
	public static void setplayerimg(int a){
		playerimg = a;
	}
	public static void setchosenlevelsolo(String str){
		chosenlevelsolo = str;
	}
	public static void setchosenlevelmulti(String str){
		chosenlevelmulti = str;
	}
	public static  void setnbplayer(int a){
		nbplayer = a;
	}
	public static  void setplayer1img(int a){
		player1img = a;
	}
	public static  void setplayer2img(int a){
		player2img = a;
	}
	public static  void setplayer3img(int a){
		player3img = a;
	}
	public static  void setplayer4img(int a){
		player4img = a;
	}
	
	
	
	
	
	//Lance la barre d'outils
	public void InitToolbar(){
		this.menu1.add(item1);
		this.menuBar.add(menu1);
		
		item1.addActionListener(new ActionListener(){	//permet le retour au menu principale par la case fichier
    	public void actionPerformed(ActionEvent ar0){ 
    		pan.setVisible(false);    		
    		mainTimer.stop();							///Pour Siméon 
        	
        	InitMenu();  		    		
        	
           // manager = new GameManager(); //new !
    		
    	}
    	});
		this.setJMenuBar(menuBar);	
	}
	
	//change la barre d'outil lors d'une nouvelle partie
	public void changetoolbar(String mode){
		this.menuBar.add(menu2);
		this.menu2.add(item2);
		this.menu1.add(item3);
		
		if(mode=="solo"){
			item3.addActionListener(new ActionListener(){	//nouvelle partie en mode solo
	    	public void actionPerformed(ActionEvent ar0){
	    		mainTimer.stop();
	    		
	            Gamelaunch("solo");
	    	}	
	    	});
		
			item2.addActionListener(new ActionListener(){		//aide en mode solo
				public void actionPerformed(ActionEvent ar0){
					Help zd = new Help(null,"Aide",true,"Aidesolo.png");
				}
				
		});
		}	
		
		if (mode=="multi"){
			item2.addActionListener(new ActionListener(){		//aide en mode multi
				public void actionPerformed(ActionEvent ar0){
					Help zd = new Help(null,"Aide",true,"Aidemulti.png");
				}
			});
			
			item3.addActionListener(new ActionListener(){	//nouvelle partie en mode multi
		    	public void actionPerformed(ActionEvent ar0){
		    		mainTimer.stop();
		            
		            Gamelaunch("multi");
		    	}	
		    	});
		}
	}
	
	
	
	//initie le menu principal
	public void InitMenu(){	
		this.setSize(600,600);
		this.add(bsolo);
		this.add(bmulti);
		
		bouton("menuprincipal", 0, true);//cheat pour rendre (in)visible les boutons
		
		this.menupage1 = new Menu("menu2.png",600,600,0,0);
		getContentPane().add(menupage1) ;
		

		this.bmulti.addActionListener(new ActionListener(){			//sélection du mode multi
			   public void actionPerformed(ActionEvent event){
				   
				   MenuMultipage1Launch();
				   
				   menupage1.setVisible(false);
				   bouton("menuprincipal", 0, false);//cheat
				  /* bmulti.setVisible(false);
				   bsolo.setVisible(false);*/
			   }
			 });
		this.bsolo.addActionListener(new ActionListener(){			//sélection du mode solo
			   public void actionPerformed(ActionEvent event){	

				   MenuSoloLaunch();
				   
				   menupage1.setVisible(false);
				   bouton("menuprincipal", 0, false);//cheat
				  /* bsolo.setVisible(false);
				   bmulti.setVisible(false);*/
			   }
			 });
		
	}
	
	
	
		//lance le menu solo
		public void MenuSoloLaunch(){
			setLayout(null);
			this.add(lvl1solo);
			this.add(lvl2solo);
			this.add(lvl3solo);
			this.add(lvl4solo);
			this.add(lvl5solo);
			this.add(player1);
			this.add(player2);
			this.add(player3);
			this.add(player4);	
			
			//affichage du choix
			
			levelsolo.setBounds(240, 160, 200, 20);	
			this.add(levelsolo);
			this.add(playersolo);
			playersolo.setBounds(240, 450, 200, 20);
			
			setLayout(new BorderLayout());
			this.add(ok3,BorderLayout.SOUTH);
			
			
			bouton("solo", 1, true);//cheat
			
			//choix du niveau en solo
			this.lvl1solo.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event){
					GameView.setchosenlevelsolo("levelsolo1");
					levelsolo.setText("Niveau choisi : 1");
				   }
			 });
			this.lvl2solo.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					GameView.setchosenlevelsolo("levelsolo2");
					levelsolo.setText("Niveau choisi : 2");
				   }
			 });
			this.lvl3solo.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelsolo("levelsolo3");
					   levelsolo.setText("Niveau choisi : 3");
				   }
			 });
			this.lvl4solo.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelsolo("levelsolo3");
					   levelsolo.setText("Niveau choisi : 4");
				   }
			 });
			this.lvl5solo.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelsolo("levelsolo3");
					   levelsolo.setText("Niveau choisi : 5");
				   }
			 });
			this.player1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayerimg(1);
					   playersolo.setText("Joueur choisi : 1");
				   }
			 });
			this.player2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayerimg(2);
					   playersolo.setText("Joueur choisi : 2");
				   }
			 });
			this.player3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayerimg(3);
					   playersolo.setText("Joueur choisi : 3");
				   }
			 });
			this.player4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayerimg(4);
					   playersolo.setText("Joueur choisi : 4");
				   }
			 });
			
			
			if(premierTour1 == true){	//cette condition évite de créer plusieurs listener pour le même bouton !
				//clic sur le bouton ok en mode solo
				this.ok3.addActionListener(new ActionListener(){
					   public void actionPerformed(ActionEvent event){
						   Gamelaunch("solo"); 
						  /* player1.setVisible(false);
						   player2.setVisible(false);
						   player3.setVisible(false);
						   player4.setVisible(false);
						   ok.setVisible(false);
						   lvl1solo.setVisible(false);
						   lvl2solo.setVisible(false);
						   lvl3solo.setVisible(false);
						   lvl4solo.setVisible(false);
						   lvl5solo.setVisible(false);*/
						   
						   bouton("solo", 0, false);//cheat
						   
						   premierTour1 = false ;
						  
					   }
				 });
			}
			
			
			
			
		}
		
		
		
		
		//lance le menu multi (a mettre en une seule fonction)
		public void MenuMultipage1Launch(){
			setLayout(null);
			this.add(p2);
			this.add(p3);
			this.add(p4);
			this.add(lvl1multi);
			this.add(lvl2multi);
			this.add(lvl3multi);
			this.add(lvl4multi);
			this.add(lvl5multi);
			
			//affichage des choix
			
			levelmulti.setBounds(240, 320, 200, 20);
			nbreplayer.setBounds(240, 180, 200, 100);
			this.add(levelmulti);
			this.add(nbreplayer);
			
			setLayout(new BorderLayout());
			this.add(ok,BorderLayout.SOUTH);	
			bouton("multi1", 0, true);//cheat
			
			//choix du nombre de joueurs en multi
			this.p2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setnbplayer(2);
					   nbreplayer.setText("Nombre choisi : 2");
				   }
				 });
			this.p3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setnbplayer(3);
					   nbreplayer.setText("Nombre choisi : 3");
				   }
				 });
			this.p4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setnbplayer(4);
					   nbreplayer.setText("Nombre choisi : 4");
				   }
				 });
			this.lvl1multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti1");
					   levelmulti.setText("Niveau choisi : 1");
				   }
			 });
			this.lvl2multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti2");
					   levelmulti.setText("Niveau choisi : 2");
				   }
			 });
			this.lvl3multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti3");
					   levelmulti.setText("Niveau choisi : 3");
				   }
			 });
			this.lvl4multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti4");
					   levelmulti.setText("Niveau choisi : 4");
				   }
			 });
			this.lvl5multi.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setchosenlevelmulti("levelMulti5");
					   levelmulti.setText("Niveau choisi : 5");
				   }
			 });
			//clic sur le bouton ok (le premier en multi)
			this.ok.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   //ModeSolo.startGame(playerimg,chosenlevel);
					  
					   gamemenumultipage2launch(nbplayer);
					  /* p2.setVisible(false);
					   p3.setVisible(false);
					   p4.setVisible(false);
					   lvl1multi.setVisible(false);
					   lvl2multi.setVisible(false);
					   lvl3multi.setVisible(false);
					   lvl4multi.setVisible(false);
					   lvl5multi.setVisible(false);*/
					   bouton("multi1", 0, false);//cheat
				   }
			 });
		}
		
		
		//permet le choix du joueur en multi
		private void gamemenumultipage2launch(int nbplayer) {
			
			player1multi.setBounds(240, 160, 200, 20);
			player2multi.setBounds(240, 260, 200, 20);
			player3multi.setBounds(240, 360, 200, 20);
			player4multi.setBounds(240, 460, 200, 20);
			
			setLayout(null);
			if (nbplayer==2){
				this.add(player1_1);
				this.add(player2_1);
				this.add(player3_1);
				this.add(player4_1);
				this.add(player1_2);
				this.add(player2_2);
				this.add(player3_2);
				this.add(player4_2);
				this.add(player1multi);
				this.add(player2multi);
				
				//bouton("menu2", 2, true);//cheat
			}			
			else if (nbplayer==3){
				this.add(player1_1);
				this.add(player2_1);
				this.add(player3_1);
				this.add(player4_1);
				this.add(player1_2);
				this.add(player2_2);
				this.add(player3_2);
				this.add(player4_2);
				this.add(player1_3);
				this.add(player2_3);
				this.add(player3_3);
				this.add(player4_3);
				this.add(player1multi);
				this.add(player2multi);
				this.add(player3multi);
				
			}
			else if (nbplayer==4){
				this.add(player1_1);
				this.add(player2_1);
				this.add(player3_1);
				this.add(player4_1);
				this.add(player1_2);
				this.add(player2_2);
				this.add(player3_2);
				this.add(player4_2);
				this.add(player1_3);
				this.add(player2_3);
				this.add(player3_3);
				this.add(player4_3);
				this.add(player1_4);
				this.add(player2_4);
				this.add(player3_4);
				this.add(player4_4);
				this.add(player1multi);
				this.add(player2multi);
				this.add(player3multi);
				this.add(player4multi);
				
				//bouton("multi2", 4, true);//cheat
			}
			
			setLayout(new BorderLayout());
			this.add(ok2,BorderLayout.SOUTH);
			//ok.setVisible(true);
			bouton("multi2", nbplayer, true);
					
			this.player1_1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
						GameView.setplayer1img(1);
						player1multi.setText("Joueur choisi : 1");
				   }
			 });
			this.player2_1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer1img(2);
					   player1multi.setText("Joueur choisi : 2");
				   }
			 });
			this.player3_1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer1img(3);
					   player1multi.setText("Joueur choisi : 3");
				   }
			 });
			this.player4_1.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer1img(4);
					   player1multi.setText("Joueur choisi : 4");
				   }
			 });
			this.player1_2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer2img(1);
					   player2multi.setText("Joueur choisi : 1");
				   }
			 });
	
			this.player2_2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer2img(2);
					   player2multi.setText("Joueur choisi : 2");
				   }
			 });
			this.player3_2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer2img(3);
					   player2multi.setText("Joueur choisi : 3");   }
			 });
			this.player4_2.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer2img(4);
					   player2multi.setText("Joueur choisi : 4");
				   }
			 });
			this.player1_3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer3img(1);
					   player3multi.setText("Joueur choisi : 1");
				   }
			 });
			this.player2_3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer3img(2);
					   player3multi.setText("Joueur choisi : 2");
				   }
			 });
			this.player3_3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer3img(3);
					   player3multi.setText("Joueur choisi : 3");
				   }
			 });
			this.player4_3.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer3img(4);
					   player3multi.setText("Joueur choisi : 4");
				   }
			 });
			this.player1_4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer4img(1);
					   player4multi.setText("Joueur choisi : 1");
				   }
			 });
			this.player2_4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer4img(2);
					   player4multi.setText("Joueur choisi : 2");
				   }
			 });
			this.player3_4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer4img(3);
					   player4multi.setText("Joueur choisi : 3");
				   }
			 });
			this.player4_4.addActionListener(new ActionListener(){
				   public void actionPerformed(ActionEvent event){
					   GameView.setplayer4img(4);
					   player4multi.setText("Joueur choisi : 4");
				   }
			 });
			
			
			if(premierTour2 == true){	//cette condition évite de créer plusieurs listener pour le même bouton
				this.ok2.addActionListener(new ActionListener(){
					   public void actionPerformed(ActionEvent event){
						   
						 /*  player1_1.setVisible(false);
						   player2_1.setVisible(false);
						   player3_1.setVisible(false);
						   player4_1.setVisible(false);
						   player1_2.setVisible(false);
						   player2_2.setVisible(false);
						   player3_2.setVisible(false);
						   player4_2.setVisible(false);
						   player1_3.setVisible(false);
						   player2_3.setVisible(false);
						   player3_3.setVisible(false);
						   player4_3.setVisible(false);
						   player1_4.setVisible(false);
						   player2_4.setVisible(false);
						   player3_4.setVisible(false);
						   player4_4.setVisible(false);*/
						   
						   bouton("multi2", 4, false);//cheat
						   
						
						   Gamelaunch("multi");
						   
						   premierTour2 = false ;
					   }
				 });
			}
			
			
			
			
		}
		
		public void Gamelaunch(String mode){
			//System.out.println(mode);
			this.manager = new GameManager();
			pan.setVisible(true);
			
			changetoolbar(mode);//normal que ce soit "mode" et pas mode ?
		
			
			if (mode=="multi"){
			
				this.manager.startGame( this.nbplayer,  player1img, player2img, player3img, player4img, this.chosenlevelmulti);
				this.setSize(840,650);
				this.setFocusable(true);
				
				addKeyListener(manager);	
				getContentPane().setLayout(null);
				
				
				
				this.barreinfo = new BarreInfo();
				getContentPane().add(barreinfo);
				Dimension size1 = barreinfo.getPreferredSize();
				barreinfo.setBounds(600,0,size1.width, size1.height);
				
				
				//this.pan = new GamePanel();
				getContentPane().add(pan) ;
				pan.setBounds(0,0,620, 620);
				
				//ok.setVisible(false);//
				
				
				mainTimer.start();
			}
			
			
			if (mode=="solo"){
				this.manager.startGameSolo(chosenlevelsolo, playerimg);
				this.setSize(430,250);			
				this.setFocusable(true);
				
				addKeyListener(manager);
				getContentPane().setLayout(null);
				
				this.barreinfosolo = new BarreInfoSolo();
				getContentPane().add(barreinfosolo);
				Dimension size2 = barreinfosolo.getPreferredSize();
				barreinfosolo.setBounds(220,0,size2.width, size2.height);
				
				
				//this.pan = new GamePanel() ;
				getContentPane().add(pan) ;
				pan.setBounds(0,0,220, 220);
				
				mainTimer.start();
			}

			
		}
	public void actionPerformed(ActionEvent e) {		//� terminer
		manager.update() ; 			//� modifier
		repaint() ;
		
	}
	
	
	
	
	public static GameController getGameController(){	//est-ce un problème d'avoir une méthode static ?
		return manager.getGameController();
	}
	
	
	
	
	
	
	//permet rendre visible/invisible les éléments de l'inteface du début
	public void bouton(String page, int nbplayers, Boolean bool){
		if(page== "menuprincipal"){
		bmulti.setVisible(bool);
		bsolo.setVisible(bool);
		}
		if(page=="multi1"){
			 p2.setVisible(bool);
			 p3.setVisible(bool);
			 p4.setVisible(bool);
			 lvl1multi.setVisible(bool);
			 lvl2multi.setVisible(bool);
			 lvl3multi.setVisible(bool);
			 lvl4multi.setVisible(bool);
			 lvl5multi.setVisible(bool);
			 
			levelmulti.setVisible(bool);
			nbreplayer.setVisible(bool);
			 
			 ok.setVisible(bool);
		}
		else if (page == "multi2"){
			
			 player1multi.setVisible(bool);
			 player2multi.setVisible(bool);
			 player3multi.setVisible(bool);
			 player4multi.setVisible(bool);
			
			ok2.setVisible(bool);
			if (nbplayers==2){
			 player1_1.setVisible(bool);
			 player2_1.setVisible(bool);
			 player3_1.setVisible(bool);
			 player4_1.setVisible(bool);
			 player1_2.setVisible(bool);
			 player2_2.setVisible(bool);
			 player3_2.setVisible(bool);
			 player4_2.setVisible(bool);
			}
			if (nbplayers == 3){
			 player1_1.setVisible(bool);
			 player2_1.setVisible(bool);
			 player3_1.setVisible(bool);
			 player4_1.setVisible(bool);
			 player1_2.setVisible(bool);
			 player2_2.setVisible(bool);
			 player3_2.setVisible(bool);
			 player4_2.setVisible(bool);
			 player1_3.setVisible(bool);
			 player2_3.setVisible(bool);
			 player3_3.setVisible(bool);
			 player4_3.setVisible(bool);
			 }
			if(nbplayers == 4){
			player1_1.setVisible(bool);
			player2_1.setVisible(bool);
			player3_1.setVisible(bool);
			player4_1.setVisible(bool);
			player1_2.setVisible(bool);
			 player2_2.setVisible(bool);
			 player3_2.setVisible(bool);
			 player4_2.setVisible(bool);
			 player1_3.setVisible(bool);
			 player2_3.setVisible(bool);
			 player3_3.setVisible(bool);
			 player4_3.setVisible(bool);
			 player1_4.setVisible(bool);
			 player2_4.setVisible(bool);
			 player3_4.setVisible(bool);
			 player4_4.setVisible(bool);
			}
		}
			 
			else if (page == "solo"){
			ok3.setVisible(bool);
			
			lvl1solo.setVisible(bool);
			lvl2solo.setVisible(bool);
			lvl3solo.setVisible(bool);
			lvl4solo.setVisible(bool);
			lvl5solo.setVisible(bool);
			player1.setVisible(bool);
			player2.setVisible(bool);
			player3.setVisible(bool);
			player4.setVisible(bool);
			
			levelsolo.setVisible(bool);
			playersolo.setVisible(bool);
		}
	}

	}

