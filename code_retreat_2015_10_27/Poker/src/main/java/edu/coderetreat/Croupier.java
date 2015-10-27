package edu.coderetreat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Croupier {

	/**
	 * Ranks poker hand. Card is coded as two letters: first indicating card
	 * rank and second its color e.g. KH means King of Hearts
	 * 
	 * Card ranks: A - Ace K - King Q - Queen J - Jack T - Ten 9 - 9 .... 2 - 2
	 * Card suits: H - Hearts D - Diamonds C - Clubs S - Spades
	 * 
	 * @param pokerHand
	 *            string containing 5 cards separated by a space.
	 * @return poker rank
	 */
	public PokerRank rankPokerHand(String pokerHand) {
		String[] cards = pokerHand.split(" ");

		Map<Character, Integer> histogram = calculateHistogram(cards);

		switch (histogram.size()) {
		case 5:
			return considerFiveOnesPattern(cards, histogram);
		case 4:
			return PokerRank.ONE_PAIR;
		case 3:
			if (isThreeCardInIt(histogram)) {
				return PokerRank.THREE_OF_KIND;
			} else {
				return PokerRank.TWO_PAIRS;
			}

		case 2:
			if (isThreeCardInIt(histogram)) {
				return PokerRank.FULL_OF_HOUSE;
			}
			return PokerRank.FOUR_OF_KIND;

		default:
			return null;
		}

	}

	private PokerRank considerFiveOnesPattern(String[] cards,
			Map<Character, Integer> histogram) {
		if (areFiguresStraight(histogram)) {
			if (areCardsTheSameColour(cards)) {
				return PokerRank.ROYAL_FLUSH;
			} else {
				return PokerRank.STRAIGHT;
			}
		} else {
			return PokerRank.HIGH_CARD;
		}
	}

	private boolean areCardsTheSameColour(String[] cards) {
		for (int i = 1; i < cards.length; i++) {
			if (getCardColour(cards[i-1]) != getCardColour(cards[i])) {
				return false;
			}
		}
		return true;
	}

	private char getCardColour(String card) {
		return card.charAt(1);
	}

	private boolean areFiguresStraight(Map<Character, Integer> histogram) {
		List<Integer> listOfValues = new ArrayList<Integer>();
		for (Character character : histogram.keySet()) {
			int value = CardRank.valueOf(character).getValue();
			listOfValues.add(value);
		}
		listOfValues.sort(new IntegerComparator());

		return listOfValues.get(0) + 4 == listOfValues
				.get(listOfValues.size() - 1);
	}

	private boolean isThreeCardInIt(Map<Character, Integer> histogram) {
		return histogram.values().contains(3);

	}

	private Map<Character, Integer> calculateHistogram(String[] cards) {
		Map<Character, Integer> histogram = new HashMap<Character, Integer>();
		for (String card : cards) {
			Character cardRank = card.charAt(0);
			Integer number = histogram.get(cardRank);
			histogram.put(cardRank, number == null ? 1 : number + 1);
		}
		return histogram;
	}

	/**
	 * Evaluates poker hands.
	 * 
	 * @param first
	 *            first poker hand to evaluate
	 * @param second
	 *            second poker hand to evaluate
	 * @return the best poker hand
	 */
	public String evaluateHands(String first, String second) {
		throw new UnsupportedOperationException();
	}

}
