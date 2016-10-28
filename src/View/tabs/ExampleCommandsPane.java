package View.tabs;

import java.util.Observable;

import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
/**
 * 
 * @author Jordan Frazier
 *
 */
public class ExampleCommandsPane implements ListViewPane, GenericPane<String> {

	private String displayName = "Examples";
	private ListView<String> content;

	public ExampleCommandsPane() {
		initializeListView();
		makeClickable();
	}

	@Override
	public void initializeListView() {
		content = new ListView<>();
		content.setStyle("-fx-background:white");
	}
	
	@Override
	public String getTabName() {
		return displayName;
	}

	@Override
	public void makeClickable() {
		content.setOnMouseClicked(e -> {
			if (e.getButton().equals(MouseButton.PRIMARY)) {
				if (e.getClickCount() == 2) {
					//TODO: Jordan - Add run functionality to clicking
					System.out.println("clicked on " + content.getSelectionModel().getSelectedItem());
				}
			}
		});	
	}

	@Override
	public void addItem(String value) {
		content.getItems().add(value);
	}

	@Override
	public ObservableList<String> getAllItems() {
		return content.getItems();
	}

	@Override
	public ListView<String> getTabContent() {
		return this.content;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
	

}
