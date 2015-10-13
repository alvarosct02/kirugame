package modelo;

import actionscript3.MovieClip;
import controlador.GestorMapas;
import modelo.dataHolder.EnemigoData;
import vista.Juego;

public class Enemigo extends Drawable implements ITrigger{
	private int actionID;
	private int rango;
	private int jugID;

	private boolean activable;
	
	public void setActivable(boolean activable) {
		this.activable = activable;
	}

	public boolean isActivable() {
		return activable;
	}

	public Enemigo(int id,int x, int y, int accion, int jug, EnemigoData objData) {
		super(id,x,y,objData.width, objData.height,'E');
		this.actionID = accion;
		this.rango = objData.rango;
		this.jugID = jug;
		this.activable = true;
		
		this.sprite = new MovieClip(objData.mc);
		
		System.out.println(gridX);
		System.out.println(gridY);
		sprite.x = gridX * Juego.GRIDSIZE;
		sprite.y = gridY * Juego.GRIDSIZE;
	}
	
	public boolean check() {
		if (activable != true) return false;	
		Jugador player = jugID == 1 ? Mapa.p1 : Mapa.p2;
		
		for (int w = 0; w<gridW; w++){
			for (int h = 0; h<gridH; h++){	
				for (int i = -rango; i<=rango; i++){
					for (int j = -rango; j<= rango; j++){	
						if (player.isHere(gridX+j+w, gridY+i+h)){
							activable = false;
							return true;	
						}
					}
				}
			}
		}
		
		return false;
	}

	public int ejecutar() {
		Jugador player = jugID == 1 ? Mapa.p1 : Mapa.p2;
		player.blooding = true;
		addToMap();
		GestorMapas.map.activarAccion(actionID);
		return 0;
	}
	
	public void destruir() {
		Jugador player = jugID == 1 ? Mapa.p1 : Mapa.p2;
		player.blooding = false;
		removeFromMap();
	}
	
//	public int tryDie(int x, int y , String action)
//	{
//		if (x == this.dieX && this.dieY == y && action == this.action)
//		{
//			return 1 ;
//		}else return 0;
//	}
}
