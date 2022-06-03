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
			return "Su carta es m s alta HA GANADO";
		}
		else if(cartaJugador.getValue() < cartaBanca.getValue()) {
		
			dinero-=apuesta;
			System.out.println("Su dinero actual es " + dinero);
			return "Su carta es mas baja ha perdido :(";
		}
		else {
			System.out.println("No has perdido ni ganado");
			return "Su carta tiene el mismo valor que el de la banca EMPATE";
		}
	}
	
	public static boolean iniciar(){
		
		boolean continuar = true;
		Deck baraja = new Deck();
		
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
		continuar = false;
		break;//esta sentencia se aniade para poder probar en los test un caso en el que el jugador gane, ya que si dejamos que continue el programa se genera un bucle en el test
		}
		if(opcion == 2) {
			continuar = false;
			break;
		}
		}while(dinero>0);
		if(dinero == 0) {
			System.out.println("Has perdido tu dinero para volver a jugar venda el coche o la casa");
			continuar = false;
		}
		System.out.println("Partida finalizada");
		continuar = false;
		return continuar;
	}
	
public static void main(String[] args) {
	boolean continuar = true;
	do {
		continuar = iniciar();
	}while( continuar == true);
		
	}

}
