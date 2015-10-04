package vista.screen;

import java.awt.Graphics2D;

import actionscript3.Screen;

public class ScreenManager {
	
	private static Screen currentScreen;
		
	public static void showScreen(String screen){
		Screen newScreen = null;
		
		if (currentScreen != null){
			currentScreen.removerListeners();
		}
		
		switch(screen){
			case "menu": newScreen = new ScreenMenu(); break;
			case "game": newScreen = new ScreenGame(); break;
		}
		
        currentScreen = newScreen;
	}
	
	public static void renderScreen(Graphics2D canvas){
		currentScreen.renderAll(canvas);
	}
	
}
