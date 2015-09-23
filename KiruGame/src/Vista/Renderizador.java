package Vista;

import Modelo.Jugador;
import Controlador.*;

public class Renderizador {
	
	
//	Mantaner el esquema 
//	if (Juego.renderMode == 0){	
//		Codigo AQUI
//	}

	public static void mostrarWelcome(){
		if (Juego.renderMode == 0){
			System.out.println(
				  "---------------------------------------------------------------------------\n"
				+ "                            B I E N V E N I D O \n\n"
				+ "                        Presione ENTER para continuar \n"
				+ "---------------------------------------------------------------------------");	
		}
	}
	
	public static void mostrarMenuIncial(){
		if (Juego.renderMode == 0){
			System.out.println(""
				+ "---------------------------------------------------------------------------\n"
				+ "                              MENU PRINCIPAL                               \n\n"
				+ "     Ingrese el numero de la accion a realizar: \n"
				+ "       1. Iniciar Juego\n"
				+ "       2. Salir del Juego\n"
				+ "---------------------------------------------------------------------------");	
		}
	}
	
	public static void beginPedirDatos(){
		if (Juego.renderMode == 0){
			System.out.format(""
				+ "---------------------------------------------------------------------------\n"
				+ "                          DATOS DE LOS JUGADORES                           \n\n");				
		}
	}
	
	public static void endPedirDatos(){
		if (Juego.renderMode == 0){
			System.out.format("---------------------------------------------------------------------------\n");				
		}
	}
	
	public static void pedirDatos(int player){
		if (Juego.renderMode == 0){
			System.out.format("     Nombre del Jugador %d: ", player);			
		}
	}
	
	
	public static void confirmacionSalir(){
		if (Juego.renderMode == 0){
			System.out.println(""
				+ "---------------------------------------------------------------------------\n\n"
				+ "     Esta seguro que desea salir? \n"
				+ "       1. Si, deseo salir del juego\n"
				+ "       2. No, volver al menu principal\n"
				+ "---------------------------------------------------------------------------");
		}		
	}	
	
	public static void endGame(){
		if (Juego.renderMode == 0){
			System.out.println(""
				+ "----------------------------------- FIN -----------------------------------");
		}
	}
	
	public static void nuevoNivel(int i){
		if (Juego.renderMode == 0){
			String nivelstr;
			if (i == 0){
				nivelstr = "                       N I V E L     T U T O R I A L \n";
			} else {
				nivelstr = "                              N I V E L     " + String.valueOf(i) + "\n";
			}
			System.out.format(""
				+ "---------------------------------------------------------------------------\n"
				+ nivelstr
				+ "---------------------------------------------------------------------------\n");
		}
	}
	
	public static void mostrarPantalla(Mapa map) {
		if (Juego.renderMode == 0){			
			System.out.println();
			mostrarDatos(Mapa.p1, Mapa.p2);
			mostrarMapa();
		}			
	}
	
	public static void mostrarDatos(Jugador p1, Jugador p2){
		if (Juego.renderMode == 0){
			System.out.format(""
				+ "---------------------------------------------------------------------------\n"
				+ "      Cuy : %s\n"
				+ "     Milo : %s\n"
				+ "     Vida : %d puntos\n"
				+ "---------------------------------------------------------------------------\n"
				,p1.getNombre(),p2.getNombre(),Jugador.getVida());
		}
	}
	
	public static void mostrarMapa(){		
		System.out.println();
		for (int i = 0; i<Mapa.gridHeight; i++){
			System.out.print("                    ");
			for (int j = 0; j<Mapa.gridWidth; j++){
				char valor = GestorMapas.map.getCeldaValue(j,i);
				System.out.print(valor + " ");		
			}
			System.out.println();
		}		
	}	

	public static void ingreseComandoGame() {
		if (Juego.renderMode == 0){
			System.out.println();
			if (Juego.renderMode == 0){
				System.out.format(""
					+ "---------------------------------------------------------------------------\n"
					+ "            Arriba ( W / I )                Izquierda ( A / J ) \n"
					+ "             Abajo ( S / K )                  Derecha ( D / L ) \n"
					+ "             Salir (  ESC  ) \n\n"
					+ " >> Ingrese el comando a ejecutar: ");
			}
		}	
		
	}
	
	public static void errorCmd(){
		if (Juego.renderMode == 0){
			System.out.println(" >> Error: Comando Invalido. Vuelva a intentarlo");
		}		
	}

	public static void logMover(String nombre, String dir) {
		if (Juego.renderMode == 0){
			System.out.format(" >> El jugador %s se ha movido hacia %s\n",nombre,dir);	
		}		
	}
	
	public static void confirmacionSalirGame() {
		if (Juego.renderMode == 0){
			System.out.println(""
				+ "---------------------------------------------------------------------------\n\n"
				+ "     Esta seguro que desea salir? \n"
				+ "       1. Si, deseo salir al menu principal\n"
				+ "       2. No, volver al juego\n"
				+ "---------------------------------------------------------------------------");
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

	public static void logNoMover() {
		if (Juego.renderMode == 0){
			System.out.println(" >> No puedes moverte en esta direccion");	
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
			System.out.println(""
				+ "---------------------------------------------------------------------------\n\n"
				+ "                           G A M E     O V E R                             \n\n"
				+ "        Has perdido el juego.... Te esperamos para una otra partida !      \n"
				+ "---------------------------------------------------------------------------");
		}
	}
	
	public static void pantallaJuegoCompletado(){
		if (Juego.renderMode == 0){
			System.out.println(""
				+ "---------------------------------------------------------------------------\n\n"
				+ "                              JUEGO COMPLETADO \n\n"
				+ "                Bravo ! Has completado el juego. Fue muy facil ? \n"
				+ "---------------------------------------------------------------------------");
		}
	}
	

	public static void requestChar(char car) {
		if (Juego.renderMode == 0){
			System.out.format(" >> Presiona %c: ",car);	
		}			
	}

	
	public static void requestSecuencia(String sec) {
		if (Juego.renderMode == 0){
			System.out.format(""
				+ "---------------------------------------------------------------------------\n\n"
				+ "                           COMPLETA LA SECUENCIA                           \n\n"
				+ "  Ingresa la secuencia \"%s\" para realizar una accion especial! \n"
				+ "---------------------------------------------------------------------------\n",
				sec);
		}		
	}
	
	public static void errorSecuencia(String sec) {
		if (Juego.renderMode == 0){
			System.out.format(" >> Error en la secuencia ingresada \"%s\"\n"
					+" >> Has perdi 2 puntos de vida, te quedan %d puntos\n",sec,Jugador.getVida());	
		}			
	}
	
	public static void pressToMove(int tipoAccion) {
		if (Juego.renderMode == 0){
			System.out.println();
			if (tipoAccion == 1){
				System.out.format(" >> Accion Especial en curso\n");	
			} else if (tipoAccion == 2){
				System.out.format(" >> Combo Duo en curso\n");	
			}
			System.out.format(" >> Presiona ENTER para continuar\n");	
		}			
	}
}
