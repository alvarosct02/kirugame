package Modelo;

import Modelo.Sprite;
import Vista.GestorMapas;

public class Objeto extends Sprite{
				
	public Objeto(int id, int x, int y, int w, int h, char sprite){
		super(x,y,w,h,sprite);
		this.id = id;
		agregarMapa();
	}
}