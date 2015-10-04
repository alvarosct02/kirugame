package javaAS3;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class SceneAS3 {
	public String name = "";
	private int numFrame = 0;
	private int currentFrame = 0;
	
	private ArrayList<BufferedImage> imgArr = new ArrayList<BufferedImage>();
	
	public SceneAS3(String name){
		this.name = name;
	}
	
	public void addFrame(BufferedImage img){
		addFrame(img,1);
	}
	
	public void addFrame(BufferedImage img, int rep){
		for (int i = 0; i<rep; i++){
			this.imgArr.add(img);
		}
		numFrame += rep;
	}
	
	public BufferedImage getFrame(){
		return getFrame(currentFrame);
	}
	
	public BufferedImage getFrame(int frame){
		if (frame < imgArr.size())
			return imgArr.get(frame);
		return null;
	}
	
	public void next(){
		currentFrame++;
		if (currentFrame == numFrame){
			currentFrame = 0;
		}
	}
	
}
