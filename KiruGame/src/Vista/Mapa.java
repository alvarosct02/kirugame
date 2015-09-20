package Vista;

import Modelo.AccionEspecial;
import Modelo.Jugador;

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

	public void ejecutarAccionEspecial() {
		Jugador player = null;
		for (AccionEspecial accion : acciones) {
			if (p1.isHere(accion.gridX, accion.gridY)){
				player = p1;
			}
			if (p2.isHere(accion.gridX, accion.gridY)){
				player = p2;
			}
			
			if (player != null){
				accion.ejecutar(player);
				break;
			}			
		}
		
	}

	public void addAccion(AccionEspecial accion) {
		acciones.add(accion);
		
	}
	
	
}

