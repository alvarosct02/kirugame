package vista;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modelo.EnemigoData;
import modelo.ImageData;
import modelo.Objeto;
import modelo.ObjetoData;

public class AssetManager {
	
	public static ArrayList<ImageData> imageList = new ArrayList<ImageData>();	
	public static ArrayList<ObjetoData> objectList = new ArrayList<ObjetoData>();
	public static ArrayList<EnemigoData> enemyList = new ArrayList<EnemigoData>();
	
	public AssetManager(){
		// Constructor vacio
	}		
	
	public static BufferedImage getEnemy(String name){
		return getImage(name, enemyList);
	}
	
	public static BufferedImage getImage(String name){
		return getImage(name, imageList);
	}
	
	public static BufferedImage getObject(String name){
		return getImage(name, objectList);
	}
	
	
	private static BufferedImage getImage(String name, ArrayList arrayList){
		for (ImageData imageData : (ArrayList<ImageData>)arrayList) {
			if (imageData.nombre.equals(name)){
				return imageData.img;
			}
		}
		System.out.println("Error: Can't retrive " + name);
		return null;		
	}
	
	public static EnemigoData getEnemyByID(int id){
		return (EnemigoData) getByID(id, enemyList);
	}
	
	public static ObjetoData getObjectByID(int id){
		return (ObjetoData) getByID(id, objectList);
	}
	
	
	private static ImageData getByID(int id, ArrayList arrayList){
		for (ImageData imageData : (ArrayList<ImageData>)arrayList) {
			if (imageData.id == id){
				return imageData;
			}
		}
		System.out.println("Error: Can't retrive image with id:" + id);
		return null;		
	}
	
	
	
	public static void cargarImagenes(){
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();;
		DocumentBuilder dBuilder = null;
		Document doc = null;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();		
//			Cargar Metadata Imagenes
			File objetosFileBase = new File("./assets/data/imagenes.xml");
			doc = dBuilder.parse(objetosFileBase);
			doc.getDocumentElement().normalize();
			NodeList objetosListBase = doc.getElementsByTagName("imagen");

			for (int id = 0; id < objetosListBase.getLength(); id++) {
				Element objetoBase = (Element) objetosListBase.item(id);				
				String nombre = objetoBase.getElementsByTagName("nombre").item(0).getTextContent();
				String path = 	objetoBase.getElementsByTagName("path").item(0).getTextContent();				
				ImageData obj = new ImageData(id, nombre, path);
				imageList.add(obj);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		try{
//			bgMenu 	= ImageIO.read(new File("assets/img/bgMenu.jpg"));
//			btnJugar 	= ImageIO.read(new File("assets/img/btnJugar.png"));
//			btnSalir 	= ImageIO.read(new File("assets/img/btnSalir.png"));	
//			btnCreditos	= ImageIO.read(new File("assets/img/btnCreditos.png"));		
////			dibujoListo = true;
//		}catch(Exception ex){
//		
//		}
	}
	
	public static void cargarEnemigos(){
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();;
		DocumentBuilder dBuilder = null;
		Document doc = null;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();		
//			Cargar Metadata Objetos
			File objetosFileBase = new File("./assets/data/enemigos.xml");
			doc = dBuilder.parse(objetosFileBase);
			doc.getDocumentElement().normalize();
			NodeList objetosListBase = doc.getElementsByTagName("enemigo");

			for (int id = 0; id < objetosListBase.getLength(); id++) {
				Element objetoBase = (Element) objetosListBase.item(id);
				
				String nombre = objetoBase.getElementsByTagName("nombre").item(0).getTextContent();
				char sprite = 	objetoBase.getElementsByTagName("sprite").item(0).getTextContent().charAt(0);
				int width = 	Integer.parseInt(objetoBase.getElementsByTagName("width").item(0).getTextContent());
				int height = 	Integer.parseInt(objetoBase.getElementsByTagName("height").item(0).getTextContent());
				int rango = 	Integer.parseInt(objetoBase.getElementsByTagName("rango").item(0).getTextContent());
				String frame = 	objetoBase.getElementsByTagName("frame").item(0).getTextContent();
				
				EnemigoData obj = new EnemigoData(id, nombre, width, height, sprite, rango, frame);
				enemyList.add(obj);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void cargarObjetos(){
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();;
		DocumentBuilder dBuilder = null;
		Document doc = null;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();		
//			Cargar Metadata Objetos
			File objetosFileBase = new File("./assets/data/objetos.xml");
			doc = dBuilder.parse(objetosFileBase);
			doc.getDocumentElement().normalize();
			NodeList objetosListBase = doc.getElementsByTagName("objeto");

			for (int id = 0; id < objetosListBase.getLength(); id++) {
				Element objetoBase = (Element) objetosListBase.item(id);
				
				String nombre = objetoBase.getElementsByTagName("nombre").item(0).getTextContent();
				char sprite = 	objetoBase.getElementsByTagName("sprite").item(0).getTextContent().charAt(0);
				int width = 	Integer.parseInt(objetoBase.getElementsByTagName("width").item(0).getTextContent());
				int height = 	Integer.parseInt(objetoBase.getElementsByTagName("height").item(0).getTextContent());
				int tipo = 		Integer.parseInt(objetoBase.getElementsByTagName("tipo").item(0).getTextContent());
				String frame = 	objetoBase.getElementsByTagName("frame").item(0).getTextContent();
				
				ObjetoData obj = new ObjetoData(id, nombre, width, height, sprite, tipo, frame);
				objectList.add(obj);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
