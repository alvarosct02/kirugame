package controlador;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import actionscript3.Scene;
import modelo.*;
import vista.AssetManager;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.*	;

public class GestorMapas {
	
	private static DocumentBuilderFactory dbFactory;
	private static DocumentBuilder dBuilder;
	private static char [][] mapaFree;
	private static char [][] mapaObjetos;
	
	public static Mapa map;
	
	static {
		dbFactory = DocumentBuilderFactory.newInstance();
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		
		mapaFree =new char[20][20];
		mapaObjetos =new char[20][20];
	}
	
	public static void cargarNivel(int i){	
		
		File fXmlFile = new File("./assets/data/mapas.xml");
		Document doc;
		try {
			doc = dBuilder.parse(fXmlFile);		
			doc.getDocumentElement().normalize();		
			NodeList nList = doc.getElementsByTagName("mapa");
			Node nNode = nList.item(i);
	
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				
				String urlArchivo = eElement.getElementsByTagName("url").item(0).getTextContent();
				int posxA = Integer.parseInt(eElement.getElementsByTagName("xposA").item(0).getTextContent());
				int posyA = Integer.parseInt(eElement.getElementsByTagName("yposA").item(0).getTextContent());
				int posxB = Integer.parseInt(eElement.getElementsByTagName("xposB").item(0).getTextContent());
				int posyB = Integer.parseInt(eElement.getElementsByTagName("yposB").item(0).getTextContent());
				int posxTerrenoA = Integer.parseInt(eElement.getElementsByTagName("terrenoA_X").item(0).getTextContent());
				int posyTerrenoA = Integer.parseInt(eElement.getElementsByTagName("terrenoA_Y").item(0).getTextContent());
				int posxTerrenoB = Integer.parseInt(eElement.getElementsByTagName("terrenoB_X").item(0).getTextContent());
				int posyTerrenoB = Integer.parseInt(eElement.getElementsByTagName("terrenoB_Y").item(0).getTextContent());

				try {
					cargarMapa(urlArchivo);					
					map.cargarTerreno(new Point(posxTerrenoA,posyTerrenoA),new Point(posxTerrenoB,posyTerrenoB));					
					cargarObjetos(i);
					cargarEnemigos(i);
					cargarAcciones(i);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Mapa.p1.setXY(posxA, posyA);
				Mapa.p2.setXY(posxB, posyB);
				
				
//				map.addPlayer();
				
	//			cargarMapa();
				
//				parseAccion("C.1.8.2.WEDQ.0.1.0.1.0.1");
				
								
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private static void cargarAcciones(int i)throws SAXException, IOException {

		File accionesFile = new File("./assets/data/acciones.xml");		
		Document doc = dBuilder.parse(accionesFile);		
		doc.getDocumentElement().normalize();
		NodeList objetosList = doc.getElementsByTagName("nivel");
		
		Element nivel =(Element) objetosList.item(i);
		NodeList listaAcciones = nivel.getElementsByTagName("accion");

		for (int pos = 0; pos < listaAcciones.getLength(); pos++) {
			Element accion  = (Element) listaAcciones.item(pos);			

			char sprite = accion.getElementsByTagName("sprite").item(0).getTextContent().charAt(0);
			int tipo = Integer.parseInt(accion.getElementsByTagName("tipo").item(0).getTextContent());
			String sec =  accion.getElementsByTagName("cad").item(0).getTextContent();
			int cod = Integer.parseInt(accion.getAttribute("id"));
			int visible = Integer.parseInt(accion.getElementsByTagName("visible").item(0).getTextContent());
			
			AccionEspecial accionObj = new AccionEspecial(sprite, cod, sec, tipo,visible);
			NodeList listaJugadores = accion.getElementsByTagName("jugador");

			for(int ij = 0 ; ij<listaJugadores.getLength(); ij++)
			{
				Element jugador = (Element) listaJugadores.item(ij);

				NodeList listaMovimientos = jugador.getElementsByTagName("mov");

				int[][] movinfo = new int[listaMovimientos.getLength()][2];

				int x = Integer.parseInt(jugador.getElementsByTagName("xpos").item(0).getTextContent());
				int y = Integer.parseInt(jugador.getElementsByTagName("ypos").item(0).getTextContent());
				int id = Integer.parseInt(jugador.getAttribute("id"));
				for(int imov = 0 ; imov<listaMovimientos.getLength();imov++)
				{
					Element movimiento = (Element) listaMovimientos.item(imov);

					movinfo[imov][0] = Integer.parseInt(movimiento.getElementsByTagName("xdir").item(0).getTextContent());
					movinfo[imov][1] = Integer.parseInt(movimiento.getElementsByTagName("ydir").item(0).getTextContent());
					
				}

				accionObj.addPlayerAccion(id, x, y, movinfo);				
			}
			
			map.addAccion(accionObj);
		}
	}

	
	public static void cargarAnimacionesJugadores(){
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();;
		DocumentBuilder dBuilder = null;
		Document doc = null;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();		
//			Cargar Metadata Objetos
			File objetosFileBase = new File("./assets/data/jugadores.xml");
			doc = dBuilder.parse(objetosFileBase);
			doc.getDocumentElement().normalize();
			NodeList objetosListBase = doc.getElementsByTagName("jugador");
			
			Scene scene;
			
			for (int id = 0; id < objetosListBase.getLength(); id++) {
				Element objetoBase = (Element) objetosListBase.item(id);
//				scene = new Scene(folder);
				
				NodeList anims = objetoBase.getElementsByTagName("anim");	
				for (int i = 0; i < anims.getLength(); i++) {
					Element anim= (Element) anims.item(i);
					int animID= Integer.parseInt(anim.getTextContent());
										
					Mapa.p1.mc.addScene(AssetManager.getSceneByID(animID));
									
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void cargarMapa(String urlArchivo) throws Exception{
		
		BufferedReader in = null;
		in = new BufferedReader(new FileReader("./assets/data/"+urlArchivo));
		String letra;

		for (int x = 0 ; x <12; x++){
			letra = in.readLine();
			for(int y = 0 ; y < 16; y++){
				char sprite = letra.charAt(y);
				mapaFree[x][y] = sprite;
				mapaObjetos[x][y]  = '*';
			}
		}		
		in.close();
		map = new Mapa(mapaFree);
	}

	public static void cargarObjetos(int nivel){

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();;
		DocumentBuilder dBuilder = null;
		Document doc = null;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();		
//			Cargar Metadata Objetos
			File objetosFile = new File("./assets/data/objetosMapa.xml");
			doc = dBuilder.parse(objetosFile);
			doc.getDocumentElement().normalize();
			NodeList objetosList = doc.getElementsByTagName("nivel");
			
			Element listaObjectos =(Element) objetosList.item(nivel);
			NodeList objetosMapa = listaObjectos.getElementsByTagName("objetoMapa");

			for (int pos = 0; pos < objetosMapa.getLength(); pos++) {
				Element objetoMapa  = (Element) objetosMapa.item(pos);			
				int objetoID = Integer.parseInt(objetoMapa.getElementsByTagName("objetoID").item(0).getTextContent());
				int posx = Integer.parseInt(objetoMapa.getElementsByTagName("xpos").item(0).getTextContent());
				int posy = Integer.parseInt(objetoMapa.getElementsByTagName("ypos").item(0).getTextContent());
				int id = Integer.parseInt(objetoMapa.getAttribute("id"));
				
				Objeto obj = map.getCelda(posx,posy).addObjeto(id, objetoID);	
				map.addObjeto(obj);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public static void cargarEnemigos(int nivel){
		
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();;
		DocumentBuilder dBuilder = null;
		Document doc = null;
		
		try {
			dBuilder = dbFactory.newDocumentBuilder();		
//			Cargar Metadata Objetos
			File objetosFile = new File("./assets/data/enemigosMapa.xml");
			doc = dBuilder.parse(objetosFile);
			doc.getDocumentElement().normalize();
			NodeList objetosList = doc.getElementsByTagName("nivel");
			
			Element listaObjectos =(Element) objetosList.item(nivel);
			NodeList objetosMapa = listaObjectos.getElementsByTagName("enemigoMapa");

			for (int pos = 0; pos < objetosMapa.getLength(); pos++) {
				Element objetoMapa  = (Element) objetosMapa.item(pos);			
				int enemigoID = Integer.parseInt(objetoMapa.getElementsByTagName("enemigoID").item(0).getTextContent());
				int accionID = Integer.parseInt(objetoMapa.getElementsByTagName("accionID").item(0).getTextContent());
				int jugadorID = Integer.parseInt(objetoMapa.getElementsByTagName("jugadorID").item(0).getTextContent());
				int posx = Integer.parseInt(objetoMapa.getElementsByTagName("xpos").item(0).getTextContent());
				int posy = Integer.parseInt(objetoMapa.getElementsByTagName("ypos").item(0).getTextContent());
				int id = Integer.parseInt(objetoMapa.getAttribute("id"));
				
				EnemigoData enemyData = AssetManager.getEnemyByID(enemigoID);			
				Enemigo enemigo = new Enemigo(id, posx, posy, accionID,jugadorID, enemyData);
				map.addEnemigo(enemigo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
}