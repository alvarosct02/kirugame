package drawable.objeto;

import drawable.Sprite;

public class Objeto extends Sprite{
				
	public Objeto(int posX, int posY, char sprite)
	{
		this.gridX= posX;
		this.gridY = posY;
		this.sprite = sprite;
	}
}