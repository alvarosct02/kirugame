package mapa;
import java.lang.reflect.Array;

import game.Juego;

public class Mapa {
	private int gridSize = Juego.gridSize;
	private int gridWidth = Juego.gridWidth;
	private int gridHeight = Juego.gridHeight;
	
	private Celda[][] mapa;
	
	public Mapa(){		
		mapa = new Celda[gridHeight][gridWidth];		
		for (int i = 0; i<gridHeight; i++){
			for (int j = 0; j<gridWidth; j++){
				Celda celda = new Celda(i,j,'A');
				mapa[i][j] = celda;
			}
		}
	}

//	public Celda getCelda(int i, int j) {
//		return mapa[i][j];
//	}
	
	public char getCeldaValue(int i, int j) {
		return mapa[i][j].getValor();
	}

	public void cargarNivel(int i) {
		// TODO Auto-generated method stub
		
	}
	
	
}

