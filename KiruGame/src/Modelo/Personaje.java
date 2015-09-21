package Modelo;
import Modelo.Sprite;
import Controlador.*;

public class Personaje extends Sprite{
	protected int alto;
	protected int ancho;
	
	public Personaje(int x, int y, int alto, int ancho, char sprite){
		super(x,y,sprite);
		this.alto = alto;
		this.ancho = ancho;
	}	
	
	
}
