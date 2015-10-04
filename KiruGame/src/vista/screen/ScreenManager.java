package vista.screen;

import java.awt.Graphics2D;

import javaAS3.ScreenAS3;

public class ScreenManager {
	
	private static ScreenAS3 currentScreen;
		
	public static void showScreen(String screen){
		ScreenAS3 newScreen = null;
		switch(screen){
			case "menu": newScreen = new ScreenMenu(); break;
			case "game": newScreen = new ScreenGame(); break;
		}
		if (currentScreen != null){
			currentScreen.removerListeners();
		}
        currentScreen = newScreen;
	}
	
	public static void renderScreen(Graphics2D canvas){
		currentScreen.renderAll(canvas);
	}
	
}
