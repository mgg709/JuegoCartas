package org.hmis.cardGame;

import java.util.Scanner;

public class CartaMasAlta {
	
	private static int dinero = 0;
	
	public static int getDinero() {
		return dinero;
	}

	public static void setDinero(int dinero) {
		CartaMasAlta.dinero = dinero;
	}


	
	public static boolean ComprobarApuesta(int apuesta) {
		boolean permitido = true;
		if(apuesta > dinero) {
			System.out.println("No puede introducir una cantidad mayor al dinero que posee en el banco");
			permitido = false;
		}
		return permitido;
	}
	
	public static Card ObtenerCarta(Deck baraja) {
		Card carta = baraja.dealCard();
		return carta;
	}
	
	public static String Ganador(Card cartaJugador, Card cartaBanca, int apuesta) {
		if(cartaJugador.getValue() > cartaBanca.getValue()) {
			//System.out.println("Su carta es m s alta, HA GANADO!!");
			dinero+=apuesta;
			System.out.println("Su dinero actual es " + dinero);
			return "Su carta es m s alta HA GANADO!!";
		}
		else if(cartaJugador.getValue() < cartaBanca.getValue()) {
			//System.out.println("Su carta es mas baja, ha perdido :(");
			dinero-=apuesta;
			System.out.println("Su dinero actual es " + dinero);
			return "Su carta es mas baja ha perdido :(";
		}
		else {
			//System.out.println("Su carta tiene el mismo valor que el de la banca, EMPATE");
			return "Su carta tiene el mismo valor que el de la banca EMPATE";
		}
	}
	
	public static String iniciar(Deck d){
		
	
		Deck baraja = d;
		
		baraja.shuffle();
		Scanner scan = new Scanner(System.in);
		System.out.println("------------------- JUEGO DE CARTA MAS ALTA -------------------");
		
		System.out.println("Introduzca la cantidad inicial de dinero");
		int money = scan.nextInt();
		CartaMasAlta.setDinero(money);;
		do {
		System.out.println("MENU:");
		System.out.println("1- Jugar");
		System.out.println("2- Salir");
		System.out.println("Escoge una opcion");
		int opcion = scan.nextInt();
		if (opcion == 1) {
		System.out.println("Introduzca la cantidad para apostar:");
		int apuesta = scan.nextInt();
		if(ComprobarApuesta(apuesta) == false) {
			continue;
		}
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
			return "Has perdido tu dinero, para volver a jugar venda el coche o la casa";
		}
		return "Partida finalizada";
	}
	
public static void main(String[] args) {
		String s;
		Deck d = new Deck();
	do {
		s = iniciar(d);
	}while(s != "Partida finalizada");
		
	}

}
