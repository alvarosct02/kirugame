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
				System.out.println("En una casa de Lima, Kiara recibió de regalo\n"
						         + "un lindo y perqueño cuy, al que le puso nombre\n"
						         + "Kiru, que significa dientes en quechua y le \n"
						         + "puso así por sus grandes dientes, que eran tan\n"
						         + " brillantes como las perlas del mar.\n\n"
						         + "Allí kiru se encontró con Milo, el engreído de \n"
						         + "la casa porque era un perro muy juguetón. Todos \n"
						         + "los días jugaban juntos por todas las partes de \n"
						         + "la casa. Jugaban en la sala, en la cocina, en el \n"
						         + "jardín y en los lugares menos imaginados\n\n"
						         + "Un día Milo le contó a Kiru que él nació \n"
						         + "en Lima y por eso era limeño. Entonces Kiru le \n"
						         + "preguntó:- Tú sabes ¿de dónde soy yo? -Yo sé que \n"
						         + "un día te trajeron, pero no sé de dónde- respondió \n"
						         + "Milo. Entonces Kiru se preguntó: ¿Y de dónde vengo yo?\n\n"
						         + "Kiry se sentía muy triste porque no sabía de dónde era. \n"
						         + "Y a Milo se le ocurrió una gran idea..-¿qué te parece si \n"
						         + "nos vamos de viaje por varios lugares del Perú?, así \n"
						         + "podremos averiguar y saber de dónde eres. Y sin decir \n"
						         + "nada a sus dueños, se escaparon de la casa.");
				break;
			case 2:
				System.out.println("Luego de haberse escapado de la casa de sus amos empiezan\n"
						         + " su travesía a través de las congestionadas calles de Lima. \n"
						         + "Sorteando carro tras carro logran encontrar un carro cuyo \n"
						         + "destino les parece prometedor. Se suben al carro con Destino \n"
						         + "a Paracas y...\n\n"
						         + "Llegan a una playa muy bonita con un sol muy radiante y les \n"
						         + "entran ganas de celebrar su gran hazaña. Empiezan a jugar \n"
						         + "con la area, se meten al matar y disfrutan de la hermosa playa");
				break;
			case 3:
				System.out.println("Mientras jugaban en la playa un personaje surcaba los cielos y\n"
						         + "decide acercase al peculiar par. Se encontraron con Peli el \n"
						         + "pelicano. El era un pelicano muy orgulloso. Entonces Kiru le\n"
						         + " preguntó: - Disculpe señor pelicano, ¿usted sabe de dónde vienen \n"
						         + "los cuyes? -Peli respondió: -No, pero los pelicanos somos de \n"
						         + "aquí de Paracas. toda mi vida he vivido aquí y no he visto ni\n"
						         + "un cuy. -Entonces Kiru se preguntó: ¿Y de dónde vengo yo?\n\n"
						         + "Tras no haber conseguido una respuesta satisfactoria el par \n"
						         + "decide seguir su camino en direccion a las alturas, deciden \n"
						         + "dirigirse a la sierra");
				break;
			case 4:
				System.out.println("En su camino se hallaron en un lugar llamado Cusco. Cuando \n"
						         + "estaban cerca de Machu Picchu, se encontraron con Dana la llama. \n"
						         + "Kiru le hizo la misma pregunta, pero ella le respondió: Querido \n"
						         + "Kiru, los cuyes no pertenecen a una sola parte del Perú, sino \n"
						         + "que ellos están por tod la cordillera de los Andes, desde Venezuela, \n"
						         + "pasando por el Perú y llegando hasta Argentína. tienes que estar \n"
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
