package com.code.stone.model;

import java.util.Comparator;
import java.util.List;

public class Util {
	
	public static List<Card> sortCards(List<Card> cards) {
		
		 //cards.sort(Comparator.comparing(Card::getSuit).thenComparing(Card::getVal));
		cards.sort(Comparator.comparing(Card::getColor).thenComparing(Card::getValue));
		
		return cards;
	}

}
