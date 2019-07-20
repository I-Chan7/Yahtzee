/**
 * 
 * @author: Ivan Chan i7953483
 * @version 1.0
 * 
 * User wallet, allows other classes the check, add to or subtract from the balance.
 * 
 */

public class Wallet {
	private static double balance = 1000;
	
	/**
	 * Retrieves wallet balance
	 * @return
	 */
	public static double getBalance() {
		return balance;
	}
	
	/**
	 * Adds balance to wallet
	 * @param value
	 * @return
	 */
	public static double addBalance(double value) {
		return balance += value;
	}
	
	/**
	 * Subtracts value from wallet
	 * @param value
	 * @return
	 */
	public static double subtractBalance(double value) {
		return balance -= value;
	}
}
	