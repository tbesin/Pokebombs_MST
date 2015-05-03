package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Controller.GameController;
import Modele.Bomb;
import Modele.CasePousseBomb;
import Modele.CaseUpBomb;
import Modele.CaseUpLife;

public class BarreInfoSolo extends JPanel{
	public BarreInfoSolo(){
	}
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
		  /* for (int i =0; i<GameController.getPlayerList().size();i++){
			   if (GameController.getPlayerList().get(i).getPousseBomb())
				   g.drawImage(CasePousseBomb.getCasePousseBombImg(), 20, 60+30*i , 30, 30, this);
			  }
		  
		   for (int i =0; i<GameController.getPlayerList().size();i++){
			   for (int j = 0 ; j< GameController.getPlayerList().get(i).getLife(); j++){
				   g.drawImage(CaseUpLife.getCaseUpLifeImg(), 20+30*j, 60+30*i , 30, 30, this);
			   }
			   for (int j = 0 ; j< GameController.getPlayerList().get(i).getBomb(); j++){
				   g.drawImage(Bomb.getBombImg(), 50+30*j, 60+30*i , 30, 30, this);
			   g.drawString(""+GameController.getPlayerList().get(i).getSpeed(), 20+30*i, 330);			   
		   
		   }

	}*/
	}
}

