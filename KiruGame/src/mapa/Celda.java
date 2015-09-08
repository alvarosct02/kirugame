package mapa;

import drawable.Sprite;

public class Celda {
	private int x;
	private int y;
	private char valor;
	private Sprite sprite;
	
	
	
	public Celda(int x,int y,char val){
		this.x = x;
		this.y = y;
		this.valor = val;
		
	}

	private Sprite asignarSprite(char val){
		switch (val) {
		case 'B':
			
			break;

		default:
			break;
		}
	}
	
	public char getValor() {
		return valor;
	}

//	public void setValor(char valor) {
//		this.valor = valor;
//	}
}