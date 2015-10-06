package controlador;
import modelo.Jugador;
import controlador.Mapa;
import controlador.GestorMapas;
import vista.Juego;
public class Saver {
	
	public int currentLevel = 0;		
	public int cantNivel = 2;
	
	public Jugador p1;
	public Jugador p2;
	public Mapa map;
	public int  vida;
	
	public Saver()
	{
		this.currentLevel = Juego.currentLevel;
		this.cantNivel    = Juego.cantNivel;
		this.p1           = Mapa.p1;
		this.p2           = Mapa.p2;
		this.map          = GestorMapas.map;
		this.vida         = Mapa.p1.getVida();
	}

}
