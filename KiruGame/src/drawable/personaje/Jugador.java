package drawable.personaje;

import game.Renderizador;

public class Jugador extends Personaje {
	private static int vida = 10;	
	private String nombre;
	private String input;

	public Jugador(String nombre, String input, int alto,int ancho, char sprite){
		super(0,0,alto,ancho,sprite);
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
			Renderizador.log("No puedes moverte en esta direccion");	
		} else {
			Renderizador.logMover(nombre, dir);
		}
		
		return 1;
	}
	
	public int moverXY(int x, int y){
		if(setPos(x,y) == 1){
			return 0;
		}else 
			return 1 ;
		
	}
	
	public int getVida() {
		return Jugador.vida;
		
	}

	public void reduceVida(int vida) {
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
