package modelo;

import java.nio.file.Watchable;

import actionscript3.MovieClip;
import controlador.GestorMapas;

public class Jugador extends Drawable {
	private static int vida = 10;	
	private String nombre;
	public boolean blooding = false;
	public int xDir;
	public int yDir;
	public float xDesp;;
	public float yDesp;
	public int dir;
	public char dirChar = 'R';
	public boolean moving = false;
	private int step = 0;
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public static void resetVida(){
		vida = 10;
	}
	
	private String input;
	private char terreno;
	
	public void setAnimInit(String anim){
		((MovieClip) sprite).setScene(anim);
	}

	public Jugador(){
		super(1,0,0,1,1,'@');
		sprite = new MovieClip();
//		this.sprite = 'X';
	}

	public void addData(String nombre, String input, int alto,int ancho, char caracter, char terreno) {
		// TODO Auto-generated method stub
		this.gridW = ancho;
		this.gridH = alto;
		this.caracter = caracter;
		this. terreno = terreno;		
		this.nombre = nombre;
		this.input = input;		
	}
	
	public void setDir(char cmd){
		cmd = Character.toUpperCase(cmd);
		if (cmd == input.charAt(3)){			
			dir = 0;
		} else if (cmd == input.charAt(0)){
			dir = 1;
		} else if (cmd == input.charAt(1)){
			dir = 2;
		} else if (cmd == input.charAt(2)){
			dir = 3;
		}
		moving = true;	
	}
	
	public void setDirXY(){	
		switch (dir) {
			case 0: xDir = 1; yDir = 0; break;
			case 1: xDir = 0; yDir =-1; break;
			case 2: xDir = -1; yDir = 0; break;
			case 3: xDir = 0; yDir = 1; break;
			default: break;
		}
	}
	
	public void setAnim(){
		switch (dir) {
			case 0: dirChar = 'R'; setWalk(); break;
			case 1: setWalk(); break;
			case 2: dirChar = 'L'; setWalk(); break;
			case 3: setWalk(); break;
			default: break;
		}
	}
	
	public void moverDir(){
		if (step==0 && !moving) return;
		if  (step == 0 && moving){
			setDirXY();
			setAnim();
			boolean resp = moverXY(gridX + xDir, gridY + yDir);
			if (!resp) return;
		}
		step ++;
		if (step == 12){
			setXY(gridX + xDir, gridY + yDir);
			step = 0;	
		}
		xDesp = xDir * (64/12) * (step+1);
		yDesp = yDir * (64/12) * (step+1);
		
	}
	
	public void move(){
		
	}
	
	private boolean moverXY(int x, int y){
//		boolean aux = GestorMapas.map.getCeldaValue(x,y) == 'o';
//		boolean aux1 = GestorMapas.map.getCelda(x,y).walkable == true;
//		
		if(
			isValid(x,y) == 1 && 
			((GestorMapas.map.getCeldaValue(x, y) == terreno || GestorMapas.map.getCeldaValue(x,y) == 'D' || GestorMapas.map.getCeldaValue(x,y) == 'C')
			|| (GestorMapas.map.getCeldaValue(x,y) == 'o' && GestorMapas.map.getCelda(x,y).walkable == true))
		){
//			if (blooding) getTipoDano(1);
//			setXY(x,y);
			return true ;
		}else 		
			return false;
	}
	
	public void setIdle(){
		moving = false;
		((MovieClip) sprite).setScene("idle_" + dirChar);
		
	}
	
	public void setWalk(){
		((MovieClip) sprite).setScene("walking_" + dirChar);
	}
	
	public static int getVida() {
		return Jugador.vida;		
	}
	public static void setVida(int vida)
	{
		Jugador.vida = vida; 
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
