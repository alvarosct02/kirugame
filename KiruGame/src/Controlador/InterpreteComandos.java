package Controlador;

import Vista.Juego;

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
		switch (cmd) {
		case "W": case"A": case"S": case"D":
			return Juego.p1.moverDir(cmd);
		case "I": case"J": case"K": case"L":
			return Juego.p2.moverDir(cmd);
		case "ESC":
			return -1;
		default:
			return 0;
		}
	}

}