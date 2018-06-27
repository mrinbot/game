package com.code.stone.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.code.stone.model.Card;
import com.code.stone.model.Deck;
import com.code.stone.model.DeckWrapper;

@Service
public class UtilServiceImpl implements UtilService {

	@Override
	public List<Deck> createStack(List<Deck> decks) {

        Deck deck = new Deck();
		deck.stackCards();
		deck.shuffle();

		decks.add(deck);

		return decks;
	}

	@Override
	public List<DeckWrapper> createResponse(List<Deck> decks) {

		List<DeckWrapper> deckWrappers = new ArrayList<>();
		
		if(decks.isEmpty()) 
			return deckWrappers;

		for (Deck deck : decks) {
			for (Card card : deck.getCards()) {

				DeckWrapper deckWrapper = new DeckWrapper();
				deckWrapper.setSuit(card.getSuit().toString());
				deckWrapper.setColor(card.getColor());
				deckWrapper.setValue(card.getValue());
				deckWrapper.setVal(card.getVal().toString());
				
				deckWrappers.add(deckWrapper);
			}
		}

		return deckWrappers;
	}

	@Override
	public List<Deck> shuffleCards(List<Deck> decks) {

		for (Deck deck : decks) {
			deck.shuffle();
		}

		return decks;
     }

	@Override
	public List<Deck> sortCards(List<Deck> decks) {
		
		List<Deck> sortedDecks = new ArrayList<>();
		
		for (Deck deck : decks) {
			deck.sortCards();
			sortedDecks.add(deck);
		}

		return sortedDecks;
	}

	@Override
	public List<Card> drawCard(List<Deck> decks) {
		
		List<Card> cardsDrawn = new ArrayList<>();
		
		for(Deck deck : decks) {
			Card cardDrawn = deck.drawCard();
			cardsDrawn.add(cardDrawn);
		}
		
		return cardsDrawn;
	}

	@Override
	public List<Deck> sortCardsByColor(List<Deck> decks) {
		
		List<Deck> sortedDecks = new ArrayList<>();
		
		for (Deck deck : decks) {
			deck.sortCardsByColor();
			sortedDecks.add(deck);
		}

		return sortedDecks;
	}

	@Override
	public List<Deck> sortCardsByValue(List<Deck> decks) {
		
		List<Deck> sortedDecks = new ArrayList<>();
		
		for (Deck deck : decks) {
			deck.sortCardsByValue();
			sortedDecks.add(deck);
		}

		return sortedDecks;
	}

	@Override
	public List<Card> dragCards(List<Deck> decks) {
		
		List<Card> cardsDrawn = new ArrayList<>();
		
		for(Deck deck : decks) {
			
			while(!deck.getCards().isEmpty()) {
				
				Card cardDrawn = deck.drawCard();
				cardsDrawn.add(cardDrawn);
			}
		}
		
		decks.clear();
		
		return cardsDrawn;
	
	}

}
