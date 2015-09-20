package Vista;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Controlador.Juego;
import Modelo.AccionEspecial;
import Modelo.Objeto;
import Modelo.Obstaculo;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.*	;

public class GestorMapas {
	
	
	/*private static char tutorialFree[][] = {
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','S'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'}
	};
	
	private static char nivel1Free[][] ={
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'}
	};

	
	private static char nivel2Free[][] ={
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'S','S','S','S','S','S','S','S','S','S','S','S','S','S','S','S'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'},
		{'N','N','N','N','N','N','N','N','N','N','N','N','N','N','N','N'}
	};
	
	private static char tutorialGg[][] = {
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'A','*','*','*','*','*','*','*','C','d','d','*','*','*','*','*'},
		{'*','*','*','m','m','*','*','*','*','d','d','*','*','*','*','*'},
		{'*','*','*','m','m','*','j','j','*','*','*','*','*','*','*','*'},
		{'*','*','*','*','*','*','j','j','*','*','*','*','*','D','*','o'},
		{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','o'},
		{'a','a','a','a','a','a','a','a','a','a','a','a','a','a','a','o'},
		{'*','*','*','*','m','m','*','*','*','*','*','*','*','D','*','o'},
		{'*','*','*','*','m','m','*','*','*','*','*','*','*','*','*','*'},
		{'*','*','*','*','*','*','*','*','j','j','*','j','j','*','*','*'},
		{'B','*','*','*','*','*','*','*','j','j','*','j','j','*','*','*'}
	};
	private static char nivel1Gg[][] ={
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'*','*','*','*','*','*','*','*','*','*','C','*','*','*','*','*'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','A'},
		{'*','*','*','*','*','*','*','*','*','*','*','*','*','*','*','*'},
		{'p','p','p','p','p','p','p','p','p','p','p','p','p','p','p','p'},
		{'*','*','*','L','*','*','*','*','*','i','i','*','*','*','*','*'},
		{'*','*','*','L','C','*','*','*','*','i','i','*','*','*','*','B'},
		{'*','*','*','L','*','*','*','*','*','*','*','g','g','*','*','*'},
		{'*','*','*','L','*','*','*','*','*','*','*','g','g','*','*','*'}
	};	
	private static char nivel2Gg[][] ={
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z','Z'},
		{'*','*','*','*','t','*','*','*','*','L','L','L','L','L','L','L'},
		{'*','*','*','*','t','*','*','*','*','L','L','L','L','L','L','L'},
		{'A','*','*','C','t','*','*','*','*','L','L','L','L','L','L','L'},
		{'*','*','*','*','t','*','*','*','D','L','L','L','o','o','o','o'},
		{'g','g','g','g','g','g','g','g','g','L','L','L','o','o','o','o'},
		{'*','*','*','m','*','*','*','*','D','L','L','L','L','L','L','L'},
		{'*','*','*','m','*','*','*','*','*','L','L','L','L','L','L','L'},
		{'B','*','*','m','*','h','h','*','*','L','L','L','L','L','L','L'},
		{'*','*','*','*','*','h','h','*','*','L','L','L','L','L','L','L'}
	};*/
	
	
	
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
				String urlObjetos = eElement.getElementsByTagName("urlObjetos").item(0).getTextContent();
				int posxA = Integer.parseInt(eElement.getElementsByTagName("xposA").item(0).getTextContent());
				int posyA = Integer.parseInt(eElement.getElementsByTagName("yposA").item(0).getTextContent());
				int posxB = Integer.parseInt(eElement.getElementsByTagName("xposB").item(0).getTextContent());
				int posyB = Integer.parseInt(eElement.getElementsByTagName("yposB").item(0).getTextContent());
	
				try {
					cargarMapa(urlArchivo);
					cargarObjetos(urlObjetos,i);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				Juego.p1.moverXY(posxA, posyA);
				Juego.p2.moverXY(posxB, posyB);
//				map.addPlayer();
				
	//			cargarMapa();
				

				parseAccion("C.1.8.2.WEDQ.0.1.0.1.0.1");
				
								
			}

		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	private static void parseAccion(String act){
		String[] arreglo = act.split("\\.");
		char sprite = arreglo[0].charAt(0);
		int cod = Integer.parseInt(arreglo[1]);
		int posX = Integer.parseInt(arreglo[2]);
		int posY = Integer.parseInt(arreglo[3]);

		String sec = arreglo[4];
		
		int offset = 5; //Posicion de la secuencia
		int size = (arreglo.length-offset)/2;
		int[][] cordMov = new int[size][2];
		for (int i = 0; i<size; i++){
			cordMov[i][0] = Integer.parseInt(arreglo[offset+2*i]);
			cordMov[i][1] = Integer.parseInt(arreglo[offset+2*i+1]);
		}
		
		AccionEspecial accion = new AccionEspecial(posX, posY, sprite, cod, sec,cordMov);
		map.addAccion(accion);
	}
	
	public static void cargarMapa(String urlArchivo) throws Exception{
		
		BufferedReader in = null;
		in = new BufferedReader(new FileReader("./src/Data/"+urlArchivo));

		int letra;

		for (int x = 0 ; x <12; x++){
			for(int y = 0 ; y < 16; y++){
				letra = in.read();
				char sprite[] = Character.toChars(letra);
				mapaFree[x][y] = sprite[0];
				mapaObjetos[x][y]  = '*';
			}
			letra = in.read();
			letra = in.read();
		}		
		in.close();
		map = new Mapa(mapaFree);
	}

	public static void cargarObjetos(String urlObjetos, int nivel) throws SAXException, IOException{
		
//		Cargar Objetos por Nivel
		File objetosFile = new File("./src/Data/"+urlObjetos);		
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
			
			Element objetoBase = (Element) objetosListBase.item(objetoID);
			char sprite = objetoBase.getElementsByTagName("sprite").item(0).getTextContent().charAt(0);
			int width = Integer.parseInt(objetoBase.getElementsByTagName("width").item(0).getTextContent());
			int height = Integer.parseInt(objetoBase.getElementsByTagName("height").item(0).getTextContent());
			
			map.getCelda(posx,posy).addObjeto(width, height, sprite);			
		}
	}
	
}