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