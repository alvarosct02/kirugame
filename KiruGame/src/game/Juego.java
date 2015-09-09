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
	
	private static boolean salir = false;
	
//	Nivel inicial a jugar
	private final int firstLevel = 0;
	
	public static int renderMode = 0;
	private String cmd = ""; 
	private Scanner sc = new Scanner(System.in);
	
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
//		TUTORIAL
		if (i == 0){
			if (p1.gridX == 8 && p1.gridY == 2 && map.isSpecial(8, 2)){
				map.banishObject(8, 2);
				map.toogleSpecial(8, 2);
				String sec = "WEDQ";
				while(true){
					if (Jugador.getVida() <= 0) return true;
					Renderizador.requestSecuencia(sec);
					if (secuencia(sec)){
						break;
					} else {
						Renderizador.errorSecuencia(sec);
					}
				}
				sc.nextLine();
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				Renderizador.pressToMove(1);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				Renderizador.pressToMove(1);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				Renderizador.pressToMove(1);
				sc.nextLine();
			}
			
			if (p1.gridX == 13 && p1.gridY == 5 && p2.gridX == 13 && p2.gridY == 8 && map.isSpecial(13, 5) && map.isSpecial(13, 8)){

				map.banishObject(13, 5);
				map.toogleSpecial(13, 5);
				map.banishObject(13, 8);
				map.toogleSpecial(13, 8);
				String sec = "SDKIQEUO";
				while(true){
					if (Jugador.getVida() <= 0) return true;
					Renderizador.requestSecuencia(sec);
					if (secuencia(sec)){
						break;
					} else {
						Renderizador.errorSecuencia(sec);
					}
				}
				sc.nextLine();
				
				p1.setXY(p1.gridX, p1.gridY+1);
				p2.setXY(p2.gridX, p2.gridY-1);

				Renderizador.pressToMove(2);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				p2.setXY(p2.gridX + 1, p2.gridY);
				Renderizador.pressToMove(2);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				p2.setXY(p2.gridX + 1, p2.gridY);
				Renderizador.pressToMove(2);
				sc.nextLine();
				
				Renderizador.dialogo2();
				return true;
			}
		}
		if (i == 1){
			if (p1.gridX == 10 && p1.gridY == 4 && map.isSpecial(10, 4)){
				map.banishObject(10, 4);
				map.toogleSpecial(10, 4);
				String sec = "SDQEQE";
				while(true){
					if (Jugador.getVida() <= 0) return true;
					Renderizador.requestSecuencia(sec);
					if (secuencia(sec)){
						break;
					} else {
						Renderizador.errorSecuencia(sec);
					}
				}
				sc.nextLine();
				
				p1.setXY(p1.gridX, p1.gridY + 1);
				Renderizador.pressToMove(1);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p1.setXY(p1.gridX, p1.gridY +1);
				Renderizador.pressToMove(1);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p1.setXY(p1.gridX, p1.gridY + 2);
				Renderizador.pressToMove(1);
				sc.nextLine();
				Renderizador.mostrarMapa(map);	
				
				map.banishObject(p1.gridX, p1.gridY);
				map.banishObject(p1.gridX-1, p1.gridY);
				map.banishObject(p1.gridX, p1.gridY+1);
				map.banishObject(p1.gridX-1, p1.gridY+1);
				p1.setXY(p1.gridX, p1.gridY - 4);				
				Renderizador.pressToMove(1);
				sc.nextLine();
			}
			
			if (p2.gridX == 4 && p2.gridY == 9  && map.isSpecial(4, 9)){

				map.banishObject(4,9);
				map.toogleSpecial(4,9);
				String sec = "JJUOJ";
				while(true){
					if (Jugador.getVida() <= 0) return true;
					Renderizador.requestSecuencia(sec);
					if (secuencia(sec)){
						break;
					} else {
						Renderizador.errorSecuencia(sec);
					}
				}
				sc.nextLine();
				
				p2.setXY(p2.gridX-1, p2.gridY);
				Renderizador.pressToMove(1);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p2.setXY(p2.gridX-1, p2.gridY);
				Renderizador.pressToMove(1);
				sc.nextLine();
			}
			
			if (p1.gridX == 0 && p2.gridX == 0){
				return true;
			}
		}
		if (i == 2){
			if (p1.gridX == 3 && p1.gridY == 5 && map.isSpecial(3, 5)){
				map.banishObject(3, 5);
				map.toogleSpecial(3, 5);
				String sec = "SDEWD";
				while(true){
					if (Jugador.getVida() <= 0) return true;
					Renderizador.requestSecuencia(sec);
					if (secuencia(sec)){
						break;
					} else {
						Renderizador.errorSecuencia(sec);
					}
				}
				sc.nextLine();
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				Renderizador.pressToMove(1);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				Renderizador.pressToMove(1);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p1.setXY(p1.gridX + 1, p1.gridY);
				Renderizador.pressToMove(1);
				sc.nextLine();
			}
			
			if (p1.gridX == 8 && p1.gridY == 6 && p2.gridX == 8 && p2.gridY == 8 && map.isSpecial(8, 6) && map.isSpecial(8, 8)){

				map.banishObject(8, 6);
				map.toogleSpecial(8,6);
				map.banishObject(8, 8);
				map.toogleSpecial(8, 8);
				String sec = "SIQEUOKLSD";
				while(true){
					if (Jugador.getVida() <= 0) return true;
					Renderizador.requestSecuencia(sec);
					if (secuencia(sec)){
						break;
					} else {
						Renderizador.errorSecuencia(sec);
					}
				}
				sc.nextLine();
				
				p1.setXY(p1.gridX+1, p1.gridY);
				p2.setXY(p2.gridX+1, p2.gridY);
				Renderizador.pressToMove(2);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
				
				p1.setXY(p1.gridX + 3, p1.gridY-1);
				p2.setXY(p2.gridX + 3, p2.gridY);
				Renderizador.pressToMove(2);
				sc.nextLine();
				Renderizador.mostrarMapa(map);
							
				p1.setXY(p1.gridX, p1.gridY + 1);
				p2.setXY(p2.gridX, p2.gridY -1);
				map.toogleWalk(p1.gridX, p1.gridY);
				map.toogleWalk(p1.gridX + 1, p1.gridY);
				map.toogleWalk(p1.gridX + 2, p1.gridY);
				map.toogleWalk(p1.gridX + 3, p1.gridY);
				map.toogleWalk(p1.gridX, p1.gridY +1);
				map.toogleWalk(p1.gridX + 1, p1.gridY +1);
				map.toogleWalk(p1.gridX + 2, p1.gridY +1);
				map.toogleWalk(p1.gridX + 3, p1.gridY +1);
				Renderizador.pressToMove(2);
				sc.nextLine();
			}			

			if (p1.gridX == 15 && p2.gridX == 15){
				return true;
			}
		}
		return false;
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
		Renderizador.pantallaGameOver();
		menuLoop();
	}
	
	private void gameWin() {
		Renderizador.pantallaJuegoCompletado();
		menuLoop();
	}
	
}
