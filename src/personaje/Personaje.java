package personaje;
import game.*;

public class Personaje {
	protected int gridX;
	protected int gridY;
	
	public Personaje(int x, int y){
		this.gridX = x;
		this.gridY = y;
	}
	
	public void setPos(int x, int y){
		
		if (x>=0 && y>=0 && x<Juego.gridWidth && y<Juego.gridHeight){
			
		}
	}
}
