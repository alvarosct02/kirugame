package Vista;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
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
	
	
	
	
	public static Mapa map;
//	public GestorMapas(){
//		
//	}
	
	public static void cargarNivel(int i){

		try {

			File fXmlFile = new File("./src/Data/mapas.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
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


				BufferedReader in = new BufferedReader(new FileReader("./src/Data/"+urlArchivo));

				String line;

				int letra;
				char [][] mapaFree =new char[20][20];
				char [][] mapaObjetos =new char[20][20];

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
				
				mapaObjetos[posyA][posxA] = 'A';
				mapaObjetos[posyB][posxB] = 'B';	

				File objetosFile = new File("./src/Data/"+urlObjetos);
				File objetosFileBase = new File("./src/Data/objetos.xml");
				doc = dBuilder.parse(objetosFile);

				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();


				NodeList objetosList = doc.getElementsByTagName("nivel");

				doc = dBuilder.parse(objetosFileBase);

				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();
				
				NodeList objetosListBase = doc.getElementsByTagName("objeto");


				Element listaObjetos =(Element) objetosList.item(i);
				NodeList elementos = listaObjetos.getElementsByTagName("objetoMapa");

				for (int temp = 0; temp < elementos.getLength(); temp++) {
					Element elemento  = (Element) elementos.item(temp);
					int objetoID = Integer.parseInt(elemento.getElementsByTagName("objetoID").item(0).getTextContent());
					Element elementoBase = (Element) objetosListBase.item(objetoID);
					String sprite = (elementoBase.getElementsByTagName("sprite").item(0).getTextContent());

					int posx = Integer.parseInt(elemento.getElementsByTagName("xpos").item(0).getTextContent());
					int posy = Integer.parseInt(elemento.getElementsByTagName("ypos").item(0).getTextContent());
					
					mapaObjetos[posy][posx] = elemento.getElementsByTagName("objetoID").item(0).getTextContent().charAt(0);

				}



				map = new Mapa(mapaFree,mapaObjetos);
			}

			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}