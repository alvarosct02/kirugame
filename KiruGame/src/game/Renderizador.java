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
	
	public static void dialogo1(){
		if (Juego.renderMode == 0){
			System.out.println();
			System.out.println("-----------------------1-------------------------------");
			System.out.println();
			System.out.println("Usa WASD para mover a Kiru y JKLI para mover a Milo. ");
			System.out.println("Si ves un lugar para la acción o el dúo ¡Párate sobre él! Podrás realizar acciones especiales. ");
			System.out.println("Sólo podrás pasar los niveles con la ayuda de las acciones especiales. Para esto, tendrás que ");
			System.out.println("presionar comandos que se mostrarán en un cuadro de diálogo como éste. ");
			System.out.println("Los comandos deben ser ejecutados en la secuencia correcta sino perderás puntos de vida. ");
			System.out.println("Puedes ver los puntos de vida en la parte superior de la pantalla. ");
			System.out.println("Para activar los terrenos con acciones especiales dúo, tienen que estar sobre ellos Kiru y ");
			System.out.println("Milo al mismo tiempo, en los de acciones especiales sólo con uno basta. ");
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println();
		}
	}
	
	public static void dialogo2(){
		if (Juego.renderMode == 0){
			System.out.println();
			System.out.println("-------------------------2-----------------------------");
			System.out.println();
			System.out.println("En tu aventura, a veces te toparás con animales malos. ");
			System.out.println("Estos enemigos te bajarán puntos de vida. Si tus puntos de vida llegan a 0, se acabará el juego. ");
			System.out.println("Si un enemigo afecta a un personaje, este no se podrá mover. Tendrás que usar a su amigo para ayudarlo. ");
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println();
		}
	}
	
	public static void pantallaGameOver(){
		if (Juego.renderMode == 0){
			System.out.println();
			System.out.println("-------------------------GAME OVER-----------------------------");
			System.out.println("");
			System.out.println("Has perdido el juego.... Te esperamos para una otra partida ! ");
			System.out.println("");
			System.out.println("");
			System.out.println("---------------------------------------------------------------");
			System.out.println();
		}
	}
	
	public static void pantallaJuegoCompletado(){
		if (Juego.renderMode == 0){
			System.out.println();
			System.out.println("-------------------------Juego Completado-----------------------------");
			System.out.println("");
			System.out.println("Bravo ! Has completado el juego. Fue muy facíl ? ");
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			System.out.println();
		}
	}
}
