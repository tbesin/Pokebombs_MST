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
	
	
	
	GameController controller = GameView.getGameController();
	
	public void paint(Graphics g){
		   try {
			      //Image img = ImageIO.read(new File("ALLO.jpg"));		///trouver une autre image
			      //g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			    } catch (Exception e) {
			      e.printStackTrace();
			    } 
		   this.setSize(200, 600);
		   Font font = new Font("Arial", Font.BOLD, 20);
		   g.setFont(font);
		   g.setColor(Color.black); 
		   for (int i =0; i<controller.getPlayerList().size();i++){
				if(controller.getPlayerList().get(i).getLife() != 0){
					 if (controller.getPlayerList().get(i).getPousseBomb()){
						   ImageIcon ic = new ImageIcon("casePousseBomb.png");
						   g.drawImage(ic.getImage(),20, 108+140*i , 30, 30, this);
					 }
				   for (int j = 0 ; j< controller.getPlayerList().get(i).getLife(); j++){
					   ImageIcon ic = new ImageIcon("baieVie1.png");
					   g.drawImage(ic.getImage(),20+30*j, 30+140*i , 30, 30, this);
					   g.drawString("Joueur "+(i+1)+":",25,25+140*i);
					   g.drawString("Speed :  "+controller.getPlayerList().get(i).getSpeed(),25, 105+140*i);	
				   }
				   for (int j = 0 ; j< controller.getPlayerList().get(i).getBomb(); j++){
					   ImageIcon ic = new ImageIcon("pokeball.png");
					   g.drawImage(ic.getImage(),20+30*j,60+140*i , 30, 30, this);
					   
						   
				   }
				}
				   
				   else g.drawString("Dead", 25, 100 + 140*i);
			  

		}
}
}