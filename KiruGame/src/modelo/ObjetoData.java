package modelo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import actionscript3.MovieClip;
import vista.AssetManager;

public class ObjetoData extends ImageData {
	
	int width;
	int height;
	char sprite;
	int layer;
	int tipo;
	
	public ObjetoData(int id, String nom, int w, int h, char sprite, int tipo, int animID) {
		super(id,nom,"" ,0,0);
		this.width = w;
		this.height = h;
		this.sprite = sprite;
		this.tipo = tipo;		

		mc = new MovieClip();
		mc.addScene(AssetManager.getSceneByID(animID),"idle");
	}
	
}
