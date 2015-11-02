package modelo;

import java.awt.Point;
import java.util.ArrayList;

import actionscript3.Sprite;
import controlador.AssetManager;
import modelo.*;
import modelo.dataHolder.ObjetoData;
import vista.Juego;


public class Mapa extends Sprite {
	public static final int gridWidth = 16;
	public static final int gridHeight = 12;
	
	private Celda[][] mapa;
	private char valor;
	
	public static Jugador p1 = new Jugador();
	public static Jugador p2 = new Jugador();	

	public ArrayList<AccionEspecial> acciones= new ArrayList<AccionEspecial>();
	public ArrayList<Objeto> objetos= new ArrayList<Objeto>();
	public ArrayList<Enemigo> enemigos= new ArrayList<Enemigo>();
	
	 public Celda[][] getCeldaMatrix()
	 {
		 return this.mapa;
	 }
	 
	 public void setCeldaMatrix(Celda[][] mapa)
	 {
		 this.mapa = mapa;
	 }
	public  ArrayList<AccionEspecial> getAcciones()
	{
		return this.acciones;
	}
	
	public ArrayList<Objeto> getObjetos() 
	{
		return this.objetos;
	}

	
	public ArrayList<Enemigo> getEnemigos()
	{
		return this.enemigos;
	}
	
	public Mapa(char terreno[][]){//Creando el mapa
		mapa = new Celda[gridHeight][gridWidth];		
		for (int i = 0; i<gridHeight; i++){
			for (int j = 0; j<gridWidth; j++){
				Celda celda = new Celda(i,j,terreno[i][j]);				
				mapa[i][j] = celda;
			}		
		}
				
	}
	
	public void cargarFondo(int imgID){
		Sprite fondo = new Sprite();
		fondo.setImg(AssetManager.getImageByID(imgID));
//		fondo.x = posTerrenoA.x * Juego.GRIDSIZE;
//		fondo.y = posTerrenoA.y * Juego.GRIDSIZE;
		addChild(fondo);	
	}
	
	public void cargarTerreno(Point posTerreno, int imgID){		
		Sprite terreno = new Sprite();
		terreno.setImg(AssetManager.getImageByID(imgID));
		terreno.x = posTerreno.x * Juego.GRIDSIZE;
		terreno.y = posTerreno.y * Juego.GRIDSIZE;
		addChild(terreno);		
	}
	
	public Celda getCelda(int x, int y) {
		return mapa[y][x];		
	}	
	
	
	public char getCeldaValue(int x, int y) {
		if (x == p1.gridX && y == p1.gridY){
			return p1.caracter;
		}
		if (x == p2.gridX && y == p2.gridY){
			return p2.caracter;
		}
		return mapa[y][x].getValor();
	}

	public int ejecutarAccionEspecial() {
		for (AccionEspecial accion : acciones) {
			if (accion.check()){
				return accion.ejecutar();
			}			
		}
		return -1;		
	}

	public boolean checkEnemigos() {
		for (Enemigo enemigo : enemigos) {
			if (enemigo.check()){
				enemigo.ejecutar();
			}
		}
		return false;
	}

	public void addAccion(AccionEspecial accion) {
		acciones.add(accion);		
	}
	
	public void addObjeto(int id, int x, int y, int objetoID) {
		
		ObjetoData objData = AssetManager.getObjectByID(objetoID);			
		int tipo = objData.tipo;
		
		Objeto obj = null;
		switch (tipo) {
			case 0:		
				obj = new Obstaculo(id,x,y,objData);break;
			case 1:
				obj = new ObjetoApoyo(id,x,y,objData); break;
			default:
				System.out.println("Warning: Se ha instanciado un objeto tipo OBJECT");
				obj = new Objeto(id,x,y,objData);	break;
		}
		
		objetos.add(obj);
		
	}

	public void addEnemigo(Enemigo enemigo) {
		enemigos.add(enemigo);	
	}
	
	public Objeto getObjeto(int id) {
		for (Objeto obj : objetos) {
			if (obj.id == id)
				return obj;
		}
		return null;
	}

	public Enemigo getEnemigo(int id) {
		for (Enemigo enemigo : enemigos) {
			if (enemigo.id == id)
				return enemigo;
		}
		return null;
	}

	public void activarAccion(int id) {
		for (AccionEspecial accion : acciones) {
			if (accion.idAccion == id){
				accion.activar();
				return;
			}
		}		
	}

	public void update() {
		p1.sprite.x = p1.gridX * Juego.GRIDSIZE;
		p1.sprite.y = p1.gridY * Juego.GRIDSIZE;		

		p2.sprite.x = p2.gridX * Juego.GRIDSIZE;
		p2.sprite.y = p2.gridY * Juego.GRIDSIZE;
//		
	}

	
	
}

