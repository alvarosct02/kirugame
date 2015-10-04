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

import modelo.Objeto;
import modelo.ObjetoData;

public class AssetManager {
	public static BufferedImage imgFondo;
	public static BufferedImage imgFondo2;
	public static BufferedImage btn1;
	public static BufferedImage btn2;
	public static BufferedImage btn3;
	
	public static ArrayList<ObjetoData> objectList = new ArrayList<ObjetoData>();
//	public static ArrayList<BufferedImage> objectList = new ArrayList<BufferedImage>();
//	public static ArrayList<BufferedImage> objectList = new ArrayList<BufferedImage>();
	
	public AssetManager(){
		// Constructor vacio
	}
	
	public static void cargarImagenes(){
		try{
			imgFondo = ImageIO.read(new File("assets/img/background_menu.jpg"));
			imgFondo2 = ImageIO.read(new File("assets/img/Game-Back1.jpg"));
			btn1 = ImageIO.read(new File("assets/img/btn1.png"));
			btn2 = ImageIO.read(new File("assets/img/btn2.png"));	
			btn3 = ImageIO.read(new File("assets/img/btn3.png"));		
//			dibujoListo = true;
		}catch(Exception ex){
		
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
