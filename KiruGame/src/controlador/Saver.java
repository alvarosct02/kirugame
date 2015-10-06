package controlador;
import modelo.Jugador;
import  javax.swing.JFileChooser ;
import modelo.Objeto;

import com.thoughtworks.xstream.*;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import controlador.Mapa;
import controlador.GestorMapas;
import vista.Juego;
public class Saver {
	
	public int currentLevel = 0;		
	public int cantNivel = 2;
	
	public Jugador p1;
	public Jugador p2;
	
	public ArrayList<AccionEspecial> acciones= new ArrayList<AccionEspecial>();
	public ArrayList<Objeto> objetos= new ArrayList<Objeto>();
	public ArrayList<Enemigo> enemigos= new ArrayList<Enemigo>();
	public int  vida;
	public int token;
	public Saver()
	{
		
		
	}
	
	public void guardar()
	{
		this.currentLevel = Juego.currentLevel;
		this.cantNivel    = Juego.cantNivel;
		this.p1           = Mapa.p1;
		this.p2           = Mapa.p2;
		this.acciones     = GestorMapas.map.getAcciones();
		this.objetos      = GestorMapas.map.getObjetos();
		this.enemigos     = GestorMapas.map.getEnemigos();
		this.token        = 1;
		this.vida         = GestorMapas.map.p1.getVida();
		try {XStream xs = new XStream();
          // 1. Escribir el archivoFileWriter 
          FileWriter fw = new FileWriter("save1.xml");
          fw.write(xs.toXML(this));
          fw.close();
         
		  } catch (IOException e) {
         System.out.println(e.toString());
      		}
		  
	}
	
	public static void cargar(String data)
	{
		 try {XStream xs = new XStream();
         
		 FileReader fr = new FileReader(data);
	        Saver newsaver = (Saver)xs.fromXML(fr);
	        
	        fr.close();
	        Mapa.p1 = newsaver.p1;
	        Mapa.p2 = newsaver.p2;
	        Juego.currentLevel = newsaver.currentLevel;
			
			GestorMapas.map.setAcciones(newsaver.acciones);
			GestorMapas.map.setObjetos(newsaver.objetos);
			GestorMapas.map.setEnemigos(newsaver.enemigos);
			
			GestorMapas.map.p1.setVida(newsaver.vida);
	        
	        
		  } catch (IOException e) {
        System.out.println(e.toString());
     		}
		
		
	}

}
