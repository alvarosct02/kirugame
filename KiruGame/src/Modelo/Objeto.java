package Modelo;

import Modelo.Sprite;
import Vista.GestorMapas;

public class Objeto extends Sprite{
				
	public Objeto(int id, int x, int y, int w, int h, char sprite){
		super(x,y,w,h,sprite);
		this.id = id;
		agregarMapa();
	}
	
	public void agregarMapa(){
		for (int i = 0; i<gridH ; i++){
			for (int j = 0; j<gridW ; j++){
				GestorMapas.map.getCelda(gridX+j,gridY+i).visibleChar = sprite;
			}
		}
	}
	
	public void quitarMapa(){
		for (int i = 0; i<gridH ; i++){
			for (int j = 0; j<gridW ; j++){
				GestorMapas.map.getCelda(gridX+j,gridY+i).showTerreno();
			}
		}
	}
}