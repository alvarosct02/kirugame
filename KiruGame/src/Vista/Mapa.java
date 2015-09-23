package Vista;

import Modelo.*;
import java.util.ArrayList;
import Controlador.Juego;


public class Mapa {

	private int gridSize = Juego.gridSize;
	private int gridWidth = Juego.gridWidth;
	private int gridHeight = Juego.gridHeight;
	
	private Celda[][] mapa;
	private char valor;
	
	public Jugador p1 = Juego.p1;
	public Jugador p2 = Juego.p2;	

	private ArrayList<AccionEspecial> acciones= new ArrayList<AccionEspecial>();
	private ArrayList<Objeto> objetos= new ArrayList<Objeto>();
	private ArrayList<Enemigo> enemigos= new ArrayList<Enemigo>();
	
	public Mapa(char terreno[][]){//Creando el mapa
		mapa = new Celda[gridHeight][gridWidth];		
		for (int i = 0; i<gridHeight; i++){
			for (int j = 0; j<gridWidth; j++){
				Celda celda = new Celda(i,j,terreno[i][j]);

				mapa[i][j] = celda;
			}			
		}
	}
	
	public Celda getCelda(int x, int y) {
		return mapa[y][x];		
	}	
	
	
	public char getCeldaValue(int x, int y) {
		if (x == p1.gridX && y == p1.gridY){
			return p1.sprite;
		}
		if (x == p2.gridX && y == p2.gridY){
			return p2.sprite;
		}
		return mapa[y][x].getValor();
	}

	public int ejecutarAccionEspecial() {
		Jugador player = null;
		for (AccionEspecial accion : acciones) {
			if (accion.check()){
				accion.ejecutar();
				return accion.idAccion;
			}			
		}
		return -1;
		
	}

	public void addAccion(AccionEspecial accion) {
		acciones.add(accion);		
	}
	
	public void addObjeto(Objeto obj) {
		objetos.add(obj);		
	}
	
	public Objeto getObjeto(int id) {
		for (Objeto obj : objetos) {
			if (obj.id == id)
				return obj;
		}
		return null;
	}
	
	
}

