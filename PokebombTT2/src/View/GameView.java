package View;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import Controller.GameController;


public class GameView extends JFrame implements ActionListener {
	GameMenu menudepart;
	Timer mainTimer ;							
	GameController controller ;
	GamePanel pan ;
	BarreInfo barreinfo;				//barre d'informations sur l'état des joueurs
	BarreInfoSolo barreinfosolo;		
	
	
	//menu --> à mettre dans game panel => NON
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Aide");
	private JMenuItem item1 = new JMenuItem("Nouvelle partie");
	private JMenuItem item2 = new JMenuItem("Aide");
	
	public GameView() {
		InitMenu();
		InitToolbar();
		
	}
	
	
	
	//crée la barre d'aide tout au-dessus de la fenêtre
	public void InitToolbar(){			
		this.menu1.add(item1);
		this.menu2.add(item2);
		this.menuBar.add(menu1);
		this.menuBar.add(menu2);
		item2.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent arg0){			//What ? => aller voir les classes anonymes
    		Help zd = new Help(null,"Aide",true);
    		}
    	});
		item1.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent ar0){
    		}
    	});
		this.setJMenuBar(menuBar);	
	}
	
	
	
	
	//lance le menu de départ
	public void InitMenu(){							
		this.setSize(600,600);
		
		this.menudepart = new GameMenu();
		getContentPane().add(menudepart) ;
		
		GameMenu.p1.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){
				   GameSoloLaunch();
				   menudepart.setVisible(false);
			   }
			 });
		
		GameMenu.p2.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){
				   GameViewlaunch(2);
				   menudepart.setVisible(false);		//juste le rendre invisible ne le tue pas ><
			   }
			 });
		
		GameMenu.p3.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){
				   GameViewlaunch(3);
				   menudepart.setVisible(false);
			   }
			 });
		
		GameMenu.p4.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){
				   GameViewlaunch(4);
				   menudepart.setVisible(false);
			   }
			 });
	}
	
	
	public void GameViewlaunch(int a){					//permet de lancer les modes de jeu multijoueurs
		this.controller = new GameController() ; //
		
		GameController.startGame(a);	//lance le jeu
		
		this.setSize(740,650);
		this.setTitle("Bombermon !!!");
		this.setFocusable(true);
		
		addKeyListener(controller);	
		
		getContentPane().setLayout(null);
		
		this.barreinfo = new BarreInfo();	//lance la barre d'informations sur les joueurs
		getContentPane().add(barreinfo);
		Dimension size1 = barreinfo.getPreferredSize();
		barreinfo.setBounds(600,0,size1.width, size1.height);
		
		this.pan = new GamePanel();
		getContentPane().add(pan) ;
		pan.setBounds(0,0,620, 620);
		
		mainTimer = new Timer(10,this);
		mainTimer.start();
		
	}
		
		
	public void GameSoloLaunch(){		//permet de lancer le jeu en mode solo
		this.controller = new GameController() ;
		
		this.setTitle("Pokebombs !!!");	
		//this.setSize(430,250);
		this.setSize(600,600);
		this.setFocusable(true);
		
		addKeyListener(controller);
		
		this.barreinfosolo = new BarreInfoSolo();
		Dimension size2 = barreinfosolo.getPreferredSize();
		barreinfosolo.setBounds(220,0,size2.width, size2.height);
		getContentPane().add(barreinfosolo);
		
		this.pan = new GamePanel() ;
		getContentPane().add(pan) ;	
		pan.setBounds(0,0,200, 220);
		
		mainTimer = new Timer(10,this);
		mainTimer.start();
		//GameController.startGame();
		//GameController.startGameSolo();
		GameController.startGameSolo();
	}
		
		
	public void actionPerformed(ActionEvent e) {		//à terminer
		controller.update() ; 			//à modifier !!!
		repaint() ;
		
	}

}
