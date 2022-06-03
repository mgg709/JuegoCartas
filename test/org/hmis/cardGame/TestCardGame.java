package org.hmis.cardGame;

import static com.github.stefanbirkner.systemlambda.SystemLambda.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Rule;
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
	@CsvSource({"3, 2, 2, 2 , Su carta es m s alta HA GANADO" , 
				"2, 2, 3, 2, Su carta es mas baja ha perdido :(",
				"2, 2, 2, 2, Su carta tiene el mismo valor que el de la banca EMPATE"})
	void testGanador(int valueJugador, int suitJugador, int valueBanca, int suitBanca, String expected) {
		
		Card jugador = new Card(valueJugador, suitJugador);
		Card banca = new Card(valueBanca,suitBanca);
		String s = CartaMasAlta.Ganador(jugador, banca, 10);
		assertEquals(expected,s);
	}
	
	
	@ParameterizedTest
	@CsvSource({"Partida finalizada"})
	void testMain2(String expectedOpcion) throws Exception {
		String result = tapSystemOut(() ->{
			withTextFromSystemIn("1","2").execute(() ->{
				CartaMasAlta.iniciar();
			});
		});
		String[] aux = result.split("\n");
		assertEquals(expectedOpcion.trim(), aux[aux.length-1].trim());
		
		
	}
	@ParameterizedTest
	@CsvSource({"Has perdido tu dinero para volver a jugar venda el coche o la casa"})
	void testMain1(String expectedOpcion) throws Exception {
		String result = tapSystemOut(() ->{
			withTextFromSystemIn("1","1","1").execute(() ->{
				CartaMasAlta.iniciar();
			});
		});
		String[] aux = result.split("\n");
		if(CartaMasAlta.getDinero()==0) {
		assertEquals(expectedOpcion.trim(), aux[aux.length-2].trim());
		} else if (CartaMasAlta.getDinero()>1) {
			assertEquals("Su dinero actual es 2", aux[aux.length-2].trim());
		}else {
			assertEquals("No has perdido ni ganado", aux[aux.length-2].trim());
		}
		
		
	}
	@ParameterizedTest
	@CsvSource({"Has perdido tu dinero para volver a jugar venda el coche o la casa"})
	void testMain3(String expectedOpcion) throws Exception {
		String result = tapSystemOut(() ->{
			withTextFromSystemIn("0","1","1").execute(() ->{
				CartaMasAlta.iniciar();
			});
		});
		String[] aux = result.split("\n");
		assertEquals(expectedOpcion.trim(), aux[aux.length-2].trim());
		
		
	}
}
