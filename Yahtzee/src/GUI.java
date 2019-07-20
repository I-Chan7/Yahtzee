import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 * 
 * @author Ivan Chan
 *
 * GUI for Yahtzee
 * 
 */

public class GUI extends JFrame{

	private static final long serialVersionUID = -6208361154880723348L;
	private JLabel lblScoreRule, lblYahtzeeScore, lblPairScore, lblStraightScore, lblPayout, 
	lblWallet, lblPlaceBet, lblCurrentBet, lblDie1, lblDie2, lblDie3, lblResult, lblWinnings, 
	lblYahtzeeCount, lblPairCount, lblStraightCount, lblGameCount, lblScore, lblTotalScore;
	private JTextField txtBet;
	private JButton btnBet, btnRoll, btnExit;	
	private JPanel panel;
	private JFrame frame;
	private double bet;
	NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
	
	
	/**
	 * Initialises the GUI.
	 */
	public GUI(){ 
		createForm();
		addFields();
		addButtons();
		
		frame.add(panel); 
		frame.setVisible(true);
	}
	
	/**
	 * Creates the GUI where the game will be played.
	 */
	public void createForm(){
		frame = new JFrame();
		frame.setTitle("Yahtzee");
		frame.setSize(600,300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(null);
		Color c = new Color(210, 210, 210);
		panel.setBackground(c);
	}
	
	/**
	 * Determines the position of all labels and text components on the GUI.
	 */
	public void addFields(){ 
		lblScoreRule = new JLabel("Scores:");
		lblScoreRule.setBounds(420, 40, 150, 20);
		panel.add(lblScoreRule);
		
		lblYahtzeeScore = new JLabel("Yahzee - 50");
		lblYahtzeeScore.setBounds(420, 60, 150, 20);
		panel.add(lblYahtzeeScore);
		
		lblStraightScore = new JLabel("Straight - 30");
		lblStraightScore.setBounds(420, 80, 150, 20);
		panel.add(lblStraightScore);
		
		lblPairScore = new JLabel("Pair - Sum of Dice Values");
		lblPairScore.setBounds(420, 100, 150, 20);
		panel.add(lblPairScore);
		
		lblPayout = new JLabel("Payout = Bet x Score / 10");
		lblPayout.setBounds(420, 120, 150, 20);
		panel.add(lblPayout);
		
		lblWallet = new JLabel("Your Wallet: "+fmt1.format(Wallet.getBalance())); //displays the current wallet balance.
		lblWallet.setBounds(40, 150, 150, 20);
		panel.add(lblWallet);
		
		lblPlaceBet = new JLabel("Place Your Bet:");
		lblPlaceBet.setBounds(40, 170, 100, 20);
		panel.add(lblPlaceBet);
		
		txtBet = new JTextField(); //text field where the user enters the betting amount.
		txtBet.setBounds(40, 190, 100, 20);
		panel.add(txtBet);
		
		lblCurrentBet = new JLabel("Current Bet: "+fmt1.format(Yahtzee.getCurrentBet())); //displays the current accepted bet.
		lblCurrentBet.setBounds(200, 50, 200, 20);
		lblCurrentBet.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCurrentBet);
		
		ImageIcon diceImage1 = new ImageIcon(getClass().getResource("dice1.jpg"));
		lblDie1 = new JLabel(diceImage1);
		lblDie1.setBounds(210, 80, 50, 50);
		panel.add(lblDie1);
		/* the result of a dice roll is represented as images showing the faces of the dice, all 3 dice show the
		 * value 1 by default.
		 */
		
		ImageIcon diceImage2 = new ImageIcon(getClass().getResource("dice1.jpg"));		
		lblDie2 = new JLabel (diceImage2);
		lblDie2.setBounds(275, 80, 50, 50);
		panel.add (lblDie2);
		
		ImageIcon diceImage3 = new ImageIcon(getClass().getResource("dice1.jpg"));
		lblDie3 = new JLabel (diceImage3);
		lblDie3.setBounds(340, 80, 50, 50);
		panel.add (lblDie3);
	
		lblResult = new JLabel(""); //displays the result of the last dice roll.
		lblResult.setBounds(200, 140, 200, 20);
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add (lblResult);
		
		lblScore = new JLabel(""); //displays the score from the last dice roll.
		lblScore.setBounds(200, 165, 200, 20);
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add (lblScore);
		
		lblWinnings = new JLabel(""); //displays the amount of money won from the last dice roll.
		lblWinnings.setBounds(200, 190, 200, 20);
		lblWinnings.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add (lblWinnings);
		
		lblGameCount = new JLabel("Played: "+ Yahtzee.getGameCount()); //displays the total number of games played in the current session.
		lblGameCount.setBounds(40, 20, 100, 20);
		panel.add (lblGameCount);
		
		lblYahtzeeCount = new JLabel("Yahtzee: "+ Yahtzee.getYahtzeeCount()); //displays the number of the times the user has rolled a Yahtzee.
		lblYahtzeeCount.setBounds(40, 40, 100, 20);
		panel.add (lblYahtzeeCount);
		
		lblStraightCount = new JLabel("Straight: "+ Yahtzee.getStraightCount()); //displays the number of times the user has rolled a straight.
		lblStraightCount.setBounds(40, 60, 100, 20);
		panel.add (lblStraightCount);
		
		lblPairCount = new JLabel("Pairs: "+ Yahtzee.getPairCount()); //displays the number of times the user has rolled a pair.
		lblPairCount.setBounds(40, 80, 100, 20);
		panel.add (lblPairCount);
	
		lblTotalScore = new JLabel("Total Score: "+ Yahtzee.getTotalScore()); //displays the total score accumulated in the current session.
		lblTotalScore.setBounds(40, 100, 100, 20);
		panel.add (lblTotalScore);
	}
	
