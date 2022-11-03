import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.swing.border.EmptyBorder;


public class gameView extends JFrame{
    private JPanel contentPane;
    private static JLabel charx;
	private static JLabel Tlight;
	private static JLabel greenLight;
	private static JLabel yellowLsight;
	private static JLabel Level;
    private static Timer time = new Timer();
	private static Timer light = new Timer();
    private static TimerTask tt;
	private static TimerTask lightTask;
    private static int x;
	private static String color;
	private static int check = 100000;
	private static long elapsed;
	private static int y=200;
	private static int speed = 1;
	private static int level = 1;

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
    public void timer(String state){
		color = "green";
		int Telapsed;
		tt = new TimerTask(){

			public void run(){
				elapsed +=1 ;
				if(!(state.equals("red"))) {

					x += speed;
					charx.setBounds(x, y , 90, 30);
					if((check <x-10) ){
						
						x = 0;
						time.cancel();
						reset();

					}

					if(x >= 950){
						gameEvents("win");
						reset();
					}
					
					
					//int xx = ThreadLocalRandom.current().nextInt(60, 80 + 1);
					if(elapsed > ThreadLocalRandom.current().nextInt(60, 200 + 1) ){
						
						elapsed = 0;
						check = x;
						Tlight.setBackground(Color.red);
						color = "red";
						
					}
					else{

					}
					
				}
				else{
				}
				
			}
		};
		time.schedule(tt, 1, 20);


	}

	public void reset(){
		charx.setBounds(0, 200 , 90, 30);
		check = 100000;
		x = 0;
		Tlight.setBackground(Color.green);

	}
	//
	//

	public static void light(Long duration){
		Long dur = duration*1000;
		lightTask = new TimerTask(){
			public void run(){
				elapsed += 1;
				Tlight.setBackground(Color.red);
				if(elapsed == dur){
					Tlight.setBackground(Color.green);
				}
			}
		};
		light.schedule(tt, 1, dur);
	}

	//
	//
	public void Controller(String state){
		timer(state);
		System.out.println(state);
		
		
	}
	public void gameEvents(String Case){
		if(Case.equalsIgnoreCase("win")){
			JOptionPane.showMessageDialog(null, "Congratulations you won the game! \n Level up!!");
			level += 1; 
			levelUp();
		}

	}

	public void levelUp(){
		speed =+ 2;
		Level.setText("Level: " + String.valueOf(level));
	}
	

    public gameView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 992, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setResizable(false);
		addKeyListener(new KeyAdapter(){
			@Override
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode()== KeyEvent.VK_SPACE){
					
					try{
						Controller("green");
					}
					catch(IllegalStateException exp){
						time = new Timer();
						Controller("green");
					}
				}
				if(e.getKeyCode()== KeyEvent.VK_SHIFT){
					
					time.cancel();
					try{
						TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(1, 3+ 1) );
						Tlight.setBackground(Color.green);
					}
					catch(InterruptedException intE){

					}
					
					elapsed = 0;
					check = 10000;
				}
				if(e.getKeyCode()== KeyEvent.VK_LEFT){
					y = y - 40;
					if(y<180){
						y = 180;

					}
					
				}
				if(e.getKeyCode()== KeyEvent.VK_RIGHT){
					y = y + 40;
					if(y>240){
						y = 240;
					}
					
				}
			}
		});
		contentPane.setLayout(null);
//char
        charx = new JLabel();
        charx.setBounds(0, 200, 90, 30);
        charx.setOpaque(true);
        charx.setBackground(Color.black);
        contentPane.add(charx);

		Tlight = new JLabel();
        Tlight.setBounds(902, 0, 90, 30);
        Tlight.setOpaque(true);
        Tlight.setBackground(Color.green);
        contentPane.add(Tlight);

		

		Level = new JLabel();
        Level.setBounds(0, 0, 100, 30);
        Level.setText("Level: " + String.valueOf(level));
		Level.setHorizontalAlignment(SwingConstants.CENTER);
		Level.setFont(new Font("Times new roman",Font.BOLD, 16));
        contentPane.add(Level);

    
    }
    

}