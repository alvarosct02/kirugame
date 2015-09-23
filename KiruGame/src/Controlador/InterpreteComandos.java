package Controlador;

//import Vista.Mapa;
//import Vista.Renderizador;

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

	public static int[] cmdJuego1(String cmd) {
//		Estandarizar todo a mayusculas
		
		int[] resp = {0,0,0};
		
		cmd = cmd.toUpperCase();
		switch (cmd) {
		case "W": case"A": case"S": case"D":
			resp[0] = 1;
			resp[1] = 1;
			resp[2] = cmd.charAt(0);
			break;
		case "I": case"J": case"K": case"L":
			resp[0] = 1;
			resp[1] = 2;
			resp[2] = cmd.charAt(0);
			break;
		case "ESC":
			resp[0] = -1; break;
		default:
			resp[0] = 0; 
			int a = 0; 
			break;
		}
		
		return resp;
	}

}