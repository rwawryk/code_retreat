package edu.coderetreat;

public enum CardSuit {

	CLUBS('C'), DIAMONDS('D'), SPADES('S'), HEARTS('H');

	private char suitSymbol;

	CardSuit(char suitSymbol) {
		this.suitSymbol = suitSymbol;
	}

	public static CardSuit valueOf(char value) {
		for (CardSuit suit : CardSuit.values()) {
			if (value == suit.suitSymbol) {
				return suit;
			}
		}
		throw new IllegalArgumentException();
	}

}
