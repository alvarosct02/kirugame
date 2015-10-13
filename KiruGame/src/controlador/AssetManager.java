package controlador;

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

import actionscript3.MovieClip;
import actionscript3.Scene;
import modelo.Objeto;
import modelo.dataHolder.EnemigoData;
import modelo.dataHolder.ImageData;
import modelo.dataHolder.ObjetoData;

public class AssetManager {
	
	public static ArrayList<ImageData> imageList = new ArrayList<ImageData>();	
	public static ArrayList<ObjetoData> objectList = new ArrayList<ObjetoData>();
	public static ArrayList<EnemigoData> enemyList = new ArrayList<EnemigoData>();
	public static ArrayList<Scene> sceneList = new ArrayList<Scene>();
	
	public AssetManager(){
		// Constructor vacio
	}
	
	public static void init(){
		cargarAnimaciones();
		cargarImagenes();
		cargarEnemigos();
		cargarObjetos();
		
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
	
	public static BufferedImage getImageByID(int id){
		for (ImageData image : imageList) {
			if (image.id == id){
				return image.img;
			}
		}
		System.out.println("Error: Can't retrive image with id:" + id);
		return null;
	}
	
	public static Scene getSceneByID(int id){
		for (Scene scene : sceneList) {
			if (scene.id == id){
				return scene;
			}
		}
		System.out.println("Error: Can't retrive scene with id:" + id);
		return null;	
	}
	
	public static Scene getScene(String name){
		for (Scene scene : sceneList) {
			if (scene.name.equals(name)){
				return scene;
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
	
	
	
	private static void cargarImagenes(){
		
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

			for (int pos = 0; pos < objetosListBase.getLength(); pos++) {
				Element objetoBase = (Element) objetosListBase.item(pos);

				int id = Integer.parseInt(objetoBase.getAttribute("id"));
				String nombre = objetoBase.getAttribute("nom");
				String url = 	objetoBase.getAttribute("url");		
				int offsetX = Integer.parseInt(objetoBase.getAttribute("offsetX"));	
				int offsetY = Integer.parseInt(objetoBase.getAttribute("offsetY"));			
				ImageData obj = new ImageData(id, nombre, url, offsetX, offsetY);
				imageList.add(obj);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void cargarEnemigos(){
		
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

			for (int pos = 0; pos < objetosListBase.getLength(); pos++) {
				Element objetoBase = (Element) objetosListBase.item(pos);

				int id = Integer.parseInt(objetoBase.getAttribute("id"));	
				String nom 		= objetoBase.getAttribute("nom");
				char caracter 	= objetoBase.getAttribute("char").charAt(0);
				int width 		= Integer.parseInt(objetoBase.getAttribute("width"));
				int height 		= Integer.parseInt(objetoBase.getAttribute("height"));
				int rango 		= Integer.parseInt(objetoBase.getAttribute("rango"));
				
				EnemigoData obj = new EnemigoData(id, nom, width, height, caracter, rango);
				
				NodeList animList = objetoBase.getElementsByTagName("anim");
				for (int pos2 = 0; pos2 < objetosListBase.getLength(); pos2++) {
					Element animObjeto = (Element) animList.item(pos2);
					
					int animID = 		Integer.parseInt(animObjeto.getAttribute("refID"));
					String animNom = 	animObjeto.getAttribute("nom");		
					
					obj.addAnim(animID,animNom);					
				}				
				
				enemyList.add(obj);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void cargarObjetos(){
		
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

			for (int pos = 0; pos < objetosListBase.getLength(); pos++) {
				Element objetoBase = (Element) objetosListBase.item(pos);
				

				int id = 	Integer.parseInt(objetoBase.getAttribute("id"));
				String nombre = objetoBase.getAttribute("nom");
				char caracter 	= objetoBase.getAttribute("char").charAt(0);
				int width 		= Integer.parseInt(objetoBase.getAttribute("width"));
				int height 		= Integer.parseInt(objetoBase.getAttribute("height"));
				int tipo 		= Integer.parseInt(objetoBase.getAttribute("tipo"));
				int anim 		= Integer.parseInt(objetoBase.getAttribute("anim"));
				
				ObjetoData obj = new ObjetoData(id, nombre, width, height, caracter, tipo, anim);
				objectList.add(obj);
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void cargarAnimaciones(){
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();;
		DocumentBuilder dBuilder = null;
		Document doc = null;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();		
//			Cargar Metadata Objetos
			File objetosFileBase = new File("./assets/data/animaciones.xml");
			doc = dBuilder.parse(objetosFileBase);
			doc.getDocumentElement().normalize();
			NodeList objetosListBase = doc.getElementsByTagName("anim");
			
			Scene scene;
			
			for (int pos = 0; pos < objetosListBase.getLength(); pos++) {
				Element objetoBase = (Element) objetosListBase.item(pos);
				
				int id = Integer.parseInt(objetoBase.getAttribute("id"));
				String folder = objetoBase.getAttribute("folder");
				String nom = objetoBase.getAttribute("nom");
				int offsetX = Integer.parseInt(objetoBase.getAttribute("offsetX"));	
				int offsetY = Integer.parseInt(objetoBase.getAttribute("offsetY"));	
				scene = new Scene(nom,offsetX,offsetY);
				scene.id = id;
				
				NodeList frames = objetoBase.getElementsByTagName("frame");						
				for (int i = 0; i < frames.getLength(); i++) {
					Element frame = (Element) frames.item(i);
					String src = frame.getAttribute("src");
					int rep = Integer.parseInt(frame.getAttribute("rep"));	
					BufferedImage img = ImageIO.read(new File("assets/img/" + folder + "/" + src));
					scene.addFrame(img, rep);						
				}
				sceneList.add(scene);
				
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
