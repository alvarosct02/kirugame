package modelo;

import actionscript3.Sprite;
import controlador.GestorMapas;

public abstract class Drawable{
	
	public char caracter = '_';
	public int gridX;
	public int gridY;
	public int gridW;
	public int gridH;
	public int id;
	private boolean active = false;
	
	public Sprite sprite = new Sprite();
	
	public Drawable(int id, int xpos, int ypos,int w, int h, char caracter)	{
		gridX = xpos;
		gridY = ypos;
		gridW = w;
		gridH = h;
		this.caracter = caracter;
	}
	
	public boolean isActive() {
		return active;
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
	
	public void enable(){
		this.active = true;
	}
	
	public void disable(){
		this.active = false;
	}
	
	public boolean isHere(int x,int y){
		return (gridX == x && gridY == y);
	}
	
	public void addToMap(){
		if (isActive() == true) return;
		
		enable();		
		GestorMapas.map.addChild(this.sprite);
//		Cambiar las Celdas
		for (int i = 0; i<gridH ; i++){
			for (int j = 0; j<gridW ; j++){
				GestorMapas.map.getCelda(gridX+j,gridY+i).visibleChar = caracter;
			}
		}
	}
	
	public void removeFromMap(){
		if (isActive() == false) return;
		
		disable();
		GestorMapas.map.removeChild(this.sprite);
//		Cambiar las Celdas
		for (int i = 0; i<gridH ; i++){
			for (int j = 0; j<gridW ; j++){
				GestorMapas.map.getCelda(gridX+j,gridY+i).showTerreno();
			}
		}
	}
}