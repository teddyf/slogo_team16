package View.tabs;

import java.util.Observable;

import View.helper.Buttons;
import View.helper.Console;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
/**
 * The pane which holds the command history input into the console
 * @author Jordan Frazier
 *
 */
public class CommandHistoryPane implements ListViewPane, GenericPane<String> {
	
	private String displayName = "History";
	private ListView<String> content;
	private Console myConsole;

	public CommandHistoryPane(Console console) {
		myConsole = console;
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
					myConsole.getConsoleArea().setText(content.getSelectionModel().getSelectedItem());
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
		if (o instanceof Buttons) {
			String command = ((Buttons) o).getCurrentCommand();
			content.getItems().add(command);
		}
		
	}
}
