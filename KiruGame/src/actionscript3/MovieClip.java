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
	}
	
	public MovieClip(MovieClip mc) {
		super();
		for (Scene scene : mc.sceneArr) {
			addScene(scene);
		}
	}
	
	public void addScene(String sceneName,int offsetX, int offsetY){
		Scene scene = new Scene(sceneName,offsetX,offsetY);
		scene.offsetX = offsetX;
		scene.offsetY = offsetY;
		sceneArr.add(scene);
		setScene(sceneName);
	}
	
	public void addScene(Scene scene2, String nombre){
		addScene(scene2);
		currentScene.name = nombre;
	}
	
	public void addScene(Scene scene2){
		Scene scene = new Scene(scene2.name,scene2.offsetX,scene2.offsetY);
		for (int i = 0; i<scene2.getNumFrame(); i++){
			scene.addFrame(scene2.getFrame(i));
		}		
		sceneArr.add(scene);
		setScene(scene2.name);
	}
	
	public Scene getScene(String sceneName){
		for (Scene scene : sceneArr) {
			if (scene.name.equals(sceneName))
				return scene;
		}
		return null;
	}
	
	public Scene getScene(int index){
		if (index < sceneArr.size()){
			return sceneArr.get(index);
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
