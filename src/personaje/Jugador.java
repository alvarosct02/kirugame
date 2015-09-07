package personaje;

import game.Renderizador;

public class Jugador extends Personaje {
	private static int vida = 10;	
	private String nombre;
	private String input;

	public Jugador(String nombre, String input){
		super(0,0);
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
		
		return 0;
	}
	
	public int getVida() {
		return Jugador.vida;
		
	}

	public void reduceVida(int tipo) {
		Jugador.vida -= vida;
	}

}
