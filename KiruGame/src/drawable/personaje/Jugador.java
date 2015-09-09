package drawable.personaje;

import mapa.GestorMapas;
import game.Renderizador;

public class Jugador extends Personaje {
	private static int vida = 10;	
	private String nombre;
	public String getNombre() {
		return nombre;
	}

	public static void resetVida(){
		vida = 10;
	}
	
	private String input;
	private char terreno;

	public Jugador(String nombre, String input, int alto,int ancho, char sprite, char terreno){
		super(0,0,alto,ancho,sprite);
		tipo = 1;
		this. terreno = terreno;		
		this.nombre = nombre;
		this.input = input;		
	}
	
	public int moverDir(String cmd){
		int error = 0;
		String dir = "";
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
		
		
		if (error==1){
			Renderizador.logNoMover();	
		} else {
			Renderizador.logMover(nombre, dir);
		}
		
		return 1;
	}
	
	public int moverXY(int x, int y){
		if(
			isValid(x,y) == 1 && 
			((GestorMapas.map.getCeldaValue(y, x) == terreno || GestorMapas.map.getCeldaValue(y, x) == 'D' || GestorMapas.map.getCeldaValue(y, x) == 'C')
			|| (GestorMapas.map.getCeldaValue(y,x) == 'o' && GestorMapas.map.isWalkable(x,y) == true))
		){
			setXY(x,y);
			return 0 ;
		}else 		
			return 1;
	}
	
	public static int getVida() {
		return Jugador.vida;
		
	}

	private void reduceVida(int vida) {
		Jugador.vida -= vida;
	}
	
	public void getTipoDano(int tipo){
		
		switch(tipo){
			case 1: // enemigos
				this.reduceVida(1);
				break;
			case 2:// fallar comando
				this.reduceVida(2);
				break;
		}
	}

}
