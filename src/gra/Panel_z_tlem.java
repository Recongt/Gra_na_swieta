package gra;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class Panel_z_tlem extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {  
        Image img = Toolkit.getDefaultToolkit().getImage(  
       		 okno_gry.class.getResource("/gra/tloPanelu.jpg"));  
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
   } 
}
