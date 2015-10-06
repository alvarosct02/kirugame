package controlador;
import modelo.Jugador;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import  javax.swing.JFileChooser ;
import modelo.Objeto;
import modelo.Celda;
import com.thoughtworks.xstream.*;
import java.io.FileWriter;
import java.awt.Point;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import controlador.GestorMapas;
import vista.Juego;
import vista.screen.ScreenManager;
public class Saver {
	
	public int currentLevel = 0;		
	public int cantNivel = 2;
	
	public Point p1;
	public Point p2;
	
	public ArrayList<AccionEspecial> acciones= new ArrayList<AccionEspecial>();
	public ArrayList<Objeto> objetos= new ArrayList<Objeto>();
	public ArrayList<Enemigo> enemigos= new ArrayList<Enemigo>();
	public int  vida;
	
	public Celda mapCelda[][];
	public Saver()
	{
		
		
	}
	
	public void guardar()
	{
		this.currentLevel = Juego.currentLevel;
		this.cantNivel    = Juego.cantNivel;
		this.p1           = new Point(Mapa.p1.gridX,Mapa.p1.gridY);
		this.p2           = new Point(Mapa.p2.gridX,Mapa.p2.gridY);
		this.acciones     = GestorMapas.map.getAcciones();
//		this.objetos      = GestorMapas.map.getObjetos();
//		this.enemigos     = GestorMapas.map.getEnemigos();
		
		this.vida         = GestorMapas.map.p1.getVida();
		this.mapCelda     = GestorMapas.map.getCeldaMatrix();
		try {XStream xs = new XStream();
          // 1. Escribir el archivoFileWriter 
		DateFormat df = new SimpleDateFormat("MM-dd-yyyy-hh-mm-ss");

		// Get the date today using Calendar object.
		Date today = Calendar.getInstance().getTime();        
		// Using DateFormat format method we can create a string 
		// representation of a date with the defined format.
		String reportDate = df.format(today);

		// Print what date is today!
		
		
          FileWriter fw = new FileWriter(".\\save\\save-"+reportDate+".xml");
          fw.write(xs.toXML(this));
          fw.close();
         
		  } catch (IOException e) {
         System.out.println(e.toString());
      		}
		  
	}
	
	public static void cargar(String data)
	{
		 try {XStream xs = new XStream();
		 xs.alias("controlador.Mapa", Mapa.class);
		 FileReader fr = new FileReader(data);
	        Saver newsaver = (Saver)xs.fromXML(fr);
	        
	        fr.close();
	        
			
			
	        //GestorMapas.cargarNivel(newsaver.currentLevel);
	        
			

	        Juego.currentLevel = newsaver.currentLevel;
	        
			ScreenManager.showScreen("game");
			GestorMapas.map.setCeldaMatrix(newsaver.mapCelda);
	        GestorMapas.map.setAcciones(newsaver.acciones);
			GestorMapas.map.setObjetos(newsaver.objetos);
//			GestorMapas.map.setEnemigos(newsaver.enemigos);
			Mapa.p1.setXY(newsaver.p1.x, newsaver.p1.y);
	        Mapa.p2.setXY(newsaver.p2.x, newsaver.p2.y);	        
			Jugador.setVida(newsaver.vida);
	        
		  } catch (IOException e) {
        System.out.println(e.toString());
     		}
		
		
	}

}
