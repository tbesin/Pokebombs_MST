import javax.swing.JFrame;

import editor.*;
import View.*;
import Modele.*;
import Controller.*;

public class Main {

	public static void main(String[] args) {
	GameView frame = new GameView();
	
	//frame.setSize(600,800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
		
		//�diteur
		//EditorFrame efr = new EditorFrame() ;
	}

}
