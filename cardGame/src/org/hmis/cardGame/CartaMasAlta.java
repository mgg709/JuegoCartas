package org.hmis.cardGame;

import java.util.Scanner;

public class CartaMasAlta {
	
	private static int dinero = 0;
	
	public static int Dinero(int money) {
		dinero = money;
		return dinero;
	}
	
	public static void ComprobarApuesta(int apuesta) {
		if(apuesta > dinero) {
			System.out.println("No puede introducir una cantidad mayor al dinero que posee en el banco");
		}
		
	}
	
	public static Card ObtenerCarta(Deck baraja) {
		Card carta = baraja.dealCard();
		return carta;
	}
	
	public static void Ganador(Card cartaJugador, Card cartaBanca, int apuesta) {
		if(cartaJugador.getValue() > cartaBanca.getValue()) {
			System.out.println("Su carta es m s alta, HA GANADO!!");
			dinero+=apuesta;
			System.out.println("Su dinero actual es " + dinero);
		}
		else if(cartaJugador.getValue() < cartaBanca.getValue()) {
			System.out.println("Su carta es m s baja, ha perdido :(");
			dinero-=apuesta;
			System.out.println("Su dinero actual es " + dinero);
		}
		else {
			System.out.println("Su carta tiene el mismo valor que el de la banca, EMPATE");
		}
	}
	
public static void main(String[] args) {
		
		Deck baraja = new Deck();
		
		baraja.shuffle();
		Scanner scan = new Scanner(System.in);
		System.out.println("------------------- JUEGO DE CARTA M S ALTA -------------------");
		
		System.out.println("Introduzca la cantidad inicial de dinero");
		int money = scan.nextInt();
		Dinero(money);
		do {
		System.out.println("MENU:");
		System.out.println("1- Jugar");
		System.out.println("2- Salir");
		System.out.println("Escoge una opci n");
		int opcion = scan.nextInt();
		if (opcion == 1) {
		System.out.println("Introduzca la cantidad para apostar:");
		int apuesta = scan.nextInt();
		ComprobarApuesta(apuesta);
		Card cartaJugador = ObtenerCarta(baraja);
		Card cartaBanca = ObtenerCarta(baraja);
		System.out.println("Su carta es:" + cartaJugador.getSuitAsString() + " " + cartaJugador.getValueAsString());
		System.out.println("La carta de la banca es:" + cartaBanca.getSuitAsString() + " " + cartaBanca.getValueAsString());
		Ganador(cartaJugador, cartaBanca, apuesta);
		}
		if(opcion == 2) {
			break;
		}
		}while(dinero>0);
		if(dinero == 0) {
			System.out.println("Has perdido tu dinero, para volver a jugar venda el coche o la casa");
		}
		System.out.println("Partida finalizada");
	}

}
