package pkg;

import javax.swing.JApplet;

public class Applet extends JApplet{

	private final int WIDTH = 700;
	private final int HEIGHT = 250;
	
	public void init(){
		
		Panel panel = new Panel(WIDTH, HEIGHT);
		this.getContentPane().add(panel);
		this.setSize(WIDTH, HEIGHT);
		
	}

}
