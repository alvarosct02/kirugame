package Vista;

import Modelo.Sprite;
import Modelo.*;
import Modelo.Jugador;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.*	;

public class Celda {
	private int x;
	private int y;
	private char terreno;
	private Sprite sprite;
	
	private boolean special = false;
	private boolean walkObjetoApoyo = false;
	
	
	
		
	public boolean isSpecial() {
		return special;
	}
	
	public boolean isWalkable() {
		return walkObjetoApoyo;
	}

	public Celda(int y,int x,char terreno,char obj){
		this.x = x;
		this.y = y;
		this.terreno = terreno;
		sprite = asignarSprite(obj);
		
		
	}
	
	private Sprite asignarSprite(char val){
		Sprite sprite = null;
		if(val =='*')
		{
			sprite = null;
			return sprite;
		}else{
			try{
			
			
				File fXmlFile = new File("./src/Data/objetos.xml");
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
	
				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();
	
				NodeList nList = doc.getElementsByTagName("objetos");
	
				Node nNode = nList.item(Character.getNumericValue(val));
	
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	
					Element eElement = (Element) nNode;
					sprite = new Obstaculo(x,y,eElement.getElementsByTagName("sprite").item(0).getTextContent().charAt(0));
					return sprite;
				}
			} catch (Exception e) {
				e.printStackTrace();
				sprite = null;
				return sprite;
			}
		/*switch (val) {
		case 'm':
			sprite = new Obstaculo(x, y, val); break;
		case 'j':
			sprite = new Obstaculo(x, y, val); break;
		case 'd':
			sprite = new Obstaculo(x, y, val); break;
		case 'p':
			sprite = new Obstaculo(x, y, val); break;
		case 'i':
			sprite = new Obstaculo(x, y, val); break;
		case 'g':
			sprite = new Obstaculo(x, y, val); break;
		case 'L':
			sprite = new Obstaculo(x, y, val); break;
		case 'h':
			sprite = new Obstaculo(x, y, val); break;
		case 't':
			sprite = new Obstaculo(x, y, val); break;
		case 'a':
			sprite = new Obstaculo(x, y, val); break;
		case 'o':			
			sprite = new ObjetoApoyo(x, y, val); break;

		case 'C':
			special = true;
			sprite = new AccionEspecial(x, y, val,0); break;

		case 'D':
			special = true;
			sprite = new AccionEspecial(x, y, val,0); break;
		default:
			sprite = null;
		}*/
		}
		return sprite;
		
		
	}
	

	public void banishObject(){
		sprite = null;			
	}
	
	public void toogleSpecial(){
		special = false;
	}
	
	public void toogleWalk(){
		walkObjetoApoyo = true;
	}
	
	public char getValor() {
		if (sprite != null){
			return sprite.sprite;
		} else {			
			return terreno;
		}
	}

	public void asginarPlayer(Jugador player) {
		sprite = player;
	}

//	public void setValor(char valor) {
//		this.valor = valor;
//	}
}