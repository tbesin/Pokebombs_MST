package Modele;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import Controller.GameController;

public class Goal extends Entity{
	
	public Goal(int x, int y) {
		super(x, y);
	}
	
	public void update(){
	}
	
	public Image getImg(){
		ImageIcon ic = new ImageIcon("ProfChen.png");
		return ic.getImage();
	 }
	public Rectangle getBounds(){
		int intX = 20 ;					
		int intY = 30 ;		
		return new Rectangle(x,y,intX,intY);
	}
	
	
	public void interact(Player p){	
		p.setCanGo(1);
		if (p.getLife()>=2 && p.getBomb()>=1) {JOptionPane.showMessageDialog(null, "Chen: Felicitation, tu es fin pret pour le prochain niveau \n Minh huy (createur) Haha, soyons honn�te, t'as reussi grace ˆ moi, avoue xD. \nBon restons un peu serieux si ce n'est pas le cas, tu as toute ma reconnaissance, tres peu de gens ont reussi ce niveau sans aide :) \n Antonin: Vous ne pouvez rivaliser avec le premier, vous resterez toujours le second" );}
		else if (GameController.getBreakableList().size()==0 && GameController.getTrapList().size()==0 && GameController.getMonsterList().size()==0)JOptionPane.showMessageDialog(null,"Chen: reviens me voir en etant mieux prepare pour passer au niveau suivant ( 2 vies et 1 bombe ) \n Minh Huy (createur) : Je me demande si je dois laisser ces interrupteurs dans ce niveau ;)");
		else {JOptionPane.showMessageDialog(null, "Chen: tu n'as pas assez de vies et bombs pour le prochain niveau, reviens me voir plus tard avec plus de provisions (2 vies et 1 bombe) \n Minh huy (createur): Pfff, tu penses serieusement que mon niveau serait aussi simple :p" );}
		GameController.removeGoal(this);

	
	}
}

