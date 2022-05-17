package org.hmis.cardGame;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestCard {

	@ParameterizedTest
	@CsvSource({
		"1,1,1"
	})
	void testGetSuit(int value, int suit, int expected) {
		
		Card carta = new Card(value, suit);
		int resultado = carta.getSuit();
		assertEquals(expected, resultado);
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,1,1"
	})
	void testGetValue(int value, int suit, int expected) {
		
		Card carta = new Card(value, suit);
		int resultado = carta.getValue();
		assertEquals(expected, resultado);
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,0,♠",
		"1,1,♥",
		"1,2,♦",
		"1,3,♣",
		"1,4,¯\\_(ツ)_/¯"
		
	})
	void testGetSuitAsString(int value, int suit, String expected) {
		
		Card carta = new Card(value, suit);
		String resultado = carta.getSuitAsString();
		assertEquals(expected, resultado);
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,1,A",
		"2,1,2",
		"3,1,3",
		"4,1,4",
		"5,1,5",
		"6,1,6",
		"7,1,7",
		"8,1,8",
		"9,1,9",
		"10,1,10",
		"11,1,J",
		"12,1,Q",
		"13,1,K",
		"14,1,¯\\_(ツ)_/¯"
		
	})
	void testGetValueAsString(int value, int suit, String expected) {
		
		Card carta = new Card(value, suit);
		String resultado = carta.getValueAsString();
		assertEquals(expected, resultado);
		
	}
	
	@ParameterizedTest
	@CsvSource({
		"1,1,A♥"
	})
	void tesToString(int value, int suit, String expected) {
		
		Card carta = new Card(value, suit);
		String resultado = carta.toString();
		assertEquals(expected, resultado);
		
	}
	
	
	
	

}
