package com.code.stone.model;

/**
 * Enum representing the value of a card
 */
public enum Value {

	TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), KING(10), QUEEN(10), ACE(11);

	private int val;

	/**
	 * Constructor for value enum
	 * @param val integer value
	 */
	private Value(int val) {
		this.val = val;
	}

	/**
	 * Returns the integer value
	 * @return
	 */
	public int getVal() {
		return val;
	}

}
