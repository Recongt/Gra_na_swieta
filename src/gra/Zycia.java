package gra;



import java.awt.Graphics;
import java.awt.Image;

import java.awt.Toolkit;



import javax.swing.JPanel;

public class Zycia extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3669599482338981598L;

	/**
	 * 
	 */

	

	

	public void paintComponent(Graphics g) {  
        Image img = Toolkit.getDefaultToolkit().getImage(  
       		 okno_gry.class.getResource("/gra/bombka.png"));  
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
   } 
	

   } 

