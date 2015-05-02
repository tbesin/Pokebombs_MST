package View;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameMenu extends JPanel implements ActionListener{
	
   public static Bouton p2 = new Bouton("","2Joueurs.png",50,150,150,40);
   public static Bouton p3 = new Bouton("","3Joueurs.png",50,250,150,40);
   public static Bouton p4 = new Bouton("","4Joueurs.png",50,350,150,40);   
   public static Bouton p1 = new Bouton("","Solo.png",350,150,150,40);
   
   
   public GameMenu(){
	   
   }	
   
   
   public void paint(Graphics g){
	   
	   try {
		      Image img = ImageIO.read(new File("menu2.png"));
		      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	   
	   this.add(p1);
	   this.add(p2);
	   this.add(p3);
	   this.add(p4);
	   setLayout(null);
	   this.setVisible(true);
	   
	   //this.validate();
	   
	  
   }
	   

		
	

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
}
