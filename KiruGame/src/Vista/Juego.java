package Vista;
import java.util.Scanner;

import Controlador.GestorMapas;
import Controlador.InterpreteComandos;
import Modelo.Jugador;
import Modelo.Mapa;
import Modelo.ObjetoApoyo;

public class Juego {
//	Nivel inicial a jugar   DEBERIA SER 0
	private final int firstLevel = 1;
	
	public static final int gridSize = 64;
	public static final int gridWidth = 16;
	public static final int gridHeight = 12;
	public static final int cantNivel = 2;
	
	public static Jugador p1;
	public static Jugador p2;
	public static Mapa map;
	
	private static boolean salir = false;
	
	
	public static int renderMode = 0;
	private String cmd = ""; 
	public static Scanner sc = new Scanner(System.in);
	
	public Juego(){
		Renderizador.mostrarWelcome();		
		sc.nextLine();		
		menuLoop();
	}
	
	public void initGame(){
		Renderizador.beginPedirDatos();
		Renderizador.pedirDatos(1);		
		Jugador.resetVida();
		String nom1 = sc.next();
		p1 = new Jugador(nom1, "WASDQE",1,1,'A','S');
		Renderizador.pedirDatos(2);	
		String nom2 = sc.next();
		p2 = new Jugador(nom2, "IJKLUO",1,1,'B','N');
		Renderizador.endPedirDatos();
		gameLoop();
		if (Jugador.getVida()<= 0){
			gameOver();
		} else {
			gameWin();
		}
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
		
		for (int i=firstLevel; i<=cantNivel; i++){	
			Renderizador.nuevoNivel(i);
			if (Jugador.getVida() <= 0) return;
//			Mostrar Historia
			Renderizador.mostrarHistoria(i+1);
			
			if (i==0){
				Renderizador.dialogo1();
			}
			
//			Cargar el nivel correspondiente
			GestorMapas.cargarNivel(i);
			map = GestorMapas.map;
			int act1,act2 = 0;
			while (true){
				Renderizador.mostrarPantalla(map);
				Renderizador.ingreseComandoGame();
				cmd = sc.next();
				act1 = InterpreteComandos.cmdJuego1(cmd);
				if (act1 == 1){
					if (onEnterFrame(i)){						
						break;
					}
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
	
	private boolean onEnterFrame(int i) {
		if (Jugador.getVida() <= 0)
			return true;			
		
		if (map.checkEnemigos())
			return false;
		
		int idAccion = map.ejecutarAccionEspecial();
		
//		CONDICION ESPECIAL NIVEL 1
		if (i==1 && p1.gridX == 0 && p2.gridX == 0)
			return true;		

		if (i==2 && p1.gridX == 15 && p2.gridX == 15)
			return true;
		
//		SE ACABO LA VIDA
		if (idAccion == -2)
			return true;
		
//		NO PASO NADA
		else if (idAccion == -1)		
			return false;
		else {
//			PARA EL NIVEL 0
			if (i == 0){
				if (idAccion == 1){			
					Renderizador.dialogo2();
					return true;
				}
			}
			
//			PARA EL NIVEL 1
			if (i == 1){
				if (idAccion == 0){	
					map.getObjeto(2).quitarMapa();
					return false;
				}
				if (idAccion == 2){	
					map.getEnemigo(0).destruir();
					return false;
				}
			}			
			
//			PARA EL NIVEL 2
			if (i == 2){
				if (idAccion == 1){	
					ObjetoApoyo obj = (ObjetoApoyo)map.getObjeto(5);
					obj.allowWalk();
					return false;
				}
			}	
		}
		return false;		
	}

	private void gameOver() {
		Renderizador.pantallaGameOver();
		menuLoop();
	}
	
	private void gameWin() {
		Renderizador.pantallaJuegoCompletado();
		menuLoop();
	}
	
}
