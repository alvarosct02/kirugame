package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class EnemigoData extends ImageData {
	
	public int width;
	public int height;
	public char sprite;
	public int layer;
	public int rango;
	
	public EnemigoData(int id, String nom, int w, int h, char sprite, int rango, String path) {
		super(id,nom,path);
		
		this.width = w;
		this.height = h;
		this.sprite = sprite;
		this.rango = rango;
	}
	
}
