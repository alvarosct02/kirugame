package javaAS3;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MovieClipAS3 extends SpriteAS3 {
	
	private ArrayList<SceneAS3> sceneArr= new ArrayList<SceneAS3>();
	public SceneAS3 currentScene;
	private boolean isPlaying = true;
//	private int currentFrame = 0;
	
	public MovieClipAS3() {
		// TODO Auto-generated constructor stub
	}
	
	public void addScene(String sceneName){
		SceneAS3 scene = new SceneAS3(sceneName);
		sceneArr.add(scene);
		currentScene = scene;		
	}
	
	public SceneAS3 getScene(String sceneName){
		for (SceneAS3 scene : sceneArr) {
			if (scene.name == sceneName)
				return scene;
		}
		return null;
	}
	
	public boolean setScene(String sceneName){
		currentScene = getScene(sceneName);
		if (currentScene != null)
			return true;
		return false;
	}
	
	public void play(){
		isPlaying = true;
	}
	
	public void stop(){
		isPlaying = false;
	}
	
	@Override
	protected void render(Graphics2D canvas) {	
		img = currentScene.getFrame();	
		
		if (isPlaying)
			currentScene.next();

		super.render(canvas);
		
	}
	

}
