package Controlador;

import Modelo.Jugador;
import Vista.Mapa;
import Vista.Renderizador;

public class InterpreteComandos {
	public static void ingresaComando(String cmd){
		
	}
	
	public static int cmdInicial(String cmd){
		
//		Estandarizar todo a mayusculas
		cmd = cmd.toUpperCase();
		
		switch (cmd) {
		case "1":
			return 1;	
		case "2":
			return -1;
		default:
			return 0;
		}
	}

	public static int cmdSalir(String cmd){
		
//		Estandarizar todo a mayusculas
		cmd = cmd.toUpperCase();
		
		switch (cmd) {
			case "1":
				return 1;	
			case "2":
				return -1;
			default:
				return 0;
		}
	}

	public static int cmdJuego1(String cmd) {
//		Estandarizar todo a mayusculas
		cmd = cmd.toUpperCase();
		int aux;
		Jugador player;
		switch (cmd) {
		case "W": case"A": case"S": case"D":
			player = Mapa.p1;
			aux = player.moverDir(cmd);
			break;
		case "I": case"J": case"K": case"L":
			player = Mapa.p2;
			aux = player.moverDir(cmd);
			break;
		case "ESC":
			return -1;
		default:
			return 0;
		}
		
		if (aux == 1){
			Renderizador.logNoMover();
			return -2;
		} else {
			Renderizador.logMover(player.getNombre(), player.dir);
			return 1;
		}
	}

}