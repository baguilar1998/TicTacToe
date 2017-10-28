import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;
import javax.swing.*;


public class gameGui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static ImageIcon X,O;
	protected static JLabel [] s = new JLabel[9];
	private static JMenuBar menubar;
	private static JMenu file,help;
	private static JMenuItem newGame,exit,howToPlay;
	
	protected static int [] board = new int[9];
	protected static int XorO=0;
	public static int pieces=0;
	
	private ImageIcon icon = new ImageIcon(getClass().getResource("icon.png"));
	
	public gameGui(){
		setTitle("Tic Tac Toe");
		setResizable(false);
		setSize(600,600);
		setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		setIconImage(icon.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupGame();
		setVisible(true);
	}
	
	private void setUpMenu(){
		
		menubar=new JMenuBar();
		setJMenuBar(menubar);
		
		file = new JMenu("File");
		menubar.add(file);
		
		help = new JMenu("Help");
		menubar.add(help);
		
		howToPlay=new JMenuItem("How to Play");
		help.add(howToPlay);
		howToPlay.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				JOptionPane.showMessageDialog(null,"The object of Tic Tac Toe is to get three in a row.\n "
						+ "You play on a three by three game board. \n"
						+ "The first player is known as X and the second is O. \n"
						+ "Players alternate by placing Xs and Os on the game board \n"
						+ "until either opponent has three in a row or all nine squares are filled.\n"
						+ " X always goes first, and in the event that no one has three in a row, it is a tied game");
			}
		});
		newGame = new JMenuItem("New Game");
		file.add(newGame);
		
		newGame.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				clearGame();
			}
		});
		
		exit= new JMenuItem("Close Game");
		file.add(exit);
		
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
	}
	
	private void setupGame(){
		setLayout(new GridLayout(3,3));
		gameEvent e = new gameEvent();
		
		setUpMenu();
        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
		
		X= new ImageIcon(getClass().getResource("X.png"));
		O= new ImageIcon(getClass().getResource("O.png"));
		
		for(int i=0;i<s.length;++i){
			board[i]=-1;
			s[i]= new JLabel();
			s[i].setIcon(null);
			s[i].setSize(new Dimension(200,200));
			s[i].setBorder(border);
			add(s[i]);
			s[i].addMouseListener(e);
		}
	}
	
	protected static void checkGame(){
		
		if(gameChecker.rowCheck()==0){
			JOptionPane.showMessageDialog(null,"Player One has won!");
			gameEvent.enabled=false;
			return;
		}
		else if(gameChecker.rowCheck()==1){
			JOptionPane.showMessageDialog(null,"Player Two has won!");
			gameEvent.enabled=false;
			return;
		}
		
		if(gameChecker.verticalCheck()==0){
			JOptionPane.showMessageDialog(null,"Player One has won!");
			gameEvent.enabled=false;
			return;
		}
		else if(gameChecker.verticalCheck()==1){
			JOptionPane.showMessageDialog(null,"Player Two has won!");
			gameEvent.enabled=false;
			return;
		}
			
		if(gameChecker.diagonalCheck1()==0){
			JOptionPane.showMessageDialog(null,"Player One has won!");
			gameEvent.enabled=false;
			return;
		}
		else if(gameChecker.diagonalCheck1()==1){
			JOptionPane.showMessageDialog(null,"Player Two has won!");
			gameEvent.enabled=false;
			return;
		}
		
		if(gameChecker.diagonalCheck2()==0){
			JOptionPane.showMessageDialog(null,"Player One has won!");
			gameEvent.enabled=false;
			return;
		}
		else if(gameChecker.diagonalCheck2()==1){
			JOptionPane.showMessageDialog(null,"Player Two has won!");
			gameEvent.enabled=false;
			return;
		}
		
		pieces=gameChecker.getPieces();
		if(pieces==9){
			JOptionPane.showMessageDialog(null,"Tied Game :/");
			gameEvent.enabled=false;
		}
	}

	private void clearGame(){
		for(int i=0;i<9;++i){
			s[i].setIcon(null);
			board[i]=-1;
		}
		pieces=0;
		XorO=0;
		gameEvent.enabled=true;
	}
}
