package modelo;

import java.awt.Point;
import java.util.ArrayList;

import actionscript3.SpriteAS3;
import controlador.AccionEspecial;
import controlador.Enemigo;
import modelo.*;
import vista.AssetManager;
import vista.Juego;


public class Mapa extends SpriteAS3 {
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
	
	public void setEnemigos(ArrayList<Enemigo> lista)
	{
		for (int i= 0; i<lista.size(); i++){
			if (lista.get(i).isActiva() && enemigos.get(i).isActiva()){
//				Nada
			} else if (!lista.get(i).isActiva() && !enemigos.get(i).isActiva()){
//				Nada
			} else if (lista.get(i).isActiva() && !enemigos.get(i).isActiva()){
				enemigos.get(i).agregarMapa();
			} else if (!lista.get(i).isActiva() && enemigos.get(i).isActiva()){
				enemigos.get(i).quitarMapa();
			}
			
			enemigos.get(i).setActivable(lista.get(i).isActivable());
		}
	}
	
	public  void setAcciones(ArrayList<AccionEspecial> lista)
	{
		for (int i= 0; i<lista.size(); i++){
			if (lista.get(i).isActiva() && acciones.get(i).isActiva()){
//				Nada
			} else if (!lista.get(i).isActiva() && !acciones.get(i).isActiva()){
//				Nada
			} else if (lista.get(i).isActiva() && !acciones.get(i).isActiva()){
				acciones.get(i).activar();
			} else if (!lista.get(i).isActiva() && acciones.get(i).isActiva()){
				acciones.get(i).hideAction();
			}
		}
	}
	
	public void setObjetos(ArrayList<Objeto> lista) 
	{
		for (int i= 0; i<lista.size(); i++){
			if (lista.get(i).isActiva() && objetos.get(i).isActiva()){
		//			Nada
			} else if (!lista.get(i).isActiva() && !objetos.get(i).isActiva()){
		//			Nada
			} else if (lista.get(i).isActiva() && !objetos.get(i).isActiva()){
				objetos.get(i).agregarMapa();
			} else if (!lista.get(i).isActiva() && objetos.get(i).isActiva()){
				objetos.get(i).quitarMapa();
		}
	}
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
	
	public void cargarTerreno(Point posTerrenoA, Point posTerrenoB){
		
		String imgName = "";
		SpriteAS3 fondo = new SpriteAS3();
		imgName = "bg" + (Juego.currentLevel+1);
		fondo.setImg(AssetManager.getImage(imgName));
//		fondo.x = posTerrenoA.x * Juego.GRIDSIZE;
//		fondo.y = posTerrenoA.y * Juego.GRIDSIZE;
		addChild(fondo);	
		
		SpriteAS3 terrenoA = new SpriteAS3();
		imgName = "terreno" + (Juego.currentLevel+1) + "A";
		terrenoA.setImg(AssetManager.getImage(imgName));
		terrenoA.x = posTerrenoA.x * Juego.GRIDSIZE;
		terrenoA.y = posTerrenoA.y * Juego.GRIDSIZE;
		addChild(terrenoA);		

		SpriteAS3 terrenoB = new SpriteAS3();
		imgName = "terreno" + (Juego.currentLevel+1) + "B";
		terrenoB.setImg(AssetManager.getImage(imgName));
		terrenoB.x = posTerrenoB.x * Juego.GRIDSIZE;
		terrenoB.y = posTerrenoB.y * Juego.GRIDSIZE;
		addChild(terrenoB);
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
	
	public void addObjeto(Objeto obj) {
		objetos.add(obj);
//		addChild(obj.sprite);
		
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
			}
		}		
	}

	public void update() {
		p1.mc.x = p1.gridX * Juego.GRIDSIZE;
		p1.mc.y = p1.gridY * Juego.GRIDSIZE;		

		p2.mc.x = p2.gridX * Juego.GRIDSIZE;
		p2.mc.y = p2.gridY * Juego.GRIDSIZE;
//		
	}

	
	
}

