package pack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		//the deck of cards
		ArrayList<Card> deck = new ArrayList<Card>();
		deck.add(new Card("heart", "2", 2));
		deck.add(new Card("diamond", "2", 2));
		deck.add(new Card("club", "2", 2));
		deck.add(new Card("spade", "2", 2));
		deck.add(new Card("heart", "3", 3));
		deck.add(new Card("diamond", "3", 3));
		deck.add(new Card("club", "3", 3));
		deck.add(new Card("spade", "3", 3));
		deck.add(new Card("heart", "4", 4));
		deck.add(new Card("diamond", "4", 4));
		deck.add(new Card("club", "4", 4));
		deck.add(new Card("spade", "4", 4));
		deck.add(new Card("heart", "5", 5));
		deck.add(new Card("diamond", "5", 5));
		deck.add(new Card("club", "5", 5));
		deck.add(new Card("spade", "5", 5));
		deck.add(new Card("heart", "6", 6));
		deck.add(new Card("diamond", "6", 6));
		deck.add(new Card("club", "6", 6));
		deck.add(new Card("spade", "6", 6));
		deck.add(new Card("heart", "7", 7));
		deck.add(new Card("diamond", "7", 7));
		deck.add(new Card("club", "7", 7));
		deck.add(new Card("spade", "7", 7));
		deck.add(new Card("heart", "8", 8));
		deck.add(new Card("diamond", "8", 8));
		deck.add(new Card("club", "8", 8));
		deck.add(new Card("spade", "8", 8));
		deck.add(new Card("heart", "9", 9));
		deck.add(new Card("diamond", "9", 9));
		deck.add(new Card("club", "9", 9));
		deck.add(new Card("spade", "9", 9));
		deck.add(new Card("heart", "10", 10));
		deck.add(new Card("diamond", "10", 10));
		deck.add(new Card("club", "10", 10));
		deck.add(new Card("spade", "10", 10));
		deck.add(new Card("heart", "A", 11));
		deck.add(new Card("diamond", "A", 11));
		deck.add(new Card("club", "A", 11));
		deck.add(new Card("spade", "A", 11));
		deck.add(new Card("heart", "J", 10));
		deck.add(new Card("diamond", "J", 10));
		deck.add(new Card("club", "J", 10));
		deck.add(new Card("spade", "J", 10));
		deck.add(new Card("heart", "Q", 10));
		deck.add(new Card("diamond", "Q", 10));
		deck.add(new Card("club", "Q", 10));
		deck.add(new Card("spade", "Q", 10));
		deck.add(new Card("heart", "K", 10));
		deck.add(new Card("diamond", "K", 10));
		deck.add(new Card("club", "K", 10));
		deck.add(new Card("spade", "K", 10));

		Player user = new Player("Marcel");
		Player dealer = new Player("Dealer");

		System.out.println("Do you want to start the game? yes/no");
		String desirePlay;
		desirePlay = scanner.nextLine();

		if ("yes".equals(desirePlay)) {
			do {
				user.resetAll();
				dealer.resetAll();
				System.out.println("Welcome to BlackJack!");
				// mix the cards
				Collections.shuffle(deck);
				
				user.receivesCard(deck.get(0));
				user.receivesCard(deck.get(1));
				dealer.receivesCard(deck.get(2));
				dealer.receivesCard(deck.get(3));
				int indexDeck = 4;

				// Display two cards for the player and one card for the dealer
				System.out.println("Your cards are: " + deck.get(0).simbol + " " + deck.get(0).color + "    "
						+ deck.get(1).simbol + " " + deck.get(1).color);
				System.out.println("Dealer's first card is: " + deck.get(2).simbol + " " + deck.get(2).color);

				// logic of the player
				boolean lost = false;
				String optChoice;

				do {

					System.out.println("You have accumulated " + user.score + " points.");

					if (user.score == 21) {
						System.out.println("Congratulations! You have BlackJack!");
						break;
					} else {
						System.out.println("Do you want more cards? yes/no");
						optChoice = scanner.nextLine();
					}
					if (optChoice.equalsIgnoreCase("yes")) {
						user.receivesCard(deck.get(indexDeck));
						System.out.println("You got " + deck.get(indexDeck).simbol + " " + deck.get(indexDeck).color
								+ " and you have " + user.score + " points.");
						indexDeck++;
						if (user.score == 21) {
							System.out.println("Congratulations! You have BlackJack!");
							break;
						} else if (user.score > 21) {
							lost = true;
							break;
						} else if (user.score < 21) {
							continue;
						}
					} else if (optChoice.equalsIgnoreCase("no")) {
						System.out.println("You stopped at " + user.score + " points.");
						break;
					}
				} while (!optChoice.equalsIgnoreCase("no") && user.score < 21);

				if (lost == true) {
					System.out.println("You lost.");
				} else {

					// here starts the logic of the dealer
					System.out.println();
					System.out.println("The cards of the dealer: " + deck.get(2).simbol + " " + deck.get(2).color
							+ "    " + deck.get(3).simbol + " " + deck.get(3).color);
					if (dealer.score == user.score) {
						System.out.println("Split.");
						break;
					} else if (dealer.score > user.score && dealer.score <= 21) {
						System.out.println("Dealer has "+dealer.score+ " points");
						System.out.println("Dealer won.");
					} else if (dealer.score < user.score) {
						do {
							System.out.println("Dealer got another card.");
							System.out.println();
							dealer.receivesCard(deck.get(indexDeck));
							System.out.println("The dealer's card is " + deck.get(indexDeck).simbol + " "
									+ deck.get(indexDeck).color + " and now has " + dealer.score + " points.");
							indexDeck++;
							if (dealer.score == 21 && dealer.score > user.score) {
								System.out.println("Dealer won.");
								break;
							} else if (dealer.score > user.score && dealer.score < 21) {
								System.out.println("Dealer won.");
								break;
							} else if (dealer.score > 21) {
								System.out.println(" Player won.");
								break;
							} else if (dealer.score == user.score) {
								System.out.println("Split.");
								break;
							}

						} while (dealer.score < user.score || dealer.score < 21);

					}
				}
				System.out.println("Do you want to play again?");
				desirePlay = scanner.nextLine();
			} while ("yes".equals(desirePlay));
		}
	}
}
