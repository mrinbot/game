package com.code.stone.model;

/**
 * Enum representing the suit of a card
 */
public enum Suit {

	CLOVERS("GREEN"), SPADES("BLACK"), HEARTS("RED"), ROUTES("BLUE");

	private String color;

	/**
	 * Constructor for suit enum
	 * @param color color of the suit
	 */
	private Suit(String color) {
		this.color = color;
	}

	/**
	 * Returns the color of a suit in card
	 * @return color of the suit
	 */
	public String getColor() {
		return color;
	}

}
