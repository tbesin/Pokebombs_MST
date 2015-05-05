package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Controller.GameController;
import Modele.Bomb;
import Modele.CasePousseBomb;
import Modele.CaseUpBomb;
import Modele.CaseUpLife;

public class BarreInfoSolo extends JPanel{
	
	public BarreInfoSolo(){
	}
	
	GameController controller = GameView.getGameController();
	
	public void paint(Graphics g){
		   try {
			      //Image img = ImageIO.read(new File("ALLO.jpg"));
			      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			    } catch (Exception e) {
			      e.printStackTrace();
			    } 
		   this.setSize(200, 250);
		   Font font = new Font("Courier", Font.BOLD, 20);
		   g.setFont(font);
		   g.setColor(Color.black);          
		 //g.drawString((String), 10, 20);
		 if (controller.getPlayerList().get(0).getPousseBomb()){
				   ImageIcon ic = new ImageIcon("casePousseBomb.png");
			   		g.drawImage(ic.getImage(),20, 120 , 30, 30, this);
			  }

		  
			   for (int j = 0 ; j< controller.getPlayerList().get(0).getLife(); j++){
				   ImageIcon ic = new ImageIcon("baieVie1.png");
				   g.drawImage(ic.getImage(),20+30*j, 60 , 30, 30, this);
			   }
			   for (int j = 0 ; j< controller.getPlayerList().get(0).getBomb(); j++){
				   ImageIcon ic = new ImageIcon("pokeball.png");
				   g.drawImage(ic.getImage(),20+30*j, 90 , 30, 30, this);
				   g.drawString("Speed: "+controller.getPlayerList().get(0).getSpeed(), 25, 163);			   
		   
		   }

	}
	}

