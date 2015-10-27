package edu.coderetreat;

public enum PokerRank {

	HIGH_CARD(0), 
	ONE_PAIR(1), 
	TWO_PAIRS(2), 
	THREE_OF_KIND(3),
	STRAIGHT(4), 
	FLUSH(5), 
	FULL_OF_HOUSE(6), 
	FOUR_OF_KIND(7), 
	STRAIGHT_FLUSH(8), 
	ROYAL_FLUSH(9);

	private int rank;

	PokerRank(int rank) {
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}
}
