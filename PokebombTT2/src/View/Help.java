package View;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Help extends JDialog {
  public Help(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(1000, 1000);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setVisible(true);
  }
  public void paint(Graphics g) {
	  try {
	      Image img = ImageIO.read(new File("aide.png"));
	      g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
	    } catch (IOException e) {
	      e.printStackTrace();
	    } 
}
}
  