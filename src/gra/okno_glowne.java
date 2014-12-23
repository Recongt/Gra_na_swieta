package gra;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;




import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Component;

import javax.swing.Box;

import java.awt.Insets;
import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;





import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class okno_glowne extends JFrame {
	public final static int TWO_SECOND = 2000;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long  krotka;
	private JPanel contentPane;
	private int ilosc_zyc;
	private int szybkosc;
	private boolean game_over=false;
	private int y;
	private int x;
	private int roznica;
	public int x_polozenie_paczki;
	public int y_polozenie_paczki;
	private int punkty = 0;
	
	private Image zycie = Toolkit.getDefaultToolkit().getImage(  
      		 okno_gry.class.getResource("/gra/Zycia.png"));
	protected Timer timer;
	
	/*
	private Image Aktywne_zycie = Toolkit.getDefaultToolkit().getImage(  
      		 okno_gry.class.getResource("/gra/bombka.png")); 
	
	private Image Stracone_zycie = Toolkit.getDefaultToolkit().getImage(  
     		 okno_gry.class.getResource("/gra/bombka_brooken.png"));

	*/

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					okno_glowne frame = new okno_glowne(int poziom);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public okno_glowne(int poziom) {
		
		if(poziom == 1){
			setTitle("Poziom ³atwy");
		}
		else if(poziom == 2){
			setTitle("poziom œredni");
		}
		else {
			setTitle("Poziom trudny");
		}
		ilosc_zyc = 3;
		
		

		
		
		/* Sprawdzenie wysokosci okna */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new panel_tlo();
		
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{64, 54, 69, 732, 0};
		gbl_contentPane.rowHeights = new int[]{41, 0, 50, 395, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Ilo\u015B\u0107 \u017Cy\u0107");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Unicode MS", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
		GridBagConstraints gbc_rigidArea = new GridBagConstraints();
		gbc_rigidArea.fill = GridBagConstraints.BOTH;
		gbc_rigidArea.insets = new Insets(0, 0, 5, 0);
		gbc_rigidArea.gridheight = 3;
		gbc_rigidArea.gridx = 3;
		gbc_rigidArea.gridy = 0;
		contentPane.add(rigidArea, gbc_rigidArea);
		
		JButton btnNewButton = new JButton("New button");
	

		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		final Zycia lblPierwsze = new Zycia();
		GridBagConstraints gbc_lblPierwsze = new GridBagConstraints();
		gbc_lblPierwsze.fill = GridBagConstraints.BOTH;
		gbc_lblPierwsze.insets = new Insets(0, 0, 5, 5);
		gbc_lblPierwsze.gridx = 0;
		gbc_lblPierwsze.gridy = 2;
		contentPane.add(lblPierwsze, gbc_lblPierwsze);
		
		final Zycia lblDrugie = new Zycia();
		lblDrugie.setBackground(Color.BLACK);
		GridBagConstraints gbc_lblDrugie = new GridBagConstraints();
		gbc_lblDrugie.fill = GridBagConstraints.BOTH;
		gbc_lblDrugie.insets = new Insets(0, 0, 5, 5);
		gbc_lblDrugie.gridx = 1;
		gbc_lblDrugie.gridy = 2;
		contentPane.add(lblDrugie, gbc_lblDrugie);
		
		final Zycia lblTrzecie = new Zycia();
		lblTrzecie.setBackground(Color.DARK_GRAY);
		
		lblTrzecie.setOpaque(true);
		
		
		GridBagConstraints gbc_lblTrzecie = new GridBagConstraints();
		gbc_lblTrzecie.fill = GridBagConstraints.BOTH;
		gbc_lblTrzecie.insets = new Insets(0, 0, 5, 5);
		gbc_lblTrzecie.gridx = 2;
		gbc_lblTrzecie.gridy = 2;
		contentPane.add(lblTrzecie, gbc_lblTrzecie);
		
		final Panel_z_tlem Panel_gry = new Panel_z_tlem();
		Panel_gry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int myszka_x=getX();
				int myszka_y=getY();
				
				if(myszka_x>=x_polozenie_paczki && myszka_x <= (x_polozenie_paczki+50) && myszka_y>=y_polozenie_paczki && myszka_y <= (y_polozenie_paczki+50)){
					punkty = punkty +1;
					System.out.print("Trafione!\n");
					
				}
				else{
					ilosc_zyc = ilosc_zyc-1;
					System.out.print("Pudlo!\n");
				}
				System.out.print(myszka_x);
				System.out.print(" ");
				System.out.print(x_polozenie_paczki);
				System.out.print("\n");
				System.out.print(myszka_y);
				System.out.print(" ");
				System.out.print(y_polozenie_paczki);
				System.out.print("\n");
				
				
				
				
				
			}
		});

		/* Obczaic warunki i dlaczego nie znika ilosc zyc*/
		
		
		
		

		int a= Panel_gry.getHeight();
		Panel_gry.setBackground(Color.WHITE);
		GridBagConstraints gbc_Panel_gry = new GridBagConstraints();
		gbc_Panel_gry.fill = GridBagConstraints.BOTH;
		gbc_Panel_gry.gridwidth = 4;
		gbc_Panel_gry.gridx = 0;
		gbc_Panel_gry.gridy = 3;
		contentPane.add(Panel_gry, gbc_Panel_gry);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int h = screenSize.height;
		int w = screenSize.width;
		setSize(new Dimension(w/2, h/2));
		setMinimumSize(new Dimension(w/2, h/2));

		
		
		
	

	
		
	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//return (int)(Math.random() * range) + min;
			/*	
				y =(int)( Math.random() * ( (Panel_gry.getHeight()-50)  ));
				x = (int)( Math.random() * ( (Panel_gry.getWidth()-50)  ));
				Image im = Toolkit.getDefaultToolkit().getImage(  
			      		 okno_gry.class.getResource("/gra/gifty/gift1.png"));
				
				roznica = getHeight() - Panel_gry.getHeight();
				Graphics g = getGraphics();
				g.drawImage(im, x, y+roznica, 50, 50, null);
				g.dispose();
				
				*/
				timer.start();
				
				System.out.print("Wysokosc okna ");
				System.out.print(getHeight());
				System.out.print("\n");
				System.out.print("Wysokosc okna malego ");
				System.out.print(Panel_gry.getHeight());
				System.out.print("\n");
				System.out.print("Roznica ");
				System.out.print(roznica);
				System.out.print("\n");
			
				
				
			}
		});
		System.out.print("Wysokosc okna ");
		System.out.print(getHeight());
		System.out.print("\n");
		System.out.print("Wysokosc okna malego ");
		System.out.print(a);
		System.out.print("\n");
		System.out.print("Roznica ");
		System.out.print(roznica);
		System.out.print("\n");
		
		timer = new Timer(TWO_SECOND, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		    	
		    	
		    	
		    	
			//Stworz nowy prezent
		    	
		    	if((krotka % 2) == 1){
		    		repaint();
				}
		    	else{
		    	y =(int)( Math.random() * ( (Panel_gry.getHeight()-50)  ));
				x = (int)( Math.random() * ( (Panel_gry.getWidth()-50)  ));
				Image im = Toolkit.getDefaultToolkit().getImage(  
			      		 okno_gry.class.getResource("/gra/gifty/gift1.png"));
				
				roznica = getHeight() - Panel_gry.getHeight();
				Graphics g = getGraphics();
				g.drawImage(im, x, y+roznica, 50, 50, null);
				g.dispose();
				x_polozenie_paczki=x;
				y_polozenie_paczki=y;
				
		    	}
		    	
		    	System.out.print(krotka);
		    	krotka = krotka + 1;
				if(ilosc_zyc == 3){	
					lblTrzecie.setVisible(true);
					lblDrugie.setVisible(true);
					lblPierwsze.setVisible(true);			
				}
				else if(ilosc_zyc == 2){
					lblTrzecie.setVisible(false);
					lblDrugie.setVisible(true);
					lblPierwsze.setVisible(true);
				}
				else if(ilosc_zyc == 1){
					lblTrzecie.setVisible(false);
					lblDrugie.setVisible(false);
					lblPierwsze.setVisible(true);
				}
				else{
					lblTrzecie.setVisible(false);
					lblDrugie.setVisible(false);
					lblPierwsze.setVisible(false);
					game_over=true;
				}

		    	
		        if (game_over==true) {
		            timer.stop();
		            //...Update the GUI...*/
		        }
		    }    
		});
		
		
	}
	

}



