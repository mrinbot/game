package com.code.stone.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.code.stone.model.Card;
import com.code.stone.model.Deck;
import com.code.stone.model.DeckWrapper;
import com.code.stone.service.UtilService;

/**
 * Controller class for Card Game program
 */

@Controller
@RequestMapping("/game")
public class GameController {

	private static final Logger logger = LoggerFactory.getLogger(GameController.class);
	private List<Deck> decks = new ArrayList<>();

	@Autowired
	private UtilService utilService;

	/**
	 * Adds the stack of playing cards to deck and shuffles them in a random manner
	 * 
	 * @param model 
	 * @return view page
	 */
	@GetMapping("/stack")
	public String getStack(Model model) {

		logger.info("In Application : getStack method");

		decks = utilService.createStack(decks);
		List<DeckWrapper> deckWrappers = utilService.createResponse(decks);
		
		int cardsinDecks = decks.stream().map(Deck::getCards).filter(rs -> rs != null).mapToInt(List::size).sum();
		
		model.addAttribute("decks", deckWrappers);
		model.addAttribute("size", cardsinDecks);
		model.addAttribute("deckSize", decks.size());

		return "page";

	}

	/**
	 * Provides default sorting of the cards in decks by color and value both
	 * Also allows sorting by only color or value of the card 
	 * 
	 * @param model 
	 * @return view page
	 */
	@GetMapping(value = { "/sort", "/sort/{sortBy}" })
	public String sortCards(Model model, @PathVariable Optional<String> sortBy) {

		List<DeckWrapper> deckWrappers;

		if (sortBy.isPresent() && sortBy.get().equals("color")) {
			
			logger.info("In Application : sortCards method. Sorting By COLOR : " );
			decks = utilService.sortCardsByColor(decks);
		} 
		else if (sortBy.isPresent() && sortBy.get().equals("value")) 
		{
			logger.info("In Application : sortCards method. Sorting By VALUE: ");
			decks = utilService.sortCardsByValue(decks);
		} 
		else 
		{
			logger.info("In Application : sortCards method. Sorting By DEFAULT COLOR AND VALUE : ");
			decks = utilService.sortCards(decks);
		}

		deckWrappers = utilService.createResponse(decks);
		
		int cardsinDecks = decks.stream().map(Deck::getCards).filter(rs -> rs != null).mapToInt(List::size).sum();
		
		model.addAttribute("decks", deckWrappers);
		model.addAttribute("size", cardsinDecks);
		model.addAttribute("deckSize", decks.size());

		return "page";

	}

	/**
	 * Shuffles the cards in decks in a random manner
	 * 
	 * @param model 
	 * @return view page
	 */
	@GetMapping("/shuffle")
	public String shuffleCards(Model model) {

		logger.info("In Application : shuffleCards method");

		decks = utilService.shuffleCards(decks);
		List<DeckWrapper> deckWrappers = utilService.createResponse(decks);
		
		int cardsinDecks = decks.stream().map(Deck::getCards).filter(rs -> rs != null).mapToInt(List::size).sum();
		
		model.addAttribute("decks", deckWrappers);
		model.addAttribute("size", cardsinDecks);
		model.addAttribute("deckSize", decks.size());

		return "page";

	}

	/**
	 * Removes card from the top of the stack of cards in decks
	 * 
	 * @param model 
	 * @return view page
	 */
	@GetMapping("/draw")
	public String drawCard(Model model) {

		logger.info("In Application : drawCard method");

		List<Card> cardsDrawn = utilService.drawCard(decks);
		List<DeckWrapper> deckWrappers = utilService.createResponse(decks);
		
		int cardsinDecks = decks.stream().map(Deck::getCards).filter(rs -> rs != null).mapToInt(List::size).sum();

		model.addAttribute("decks", deckWrappers);
		model.addAttribute("cardsDrawn", !cardsDrawn.isEmpty() ? cardsDrawn.toString(): "");
		model.addAttribute("size", cardsinDecks);
		model.addAttribute("deckSize", decks.size());

		return "page";

	}
	
	/**
	 * Removes card from the top of the stack of cards in decks until all cards are drawn
	 * 
	 * @param model 
	 * @return view page
	 */
	@GetMapping("/drag")
	public String dragCards(Model model) {

		logger.info("In Application : dragCards method");

		List<Card> cardsDrawn = utilService.dragCards(decks);
		
		int cardsinDecks = decks.stream().map(Deck::getCards).filter(rs -> rs != null).mapToInt(List::size).sum();

		model.addAttribute("cardsDrawn", cardsDrawn);
		model.addAttribute("size", cardsDrawn.size());
		model.addAttribute("deckSize", decks.size());
		model.addAttribute("cardsRemaining", cardsinDecks);

		return "cards";

	}

	/**
	 * Acts as the default method. Clears the decks in the list
	 * 
	 * @param model 
	 * @return view page
	 */
	@GetMapping("/")
	public String clearDeck(Model model) {

		logger.info("In Application : default method");

		decks.clear();
		List<DeckWrapper> deckWrappers = utilService.createResponse(decks);
		model.addAttribute("decks", deckWrappers);

		return "page";

	}

}
