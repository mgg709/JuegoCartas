package org.hmis.cardGame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class TestCardGame {
	
	@ParameterizedTest
	@CsvSource("5")
	void testGetDinero(int dinero) {
		CartaMasAlta.setDinero(dinero);
		assertEquals(dinero, CartaMasAlta.getDinero());
	}
	
	@ParameterizedTest
	@CsvSource({"5,6,false" ,
			"6,5,true"})
	void testComprobarApuesta(int dinero,int apuesta, boolean expected) {
		CartaMasAlta.setDinero(dinero);
		boolean resultado = CartaMasAlta.ComprobarApuesta(apuesta);
		assertEquals(expected, resultado);
	}

	@ParameterizedTest
	@CsvSource("51")
	void testObtenerCarta(int tamanioExpected) {
		Deck d = new Deck();
		Card c = CartaMasAlta.ObtenerCarta(d);
		assertEquals(tamanioExpected, d.cardsLeft());
	}
	@ParameterizedTest
	@CsvSource({"3, 2, 2, 2 , Su carta es m s alta HA GANADO!!" , 
				"2, 2, 3, 2, Su carta es mas baja ha perdido :(",
				"2, 2, 2, 2, Su carta tiene el mismo valor que el de la banca EMPATE"})
	void testGanador(int valueJugador, int suitJugador, int valueBanca, int suitBanca, String expected) {
		
		Card jugador = new Card(valueJugador, suitJugador);
		Card banca = new Card(valueBanca,suitBanca);
		String s = CartaMasAlta.Ganador(jugador, banca, 10);
		assertEquals(expected,s);
	}
	@Test
	void testMain() {
		String[] args = null;
		CartaMasAlta.main(args);
	}
}
