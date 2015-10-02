package modelo;

import controlador.GestorMapas;

public class ObjetoApoyo extends Objeto{

	public ObjetoApoyo(int id,int x, int y, int w, int h, char sprite) {
		super(id,x, y, w, h, sprite);
	}
	

	public void allowWalk(){
		for (int i = 0; i<gridH ; i++){
			for (int j = 0; j<gridW ; j++){
				GestorMapas.map.getCelda(gridX+j,gridY+i).walkable = true;
			}
		}
	}
	
}