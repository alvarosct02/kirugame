import javaAS3.StageAS3;
import vista.GestorImagenes;
import vista.Juego;

public class Main {
	public static void main(String[] args) {	
		GestorImagenes.cargarImagenes();
		Juego game = new Juego();
		System.out.println("El juego ha terminado");
	}
}