package com.code.stone.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.code.stone.model.Card;
import com.code.stone.model.Deck;
import com.code.stone.model.Suit;
import com.code.stone.model.Value;
import com.code.stone.service.UtilService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameApplicationTests {
	
	private  List<Deck> decks;
	private  List<Card> cards;
	
	@Autowired
	private UtilService utilService;
	
	@Before 
	public void setUp() {	
	   
		decks = new ArrayList<>();
		cards = new ArrayList<>();
	}

	@Test
	public void testCreateStack() {
	
		assertTrue("deck is empty ", decks.isEmpty());
		int totalCards = 0;
		decks = utilService.createStack(decks);
		totalCards = decks.stream().map(Deck::getCards).mapToInt(List::size).sum();
		
		assertFalse("deck is not empty", decks.isEmpty());
		assertEquals("One deck created", decks.size(), 1);
		assertEquals("Deck contains 52 cards", totalCards , 52);
		
		decks = utilService.createStack(decks);
		totalCards = decks.stream().map(Deck::getCards).mapToInt(List::size).sum();
		
		assertEquals("Two decks created", decks.size(), 2);
		assertEquals("Deck contains 52 cards", totalCards , 104);
	}
	
	@Test
	public void testDragCardsInGame() {
	
		decks = createDecksOfCards(decks);
		int totalCards = 0;
		totalCards = decks.stream().map(Deck::getCards).mapToInt(List::size).sum();
		
		assertEquals("Number of decks before drag", decks.size(), 1);
		assertEquals("Initial number of cards is 6", totalCards , 6);
		
		cards = utilService.dragCards(decks);
		totalCards = decks.stream().map(Deck::getCards).mapToInt(List::size).sum();
		
		assertEquals("No decks remaining after drag", decks.size(), 0);
		assertEquals("Card Reamining in Deck", totalCards , 0);
		assertEquals("Total Cards drawn", cards.size(), 6);
		assertEquals("New Top of Deck", cards.get(0), new Card(Suit.HEARTS, Value.FIVE));
	}
	
	@Test
	public void testDrawingCardsInGame() {
	
		decks = createDecksOfCards(decks);
		int totalCards = 0;
		totalCards = decks.stream().map(Deck::getCards).mapToInt(List::size).sum();
		
		assertEquals("Initial number of cards is 6", totalCards , 6);
		
		cards = utilService.drawCard(decks);
		totalCards = decks.stream().map(Deck::getCards).mapToInt(List::size).sum();
		
		assertEquals("Decks size should remain same", decks.size(), 1);
		assertEquals("Card Drawn", totalCards , 5);
		assertEquals("Top Card is HEARTS-FIVE", cards.get(0), new Card(Suit.HEARTS, Value.FIVE));
		assertEquals("New Top of Deck", decks.get(0).getCards().get(0), new Card(Suit.CLOVERS, Value.NINE));
	}
	
	@Test
	public void testSortingCardsInGame() {
	
		decks = createDecksOfCards(decks);
		decks = utilService.sortCards(decks);
		int totalCards = decks.stream().map(Deck::getCards).mapToInt(List::size).sum();
		
		assertEquals("Decks size should remain same", decks.size(), 1);
		assertEquals("Deck contains initial number of cards", totalCards , 6);
		assertEquals("Top Card is SPADES-THREE", decks.get(0).getCards().get(0), new Card(Suit.SPADES, Value.THREE));
		assertEquals("Last Card is HEARTS-QUEEN", decks.get(0).getCards().get(totalCards-1), new Card(Suit.HEARTS, Value.QUEEN));
	}
	
	@Test
	public void testSortingCardsInGameByValue() {
	
		decks = createDecksOfCards(decks);
		decks = utilService.sortCardsByValue(decks);
		int totalCards = decks.stream().map(Deck::getCards).mapToInt(List::size).sum();
		
		assertEquals("Decks size should remain same", decks.size(), 1);
		assertEquals("Decks contains initial number of cards", totalCards , 6);
		assertEquals("Top Card is ROUTES-TWO", decks.get(0).getCards().get(0), new Card(Suit.ROUTES, Value.TWO));
		assertEquals("Last Card is HEARTS-QUEEN", decks.get(0).getCards().get(totalCards-1), new Card(Suit.HEARTS, Value.QUEEN));
	}
	
	@Test
	public void testSortingCardsInGameByColor() {
	
		decks = createDecksOfCards(decks);
		decks = utilService.sortCardsByColor(decks);
		int totalCards = decks.stream().map(Deck::getCards).mapToInt(List::size).sum();
		
		assertEquals("Decks size should remain same", decks.size(), 1);
		assertEquals("Deck contains initial number of cards", totalCards , 6);
		assertEquals("Top Card is SPADES-THREE", decks.get(0).getCards().get(0), new Card(Suit.SPADES, Value.THREE));
		assertEquals("Last Card is HEARTS-QUEEN", decks.get(0).getCards().get(totalCards-1), new Card(Suit.HEARTS, Value.QUEEN));
	}
	
	
	
	private List<Deck> createDecksOfCards(List<Deck> decks) {
		
		List<Card> cards = creatCardsList();
		
		Deck deck =  new Deck(cards);
		decks.add(deck);
		
		return decks;
		
	}
	
    private List<Card> creatCardsList() {
		
    	List<Card> cards = new ArrayList<>();
    	
    	cards.add(new Card(Suit.HEARTS, Value.FIVE));
    	cards.add(new Card(Suit.CLOVERS, Value.NINE));
    	cards.add(new Card(Suit.ROUTES, Value.TWO));
    	cards.add(new Card(Suit.SPADES, Value.THREE));
    	cards.add(new Card(Suit.HEARTS, Value.QUEEN));
    	cards.add(new Card(Suit.SPADES, Value.SEVEN));
    	
		return cards;
		
	}

}