	/**
	 * Implements buttons allowing the user to make bets, roll the dice or exit the game.
	 */
	public void addButtons(){ 
		btnBet = new JButton ("Bet");
		btnBet.setBounds(40, 220, 100, 20);
		btnBet.addActionListener(new BetHandler());
		panel.add (btnBet);
		
		btnRoll = new JButton ("Roll Dice");
		btnRoll.setBounds(250, 220, 100, 20);
		btnRoll.addActionListener(new RollHandler());
		panel.add (btnRoll);

		btnExit = new JButton ("Exit");
		btnExit.setBounds(450, 220, 100, 20);
		btnExit.addActionListener(new ExitHandler());  
		panel.add (btnExit);
	}
	
	class BetHandler implements ActionListener { //handles the bet amount entered by the user when the "Bet" button is pressed.
		public void actionPerformed(ActionEvent event) {
			if(bet>0){
				JOptionPane.showMessageDialog(frame, "You have already placed a bet"); 
				txtBet.setText(""); 
			} //A message box will display if the user attempts to make another bet while one is already in place.
			else{
					try{
					bet = Double.parseDouble(txtBet.getText()); //takes the value of the bet entered by user 
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(frame, "Please enter a valid amount", "ERROR", JOptionPane.ERROR_MESSAGE);
						txtBet.setText(""); 
						/* An error box will display if a double is not entered, resetting the text field allowing the user to 
						 * re-enter a valid bet.
						 */
				} 
				
					if(bet>Wallet.getBalance()){
						JOptionPane.showMessageDialog(frame, "You do not have enough money to make "
								+ "this bet"); 
						txtBet.setText("");
						bet = 0; 
						/* A message box will display if the user attempts to enter a bet higher than the amount left in wallet, the 
						 * text field and the current bet will both reset as the bet is not valid.
						 */
					}
					if(bet<0){
						JOptionPane.showMessageDialog(frame, "Please enter a valid amount", 
								"ERROR", JOptionPane.ERROR_MESSAGE); //error box will display if a negative number is entered. 
							txtBet.setText("");
					}
					else{
						lblCurrentBet.setText("Current Bet: "+fmt1.format(bet));
						txtBet.setText("");
						Wallet.subtractBalance(bet);
						Yahtzee.setCurrentBet(bet);
						lblWallet.setText("Your Wallet: "+fmt1.format(Wallet.getBalance()));
						/* Once a valid bet has been accepted the amount will display next to the Label "Current Bet" and the same amount 
						 * will be subtracted from the wallet.
						 */
					} 
			}
		}
	}
	
