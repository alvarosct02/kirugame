package modelo;

import actionscript3.MovieClip;
import modelo.Drawable;
import modelo.dataHolder.ObjetoData;
import vista.Juego;

public class Objeto extends Drawable{
	
	public Objeto(int id, int x, int y, ObjetoData objData){
		super(id,x,y,objData.width,objData.height, objData.caracter);
		
		this.sprite = new MovieClip(objData.mc);		
		this.sprite.x = gridX * Juego.GRIDSIZE;
		this.sprite.y = gridY * Juego.GRIDSIZE;
		addToMap();
	}
}