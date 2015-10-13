package modelo;

import controlador.GestorMapas;

public class ObjetoApoyo extends Objeto{

	public ObjetoApoyo(int id,int x, int y, ObjetoData objData) {
		super(id,x, y, objData);
		caracter = 'o';
		
	}
	

	public void allowWalk(){
		for (int i = 0; i<gridH ; i++){
			for (int j = 0; j<gridW ; j++){
				GestorMapas.map.getCelda(gridX+j,gridY+i).walkable = true;
			}
		}
	}
	
}