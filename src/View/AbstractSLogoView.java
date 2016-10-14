package View;

import javafx.scene.Scene;

public abstract class AbstractSLogoView {
	
	public static final int SCENE_WIDTH = 1200;
	public static final int SCENE_HEIGHT = 700;
	protected static final int LEFT_PANE_WIDTH = SCENE_WIDTH - SCENE_WIDTH / 3;
	protected static final int RIGHT_PANE_WIDTH = SCENE_WIDTH / 3 - 30;
	
	public abstract Scene init();
	
	

}
