package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class Bouton extends JButton {
	private Image img;	
	public Bouton (String name,String filename,int posx,int posy,int height,int width){
		 super(name);
		    try {
		      img = ImageIO.read(new File(filename));
		    } catch (IOException e) {
		      e.printStackTrace();
		    }

		  this.setBounds(posx,posy,height,width);
	}
		  public void paintComponent(Graphics g){
			    Graphics2D g2d = (Graphics2D)g;
			    g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			  }

 
	}
