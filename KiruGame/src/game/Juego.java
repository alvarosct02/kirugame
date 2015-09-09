package game;
import java.util.Scanner;

import mapa.GestorMapas;
import mapa.Mapa;
import drawable.personaje.Jugador;

public class Juego {
	public static final int gridSize = 64;
	public static final int gridWidth = 16;
	public static final int gridHeight = 12;
	public static final int cantNivel = 2;
	
	public static Jugador p1;
	public static Jugador p2;
	public static Mapa map;
	
	public static int renderMode = 0;
	private String cmd = ""; 
	private Scanner sc = new Scanner(System.in);
	
	public Juego(){
		Renderizador.mostrarWelcome();		
		sc.nextLine();		
		menuLoop();
	}
	
	public void initGame(){
		Renderizador.pedirDatos(1);			
		String nom1 = sc.next();
		p1 = new Jugador(nom1, "WASDQE",1,1,'A','S');
		Renderizador.pedirDatos(2);	
		String nom2 = sc.next();
		p2 = new Jugador(nom2, "IJKLUO",1,1,'B','N');
		gameLoop();
	}
	
	public void menuLoop(){
		Renderizador.mostrarMenuIncial();
		int act1;
		while (true){
			cmd = sc.next();
			act1 = InterpreteComandos.cmdInicial(cmd);
			if (act1 == 1){
				initGame();
				break;
			} else if (act1 == -1) {
				Renderizador.confirmacionSalir();
				int act2; 
				while (true){
					cmd = sc.next();
					act2 = InterpreteComandos.cmdSalir(cmd);
					if (act2 == 1){
						Renderizador.endGame();
						break;
					} else if (act2 == -1) {
						Renderizador.mostrarMenuIncial();
						break;						
					} else {
						Renderizador.errorCmd();
					}
				}
				if (act2 == 1) break;
			} else {
				Renderizador.errorCmd();				
			}
		}
	}
	

	public void gameLoop(){
		
		for (int i=0; i<cantNivel; i++){		
			
//			Mostrar Historia
			Renderizador.mostrarHistoria(i+1);
			
			if (i==0){
				Renderizador.dialogo1();
			}
			
//			Cargar el nivel correspondiente
			GestorMapas.cargarNivel(i);
			map = GestorMapas.map;
			int act1,act2;
			while (true){
				Renderizador.mostrarPantalla(map);
				Renderizador.ingreseComandoGame();
				cmd = sc.next();
				act1 = InterpreteComandos.cmdJuego1(cmd);
				if (act1 == 1){
					onEnterFrame(i);
				} else if (act1 == -1) {
					Renderizador.confirmacionSalirGame();
					while (true){
						cmd = sc.next();
						act2 = InterpreteComandos.cmdSalir(cmd);
						if (act2 == 1){
							break;
						} else if (act2 == -1) {							
							break;						
						} else {
							Renderizador.errorCmd();
						}
					}
					if (act2 == 1) break;
				} else {
					Renderizador.errorCmd();				
				}				
			}
			if (act2 == 1){
				menuLoop();
				break;				
			}
		}			
		
	}
	
	private void onEnterFrame(int i) {
//		TUTORIAL
		if (i == 0){
			if (p1.gridX == 8 && p1.gridY == 2){
				while(true){
					Renderizador.requestSecuencia("WEDQ");
					if (secuencia("WEDQ")){
						break;
					}
				}
				sc.nextLine();
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				Renderizador.pressToMove();
				sc.nextLine();
				Renderizador.mostrarPantalla(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				Renderizador.pressToMove();
				sc.nextLine();
				Renderizador.mostrarPantalla(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				Renderizador.pressToMove();
				sc.nextLine();
				Renderizador.mostrarPantalla(map);
			}
			
			if (p1.gridX == 13 && p1.gridY == 5 && p2.gridX == 13 && p2.gridY == 8){
				while(true){
					Renderizador.requestSecuencia("SDKIQEUO");
					if (secuencia("SDKIQEUO")){
						break;
					}
				}
				sc.nextLine();
				
				p1.setXY(p1.gridX, p1.gridY+1);
				p2.setXY(p2.gridX, p2.gridY-1);
				Renderizador.pressToMove();
				sc.nextLine();
				Renderizador.mostrarPantalla(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				p2.setXY(p2.gridX + 1, p2.gridY);
				Renderizador.pressToMove();
				sc.nextLine();
				Renderizador.mostrarPantalla(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				p2.setXY(p2.gridX + 1, p2.gridY);
				Renderizador.pressToMove();
				sc.nextLine();
				Renderizador.mostrarPantalla(map);
				
				Renderizador.dialogo2();
			}
		}
		
	}
	
	private boolean secuencia(String cadena){
		String charPressed;
		int i;
		for(i=0; i<cadena.length(); i++){
			char car = cadena.charAt(i);
			Renderizador.requestChar(Character.toUpperCase(car));
			charPressed = sc.next();
//			Si se equivoca, break!
			if (Character.toUpperCase(charPressed.charAt(0)) != car) break;
		}
//		Si no completo con exito la secuencia
		if (i != cadena.length()){
			p1.getTipoDano(2);
			return false;
		} else {			
			return true;
		}
	}

	private void gameOver() {
		Renderizador.mostrarGameOver();
		menuLoop();
	}
	
}
