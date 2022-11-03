import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.*;

public class mainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainView frame = new mainView();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */


	public mainView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		contentPane.setLayout(null);
		

		JButton playButton = new JButton("Play");
		playButton.setHorizontalAlignment(SwingConstants.CENTER);
		playButton.setBounds(451, 373, 90, 30);
		playButton.setBorder(null);
		playButton.setOpaque(true);
		playButton.setBackground(Color.white);
		playButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				playButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				playButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				
			}
			@Override
			
		
			public void mouseClicked(MouseEvent e) {
				dispose();
				gameView nw = new gameView();
				nw.setVisible(true);
					
				
			};
				
		});
		contentPane.add(playButton);

		/*JLabel charGif = new JLabel();
		charGif.setIcon(new ImageIcon("/Users/saugatsingh/Downloads/running-stickman-unscreen.gif"));
		charGif.setBounds(0,70,312,376);
		charGif.setBackground(Color.black);
		contentPane.add(charGif);

		JLabel roadGif = new JLabel();
		roadGif.setIcon(new ImageIcon("/Users/saugatsingh/eclipse-workspace/squid game/images/7839761c1cc3eb9.png.gif"));
		roadGif.setBounds(0, 123, 569, 422);
		contentPane.add(roadGif);
		
		JLabel background = new JLabel();
		Image img = new ImageIcon("/Users/saugatsingh/eclipse-workspace/squid game/images/background.png").getImage();
		background.setIcon(new ImageIcon(img));
		background.setBounds(0, 0, 992, 561);
		contentPane.add(background);
		*/
		
		
		
	}}
		
	

