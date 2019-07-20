

/**
 * 
 * @author: Ivan Chan
 * @version 1.0
 * 
 * Simulates a Yahtzee game where 3 dice are rolled and the player is given a score based on the result of the roll.
 * The player starts with £1000 in the wallet, he must place a bet before the dice are rolled, bet can be any amount.
 * If no money are left in the wallet, the player must restart the game. The program also tracks the number of games,
 * each combinations and the total score in a single session.
 * 
 */

public class Yahtzee {
	private static double currentBet = 0;
	private static int yahtzeeCount = 0;
	private static int pairCount = 0;
	private static int straightCount = 0;
	private static int gameCount = 0;
	private static int score; 
	private static int totalScore = 0;
	static GUI gui = new GUI();
		
	static Dice die1 = new Dice();
	static Dice die2 = new Dice();
	static Dice die3 = new Dice();
	
	/**
	 * Rolls three dice by calling the roll() method from the Dice class.
	 */
	public static void rollDice(){
		die1.roll();
		die2.roll();
		die3.roll();
		gui.displayHand(die1, die2, die3);
		getResult();
		payOut(score);
	}	

	/** 
	 * Determines the result of the current dice hand.
	 * @return the score from the last roll after determining the result
	 */
	public static int getResult(){
		int compare = die1.compareTo(die2);
		int compare1 = die2.compareTo(die3);
		int compare2 = die1.compareTo(die3);
		//Compares the dice in hand to find any valid combinations.
		if(compare==0&&compare1==0&&compare2==0){
			gui.setResultLabel("All dice match - Yahtzee!");
			yahtzeeCount++;
			gui.setYahtzeeCountLabel(yahtzeeCount);
			score = 50;
		}
		else if(compare==0||compare1==0||compare2==0){
			gui.setResultLabel("Two dice match - Pair");
			pairCount++;
			gui.setPairCountLabel(pairCount);	
			score = die1.getFaceValue()+die2.getFaceValue()+die3.getFaceValue();
		}
		else if(compare==2&&compare1==2||compare==2&&compare2==2||compare1==2&&compare2==2){
			gui.setResultLabel("Straight");
			straightCount++;
			gui.setStraightCountLabel(straightCount);
			score = 30;
		}
		else{
			gui.setResultLabel("No matches");
			score = 0;
		}		
		gameCount++;
		totalScore = totalScore+score;
		gui.setScoreLabel(score);
		gui.setGameCountLabel(gameCount);
		gui.setTotalScoreLabel(totalScore);
		
		return score;
	}
	
	/**
	 * Calculates the winnings and adds it to the wallet.
	 * @param score the score from the last dice roll
	 */
	public static void payOut(int score){
		double winnings = currentBet*score/10;
		if(winnings>0){
			Wallet.addBalance(winnings+currentBet); //Adds the winnings to the wallet, original bet also refunded if the user wins.
			gui.setWalletLabel(); 
		}
		gui.setWinningsLabel(winnings);
		currentBet = 0; //Reset current bet.
		gui.resetBet();
		if(Wallet.getBalance()==0){
			gui.emptyWallet();
		}
	}
	
	/**
	 * Returns value of currentBet
	 * @return
	 */
	public static double getCurrentBet() {
		return currentBet;
	}
	
	/**
	 * Sets value of currentBet
	 * @param bet
	 */
	public static void setCurrentBet(double bet) {
		currentBet = bet;
	}
	
	/**
	 * Returns value of gameCount
	 * @return
	 */
	public static int getGameCount() {
		return gameCount;
	}
	
	/**
	 * Returns values of pairCount
	 * @return
	 */
	public static int getPairCount() {
		return pairCount;
	}
	
	/**
	 * Returns value of straightCount
	 * @return
	 */
	public static int getStraightCount() {
		return straightCount;
	}
	
	/**
	 * Returns value of yahtzeeCount
	 * @return
	 */
	public static int getYahtzeeCount() {
		return yahtzeeCount;
	}
	
	/**
	 * Returns value of score
	 * @return
	 */
	public static int getScore() {
		return score;
	}
	
	/**
	 * Returns value of totalScore
	 * @return
	 */
	public static int getTotalScore() {
		return totalScore;
	}
	
	public static void main(String[] args) {
		new Yahtzee();
	}

}