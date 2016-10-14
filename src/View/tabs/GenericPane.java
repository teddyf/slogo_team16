package View.tabs;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public interface GenericPane<T> {
	
	public String getTabName();
	
	public void makeClickable();	
	
	public ObservableList<T> getAllItems();
	
	public ListView<T> getTabContent();
}
