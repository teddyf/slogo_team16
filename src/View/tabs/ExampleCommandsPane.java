package View.tabs;

import java.util.Observable;

import View.helper.Console;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;

/**
 * This pane holds example commands the user can click on and run
 * @author Jordan Frazier
 *
 */
public class ExampleCommandsPane implements ListViewPane, GenericPane<String> {

	private String displayName = "Examples";
	private ListView<String> content;
	private Console myConsole;

	public ExampleCommandsPane(Console console) {
		myConsole = console;
		initializeListView();
		makeClickable();
	}

	@Override
	public void initializeListView() {
		content = new ListView<>();
		content.setStyle("-fx-background:white");
		populateContent();
	}

	@Override
	public String getTabName() {
		return displayName;
	}

	@Override
	public void makeClickable() {
		content.setOnMouseClicked(e -> {
			if (e.getClickCount() == 2) {
				myConsole.getConsoleArea().setText(content.getSelectionModel().getSelectedItem());
			}
		});
	}

	public void populateContent() {
		addItem("repeat 5 [ fd 100 rt 144 ]");
		addItem("repeat 4 [ fd 100 rt 90 ]");
		addItem("repeat 72 [ fd 155 rt 95 ]");
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
