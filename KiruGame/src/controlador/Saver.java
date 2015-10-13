package controlador;
import modelo.Jugador;
import modelo.Mapa;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import  javax.swing.JFileChooser ;
import modelo.Objeto;
import modelo.AccionEspecial;
import modelo.Celda;
import modelo.Enemigo;

import com.thoughtworks.xstream.*;
import java.io.FileWriter;
import java.awt.Point;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import controlador.GestorMapas;
import vista.Juego;
import vista.screen.ScreenManager;

class RawEnemigo{
	public boolean active;
	
	public RawEnemigo(boolean active){
		this.active = active;
	}
}

class RawAccion{
	public boolean active;
	
	public RawAccion(boolean active){
		this.active = active;
	}
}

class RawObjeto{
	public boolean active;
	
	public RawObjeto(boolean active){
		this.active = active;
	}
}

class RawJugador{
	public String nombre;
	public int x;
	public int y;
	public boolean blooding;
	public RawJugador(String nombre, int x, int y, boolean blooding){
		this.nombre = nombre;
		this.x = x;
		this.y = y;
		this.blooding = blooding;
	}
}

class RawGame{
	public int vida;
	public int nivelActual;
	
	public RawGame(int vida, int nivelActual){
		this.vida = vida;
		this.nivelActual = nivelActual;
	}
}



public class Saver {
	
	public RawGame game = null;
	public RawJugador p1 = null;
	public RawJugador p2 = null;

	public ArrayList<RawObjeto> objetos = null;
	public ArrayList<RawEnemigo> enemigos = null;
	public ArrayList<RawAccion> acciones = null;
	
	public Saver()
	{
		
		
	}
	
	private void updateData(){
		game = new RawGame(Juego.cantNivel, Juego.currentLevel);
		p1 = new RawJugador(Mapa.p1.getNombre(), Mapa.p1.gridX, Mapa.p1.gridY, Mapa.p1.blooding);
		p2 = new RawJugador(Mapa.p2.getNombre(), Mapa.p2.gridX, Mapa.p2.gridY, Mapa.p2.blooding);
		
		acciones = new ArrayList<RawAccion>();
		for (AccionEspecial accion : GestorMapas.map.getAcciones()){
			acciones.add(new RawAccion(accion.isActive()));
		}
		enemigos = new ArrayList<RawEnemigo>();
		for (Enemigo enemigo : GestorMapas.map.getEnemigos()){
			enemigos.add(new RawEnemigo(enemigo.isActive()));
		}
		objetos = new ArrayList<RawObjeto>();
		for (Objeto objeto : GestorMapas.map.getObjetos()){
			objetos.add(new RawObjeto(objeto.isActive()));
		}
	}
	
	public void guardar()
	{
		updateData();		
		try {
			XStream xs = new XStream();
			
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss");
			Date today = Calendar.getInstance().getTime();        
			String uniqueName = df.format(today);
			
			FileWriter fw = new FileWriter(".\\save\\save-"+uniqueName+".xml");
			fw.write(xs.toXML(this));
			fw.close();
     
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		  
	}
	
	public static void cargar(String nombreArchivo)	{
		try {
			XStream xs = new XStream();
//			xs.alias("controlador.Mapa", Mapa.class);
			FileReader fr = new FileReader(nombreArchivo);
			Saver loadGame = (Saver)xs.fromXML(fr);			  
			fr.close();
    
	        Juego.currentLevel = loadGame.game.nivelActual;	        
			ScreenManager.showScreen("game");
			loadData(loadGame);
			
    
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
	
	private static void loadData(Saver loadGame){
		Jugador.setVida(loadGame.game.vida);
		
		Mapa.p1.setNombre(loadGame.p1.nombre);
		Mapa.p1.setXY(loadGame.p1.x, loadGame.p1.y);
		Mapa.p1.blooding = loadGame.p1.blooding;
		
		Mapa.p2.setNombre(loadGame.p2.nombre);
		Mapa.p2.setXY(loadGame.p2.x, loadGame.p2.y);
		Mapa.p2.blooding = loadGame.p2.blooding;
		
		for (int i=0; i<GestorMapas.map.getAcciones().size(); i++){
			if (loadGame.acciones.get(i).active) GestorMapas.map.getAcciones().get(i).activar();
			else GestorMapas.map.getAcciones().get(i).hideAction();
		}
		
		for (int i=0; i<GestorMapas.map.getEnemigos().size(); i++){
			if (loadGame.enemigos.get(i).active) GestorMapas.map.getEnemigos().get(i).addToMap();
			else GestorMapas.map.getEnemigos().get(i).removeFromMap();
		}
		
		for (int i=0; i<GestorMapas.map.getObjetos().size(); i++){
			if (loadGame.objetos.get(i).active) GestorMapas.map.getObjetos().get(i).addToMap();
			else GestorMapas.map.getObjetos().get(i).removeFromMap();
		}
	}

}
