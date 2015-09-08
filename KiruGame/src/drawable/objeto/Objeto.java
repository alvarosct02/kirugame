package drawable.objeto;

import drawable.Sprite;

public class Objeto extends Sprite{
			
	protected int posX;
	protected int posY;
	protected char sprite;
	
	public Objeto(int posX, int posY, char sprite)
	{
		this.posX= posX;
		this.posY = posY;
		this.sprite = sprite;
	}
}