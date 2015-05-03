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
	
	public static ArrayList<Player> players = GameController.getPlayerList() ;
	public static ArrayList<Entity> entities = GameController.getEntityList() ;////
	
	
	
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
		
		
		//tout
		for(int i = 0 ; i < entities.size() ; i++){
			Entity cus = entities.get(i);
			draw(g2d, cus.getImg(), cus.getX(), cus.getY() );
		}
		
		
		//les joueurs
		for(int i = 0 ; i < players.size() ; i++ ){
			Player tempPlayer = players.get(i);
			g2d.drawImage(tempPlayer.getImg(), tempPlayer.getX(), tempPlayer.getY(), null) ;					//intX-10,intY-10,null);
		}
	}		
}


