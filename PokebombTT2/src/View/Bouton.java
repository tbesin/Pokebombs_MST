package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.event.MenuDragMouseEvent;

//import com.sun.glass.events.MouseEvent;

public class Bouton extends JButton implements MouseListener {
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
	public Bouton(String name,String filename,String filename2,int posx,int posy,int height,int width){
		super(name);
		this.addMouseListener(this);
		try {
		      img = ImageIO.read(new File(filename));
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		this.setBounds(posx,posy,height,width);	
 
	}
	 	public void mouseClicked(MenuDragMouseEvent event, String filename2) throws IOException {
	 		  img = ImageIO.read(new File(filename2));

	 			  
                     
		  }
		  public void paintComponent(Graphics g){
			    Graphics2D g2d = (Graphics2D)g;
			    g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
			  }
		
		  @Override
		public void mouseClicked(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(java.awt.event.MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
}
	