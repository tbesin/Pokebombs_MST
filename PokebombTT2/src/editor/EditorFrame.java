package editor;

import javax.swing.JFrame;

public class EditorFrame extends JFrame {
	public EditorFrame(){
		this.setTitle("Editeur de map");
		EditorBoard eb = new EditorBoard();
		
		this.setSize(eb.frameDim, eb.frameDim);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.add(new EditorBoard());
		this.setVisible(true);
	}

}
