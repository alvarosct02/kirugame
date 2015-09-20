package Modelo;

import Controlador.Juego;
import Vista.GestorMapas;
import Vista.Renderizador;

public class AccionEspecial extends Objeto{
	
	private int codigo;
	private String sec;
	private int[][] cord;
	
	public AccionEspecial(int posX, int posY, char sprite,int cod,String sec, int[][] cord) {
		super(posX, posY,1,1, sprite);
		codigo = cod;
		this.sec = sec;
		this.cord = cord;		
		tipo = 10;
		GestorMapas.map.getCelda(posX, posY).visibleChar = sprite;
	}	
	
	private boolean secuencia(String cadena){
		String charPressed;
		int i;
		for(i=0; i<cadena.length(); i++){
			char car = cadena.charAt(i);
			Renderizador.requestChar(Character.toUpperCase(car));
			charPressed = Juego.sc.next();
//			Si se equivoca, break!
			if (Character.toUpperCase(charPressed.charAt(0)) != car) break;
		}
//		Si no completo con exito la secuencia
		if (i != cadena.length()){
			Jugador.getTipoDano(2);
			return false;
		} else {			
			return true;
		}
	}

	public void ejecutar(Jugador player) {
//		map.getCelda(8, 2).removeSprite();
//		map.getCelda(8, 2).trigger = false;	
		while(true){
			if (Jugador.getVida() <= 0) return;
			Renderizador.requestSecuencia(sec);
			if (secuencia(sec)){
				break;
			} else {
				Renderizador.errorSecuencia(sec);
			}
		}
		Juego.sc.nextLine();	
		
		GestorMapas.map.getCelda(gridX,gridY).visibleChar = GestorMapas.map.getCelda(gridX,gridY).getTerreno();
		
		for (int i = 0; i<cord.length; i++){
			int[] vect = getDirVector(cord[i][0], cord[i][1]);
			player.setXY(player.gridX + vect[0], player.gridY + vect[1]);
			Renderizador.pressToMove(sprite);
			Juego.sc.nextLine();
			Renderizador.mostrarMapa();
		}
		
	}
	
	private int[] getDirVector(int dir, int dist){
		int[] vector = {0,0};
		switch (0) {
		case 0: vector[0] = 1; break;
		case 1: vector[0] = -1; break;
		case 2: vector[0] = -1; break;
		case 3: vector[0] = 1; break;		
		default:
			break;
		}
		vector[0] *= dist;
		vector[1] *= dist;
		return vector;
	}
}