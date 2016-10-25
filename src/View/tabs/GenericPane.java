package View.tabs;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
/**
 * 
 * @author Jordan Frazier
 *
 * @param <T>
 */
public interface GenericPane<T> {
	
	//public void changeBackgroundColor(String color);
	
	public String getTabName();
	
	public void makeClickable();	
	
	public ObservableList<T> getAllItems();
	
	public ListView<T> getTabContent();
}
