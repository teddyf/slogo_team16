package View.tabs;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;

public class CommandHistoryPane implements ListViewPane, GenericPane<String> {
	
	private String displayName = "History";
	private ListView<String> content;

	public CommandHistoryPane() {
		initializeListView();
		makeClickable();
	}

	@Override
	public void initializeListView() {
		content = new ListView<>();
		content.getItems().add("First History\nCommand");
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
					// Add command to text area instead of running actually
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
}
