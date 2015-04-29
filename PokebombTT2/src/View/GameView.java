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
	BarreInfo barreinfo;
	BarreInfoSolo barreinfosolo;
	
	
	//menu --> � mettre dans game panel => NON
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menu1 = new JMenu("Fichier");
	private JMenu menu2 = new JMenu("Aide");
	private JMenuItem item1 = new JMenuItem("Nouvelle partie");
	private JMenuItem item2 = new JMenuItem("Aide");
	
	public GameView() {
		InitMenu();
		InitToolbar();
		
	}
	
	
	public void InitToolbar(){
		this.menu1.add(item1);
		this.menu2.add(item2);
		this.menuBar.add(menu1);
		this.menuBar.add(menu2);
		item2.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent arg0){			//What ?
    		Help zd = new Help(null,"Aide",true);
    		}
    	});
		item1.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent ar0){
    		}
    	});
		this.setJMenuBar(menuBar);	
	}
	
	public void InitMenu(){	
		this.setSize(600,600);
		this.menudepart = new GameMenu();
		getContentPane().add(menudepart) ;
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
		GameMenu.p1.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent event){
				   GameSoloLaunch();
				   menudepart.setVisible(false);
			   }
			 });
	}
	
		public void GameViewlaunch(int a){
			this.controller = new GameController() ; //
			
			GameController.startGame(a);
			this.setSize(740,650);
			this.setTitle("Bombermon !!!");
			this.setFocusable(true);
			
			addKeyListener(controller);	
			getContentPane().setLayout(null);
			this.barreinfo = new BarreInfo();
			getContentPane().add(barreinfo);
			Dimension size1 = barreinfo.getPreferredSize();
			barreinfo.setBounds(600,0,size1.width, size1.height);
			this.pan = new GamePanel();
			getContentPane().add(pan) ;			//O� est d�fini pan ?
			pan.setBounds(0,0,620, 620);
			mainTimer = new Timer(10,this);
			mainTimer.start();
			
		}
		
		
		public void GameSoloLaunch(){
			this.controller = new GameController() ;
			
			this.setTitle("Pokebombs !!!");	
			this.setSize(430,250);
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
			GameController.startGameSoloTuto();
		}
		
		
	public void actionPerformed(ActionEvent e) {		//� terminer
		controller.update() ; 			//� modifier
		repaint() ;
		
	}

}
