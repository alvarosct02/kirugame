package game;

import drawable.personaje.Jugador;
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

			System.out.println();
			mostrarDatos(Juego.p1, Juego.p2);
			mostrarMapa(map);
		}			
	}

	public static void mostrarHistoria(int i) {
		if (Juego.renderMode == 0){
			System.out.println();
			switch(i){
			case 1:
				System.out.println("En una casa de Lima, Kiara recibi� de regalo\n"
						         + "un lindo y perque�o cuy, al que le puso nombre\n"
						         + "Kiru, que significa dientes en quechua y le \n"
						         + "puso as� por sus grandes dientes, que eran tan\n"
						         + " brillantes como las perlas del mar.\n\n"
						         + "All� kiru se encontr� con Milo, el engre�do de \n"
						         + "la casa porque era un perro muy juguet�n. Todos \n"
						         + "los d�as jugaban juntos por todas las partes de \n"
						         + "la casa. Jugaban en la sala, en la cocina, en el \n"
						         + "jard�n y en los lugares menos imaginados\n\n"
						         + "Un d�a Milo le cont� a Kiru que �l naci� \n"
						         + "en Lima y por eso era lime�o. Entonces Kiru le \n"
						         + "pregunt�:- T� sabes �de d�nde soy yo? -Yo s� que \n"
						         + "un d�a te trajeron, pero no s� de d�nde- respondi� \n"
						         + "Milo. Entonces Kiru se pregunt�: �Y de d�nde vengo yo?\n\n"
						         + "Kiry se sent�a muy triste porque no sab�a de d�nde era. \n"
						         + "Y a Milo se le ocurri� una gran idea..-�qu� te parece si \n"
						         + "nos vamos de viaje por varios lugares del Per�?, as� \n"
						         + "podremos averiguar y saber de d�nde eres. Y sin decir \n"
						         + "nada a sus due�os, se escaparon de la casa.");
				break;
			case 2:
				System.out.println("Luego de haberse escapado de la casa de sus amos empiezan\n"
						         + " su traves�a a trav�s de las congestionadas calles de Lima. \n"
						         + "Sorteando carro tras carro logran encontrar un carro cuyo \n"
						         + "destino les parece prometedor. Se suben al carro con Destino \n"
						         + "a Paracas y...\n\n"
						         + "Llegan a una playa muy bonita con un sol muy radiante y les \n"
						         + "entran ganas de celebrar su gran haza�a. Empiezan a jugar \n"
						         + "con la area, se meten al matar y disfrutan de la hermosa playa");
				break;
			case 3:
				System.out.println("Mientras jugaban en la playa un personaje surcaba los cielos y\n"
						         + "decide acercase al peculiar par. Se encontraron con Peli el \n"
						         + "pelicano. El era un pelicano muy orgulloso. Entonces Kiru le\n"
						         + " pregunt�: - Disculpe se�or pelicano, �usted sabe de d�nde vienen \n"
						         + "los cuyes? -Peli respondi�: -No, pero los pelicanos somos de \n"
						         + "aqu� de Paracas. toda mi vida he vivido aqu� y no he visto ni\n"
						         + "un cuy. -Entonces Kiru se pregunt�: �Y de d�nde vengo yo?\n\n"
						         + "Tras no haber conseguido una respuesta satisfactoria el par \n"
						         + "decide seguir su camino en direccion a las alturas, deciden \n"
						         + "dirigirse a la sierra");
				break;
			case 4:
				System.out.println("En su camino se hallaron en un lugar llamado Cusco. Cuando \n"
						         + "estaban cerca de Machu Picchu, se encontraron con Dana la llama. \n"
						         + "Kiru le hizo la misma pregunta, pero ella le respondi�: Querido \n"
						         + "Kiru, los cuyes no pertenecen a una sola parte del Per�, sino \n"
						         + "que ellos est�n por tod la cordillera de los Andes, desde Venezuela, \n"
						         + "pasando por el Per� y llegando hasta Argent�na. tienes que estar \n"
						         + "orgulloso porque los cuyes son de varios lugares. \n\n"
						         + "Feliz por la respuesta de Dana, Kiru decide, con Milo, viajar por \n"
						         + "todos los Andes");
			}
		}	
		
	}

	public static void ingreseComandoGame() {
		if (Juego.renderMode == 0){
			System.out.println("ingreseComandoGame");	
		}	
		
	}
	
	public static void mostrarDatos(Jugador j, Jugador k){
		System.out.println("Player 1: "+j.getNombre());
		System.out.println("Player 2: "+k.getNombre());
		System.out.println("Vida: "+j.getVida());
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
			System.out.println("Si ves un lugar para la acci�n o el d�o �P�rate sobre �l! Podr�s realizar acciones especiales. ");
			System.out.println("S�lo podr�s pasar los niveles con la ayuda de las acciones especiales. Para esto, tendr�s que ");
			System.out.println("presionar comandos que se mostrar�n en un cuadro de di�logo como �ste. ");
			System.out.println("Los comandos deben ser ejecutados en la secuencia correcta sino perder�s puntos de vida. ");
			System.out.println("Puedes ver los puntos de vida en la parte superior de la pantalla. ");
			System.out.println("Para activar los terrenos con acciones especiales d�o, tienen que estar sobre ellos Kiru y ");
			System.out.println("Milo al mismo tiempo, en los de acciones especiales s�lo con uno basta. ");
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
			System.out.println("En tu aventura, a veces te topar�s con animales malos. ");
			System.out.println("Estos enemigos te bajar�n puntos de vida. Si tus puntos de vida llegan a 0, se acabar� el juego. ");
			System.out.println("Si un enemigo afecta a un personaje, este no se podr� mover. Tendr�s que usar a su amigo para ayudarlo. ");
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
			System.out.println("Bravo ! Has completado el juego. Fue muy fac�l ? ");
			System.out.println();
			System.out.println("---------------------------------------------------------------");
			System.out.println();
		}
	}
	

	public static void requestChar(char car) {
		if (Juego.renderMode == 0){
			System.out.format("Presiona %c:\n",car);	
		}			
	}

	public static void pressToMove() {
		if (Juego.renderMode == 0){
			System.out.format("Presiona Enter para continuar");	
		}			
	}
}
