import java.util.Random;

/**
 * @author: Ivan Chan 
 * 
 * A class that simulates the rolling of a six-sided die using random number generator, 
 * to be used with the Yahtzee class to simulate a game of Yahtzee.
 * 
 */
public class Dice implements Comparable<Dice>{

	private int faceValue;
	
	/**
	 * Simulates a dice roll by randomly generating a number between 1-6.
	 */
	public void roll(){
		Random rand = new Random();
		faceValue = rand.nextInt(6) + 1;
	}
	
	/**
	 * Retrieves face value of the die thrown.
	 * @return value of the die thrown
	 */
	public int getFaceValue(){
		return faceValue;
	}
	
	/**
	 * Allows setting of faceValue manually, for testing purposes.
	 * @param newValue value to be set as the desired faceValue
	 */
	public void setFaceValue(int newValue){
		faceValue = newValue;
	}
	
	/**
	 * Maps faceValue of the die to a corresponding image.
	 * @return image showing the face of the die
	 */
	public String getImage(){
		String image;
		if(faceValue==1){
			image = "dice1.jpg";
		}
		else if(faceValue==2){
			image = "dice2.jpg";
		}
		else if(faceValue==3){
			image = "dice3.jpg";
		}
		else if(faceValue==4){
			image = "dice4.jpg";
		}
		else if(faceValue==5){
			image = "dice5.jpg";
		}
		else{
			image = "dice6.jpg";
		}
		return image;
	}


	/**
	 * The Dice class implements comparable, the compareTo() method is used to determine
	 * the result of a game of Yahtzee.
	 */
	public int compareTo(Dice dice) {
		
		if (this.getFaceValue()==dice.getFaceValue()){
			return 0;
		}
		else if (this.getFaceValue()-dice.getFaceValue()==1||this.getFaceValue()-dice.getFaceValue()==-1){
			return 2;
		}
		else{
			return 1;
		}
		
	}

}