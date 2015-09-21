package Modelo;

import java.util.ArrayList;

import Controlador.Juego;
import Vista.GestorMapas;
import Vista.Renderizador;

public class AccionEspecial{
	
	private int codigo;
	private String sec;
	
	private boolean activa = true;
	
	private char sprite;
	
	private int tipo;
	private ArrayList<Integer> jugArray = new ArrayList<Integer>();
	private ArrayList<int[]> posArray = new ArrayList<int[]>();;
	private ArrayList<int[][]> cordArray = new ArrayList<int[][]>();;
	
	public AccionEspecial(char sprite,int cod,String sec, int tipo) {
		this.sprite = sprite;
		codigo = cod;
		this.sec = sec;
		this.tipo = tipo;		
	}	
	
	public void addPlayerAccion(int id, int x, int y, int[][] movInfo){
		
		jugArray.add(id);
		cordArray.add(movInfo);
		
		int[] tempPos = new int[2];
		tempPos[0] = x;
		tempPos[1] = y;
		posArray.add(tempPos);
		
		GestorMapas.map.getCelda(x, y).visibleChar = sprite;		
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

	public void ejecutar() {
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
		
		
		Jugador player;
		for (int j = 0; j<jugArray.size(); j++){
			char tmp = GestorMapas.map.getCelda(posArray.get(j)[0],posArray.get(j)[1]).getTerreno();
			GestorMapas.map.getCelda(posArray.get(j)[0],posArray.get(j)[1]).visibleChar = tmp;
		}
		for (int i = 0; i< cordArray.get(0).length; i++){

			for (int j = 0; j<jugArray.size(); j++){
				int[] vect = getDirVector(cordArray.get(j)[i][0], cordArray.get(j)[i][1]);
				
				if (jugArray.get(j) == 1)
					player = Juego.p1;
				else
					player = Juego.p2;
				
				player.setXY(player.gridX + vect[0], player.gridY + vect[1]);
				Renderizador.pressToMove(sprite);
				Juego.sc.nextLine();
				Renderizador.mostrarMapa();
			}
			
		}
		
		activa = false;
		
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

	public boolean check() {
		if (activa != true) return false;
		
		Jugador player = null;
		boolean resp = true;
		for (int j = 0; j<jugArray.size(); j++){			
			if (jugArray.get(j) == 1)
				player = Juego.p1;
			else
				player = Juego.p2;
			
			resp &= player.isHere(posArray.get(j)[0], posArray.get(j)[1]);				
			
		}
		
		return resp;
	}
}