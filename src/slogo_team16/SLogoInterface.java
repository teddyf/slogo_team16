package slogo_team16;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class SLogoInterface {
	private Scene myScene;
	
	public SLogoInterface(){
		
	}
	
	public Scene init(int width, int height){
		Group root = new Group();
		myScene = new Scene(root, width, height, Color.WHITE);
	
		return myScene;
	}

}
