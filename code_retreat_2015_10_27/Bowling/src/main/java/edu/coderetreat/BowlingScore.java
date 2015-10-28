package edu.coderetreat;

import java.util.ArrayList;
import java.util.List;

public class BowlingScore {

	private static final int ALL_PINS = 10;
	private static final int LAST_FRAME_NUMBER = 10;

	private int score = 0;
	private int frameNumber = 1;
	private int bonusCounter = 0;
	private List<Integer> frame = new ArrayList<Integer>();

	/**
	 * Register a thrown a ball.
	 * 
	 * @param pins
	 *            number of knocked down pins
	 */
	public void roll(int pins) {
		handleScore(pins);
		if (frameNumber < LAST_FRAME_NUMBER) {
			handleFrame(pins);
		} else {
			handleLastFrame(pins);
		}
	}

	private void handleScore(int pins) {
		if (bonusCounter > 0) {
			pins *= 2;
			bonusCounter--;
		}
		score += pins;
	}

	private void handleFrame(int pins) {
		frame.add(pins);
		switch (frame.size()) {
		case 1: // 1st roll
			if (frame.get(0) == ALL_PINS) {
				// strike
				bonusCounter += 2;
				nextFrame();
			}
			break;
		case 2: // 2nd roll
			if (frame.get(0) + frame.get(1) == ALL_PINS) {
				// spare
				bonusCounter++;
			}
			nextFrame();
			break;
		}
	}

	private void handleLastFrame(int pins) {
		throw new UnsupportedOperationException();
	}
	
	private void nextFrame() {
		frameNumber++;
		frame.clear();
	}

	/**
	 * @return current game score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @return true if a game is over, otherwise false
	 */
	public boolean isFinished() {
		return frameNumber > 10;
	}

	/**
	 * 
	 * @return current frame number
	 */
	public int getFrameNumber() {
		return frameNumber;
	}
}
