package game;
import java.util.Scanner;

import personaje.Jugador;
import personaje.Personaje;

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
		p1 = new Jugador(nom1, "WASDQE");
		Renderizador.pedirDatos(2);	
		String nom2 = sc.next();
		p2 = new Jugador(nom2, "IJKLUO");
		map = new Mapa();
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
			Renderizador.mostrarHistoria(i);				
			
//			Cargar el nivel correspondiente
			map.cargarNivel(i);	
			
			int act1,act2;
			while (true){
				Renderizador.mostrarPantalla(map);
				Renderizador.ingreseComandoGame();
				cmd = sc.next();
				act1 = InterpreteComandos.cmdJuego1(cmd);
				if (act1 == 1){
					
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
	
	private void gameOver() {
		Renderizador.mostrarGameOver();
		menuLoop();
	}
	
}
