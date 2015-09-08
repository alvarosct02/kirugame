package mapa;
public class Celda {
	private int x;
	private int y;
	private char valor;
	
	public Celda(int x,int y,char val){
		this.x = x;
		this.y = y;
		this.valor = val;
		
	}

	public char getValor() {
		return valor;
	}

//	public void setValor(char valor) {
//		this.valor = valor;
//	}
}