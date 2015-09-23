package Controlador;

import Modelo.*;

import java.util.ArrayList;


public class Mapa {

	public static final int gridSize = 64;
	public static final int gridWidth = 16;
	public static final int gridHeight = 12;
	
	private Celda[][] mapa;
	private char valor;
	
	public static Jugador p1 = new Jugador();
	public static Jugador p2 = new Jugador();	

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
		for (AccionEspecial accion : acciones) {
			if (accion.check()){
				return accion.ejecutar();
			}			
		}
		return -1;		
	}

	public boolean checkEnemigos() {
		for (Enemigo enemigo : enemigos) {
			if (enemigo.check()){
				enemigo.ejecutar();
			}			
		}
		return false;
	}

	public void addAccion(AccionEspecial accion) {
		acciones.add(accion);		
	}
	
	public void addObjeto(Objeto obj) {
		objetos.add(obj);		
	}

	public void addEnemigo(Enemigo enemigo) {
		enemigos.add(enemigo);	
	}
	
	public Objeto getObjeto(int id) {
		for (Objeto obj : objetos) {
			if (obj.id == id)
				return obj;
		}
		return null;
	}

	public Enemigo getEnemigo(int id) {
		for (Enemigo enemigo : enemigos) {
			if (enemigo.id == id)
				return enemigo;
		}
		return null;
	}

	public void activarAccion(int id) {
		for (AccionEspecial accion : acciones) {
			if (accion.idAccion == id){
				accion.activar();
			}
		}		
	}
	
	
}

