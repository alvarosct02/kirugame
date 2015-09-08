package mapa;

import drawable.Sprite;
import drawable.objeto.Objeto;
import drawable.personaje.Jugador;

public class Celda {
	private int x;
	private int y;
	private char valor;
	private Sprite sprite;
	
	
	
	public Celda(int x,int y,char val){
		this.x = x;
		this.y = y;
		this.valor = asignarValor(val);
		
	}
	
	private char asignarValor(char val){
		switch (val) {
		case 'A':
			return 'S';
		case 'B':
			return 'N';
		default:
			return val;
		}
	}

	private Sprite asignarSprite(char val){
		Sprite sprite;
		sprite = new Objeto(x, y, val);
		switch (val) {
		case 'A':
		case 'B':
			
		default:
			sprite = null;
		}
		return sprite;
		
	}
	
	public char getValor() {
		if (sprite != null){
			if (sprite.tipo == 1){
				return sprite.sprite;
			}
			return '_';
		} else {			
			return valor;
		}
		
		
		
		
	}

	public void asginarPlayer(Jugador player) {
		sprite = player;
	}

//	public void setValor(char valor) {
//		this.valor = valor;
//	}
}