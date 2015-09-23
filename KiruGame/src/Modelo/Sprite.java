package Modelo;

import Controlador.GestorMapas;
import Controlador.Mapa;

public abstract class Sprite{
	
	public int tipo = -1;
	public char sprite = '_';
	public int gridX;
	public int gridY;
	public int gridW;
	public int gridH;
	public int id;
	
	public Sprite(int xpos, int ypos,int w, int h, char sprite)	{
		gridX = xpos;
		gridY = ypos;
		gridW = w;
		gridH = h;
		this.sprite = sprite;
	}
	
	public int isValid(int x, int y){		
		if (x>=0 && y>=0 && x< Mapa.gridWidth && y< Mapa.gridHeight){
			return 1 ;
		} else
			return 0 ;
	}
	
	public void setXY(int x, int y){		
		gridX = x;
		gridY = y;
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