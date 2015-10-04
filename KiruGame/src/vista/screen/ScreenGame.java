package vista.screen;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import actionscript3.Button;
import actionscript3.ToogleButton;
import actionscript3.Screen;
import actionscript3.SimpleButton;
import actionscript3.SpriteAS3;
import actionscript3.Stage;
import vista.AssetManager;

public class ScreenGame extends Screen{
	
	Button btn;
	SpriteAS3 obj;
	int max = 264;
	public ScreenGame(){
		super();		
//		btn = new ImageButton(AssetManager.btn1,AssetManager.btn1,AssetManager.btn1,AssetManager.btn2);
		
		
		obj = new SpriteAS3();
		obj.setImg(AssetManager.objectList.get(2).img);
		obj.x = 200;
		obj.y = 200;
		addChild(obj);
		
		btn = new SimpleButton(AssetManager.btn1,AssetManager.btn2) {			
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				max += 64;				
			}
		};
		addChild(btn);
		
		SpriteAS3 obj2 = new SpriteAS3();
		obj2.setImg(AssetManager.objectList.get(2).img);
		obj2.x = 264;
		obj2.y = 264;
		addChild(obj2);
		
//		btn.
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		
		if (obj.x <= max)
			obj.x += 64/24;
//		System.out.println(obj.x);
		
		Stage.stage.repaint();
	}
	
}
