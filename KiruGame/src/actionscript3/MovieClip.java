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
		super();
		stage = Stage.stage;	
	}
	
	public void addScene(String sceneName){
		Scene scene = new Scene(sceneName);
		sceneArr.add(scene);
		currentScene = scene;	
		this.offsetX = currentScene.offsetX;
		this.offsetY = currentScene.offsetY;
	}
	
	public void addScene(Scene scene2, String nombre){
		addScene(scene2);
		currentScene.name = nombre;
	}
	
	public void addScene(Scene scene2){
		Scene scene = new Scene(scene2.name);
		for (int i = 0; i<scene2.getNumFrame(); i++){
			scene.addFrame(scene2.getFrame(i));
		}
		scene.offsetX = scene2.offsetX;
		scene.offsetY = scene2.offsetY;
		
		sceneArr.add(scene);
		currentScene = scene;
		this.offsetX = currentScene.offsetX;
		this.offsetY = currentScene.offsetY;
	}
	
	public Scene getScene(String sceneName){
		for (Scene scene : sceneArr) {
			if (scene.name.equals(sceneName))
				return scene;
		}
		return null;
	}
	
	public boolean setScene(String sceneName){
		currentScene = getScene(sceneName);
		if (currentScene != null){
			this.offsetX = currentScene.offsetX;
			this.offsetY = currentScene.offsetY;
			return true;
		}
			
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
