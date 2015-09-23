package Controlador;

import java.util.ArrayList;
import java.util.Scanner;

import Modelo.ITrigger;
import Modelo.Jugador;
import Vista.Renderizador;

public class AccionEspecial implements ITrigger{
	
	public int idAccion;
	private String sec;

	private Scanner sc = new Scanner(System.in);
	private boolean activa = true;
	
	private char sprite;
	
	private int tipo;
	private ArrayList<Integer> jugArray = new ArrayList<Integer>();
	private ArrayList<int[]> posArray = new ArrayList<int[]>();;
	private ArrayList<int[][]> cordArray = new ArrayList<int[][]>();;
	
	public AccionEspecial(char sprite,int cod,String sec, int tipo, int visible) {
		this.sprite = sprite;
		idAccion = cod;
		this.sec = sec;
		this.tipo = tipo;	
		this.activa = visible==1? true:false;	
	}	
	
	public void addPlayerAccion(int id, int x, int y, int[][] movInfo){
		
		jugArray.add(id);
		cordArray.add(movInfo);
		
		int[] tempPos = new int[2];
		tempPos[0] = x;
		tempPos[1] = y;
		posArray.add(tempPos);
		
		if (activa)
			GestorMapas.map.getCelda(x, y).visibleChar = sprite;		
	}
	
	private boolean secuencia(String cadena){
		String charPressed;
		int i;
		for(i=0; i<cadena.length(); i++){
			char car = cadena.charAt(i);
			Renderizador.requestChar(Character.toUpperCase(car));
			charPressed = sc.next();
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
	
	public int ejecutar() {
//		map.getCelda(8, 2).removeSprite();
//		map.getCelda(8, 2).trigger = false;	
		while(true){
			if (Jugador.getVida() <= 0) return -2;
			if (secuencia(sec)){
				break;
			} else {
				Renderizador.errorSecuencia(sec);
			}
		}
		sc.nextLine();	
		
		
		Jugador player;
		for (int j = 0; j<jugArray.size(); j++){
			GestorMapas.map.getCelda(posArray.get(j)[0],posArray.get(j)[1]).showTerreno();
		}
		for (int i = 0; i< cordArray.get(0).length; i++){
			for (int j = 0; j<jugArray.size(); j++){
				int[] vect = {cordArray.get(j)[i][0], cordArray.get(j)[i][1]};
				
				if (jugArray.get(j) == 1)
					player = Mapa.p1;
				else
					player = Mapa.p2;
				
				player.setXY(player.gridX + vect[0], player.gridY + vect[1]);
				
			}
			Renderizador.pressToMove(sprite);
			sc.nextLine();
			Renderizador.mostrarMapa();
			
		}
		
		activa = false;
		return idAccion;
		
	}
	
	public boolean check() {
		if (activa != true) return false;		
		Jugador player = null;
		boolean resp = true;
		for (int j = 0; j<jugArray.size(); j++){			
			if (jugArray.get(j) == 1)
				player = Mapa.p1;
			else
				player = Mapa.p2;
			
			resp &= player.isHere(posArray.get(j)[0], posArray.get(j)[1]);				
			
		}
		
		return resp;
	}

	public void activar() {
		activa = true;
		GestorMapas.map.getCelda(posArray.get(0)[0], posArray.get(0)[1]).visibleChar = sprite;	
		
	}
}