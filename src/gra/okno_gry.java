package gra;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class okno_gry extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private int poziom;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					okno_gry frame = new okno_gry();
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
	public okno_gry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 512);
		contentPane = new panel_okno_startowe();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Wybierz poziom");
		lblNewLabel.setFont(new Font("Bauhaus 93", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(257, 169, 156, 35);
		contentPane.add(lblNewLabel);
		
		JButton btn£atwy = new JButton("\u0141atwy");
		btn£atwy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				poziom = 1;
				okno_glowne	latwy= new okno_glowne(1);
				latwy.show(true);
				dispose();
			}
		});
		btn£atwy.setForeground(SystemColor.desktop);
		btn£atwy.setBounds(291, 227, 89, 23);
		contentPane.add(btn£atwy);
		
		JButton btnŒredni = new JButton("\u015Aredni");
		btnŒredni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poziom = 2;
				new okno_glowne(2).show(true);
				
				dispose();
			}
		});
		btnŒredni.setBounds(291, 261, 89, 23);
		contentPane.add(btnŒredni);
		
		JButton btnTrudny = new JButton("Trudny");
		btnTrudny.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poziom = 3;
				 new okno_glowne(3).show(true);
				 dispose();
			}
		});
		btnTrudny.setBounds(291, 295, 89, 23);
		contentPane.add(btnTrudny);
	}
}
