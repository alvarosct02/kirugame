package mapa;

import drawable.personaje.Jugador;
import game.Juego;


public class Mapa {

	private int gridSize = Juego.gridSize;
	private int gridWidth = Juego.gridWidth;
	private int gridHeight = Juego.gridHeight;
	
	private Celda[][] mapa;
	private char valor;
	
	public Jugador p1 = Juego.p1;
	public Jugador p2 = Juego.p2;
	
	
	
	public Mapa(char valores[][]){//Creando el mapa
		mapa = new Celda[gridHeight][gridWidth];		
		for (int i = 0; i<gridHeight; i++){
			for (int j = 0; j<gridWidth; j++){
				Celda celda = new Celda(i,j,valores[i][j]);
				if (valores[i][j] == 'A'){
					p1.setPos(j, i);
				}
				if (valores[i][j] == 'B'){
					p2.setPos(j, i);	
				}
				mapa[i][j] = celda;
			}
			
		}
	}

//	public Celda getCelda(int i, int j) {
//		return mapa[i][j];
//	}
		
	public char getCeldaValue(int i, int j) {
		if (j == p1.gridX && i == p1.gridY){
			return p1.sprite;
		}
		if (j == p2.gridX && i == p2.gridY){
			return p2.sprite;
		}
		return mapa[i][j].getValor();
	}

	public void cargarNivel(int i) {
		// TODO Auto-generated method stub
		
	}

	public void asignarPlayer(Jugador player, int posX, int posY) {
		mapa[posY][posX].asginarPlayer(player);
	}
	
	
}

