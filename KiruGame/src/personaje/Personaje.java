package personaje;
import game.*;

public class Personaje {
	protected int gridX;
	protected int gridY;
	protected int alto;
	protected int ancho;
	protected char sprite;
	
	public Personaje(int x, int y, int alto, int ancho, char sprite){
		this.gridX = x;
		this.gridY = y;
		this.alto = alto;
		this.ancho = ancho;
		this.sprite = sprite;
	}
	
	public int setPos(int x, int y){
		
		if (x>=0 && y>=0 && x<Juego.gridWidth && y<Juego.gridHeight){
			gridX = x ;
			gridY = y;
			return 1 ;
		}else return 0 ;
	}
}
