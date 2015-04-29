package editor;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class EditorBoard extends JPanel implements MouseListener, MouseMotionListener, MouseWheelListener, KeyListener {
	
	//attributs
	String Editeur[][] = new String[15][15];		//tableau à deux dim pour positionner les éléments
	String ImageSelect[] = {"MUR","BLOC","JOUEUR","OBJECTIF","UPBOMB", "UPLIFE"} ;		//tableau à une dim pour savoir ce qu'on sélectionne
	String ImageCourante = "MUR" ; 		//image à dessiner
	int mX, mY ;		//position de la souris
	int indexInc = 0 ;
	
	//images
	Image mur ;
	Image bloc ;
	Image joueur ;
	Image objectif ;
	Image upBomb ;
	Image upLife ;
	
	//pour les fichiers
	FileWriter fw ;
	FileReader fr ;
	
	public int frameDim = 600;		//dimensions de la fenêtre (carrée)
	public int nombreCases = 15 ;	//nombre de cases dans la fenêtre
	public int tailleCase = frameDim/nombreCases ;	//dimensions des cases
	
	
	
	//constructeur
	public EditorBoard(){
		
		//images
		ImageIcon iMur = new ImageIcon("petit_rocher.png");
		mur = iMur.getImage();
		
		ImageIcon iBloc = new ImageIcon("petit_arbre.png");
		bloc = iBloc.getImage();
		
		ImageIcon iJoueur = new ImageIcon("Player1down1.png");
		joueur = iJoueur.getImage();
		
		ImageIcon iObjectif = new ImageIcon("ProfChen.png");
		objectif = iObjectif.getImage();
		
		ImageIcon iUpBomb = new ImageIcon("BombBonus.png");
		upBomb = iUpBomb.getImage();
		
		ImageIcon iUpLife = new ImageIcon("BonusVie.png");
		upLife = iUpLife.getImage();
		
		this.setFocusable(true);		//autorise les listeners sur le panel
		
		addMouseListener(this);			//interaction avec la souris
		addMouseMotionListener(this);
		addMouseWheelListener(this);
		addKeyListener(this);
		
	}
	
	public void paint(Graphics g){
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g ;
		
		for(int i  = 0 ; i < this.nombreCases ; i++){
			for(int j = 0 ; j< this.nombreCases ; j++){
				if(Editeur[i][j] == "MUR"){
					g2d.drawImage(mur, i*this.tailleCase, j*this.tailleCase, null);
				}
				
				else if(Editeur[i][j] == "BLOC"){
					g2d.drawImage(bloc, i*this.tailleCase, j*this.tailleCase, null);
				}
				
				else if(Editeur[i][j] == "JOUEUR"){
					g2d.drawImage(joueur, i*this.tailleCase, j*this.tailleCase, null);
				}
				
				else if(Editeur[i][j] == "OBJECTIF"){
					g2d.drawImage(objectif, i*this.tailleCase, j*this.tailleCase, null);
				}
				
				else if(Editeur[i][j] == "UPBOMB"){
					g2d.drawImage(upBomb, i*this.tailleCase, j*this.tailleCase, null);
				}
				
				else if(Editeur[i][j] == "UPLIFE"){
					g2d.drawImage(upLife, i*this.tailleCase, j*this.tailleCase, null);
				}
			}
		}
		
		if(ImageCourante == "MUR" ){
			g2d.drawImage(mur, mX, mY, null);
		}
		
		else if(ImageCourante == "BLOC" ){
			g2d.drawImage(bloc, mX, mY, null);
		}
		
		else if(ImageCourante == "JOUEUR" ){
			g2d.drawImage(joueur, mX, mY, null);
		}
		
		else if(ImageCourante == "OBJECTIF" ){
			g2d.drawImage(objectif, mX, mY, null);
		}
		
		else if(ImageCourante == "UPBOMB" ){
			g2d.drawImage(upBomb, mX, mY, null);
		}
		
		else if(ImageCourante == "UPLIFE" ){
			g2d.drawImage(upLife, mX, mY, null);
		}
		
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		mX = arg0.getX() - this.tailleCase/2 ;
		mY = arg0.getY() - this.tailleCase/2 ;
		
		repaint();		
	}

	//bug parfois
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		
		int x = arg0.getX()/this.tailleCase ;
		int y = arg0.getY()/this.tailleCase ;
		
		
		if(arg0.getButton() == MouseEvent.BUTTON1){
			Editeur[x][y] = ImageCourante ;
		}
		
		else if(arg0.getButton() == MouseEvent.BUTTON3){
			Editeur[x][y] = null ;
		}
		
		repaint();
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void keyReleased(KeyEvent arg0) {
		char key = arg0.getKeyChar();
		
		//écriture
		if(key == 's'){
			try{
				fw = new FileWriter(JOptionPane.showInputDialog(null, "Entrez le chemin de sauvegarde en .txt :", "Editeur de map", JOptionPane.QUESTION_MESSAGE));
				
				for(int i = 0 ; i < this.nombreCases ; i++){
					for(int j = 0 ; j < this.nombreCases ; j++){
						
						if(Editeur[j][i] == "MUR"){
							fw.write("0");
						}
						
						else if(Editeur[j][i] == "BLOC"){
							fw.write("1");
						}
						
						else if(Editeur[j][i] == "JOUEUR"){
							fw.write("2");
						}
						
						else if(Editeur[j][i] == "OBJECTIF"){
							fw.write("3");
						}
						
						else if(Editeur[j][i] == null){
							fw.write(" ");
						}
						
						else if(Editeur[j][i] == "UPBOMB"){
							fw.write("4");
						}
						
						else if(Editeur[j][i] == "UPLIFE"){
							fw.write("5");
						}
					}
					fw.write("\r\n");
				}
				fw.close();
			}
			catch(Exception ex){
				
			}
		}
		
		//lecture
		if(key == 'l'){
			try{
				fr = new FileReader(JOptionPane.showInputDialog(null, "Entrez le chemin de lecture :", "Editeur de map", JOptionPane.QUESTION_MESSAGE));
				
				int i = 0 ;
				int x = 0 , y = 0 ;
				
				while((i = fr.read()) != -1){
					char strImg = (char) i ;
					
					if(strImg == '0'){
						Editeur[x][y] = "MUR";
					}
					
					else if(strImg == '1'){
						Editeur[x][y] = "BLOC";
					}
					
					else if(strImg == '2'){
						Editeur[x][y] = "JOUEUR";
					}
					
					else if(strImg == '3'){
						Editeur[x][y] = "OBJECTIF";
					}
					
					else if(strImg == ' '){
						Editeur[x][y] = null;
					}
					
					else if(strImg == '4'){
						Editeur[x][y] = "UPBOMB";
					}
					
					else if(strImg == '5'){
						Editeur[x][y] = "UPLIFE";
					}
					
					else if(strImg == '\r' || strImg == '\n'){
						x-- ;
					}
					
					if(x == this.nombreCases - 1){
						y++ ;
						x = 0 ;
					}
					else {
						x++ ;
					}
				}
				fr.close();
			}
			catch(Exception ex){
				System.out.println("problème..." + ex);
			}
		}
		
	}


	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent arg0) {
		int rot = arg0.getWheelRotation();
		
		if(rot <0){
			if(indexInc > 0){
				indexInc--;
			}
		}
		
		else if(rot >0){
			if(indexInc < 3){
				indexInc++ ;
			}
		}
		
		ImageCourante = ImageSelect[indexInc];
		
		repaint();
	}

}
