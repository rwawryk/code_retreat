package edu.coderetreat;

import static edu.coderetreat.BowlingScoreAssert.assertThat;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BowlingScoreTest {
	
	private BowlingScore bowlingScore;
	
	@Before
	public void setUp() {
		bowlingScore = new BowlingScore();
	}
	
	@Test
	public void shouldHandleOneRoll() {
		// when
		bowlingScore.roll(5);
		// then
		assertThat(bowlingScore).hasScore(5).hasFrameNumber(1).isNotFinished();
	}
	
	@Test
	public void shouldHandleTwoRolls() {
		// when
		bowlingScore.roll(5);
		// then
		assertThat(bowlingScore).hasScore(5).hasFrameNumber(1).isNotFinished();
		
		// when
		bowlingScore.roll(2);
		// then
		assertThat(bowlingScore).hasScore(7).hasFrameNumber(2).isNotFinished();
	}
	
	@Test
	public void shouldHandleStrike() {
		// when
		bowlingScore.roll(10);
		// then
		assertThat(bowlingScore).hasScore(10).hasFrameNumber(2).isNotFinished();
		
		// when
		bowlingScore.roll(2);
		// then
		assertThat(bowlingScore).hasScore(14).hasFrameNumber(2).isNotFinished();
		
		// when
		bowlingScore.roll(3);
		// then
		assertThat(bowlingScore).hasScore(20).hasFrameNumber(3).isNotFinished();
	}
	
	@Test
	public void shouldHandleSpare() {
		// when
		bowlingScore.roll(9);
		// then
		assertThat(bowlingScore).hasScore(9).hasFrameNumber(1).isNotFinished();
		
		// when
		bowlingScore.roll(1);
		// then
		assertThat(bowlingScore).hasScore(10).hasFrameNumber(2).isNotFinished();
		
		// when
		bowlingScore.roll(3);
		// then
		assertThat(bowlingScore).hasScore(16).hasFrameNumber(2).isNotFinished();
	}
	
	@Test
	@Ignore
	public void shouldHandleLastFrame() {
		// given - 18 rolls land in channel
		for(int i = 0; i< 18; i++) {
			bowlingScore.roll(0);
		}
		
		// when
		bowlingScore.roll(2);
		// then
		assertThat(bowlingScore).hasScore(2).hasFrameNumber(10).isNotFinished();
		
		// when
		bowlingScore.roll(3);
		// then
		assertThat(bowlingScore).hasScore(5).isFinished();
	}
	
	@Test
	@Ignore
	public void shouldHandleLastFrameWithFirstStrike() {
		// given - 18 rolls land in channel
		for(int i = 0; i< 18; i++) {
			bowlingScore.roll(0);
		}
		
		// when
		bowlingScore.roll(10);
		// then
		assertThat(bowlingScore).hasScore(10).hasFrameNumber(10).isNotFinished();
		
		// when
		bowlingScore.roll(2);
		// then
		assertThat(bowlingScore).hasScore(14).hasFrameNumber(10).isNotFinished();
		
		// when
		bowlingScore.roll(3);
		// then
		assertThat(bowlingScore).hasScore(20).isFinished();
	}
	
	@Test
	@Ignore
	public void shouldHandleLastFrameWithSecondStrike() {
		// given - 18 rolls land in channel
		for(int i = 0; i< 18; i++) {
			bowlingScore.roll(0);
		}
		
		// when
		bowlingScore.roll(2);
		// then
		assertThat(bowlingScore).hasScore(2).hasFrameNumber(10).isNotFinished();
		
		// when
		bowlingScore.roll(10);
		// then
		assertThat(bowlingScore).hasScore(12).hasFrameNumber(10).isNotFinished();
		
		// when
		bowlingScore.roll(3);
		// then
		assertThat(bowlingScore).hasScore(18).isFinished();
	}
	
	@Test
	@Ignore
	public void shouldHandleLastFrameWithSpare() {
		// given - 18 rolls land in channel
		for(int i = 0; i< 18; i++) {
			bowlingScore.roll(0);
		}
		
		// when
		bowlingScore.roll(8);
		// then
		assertThat(bowlingScore).hasScore(8).hasFrameNumber(10).isNotFinished();
		
		// when
		bowlingScore.roll(2);
		// then
		assertThat(bowlingScore).hasScore(10).hasFrameNumber(10).isNotFinished();
		
		// when
		bowlingScore.roll(5);
		// then
		assertThat(bowlingScore).hasScore(20).isFinished();
	}
	
	@Test
	@Ignore
	public void shouldHandlePerfectGame() {
		// TODO create test case
	}
	
	@Test
	@Ignore
	public void shouldHandleCaseShownInPresentation() {
		// TODO create test case
	}
}