	class RollHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(bet==0){
				JOptionPane.showMessageDialog(frame, "Please place a bet first.");
				// An error message will be displayed if the user attempts to click the "Roll" button without making a bet first.
			}
			else{
				Yahtzee.rollDice();
				// The above methods will be called when the user clicks the "Roll" button.
			}
		}
	}
		
	class ExitHandler implements ActionListener { 
		public void actionPerformed(ActionEvent event) {
			int n = JOptionPane.showConfirmDialog(frame, 
					"Are you sure you want to exit?", 
					"Exit?", 
					JOptionPane.YES_NO_OPTION);
			if(n == JOptionPane.YES_OPTION){
				System.exit(0);
				// The program will terminate if the user chooses to exit the game.
			}
		}
	}
	
	/**
	 * Retrieves images using getImage() method from the Dice class the maps them to the corresponding ImageIcon.
	 */
	public void displayHand(Dice die1, Dice die2, Dice die3){
		ImageIcon diceImage1 = new ImageIcon(getClass().getResource(die1.getImage()));
		lblDie1.setIcon(diceImage1);
		ImageIcon diceImage2 = new ImageIcon(getClass().getResource(die2.getImage()));
		lblDie2.setIcon(diceImage2);
		ImageIcon diceImage3 = new ImageIcon(getClass().getResource(die3.getImage()));
		lblDie3.setIcon(diceImage3);
		/* Calls the getImage method from the Dice class, gets the image showing the correct value of the dice rolled and 
		 * displays them on the GUI.
		 */
	}
	
	/**
	 * Sets lblResult
	 * @param result
	 */
	public void setResultLabel(String result) {
		lblResult.setText(result);
	}
	
	/**
	 * Sets lblYahtzeeCount
	 * @param yahtzeeCount
	 */
	public void setYahtzeeCountLabel(int yahtzeeCount) {
		lblYahtzeeCount.setText("Yahtzee: "+yahtzeeCount);
	}
	
	/**
	 * Sets lblPairCount
	 * @param pairCount
	 */
	public void setPairCountLabel(int pairCount) {
		lblPairCount.setText("Pairs: "+pairCount);
	}
	
	/**
	 * Sets lblStraightCount
	 * @param straightCount
	 */
	public void setStraightCountLabel(int straightCount) {
		lblStraightCount.setText("Straights: "+straightCount);
	}
	
	/**
	 * Sets lblScore
	 * @param score
	 */
	public void setScoreLabel(int score) {
		if (score > 0) {
			lblScore.setText("You have scored "+score+" points");
		}
		else {
			lblScore.setText(""); //Nothing will be displayed if the score from the last roll is 0.
		}
			
	}
	
	/**
	 * Sets GameCount
	 * @param gameCount
	 */
	public void setGameCountLabel(int gameCount) {
		lblGameCount.setText("Played: "+ gameCount);
	}
	
	/**
	 * Sets lblTotalScore
	 * @param totalScore
	 */
	public void setTotalScoreLabel(int totalScore) {
		lblTotalScore.setText("Total Score: "+ totalScore);
	}
	
	/**
	 * Sets lblWinnings
	 * @param winnings
	 */
	public void setWinningsLabel(double winnings) {
		if (winnings > 0) {
			lblWinnings.setText("Winnings: "+fmt1.format(winnings));
		}
		else {
			lblWinnings.setText("");
		}
	}
	
	/**
	 * Sets lblWallet
	 */
	public void setWalletLabel() {
		lblWallet.setText("Your Wallet: "+fmt1.format(Wallet.getBalance())); 
	}
	
	/**
	 * Resets current betting amount at the end of the round
	 */
	public void resetBet() {
		lblCurrentBet.setText("Current Bet: "+fmt1.format(0));
		bet = 0;
	}
	
	/**
	 * Exits the game when wallet balance = 0
	 */
	public void emptyWallet() {
		JOptionPane.showMessageDialog(frame, "Your wallet is empty.");	
		System.exit(0);
		
	}
}
