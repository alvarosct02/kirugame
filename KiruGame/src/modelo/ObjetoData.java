package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ObjetoData extends ImageData {
	
	int width;
	int height;
	char sprite;
	int layer;
	int tipo;
	
	public ObjetoData(int id, String nom, int w, int h, char sprite, int tipo, String path) {
		super(id,nom,path);
		this.width = w;
		this.height = h;
		this.sprite = sprite;
		this.tipo = tipo;
	}
	
}
