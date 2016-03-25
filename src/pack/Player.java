package pack;
import java.util.ArrayList;

public class Player {

	String name;
	ArrayList<Card> cards = new ArrayList<Card>();
	int score;

	public Player(String name) {
		this.name = name;
		this.score = 0;
	}
	
	/**
	 * This method add cards to ArrayList and calculates the score
	 */
	public void receivesCard(Card card) {
		cards.add(card);
		score += card.value;
		// if the player receives an A and the score is higher then 21, the
		// value of the A is 1
		if (card.simbol.equals("A") && score > 21) {
			score -= 10;
		}
	}

	// this method reset the score to 0 and clean the list
	public void resetAll() {
		this.score = 0;
		cards.clear();
	}

}
