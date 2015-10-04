package actionscript3;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MovieClip extends SpriteAS3 {
	
	private ArrayList<Scene> sceneArr= new ArrayList<Scene>();
	public Scene currentScene;
	private boolean isPlaying = true;
//	private int currentFrame = 0;
	
	public MovieClip() {
		// TODO Auto-generated constructor stub
	}
	
	public void addScene(String sceneName){
		Scene scene = new Scene(sceneName);
		sceneArr.add(scene);
		currentScene = scene;		
	}
	
	public Scene getScene(String sceneName){
		for (Scene scene : sceneArr) {
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
		setImg(currentScene.getFrame());	
		
		if (isPlaying)
			currentScene.next();

		super.render(canvas);
		
	}
	

}
