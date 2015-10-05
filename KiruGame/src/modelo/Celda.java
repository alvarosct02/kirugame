package modelo;

import vista.AssetManager;

public class Celda {
	private int x;
	private int y;
	private char terreno;
	public char visibleChar;
	private Sprite sprite;
	private Sprite objeto;	

	public boolean trigger = false;
	public boolean walkable = false;
	
	
	
	public Celda(int y,int x,char terreno){
		this.x = x;
		this.y = y;
		this.terreno = terreno;
		this.visibleChar = terreno;
//		sprite = asignarSprite(obj);
		
		
	}
	
	private Sprite asignarSprite(char val){
		Sprite sprite = null;
//		if(val =='*')
//		{
//			sprite = null;
//			return sprite;
//		}else{
//			try{
//			
//			
//				File fXmlFile = new File("./src/Data/objetos.xml");
//				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//				Document doc = dBuilder.parse(fXmlFile);
//	
//				//optional, but recommended
//				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
//				doc.getDocumentElement().normalize();
//	
//				NodeList nList = doc.getElementsByTagName("objetos");
//	
//				Node nNode = nList.item(Character.getNumericValue(val));
//	
//				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//	
//					Element eElement = (Element) nNode;
//					sprite = new Obstaculo(x,y,eElement.getElementsByTagName("sprite").item(0).getTextContent().charAt(0));
//					return sprite;
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//				sprite = null;
//				return sprite;
//			}
//		/*switch (val) {
//		case 'm':
//			sprite = new Obstaculo(x, y, val); break;
//		case 'j':
//			sprite = new Obstaculo(x, y, val); break;
//		case 'd':
//			sprite = new Obstaculo(x, y, val); break;
//		case 'p':
//			sprite = new Obstaculo(x, y, val); break;
//		case 'i':
//			sprite = new Obstaculo(x, y, val); break;
//		case 'g':
//			sprite = new Obstaculo(x, y, val); break;
//		case 'L':
//			sprite = new Obstaculo(x, y, val); break;
//		case 'h':
//			sprite = new Obstaculo(x, y, val); break;
//		case 't':
//			sprite = new Obstaculo(x, y, val); break;
//		case 'a':
//			sprite = new Obstaculo(x, y, val); break;
//		case 'o':			
//			sprite = new ObjetoApoyo(x, y, val); break;
//
//		case 'C':
//			special = true;
//			sprite = new AccionEspecial(x, y, val,0); break;
//
//		case 'D':
//			special = true;
//			sprite = new AccionEspecial(x, y, val,0); break;
//		default:
//			sprite = null;
//		}*/
//		}
		return sprite;
		
		
	}
	
	
	public char getValor() {		
		return visibleChar;	
	}
	
//	public char getTerreno() {		
//		return terreno;	
//	}
	
	public void showTerreno() {		
		visibleChar = terreno;
	}

	public Objeto addObjeto(int id , int objetoID) {
		ObjetoData objData = AssetManager.getObjectByID(objetoID);		
		
		int tipo = objData.tipo;
		
		Objeto obj = null;
		switch (tipo) {
			case 0:			
				obj = new Obstaculo(id,x,y,objData);break;
			case 1:			
				obj = new ObjetoApoyo(id,x,y,objData); break;
			default:
				obj = new Objeto(id,x,y,objData);	break;
		}
		
		this.objeto = obj;
		return obj;
	}

//	public void setValor(char valor) {
//		this.valor = valor;
//	}
}