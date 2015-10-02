package vista.screen;

import java.awt.Graphics2D;

public class ScreenManager {
	
	private static Screen currentScreen;
		
	public static void showScreen(String screen){
		Screen newScreen = null;
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
