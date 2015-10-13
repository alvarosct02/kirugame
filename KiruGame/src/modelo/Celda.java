package modelo;

import controlador.AssetManager;

public class Celda {
	private int x;
	private int y;
	private char terreno;
	public char visibleChar;

	public boolean trigger = false;
	public boolean walkable = false;	
	
	public Celda(int y,int x,char terreno){
		this.x = x;
		this.y = y;
		this.terreno = terreno;
		this.visibleChar = terreno;
	}
	
	public char getValor() {		
		return visibleChar;
	}
	
	public void showTerreno() {		
		visibleChar = terreno;
	}

}