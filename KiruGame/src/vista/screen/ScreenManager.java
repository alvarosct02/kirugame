package vista.screen;

import java.awt.Graphics2D;

import actionscript3.Screen;

public class ScreenManager {
	
	private static Screen currentScreen;
	private static Screen currentPopup;
	
	public static Screen getCurrentScreen() {
		return currentScreen;
	}

	public static Screen getCurrentPopup() {
		return currentPopup;
	}
		
	public static void showScreen(String screen){
		Screen newScreen = null;
		
		if (currentScreen != null){
			currentScreen.removerListeners();
		}
		
		switch(screen){
			case "menu": newScreen = new ScreenMenu(); break;
			case "game": newScreen = new ScreenGame(); break;
			case "test": newScreen = new ScreenTest(); break;
		}
		
        currentScreen = newScreen;
	}
	
	public static void showPopup(String popup){
		Screen newPopup = null;		
		currentScreen.active = false;
//		currentScreen.pause();
		currentScreen.disable();
		switch(popup){
			case "action": newPopup = new PopupAction(); break;
//			case "game": newPopup = new ScreenGame(); break;
//			case "test": newPopup = new ScreenTest(); break;
		}
		
        currentPopup = newPopup;
	}
	
	public static void closePopup(){		
		if (currentPopup == null) return;
		
		currentScreen.active = true;
		currentScreen.enable();
//		currentScreen.restart();
		
		currentPopup.removerListeners();
		currentPopup = null;
		
	}
	
	public static void renderScreen(Graphics2D canvas){
		currentScreen.renderAll(canvas);
		if (currentPopup != null)
			currentPopup.renderAll(canvas);
	}
	
}
