package controlador;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import actionscript3.MovieClip;
import actionscript3.Scene;
import modelo.*;
import modelo.dataHolder.EnemigoData;
import vista.Juego;

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
		
		File fXmlFile = new File("./assets/data/mapa"+i+".xml");
		Document doc;
		try {
			doc = dBuilder.parse(fXmlFile);		
			doc.getDocumentElement().normalize();
			
			Element mapaData = (Element) doc.getElementsByTagName("mapa").item(0);
				
			String urlArchivo = mapaData.getAttribute("url");
			int bgImgID= Integer.parseInt(mapaData.getAttribute("imgID"));
			
			cargarMapa(urlArchivo);					
			map.cargarFondo(bgImgID);

			NodeList listaJugadores = doc.getElementsByTagName("jugador");
//			cargarJugadores(listaJugadores);
			
			Jugador player;
			for (int pos = 0; pos < listaJugadores.getLength(); pos++) {				
				Element elem  = (Element) listaJugadores.item(pos);	
				
				int id = Integer.parseInt(elem.getAttribute("id"));	
				int posx = Integer.parseInt(elem.getAttribute("xpos"));
				int posy = Integer.parseInt(elem.getAttribute("ypos"));
				int xTerreno = Integer.parseInt(elem.getAttribute("xTerreno"));
				int yTerreno = Integer.parseInt(elem.getAttribute("yTerreno"));	
				int terrenoImgID = Integer.parseInt(elem.getAttribute("imgID"));
				String animInit = elem.getAttribute("animInit");				
				

				map.cargarTerreno(new Point(xTerreno, yTerreno), terrenoImgID);
				player = id==1? Mapa.p1 : Mapa.p2;
				player.setAnimInit(animInit);
				player.setXY(posx, posy);
				
				
			}
			
			NodeList listaAcciones = doc.getElementsByTagName("accion");
			cargarAcciones(listaAcciones);
			NodeList listaObjetos = doc.getElementsByTagName("objeto");
			cargarObjetos(listaObjetos);
			NodeList listaEnemigos = doc.getElementsByTagName("enemigo");
			cargarEnemigos(listaEnemigos);
			
			Juego.map = map;
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void cargarAcciones(NodeList listaAcciones)throws SAXException, IOException {

		for (int pos = 0; pos < listaAcciones.getLength(); pos++) {
			Element accion  = (Element) listaAcciones.item(pos);			

			int cod = Integer.parseInt(accion.getAttribute("id"));
			String sec =  accion.getAttribute("sec");
			int visible = Integer.parseInt(accion.getAttribute("visible"));
			int tipo = Integer.parseInt(accion.getAttribute("tipo"));
			int time = Integer.parseInt(accion.getAttribute("time"));
			
			AccionEspecial accionObj = new AccionEspecial(cod, sec, tipo,visible,time);
			
			NodeList listaJugadores = accion.getElementsByTagName("jug");

			for(int ij = 0 ; ij < listaJugadores.getLength(); ij++) {
				Element jugador = (Element) listaJugadores.item(ij);
				
				int x = Integer.parseInt(jugador.getAttribute("xpos"));
				int y = Integer.parseInt(jugador.getAttribute("ypos"));
				int id = Integer.parseInt(jugador.getAttribute("id"));
				
				NodeList listaMovimientos = jugador.getElementsByTagName("mov");
				int[][] movinfo = new int[listaMovimientos.getLength()][3];
				
				for(int imov = 0 ; imov<listaMovimientos.getLength();imov++) {
					Element movimiento = (Element) listaMovimientos.item(imov);

					movinfo[imov][0] = Integer.parseInt(movimiento.getAttribute("xdir"));
					movinfo[imov][1] = Integer.parseInt(movimiento.getAttribute("ydir"));
					movinfo[imov][2] = Integer.parseInt(movimiento.getAttribute("anim"));					
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
			Jugador player;
			for (int id = 0; id < objetosListBase.getLength(); id++) {
				Element objetoBase = (Element) objetosListBase.item(id);
//				scene = new Scene(folder);
				player = id ==0? Mapa.p1 : Mapa.p2;
				NodeList anims = objetoBase.getElementsByTagName("anim");	
				for (int i = 0; i < anims.getLength(); i++) {
					Element anim= (Element) anims.item(i);
					int animID= Integer.parseInt(anim.getTextContent());
					String nom= anim.getAttribute("nombre");											
								
					((MovieClip)player.sprite).addScene(AssetManager.getSceneByID(animID),nom);
									
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
	
	

	public static void cargarObjetos(NodeList objetosList){

		for (int pos = 0; pos < objetosList.getLength(); pos++) {
			Element elem  = (Element) objetosList.item(pos);			
			int objetoID = Integer.parseInt(elem.getAttribute("refID"));
			int posx = Integer.parseInt(elem.getAttribute("xpos"));
			int posy = Integer.parseInt(elem.getAttribute("ypos"));
			int id = Integer.parseInt(elem.getAttribute("id"));
			
			map.addObjeto(id, posx,posy, objetoID);			
		}
		
		
	}
	
	
	
	public static void cargarEnemigos(NodeList objetosList){
	
		for (int pos = 0; pos < objetosList.getLength(); pos++) {
			Element elem  = (Element) objetosList.item(pos);			
			int enemigoID = Integer.parseInt(elem.getAttribute("refID"));
			int accionID = Integer.parseInt(elem.getAttribute("accionID"));
			int jugadorID = Integer.parseInt(elem.getAttribute("jugadorID"));
			int posx = Integer.parseInt(elem.getAttribute("xpos"));
			int posy = Integer.parseInt(elem.getAttribute("ypos"));
			int id = Integer.parseInt(elem.getAttribute("id"));
			
			EnemigoData enemyData = AssetManager.getEnemyByID(enemigoID);			
			Enemigo enemigo = new Enemigo(id, posx, posy, accionID,jugadorID, enemyData);
			map.addEnemigo(enemigo);
		}
			
		
	}
	
	
	
	
}