package personaje;

public class Enemigo  {
	private int damage;
	private int dieX;
	private int dieY;
	private String action;
	private int posX;
	private int posY;
	private int alto;
	private int ancho;
	private char sprite;
	
	public Enemigo(int posX, int posY,int dieX, int dieY,int alto,int ancho, char sprite, String action)
	{
		// la posicione de inicio sera la esquina superior izquierda desde ahi se dibujara con el alto y el ancho que tiene el objeto
		this.posX = posX;
		this.posY = posY;
		this.alto = alto;
		this.ancho = ancho;
		this.sprite = sprite;
		this.dieX = dieX;
		this.dieY = dieY;
		this.action = action;
		
	}
	
	public int tryDie(int x, int y , String action)
	{
		if (x == this.dieX && this.dieY == y && action == this.action)
		{
			return 1 ;
		}else return 0;
	}
}
