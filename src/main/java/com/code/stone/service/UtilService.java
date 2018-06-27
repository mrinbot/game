package com.code.stone.service;

import java.util.List;

import com.code.stone.model.Card;
import com.code.stone.model.Deck;
import com.code.stone.model.DeckWrapper;

public interface UtilService {

	/**
	 * Adds the deck of playing cards to given collection of decks and shuffles the cards in a random manner
	 * 
	 * @param decks list of decks
	 * @return list of decks containing the cards added
	 */
	List<Deck> createStack(List<Deck> decks);
	
	/**
	 * Converts the list of decks to a list of response objects
	 * 
	 * @param decks list of decks
	 * @return list of formatted objects
	 */
	List<DeckWrapper> createResponse(List<Deck> decks);
	
	/**
	 * Shuffles the cards in the collection of decks
	 * 
	 * @param decks list of decks
	 * @return list of decks containing shuffled cards
	 */
	List<Deck> shuffleCards(List<Deck> decks);
	
	/**
	 * Sorts the cards by their color and value in the collection of decks
	 * 
	 * @param decks list of decks
	 * @return list of decks containing sorted cards
	 */
	List<Deck> sortCards(List<Deck> decks);
	
	/**
	 * Removes the cards from top of the deck in the collection of decks
	 * 
	 * @param decks list of decks
	 * @return list of cards drawn
	 */
	List<Card> drawCard(List<Deck> decks);
	
	/**
	 * Sorts the cards by their color in the collection of decks
	 * 
	 * @param decks list of decks
	 * @return list of decks containing sorted cards
	 */
	List<Deck> sortCardsByColor(List<Deck> decks);
	
	/**
	 * Sorts the cards by their value in the collection of decks
	 * 
	 * @param decks list of decks
	 * @return list of decks containing sorted cards
	 */
	List<Deck> sortCardsByValue(List<Deck> decks);
	
	/**
	 * Removes the cards from top of the deck in the collection of decks until all cards are drawn
	 * Also removes all the decks from the given collection of decks 
	 * 
	 * @param decks list of decks
	 * @return list of cards drawn
	 */
	List<Card> dragCards(List<Deck> decks);
}
