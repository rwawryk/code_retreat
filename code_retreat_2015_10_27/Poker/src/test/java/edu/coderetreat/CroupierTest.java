package edu.coderetreat;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

/**
 * Poker croupier test. Card consists of two letters: first indicating card
 * rank and second its color e.g. KH means King of Hearts 
 * 
 * Card ranks: A - Ace, K - King, Q - Queen, J - Jack, T - Ten, 9 - 9, ..., 2 - 2 
 * Card suits: H - Hearts, D - Diamonds, C - Clubs, S - Spades
 * 
 */
public class CroupierTest {
	
	private Croupier croupier;
	
	@Before
	public void setUp() {
		croupier = new Croupier();
	}
	
	@Test
	public void shouldRankPokerHandAsOnePair() {
		
		// given
		String pokerHand = "KC KD 7C 2C JH";
		
		// when
		PokerRank rank = croupier.rankPokerHand(pokerHand);
		
		// then
		assertThat(rank).isEqualTo(PokerRank.ONE_PAIR);
	}
	
	@Test
	public void shouldRankPokerHandAsTwoPairs() {
		
		// given
		String pokerHand = "KC KD 7C 7H JH";
		
		// when
		PokerRank rank = croupier.rankPokerHand(pokerHand);
		
		// then
		assertThat(rank).isEqualTo(PokerRank.TWO_PAIRS);
	}
	
	@Test
	public void shouldRankPokerHandAsThreeOfKind() {
		
		// given
		String pokerHand = "KC KD KH 7H JH";
		
		// when
		PokerRank rank = croupier.rankPokerHand(pokerHand);
		
		// then
		assertThat(rank).isEqualTo(PokerRank.THREE_OF_KIND);
	}
	@Test
	public void shouldRankPokerHandAsFourOfKind() {
		
		// given
		String pokerHand = "KC KD KH KS JH";
		
		// when
		PokerRank rank = croupier.rankPokerHand(pokerHand);
		
		// then
		assertThat(rank).isEqualTo(PokerRank.FOUR_OF_KIND);
	}
	
	@Test
	public void shouldRankPokerHandAsFul() {
		
		// given
		String pokerHand = "KC KD KH QS QH";
		
		// when
		PokerRank rank = croupier.rankPokerHand(pokerHand);
		
		// then
		assertThat(rank).isEqualTo(PokerRank.FULL_OF_HOUSE);
	}
	
	@Test
	public void shouldRankPokerHandAsStraight() {
		
		// given
		String pokerHand = "3C 4D 5H 6S 7H";
		
		// when
		PokerRank rank = croupier.rankPokerHand(pokerHand);
		
		// then
		assertThat(rank).isEqualTo(PokerRank.STRAIGHT);
	}
	
	@Test
	public void shouldRankPokerHandAsHighCard() {
		
		// given
		String pokerHand = "3C 5D 7H TS QH";
		
		// when
		PokerRank rank = croupier.rankPokerHand(pokerHand);
		
		// then
		assertThat(rank).isEqualTo(PokerRank.HIGH_CARD);
	}
	
	@Test
	public void shouldRankPokerHandAsRoyalFlush() {
		
		// given
		String pokerHand = "AC KC QC JC TC";
		
		// when
		PokerRank rank = croupier.rankPokerHand(pokerHand);
		
		// then
		assertThat(rank).isEqualTo(PokerRank.ROYAL_FLUSH);
	}
	
	@Test
	public void shouldRankPokerHandAsStraightFlush() {
		
		// given
		String pokerHand = "JC TC 8C 9C TC";
		
		// when
		PokerRank rank = croupier.rankPokerHand(pokerHand);
		
		// then
		assertThat(rank).isEqualTo(PokerRank.STRAIGHT_FLUSH);
	}
}
