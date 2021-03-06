package controlador;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Scanner;

import actionscript3.SpriteAS3;
import modelo.ITrigger;
import modelo.ImageData;
import modelo.Jugador;
import modelo.Mapa;
import vista.AssetManager;
import vista.Juego;
import vista.Renderizador;
import vista.screen.PopupAction;
import vista.screen.ScreenManager;

public class AccionEspecial implements ITrigger{
	
	public int idAccion;
	private String sec;

	public String getSec() {
		return sec;
	}

	private Scanner sc = new Scanner(System.in);
	private boolean activa = true;
	
	public boolean isActiva() {
		return activa;
	}

	private char caracter;
	public BufferedImage img = null;
	private int tipo;
	public ArrayList<Integer> jugArray = new ArrayList<Integer>();
	private ArrayList<int[]> posArray = new ArrayList<int[]>();;
	public ArrayList<int[][]> cordArray = new ArrayList<int[][]>();
	private ArrayList<SpriteAS3> spriteArr = new ArrayList<SpriteAS3>();
	
	public AccionEspecial(char car,int cod,String sec, int tipo, int visible) {
		this.caracter = car;
		idAccion = cod;
		this.sec = sec;
		this.tipo = tipo;	
		this.activa = visible==1? true:false;
		img = AssetManager.getImage("action" + this.tipo);
//		SpriteAS3 sprite
		
//		if (activa){
//			ScreenManager.getCurrentScreen().addChild(child);
//		}
	}	
	
	public void addPlayerAccion(int id, int x, int y, int[][] movInfo){
		
		SpriteAS3 sprite = new SpriteAS3();
		sprite.setImg(img);
		sprite.x = x * Juego.GRIDSIZE;
		sprite.y = y * Juego.GRIDSIZE;
		
		spriteArr.add(sprite);
		
		jugArray.add(id);
		cordArray.add(movInfo);
		
		int[] tempPos = new int[2];
		tempPos[0] = x;
		tempPos[1] = y;
		posArray.add(tempPos);
		
		if (activa){
			showAction();
		}
					
	}
	
	public void showAction(){
		
		System.out.println("SHOW ACTION");
		for (int i = 0; i< jugArray.size(); i++){
			int[] point = posArray.get(i);			
			GestorMapas.map.getCelda(point[0], point[1]).visibleChar = caracter;
			GestorMapas.map.addChild(spriteArr.get(i));
		}
	}
	
	public void hideAction(){
		activa = false;
		for (int i = 0; i< jugArray.size(); i++){
			int[] point = posArray.get(i);			
			GestorMapas.map.getCelda(point[0], point[1]).showTerreno();
			GestorMapas.map.removeChild(spriteArr.get(i));
		}		
	}
	
	public int ejecutar() {		
		ScreenManager.showPopup("action");
		((PopupAction)ScreenManager.getCurrentPopup()).definirAccion(this);				
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
		showAction();
		
	}
}