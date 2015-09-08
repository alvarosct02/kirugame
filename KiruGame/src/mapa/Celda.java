package mapa;
public class Celda {
	private int x;
	private int y;
	private char valor;
	
	public Celda(int x,int y){
		this.x = x;
		this.y = y;
		valor = 'A';
		
	}

	public char getValor() {
		return valor;
	}

//	public void setValor(char valor) {
//		this.valor = valor;
//	}
}
