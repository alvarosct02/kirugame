package mapa;

import drawable.personaje.Jugador;
import game.Juego;


public class Mapa {

	private int gridSize = Juego.gridSize;
	private int gridWidth = Juego.gridWidth;
	private int gridHeight = Juego.gridHeight;
	
	private Celda[][] mapa;
	private char valor;
	
	private int posX_A = 0;
	private int posY_A = 0;

	private int posX_B = 0;
	private int posY_B = 0;
	
	public Mapa(char valores[][]){//Creando el mapa
		mapa = new Celda[gridHeight][gridWidth];		
		for (int i = 0; i<gridHeight; i++){
			for (int j = 0; j<gridWidth; j++){
				Celda celda = new Celda(i,j,valores[i][j]);
				if (valores[i][j] == 'A'){
					posX_A = j;
					posY_A = i;
				}
				if (valores[i][j] == 'B'){
					posX_B = j;
					posY_B = i;					
				}

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

	public int getPosX_A() {
		return posX_A;
	}

	public int getPosY_A() {
		return posY_A;
	}

	public int getPosX_B() {
		return posX_B;
	}

	public int getPosY_B() {
		return posY_B;
	}

	public void asignarPlayer(Jugador player, int posX, int posY) {
		mapa[posY][posX].asginarPlayer(player);
	}
	
	
}

