package gra;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class aaa extends JFrame{
	
	
	public void paintComponent(Graphics g) {  
        Image img = Toolkit.getDefaultToolkit().getImage(  
       		 okno_gry.class.getResource("/gra/url.gif"));  
        g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);  
   }

}
