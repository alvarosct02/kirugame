package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import actionscript3.MovieClip;
import controlador.GestorMapas;
import modelo.dataHolder.EnemigoData;
import vista.Juego;
import vista.screen.PopupAction;
import vista.screen.ScreenManager;

public class Enemigo extends Drawable implements ITrigger{
	private int actionID;
	private int rango;
	private int jugID;
	private TimerEnemy timer = null;

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
		timer = new TimerEnemy();
		timer.start();
		Jugador player = jugID == 1 ? Mapa.p1 : Mapa.p2;
		player.blooding = true;
		addToMap();
		GestorMapas.map.activarAccion(actionID);
		return 0;
	}
	
	public void destruir() {
		timer.detener();
		Jugador player = jugID == 1 ? Mapa.p1 : Mapa.p2;
		player.blooding = false;
		removeFromMap();
	}

}


class TimerEnemy extends Thread{
	private int maxTime = 0;
	private int contador = -1;
	private boolean running = true;
	
	public TimerEnemy(){
		this.maxTime = 2;
	}
	
	public void detener(){
		running = false;
	}
	
	public void run() {
		try {
			while (running){
				contador ++ ;
				System.out.println("Seconds:" + contador);
				
				if (Jugador.getVida() <= 0){
					break;
				}
				
				if (contador == maxTime){
					contador = -1;
					Jugador.getTipoDano(1);
					continue;
				}
				sleep(1000);
			}
			if (Jugador.getVida() <= 0){
				ScreenManager.showScreen("gameOver");
			}
			System.out.println("TimerEnemy Fuera");
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
