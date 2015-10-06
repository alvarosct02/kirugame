package modelo;

import actionscript3.SpriteAS3;
import controlador.GestorMapas;
import modelo.Sprite;
import vista.Juego;

public class Objeto extends Sprite{
	
	public Objeto(int id, int x, int y, ObjetoData objData){
		super(x,y,objData.width,objData.height);
		this.id = id;
		this.sprite.setImg(objData.img);
		this.caracter = objData.sprite;
		this.sprite.x = gridX * Juego.GRIDSIZE;
		this.sprite.y = gridY * Juego.GRIDSIZE;
		agregarMapa();
	}
}