package Controlador;

//import Vista.Mapa;
//import Vista.Renderizador;

public class InterpreteComandos {
	public static void ingresaComando(String cmd){
		
	}
	
	public static int cmdInicial(String cmd2){
		
//		Estandarizar todo a mayusculas
		cmd2 = cmd2.toUpperCase();
		char cmd = cmd2.charAt(0);
		switch (cmd) {
		case '1':
			return 1;	
		case '2':
			return -1;
		default:
			return 0;
		}
	}

	public static int cmdSalir(String cmd2){
		
//		Estandarizar todo a mayusculas
		cmd2 = cmd2.toUpperCase();
		char cmd = cmd2.charAt(0);
		
		switch (cmd) {
			case '1':
				return 1;	
			case '2':
				return -1;
			default:
				return 0;
		}
	}

	public static int[] cmdJuego1(String cmd2) {
//		Estandarizar todo a mayusculas
		
		int[] resp = {0,0,0};
		
		cmd2 = cmd2.toUpperCase();
		char cmd = cmd2.charAt(0);
		switch (cmd) {
		case 'W': case'A': case'S': case'D':
			resp[0] = 1;
			resp[1] = 1;
			resp[2] = cmd;
			break;
		case 'I': case'J': case'K': case'L':
			resp[0] = 1;
			resp[1] = 2;
			resp[2] = cmd;
			break;
		case 'Z':
			resp[0] = -1; break;
		default:
			resp[0] = 0; 
			int a = 0; 
			break;
		}
		
		return resp;
	}

}