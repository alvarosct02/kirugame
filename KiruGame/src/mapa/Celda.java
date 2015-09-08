package mapa;

import drawable.Sprite;
import drawable.objeto.*;
import drawable.personaje.Jugador;

public class Celda {
	private int x;
	private int y;
	private char valor;
	private Sprite sprite;
	
	
	
	public Celda(int y,int x,char val){
		this.x = x;
		this.y = y;
		this.valor = asignarValor(val);
		sprite = asignarSprite(val);
		
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
		switch (val) {
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
		default:
			sprite = null;
		}
		return sprite;
		
	}
	
	public char getValor() {
		if (sprite != null){
			return sprite.sprite;
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