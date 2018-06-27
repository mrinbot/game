package com.code.stone.model;

/**
 * Class representing a playing card in a deck
 */
public class Card {

	private Suit suit;
	private Value val;

	/**
	 * Constructor for Card class
	 * @param suit suit of the card
	 * @param val value of the card
	 */
	public Card(Suit suit, Value val) {
		this.suit = suit;
		this.val = val;
	}

	/**
	 * Returns the suit of a card
	 * @return suit
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Returns the value of a card
	 * @return value of the card
	 */
	public Value getVal() {
		return val;
	}

	/**
	 * Returns the color of a card
	 * @return color of the card
	 */
	public String getColor() {
		return getSuit().getColor();
	}

	/**
	 * Returns the integer value of a card
	 * @return value of the card
	 */
	public int getValue() {
		return getVal().getVal();
	}

	@Override
	public String toString() {
		return getSuit().toString() + "-" + getVal().toString();

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((val == null) ? 0 : val.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suit != other.suit)
			return false;
		if (val != other.val)
			return false;
		return true;
	}
}
