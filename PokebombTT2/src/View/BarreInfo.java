package View;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controller.GameController;
import Modele.Bomb;
import Modele.CasePousseBomb;
import Modele.CaseUpBomb;
import Modele.CaseUpLife;
import Modele.Player;



public class BarreInfo extends JPanel {

	public BarreInfo() {
	}
	public void paint(Graphics g){
		   try {
			      //Image img = ImageIO.read(new File("ALLO.jpg"));		///trouver une autre image
			      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			    } catch (Exception e) {
			      e.printStackTrace();
			    } 
		   this.setSize(120, 600);
		   Font font = new Font("Courier", Font.BOLD, 20);
		   g.setFont(font);
		   g.setColor(Color.black); 
		   for (int i =0; i<GameController.getPlayerList().size();i++){
				if (GameController.getPlayerList().get(i).getPousseBomb()){
					   ImageIcon ic = new ImageIcon("casePousseBomb.png");
					   g.drawImage(ic.getImage(),20, 120+130*i , 30, 30, this);
			   }
			   }
			   for (int i =0; i<GameController.getPlayerList().size();i++){
				   for (int j = 0 ; j< GameController.getPlayerList().get(i).getLife(); j++){
					   ImageIcon ic = new ImageIcon("baieVie1.png");
					   g.drawImage(ic.getImage(),20, 60+30*i , 30, 30, this);
				   }
				   for (int j = 0 ; j< GameController.getPlayerList().get(i).getBomb(); j++){
					   ImageIcon ic = new ImageIcon("pokeball.png");
					   g.drawImage(ic.getImage(),20+30*j,90+130*i , 30, 30, this);
					   g.drawString(""+GameController.getPlayerList().get(i).getSpeed(),25, 165+130*i);			   
			   }

		}
}
}