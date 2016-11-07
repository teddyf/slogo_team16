package View.tabs;

import java.util.Observer;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

/**
 * This interface defines the behaviors all tabs should have in the TabPane. 
 * 
 * @author Jordan Frazier
 *
 * @param <T>
 */
public interface GenericPane<T> extends Observer {
	
	//public void changeBackgroundColor(String color);
	
	public String getTabName();
	
	public void makeClickable();	
	
	public ObservableList<T> getAllItems();
	
	public ListView<T> getTabContent();
}
