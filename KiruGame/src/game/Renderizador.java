package game;

import mapa.Mapa;

public class Renderizador {
	
	
//	Mantaner el esquema 
//	if (Juego.renderMode == 0){	
//		Codigo AQUI
//	}

	public static void mostrarWelcome(){
		if (Juego.renderMode == 0){
			System.out.println("Bienvenido al Juego");	
			System.out.println("Presione ENTER para continuar");	
		}
	}
	
	public static void pedirDatos(int player){
		if (Juego.renderMode == 0){
			System.out.format("Ingrese nombre del Jugador %d:", player);			
		}
	}
	
	
	public static void confirmacionSalir(){
		if (Juego.renderMode == 0){
			System.out.println("Esta seguro que desea salir?");
			System.out.println("\t1. Si, deseo salir del juego");	
			System.out.println("\t2. No, volver al menu");	
		}		
	}
	
	
	public static void errorCmd(){
		if (Juego.renderMode == 0){
			System.out.println("Error: Comando Invalido");
		}		
	}
	
	public static void endGame(){
		if (Juego.renderMode == 0){
			System.out.println("El juego ha terminado");
		}
	}
	
	public static void mostrarMenuIncial(){
		if (Juego.renderMode == 0){
			System.out.println("Ingrese el numero de la accion a realizar:");	
			System.out.println("\t1. Iniciar Juego");	
			System.out.println("\t2. Salir del Juego");	
		}
	}
	
	public static void mostrarMapa(Mapa map){		
		for (int i = 0; i<Juego.gridHeight; i++){
			for (int j = 0; j<Juego.gridWidth; j++){
				char valor = map.getCeldaValue(i, j);
				System.out.print(valor + " ");		
			}
			System.out.println();
		}
	}

	public static void mostrarPantalla(Mapa map) {
		if (Juego.renderMode == 0){
			System.out.println("mostrarPantalla");
			mostrarMapa(map);
		}	
		
	}

	public static void mostrarHistoria(int i) {
		if (Juego.renderMode == 0){
			System.out.format("mostrarHistoria");
			System.out.println();
		}	
		
	}

	public static void ingreseComandoGame() {
		if (Juego.renderMode == 0){
			System.out.println("ingreseComandoGame");	
		}	
		
	}

	public static void mostrarGameOver() {
		if (Juego.renderMode == 0){
			System.out.println("mostrarGameOver");	
		}	
		
	}

	public static void logMover(String nombre, String dir) {
		if (Juego.renderMode == 0){
			System.out.format("%s se ha movido hacia %s\n\n",nombre,dir);	
		}	
		
	}

	public static void confirmacionSalirGame() {
		if (Juego.renderMode == 0){
			System.out.println("Esta seguro que desea salir?");
			System.out.println("\t1. Si, deseo salir al menu principal");	
			System.out.println("\t2. No, volver al juego");	
		}		
		
	}

	public static void log(String msg) {
		if (Juego.renderMode == 0){
			System.out.format("%s\n",msg);	
		}	
		
	}
	
	
	
}
