package View.helpscreen;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

import View.helper.SceneManager;
import javafx.scene.Group;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
public class HelpScreen {
	//public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";

	//private final ResourceBundle myResources;
	public static final int HELP_WIDTH = 800;
	public static final int HELP_HEIGHT = 600;
    private ClassLoader classLoader;
    private WebEngine webEngine;
    private WebView web;
    private SceneManager newScene;
    
    /**
     * creates a new helpscreen instance
     */
    public HelpScreen() {
    	newScene = new SceneManager();
    	//myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE);
    }
    
    public void displayHelp(){
    	Group root= newScene.setupNewScene("Help page",HELP_WIDTH, HELP_HEIGHT); //TODO: replace with static variables
    	createWeb();
    	root.getChildren().add(web);
    	
    }

    private WebView createWeb() {
        classLoader = getClass().getClassLoader();
        web = new WebView(); 
        webEngine = web.getEngine();
        URL helpUrl=classLoader.getResource("resources/html/SLOGO_help.html"); //TODO: put all strings in some properties file later
        webEngine.load(helpUrl.toExternalForm()); 
        return web;


    }

}
