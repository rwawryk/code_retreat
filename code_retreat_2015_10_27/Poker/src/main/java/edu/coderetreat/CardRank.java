package edu.coderetreat;

public enum CardRank {

	TWO('2',2), THREE('3',3), FOUR('4',4), FIVE('5',5), SIX('6',6), SEVEN('7',7), EIGHT('8',8), 
	NINE('9',9), TEN('T',10), JACK('J',11), QUEEN('Q',12), KING('K',13), ACE('A',14);

	private char rankSymbol;
	private int value;

	CardRank(char rankSymbol, int value) {
		this.rankSymbol = rankSymbol;
		this.value = value;
	}

	public int order() {
		return this.ordinal();
	}
	public int getValue(){
		return value;
	}

	public static CardRank valueOf(char value) {
		for (CardRank suit : CardRank.values()) {
			if (value == suit.rankSymbol) {
				return suit;
			}
		}
		throw new IllegalArgumentException();
	}

}
