package Modelo;

import Controlador.GestorMapas;

public class Jugador extends Personaje {
	private static int vida = 10;	
	private String nombre;
	public boolean blooding = false;
	public String dir;
	public String getNombre() {
		return nombre;
	}

	public static void resetVida(){
		vida = 10;
	}
	
	private String input;
	private char terreno;

	public Jugador(){
		super(0,0,1,1,'X');
	}

	public void addData(String nombre, String input, int alto,int ancho, char sprite, char terreno) {
		// TODO Auto-generated method stub
		this.gridW = ancho;
		this.gridH = alto;
		this.sprite = sprite;
		this. terreno = terreno;		
		this.nombre = nombre;
		this.input = input;		
	}
	
	public int moverDir(String cmd){
		int error = 0;
		if (cmd.charAt(0) == input.charAt(3)){
			error = moverXY(gridX+1,gridY);
			dir = "la derecha";			
		} else if (cmd.charAt(0) == input.charAt(0)){
			error = moverXY(gridX,gridY-1);
			dir = "arriba";			
		} else if (cmd.charAt(0) == input.charAt(1)){
			error = moverXY(gridX-1,gridY);
			dir = "la izquierda";				
		} else if (cmd.charAt(0) == input.charAt(2)){
			error = moverXY(gridX,gridY+1);
			dir = "abajo";
		}		
		return error;
	}
	
	private int moverXY(int x, int y){
		if(
			isValid(x,y) == 1 && 
			((GestorMapas.map.getCeldaValue(x, y) == terreno || GestorMapas.map.getCeldaValue(x,y) == 'D' || GestorMapas.map.getCeldaValue(x,y) == 'C')
			|| (GestorMapas.map.getCeldaValue(x,y) == 'o' && GestorMapas.map.getCelda(x,y).walkable == true))
		){
			if (blooding) getTipoDano(1);
			setXY(x,y);
			return 0 ;
		}else 		
			return 1;
	}
	
	public static int getVida() {
		return Jugador.vida;		
	}
	
	public boolean isHere(int x, int y){
		return (x == gridX && y == gridY);
	}

	private static void reduceVida(int vida) {
		Jugador.vida -= vida;
	}
	
	public static void getTipoDano(int tipo){
		
		switch(tipo){
			case 1: // enemigos
				Jugador.reduceVida(1);
				break;
			case 2:// fallar comando
				Jugador.reduceVida(2);
				break;
		}
	}

}
