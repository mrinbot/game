package com.code.stone.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class representing the deck of playing cards
 */
public class Deck {

    private final List<Card> cards;
	
	/**
	 * Constructor for Deck class
	 */
	public Deck() {
		cards = new ArrayList<Card>(52);
	}
	
	/**
	 * Parameterized Constructor for Deck class
	 * 
	 * @param deckOfCards list of cards
	 */
	public Deck(List<Card> deckOfCards) {
		cards = deckOfCards;
	}
	
	public List<Card> getCards() {
		return cards;
	}

	/**
	 * Populates the deck with 52 cards
	 */
	public void stackCards() {
		
		for(Suit suit : Suit.values()) {
			for(Value value : Value.values()) {
				cards.add(new Card(suit, value));
			}
		}
	}
	
	/**
	 * Shuffles the cards in a deck
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	/**
	 * Removes a card from the top of the deck of playing cards
	 * @return card
	 */
	public Card drawCard() {

		return !cards.isEmpty() ? cards.remove(0) : null;
	}
	
	/**
	 * Sorts the cards in the deck by color and value
	 */
	public void sortCards() {

		cards.sort(Comparator.comparing(Card::getColor).thenComparing(Card::getValue));
	}
	
	/**
	 * Sorts the cards in the deck by color
	 */
	public void sortCardsByColor() {

		cards.sort(Comparator.comparing(Card::getColor));
	}
	
	/**
	 * Sorts the cards in the deck by value
	 */
	public void sortCardsByValue() {

		cards.sort(Comparator.comparing(Card::getValue));
	}
	
	@Override
	public String toString() {
		
		return cards.stream().map(card -> card.toString()).collect(Collectors.joining( "," + "\n" ));
	}

}
