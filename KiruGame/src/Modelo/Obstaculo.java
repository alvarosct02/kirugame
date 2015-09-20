package Modelo;

import Vista.GestorMapas;

public class Obstaculo extends Objeto{

	public Obstaculo(int posX, int posY, int w, int h, char sprite) {
		super(posX, posY, w, h, sprite);
		agregarMapa();
		
		
	}
	
	private void agregarMapa(){
		for (int i = 0; i<gridH ; i++){
			for (int j = 0; j<gridW ; j++){
				GestorMapas.map.getCelda(gridX+j,gridY+i).visibleChar = sprite;
			}
		}
	}
	
}
