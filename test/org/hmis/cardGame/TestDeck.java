package org.hmis.cardGame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class TestDeck {

	@ParameterizedTest
	@MethodSource("providerDecks")
	void testShuffle(Deck d1, Deck d2) {
		
		d1.shuffle();
		assertNotEquals(d1,d2);
		
		
	}
	
	@ParameterizedTest
	@MethodSource("providerDeck")
	void testCardsLeft(Deck d1, int numCards) {
		int resultado = d1.cardsLeft();
		assertEquals(numCards, resultado);
	}
	
	@ParameterizedTest
	@MethodSource("providerDeckTwo")
	void testDealCard(Deck d1, int numCards) {
		d1.dealCard();
		int resultado = d1.cardsLeft();
		assertEquals(numCards, resultado);
	}
	
private static Stream<Arguments> providerDecks(){
	
	Deck d1 = new Deck();
	Deck d2 = new Deck();	
	
		return Stream.of(
				Arguments.of(d1,d2)
				);
	}
	
	private static Stream<Arguments> providerDeck(){
		
		Deck d1 = new Deck();
		int numCards = 52;
		
			return Stream.of(
					Arguments.of(d1,numCards)
					);
		}
private static Stream<Arguments> providerDeckTwo(){
		
		Deck d1 = new Deck();
		int numCards = 51;
		
			return Stream.of(
					Arguments.of(d1,numCards)
					);
		}


}