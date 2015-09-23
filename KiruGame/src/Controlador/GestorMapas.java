package Controlador;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Modelo.*;
import Vista.AccionEspecial;
import Vista.Enemigo;
import Vista.Mapa;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

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
		
		File fXmlFile = new File("./src/Data/mapas.xml");
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
	
				try {
					cargarMapa(urlArchivo);
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

		File accionesFile = new File("./src/Data/acciones.xml");		
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

	
	
	public static void cargarMapa(String urlArchivo) throws Exception{
		
		BufferedReader in = null;
		in = new BufferedReader(new FileReader("./src/Data/"+urlArchivo));
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

	public static void cargarObjetos(int nivel) throws SAXException, IOException{
		
//		Cargar Objetos por Nivel
		File objetosFile = new File("./src/Data/objetosMapa.xml");		
		Document doc = dBuilder.parse(objetosFile);		
		doc.getDocumentElement().normalize();
		NodeList objetosList = doc.getElementsByTagName("nivel");
		
		Element listaObjetos =(Element) objetosList.item(nivel);
		NodeList objetosMapa = listaObjetos.getElementsByTagName("objetoMapa");

//		Cargar Metadata Objetos
		File objetosFileBase = new File("./src/Data/objetos.xml");
		doc = dBuilder.parse(objetosFileBase);
		doc.getDocumentElement().normalize();
		NodeList objetosListBase = doc.getElementsByTagName("objeto");

		for (int pos = 0; pos < objetosMapa.getLength(); pos++) {
			Element objetoMapa  = (Element) objetosMapa.item(pos);			
			int objetoID = Integer.parseInt(objetoMapa.getElementsByTagName("objetoID").item(0).getTextContent());
			int posx = Integer.parseInt(objetoMapa.getElementsByTagName("xpos").item(0).getTextContent());
			int posy = Integer.parseInt(objetoMapa.getElementsByTagName("ypos").item(0).getTextContent());
			int id = Integer.parseInt(objetoMapa.getAttribute("id"));
			
			Element objetoBase = (Element) objetosListBase.item(objetoID);
			char sprite = objetoBase.getElementsByTagName("sprite").item(0).getTextContent().charAt(0);
			int width = Integer.parseInt(objetoBase.getElementsByTagName("width").item(0).getTextContent());
			int height = Integer.parseInt(objetoBase.getElementsByTagName("height").item(0).getTextContent());
			int tipo = Integer.parseInt(objetoBase.getElementsByTagName("tipo").item(0).getTextContent());
			
			Objeto obj = map.getCelda(posx,posy).addObjeto(id, tipo,width, height, sprite);	
			map.addObjeto(obj);
		}
	}
	
public static void cargarEnemigos(int nivel) throws SAXException, IOException{
		
//		Cargar enemigos por Nivel
		File enemigosFile = new File("./src/Data/enemigosMapa.xml");		
		Document doc = dBuilder.parse(enemigosFile);		
		doc.getDocumentElement().normalize();
		NodeList enemigosList = doc.getElementsByTagName("nivel");
		
		Element listaenemigos =(Element) enemigosList.item(nivel);
		NodeList enemigosMapa = listaenemigos.getElementsByTagName("enemigoMapa");

//		Cargar Metadata enemigos
		File enemigosFileBase = new File("./src/Data/enemigos.xml");
		doc = dBuilder.parse(enemigosFileBase);
		doc.getDocumentElement().normalize();
		NodeList enemigosListBase = doc.getElementsByTagName("enemigo");

		for (int pos = 0; pos < enemigosMapa.getLength(); pos++) {
			Element enemigoMapa  = (Element) enemigosMapa.item(pos);			
			int enemigoID = Integer.parseInt(enemigoMapa.getElementsByTagName("enemigoID").item(0).getTextContent());
			int accionID = Integer.parseInt(enemigoMapa.getElementsByTagName("accionID").item(0).getTextContent());
			int jugadorID = Integer.parseInt(enemigoMapa.getElementsByTagName("jugadorID").item(0).getTextContent());
			int posx = Integer.parseInt(enemigoMapa.getElementsByTagName("xpos").item(0).getTextContent());
			int posy = Integer.parseInt(enemigoMapa.getElementsByTagName("ypos").item(0).getTextContent());
			int id = Integer.parseInt(enemigoMapa.getAttribute("id"));
			
			Element enemigoBase = (Element) enemigosListBase.item(enemigoID);
			char sprite = enemigoBase.getElementsByTagName("sprite").item(0).getTextContent().charAt(0);
			int width = Integer.parseInt(enemigoBase.getElementsByTagName("width").item(0).getTextContent());
			int height = Integer.parseInt(enemigoBase.getElementsByTagName("height").item(0).getTextContent());
			int rango = Integer.parseInt(enemigoBase.getElementsByTagName("rango").item(0).getTextContent());
			
			Enemigo enemigo = new Enemigo(id, posx, posy, width, height, sprite, accionID, rango, jugadorID);
			map.addEnemigo(enemigo);
		}
	}
	
	
	
}