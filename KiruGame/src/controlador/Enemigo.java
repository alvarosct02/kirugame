package controlador;

import modelo.ITrigger;
import modelo.Jugador;
import modelo.Personaje;

public class Enemigo extends Personaje implements ITrigger{
	private int actionID;
	private int rango;
	private int jugID;

	private boolean activa;
	
	public Enemigo(int id,int x, int y, int w, int h, char sprite, int accion, int rango, int jug) {
		super(x,y,w,h,sprite);
		this.actionID = accion;
		this.rango = rango;
		this.jugID = jug;
		this.id = id;
		this.activa = true;
	}
	
	public boolean check() {
		if (activa != true) return false;	
		Jugador player = jugID == 1 ? Mapa.p1 : Mapa.p2;
		
		for (int w = 0; w<gridW; w++){
			for (int h = 0; h<gridH; h++){	
				for (int i = -rango; i<=rango; i++){
					for (int j = -rango; j<= rango; j++){	
						if (player.isHere(gridX+j+w, gridY+i+h)){
							activa = false;
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
		agregarMapa();
		GestorMapas.map.activarAccion(actionID);
		return 0;
	}
	
	public void destruir() {
		Jugador player = jugID == 1 ? Mapa.p1 : Mapa.p2;
		player.blooding = false;
		quitarMapa();	
	}
	
//	public int tryDie(int x, int y , String action)
//	{
//		if (x == this.dieX && this.dieY == y && action == this.action)
//		{
//			return 1 ;
//		}else return 0;
//	}
}
